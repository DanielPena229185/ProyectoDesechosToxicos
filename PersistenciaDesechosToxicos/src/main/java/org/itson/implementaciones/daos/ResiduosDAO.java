/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Quimico;
import com.dominio.Residuo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.DTO.ResiduoDTO;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.interfaces.IConsultasDAO;
import org.itson.interfaces.IResiduosDAO;

/**
 * Clase que implementa todas las operaciones de Residuo
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class ResiduosDAO implements IResiduosDAO{

    /**
     * Coleccion de los residuos
     */
    private static MongoCollection<Residuo> COLECCION;
    /**
     * Instancia de ResiduoDAO
     */
    private static ResiduosDAO residuosDAO;

    /**
     * Costructor que consulta la coleccion de los residuos
     *
     */
    private ResiduosDAO() {
        if (COLECCION == null) {
            COLECCION = ConexionBD.getBaseDatos().getCollection("residuos", Residuo.class);
        }
    }

    /**
     * Regresa una instancia de ResiduoDAO
     * @return instancia de ResiduoDAO
     */
    public static ResiduosDAO getInstanceResiduosDAO() {
        if (residuosDAO == null) {
            residuosDAO = new ResiduosDAO();
        }
        return residuosDAO;
    }

    /**
     * Ingresa un Residuo a la base de datos
     *
     * @param o Objeto Residuo a ingresar
     * @return El Residuo ingresado
     * @throws PersistenciaException en caso
     */
    public Residuo insertar(Residuo o) throws PersistenciaException {
        try {
            COLECCION.insertOne(o);
            return o;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo insertar el residuo: " + e.getMessage());
        }
    }

    /*
    public Residuo actualizar(Residuo o, Residuo s) throws PersistenciaException {
        try {
            COLECCION.updateOne(Filters.eq(o.getId()), new Document("$set", s));
            return s;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo actualizar el Residuo: " + e.getMessage());
        }
    }

    public Residuo eliminar(Residuo o) throws PersistenciaException {
        try {
            COLECCION.deleteOne(new Document("id", o.getId()));
            return o;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo eliminar el residuo: " + e.getMessage());
        }
    }

    public List<Residuo> consultar() throws PersistenciaException {
        try {
            List<Residuo> residuos = new ArrayList<>();
            COLECCION.find().into(residuos);
            return residuos;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudieron consultar los quimicos: " + e.getMessage());
        }
    }

    public Residuo consultar(ObjectId id) throws PersistenciaException {
        try {
            Residuo residuo = COLECCION.find(Filters.eq("id", id)).first();
            return residuo;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo consultar el Residuo: " + e.getMessage());
        }
    }
     */
    /**
     * Consulta si existen Reiduos con esos datos
     *
     * @param residuo Redisuo a buscar similitudes de informacion
     * @return Una lista de Residuos
     * @throws PersistenciaException en caso de que haya un error
     */
    public List<Residuo> consultar(ResiduoDTO residuo) throws PersistenciaException {
        try {
            List<Document> filter = new ArrayList<>();
            List<Residuo> residuos = new ArrayList<>();

            filter.add(new Document("nombre", residuo.getNombre()));
            filter.add(new Document("clave", residuo.getClave()));
            filter.add(new Document("quimicos", residuo.getQuimicos()));

            COLECCION.find(new Document("$or", filter)).into(residuos);
            return residuos;

        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo consultar los quimicos: " + e.getMessage());
        }
    }

}
