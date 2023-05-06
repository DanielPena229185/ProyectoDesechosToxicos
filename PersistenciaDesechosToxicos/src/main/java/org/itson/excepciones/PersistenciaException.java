package org.itson.excepciones;

/**
 * Esta clase se encarga de manejar las excepciones generadas en la capa
 * de persistencia.
 * 
 * @author oscar
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
     * @param message mensaje del error.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Método constructor que recibe un mensaje y una causa como parámetros.
     * @param message mensaje del error.
     * @param cause causa del error.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Método constructor que recibe una causa como parámetro.
     * @param cause causa del error.
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }
}
