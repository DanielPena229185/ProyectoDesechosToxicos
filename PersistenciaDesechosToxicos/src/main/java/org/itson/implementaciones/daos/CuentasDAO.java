/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Cuenta;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IConexionBD;
import org.itson.interfaces.IConsultasDAO;

/**
 * Clase que se encarga de realizar todas las operaciones CRUD de las
 * cuentas.
 * 
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class CuentasDAO implements IConsultasDAO<Cuenta>{
    
    private final IConexionBD MANEJADOR_CONEXIONES;
    private final MongoDatabase BASE_DATOS;
    private final MongoCollection<Cuenta> COLECCION; 
    
    /**
     * Método constructor que inicializa la clase para empezar con las
     * operaciones.
     * @param MANEJADOR_CONEXIONES La conexión a la base de datos con la que
     * va a trabajar.
     */
    public CuentasDAO(IConexionBD MANEJADOR_CONEXIONES) {
        this.MANEJADOR_CONEXIONES = MANEJADOR_CONEXIONES;
        this.BASE_DATOS = this.MANEJADOR_CONEXIONES.getBaseDatos();
        this.COLECCION = this.BASE_DATOS.getCollection("cuenta", Cuenta.class);
    }

    /**
     * Método que inserta una cuenta en la base de datos.
     * @param o Cuenta a insertar.
     * @return Cuenta insertada.
     * @throws PersistenciaException En dado caso de que no se pueda
     * insertar correctamente.
     */
    @Override
    public Cuenta insertar(Cuenta o) throws PersistenciaException {
        try {
            this.COLECCION.insertOne(o);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar la cuenta en la base de datos.", e.getCause());
        }
        
        return o;
    }

    /**
     * Método que actualiza una cuenta de la base de datos.
     * @param o Cuenta a actualizar.
     * @param s Cuenta con los datos actualizados.
     * @return Cuenta actualizado.
     * @throws PersistenciaException En dado caso de que no se pueda
     * actualizar la Cuenta en la base de datos.
     */
    @Override
    public Cuenta actualizar(Cuenta o, Cuenta s) throws PersistenciaException {
        try {
            Cuenta cuenta = this.consultar(o.getId());
            
            cuenta.setCorreo(s.getCorreo());
            cuenta.setContrasena(s.getContrasena());
            
            return cuenta;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("No se pudo actualizar la cuenta.\n" + e.getMessage());
        }
    }

    /**
     * Método que elimina a una Cuenta de la base de datos.
     * @param o Cuenta a eliminar.
     * @return Cuenta eliminado.
     * @throws PersistenciaException En dado caso de que no se pueda eliminar
     * la Cuenta de la base de datos.
     */
    @Override
    public Cuenta eliminar(Cuenta o) throws PersistenciaException {
        try {
            this.COLECCION.deleteOne(Filters.eq(this.consultar(o.getId())));
        } catch(PersistenciaException e) {
            throw new PersistenciaException("No se pudo eliminar la cuenta.\n" + e.getMessage());
        }
        
        return o;
    }

    /**
     * Método que consulta a todas las Cuentas de la base de datos.
     * @return Lista de todas las Cuentas.
     * @throws PersistenciaException Si no se encuentra a ninguna Cuenta.
     * en la base de datos.
     */
    @Override
    public List<Cuenta> consultar() throws PersistenciaException {
        List<Cuenta> cuentas = new ArrayList<>();
        this.COLECCION.find().into(cuentas);
        
        if (cuentas.size() <= 0) {
            throw new PersistenciaException("No hay cuentas registradas.");
        }
        
        return cuentas;
    }

    /**
     * Método que busca a una Cuenta por Id.
     * @param id id a buscar.
     * @return Cuenta encontrada.
     * @throws PersistenciaException Se genera una excepción si no existe
     * la Cuenta a buscar.
     */
    @Override
    public Cuenta consultar(ObjectId id) throws PersistenciaException {
        List<Cuenta> cuentas = new ArrayList<>();
        this.COLECCION.find(Filters.eq(id)).into(cuentas);
        
        if (cuentas.size() <= 0) {
            throw new PersistenciaException("No existe la cuenta a buscar.");
        }
        
        return cuentas.get(0);
    }

    /**
     * Método que consulta a todas las Cuentas que coincidan con los
     * parámetros dados.
     * @param parametros Cuenta con los parámetros especificados.
     * @return Lista de Cuentas que coincidan.
     * @throws PersistenciaException Si no se encuentra ninguna coincidencia
     * en la base de datos.
     */
    @Override
    public List<Cuenta> consultar(Cuenta parametros) throws PersistenciaException {
        List<Cuenta> cuentas = new ArrayList<>();
        List<Bson> filtros = new ArrayList<>();
        
        if (parametros.getCorreo() != null) {
            filtros.add(Filters.eq("correo", parametros.getCorreo()));
        }
        
        if (parametros.getContrasena() != null) {
            filtros.add(Filters.eq("contrasena", parametros.getContrasena()));
        }
        
        this.COLECCION.find(Filters.and(filtros)).into(cuentas);
        
        if (cuentas.size() <= 0) {
            throw new PersistenciaException("No se pudo encontrar la cuenta con las siguientes credenciales.");
        }
        
        return cuentas;
    }
}
