
package org.itson.interfaces;

import com.dominio.EmpresaTransportista;
import com.dominio.Vehiculo;
import java.util.List;
import org.itson.excepciones.PersistenciaException;

/**
 * Descriocion de la interfaz:Esta interfaz define dos métodos para interactuar con una base de datos de vehiculos
 * @author edemb
 */
public interface IVehiculosDAO {
    /**
     * Inserta un Vehiculo en la base de datos.
     * @param vehiculo el Vehiculo que se desea insertar.
     * @return el Vehiculo insertado con el identificador generado por la base de datos.
     * @throws PersistenciaException si ocurre un error al acceder a la base de datos.
     */
    Vehiculo insertarVehiculo(Vehiculo vehiculo) throws PersistenciaException;
    /**
     * Devuelve una lista de Vehiculos pertenecientes a una EmpresaTransportista especifica.
     * @param empresaTransportista la EmpresaTransportista de la cual se quieren obtener los Vehiculos.
     * @return una lista de Vehiculos pertenecientes a la EmpresaTransportista especificada.
     * @throws PersistenciaException si ocurre un error al acceder a la base de datos.
     */
    List<Vehiculo> consultarVehiculosEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws PersistenciaException;
}
