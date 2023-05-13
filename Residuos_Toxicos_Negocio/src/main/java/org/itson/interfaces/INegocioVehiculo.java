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
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocioVehiculo {

    Vehiculo insertarVehiculo(Vehiculo vehiculo) throws NegocioException;
    
    List<Vehiculo> consultaVehiuculoEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws NegocioException;
    
}
