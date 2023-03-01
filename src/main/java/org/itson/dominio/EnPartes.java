/**
* EnPartes.java
* 1 mar. 2023 09:26:42
*/ 

package org.itson.dominio;
//importanciones
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class EnPartes extends Traslado{

    /**
     * 
     */
    public EnPartes(){

    }

    /**
     * 
     * @param id
     * @param direccion
     * @param residuo 
     */
    public EnPartes(Integer id, Direccion direccion, Residuo residuo) {
        super(id, direccion, residuo);
    }
    
}
