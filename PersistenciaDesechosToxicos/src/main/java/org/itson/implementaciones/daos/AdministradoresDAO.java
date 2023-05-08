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
import org.bson.conversions.Bson;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.dto.AdministradoresDTO;
import org.itson.interfaces.IConexionBD;
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
public class AdministradoresDAO implements IConsultasDAO<Administrador, AdministradoresDTO> {

    private final IConexionBD MANEJADOR_CONEXIONES;
    private final MongoDatabase BASE_DATOS;
    private final MongoCollection<Administrador> COLECCION; 
    
    /**
     * Método constructor que inicializa la clase para empezar con las
     * operaciones.
     * @param MANEJADOR_CONEXIONES La conexión a la base de datos con la que
     * va a trabajar.
     */
    public AdministradoresDAO(IConexionBD MANEJADOR_CONEXIONES) {
        this.MANEJADOR_CONEXIONES = MANEJADOR_CONEXIONES;
        this.BASE_DATOS = this.MANEJADOR_CONEXIONES.getBaseDatos();
        this.COLECCION = this.BASE_DATOS.getCollection("administradores", Administrador.class);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
     * Método que consulta a todos los Administradores que coincidan con los
     * parámetros dados.
     * @param parametros Objeto con los parámetros especificados.
     * @return Lista de Administradores que coincidan.
     * @throws PersistenciaException Si no se encuentra ninguna coincidencia
     * en la base de datos.
     */
    @Override
    public List<Administrador> consultar(AdministradoresDTO parametros) throws PersistenciaException {
        List<Administrador> administradores = new ArrayList<>();
        List<Bson> filtros = new ArrayList<>();
        
        if (parametros.getNombres() != null) {
            filtros.add(Filters.regex("nombres", ".*" + parametros.getNombres() + ".*", "i"));
        }
        
        if (parametros.getApellidoPaterno() != null) {
            filtros.add(Filters.regex("apellido_paterno", ".*" + parametros.getApellidoPaterno() + ".*", "i"));
        }
        
        if (parametros.getApellidoMaterno() != null) {
            filtros.add(Filters.regex("apellido_materno", ".*" + parametros.getApellidoMaterno() + ".*", "i"));
        }
        
        this.COLECCION.find(Filters.and(filtros)).into(administradores);
        
        if (administradores.size() <= 0) {
            throw new PersistenciaException("No se pudo encontrar a los administradores con los parámtros especificados.");
        }
        
        return administradores;
    }
}
