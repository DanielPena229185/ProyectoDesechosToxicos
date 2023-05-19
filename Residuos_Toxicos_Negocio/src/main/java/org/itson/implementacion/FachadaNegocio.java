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

    /**
     * Inserta un objeto Productor en el sistema.
     * @param productor El Productor a insertar.
     * @return El Productor insertado.
     * @throws NegocioException Si ocurre un error en la capa de negocio durante la inserción.
     */
    @Override
    public Productor insertarProductor(Productor productor) {
        try {
            return negocioProductor.insertarProductor(productor);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Inicia sesión de un Productor en el sistema.
     * @param productor El ProductorDTO que contiene los datos de inicio de sesión.
     * @return El Productor que ha iniciado sesión
     * @throws NegocioException Si ocurre un error en la capa de negocio durante el inicio de sesión.
     */
    @Override
    public Productor loginProductor(ProductorDTO productor) throws NegocioException {
        try {
            return negocioProductor.loginProductor(productor);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Consulta la lista de Químicos en el sistema.
     * @return La lista de Químicos.
     * @throws NegocioException Si ocurre un error en la capa de negocio durante la consulta.
     */
    @Override
    public List<Quimico> consultarQuimicos() throws NegocioException {
        try {
            return negocioQuimico.consultarQuimicos();
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Inserta un objeto Residuo en el sistema.
     * @param residuo El Residuo a insertar.
     * @return El Residuo insertado.
     * @throws NegocioException Si ocurre un error en la capa de negocio durante la inserción.
     */
    @Override
    public Residuo insertarResiduo(Residuo residuo) throws NegocioException {
        try {
            return negocioResiduo.insertarResiduo(residuo);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Consulta una lista de Residuos en el sistema basada en un filtro.
     * @param residuo El Residuo utilizado como filtro.
     * @return La lista de Residuos que cumplen con el filtro.
     * @throws NegocioException Si ocurre un error en la capa de negocio durante la consulta.
    */
    @Override
    public List<Residuo> consultarResiduosFiltro(Residuo residuo) throws NegocioException {
        try {
            return negocioResiduo.consultarResiduosFiltro(residuo);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Inserta una Solicitud en el sistema.
     * @param solicitud La Solicitud a insertar.
     * @return La Solicitud insertada.
     * @throws NegocioException Si ocurre un error en la capa de negocio durante la inserción.
     */
    @Override
    public Solicitud insertarSolicitud(Solicitud solicitud) throws NegocioException {
        try {
            return negocioSolicitud.insertarSolicitud(solicitud);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Consulta una lista de Solicitudes no atendidas en el sistema.
     * @return La lista de Solicitudes no atendidas.
     * @throws NegocioException Si ocurre un error en la capa de negocio durante la consulta.
     */
    @Override
    public List<Solicitud> consultaSolicitudesNoAtendidas() throws NegocioException {
        try {
            return negocioSolicitud.consultaSolicitudesNoAtendidas();
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Consulta una lista de Solicitudes en el sistema basada en un filtro.
     * @param solicitud La Solicitud utilizada como filtro.
     * @return La lista de Solicitudes que cumplen con el filtro.
     * @throws NegocioException Si ocurre un error en la capa de negocio durante la consulta.
     */
    @Override
    public List<Solicitud> consultarSolicitudFiltro(Solicitud solicitud) throws NegocioException {
        try {
            return negocioSolicitud.consultarSolicitudFiltro(solicitud);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Inserta un objeto Transporte en el sistema.
     * @param transporte El Transporte a insertar.
     * @return El Transporte insertado.
     * @throws NegocioException Si ocurre un error en la capa de negocio durante la inserción.
     */
    @Override
    public Transporte insertarTransporte(Transporte transporte) throws NegocioException {
        try {
            return negocioTransporte.insertarTransporte(transporte);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Inserta un objeto Traslado en el sistema
     * @param traslado El Traslado a insertar.
     * @return El Traslado insertado.
     * @throws NegocioException Si ocurre un error en la capa de negocio durante la inserción.
     */
    @Override
    public Traslado insertarTraslado(Traslado traslado) throws NegocioException {
        try {
            return negocioTraslado.insertarTraslado(traslado);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Consulta una lista de Traslados asignados a una Empresa Transportista en el sistema.
     * @param empresaTransportista La Empresa Transportista para la cual se consultan los Traslados asignados.
     * @return La lista de Traslados asignados a la Empresa Transportista.
     * @throws NegocioException Si ocurre un error en la capa de negocio durante la consulta.
     */
    @Override
    public List<Traslado> consultaTrasladosAsingados(EmpresaTransportista empresaTransportista) throws NegocioException {
        try {
            return negocioTraslado.consultaTrasladosAsingados(empresaTransportista);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Consulta una lista de Vehículos pertenecientes a una Empresa Transportista en el sistema.
     * @param empresaTransportista La Empresa Transportista para la cual se consultan los Vehículos.
     * @return La lista de Vehículos pertenecientes a la Empresa Transportista.
     * @throws NegocioException Si ocurre un error en la capa de negocio durante la consulta.
     */
    @Override
    public List<Vehiculo> consultaVehiuculoEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws NegocioException {
        try {
            return negocioVehiculo.consultaVehiuculoEmpresaTrasnportadora(empresaTransportista);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Realiza el inicio de sesión de un Administrador en el sistema.
     * @param correo El correo del Administrador.
     * @param contrasena La contraseña del Administrador.
     * @return El Administrador que ha iniciado sesión.
     * @throws NegocioException Si ocurre un error en la capa de negocio durante el inicio de sesión.
     */
    @Override
    public Administrador loginAdministrador(String correo, String contrasena) throws NegocioException {
        try {
            return negocioAdministrador.loginAdministrador(correo, contrasena);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Realiza el inicio de sesión de una Empresa Transportista en el sistema.
     * @param correo El correo de la Empresa Transportista.
     * @param contrasena La contraseña de la Empresa Transportista.
     * @return La Empresa Transportista que ha iniciado sesión.
     * @throws NegocioException Si ocurre un error en la capa de negocio durante el inicio de sesión.
     */
    @Override
    public EmpresaTransportista loginEmpresaTrasnportista(String correo, String contrasena) throws NegocioException {
        try {
            return negocioEmpresaTransportista.loginEmpresaTrasnportista(correo, contrasena);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
    * Consulta una lista de todas las Empresas Transportistas registradas en el sistema
    * @return La lista de todas las Empresas Transportistas registradas.
    * @throws NegocioException Si ocurre un error en la capa de negocio durante la consulta.
    */
    @Override
    public List<EmpresaTransportista> consultaTodasEmpresasTransportistas() throws NegocioException {
        try {
            return negocioEmpresaTransportista.consultaTodasEmpresasTransportistas();
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Solicitud actualizaEstadoASolicitudAtendida(Solicitud solicitud) throws NegocioException {
        try {
            return negocioSolicitud.actualizaEstadoASolicitudAtendida(solicitud);
        } catch (NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    
}
