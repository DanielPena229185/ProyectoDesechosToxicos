/**
* CrudInterface.java
* 7 may. 2023 21:37:23
*/ 

package org.itson.interfaces;

import java.util.List;
import org.itson.excepciones.NegocioExcepcion;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface CrudInterface<T> {
    
    public T insertar(T elemento)throws NegocioExcepcion;
    public T eliminar(T elemento)throws NegocioExcepcion;
    public T actualizar(T elemento)throws NegocioExcepcion;
    public List<T> consultar()throws NegocioExcepcion;
    public List<T> consultar(T elemento)throws NegocioExcepcion;
    
}
