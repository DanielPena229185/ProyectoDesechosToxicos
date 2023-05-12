/**
 * FachadaPersistencia.java
 * 12 may. 2023 15:19:26
 */
package org.itson.implementaciones.fachada;

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
import org.itson.implementaciones.bd.DAOFactory;
import org.itson.interfaces.IEmpresasTrasnportistasDAO;
import org.itson.interfaces.IPersistencia;
import org.itson.interfaces.IProductoresDAO;
import org.itson.interfaces.IQuimicosDAO;
import org.itson.interfaces.IResiduosDAO;
import org.itson.interfaces.ISolicitudesDAO;
import org.itson.interfaces.ITrasladosDAO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class FachadaPersistencia implements IPersistencia {

    IQuimicosDAO quimicoDAO;
    IResiduosDAO residuoDAO;
    IProductoresDAO productoresDAO;
    ISolicitudesDAO solicitudesDAO;
    IEmpresasTrasnportistasDAO empresasTransportistasDAO;
    ITrasladosDAO trasladosDAO;

    /**
     * Constructor por default
     */
    public FachadaPersistencia() {

        quimicoDAO = DAOFactory.getQuimicosDAO();
        residuoDAO = DAOFactory.getResiduoDAO();
        productoresDAO = DAOFactory.getProductoresDAO();
        solicitudesDAO = DAOFactory.getSolicitudesDAO();
        empresasTransportistasDAO = DAOFactory.getEmpresasTrasnportistasDAO();
        trasladosDAO = DAOFactory.getTrasladosDAO();

    }

    @Override
    public Quimico insertarQuimico(Quimico o) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Quimico> consultarTodosLosQuimicos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Residuo insertarResiduo(Residuo o) throws PersistenciaException {
        try {
            return residuoDAO.insertar(o);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Residuo> consultarResiduoFiltro(ResiduoDTO residuo) throws PersistenciaException {
        try {
            return residuoDAO.consultar(residuo);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Productor insertarProductor(Productor o) throws PersistenciaException {
        try {
            return productoresDAO.insertar(o);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Productor consultarLoginProductor(String correo, String contrasena) throws PersistenciaException {
        try {
            return productoresDAO.consultarLogin(correo, contrasena);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Solicitud insertarSolicitud(Solicitud solicitud) throws PersistenciaException {
        try {
            return solicitudesDAO.insertarSolicitud(solicitud);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Solicitud> consultaSolicitudesNoAtendidas() throws PersistenciaException {
        try {
            return solicitudesDAO.consultaSolicitudesNoAtendidas();
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Solicitud> consultarSolicitudFiltro(SolicitudDTO filtro) throws PersistenciaException {
        try {
            return solicitudesDAO.consultarSolicitudFiltro(filtro);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Traslado insertarTraslado(Traslado traslado) throws PersistenciaException {
        try {
            return trasladosDAO.insertarTraslado(traslado);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Traslado> consultaTrasladosAsingados(EmpresaTransportista empresaTransportista) throws PersistenciaException {
        try {
            return trasladosDAO.consultaTrasladosAsingados(empresaTransportista);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }
}
