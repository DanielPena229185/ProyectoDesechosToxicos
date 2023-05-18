/**
* PresentacionException.java
* 30 abr. 2023 13:13:55
*/ 

package org.itson.excepciones;

/**
 * Descripción de la clase:Es una excepción no comprobada que se puede utilizar para 
 * representar errores específicos relacionados con la presentación en una aplicación
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID:
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PresentacionException extends RuntimeException{

/**
 * Crea una nueva instancia de PresentacionException sin mensaje de detalle.
 */
public PresentacionException() {
}
/**
 * Crea una nueva instancia de PresentacionException con un mensaje de detalle especificado.
 * @param message El mensaje de detalle.
 */
public PresentacionException(String message) {
    super(message);
}

/**
 * Crea una nueva instancia de PresentacionException con un mensaje de detalle y una causa subyacente especificados.
 * @param message El mensaje de detalle.
 * @param cause La causa subyacente.
 */
public PresentacionException(String message, Throwable cause) {
    super(message, cause);
}
    
}
