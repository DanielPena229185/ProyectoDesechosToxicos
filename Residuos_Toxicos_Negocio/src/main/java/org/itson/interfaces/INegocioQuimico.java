/**
* INegocioQuimico.java
* 11 may. 2023 20:16:52
*/ 

package org.itson.interfaces;

import com.dominio.Quimico;
import java.util.List;
import org.itson.excepciones.NegocioExcepcion;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioQuimico {

    public Quimico insertarQuimico(Quimico quimico) throws NegocioExcepcion;
    
    public List<Quimico> consultarQuimicos() throws NegocioExcepcion;
    
}