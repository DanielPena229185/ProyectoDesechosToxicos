/**
 * INegocioAdministrador.java
 * 16 may. 2023 14:52:36
 */
package org.itson.interfaces;

import com.dominio.Administrador;
import org.itson.excepciones.NegocioException;

/**
 * Descripción de la clase: interfaz que contiene los métodos definidos para
 * realizar las operaciones en las clases que la implementen
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public interface INegocioAdministrador {

    /**
     * Realiza el inicio de sesión de un administrador en el sistema.
     *
     * @param correo El correo electrónico del administrador.
     * @param contrasena La contraseña del administrador.
     * @return El objeto Administrador correspondiente al inicio de sesión
     * exitoso.
     * @throws NegocioException Si ocurre un error en la lógica del negocio
     * durante el inicio de sesión.
     */
    public Administrador loginAdministrador(String correo, String contrasena) throws NegocioException;

}
