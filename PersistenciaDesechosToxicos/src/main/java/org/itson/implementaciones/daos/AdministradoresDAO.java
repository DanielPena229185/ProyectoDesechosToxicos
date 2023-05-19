package org.itson.implementaciones.daos;

import com.dominio.Administrador;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.interfaces.IAdministradoresDAO;

/**
 * Descripción de la clase: Clase que se encarga de realizar todas las
 * operaciones CRUD de los administradores.
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class AdministradoresDAO implements IAdministradoresDAO {

    /**
     * Instancia AdministradoresDAO
     */
    private static AdministradoresDAO administradoresDAO;
    /**
     * Coleccion de Administradores
     */
    private static MongoCollection<Administrador> COLECCION;

    /**
     * Constructor
     */
    private AdministradoresDAO() {
        COLECCION = ConexionBD.getBaseDatos().getCollection("administradores", Administrador.class);
    }

    /**
     * Regresa una instancia de AdministradoresDAO
     *
     * @return una instancia de AdministradoresDAO
     */
    public static AdministradoresDAO getInstanceAdministradoresDAO() {
        if (administradoresDAO == null) {
            administradoresDAO = new AdministradoresDAO();
        }
        return administradoresDAO;
    }
    /**
     * Realiza el inicio de sesión de un administrador utilizando el correo y la contraseña proporcionados.
     *
     * @param correo El correo del administrador.
     * @param contrasena La contraseña del administrador.
     * @return El objeto Administrador correspondiente al inicio de sesión exitoso, o null si las credenciales son incorrectas.
     * @throws PersistenciaException Si se produce un error al intentar iniciar sesion
     */
    @Override
    public Administrador loginAdministrador(String correo, String contrasena) throws PersistenciaException {
        try {
            Administrador administrador = COLECCION.find(new Document("cuenta", new Document("correo", correo).append("contrasena", contrasena))).first();
            return administrador;

        } catch (MongoException e) {
            throw new PersistenciaException("Error al querer iniciar sesion" + e.getMessage());
        }
    }

}
