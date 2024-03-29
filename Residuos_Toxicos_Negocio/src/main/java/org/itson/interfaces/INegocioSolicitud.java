/**
 * INegocioSolicitud.java
 * 12 may. 2023 19:07:57
 */
package org.itson.interfaces;

import com.dominio.Solicitud;
import java.util.List;
import org.itson.excepciones.NegocioException;

/**
 * Descripción de la clase: interfaz que contiene los métodos definidos para
 * realizar las operaciones en las clases que la implementen
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public interface INegocioSolicitud {

    /**
     * Inserta una nueva solicitud en el sistema.
     *
     * @param solicitud El objeto Solicitud que se desea insertar.
     * @return El objeto Solicitud insertado en el sistema.
     * @throws NegocioException Si ocurre un error en la lógica del negocio
     * durante la inserción.
     */
    public Solicitud insertarSolicitud(Solicitud solicitud) throws NegocioException;

    /**
     * Consulta la lista de solicitudes no atendidas en el sistema.
     *
     * @return Una lista de objetos Solicitud que representan las solicitudes no
     * atendidas.
     * @throws NegocioException Si ocurre un error en la lógica del negocio
     * durante la consulta.
     */
    public List<Solicitud> consultaSolicitudesNoAtendidas() throws NegocioException;

    /**
     * Consulta una lista de solicitudes filtradas según los criterios
     * especificados.
     *
     * @param solicitud El objeto Solicitud que contiene los criterios de
     * filtrado.
     * @return Una lista de objetos Solicitud que cumplen con los criterios de
     * filtrado.
     * @throws NegocioException Si ocurre un error en la lógica del negocio
     * durante la consulta.
     */
    public List<Solicitud> consultarSolicitudFiltro(Solicitud solicitud) throws NegocioException;

    /**
     *
     * @param solicitud
     * @return
     * @throws NegocioException
     */
    Solicitud actualizaEstadoASolicitudAtendida(Solicitud solicitud) throws NegocioException;

}
