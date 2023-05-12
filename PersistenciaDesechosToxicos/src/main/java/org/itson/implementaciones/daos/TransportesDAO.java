/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Transporte;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.interfaces.ITransporteDAO;

/**
 *
 * @author edemb
 */
public class TransportesDAO implements ITransporteDAO {

    /**
     * Instancia TransportesDAO
     */
    private static TransportesDAO transporteDAO;
    /**
     * Coleccion de transportes
     */
    private static MongoCollection<Transporte> COLECCION;

    /**
     * Constructor
     */
    private TransportesDAO() {
        COLECCION = ConexionBD.getBaseDatos().getCollection("transportes", Transporte.class);
    }

    /**
     * Regresa una instancia de TranportesDAO
     *
     * @return una instancia de TranportesDAO
     */
    public static TransportesDAO getInstanceTransportesDAO() {
        if (transporteDAO == null) {
            transporteDAO = new TransportesDAO();
        }
        return transporteDAO;
    }

    /**
     * Inserta un trasnporte
     *
     * @param transporte Transporte a insertar
     * @return Transporte insertado
     * @throws PersistenciaException en caso de algun error
     */
    @Override
    public Transporte insertarTrasnporte(Transporte transporte) throws PersistenciaException {
        if (transporte == null) {
            throw new PersistenciaException("Error el trasnporte es null");
        }
        try {
            COLECCION.insertOne(transporte);
            return transporte;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al insertar Transporte: " + e.getMessage());
        }
    }

}
