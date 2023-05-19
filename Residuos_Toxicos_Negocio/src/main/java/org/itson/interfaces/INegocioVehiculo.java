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
 * Descripción de la clase: interfaz que contiene los métodos definidos para
 * realizar las operaciones en las clases que la implementen
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public interface INegocioVehiculo {

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
    List<Vehiculo> consultaVehiuculoEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws NegocioException;

}
