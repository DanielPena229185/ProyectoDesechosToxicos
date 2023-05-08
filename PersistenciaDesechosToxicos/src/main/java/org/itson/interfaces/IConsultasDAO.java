/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.excepciones.PersistenciaException;

/**
 * Interfaz que se encarga de realizar todas las operaciones CRUD de los
 * cualquier objeto de dominio que se indique.
 * 
 * @param <T> Clase de dominio a trabajar.
 * 
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public interface IConsultasDAO<T> {
    
    /**
     * Método que inserta un objeto en la base de datos.
     * @param o Objeto a insertar.
     * @return Objeto insertado.
     * @throws PersistenciaException En dado caso de que no se pueda
     * insertar correctamente.
     */
    T insertar(T o) throws PersistenciaException;
    
    /**
     * Método que actualiza un Objeto de la base de datos.
     * @param o Objeto a actualizar.
     * @param s Objeto con los datos actualizados.
     * @return Objeto actualizado.
     * @throws PersistenciaException En dado caso de que no se pueda
     * actualizar el Objeto en la base de datos.
     */
    T actualizar(T o, T s) throws PersistenciaException;
    
    /**
     * Método que elimina a un Objeto de la base de datos.
     * @param o Objeto a eliminar.
     * @return Objeto eliminado.
     * @throws PersistenciaException En dado caso de que no se pueda eliminar
     * el Objeto de la base de datos.
     */
    T eliminar(T o) throws PersistenciaException;
    
    /**
     * Método que consulta a todos los Objetos de la base de datos.
     * @return Lista de todos los Objetos.
     * @throws PersistenciaException Si no se encuentra a ningún Objeto
     * en la base de datos.
     */
    List<T> consultar() throws PersistenciaException;
    
    /**
     * Método que consulta a un Objeto por id.
     * @param id Id del objeto a buscar.
     * @return Objeto encontrado en la base de datos.
     * @throws PersistenciaException Si no encuentra al Objeto.
     */
    T consultar(ObjectId id) throws PersistenciaException;
    
    /**
     * Método que consulta a todos los Objetos que coincidan con los
     * parámetros dados.
     * @param parametros Objetos con los parámetros especificados.
     * @return Lista de Objetos que coincidan.
     * @throws PersistenciaException Si no se encuentra ninguna coincidencia
     * en la base de datos.
     */
    List<T> consultar(T parametros) throws PersistenciaException;
}
