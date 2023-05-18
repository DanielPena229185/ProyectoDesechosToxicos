package org.itson.implementacion;

import com.dominio.MedidaResiduo;
import com.dominio.Productor;
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
 * Descripcion de la clase: Esta clase se encarga de manejar las solicitudes
 * relacionadas con el traslado de residuos
 *
 * @author oscar
 */
public class NegocioSolicitud implements INegocioSolicitud {

    IPersistencia persistencia;

    /**
     * Constructor de la clase NegocioSolicitud. Inicializa la instancia de
     * FachadaPersistencia.
     */
    public NegocioSolicitud() {
        this.persistencia = new FachadaPersistencia();
    }

    /**
     * Valida si la fecha es válida para el traslado de residuos.
     *
     * @param fecha La fecha a validar.
     * @return true si la fecha no es posterior a la fecha actual, false de lo
     * contrario.
     */
    private Boolean validarFechaParaTrasladoDeResiduos(Date fecha) {
        if (!fecha.after(new Date())) {
            return true;
        }
        return false;
    }

    /**
     * Valida si la lista de residuos contiene al menos un residuo.
     *
     * @param residuos La lista de residuos a validar.
     * @return true si la lista de residuos es nula o está vacía, false de lo
     * contrario.
     */
    private Boolean validaQueTengaAlmenosUnResiduo(List<Residuo> residuos) {
        if (residuos == null || residuos.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Valida si la unidad de medida de un residuo es válida.
     *
     * @param residuo El residuo a validar.
     * @return true si la unidad de medida del residuo no coincide con ninguna
     * de las unidades válidas, false de lo contrario.
     */
    private Boolean validaLaUnidadDeMedida(Residuo residuo) {
        for (MedidaResiduo m : MedidaResiduo.values()) {
            if (!m.name().equals(residuo.getMedida_residuo())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Valida si no se han realizado más de cinco traslados en una fecha
     * determinada.
     *
     * @param fecha La fecha a verificar.
     * @return true si no se han registrado cinco traslados en la fecha dada,
     * lanza una ValidacionException de lo contrario.
     * @throws ValidacionException Si ya hay cinco traslados registrados en la
     * fecha dada.
     */
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

    private Residuo realizarParticionResiduo(Residuo residuo) {
        residuo.setProductor(null);
        residuo.setQuimicos(null);
        return residuo;
    }

    private Solicitud realizarParticionSolicitud(Solicitud solicitud) {
        //Particionar productor
        Productor productorParticionado = solicitud.getProductor();
        productorParticionado.setCuenta(null);
        productorParticionado.setDirecciones(null);
        productorParticionado.setResiduos(null);
        productorParticionado.setTipo(null);
        productorParticionado.setSolicitudes(null);

        //Particionar lista de residuos
        List<Residuo> residuos = solicitud.getResiduos();

        for (Residuo residuo : residuos) {
            realizarParticionResiduo(residuo);
        }

        solicitud.setProductor(productorParticionado);
        solicitud.setResiduos(residuos);

        return solicitud;
    }
    
    /**
     * Convierte una instancia de Solicitud a SolicitudDTO.
     *
     * @param solicitud La solicitud a convertir.
     * @return El objeto SolicitudDTO resultante de la conversión.
     * @throws ValidacionException Si la solicitud es nula.
     */
    private SolicitudDTO convertirSolicitudToDTO(Solicitud solicitud) throws ValidacionException {

        if (solicitud == null) {
            throw new ValidacionException("No hay datos en la solicitud");
        }
        
        realizarParticionSolicitud(solicitud);

        SolicitudDTO solicitudDTO = new SolicitudDTO();
        //Establece el nombre del productor
        solicitudDTO.setNombreProductor(solicitud.getProductor().getNombre());
        //Establece la fecha en la que se solicitó
//        solicitudDTO.setFechaSolicitada(solicitud.getFecha_Solicitada());
        //Establece la lista de residuos
        solicitudDTO.setResiduos(solicitud.getResiduos());

        return solicitudDTO;
    }

    /**
     * Inserta una solicitud en el sistema.
     *
     * @param solicitud La solicitud a insertar.
     * @return La solicitud insertada.
     * @throws NegocioException Si ocurre un error durante la inserción.
     */
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

    /**
     * Consulta todas las solicitudes no atendidas.
     *
     * @return Una lista de solicitudes no atendidas.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Solicitud> consultaSolicitudesNoAtendidas() throws NegocioException {
        try {
            return persistencia.consultaSolicitudesNoAtendidas();
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Consulta las solicitudes que coinciden con los filtros especificados
     *
     * @param residuo Los filtros de la solicitud.
     * @return Una lista de solicitudes que coinciden con los filtros.
     * @throws NegocioException Si ocurre un error durante la consulta o los
     * filtros de la solicitud son nulos.
     */
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

    /**
     * Valida una solicitud antes de insertarla.
     *
     * @param solicitud La solicitud a validar.
     * @return La solicitud validada.
     * @throws ValidacionException Si la solicitud es nula o no cumple con los
     * requisitos de validación.
     */
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
            if (!validaLaUnidadDeMedida(residuo)) {
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
            List<Solicitud> solicitudesFiltradas =listaFecha(solicitudes, solicitud.getFecha_Solicitada());
            if (solicitudesFiltradas.size() > 5) {
                throw new ValidacionException("- Ya hay más de 5 solicitudes que cuentan con los mismos datos");
            }
        } catch (PersistenciaException e) {
            throw new ValidacionException(e.getMessage());
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

    @Override
    public Solicitud actualizaEstadoASolicitudAtendida(Solicitud solicitud) throws NegocioException {
        try {
            
            if(solicitud == null){
                throw new ValidacionException("No hay información de la solicitud a actualizar");
            }
            
            return persistencia.actualizaEstadoASolicitudAtendida(solicitud);
            
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
    private List<Solicitud> listaFecha(List<Solicitud> lista, Date date){
        
        List<Solicitud> listaSolicitud = new LinkedList<>();
        
        for (Solicitud solicitud : lista) {
            if(solicitud.getFecha_Solicitada().equals(date)){
                listaSolicitud.add(solicitud);
            }
        }
        
        return listaSolicitud;
    }
}
