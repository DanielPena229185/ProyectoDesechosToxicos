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
public class ValidacionExcepcion extends RuntimeException{

    /**
     *
     */
    public ValidacionExcepcion(){
        super();
    }

    /**
     * 
     * @param message 
     */
    public ValidacionExcepcion(String message) {
        super(message);
    }

    /**
     * 
     * @param message
     * @param cause 
     */
    public ValidacionExcepcion(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
