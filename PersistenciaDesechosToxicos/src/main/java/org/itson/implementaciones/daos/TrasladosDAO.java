/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Traslado;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.interfaces.ITrasladosDAO;

/**
 *
 * @author edemb
 */
public class TrasladosDAO implements ITrasladosDAO {

    /**
     * Instancia de TrasladoDAO
     */
    private static TrasladosDAO trasladosDAO;
    /**
     * Coleccion de los traslados
     */
    private static MongoCollection<Traslado> COLECCION;

    /**
     * Constructor
     */
    private TrasladosDAO() {
        COLECCION = ConexionBD.getBaseDatos().getCollection("traslados", Traslado.class);
    }

    /**
     * Regresa una instancia de TrasladosDAO
     *
     * @return una instancia de TrasladoDAO
     */
    public static TrasladosDAO getInstanceTrasladosDAO() {
        if (trasladosDAO == null) {
            trasladosDAO = new TrasladosDAO();
        }
        return trasladosDAO;
    }

    /**
     * Ingresa un Traslado
     *
     * @param traslado Traslado a insertar
     * @return el Traslado insertado
     * @throws PersistenciaException en caso de algun error
     */
    @Override
    public Traslado insertar(Traslado traslado) throws PersistenciaException {
        if (traslado == null) {
            throw new PersistenciaException("El traslado era null");
        }
        try {
            COLECCION.insertOne(traslado);
            return traslado;
        } catch (MongoException e) {
            throw new PersistenciaException("Error no se pudo insertar el Traslado: " + e.getMessage());
        }
    }

}
