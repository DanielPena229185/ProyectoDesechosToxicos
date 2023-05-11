/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Quimico;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IConsultasDAO;

/**
 *
 * @author edemb
 */
public class QuimicosDAO {

    private final MongoCollection<Quimico> COLECCION;

    public QuimicosDAO(MongoDatabase DATA_BASE) {
        this.COLECCION = DATA_BASE.getCollection("quimicos", Quimico.class);
    }

    public Quimico insertar(Quimico o) throws PersistenciaException {
        try {
            COLECCION.insertOne(o);
            return o;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo insertar el quimico: " + e.getMessage());
        }
    }

    public Quimico actualizar(Quimico o, Quimico s) throws PersistenciaException {
        try {
            COLECCION.updateOne(Filters.eq(o.getId()), new Document("$set", s));
            return s;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo actualizar el quimico: " + e.getMessage());
        }
    }

    public Quimico eliminar(Quimico o) throws PersistenciaException {
        try {
            COLECCION.deleteOne(new Document("id", o.getId()));
            return o;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo eliminar el quimico: " + e.getMessage());
        }
    }

    /**
     * Consulta todos los Quimicos
     * @return Una lista de Quimicos
     * @throws PersistenciaException En caso de que no se pudo consultar 
     */
    public List<Quimico> consultar() throws PersistenciaException {
        try {
            List<Quimico> quimicos = new ArrayList<>();
            COLECCION.find().into(quimicos);
            return quimicos;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudieron consultar los quimicos: " + e.getMessage());
        }
    }

    public Quimico consultar(ObjectId id) throws PersistenciaException {
        try {
            Quimico quimico = COLECCION.find(new Document("id", id)).first();
            return quimico;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo consultar el quimico: " + e.getMessage());
        }
    }

    public List<Quimico> consultar(Quimico parametros) throws PersistenciaException {
        Document filter = new Document();
        List<Quimico> quimicos = new ArrayList<>();
        try {
            if (parametros.getId() != null) {
                filter.append("id", parametros.getId());
            }
            if (parametros.getNombre() != null) {
                filter.append("nombre", parametros.getNombre());
            }
            COLECCION.find(filter).into(quimicos);
            return quimicos;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo consultar los quimicos: " + e.getMessage());
        }
    }

}
