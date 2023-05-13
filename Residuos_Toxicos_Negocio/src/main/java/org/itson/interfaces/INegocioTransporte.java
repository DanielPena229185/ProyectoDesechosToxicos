/**
 * INegocioTransporte.java
 * 12 may. 2023 16:28:15
 */
package org.itson.interfaces;

import com.dominio.Transporte;
import org.itson.excepciones.NegocioException;

/**
 * Descripción de la interface:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioTransporte {

    Transporte insertarTransporte(Transporte transporte) throws NegocioException;
    
}
