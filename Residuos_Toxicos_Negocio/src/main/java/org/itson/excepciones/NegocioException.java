/**
* NegocioExcepcion.java
* 7 may. 2023 18:39:27
*/ 

package org.itson.excepciones;
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioException extends RuntimeException{

    /**
     * Constructor por default
     */
    public NegocioException(){
        super();
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
