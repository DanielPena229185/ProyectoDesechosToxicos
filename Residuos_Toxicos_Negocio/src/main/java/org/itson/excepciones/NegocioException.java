/**
 * NegocioExcepcion.java
 * 7 may. 2023 18:39:27
 */
package org.itson.excepciones;

/**
 * Descripción de la clase: Clase que actúa como exception para la capa el
 * sistema de negocio
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class NegocioException extends RuntimeException {

    /**
     * Constructor por default
     */
    public NegocioException() {
        super();
    }

    /**
     * Crea una nueva instancia de NegocioException con el mensaje especificado
     *
     * @param message El mensaje de la excepción
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * Crea una nueva instancia de NegocioException con el mensaje y la causa
     * especificados
     *
     * @param message El mensaje de la excepción
     * @param cause El mensaje de la excepción
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

}
