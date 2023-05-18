/**
* INegocioAdministrador.java
* 16 may. 2023 14:52:36
*/ 

package org.itson.interfaces;

import com.dominio.Administrador;
import org.itson.excepciones.NegocioException;

/**
 * Descripción de la interface:Define un método para el inicio de sesión de un administrador en el sistema. 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioAdministrador {
/**
 * Realiza el inicio de sesión de un administrador en el sistema.
 *
 * @param correo El correo electrónico del administrador.
 * @param contrasena La contraseña del administrador.
 * @return El objeto Administrador correspondiente al inicio de sesión exitoso.
 * @throws NegocioException Si ocurre un error en la lógica del negocio durante el inicio de sesión.
 */
public Administrador loginAdministrador(String correo, String contrasena) throws NegocioException;

    
}
