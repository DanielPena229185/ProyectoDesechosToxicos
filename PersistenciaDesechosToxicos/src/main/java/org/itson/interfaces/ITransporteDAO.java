
package org.itson.interfaces;

import com.dominio.Transporte;
import org.itson.excepciones.PersistenciaException;

/**
 * Descriocion de la interfaz: Interfaz que define el metodo de insertar transporte
 * @author edemb
 */
public interface ITransporteDAO {
    /**
     * Inserta un nuevo transporte en la base de datos
     * @param transporte el objeto Transporte que se desea insertar en la base de datos
     * @return el objeto Transporte insertado en la base de datos
     * @throws PersistenciaException si ocurre un error al intentar insertar el Transporte en la base de datos
     */
    Transporte insertarTrasnporte(Transporte transporte) throws PersistenciaException;
}
