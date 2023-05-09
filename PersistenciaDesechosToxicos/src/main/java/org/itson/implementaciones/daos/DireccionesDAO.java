/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Direccion;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IConsultasDAO;

/**
 * Clase que se encarga de realizar todas las operaciones CRUD de las
 * direcciones.
 * 
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class DireccionesDAO implements IConsultasDAO<Direccion> {

    private final MongoCollection<Direccion> COLECCION; 
    
    /**
     * Método constructor que inicializa la clase para empezar con las
     * operaciones.
     * @param BASE_DATOS Base de datos a la que se conecta.
     */
    public DireccionesDAO(MongoDatabase BASE_DATOS) {
        this.COLECCION = BASE_DATOS.getCollection("direcciones", Direccion.class);
    }
    
    /**
     * Método que inserta una Dirección en la base de datos.
     * @param o Dirección a insertar.
     * @return Dirección insertada.
     * @throws PersistenciaException En dado caso de que no se pueda
     * insertar correctamente.
     */
    @Override
    public Direccion insertar(Direccion o) throws PersistenciaException {
        try {
            this.COLECCION.insertOne(o);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar la dirección en la base de datos.\n" + e.getMessage());
        }
        
        return o;
    }

    /**
     * Método que actualiza una Dirección de la base de datos.
     * @param o Dirección a actualizar.
     * @param s Dirección con los datos actualizados.
     * @return Dirección actualizado.
     * @throws PersistenciaException En dado caso de que no se pueda
     * actualizar la Dirección en la base de datos.
     */
    @Override
    public Direccion actualizar(Direccion o, Direccion s) throws PersistenciaException {
        try {
            Direccion direccion = this.consultar(o.getId());
            
            direccion.setCalle(s.getCalle());
            direccion.setColonia(s.getColonia());
            direccion.setNumero(s.getNumero());
            direccion.setCiudad(s.getCiudad());
            
            return direccion;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("No se pudo actualizar la dirección.\n" + e.getMessage());
        }
    }

    /**
     * Método que elimina a una Dirección de la base de datos.
     * @param o Dirección a eliminar.
     * @return Dirección eliminado.
     * @throws PersistenciaException En dado caso de que no se pueda eliminar
     * la Dirección de la base de datos.
     */
    @Override
    public Direccion eliminar(Direccion o) throws PersistenciaException {
        try {
            this.COLECCION.deleteOne(Filters.eq(this.consultar(o.getId())));
        } catch (PersistenciaException e) {
            throw new PersistenciaException("No se pudo eliminar la dirección.\n" + e.getMessage());
        }
        
        return o;
    }

    /**
     * Método que consulta a todas las Direcciones de la base de datos.
     * @return Lista de todas las Direcciones.
     * @throws PersistenciaException Si no se encuentra a ninguna Dirección.
     * en la base de datos.
     */
    @Override
    public List<Direccion> consultar() throws PersistenciaException {
        List<Direccion> direcciones = new ArrayList<>();
        this.COLECCION.find().into(direcciones);
        
        if (direcciones.size() <= 0) {
            throw new PersistenciaException("No hay direcciones registradas.");
        }
        
        return direcciones;
    }

    /**
     * Método que busca a una Dirección por Id.
     * @param id id a buscar.
     * @return Dirección encontrada.
     * @throws PersistenciaException Se genera una excepción si no existe
     * la Dirección a buscar.
     */
    @Override
    public Direccion consultar(ObjectId id) throws PersistenciaException {
        List<Direccion> direcciones = new ArrayList<>();
        this.COLECCION.find(Filters.eq(id)).into(direcciones);
        
        if (direcciones.size() <= 0) {
            throw new PersistenciaException("No existe la dirección a consultar.");
        }
        
        return direcciones.get(0);
    }

    /**
     * Método que consulta a todas las Direcciones que coincidan con los
     * parámetros dados.
     * @param parametros Dirección con los parámetros especificados.
     * @return Lista de Direcciones que coincidan.
     * @throws PersistenciaException Si no se encuentra ninguna coincidencia
     * en la base de datos.
     */
    @Override
    public List<Direccion> consultar(Direccion parametros) throws PersistenciaException {
        List<Direccion> direcciones = new ArrayList<>();
        List<Bson> filtros = new ArrayList<>();
        
        if (parametros.getCalle() != null) {
            filtros.add(Filters.regex("calle", ".*" + parametros.getCalle() + ".*", "i"));
        }
        
        if (parametros.getColonia() != null) {
            filtros.add(Filters.regex("colonia", ".*" + parametros.getColonia() + ".*", "i"));
        }
        
        if (parametros.getNumero() != null) {
            filtros.add(Filters.regex("numero", ".*" + parametros.getNumero() + ".*", "i"));
        }
        
        if (parametros.getCiudad() != null) {
            filtros.add(Filters.regex("ciudad", ".*" + parametros.getCiudad() + ".*", "i"));
        }
        
        this.COLECCION.find(Filters.and(filtros)).into(direcciones);
        
        if (direcciones.size() <= 0) {
            throw new PersistenciaException("No se encontraron direcciones con los parámetros dados.");
        }
        
        return direcciones;
    }
}
