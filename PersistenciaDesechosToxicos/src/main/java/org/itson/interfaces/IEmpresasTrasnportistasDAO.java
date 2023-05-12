/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import com.dominio.EmpresaTransportista;
import java.util.List;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author edemb
 */
public interface IEmpresasTrasnportistasDAO {

    List<EmpresaTransportista> consultaTodasEmpresasTransportistas() throws PersistenciaException;
    EmpresaTransportista insertar(EmpresaTransportista o) throws PersistenciaException;
}
