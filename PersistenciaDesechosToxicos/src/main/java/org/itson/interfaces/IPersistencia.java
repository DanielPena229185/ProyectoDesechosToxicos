/**
 * IPersistencia.java
 * 12 may. 2023 15:16:33
 */
package org.itson.interfaces;

import com.dominio.EmpresaTransportista;
import com.dominio.Productor;
import com.dominio.Quimico;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import com.dominio.Traslado;
import com.dominio.Vehiculo;
import java.util.List;
import org.itson.DTO.ResiduoDTO;
import org.itson.DTO.SolicitudDTO;
import org.itson.excepciones.PersistenciaException;

/**
 * Descripción de la interface:a interfaz que define metodos para insertar y consultar objetos de diferentes tipos
 * como Quimico, Residuo, Productor, Solicitud y Traslado, en alguna fuente de datos persistente
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IPersistencia {
    
    /**
     * Implementacion de ascutlizar el estado a Atendida de una Solicitud
     * @param solicitud Solicitud a actualizar
     * @return la solicitud actualizada
     * @throws PersistenciaException en caso de algun error
     */
    Solicitud actualizaEstadoASolicitudAtendida(Solicitud solicitud) throws PersistenciaException;

    /**
     * Implementacion de insertarQuimico un Quimico
     *
     * @param o Quimico a insertarQuimico
     * @return El Quimico insertado
     * @throws PersistenciaException en caso de algun error
     */
    Quimico insertarQuimico(Quimico o) throws PersistenciaException;

    /**
     * Implementacion de consutar los Quimicos
     *
     * @return Una lista de Quimicos
     * @throws PersistenciaException en caso de algun error;
     */
    List<Quimico> consultarTodosLosQuimicos() throws PersistenciaException;

    /**
     * Implementacion de Insertar un Residuo
     *
     * @param o Residuo a insertarQuimico
     * @return El Residuo insertado
     * @throws PersistenciaException en caso de algun error
     */
    Residuo insertarResiduo(Residuo o) throws PersistenciaException;

    /**
     * Implementacion de consultarResiduoFiltro Residuos
     *
     * @param residuo Objeto ResiduoDTO con el que se consultara el/los
     * Residuo(s)
     * @return Una Lista de Residuos
     * @throws PersistenciaException en caso de algun error
     */
    List<Residuo> consultarResiduoFiltro(ResiduoDTO residuo) throws PersistenciaException;

    /**
     * Inserta un nuevo objeto Productor en alguna fuente de datos persistente
     * @param o el objeto Productor que se va a insertar
     * @return el objeto Productor recien insertado
     * @throws PersistenciaException si hay algún problema al realizar la insercion
     */
    Productor insertarProductor(Productor o) throws PersistenciaException;

    /**
     * Autentica un productor en el sistema
     * @param correo la dirección de correo electronico del productor
     * @param contrasena la contraseña del productor
     * @return el objeto Productor correspondiente a los datos de inicio de sesión si son válidos
     * @throws PersistenciaException si los datos de inicio de sesión son incorrectos o hay algún problema al realizar la autenticacion
     */
    Productor consultarLoginProductor(String correo, String contrasena) throws PersistenciaException;
    /**
     * Inserta una nueva Solicitud en alguna fuente de datos persistente
     * @param solicitud la solicitud que se va a insertar
     * @return la Solicitud recien insertada
     * @throws PersistenciaException si hay algún problema al realizar la insercion
     */
    Solicitud insertarSolicitud(Solicitud solicitud) throws PersistenciaException;
    /**
     * Consulta las solicitudes que aún no han sido atendidas
     * @return una lista de objetos Solicitud que aun no han sido atendidas
     * @throws PersistenciaException si hay algún problema al realizar la consulta 
     */
    List<Solicitud> consultaSolicitudesNoAtendidas() throws PersistenciaException;
    /**
     * Consulta las solicitudes que cumplen con los criterios especificados en el objeto SolicitudDTO.
     * @param filtro el objeto SolicitudDTO que contiene los criterios de busqueda.
     * @return una lista de objetos Solicitud que cumplen con los criterios especificados.
     * @throws PersistenciaException si hay algún problema al realizar la consulta.
     */
    List<Solicitud> consultarSolicitudFiltro(SolicitudDTO filtro) throws PersistenciaException;
    /**
     * Inserta un nuevo objeto Traslado en alguna fuente de datos persistente
     * @param traslado el objeto Traslado que se va a insertar
     * @return el objeto Traslado recién insertado
     * @throws PersistenciaException si hay algún problema al realizar la insercion
     */
    Traslado insertarTraslado(Traslado traslado) throws PersistenciaException;
    /**
     * 
     * Consulta los traslados asignados a la empresa transportista especificada.
     * @param empresaTransportista la empresa transportista a la que se le asignaron los traslados
     * @return una lista de objetos Traslado asignados a la empresa transportista especificada
     * @throws PersistenciaException si hay algún problema al realizar la consulta
     */
    List<Traslado> consultaTrasladosAsingados(EmpresaTransportista empresaTransportista) throws PersistenciaException;

    /**
     * Devuelve una lista de Vehiculos pertenecientes a una EmpresaTransportista especifica.
     * @param empresaTransportista la EmpresaTransportista de la cual se quieren obtener los Vehiculos.
     * @return una lista de Vehiculos pertenecientes a la EmpresaTransportista especificada.
     * @throws PersistenciaException si ocurre un error al acceder a la base de datos.
     */
    List<Vehiculo> consultarVehiculosEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws PersistenciaException;
    
    
        /**
     * Recupera todas las empresas transportistas almacenadas en alguna fuente de datos persistente
     * @return una lista de objetos EmpresaTransportista
     * @throws PersistenciaException si hay algún problema al realizar la consulta
     */
    List<EmpresaTransportista> consultaTodasEmpresasTransportistas() throws PersistenciaException;
    /**
     * Inserta un nuevo objeto EmpresaTransportista en alguna fuente de datos persistente
     * @param o el objeto EmpresaTransportista que se va a insertar
     * @return el objeto EmpresaTransportista recién insertado
     * @throws PersistenciaException si hay algún problema al realizar la inserción
     */
    EmpresaTransportista insertar(EmpresaTransportista o) throws PersistenciaException;
    /**
     * Autentica una empresa transportista en algun sistema
     * @param correo la dirección de correo electrónico de la empresa transportista
     * @param contrasena la contraseña de la empresa transportista
     * @return el objeto EmpresaTransportista correspondiente a los datos de inicio de sesión si son válidos
     * @throws PersistenciaException si los datos de inicio de sesión son incorrectos o hay algún problema al realizar la autenticación
     */
    EmpresaTransportista loginEmpresaTrasnportista(String correo,String contrasena)throws PersistenciaException;
}
