/**
* PersistenciaException.java
* 28 abr. 2023 15:33:36
*/ 

package org.itson.excepciones;
//importanciones
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PersistenciaException extends RuntimeException{

    /**
     * 
     */
    public PersistenciaException() {
    }

    /**
     * 
     * @param message 
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * 
     * @param message
     * @param cause 
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

}
