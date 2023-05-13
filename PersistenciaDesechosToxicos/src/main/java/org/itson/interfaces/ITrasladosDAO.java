
package org.itson.interfaces;

import com.dominio.EmpresaTransportista;
import com.dominio.Traslado;
import java.util.List;
import org.itson.excepciones.PersistenciaException;

/**
 * Descriocion de la interfaz: Esta es una interfaz para el acceso a datos de los Traslados
 * @author edemb
 */
public interface ITrasladosDAO {
    /**
     * Inserta un Traslado en la base de datos.
     * @param traslado el Traslado que se desea insertar.
     * @return el Traslado insertado con el identificador generado por la base de datos.
     * @throws PersistenciaException si ocurre un error al acceder a la base de datos.
     */
    Traslado insertarTraslado(Traslado traslado) throws PersistenciaException;
    /**
     * Devuelve una lista de Traslados asignados a una EmpresaTransportista especifica.
     * @param empresaTransportista la EmpresaTransportista de la cual se quieren obtener los Traslados asignados.
     * @return una lista de Traslados asignados a la EmpresaTransportista especificada.
     * @throws PersistenciaException si ocurre un error al acceder a la base de datos.
     */
    List<Traslado> consultaTrasladosAsingados(EmpresaTransportista empresaTransportista)throws PersistenciaException;
}
