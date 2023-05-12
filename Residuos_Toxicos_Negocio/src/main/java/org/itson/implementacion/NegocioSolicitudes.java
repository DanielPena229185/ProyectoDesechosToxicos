/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementacion;

import com.dominio.MedidaResiduo;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.itson.DTO.SolicitudDTO;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.interfaces.ISolicitudesDAO;
import org.itson.implementaciones.bd.DAOFactory;

/**
 *
 * @author oscar
 */
public class NegocioSolicitudes {
    
    ISolicitudesDAO solicitudesDAO;
    
    public NegocioSolicitudes() {
        this.solicitudesDAO = DAOFactory.getSolicitudesDAO();
    }

    private Boolean validarFechaParaTrasladoDeResiduos(Date fecha) throws ValidacionException {
        if (!fecha.after(new Date())) {
            throw new ValidacionException("La fecha seleccionada no debe ser anterior a la fecha actual.");
        }
        
        return true;
    }
    
    private Boolean validaQueTengaAlmenosUnResiduo(List<Residuo> residuos) throws ValidacionException {
        if (residuos.size() <= 0) {
            throw new ValidacionException("No hay residuos.");
        }
        
        return true;
    }
    
    private Boolean validaLaUnidadDeMedida(Residuo residuo) throws ValidacionException {
        for (MedidaResiduo m : MedidaResiduo.values()) {
            if (!m.name().equals(residuo.getMedida_residuo())) {
                throw new ValidacionException("Unidad de medida inválida.");
            }
        }
        
        return true;
    }
    
    private Boolean validarNoMasDeCincoTrasladosPorDia(Date fecha) throws ValidacionException {
        SolicitudDTO filtros = new SolicitudDTO();
        filtros.setFechaSolicitada(fecha);
        List<Solicitud> solicitudes = new ArrayList<>();
        
        try {
            solicitudes = this.solicitudesDAO.consultarSolicitudFiltro(filtros);
        } catch (PersistenciaException e) {
            throw new ValidacionException("No se encontró ninguna solicitud.", e.getCause());
        }
        
        if (solicitudes.size() >= 5) {
            throw new ValidacionException("Ya hay cinco traslados registrados en esta fecha.");
        }
        
        return true;
    }
}
