/**
 * NegocioTraslado.java
 * 13 may. 2023 16:16:37
 */
package org.itson.implementacion;

import com.dominio.Administrador;
import com.dominio.EmpresaTransportista;
import com.dominio.Estado;
import com.dominio.Productor;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import com.dominio.Traslado;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.implementaciones.fachada.FachadaPersistencia;
import org.itson.interfaces.INegocioTraslado;
import org.itson.interfaces.IPersistencia;

/**
 * Descripción de la clase: Clase que actúa como puente para realizar las
 * operaciones en el sistema de persistencia, pero antes realizar operaciones
 * para comprobar que el traslado de datos sea correcto
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class NegocioTraslado implements INegocioTraslado {

    IPersistencia persistencia;

    /**
     * Constructor por default
     */
    public NegocioTraslado() {
        persistencia = new FachadaPersistencia();
    }

    /**
     * Inserta un traslado en el sistema
     *
     * @param traslado El traslado a insertar.
     * @return El traslado insertado.
     * @throws NegocioException Si ocurre un error durante la inserción.
     */
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

    /**
     * Obtiene una lista de traslados asignados a una empresa transportista.
     *
     * @param empresaTransportista La empresa transportista para la cual se
     * obtienen los traslados asignados.
     * @return Una lista de traslados asignados a la empresa transportista.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Traslado> consultaTrasladosAsingados(EmpresaTransportista empresaTransportista) throws NegocioException {
        try {
            if (empresaTransportista == null) {
                throw new ValidacionException("No hay información de la empresa transportista");
            }
            return persistencia.consultaTrasladosAsingados(empresaTransportista);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        } catch (ValidacionException a) {
            throw new NegocioException(a.getMessage());
        }
    }

    /**
     * Valida un traslado antes de insertarlo.
     *
     * @param traslado El traslado a validar.
     * @return El traslado validado.
     * @throws ValidacionException Si el traslado es nulo o no cumple con los
     * requisitos de validación.
     */
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

        //Valida la lista de empresas_transportistas
        List<EmpresaTransportista> empresasTransportistas = traslado.getEmpresas_transportistas();

        if (validarListaVacia(empresasTransportistas)) {
            camposError.add("No hay ninguna empresa transportista seleccionada");
        }

        //Validar solicitud
        Solicitud solicitud = traslado.getSolicitud();
        try {
            validarSolicitudInsertar(solicitud);
        } catch (ValidacionException e) {
            camposError.add("Error en la información de solicitud\n"
                    + e.getMessage());
        }

        if (camposError.isEmpty()) {
            return traslado;
        }

        String mensaje = mensajeCampos(camposError);

        throw new ValidacionException(mensaje);
    }

    /**
     * Valida una solicitud antes de insertarla
     *
     * @param solicitud La solicitud a validar.
     * @return La solicitud validada.
     * @throws ValidacionException Si la solicitud es nula o no cumple con los
     * requisitos de validación.
     */
    private Solicitud validarSolicitudInsertar(Solicitud solicitud) throws ValidacionException {

        List<String> camposError = new LinkedList<>();

        if (solicitud == null) {
            throw new ValidacionException("No hay información de la solicitud");
        }

        // Validar estado
        Estado estado = solicitud.getEstado();
        if (estado != null) {
            if (validarTextoVacio(estado.toString())) {
                camposError.add("- No hay estado");
            }
        }

        //Validar fecha solicitada
        Date fecha_solicitada = solicitud.getFecha_Solicitada();
        if (fecha_solicitada == null) {
            camposError.add("- No hay fecha en que solicitó");
        }

        //Validar productor
        Productor productor = solicitud.getProductor();
        if (productor == null) {
            camposError.add("- No hay información del productor");
        }

        if (camposError.isEmpty()) {
            return solicitud;
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
