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
import java.util.LinkedList;
import java.util.List;
import org.itson.DTO.SolicitudDTO;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.implementaciones.fachada.FachadaPersistencia;
import org.itson.interfaces.INegocioSolicitud;
import org.itson.interfaces.IPersistencia;

/**
 *
 * @author oscar
 */
public class NegocioSolicitud implements INegocioSolicitud {

    IPersistencia persistencia;

    public NegocioSolicitud() {
        this.persistencia = new FachadaPersistencia();
    }

    private Boolean validarFechaParaTrasladoDeResiduos(Date fecha) {
        if (!fecha.after(new Date())) {
            return true;
        }

        return false;
    }

    private Boolean validaQueTengaAlmenosUnResiduo(List<Residuo> residuos) {
        if (residuos == null || residuos.isEmpty()) {
            return true;
        }

        return false;
    }

    private Boolean validaLaUnidadDeMedida(Residuo residuo) {
        for (MedidaResiduo m : MedidaResiduo.values()) {
            if (!m.name().equals(residuo.getMedida_residuo())) {
                return true;
            }
        }

        return false;
    }

    private Boolean validarNoMasDeCincoTrasladosPorDia(Date fecha) throws ValidacionException {
        SolicitudDTO filtros = new SolicitudDTO();
        filtros.setFechaSolicitada(fecha);
        List<Solicitud> solicitudes = new ArrayList<>();

        try {
            solicitudes = this.persistencia.consultarSolicitudFiltro(filtros);
        } catch (PersistenciaException e) {
            throw new ValidacionException("No se encontró ninguna solicitud.", e.getCause());
        }

        if (solicitudes.size() >= 5) {
            throw new ValidacionException("Ya hay cinco traslados registrados en esta fecha.");
        }

        return true;
    }

    private SolicitudDTO convertirSolicitudToDTO(Solicitud solicitud) throws ValidacionException {

        if (solicitud == null) {
            throw new ValidacionException("No hay datos en la solicitud");
        }

        SolicitudDTO solicitudDTO = new SolicitudDTO();
        //Establece el nombre del productor
        solicitudDTO.setNombreProductor(solicitud.getProductor().getNombre());
        //Establece la fecha en la que se solicitó
        solicitudDTO.setFechaSolicitada(solicitud.getFecha_Solicitada());
        //Establece el estado de la solicitud
        solicitudDTO.setEstado(solicitud.getEstado());
        //Establece la lista de residuos
        solicitudDTO.setResiduos(solicitud.getResiduos());

        return solicitudDTO;
    }

    @Override
    public Solicitud insertarSolicitud(Solicitud solicitud) throws NegocioException {
        try {
            validarSolicitudInsertar(solicitud);
            return persistencia.insertarSolicitud(solicitud);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        } catch (ValidacionException a) {
            throw new NegocioException(a.getMessage());
        }
    }

    @Override
    public List<Solicitud> consultaSolicitudesNoAtendidas() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Solicitud> consultarSolicitudFiltro(Solicitud residuo) throws NegocioException {
        try {
            
            if (residuo == null) {
                throw new ValidacionException("No hay datos de la solicitud");
            }
            
            SolicitudDTO solicitudDTO = convertirSolicitudToDTO(residuo);
            
            return persistencia.consultarSolicitudFiltro(solicitudDTO);
            
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        } catch (ValidacionException a) {
            throw new NegocioException(a.getMessage());
        }
    }

    private Solicitud validarSolicitudInsertar(Solicitud solicitud) throws ValidacionException {

        List<String> camposError = new LinkedList<>();

        if (solicitud == null) {
            //Residuo no inicializado
            throw new ValidacionException("No hay datos en la solicitud");
        }

        //Valida que la fecha sea mayor a la actual
        Date fecha_solicitada = solicitud.getFecha_Solicitada();

        if (fecha_solicitada == null) {
            camposError.add("- No hay ningúna fecha especificada");
        } else if (validarFechaParaTrasladoDeResiduos(fecha_solicitada)) {
            camposError.add("- La fecha no es mayor a la actual");
        }

        //Valida que tenga al menos dos químicos
        List<Residuo> residuos = solicitud.getResiduos();

        if (validaQueTengaAlmenosUnResiduo(residuos)) {
            camposError.add("- No tiene seleccionado ningún residuo");
        }

        //Valida que la lista de residuos tenga especificada la unidad de medida
        for (Residuo residuo : residuos) {
            if (validaLaUnidadDeMedida(residuo)) {
                camposError.add("- El residuo " + residuo.getNombre() + " no tiene unidad de medida\n");
            }
        }

        /*
        Valida que no exista ninguna solicitud expedida para el mismo día, 
        del mismo productor y de la misma coleccion de residuos
         */
        List<Solicitud> solicitudes;

        try {
            solicitudes = consultarSolicitudFiltro(solicitud);
        } catch (PersistenciaException e) {
            throw new ValidacionException(e.getMessage());
        }

        if (camposError.isEmpty()) {
            if (solicitudes.size() > 5) {
                throw new ValidacionException("- Ya hay más de 5 solicitudes que cuentan con los mismos datos");
            }
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
}
