/**
 * NegocioFachada.java
 * 12 may. 2023 15:08:49
 */
package org.itson.implementacion;

import com.dominio.EmpresaTransportista;
import com.dominio.Productor;
import com.dominio.Quimico;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import com.dominio.Transporte;
import com.dominio.Traslado;
import com.dominio.Vehiculo;
import java.util.List;
import org.itson.DTO.ProductorDTO;
import org.itson.excepciones.NegocioException;
import org.itson.interfaces.INegocio;
import org.itson.interfaces.INegocioProductor;
import org.itson.interfaces.INegocioQuimico;
import org.itson.interfaces.INegocioResiduo;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class FachadaNegocio implements INegocio{

    INegocioResiduo negocioResiduo;
    INegocioProductor negocioProductor;
    INegocioQuimico negocioQuimico;

    /**
     * Constructor por default
     */
    public FachadaNegocio() {
        negocioResiduo = NegocioFactory.getNegocioResiduo();
        negocioProductor = NegocioFactory.getNegocioProductor();
        negocioQuimico = NegocioFactory.getNegocioQuimico();
    }

    @Override
    public Productor insertarProductor(Productor productor) {
        try {
            return negocioProductor.insertarProductor(productor);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Productor loginProductor(ProductorDTO productor) throws NegocioException {
        try {
            return negocioProductor.loginProductor(productor);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Quimico> consultarQuimicos() throws NegocioException {
        try {
            return negocioQuimico.consultarQuimicos();
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Residuo insertarResiduo(Residuo residuo) throws NegocioException {
        try {
            return negocioResiduo.insertarResiduo(residuo);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Residuo> consultarResiduoFiltro(Residuo residuo) throws NegocioException {
        try {
            return negocioResiduo.consultarResiduoFiltro(residuo);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Solicitud insertarSolicitud(Solicitud solicitud) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Solicitud> consultaSolicitudesNoAtendidas() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Solicitud> consultarSolicitudFiltro(Solicitud solicitud) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Transporte insertarTransporte(Transporte transporte) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Traslado insertarTraslado(Traslado traslado) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Traslado> consultaTrasladosAsingados(EmpresaTransportista empresaTransportista) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vehiculo> consultaVehiuculoEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
