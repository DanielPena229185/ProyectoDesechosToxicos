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
public class NegocioExcepcion extends RuntimeException{

    /**
     * Constructor por default
     */
    public NegocioExcepcion(){
        super();
    }

    /**
     * 
     * @param message 
     */
    public NegocioExcepcion(String message) {
        super(message);
    }

    /**
     * 
     * @param message
     * @param cause 
     */
    public NegocioExcepcion(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
