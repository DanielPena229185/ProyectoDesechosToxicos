package org.itson.implementaciones.daos;

import com.dominio.EmpresaTransportista;
import com.dominio.Traslado;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.interfaces.ITrasladosDAO;

/**
 * Descripción de la clase: La clase realiza operaciones como insertar un
 * traslado o consultar los traslados asignados a una empresa transportista
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class TrasladosDAO implements ITrasladosDAO {

    /**
     * Instancia de TrasladoDAO
     */
    private static TrasladosDAO trasladosDAO;
    /**
     * Coleccion de los traslados
     */
    private static MongoCollection<Traslado> COLECCION;

    /**
     * Constructor
     */
    private TrasladosDAO() {
        COLECCION = ConexionBD.getBaseDatos().getCollection("traslados", Traslado.class);
    }

    /**
     * Regresa una instancia de TrasladosDAO
     *
     * @return una instancia de TrasladoDAO
     */
    public static TrasladosDAO getInstanceTrasladosDAO() {
        if (trasladosDAO == null) {
            trasladosDAO = new TrasladosDAO();
        }
        return trasladosDAO;
    }

    /**
     * Ingresa un Traslado
     *
     * @param traslado Traslado a insertarTraslado
     * @return el Traslado insertado
     * @throws PersistenciaException en caso de algun error
     */
    @Override
    public Traslado insertarTraslado(Traslado traslado) throws PersistenciaException {
        if (traslado == null) {
            throw new PersistenciaException("El traslado era null");
        }
        try {
            COLECCION.insertOne(traslado);
            return traslado;
        } catch (MongoException e) {
            throw new PersistenciaException("Error no se pudo insertar el Traslado: " + e.getMessage());
        }
    }

    /**
     * Consulta todos los Traslados que fueron asignados a una
     * empresaTrasnportista
     *
     * @param empresaTransportista a la que buscaran sus Traslados asignados
     * @return Una Lista de Traslados asignados
     * @throws PersistenciaException en caso de algun error
     */
    @Override
    public List<Traslado> consultaTrasladosAsingados(EmpresaTransportista empresaTransportista) throws PersistenciaException {
        if (empresaTransportista == null) {
            throw new PersistenciaException("Error la empresa trasnportista es null");
        }
        List<Traslado> traslados = new ArrayList<>();
        COLECCION.find(new Document("empresas_transportistas", new Document("$elemMatch", new Document("_id", empresaTransportista.getId())))).into(traslados);
        return traslados;

    }

}
