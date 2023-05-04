/**
 * UtilsExcepcion.java
 * 30 abr. 2023 00:21:46
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
public class UtilsExcepcion extends RuntimeException{

    /**
     * 
     */
    public UtilsExcepcion() {
        super();
    }

    /**
     * 
     * @param message 
     */
    public UtilsExcepcion(String message) {
        super(message);
    }

    /**
     * 
     * @param message
     * @param cause 
     */
    public UtilsExcepcion(String message, Throwable cause) {
        super(message, cause);
    }
}
