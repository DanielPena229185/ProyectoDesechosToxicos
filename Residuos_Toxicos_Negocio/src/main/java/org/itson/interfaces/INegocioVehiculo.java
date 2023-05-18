/**
* IVehiculoNegocio.java
* 12 may. 2023 16:22:09
*/ 

package org.itson.interfaces;

import com.dominio.EmpresaTransportista;
import com.dominio.Vehiculo;
import java.util.List;
import org.itson.excepciones.NegocioException;

/**
 * Descripción de la interface: Interfaz que define las operaciones de negocio relacionadas con los vehículos
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioVehiculo {

    /**
     * Consulta los vehículos de una empresa transportista.
     *
     * @param empresaTransportista La empresa transportista de la cual se desea consultar los vehículos.
     * @return Una lista de objetos Vehiculo que pertenecen a la empresa transportista especificada.
     * @throws NegocioException Si ocurre un error en la lógica del negocio durante la consulta.
     */
    List<Vehiculo> consultaVehiuculoEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws NegocioException;
    
}
