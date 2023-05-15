/**
* INegocioEmpresaTransportista.java
* 14 may. 2023 21:57:13
*/ 

package org.itson.implementacion;

import com.dominio.EmpresaTransportista;
import java.util.List;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.fachada.FachadaPersistencia;
import org.itson.interfaces.INegocioEmpresasTransportista;
import org.itson.interfaces.IPersistencia;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class INegocioEmpresaTransportista implements INegocioEmpresasTransportista{

    IPersistencia persistencia;
    
    /**
     * Constructor por default
     */
    public INegocioEmpresaTransportista(){
        persistencia = new FachadaPersistencia();
    }

    @Override
    public List<EmpresaTransportista> consultaTodasEmpresasTransportistas() throws PersistenciaException {
        try {
            return persistencia.consultaTodasEmpresasTransportistas();
        } catch (PersistenciaException e) {
            throw new NegocioException();
        }
    }

    @Override
    public EmpresaTransportista insertar(EmpresaTransportista o) throws PersistenciaException {
        try {
            return persistencia.insertar(o);
        } catch (PersistenciaException e) {
            throw new NegocioException();
        }
    }

    @Override
    public EmpresaTransportista loginEmpresaTrasnportista(String correo, String contrasena) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
