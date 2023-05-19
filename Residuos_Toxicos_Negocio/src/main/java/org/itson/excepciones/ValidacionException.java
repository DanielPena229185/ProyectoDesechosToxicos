/**
 * ValidacionExcepcion.java
 * 8 may. 2023 11:04:38
 */
package org.itson.excepciones;

/**
 * Descripción de la clase: Clase que actúa como exception para los métodos que
 * realizan validaciones
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class ValidacionException extends RuntimeException {

    /**
     * Crea una nueva instancia de ValidacionException sin un mensaje específico
     */
    public ValidacionException() {
        super();
    }

    /**
     * Crea una nueva instancia de ValidacionException con el mensaje
     * especificado
     *
     * @param message El mensaje de la excepción
     */
    public ValidacionException(String message) {
        super(message);
    }

    /**
     * Crea una nueva instancia de ValidacionException con el mensaje y la causa
     * especificados
     *
     * @param message El mensaje de la excepción
     * @param cause La causa de la excepción
     */
    public ValidacionException(String message, Throwable cause) {
        super(message, cause);
    }

}
