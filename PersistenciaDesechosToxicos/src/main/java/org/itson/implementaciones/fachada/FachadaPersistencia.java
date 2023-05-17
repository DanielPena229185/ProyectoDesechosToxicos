/**
 * FachadaPersistencia.java
 * 12 may. 2023 15:19:26
 */
package org.itson.implementaciones.fachada;

import com.dominio.Administrador;
import com.dominio.EmpresaTransportista;
import com.dominio.Productor;
import com.dominio.Quimico;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import com.dominio.Transporte;
import com.dominio.Traslado;
import com.dominio.Vehiculo;
import java.util.List;
import org.itson.DTO.ResiduoDTO;
import org.itson.DTO.SolicitudDTO;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.bd.DAOFactory;
import org.itson.interfaces.IAdministradoresDAO;
import org.itson.interfaces.IEmpresasTrasnportistasDAO;
import org.itson.interfaces.IPersistencia;
import org.itson.interfaces.IProductoresDAO;
import org.itson.interfaces.IQuimicosDAO;
import org.itson.interfaces.IResiduosDAO;
import org.itson.interfaces.ISolicitudesDAO;
import org.itson.interfaces.ITransporteDAO;
import org.itson.interfaces.ITrasladosDAO;
import org.itson.interfaces.IVehiculosDAO;

