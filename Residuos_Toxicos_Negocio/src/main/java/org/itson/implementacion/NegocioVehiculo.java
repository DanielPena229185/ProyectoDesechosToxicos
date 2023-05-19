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
 * Descripción de la clase: Clase que actúa como puente para realizar las
 * operaciones en el sistema de persistencia, pero antes realizar operaciones
 * para comprobar que el traslado de datos sea correcto
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class NegocioVehiculo implements INegocioVehiculo {

    IPersistencia persistencia;

    /**
     * Constructor por default
     */
    public NegocioVehiculo() {
        persistencia = new FachadaPersistencia();
    }

    /**
     * Consulta los vehículos de una empresa transportista.
     *
     * @param empresaTransportista La empresa transportista de la cual se desea
     * consultar los vehículos.
     * @return Una lista de objetos Vehiculo que pertenecen a la empresa
     * transportista especificada.
     * @throws NegocioException Si ocurre un error en la lógica del negocio
     * durante la consulta.
     */
    @Override
    public List<Vehiculo> consultaVehiuculoEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws NegocioException {
        try {
            if (empresaTransportista == null) {
                throw new ValidacionException("No hay información de la empresa transportista");
            }
            return persistencia.consultarVehiculosEmpresaTrasnportadora(empresaTransportista);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        } catch (ValidacionException a) {
            throw new NegocioException(a.getMessage());
        }
    }
}
