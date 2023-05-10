/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Residuo;
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
 * Clase que se encarga de realizar todas las operaciones CRUD de los residuos.
 * 
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class ResiduosDAO implements IConsultasDAO<Residuo> {

    private final MongoCollection<Residuo> COLECCION; 
    
    /**
     * Método constructor que inicializa la clase para empezar con las
     * operaciones.
     * @param BASE_DATOS Base de datos a la que se conecta.
     */
    public ResiduosDAO(MongoDatabase BASE_DATOS) {
        this.COLECCION = BASE_DATOS.getCollection("residuos", Residuo.class);
    }
    
    /**
     * Método que inserta un Residuo en la base de datos.
     * @param o Residuo a insertar.
     * @return Residuo insertada.
     * @throws PersistenciaException En dado caso de que no se pueda
     * insertar correctamente.
     */
    @Override
    public Residuo insertar(Residuo o) throws PersistenciaException {
        try {
            this.COLECCION.insertOne(o);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar el residuo en la base de datos.\n", e.getCause());
        }
        
        return o;
    }

    /**
     * Método que actualiza un Residuo de la base de datos.
     * @param o Residuo a actualizar.
     * @param s Residuo con los datos actualizados.
     * @return Residuo actualizado.
     * @throws PersistenciaException En dado caso de que no se pueda
     * actualizar el Residuo en la base de datos.
     */
    @Override
    public Residuo actualizar(Residuo o, Residuo s) throws PersistenciaException {
        try {            
            this.COLECCION.updateOne(Filters.eq(o.getId()), new Document("$set", s));
        } catch (PersistenciaException e) {
            throw new PersistenciaException("No se pudo actualizar el residuo.\n" + e.getMessage());
        }
        
        return o;
    }

    /**
     * Método que elimina a un Residuo de la base de datos.
     * @param o Residuo a eliminar.
     * @return Residuo eliminado.
     * @throws PersistenciaException En dado caso de que no se pueda eliminar
     * el Residuo de la base de datos.
     */
    @Override
    public Residuo eliminar(Residuo o) throws PersistenciaException {
        try {
            this.COLECCION.deleteOne(Filters.eq(o.getId()));
        } catch(PersistenciaException e) {
            throw new PersistenciaException("No se pudo eliminar el residuo." + e.getMessage());
        }
        
        return o;
    }

    /**
     * Método que consulta a todos los Residuos de la base de datos.
     * @return Lista de todos los Residuos.
     * @throws PersistenciaException Si no se encuentra a ningún Residuo
     * en la base de datos.
     */
    @Override
    public List<Residuo> consultar() throws PersistenciaException {
        List<Residuo> residuos = new ArrayList<>();
        this.COLECCION.find().into(residuos);
        
        if (residuos.size() <= 0) {
            throw new PersistenciaException("No hay residuos registrados.");
        }
        
        return residuos;
    }

    /**
     * Método que busca a un Residuo por Id.
     * @param id id a buscar.
     * @return Residuo encontrada.
     * @throws PersistenciaException Se genera una excepción si no existe
     * lo Residuo a buscar.
     */
    @Override
    public Residuo consultar(ObjectId id) throws PersistenciaException {
        List<Residuo> residuos = new ArrayList<>();
        this.COLECCION.find(Filters.eq(id)).into(residuos);
        
        if (residuos.size() <= 0) {
            throw new PersistenciaException("No existe el residuo a buscar.");
        }
        
        return residuos.get(0);
    }

    /**
     * Método que consulta a todos los Residuos que coincidan con los
     * parámetros dados.
     * @param parametros Residuos con los parámetros especificados.
     * @return Lista de Residuos que coincidan.
     * @throws PersistenciaException Si no se encuentra ninguna coincidencia
     * en la base de datos.
     */
    @Override
    public List<Residuo> consultar(Residuo parametros) throws PersistenciaException {
        List<Residuo> residuos = new ArrayList<>();
        List<Bson> filtros = new ArrayList<>();
        
        this.COLECCION.find(Filters.and(filtros)).into(residuos);
        
        if (parametros.getNombre() != null) {
            filtros.add(Filters.regex("nombre", ".*" + parametros.getNombre() + ".*", "i"));
        }
        
        if (parametros.getCantidad() != null) {
            filtros.add(Filters.eq("cantidad", parametros.getCantidad()));
        }
        
        if (parametros.getCodigo() != null) {
            filtros.add(Filters.eq("codigo", parametros.getCodigo()));
        }
        
        this.COLECCION.find(Filters.and(filtros)).into(residuos);
        
        if (residuos.size() <= 0) {
            throw new PersistenciaException("No se pudieron encontrar residuos con los parámetros dados.");
        }
        
        return residuos;
    }
}
