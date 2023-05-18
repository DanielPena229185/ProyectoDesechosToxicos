
package org.itson.implementaciones.daos;

import com.dominio.Productor;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IConsultasDAO;

/**
 * Descripcion de la clase: Esta clase se encarga de interactuar con la base de datos para realizar 
 * operaciones de insertar, actualizar, eliminar y consultar del objeto Productor
 * @author edemb
 */
public class EmpresaProductoraDAO implements IConsultasDAO<Productor> {
    /**
     * Coleccion de mongoBD que contiene los datos de los productores
     */
    private final MongoCollection<Productor> COLECCION;
    /**
     * Método constructor que inicializa la clase para empezar con las
     * operaciones.
     * @param BASE_DATOS Base de datos a la que se conecta.
     */
    public EmpresaProductoraDAO(MongoDatabase BASE_DATOS) {
        this.COLECCION = BASE_DATOS.getCollection("empresas", Productor.class);
    }
    /**
     * nserta un objeto Productor en la base de datos correspondiente
     * @param o el objeto Productor a insertar
     * @return el objeto Productor insertado
     * @throws PersistenciaException si ocurre un error durante la inserción en la base de datos
     */
    @Override
    public Productor insertar(Productor o) throws PersistenciaException {
        try {
            this.COLECCION.insertOne(o);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar la empresa productora a la base de datos.\n", e.getCause());
        }

        return o;
    }
    /**
     * Actualiza un objeto Productor en la base de datos correspondiente.
     * @param o el objeto Productor a actualizar
     * @param s el objeto Productor con los valores actualizados
     * @return el objeto Productor actualizado
     * @throws PersistenciaException si ocurre un error durante la actualización en la base de datos 
     */
    @Override
    public Productor actualizar(Productor o, Productor s) throws PersistenciaException {
        try {
            o.setNombre(s.getNombre());
            o.setResiduos(s.getResiduos());
            o.setSolicitudes(s.getSolicitudes());
            o.setDirecciones(s.getDirecciones());
            return o;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("No se pudo actualizar la empresa productora.\n" + e.getMessage());
        }
    }
    /**
     * Elimina un objeto Productor de la base de datos correspondiente
     * @param o el objeto Productor a eliminar
     * @return el objeto Productor eliminado
     * @throws PersistenciaException si ocurre un error durante la eliminacion en la base de datos
     */
    @Override
    public Productor eliminar(Productor o) throws PersistenciaException {
        try {
            this.COLECCION.deleteOne(eq("_id", o.getId()));
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo eliminar la empresa productora de la base de datos.\n", e.getCause());
        }
        return o;
    }
    /**
     * Realiza una consulta en la base de datos para obtener una lista de todos los objetos Productor
     * @return una lista de objetos Productor obtenidos de la base de datos
     * @throws PersistenciaException si ocurre un error durante la consulta en la base de datos
     */
    @Override
    public List<Productor> consultar() throws PersistenciaException {
         try {
             return this.COLECCION.find().into(new ArrayList<>());
         } catch (MongoException e) {
             throw new PersistenciaException("No se pudieron consultar las empresas productoras de la base de datos.\n", e.getCause());
         }
    }
    /**
     * Realiza una consulta en la base de datos para obtener el objeto Productor correspondiente al ObjectId especificado
     * @param id el ObjectId del objeto Productor a buscar en la base de datos
     * @return el objeto Productor correspondiente al ObjectId especificado
     * @throws PersistenciaException si ocurre un error durante la consulta en la base de datos
     */
    @Override
    public Productor consultar(ObjectId id) throws PersistenciaException {
        try {
            return this.COLECCION.find(eq("_id", id)).first();
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo consultar la empresa productora de la base de datos.\n", e.getCause());
        }
    }
    /**
     * Consulta las empresas productoras que cumplen con los criterios dados en el objeto Productor pasado como parametro
     * @param parametros un objeto Productor con los criterios de busqueda
     * @return una lista de objetos Productor que cumplen con los criterios de busqueda
     * @throws PersistenciaException si se produce un error en la conexion con la base de datos
     */
    @Override
    public List<Productor> consultar(Productor parametros) throws PersistenciaException {
       try {
           BasicDBObject filtro = new BasicDBObject();
           if(parametros.getId() != null){
            filtro.append("_id", parametros.getId());
           }
           if(parametros.getNombre() != null){
            filtro.append("nombre", parametros.getNombre());
           }
           if(parametros.getResiduos() != null){
            filtro.append("residuos", parametros.getResiduos());
           }
           if(parametros.getSolicitudes() != null){
            filtro.append("solicitudes", parametros.getSolicitudes());
           }
           if(parametros.getDirecciones() != null){
            filtro.append("direcciones", parametros.getDirecciones());
           }
           return this.COLECCION.find(filtro).into(new ArrayList<>());
       } catch (MongoException e) {
           throw new PersistenciaException("No se pudieron consultar las empresas productoras de la base de datos.\n", e.getCause());
       } 
    }

}
