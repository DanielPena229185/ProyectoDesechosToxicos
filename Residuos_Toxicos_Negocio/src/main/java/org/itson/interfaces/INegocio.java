/**
 * INegocio.java
 * 10 may. 2023 18:21:44
 */
package org.itson.interfaces;

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
}
