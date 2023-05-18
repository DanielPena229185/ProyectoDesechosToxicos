/**
 * NegocioTransporte.java
 * 12 may. 2023 22:32:52
 */
package org.itson.implementacion;

import com.dominio.EmpresaTransportista;
import com.dominio.Transporte;
import com.dominio.Vehiculo;
import java.util.LinkedList;
import java.util.List;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.implementaciones.fachada.FachadaPersistencia;
import org.itson.interfaces.INegocioTransporte;
import org.itson.interfaces.IPersistencia;

/**
 * Descripción de la clase:Se encarga de manejar los transportes en el sistema
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioTransporte implements INegocioTransporte {

    IPersistencia persistencia;

    /**
     * Constructor por default
     */
    public NegocioTransporte() {
        persistencia = new FachadaPersistencia();
    }
/**
 * Inserta un transporte en el sistema.
 *
 * @param transporte El transporte a insertar.
 * @return El transporte insertado.
 * @throws NegocioException Si ocurre un error durante la inserción.
 */
@Override
public Transporte insertarTransporte(Transporte transporte) throws NegocioException {
    try {
        validarTransporte(transporte);
        return persistencia.insertarTrasnporte(transporte);
    } catch (PersistenciaException e) {
        throw new NegocioException(e.getMessage());
    } catch (ValidacionException a) {
        throw new NegocioException(a.getMessage());
    }
}

/**
 * Valida un transporte antes de insertarlo.
 *
 * @param transporte El transporte a validar.
 * @return El transporte validado.
 * @throws ValidacionException Si el transporte es nulo o no cumple con los requisitos de validación.
 */
private Transporte validarTransporte(Transporte transporte) throws ValidacionException {
    List<String> camposError = new LinkedList<>();

    if (transporte == null) {
        throw new ValidacionException("- No hay información del transporte");
    }

    // Valida que al menos exista un vehículo seleccionado
    List<Vehiculo> vehiculos = transporte.getVehiculos();

    if (validarListaVacia(vehiculos)) {
        camposError.add("- No hay vehículos seleccionados");
    }

    // Valida los kilómetros
    Float kilometros = transporte.getKilometros();
    if (kilometros == null || kilometros == 0) {
        camposError.add("- No se especificaron los kilómetros");
    }

    // Valida el costo
    Float costo = transporte.getCoste();
    if (costo == null || costo == 0) {
        camposError.add("- No se especificó el costo");
    }

    // Valida la empresa transportista
    EmpresaTransportista empresaTransportista = transporte.getEmpresa_transportista();
    if (empresaTransportista == null) {
        camposError.add("- No hay información de la empresa transportista");
    } else {
        empresaTransportista = particionarEmpresaTransportista(empresaTransportista);
        transporte.setEmpresa_transportista(empresaTransportista);
    }

    if (camposError.isEmpty()) {
        return transporte;
    }

    String mensaje = mensajeCampos(camposError);

    throw new ValidacionException(mensaje);
}

/**
 * Realiza la partición de la empresa transportista, eliminando los vehículos y transportes asociados.
 *
 * @param empresaTransportista La empresa transportista a particionar.
 * @return La empresa transportista particionada.
 * @throws ValidacionException Si la empresa transportista es nula.
 */
private EmpresaTransportista particionarEmpresaTransportista(EmpresaTransportista empresaTransportista) throws ValidacionException {
    if (empresaTransportista == null) {
        throw new ValidacionException("- No hay información de la empresa transportista");
    }

    // Limpiar la lista de vehículos
    empresaTransportista.setVehiculos(new LinkedList<>());

    // Limpiar la lista de transportes
    empresaTransportista.setTransportes(new LinkedList<>());

    return empresaTransportista;
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

}
