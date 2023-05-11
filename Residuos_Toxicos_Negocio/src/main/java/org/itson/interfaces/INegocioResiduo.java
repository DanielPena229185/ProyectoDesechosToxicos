/**
* INegocioResiduo.java
* 10 may. 2023 11:39:54
*/ 

package org.itson.interfaces;

import com.dominio.Residuo;
import java.util.List;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.excepciones.ValidacionExcepcion;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioResiduo {

    public Residuo insertarResiduo(Residuo residuo) throws NegocioExcepcion;
    public List<Residuo> consultarResiduos() throws NegocioExcepcion;
    public List<Residuo> consultarResiduo(Residuo residuo) throws NegocioExcepcion;
    public List<Residuo> consultarResiduoFiltro(Residuo residuo) throws NegocioExcepcion;
    
}
