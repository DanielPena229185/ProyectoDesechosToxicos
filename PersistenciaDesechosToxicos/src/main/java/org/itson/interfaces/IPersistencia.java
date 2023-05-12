/**
 * IPersistencia.java
 * 12 may. 2023 15:16:33
 */
package org.itson.interfaces;

import com.dominio.EmpresaTransportista;
import com.dominio.Productor;
import com.dominio.Quimico;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import com.dominio.Traslado;
import java.util.List;
import org.itson.DTO.ResiduoDTO;
import org.itson.DTO.SolicitudDTO;
import org.itson.excepciones.PersistenciaException;

/**
 * Descripción de la interface:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IPersistencia {

    /**
     * Implementacion de insertarQuimico un Quimico
     *
     * @param o Quimico a insertarQuimico
     * @return El Quimico insertado
     * @throws PersistenciaException en caso de algun error
     */
    Quimico insertarQuimico(Quimico o) throws PersistenciaException;

    /**
     * Implementacion de consutar los Quimicos
     *
     * @return Una lista de Quimicos
     * @throws PersistenciaException en caso de algun error;
     */
    List<Quimico> consultarTodosLosQuimicos() throws PersistenciaException;

    /**
     * Implementacion de Insertar un Residuo
     *
     * @param o Residuo a insertarQuimico
     * @return El Residuo insertado
     * @throws PersistenciaException en caso de algun error
     */
    Residuo insertarResiduo(Residuo o) throws PersistenciaException;

    /**
     * Implementacion de consultarResiduoFiltro Residuos
     *
     * @param residuo Objeto ResiduoDTO con el que se consultara el/los
     * Residuo(s)
     * @return Una Lista de Residuos
     * @throws PersistenciaException en caso de algun error
     */
    List<Residuo> consultarResiduoFiltro(ResiduoDTO residuo) throws PersistenciaException;

    /**
     *
     * @param o
     * @return
     * @throws PersistenciaException
     */
    Productor insertarProductor(Productor o) throws PersistenciaException;

    /**
     *
     * @param correo
     * @param contrasena
     * @return
     * @throws PersistenciaException
     */
    Productor consultarLoginProductor(String correo, String contrasena) throws PersistenciaException;

    Solicitud insertarSolicitud(Solicitud solicitud) throws PersistenciaException;

    List<Solicitud> consultaSolicitudesNoAtendidas() throws PersistenciaException;

    List<Solicitud> consultarSolicitudFiltro(SolicitudDTO filtro) throws PersistenciaException;

    Traslado insertarTraslado(Traslado traslado) throws PersistenciaException;

    List<Traslado> consultaTrasladosAsingados(EmpresaTransportista empresaTransportista) throws PersistenciaException;

}
