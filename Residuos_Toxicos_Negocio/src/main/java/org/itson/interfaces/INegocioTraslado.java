/**
 * INegocioTraslados.java
 * 13 may. 2023 16:14:39
 */
package org.itson.interfaces;

import com.dominio.EmpresaTransportista;
import com.dominio.Traslado;
import java.util.List;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;

/**
 * Descripción de la clase: interfaz que contiene los métodos definidos para
 * realizar las operaciones en las clases que la implementen
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public interface INegocioTraslado {

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
     * @throws PersistenciaException si ocurre un error al acceder a la base de
     * datos.
     */
    List<Traslado> consultaTrasladosAsingados(EmpresaTransportista empresaTransportista) throws NegocioException;

}
