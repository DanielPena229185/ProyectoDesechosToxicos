/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Productor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.excepciones.PersistenciaException;

/**
 * Clase que contiene todas las operaciones que se pueden hacer con los
 * productores
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class ProductorDAO {

    /**
     * Coleccion de Empresas
     */
    private final MongoCollection<Productor> COLECCION;

    /**
     * Constructor que consulta la coleccion de las empresas
     *
     * @param DATA_BASE Base de datos que se utilizara
     */
    public ProductorDAO(MongoDatabase DATA_BASE) {
        this.COLECCION = DATA_BASE.getCollection("empresas", Productor.class);
    }

    /**
     * Ingresa una Empresa Productora en la base de datos
     *
     * @param o Empresa Productora a ingresar
     * @return La Empresa Productora ingresada
     * @throws PersistenciaException En caso de que no se pudo registrar la
     * empresa
     */
    public Productor insertar(Productor o) throws PersistenciaException {
        if (o == null) {
            throw new PersistenciaException("Error el productor esta vacio: ");
        }
        try {
            COLECCION.insertOne(o);
            return o;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo insertar la empresa Productora: " + e.getMessage());
        }
    }

    /**
     *
     * @param o
     * @param s
     * @return
     * @throws PersistenciaException
     */
    public Productor actualizar(Productor o, Productor s) throws PersistenciaException {
        try {
            if (s.getNombre() != null) {
                o.setNombre(s.getNombre());
            }
            if (s.getDirecciones() != null) {
                o.setDirecciones(s.getDirecciones());
            }
            if (s.getSolicitudes() != null) {
                o.setSolicitudes(s.getSolicitudes());
            }
            if (s.getResiduos() != null) {
                o.setResiduos(s.getResiduos());
            }
            COLECCION.updateOne(Filters.eq("id", o.getId()), new Document("$set", o));
            return s;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo actualizar la empresa Productora");
        }
    }
/*
    public Productor eliminar(Productor o) throws PersistenciaException {
        try {
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo eliminar el Productor");
        }
    }

    public List<Productor> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Productor consultar(ObjectId id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Productor> consultar(Productor parametros) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
*/
}
