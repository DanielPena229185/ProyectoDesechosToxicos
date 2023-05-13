/**
* INegocioSolicitud.java
* 12 may. 2023 19:07:57
*/ 

package org.itson.interfaces;

import com.dominio.Solicitud;
import java.util.List;
import org.itson.DTO.SolicitudDTO;
import org.itson.excepciones.NegocioException;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioSolicitud {

    Solicitud insertarSolicitud(Solicitud solicitud) throws NegocioException;
    List<Solicitud> consultaSolicitudesNoAtendidas() throws NegocioException;
    List<Solicitud> consultarSolicitudFiltro(Solicitud solicitud) throws NegocioException;
    
}
