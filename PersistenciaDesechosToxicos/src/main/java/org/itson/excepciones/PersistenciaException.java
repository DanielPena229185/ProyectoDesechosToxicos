package org.itson.excepciones;

/**
 * Descripción de la clase: Esta clase se encarga de manejar las excepciones
 * generadas en la capa de persistencia.
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class PersistenciaException extends RuntimeException {

    /**
     * Método constructor por omisión.
     */
    public PersistenciaException() {
        super();
    }

    /**
     * Método constructor que recibe un mensaje como parámetro.
     *
     * @param message mensaje del error.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Método constructor que recibe un mensaje y una causa como parámetros.
     *
     * @param message mensaje del error.
     * @param cause causa del error.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Método constructor que recibe una causa como parámetro.
     *
     * @param cause causa del error.
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }
}
