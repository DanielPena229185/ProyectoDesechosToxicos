/**
* INegocioAdministrador.java
* 16 may. 2023 14:52:36
*/ 

package org.itson.interfaces;

import com.dominio.Administrador;
import org.itson.excepciones.NegocioException;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioAdministrador {

    public Administrador loginAdministrador(String correo, String contrasena) throws NegocioException;
    
}
