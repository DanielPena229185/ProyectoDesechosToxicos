/**
* INegocioResiduo.java
* 10 may. 2023 11:39:54
*/ 

package org.itson.interfaces;

import com.dominio.Residuo;
import java.util.List;
import org.itson.excepciones.NegocioException;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioResiduo {

    public Residuo insertarResiduo(Residuo residuo) throws NegocioException;
    
    public List<Residuo> consultarResiduoFiltro(Residuo residuo) throws NegocioException;
    
}
