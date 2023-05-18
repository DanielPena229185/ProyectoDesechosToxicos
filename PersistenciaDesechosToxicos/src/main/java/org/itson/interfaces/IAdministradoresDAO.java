
package org.itson.interfaces;

import com.dominio.Administrador;
import org.itson.excepciones.PersistenciaException;

/**
 * Interfaz que contiene los metodos AdministradoresDAO
 * @author edemb
 */
public interface IAdministradoresDAO {
    Administrador loginAdministrador(String correo,String contrasena)throws PersistenciaException;
}
