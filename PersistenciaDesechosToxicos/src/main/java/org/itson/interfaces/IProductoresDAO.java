
package org.itson.interfaces;

import com.dominio.Productor;
import org.itson.DTO.ProductorDTO;
import org.itson.excepciones.PersistenciaException;

/**
 * Descriocion de la interfaz: Esta interfaz define dos metodos que permiten interactuar con una base de datos de productor
 * @author edemb
 */
public interface IProductoresDAO {
    /**
     * Inserta un nuevo productor en la base de datos
     * @param o el objeto Productor que se desea insertar en la base de datos
     * @return el objeto Productor insertado en la base de datos
     * @throws PersistenciaException si ocurre un error al intentar insertar el Productor en la base de datos
     */
    Productor insertar(Productor o) throws PersistenciaException;
    /**
     * Consulta un productor en la base de datos utilizando su correo electronico y contrasena
     * @param correo el correo electrónico del productor que se desea consultar
     * @param contrasena la contraseña del productor que se desea consultar
     * @return el objeto Productor que coincide con el correo electrónico y contraseña especificados
     * @throws PersistenciaException si ocurre un error al intentar consultar el Productor en la base de datos
     */
    Productor consultarLogin(String correo,String contrasena) throws PersistenciaException;
}
