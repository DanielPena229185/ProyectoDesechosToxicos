/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import com.dominio.EmpresaTransportista;
import com.dominio.Vehiculo;
import java.util.List;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author edemb
 */
public interface IVehiculosDAO {

    Vehiculo insertarVehiculo(Vehiculo vehiculo) throws PersistenciaException;

    List<Vehiculo> consultarVehiculosEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws PersistenciaException;
}
