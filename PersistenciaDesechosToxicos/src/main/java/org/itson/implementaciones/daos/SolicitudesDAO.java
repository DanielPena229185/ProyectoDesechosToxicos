package org.itson.implementaciones.daos;

import com.dominio.Estado;
import com.dominio.Solicitud;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.itson.DTO.SolicitudDTO;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.interfaces.ISolicitudesDAO;

/**
 * Descripción de la clase: La clase proporciona metodos para consultar las
 * solicitudes no atendidas, consultar solicitudes por filtro y para insertar
 * una solicitud. Estos metodos manejan excepciones y proporcionan información
 * detallada sobre los errores, como el mensaje de error y la causa del error
 * 
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class SolicitudesDAO implements ISolicitudesDAO {

    /**
     * Objeto SolicitudesDAO
     */
    private static SolicitudesDAO solicitudesDAO;
    /**
     * Coleccion de solicitudes
     */
    private static MongoCollection<Solicitud> COLECCION;

    /**
     * Constructor
     */
    private SolicitudesDAO() {
        COLECCION = ConexionBD.getBaseDatos().getCollection("solicitudes", Solicitud.class);
    }

    /**
     * Regresa una instancia de SolicitudesDAO
     *
     * @return una instancia SolicitudesDAO
     */
    public static SolicitudesDAO getInstanceSolicitudesDAO() {
        if (solicitudesDAO == null) {
            solicitudesDAO = new SolicitudesDAO();
        }
        return solicitudesDAO;
    }

    /**
     * Consulta todas las Solicitudes no atendidas
     *
     * @return Lista con Solicitudes no atendidas
     * @throws PersistenciaException en caso de algun error
     */
    @Override
    public List<Solicitud> consultaSolicitudesNoAtendidas() throws PersistenciaException {
        try {
            List<Solicitud> solicitudes = new ArrayList<>();
            COLECCION.find(new Document("estado", Estado.NO_ATENDIDA.toString())).into(solicitudes);
            return solicitudes;
        } catch (MongoException e) {
            throw new PersistenciaException("Error no se pudieron consultar las Solicitudes" + e.getMessage());
        }
    }

    /**
     * Método que consulta a todas las solicitudes por filtros.
     *
     * @param filtro filtro que recibe.
     * @return lista de solicitudes que coinciden con los filtros.
     * @throws PersistenciaException si recibe un filtro como null, si no
     * encuentra ninguna coincidencia, por si hay un fallo con la base de datos.
     */
    @Override
    public List<Solicitud> consultarSolicitudFiltro(SolicitudDTO filtro) throws PersistenciaException {
        List<Solicitud> solicitudes = new ArrayList<>();
        List<Bson> filtros = new ArrayList<>();

        if (filtro == null) {
            throw new PersistenciaException("No se recibieron parámetros válidos.");
        }

        if (filtro.getFechaSolicitada() != null) {
            filtros.add(Filters.eq("fecha_solicitada", filtro.getFechaSolicitada()));
        }

        if (filtro.getNombreProductor() != null) {
            filtros.add(Filters.eq("productor.nombre", filtro.getNombreProductor()));
        }

        if (filtro.getEstado() != null) {
            filtros.add(Filters.eq("estado", filtro.getEstado()));
        }

        if (filtro.getResiduos() != null) {
            filtros.add(Filters.eq("residuos", filtro.getResiduos()));
        }

        try {
            COLECCION.find(Filters.and(filtros)).into(solicitudes);
        } catch (MongoException e) {
            throw new PersistenciaException("Hubo un error al realizar la consulta.", e.getCause());
        }

        return solicitudes;
    }

    /**
     * Inserta una Solicitud
     *
     * @param solicitud Solicitud a insertar
     * @return Solicitud insertada
     * @throws PersistenciaException en caso de algun error
     */
    @Override
    public Solicitud insertarSolicitud(Solicitud solicitud) throws PersistenciaException {
        if (solicitud == null) {
            throw new PersistenciaException("Error la solicitud es null");
        }
        try {
            COLECCION.insertOne(solicitud);
            return solicitud;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al insertar solicitud" + e.getMessage());
        }
    }

    /**
     * Actualiza estado de la solicitud a Atendida
     *
     * @param solicitud Solicitud no Atendida que se actualizara a Atendida
     * @return Solicitud con el estado actualizado a Atendida
     * @throws PersistenciaException
     */
    @Override
    public Solicitud actualizaEstadoASolicitudAtendida(Solicitud solicitud) throws PersistenciaException {

        try {
            COLECCION.updateOne(new Document("_id", solicitud.getId()).append("estado", "NO_ATENDIDA"), new Document("$set", new Document("estado", "ATENDIDA")));
            return solicitud;
        } catch (MongoException e) {
            throw new PersistenciaException("Error no se pudo actualizar el estado de la Solicitud");
        }

    }

}
