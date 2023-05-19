package org.itson.interfaces;

import com.dominio.Administrador;
import org.itson.excepciones.PersistenciaException;

/**
 * Interfaz que contiene los metodos AdministradoresDAO
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public interface IAdministradoresDAO {

    Administrador loginAdministrador(String correo, String contrasena) throws PersistenciaException;
}
