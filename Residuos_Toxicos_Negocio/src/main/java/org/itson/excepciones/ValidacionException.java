/**
* ValidacionExcepcion.java
* 8 may. 2023 11:04:38
*/ 

package org.itson.excepciones;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ValidacionException extends RuntimeException{

    /**
     *
     */
    public ValidacionException(){
        super();
    }

    /**
     * 
     * @param message 
     */
    public ValidacionException(String message) {
        super(message);
    }

    /**
     * 
     * @param message
     * @param cause 
     */
    public ValidacionException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
