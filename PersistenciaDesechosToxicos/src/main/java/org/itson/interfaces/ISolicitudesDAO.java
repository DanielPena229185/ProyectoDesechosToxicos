/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import com.dominio.Solicitud;
import java.util.List;
import org.itson.DTO.SolicitudDTO;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author oscar
 */
public interface ISolicitudesDAO {

    Solicitud insertarSolicitud(Solicitud solicitud) throws PersistenciaException;
    List<Solicitud> consultaSolicitudesNoAtendidas() throws PersistenciaException;
    List<Solicitud> consultarSolicitudFiltro(SolicitudDTO filtro) throws PersistenciaException;
}
