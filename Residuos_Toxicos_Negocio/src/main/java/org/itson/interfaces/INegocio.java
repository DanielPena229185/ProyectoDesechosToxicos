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
 * Descripción de la interface: Define un conjunto de métodos que representan las operaciones de 
 * negocio relacionadas con el sistema.
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface INegocio {
    /**
     * Inserta un nuevo productor en el sistema.
     *
     * @param productor El objeto Productor que se desea insertar.
     * @return El objeto Productor insertado en el sistema.
     */
    public Productor insertarProductor(Productor productor);
    /**
     * Realiza el inicio de sesión de un productor en el sistema.
     *
     * @param productor El objeto ProductorDTO que contiene los datos de inicio de sesión.
     * @return El objeto Productor correspondiente al inicio de sesión exitoso.
     * @throws NegocioException Si ocurre un error en la lógica del negocio durante el inicio de sesión.
     */
    public Productor loginProductor(ProductorDTO productor) throws NegocioException;
    /**
     * Consulta la lista de químicos disponibles en el sistema.
     *
     * @return Una lista de objetos Quimico que representan los químicos disponibles.
     * @throws NegocioException Si ocurre un error en la lógica del negocio durante la consulta.
     */
    public List<Quimico> consultarQuimicos() throws NegocioException;
    /**
     * Inserta un nuevo residuo en el sistema.
     *
     * @param residuo El objeto Residuo que se desea insertar.
     * @return El objeto Residuo insertado en el sistema.
     * @throws NegocioException Si ocurre un error en la lógica del negocio durante la inserción.
     */
    public Residuo insertarResiduo(Residuo residuo) throws NegocioException;
    /**
     * Consulta una lista de residuos filtrados según los criterios especificados.
     *
     * @param residuo El objeto Residuo que contiene los criterios de filtrado.
     * @return Una lista de objetos Residuo que cumplen con los criterios de filtrado.
     * @throws NegocioException Si ocurre un error en la lógica del negocio durante la consulta.
     */
    public List<Residuo> consultarResiduoFiltro(Residuo residuo) throws NegocioException;
    /**
     * Inserta una nueva solicitud en el sistema.
     *
     * @param solicitud El objeto Solicitud que se desea insertar.
     * @return El objeto Solicitud insertado en el sistema.
     * @throws NegocioException Si ocurre un error en la lógica del negocio durante la inserción.
     */
    Solicitud insertarSolicitud(Solicitud solicitud) throws NegocioException;
    /**
     * Consulta la lista de solicitudes no atendidas en el sistema.
     *
     * @return Una lista de objetos Solicitud que representan las solicitudes no atendidas.
     * @throws NegocioException Si ocurre un error en la lógica del negocio durante la consulta.
     */
    
    List<Solicitud> consultaSolicitudesNoAtendidas() throws NegocioException;
    /**
     * Consulta una lista de solicitudes filtradas según los criterios especificados.
     *
     * @param solicitud El objeto Solicitud que contiene los criterios de filtrado.
     * @return Una lista de objetos Solicitud que cumplen con los criterios de filtrado.
     * @throws NegocioException Si ocurre un error en la lógica del negocio durante la consulta.
     */
    List<Solicitud> consultarSolicitudFiltro(Solicitud solicitud) throws NegocioException;
    /**
     * Inserta un nuevo transporte en el sistema
     *
     * @param transporte El objeto Transporte que se desea insertar.
     * @return El objeto Transporte insertado en el sistema.
     * @throws NegocioException Si ocurre un error en la lógica del negocio durante la inserción.
     */
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
