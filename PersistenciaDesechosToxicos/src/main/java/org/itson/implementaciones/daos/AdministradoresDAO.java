/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Administrador;
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
 * Clase que se encarga de realizar todas las operaciones CRUD de los
 * administradores.
 * 
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class AdministradoresDAO implements IConsultasDAO<Administrador> {

    private final MongoCollection<Administrador> COLECCION; 
    
    /**
     * Método constructor que inicializa la clase para empezar con las
     * operaciones.
     * @param BASE_DATOS Base de datos a la que se conecta.
     */
    public AdministradoresDAO(MongoDatabase BASE_DATOS) {
        this.COLECCION = BASE_DATOS.getCollection("administradores", Administrador.class);
    }
    
    /**
     * Método que inserta un administrador en la base de datos.
     * @param o Administrador a insertar.
     * @return Administrador insertado.
     * @throws PersistenciaException En dado caso de que no se pueda
     * insertar correctamente.
     */
    @Override
    public Administrador insertar(Administrador o) throws PersistenciaException {
        try {
            this.COLECCION.insertOne(o);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar el administrador a la base de datos.", e.getCause());
        }
        
        return o;
    }
    
    /**
     * Método que actualiza un administrador de la base de datos.
     * @param o Administrador a actualizar.
     * @param s Administrador con los datos actualizados.
     * @return Administrador actualizado.
     * @throws PersistenciaException En dado caso de que no se pueda
     * actualizar el Administrador en la base de datos.
     */
    @Override
    public Administrador actualizar(Administrador o, Administrador s) throws PersistenciaException {
        try {
            this.COLECCION.updateOne(Filters.eq(o.getId()), new Document("$set", s));
            
            return o;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("No se pudo actualizar el administrador.\n" + e.getMessage());
        }
    }

    /**
     * Método que elimina a un administrador de la base de datos.
     * @param o Administrador a eliminar.
     * @return Administrador eliminado.
     * @throws PersistenciaException En dado caso de que no se pueda eliminar
     * el Administrador de la base de datos.
     */
    @Override
    public Administrador eliminar(Administrador o) throws PersistenciaException {
        try {
            this.COLECCION.deleteOne(Filters.eq(o.getId()));
        } catch (PersistenciaException e) {
            throw new PersistenciaException("No se pudo eliminar el administrador.\n" + e.getMessage());
        }
        
        return o;
    }

    /**
     * Método que consulta a todos los Administradores de la base de datos.
     * @return Lista de todos los Administradores.
     * @throws PersistenciaException Si no se encuentra a ningún Administrador.
     * en la base de datos.
     */
    @Override
    public List<Administrador> consultar() throws PersistenciaException {
        List<Administrador> administradores = new ArrayList<>();
        this.COLECCION.find().into(administradores);
        
        if (administradores.size() <= 0) {
            throw new PersistenciaException("No hay administradores registrados");
        }
        
        return administradores;
    }

    /**
     * Método que busca a un administrador por Id.
     * @param id id a buscar.
     * @return Administrador encontrado.
     * @throws PersistenciaException Se genera una excepción si no existe
     * el Administrador a buscar.
     */
    @Override
    public Administrador consultar(ObjectId id) throws PersistenciaException {
        List<Administrador> administradores = new ArrayList<>();
        this.COLECCION.find(Filters.eq(id)).into(administradores);
        
        if (administradores.size() <= 0) {
            throw new PersistenciaException("No existe el administrador a buscar.");
        }
        
        return administradores.get(0);
    }
    
    /**
     * Método que consulta a todos los Administradores que coincidan con los
     * parámetros dados.
     * @param parametros Objeto con los parámetros especificados.
     * @return Lista de Administradores que coincidan.
     * @throws PersistenciaException Si no se encuentra ninguna coincidencia
     * en la base de datos.
     */
    @Override
    public List<Administrador> consultar(Administrador parametros) throws PersistenciaException {
        List<Administrador> administradores = new ArrayList<>();
        List<Bson> filtros = new ArrayList<>();
        
        if (parametros.getNombres() != null) {
            filtros.add(Filters.regex("nombres", ".*" + parametros.getNombres() + ".*", "i"));
        }
        
        if (parametros.getApellido_paterno() != null) {
            filtros.add(Filters.regex("apellido_paterno", ".*" + parametros.getApellido_paterno()+ ".*", "i"));
        }
        
        if (parametros.getApellido_materno() != null) {
            filtros.add(Filters.regex("apellido_materno", ".*" + parametros.getApellido_materno()+ ".*", "i"));
        }
        
        if (parametros.getCuenta() != null) {
            filtros.add(Filters.eq("cuenta", parametros.getCuenta()));
        }
        
        this.COLECCION.find(Filters.and(filtros)).into(administradores);
        
        if (administradores.size() <= 0) {
            throw new PersistenciaException("No se pudo encontrar a los administradores con los parámtros especificados.");
        }
        
        return administradores;
    }
}
