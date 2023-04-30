/**
* NegocioException.java
* 28 abr. 2023 15:34:38
*/ 

package org.itson.excepciones;
//importanciones
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioException extends RuntimeException{

    /*
    
    */
    public NegocioException() {
    }

    /**
     * 
     * @param message 
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * 
     * @param message
     * @param cause 
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

}
