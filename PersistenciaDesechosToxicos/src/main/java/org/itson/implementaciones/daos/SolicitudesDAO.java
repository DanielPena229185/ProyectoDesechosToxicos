/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Estado;
import com.dominio.Solicitud;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.interfaces.ISolicitudesDAO;

/**
 *
 * @author oscar
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

}
