/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Quimico;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IConsultasDAO;

/**
 * Clase que se encarga de realizar todas las operaciones CRUD de las
 * los químicos.
 * 
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class QuimicosDAO implements IConsultasDAO<Quimico> {

    private final MongoCollection<Quimico> COLECCION; 
    
    /**
     * Método constructor que inicializa la clase para empezar con las
     * operaciones.
     * @param BASE_DATOS Base de datos a la que se conecta.
     */
    public QuimicosDAO(MongoDatabase BASE_DATOS) {
        this.COLECCION = BASE_DATOS.getCollection("quimicos", Quimico.class);
    }
    
    /**
     * Método que inserta un Químico en la base de datos.
     * @param o Químico a insertar.
     * @return Químico insertada.
     * @throws PersistenciaException En dado caso de que no se pueda
     * insertar correctamente.
     */
    @Override
    public Quimico insertar(Quimico o) throws PersistenciaException {
        try {
            this.COLECCION.insertOne(o);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar el químico en la base de datos.\n", e.getCause());
        }
        
        return o;
    }

    /**
     * Método que actualiza un Químico de la base de datos.
     * @param o Químico a actualizar.
     * @param s Químico con los datos actualizados.
     * @return Químico actualizado.
     * @throws PersistenciaException En dado caso de que no se pueda
     * actualizar el Químico en la base de datos.
     */
    @Override
    public Quimico actualizar(Quimico o, Quimico s) throws PersistenciaException {
        try {            
            this.COLECCION.updateOne(Filters.eq(o.getId()), new Document("$set", s));
        } catch (PersistenciaException e) {
            throw new PersistenciaException("No se pudo actualizar el químico.\n" + e.getMessage());
        }
        
        return o;
    }

    /**
     * Método que elimina a un Químico de la base de datos.
     * @param o Químico a eliminar.
     * @return Químico eliminado.
     * @throws PersistenciaException En dado caso de que no se pueda eliminar
     * el Químico de la base de datos.
     */
    @Override
    public Quimico eliminar(Quimico o) throws PersistenciaException {
        try {
            this.COLECCION.deleteOne(Filters.eq(o.getId()));
        } catch(PersistenciaException e) {
            throw new PersistenciaException("No se pudo eliminar el químico." + e.getMessage());
        }
        
        return o;
    }

    /**
     * Método que consulta a todos los Químicos de la base de datos.
     * @return Lista de todos las Químicos.
     * @throws PersistenciaException Si no se encuentra a ningún químico
     * en la base de datos.
     */
    @Override
    public List<Quimico> consultar() throws PersistenciaException {
        List<Quimico> quimicos = new ArrayList<>();
        this.COLECCION.find().into(quimicos);
        
        if (quimicos.size() <= 0) {
            throw new PersistenciaException("No hay químicos registradas.");
        }
        
        return quimicos;
    }

    /**
     * Método que busca a un Químico por Id.
     * @param id id a buscar.
     * @return Químico encontrada.
     * @throws PersistenciaException Se genera una excepción si no existe
     * la Químico a buscar.
     */
    @Override
    public Quimico consultar(ObjectId id) throws PersistenciaException {
        List<Quimico> quimicos = new ArrayList<>();
        this.COLECCION.find(Filters.eq(id)).into(quimicos);
        
        if (quimicos.size() <= 0) {
            throw new PersistenciaException("No existe el químico a buscar.");
        }
        
        return quimicos.get(0);
    }

    /**
     * Método que consulta a todos los Químicos que coincidan con los
     * parámetros dados.
     * @param parametros Químicos con los parámetros especificados.
     * @return Lista de Químicos que coincidan.
     * @throws PersistenciaException Si no se encuentra ninguna coincidencia
     * en la base de datos.
     */
    @Override
    public List<Quimico> consultar(Quimico parametros) throws PersistenciaException {
        List<Quimico> quimicos = new ArrayList<>();
        List<Bson> filtros = new ArrayList<>();
        
        if (parametros.getNombre() != null) {
            filtros.add(Filters.regex("nombre", ".*" + parametros.getNombre() + ".*", "i"));
        }
        
        this.COLECCION.find(Filters.and(filtros)).into(quimicos);
        
        if (quimicos.size() <= 0) {
            throw new PersistenciaException("No se pudieron encontrar químicos con los parámetros dados.");
        }
        
        return quimicos;
    }
}
