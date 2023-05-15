/**
 * NegocioVehiculo.java
 * 12 may. 2023 16:28:29
 */
package org.itson.implementacion;

import com.dominio.EmpresaTransportista;
import com.dominio.Vehiculo;
import java.util.List;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.implementaciones.fachada.FachadaPersistencia;
import org.itson.interfaces.INegocioVehiculo;
import org.itson.interfaces.IPersistencia;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioVehiculo implements INegocioVehiculo {

    IPersistencia persistencia;

    /**
     * Constructor por default
     */
    public NegocioVehiculo() {
        persistencia = new FachadaPersistencia();
    }


    @Override
    public List<Vehiculo> consultaVehiuculoEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws NegocioException {
        try {
            if(empresaTransportista == null){
                throw new ValidacionException("No hay información de la empresa transportista");
            }
            return persistencia.consultarVehiculosEmpresaTrasnportadora(empresaTransportista);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        } catch (ValidacionException a){
            throw new NegocioException(a.getMessage());
        }
    }
}
