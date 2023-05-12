/**
* INegocioProductor.java
* 11 may. 2023 17:46:24
*/ 

package org.itson.interfaces;

import com.dominio.Productor;
import org.itson.DTO.ProductorDTO;
import org.itson.excepciones.NegocioExcepcion;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioProductor {

    public Productor insertarProductor(Productor productor);
    public Productor login(ProductorDTO productor) throws NegocioExcepcion;
    
}
