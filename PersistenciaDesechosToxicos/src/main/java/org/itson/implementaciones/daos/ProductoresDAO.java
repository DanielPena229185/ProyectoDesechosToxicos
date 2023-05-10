/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Productor;
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
 * empresas productoras.
 * 
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class ProductoresDAO implements IConsultasDAO<Productor> {

    private final MongoCollection<Productor> COLECCION; 
    
    /**
     * Método constructor que inicializa la clase para empezar con las
     * operaciones.
     * @param BASE_DATOS Base de datos a la que se conecta.
     */
    public ProductoresDAO(MongoDatabase BASE_DATOS) {
        this.COLECCION = BASE_DATOS.getCollection("productores", Productor.class);
    }
    
    /**
     * Método que inserta una empresa productora en la base de datos.
     * @param o Empresa productora a insertar.
     * @return Empresa productora insertada.
     * @throws PersistenciaException En dado caso de que no se pueda
     * insertar correctamente.
     */
    @Override
    public Productor insertar(Productor o) throws PersistenciaException {
        try {
            this.COLECCION.insertOne(o);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar el productor en la base de datos.\n", e.getCause());
        }
        
        return o;
    }

    /**
     * Método que actualiza una Empresa productora de la base de datos.
     * @param o Empresa productora a actualizar.
     * @param s Empresa productora con los datos actualizados.
     * @return Empresa productora actualizado.
     * @throws PersistenciaException En dado caso de que no se pueda
     * actualizar la Empresa productora en la base de datos.
     */
    @Override
    public Productor actualizar(Productor o, Productor s) throws PersistenciaException {
        try {            
            this.COLECCION.updateOne(Filters.eq(o.getId()), new Document("$set", s));
        } catch (PersistenciaException e) {
            throw new PersistenciaException("No se pudo actualizar el productor.\n" + e.getMessage());
        }
        
        return o;
    }

    /**
     * Método que elimina a una Empresa productora de la base de datos.
     * @param o Empresa productora a eliminar.
     * @return Empresa productora eliminado.
     * @throws PersistenciaException En dado caso de que no se pueda eliminar
     * la Empresa productora de la base de datos.
     */
    @Override
    public Productor eliminar(Productor o) throws PersistenciaException {
        try {
            this.COLECCION.deleteOne(Filters.eq(o.getId()));
        } catch(PersistenciaException e) {
            throw new PersistenciaException("No se pudo eliminar el prodcutor." + e.getMessage());
        }
        
        return o;
    }

    /**
     * Método que consulta a todas las Empresas productoras de la base de datos.
     * @return Lista de todas las Empresas productoras.
     * @throws PersistenciaException Si no se encuentra a ninguna Empresa productora.
     * en la base de datos.
     */
    @Override
    public List<Productor> consultar() throws PersistenciaException {
        List<Productor> productores = new ArrayList<>();
        this.COLECCION.find().into(productores);
        
        if (productores.size() <= 0) {
            throw new PersistenciaException("No hay productores registradas.");
        }
        
        return productores;
    }

    /**
     * Método que busca a una Empresa productora por Id.
     * @param id id a buscar.
     * @return Empresa productora encontrada.
     * @throws PersistenciaException Se genera una excepción si no existe
     * la Empresa productora a buscar.
     */
    @Override
    public Productor consultar(ObjectId id) throws PersistenciaException {
        List<Productor> productores = new ArrayList<>();
        this.COLECCION.find(Filters.eq(id)).into(productores);
        
        if (productores.size() <= 0) {
            throw new PersistenciaException("No existe el productor a buscar.");
        }
        
        return productores.get(0);
    }

    /**
     * Método que consulta a todas las Empresas productora que coincidan con los
     * parámetros dados.
     * @param parametros Empresa productora con los parámetros especificados.
     * @return Lista de Empresas productora que coincidan.
     * @throws PersistenciaException Si no se encuentra ninguna coincidencia
     * en la base de datos.
     */
    @Override
    public List<Productor> consultar(Productor parametros) throws PersistenciaException {
        List<Productor> productores = new ArrayList<>();
        List<Bson> filtros = new ArrayList<>();
        
        if (parametros.getNombre() != null) {
            filtros.add(Filters.regex("nombre", ".*" + parametros.getNombre() + ".*", "i"));
        }
        
        if (parametros.getTipo() != null) {
            filtros.add(Filters.eq("tipo", parametros.getTipo()));
        }
        
        if (parametros.getDirecciones() != null) {
            filtros.add(Filters.eq("direcciones", parametros.getDirecciones()));
        }
        
        if (parametros.getResiduos() != null) {
            filtros.add(Filters.eq("residuos", parametros.getResiduos()));
        }
        
        if (parametros.getSolicitudes() != null) {
            filtros.add(Filters.eq("solicitudes", parametros.getSolicitudes()));
        }
        
        this.COLECCION.find(Filters.and(filtros)).into(productores);
        
        if (productores.size() <= 0) {
            throw new PersistenciaException("No se pudieron encontrar productores con los parámetros dados.");
        }
        
        return productores;
    }
}
