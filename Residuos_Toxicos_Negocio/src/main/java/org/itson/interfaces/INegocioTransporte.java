/**
 * INegocioTransporte.java
 * 12 may. 2023 16:28:15
 */
package org.itson.interfaces;

import com.dominio.Transporte;
import org.itson.excepciones.NegocioException;

/**
 * Descripción de la interface:Define un método relacionado con la gestión de transportes en el sistema
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioTransporte {

 /**
 * Inserta un nuevo transporte en el sistema.
 *
 * @param transporte El objeto Transporte que se desea insertar.
 * @return El objeto Transporte insertado en el sistema.
 * @throws NegocioException Si ocurre un error en la lógica del negocio durante la inserción.
 */
public Transporte insertarTransporte(Transporte transporte) throws NegocioException;

    
}
