package org.itson.interfaces;

import com.mongodb.client.MongoDatabase;

/**
 * Descripción de la interfaz: Interfaz que especifica el tipo de conexión que tendrá el sistema que lo
 * va a utilizar.
 * 
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public interface IConexionBD {
    
    /**
     * Método que obtiene la base de datos que recibió especificado como
     * atributo.
     * @return la base de datos conectada.
     */
    public MongoDatabase getBaseDatos();
}
