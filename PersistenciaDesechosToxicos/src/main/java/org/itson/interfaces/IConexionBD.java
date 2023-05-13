package org.itson.interfaces;

import com.mongodb.client.MongoDatabase;

/**
 * Descripción de la interfaz: Interfaz que especifica el tipo de conexión que tendrá el sistema que lo
 * va a utilizar.
 * @author oscar
 */
public interface IConexionBD {
    
    /**
     * Método que obtiene la base de datos que recibió especificado como
     * atributo.
     * @return la base de datos conectada.
     */
    public MongoDatabase getBaseDatos();
}
