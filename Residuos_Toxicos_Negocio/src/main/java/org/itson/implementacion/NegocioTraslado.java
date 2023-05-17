/**
 * NegocioTraslado.java
 * 13 may. 2023 16:16:37
 */
package org.itson.implementacion;

import com.dominio.Administrador;
import com.dominio.Direccion;
import com.dominio.EmpresaTransportista;
import com.dominio.Residuo;
import com.dominio.Traslado;
import java.util.LinkedList;
import java.util.List;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.implementaciones.fachada.FachadaPersistencia;
import org.itson.interfaces.INegocioTraslado;
import org.itson.interfaces.IPersistencia;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioTraslado implements INegocioTraslado {

    IPersistencia persistencia;

    /**
     * Constructor por default
     */
    public NegocioTraslado() {
        persistencia = new FachadaPersistencia();
    }

    @Override
    public Traslado insertarTraslado(Traslado traslado) throws NegocioException {
        try {
            validarTrasladoInsertar(traslado);
            return persistencia.insertarTraslado(traslado);
        } catch (ValidacionException e) {
            throw new NegocioException(e.getMessage());
        } catch (PersistenciaException a) {
            throw new NegocioException(a.getMessage());
        }
    }

    @Override
    public List<Traslado> consultaTrasladosAsingados(EmpresaTransportista empresaTransportista) throws NegocioException {
        try {
            if(empresaTransportista == null){
                throw new ValidacionException("No hay información de la empresa transportista");
            }
            return persistencia.consultaTrasladosAsingados(empresaTransportista);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        } catch (ValidacionException a) {
            throw new NegocioException(a.getMessage());
        }
    }

    private Traslado validarTrasladoInsertar(Traslado traslado) throws ValidacionException {

        List<String> camposError = new LinkedList<>();

        if (traslado == null) {
            throw new ValidacionException("No hay información del traslado");
        }

        //Valida que tenga residuo
        Residuo residuo = traslado.getResiduo();
        if (residuo == null) {
            camposError.add("- No contiene ningún residuo seleccionado");
        }

        //Valida que un administrador haya registrado el traslado
        Administrador administrador = traslado.getAdministrador();
        if (administrador == null) {
            camposError.add("- No se tiene información del administrador");
        }

        //Valida la dirección
        Direccion direccion = traslado.getDireccion();

        try {
            validarDireccion(direccion);
        } catch (ValidacionException e) {
            camposError.add("Datos inválidos de la dirección:\n"
                    + e.getMessage());
        }

        //Valida la lista de empresas_transportistas
        List<EmpresaTransportista> empresasTransportistas = traslado.getEmpresas_transportistas();

        if (validarListaVacia(empresasTransportistas)) {
            camposError.add("No hay ninguna empresa transportista seleccionada");
        }

        if (camposError.isEmpty()) {
            return traslado;
        }

        String mensaje = mensajeCampos(camposError);

        throw new ValidacionException(mensaje);
    }

    private Direccion validarDireccion(Direccion direccion) throws ValidacionException {

        List<String> camposError = new LinkedList<>();

        if (direccion == null) {
            throw new ValidacionException("No hay información de la dirección");
        }

        //Validar la calle de la dirección
        String calle = direccion.getCalle();
        if (validarTextoVacio(calle)) {
            camposError.add("- No hay una calle especificada");
        }

        //Validar la colonia
        String colonia = direccion.getColonia();
        if (validarTextoVacio(colonia)) {
            camposError.add("- No hay una colonia especificada");
        }

        //Validar el número
        String numero = direccion.getNumero();
        if (validarTextoVacio(numero)) {
            camposError.add("- No hay un número especificado");
        }

        //Validar ciudad
        String ciudad = direccion.getCiudad();
        if (validarTextoVacio(ciudad)) {
            camposError.add("- No hay una ciudad especificada");
        }

        if (camposError.isEmpty()) {
            return direccion;
        }

        String mensaje = mensajeCampos(camposError);

        throw new ValidacionException(mensaje);

    }

    /**
     * Contatena todos los elementos de la lista de tipo String
     *
     * @param listaCampos Lista que quiere concatenar sus elementos
     * @return Cadena concatenada de la lista de elementos
     */
    private String mensajeCampos(List<String> listaCampos) {
        String mensaje = "";
        for (String campo : listaCampos) {
            mensaje += campo + "\n";
        }
        return mensaje;
    }

    /**
     * Valida si el texto está vacío
     *
     * @param texto Texto que se quiere validar
     * @return True si no cumple, false en caso contrario
     */
    private boolean validarTextoVacio(String texto) {
        if (texto == null || texto.isBlank()) {
            return true;
        }

        return false;
    }

    /**
     * Válida que una lista esté vacia, si la lista está vacía, retorna true, en
     * caso contrarío, regresa false
     *
     * @param lista Lista que se quiere validar
     * @return True si la lista está vacía, false en caso contrario
     */
    private boolean validarListaVacia(List lista) {
        if (lista == null || lista.isEmpty()) {
            //Lista vacía o nula
            return true;
        }
        //Lista no está vacía
        return false;
    }

}
