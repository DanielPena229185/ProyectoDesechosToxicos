package org.itson.implementaciones.daos;

import com.dominio.EmpresaTransportista;
import com.dominio.Tipo;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.interfaces.IEmpresasTrasnportistasDAO;

/**
 * Descripción de la clase: Clase que se encarga de realizar todas las
 * operaciones CRUD de las empresas transportistas.
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class EmpresasTransportistasDAO implements IEmpresasTrasnportistasDAO {

    /**
     * Coleccion de mongoBD que contiene los datos de empresa transportista
     */
    private static MongoCollection<EmpresaTransportista> COLECCION;
    /**
     * Instancia de la clase EmpresaTransportistaDAO
     */
    private static EmpresasTransportistasDAO empresasTransportistasDAO;

    /**
     * Método constructor que inicializa la clase para empezar con las
     * operaciones.
     *
     * @param BASE_DATOS Base de datos a la que se conecta.
     */
    private EmpresasTransportistasDAO() {
        this.COLECCION = ConexionBD.getBaseDatos().getCollection("empresas", EmpresaTransportista.class);
    }

    /**
     * Devuelve la instancia unica de la clase EmpresasTransportistasDAO,
     * creándola si aun no existe
     *
     * @return la instancia unica de la clase EmpresasTransportistasDAO
     */
    public static EmpresasTransportistasDAO getInstanceEmpresasTrasnportistasDAO() {
        if (empresasTransportistasDAO == null) {
            empresasTransportistasDAO = new EmpresasTransportistasDAO();
        }
        return empresasTransportistasDAO;
    }

    /**
     * Método que inserta una empresa transportista en la base de datos.
     *
     * @param o Empresa transportista a insertar.
     * @return Empresa transportista insertada.
     * @throws PersistenciaException En dado caso de que no se pueda insertar
     * correctamente.
     */
    @Override
    public EmpresaTransportista insertar(EmpresaTransportista o) throws PersistenciaException {
        try {
            this.COLECCION.insertOne(o);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar la empresa transportista a la base de datos.\n", e.getCause());
        }

        return o;
    }

    /**
     * Consulta todas las empresas transportistas registradas en la base de
     * datos
     *
     * @return una lista de objetos EmpresaTransportista
     * @throws PersistenciaException si ocurre un error al consultar la base de
     * datos
     */
    @Override
    public List<EmpresaTransportista> consultaTodasEmpresasTransportistas() throws PersistenciaException {
        try {
            List<EmpresaTransportista> transportistas = new ArrayList<>();
            COLECCION.find(new Document("tipo", Tipo.TRANSPORTISTA.toString())).into(transportistas);
            return transportistas;
        } catch (MongoException e) {
            throw new MongoException("Error al consultar las empresas trasnportisas: " + e.getMessage());
        }
    }

    /**
     * Realiza el inicio de sesion de una empresa transportista en el sistema
     *
     * @param correo El correo electrónico de la empresa transportista.
     * @param contrasena La contraseña de la empresa transportista.
     * @return La empresa transportista si las credenciales son válidas, o null
     * si no son válidas.
     * @throws PersistenciaException Si ocurre un error al intentar iniciar
     * sesión.
     */
    @Override
    public EmpresaTransportista loginEmpresaTrasnportista(String correo, String contrasena) throws PersistenciaException {
        try {
            List<Document> filtro = new ArrayList<>();

            filtro.add(new Document("cuenta", new Document("correo", correo).append("contrasena", contrasena)));
            filtro.add(new Document("tipo", Tipo.TRANSPORTISTA.toString()));

            EmpresaTransportista transportista = COLECCION.find(new Document("$and", filtro)).first();
            return transportista;

        } catch (MongoException e) {
            throw new PersistenciaException("Error al querer iniciar sesion" + e.getMessage());
        }
    }
}
