/**
 * INegocio.java
 * 10 may. 2023 18:21:44
 */
package org.itson.interfaces;

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

/**
 * Descripción de la interface:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocio {

    public Productor insertarProductor(Productor productor);

    public Productor loginProductor(ProductorDTO productor) throws NegocioException;

    public List<Quimico> consultarQuimicos() throws NegocioException;

    public Residuo insertarResiduo(Residuo residuo) throws NegocioException;

    public List<Residuo> consultarResiduoFiltro(Residuo residuo) throws NegocioException;

    Solicitud insertarSolicitud(Solicitud solicitud) throws NegocioException;

    List<Solicitud> consultaSolicitudesNoAtendidas() throws NegocioException;

    List<Solicitud> consultarSolicitudFiltro(Solicitud solicitud) throws NegocioException;

    Transporte insertarTransporte(Transporte transporte) throws NegocioException;

    /**
     * Inserta un Traslado en la base de datos.
     *
     * @param traslado el Traslado que se desea insertar.
     * @return el Traslado insertado con el identificador generado por la base
     * de datos.
     * @throws PersistenciaException si ocurre un error al acceder a la base de
     * datos.
     */
    Traslado insertarTraslado(Traslado traslado) throws NegocioException;

    /**
     * Devuelve una lista de Traslados asignados a una EmpresaTransportista
     * especifica.
     *
     * @param empresaTransportista la EmpresaTransportista de la cual se quieren
     * obtener los Traslados asignados.
     * @return una lista de Traslados asignados a la EmpresaTransportista
     * especificada.
     * @throwsNegocioExcepcion si ocurre un error al acceder a la base de datos.
     */
    List<Traslado> consultaTrasladosAsingados(EmpresaTransportista empresaTransportista) throws NegocioException;

    List<Vehiculo> consultaVehiuculoEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws NegocioException;

    public Administrador loginAdministrador(String correo, String contrasena) throws NegocioException;

    /**
     * Autentica una empresa transportista en algun sistema
     *
     * @param correo la dirección de correo electrónico de la empresa
     * transportista
     * @param contrasena la contraseña de la empresa transportista
     * @return el objeto EmpresaTransportista correspondiente a los datos de
     * inicio de sesión si son válidos
     * @throws PersistenciaException si los datos de inicio de sesión son
     * incorrectos o hay algún problema al realizar la autenticación
     */
    EmpresaTransportista loginEmpresaTrasnportista(String correo, String contrasena) throws NegocioException;

    /**
     * Recupera todas las empresas transportistas almacenadas en alguna fuente
     * de datos persistente
     *
     * @return una lista de objetos EmpresaTransportista
     * @throws PersistenciaException si hay algún problema al realizar la
     * consulta
     */
    List<EmpresaTransportista> consultaTodasEmpresasTransportistas() throws NegocioException;
}
