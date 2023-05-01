/**
* PresentacionException.java
* 30 abr. 2023 13:13:55
*/ 

package org.itson.excepciones;

/**
 * Descripción de la clase:
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID:
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PresentacionException extends RuntimeException{

    /**
     * 
     */
    public PresentacionException() {
    }

    /**
     * 
     * @param message 
     */
    public PresentacionException(String message) {
        super(message);
    }

    /**
     * 
     * @param message
     * @param cause 
     */
    public PresentacionException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
