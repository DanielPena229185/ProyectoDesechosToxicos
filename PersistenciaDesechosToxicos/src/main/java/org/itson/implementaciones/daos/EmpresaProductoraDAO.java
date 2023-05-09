/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Productor;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IConsultasDAO;

/**
 *
 * @author edemb
 */
public class EmpresaProductoraDAO implements IConsultasDAO<Productor> {

    private final MongoCollection<Productor> COLECCION;

    public EmpresaProductoraDAO(MongoDatabase BASE_DATOS) {
        this.COLECCION = BASE_DATOS.getCollection("empresas", Productor.class);
    }

    @Override
    public Productor insertar(Productor o) throws PersistenciaException {
        try {
            this.COLECCION.insertOne(o);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar la empresa productora a la base de datos.\n", e.getCause());
        }

        return o;
    }

    @Override
    public Productor actualizar(Productor o, Productor s) throws PersistenciaException {
        try {
            o.setNombre(s.getNombre());
            o.setResiduos(s.getResiduos());
            o.setSolicitudes(s.getSolicitudes());
            o.setDirecciones(s.getDirecciones());
            return o;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("No se pudo actualizar la empresa productora.\n" + e.getMessage());
        }
    }

    @Override
    public Productor eliminar(Productor o) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Productor> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Productor consultar(ObjectId id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Productor> consultar(Productor parametros) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
