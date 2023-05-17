/**
 * NegocioFachada.java
 * 12 may. 2023 15:08:49
 */
package org.itson.implementacion;

import com.dominio.Administrador;
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
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.INegocio;
import org.itson.interfaces.INegocioAdministrador;
import org.itson.interfaces.INegocioEmpresasTransportista;
import org.itson.interfaces.INegocioProductor;
import org.itson.interfaces.INegocioQuimico;
import org.itson.interfaces.INegocioResiduo;
import org.itson.interfaces.INegocioSolicitud;
import org.itson.interfaces.INegocioTransporte;
import org.itson.interfaces.INegocioTraslado;
import org.itson.interfaces.INegocioVehiculo;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class FachadaNegocio implements INegocio {

    INegocioResiduo negocioResiduo;
    INegocioProductor negocioProductor;
    INegocioQuimico negocioQuimico;
    INegocioSolicitud negocioSolicitud;
    INegocioTransporte negocioTransporte;
    INegocioTraslado negocioTraslado;
    INegocioVehiculo negocioVehiculo;
    INegocioAdministrador negocioAdministrador;
    INegocioEmpresasTransportista negocioEmpresaTransportista;

    /**
     * Constructor por default
     */
    public FachadaNegocio() {
        negocioResiduo = NegocioFactory.getNegocioResiduo();
        negocioProductor = NegocioFactory.getNegocioProductor();
        negocioQuimico = NegocioFactory.getNegocioQuimico();
        negocioSolicitud = NegocioFactory.getNegocioSolicitud();
        negocioTransporte = NegocioFactory.getNegocioTransporte();
        negocioTraslado = NegocioFactory.getNegocioTraslado();
        negocioVehiculo = NegocioFactory.getNegocioVehiculo();
        negocioAdministrador = NegocioFactory.getNegocioAdministrador();
        negocioEmpresaTransportista = NegocioFactory.getNegocioEmpresaTransportista();
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
        try {
            return negocioSolicitud.insertarSolicitud(solicitud);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Solicitud> consultaSolicitudesNoAtendidas() throws NegocioException {
        try {
            return negocioSolicitud.consultaSolicitudesNoAtendidas();
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Solicitud> consultarSolicitudFiltro(Solicitud solicitud) throws NegocioException {
        try {
            return negocioSolicitud.consultarSolicitudFiltro(solicitud);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Transporte insertarTransporte(Transporte transporte) throws NegocioException {
        try {
            return negocioTransporte.insertarTransporte(transporte);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Traslado insertarTraslado(Traslado traslado) throws NegocioException {
        try {
            return negocioTraslado.insertarTraslado(traslado);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Traslado> consultaTrasladosAsingados(EmpresaTransportista empresaTransportista) throws NegocioException {
        try {
            return negocioTraslado.consultaTrasladosAsingados(empresaTransportista);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Vehiculo> consultaVehiuculoEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws NegocioException {
        try {
            return negocioVehiculo.consultaVehiuculoEmpresaTrasnportadora(empresaTransportista);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Administrador loginAdministrador(String correo, String contrasena) throws NegocioException {
        try {
            return negocioAdministrador.loginAdministrador(correo, contrasena);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public EmpresaTransportista loginEmpresaTrasnportista(String correo, String contrasena) throws NegocioException {
        try {
            return negocioEmpresaTransportista.loginEmpresaTrasnportista(correo, contrasena);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<EmpresaTransportista> consultaTodasEmpresasTransportistas() throws NegocioException {
        try {
            return negocioEmpresaTransportista.consultaTodasEmpresasTransportistas();
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    
}