/**
 * Descripción de la clase: Esta clase implementa la IPersistencia y se encarga
 * de manejar la persistencia de los datos que son relacionados con los
 * quimicos, residuos, productores, solicitudes, empresas transportistas y los
 * traslados. Proporciona los metodos de insertar y consultar objetos de cada
 * uno de los tipos que maneja, los metodos que realizan la insercion y consulta
 * de cada tipo de objetos de DAO necesarios para realizar las operaciones de
 * persistencia que se necesiten y en si en caso que ocurra una excepcion el
 * sistema lanzara una excepcion del tipo PersistenciaExcepcion indicando dicho
 * error
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
    IVehiculosDAO vehiculosDAO;
    IAdministradoresDAO administradorDAO;
    ITransporteDAO transporteDAO;

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
        vehiculosDAO = DAOFactory.getVehiculosDAO();
        administradorDAO = DAOFactory.getAdministradoresDAO();
        transporteDAO = DAOFactory.getTransporteDAO();

    }

    /**
     * Inserta un objeto quimico en algun tipo de almacenamiento utilizando un
     * objeto QuimicoDAO
     *
     * @param o el objeto quimico a insertar
     * @return el objeto quimico insertado, incluyendo cualquier identificador
     * generado por el sistema de persistencia
     * @throws PersistenciaException si ocurre un error durante la ejecucion
     */
    @Override
    public Quimico insertarQuimico(Quimico o) throws PersistenciaException {
        try {
            return quimicoDAO.insertar(o);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    /**
     * Recupera todos los objetos quimico almacenados en algun tipo de
     * almacenamiento utilizando un objeto QuimicoDAO
     *
     * @return una lista de objeto de los quimicos
     * @throws PersistenciaException si ocurre un error durante la ejecucion
     */

    @Override
    public List<Quimico> consultarTodosLosQuimicos() throws PersistenciaException {
        try {
            return quimicoDAO.consultarTodosLosQuimicos();
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    /**
     * Inserta un objeto residuo en algún tipo de almacenamiento utilizando un
     * objeto ResiduoDAO
     *
     * @param o el objeto residuo a insertar
     * @return el objeto residuo insertado, incluyendo cualquier identificador
     * generado por el sistema de persistencia
     * @throws PersistenciaException si ocurre un error durante la ejecucion
     */
    @Override
    public Residuo insertarResiduo(Residuo o) throws PersistenciaException {
        try {
            return residuoDAO.insertar(o);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    /**
     * Recupera una lista de objetos residuo que cumplen con ciertos criterios
     * utilizando un objeto ResiduoDAO
     *
     * @param residuo residuo un objeto ResiduoDTO que especifica los criterios
     * de búsqueda
     * @return una lista de objetos residuo que cumplen con los criterios
     * especificados
     * @throws PersistenciaException si ocurre un error durante la ejecucion
     */
    @Override
    public List<Residuo> consultarResiduoFiltro(ResiduoDTO residuo) throws PersistenciaException {
        try {
            return residuoDAO.consultar(residuo);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    /**
     * Inserta un objeto Productor en algun tipo de almacenamiento utilizando un
     * objeto ProductorDAO
     *
     * @param o el objeto productor a insertar
     * @return el objeto productor que esta insertado incluyendo cualquier
     * identificador generado por el sistema de persistencia
     * @throws PersistenciaException si ocurre un error durante la ejecucion
     */
    @Override
    public Productor insertarProductor(Productor o) throws PersistenciaException {
        try {
            return productoresDAO.insertar(o);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    /**
     * Consulta el objeto productor con el correo y contrasena especificados
     * utilizando un objeto ProductorDAO
     *
     * @param correo el correo del productor que se va a consultar
     * @param contrasena la contrasena del productor a consultar
     * @return el objeto productor con el correo y contrasena especificados
     * @throws PersistenciaException si ocurre un errore durante la ejecucion
     */
    @Override
    public Productor consultarLoginProductor(String correo, String contrasena) throws PersistenciaException {
        try {
            return productoresDAO.consultarLogin(correo, contrasena);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    /**
     * Inserta una nueva Solicitud utilizando un objeto SolicitudDAO
     *
     * @param solicitud que se va a insertar
     * @return la solicitud que se inserto
     * @throws PersistenciaException si ocurre un error durante la ejecucion
     */
    @Override
    public Solicitud insertarSolicitud(Solicitud solicitud) throws PersistenciaException {
        try {
            return solicitudesDAO.insertarSolicitud(solicitud);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    /**
     * Consulta todas las solicitudes que no han sido atendidas usando un objeto
     * SolicitudDAO
     *
     * @return una lista de solicitud que no han sido atendidas
     * @throws PersistenciaException si ocurre un error durante la ejecucion
     */
    @Override
    public List<Solicitud> consultaSolicitudesNoAtendidas() throws PersistenciaException {
        try {
            return solicitudesDAO.consultaSolicitudesNoAtendidas();
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    /**
     * Consulta las solicitudes que cumplen con los criterios especificados en
     * un objeto SolicitudDTO utilizando un objeto SolicitudDAO
     *
     * @param filtro el objeto SolicitudDTO que contiene los criterios de
     * busqueda
     * @return una lista de solicitud que cumplen con los criterios
     * especificados
     * @throws PersistenciaException si ocurre un error durante la ejecucion
     */
    @Override
    public List<Solicitud> consultarSolicitudFiltro(SolicitudDTO filtro) throws PersistenciaException {
        try {
            return solicitudesDAO.consultarSolicitudFiltro(filtro);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    /**
     * Inserta un objeto Traslado en la base de datos
     *
     * @param traslado el objeto traslado a insertar
     * @return el objeto traslado insertado en la base de datos
     * @throws PersistenciaException si ocurre un error durante la ejecucion
     */
    @Override
    public Traslado insertarTraslado(Traslado traslado) throws PersistenciaException {
        try {
            return trasladosDAO.insertarTraslado(traslado);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    /**
     * Consulta una lista de objetos traslado asignados a una
     * EmpresaTransportista especificada
     *
     * @param empresaTransportista la EmpresaTransportista para la cual se desea
     * consultar los Traslados asignados
     * @return la lista de objetos traslado asignados a la EmpresaTransportista
     * especificada
     * @throws PersistenciaException si ocurre un error durante la ejecucion
     */
    @Override
    public List<Traslado> consultaTrasladosAsingados(EmpresaTransportista empresaTransportista) throws PersistenciaException {
        try {
            return trasladosDAO.consultaTrasladosAsingados(empresaTransportista);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Vehiculo> consultarVehiculosEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws PersistenciaException {
        try {
            return vehiculosDAO.consultarVehiculosEmpresaTrasnportadora(empresaTransportista);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<EmpresaTransportista> consultaTodasEmpresasTransportistas() throws PersistenciaException {
        try {
            return empresasTransportistasDAO.consultaTodasEmpresasTransportistas();
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public EmpresaTransportista insertar(EmpresaTransportista o) throws PersistenciaException {
        try {
            return empresasTransportistasDAO.insertar(o);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public EmpresaTransportista loginEmpresaTrasnportista(String correo, String contrasena) throws PersistenciaException {
        try {
            return empresasTransportistasDAO.loginEmpresaTrasnportista(correo, contrasena);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Solicitud actualizaEstadoASolicitudAtendida(Solicitud solicitud) throws PersistenciaException {

        try {
            return solicitudesDAO.actualizaEstadoASolicitudAtendida(solicitud);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }

    }

    @Override
    public Administrador loginAdministrador(String correo, String contrasena) throws PersistenciaException {
        try {
            return administradorDAO.loginAdministrador(correo, contrasena);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Transporte insertarTrasnporte(Transporte transporte) throws PersistenciaException {
        try {
            return transporteDAO.insertarTrasnporte(transporte);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }
}
