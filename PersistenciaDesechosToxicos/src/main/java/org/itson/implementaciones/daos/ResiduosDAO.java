package org.itson.implementaciones.daos;

import com.dominio.Quimico;
import com.dominio.Residuo;
import com.dominio.Tipo;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.DTO.ResiduoDTO;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.interfaces.IResiduosDAO;

/**
 * Descripcion de la clase: Clase que implementa todas las operaciones de
 * Residuo
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class ResiduosDAO implements IResiduosDAO {

    /**
     * Coleccion de los residuos
     */
    private static MongoCollection<Residuo> COLECCION;
    /**
     * Instancia de ResiduoDAO
     */
    private static ResiduosDAO residuosDAO;

    /**
     * Costructor que consulta la coleccion de los residuos
     *
     */
    private ResiduosDAO() {
        if (COLECCION == null) {
            COLECCION = ConexionBD.getBaseDatos().getCollection("residuos", Residuo.class);
        }
    }

    /**
     * Regresa una instancia de ResiduoDAO
     *
     * @return instancia de ResiduoDAO
     */
    public static ResiduosDAO getInstanceResiduosDAO() {
        if (residuosDAO == null) {
            residuosDAO = new ResiduosDAO();
        }
        return residuosDAO;
    }

    /**
     * Ingresa un Residuo a la base de datos
     *
     * @param o Objeto Residuo a ingresar
     * @return El Residuo ingresado
     * @throws PersistenciaException en caso
     */
    @Override
    public Residuo insertar(Residuo o) throws PersistenciaException {
        try {
            COLECCION.insertOne(o);
            return o;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error no se pudo insertar el residuo: " + e.getMessage());
        }
    }

    /**
     * Consulta si existen Reiduos coincidentes con los datos que contiene
     * ResiduoDTO
     *
     * @param filtro Redisuo a buscar similitudes de informacion
     * @return Una lista de Residuos
     * @throws PersistenciaException en caso de que haya un error
     */
    @Override
    public List<Residuo> consultar(ResiduoDTO filtro) throws PersistenciaException {
        if (filtro == null) {
            throw new PersistenciaException("No se obtuvieron parámetros válidos.");
        }

        try {
            List<Document> filter = new ArrayList<>();
            List<Residuo> residuos = new ArrayList<>();

            if (filtro.getId_EmpresaProductora() != null || filtro.getNombreEmpresaProductora() != null) {
                filter.add(new Document("productor.tipo", Tipo.PRODUCTO.toString()));
            }

            if (filtro.getId_EmpresaProductora() != null) {
                filter.add(new Document("productor._id", filtro.getId_EmpresaProductora()));
            }

            if (filtro.getNombreEmpresaProductora() != null) {
                filter.add(new Document("productor.nombre", filtro.getNombreEmpresaProductora()));
            }

            if (filtro.getNombre() != null) {
                filter.add(new Document("nombre", filtro.getNombre()));

            }

            if (filtro.getClave() != null) {
                filter.add(new Document("codigo", filtro.getClave()));
            }

            if (filtro.getQuimicos() != null) {
                List<ObjectId> lista = new ArrayList<>();

                for (Quimico q : filtro.getQuimicos()) {
                    lista.add(q.getId());
                }

                filter.add(new Document("quimicos._id", new Document("$all", lista)));
            }

            COLECCION.find(new Document("$and", filter)).into(residuos);

            return residuos;
        } catch (MongoException e) {
            throw new PersistenciaException("Error no se pudo consultar los quimicos: " + e.getMessage());
        }
    }
}
