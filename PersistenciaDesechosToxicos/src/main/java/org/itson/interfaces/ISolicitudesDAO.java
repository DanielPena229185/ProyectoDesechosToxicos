package org.itson.interfaces;

import com.dominio.Solicitud;
import java.util.List;
import org.itson.DTO.SolicitudDTO;
import org.itson.excepciones.PersistenciaException;

/**
 * Descriocion de la interfaz: Esta interfaz define metodos para interactuar con
 * la base de datos en relacion a las solicitudes
 *
 * @author oscar
 */
public interface ISolicitudesDAO {

    /**
     * Inserta una nueva solicitud en la base de datos
     *
     * @param solicitud el objeto Solicitud que se desea insertar en la base de
     * datos
     * @return el objeto Solicitud insertado en la base de datos
     * @throws PersistenciaException si ocurre un error al intentar insertar la
     * Solicitud en la base de datos
     */
    Solicitud insertarSolicitud(Solicitud solicitud) throws PersistenciaException;

    /**
     * Consulta las solicitudes que no han sido atendidas
     *
     * @return una lista de objetos Solicitud que no han sido atendidas
     * @throws PersistenciaException si ocurre un error al intentar consultar
     * las solicitudes en la base de datos
     */
    List<Solicitud> consultaSolicitudesNoAtendidas() throws PersistenciaException;

    /**
     * Consulta las solicitudes que coinciden con los criterios especificados en
     * el objeto SolicitudDTO
     *
     * @param filtro el objeto SolicitudDTO que contiene los criterios de
     * busqueda
     * @return una lista de objetos Solicitud que coinciden con los criterios de
     * busqueda especificados
     * @throws PersistenciaException si ocurre un error al intentar consultar
     * las solicitudes en la base de datos
     */
    List<Solicitud> consultarSolicitudFiltro(SolicitudDTO filtro) throws PersistenciaException;

    Solicitud actualizaEstadoASolicitudAtendida(Solicitud solicitud) throws PersistenciaException;
}
