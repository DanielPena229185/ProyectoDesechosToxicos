/**
* INegocioQuimico.java
* 11 may. 2023 20:16:52
*/ 

package org.itson.interfaces;

import com.dominio.Quimico;
import java.util.List;
import org.itson.excepciones.NegocioException;

/**
 * Descripción de la interface: Define dos métodos relacionados con la gestión de los químicos en el sistema
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioQuimico {

/**
 * Inserta un nuevo químico en el sistema.
 *
 * @param quimico El objeto Quimico que se desea insertar.
 * @return El objeto Quimico insertado en el sistema.
 * @throws NegocioException Si ocurre un error en la lógica del negocio durante la inserción.
 */
public Quimico insertarQuimico(Quimico quimico) throws NegocioException;

/**
 * Consulta la lista de químicos disponibles en el sistema.
 *
 * @return Una lista de objetos Quimico que representan los químicos disponibles.
 * @throws NegocioException Si ocurre un error en la lógica del negocio durante la consulta.
 */
public List<Quimico> consultarQuimicos() throws NegocioException;

    
}
