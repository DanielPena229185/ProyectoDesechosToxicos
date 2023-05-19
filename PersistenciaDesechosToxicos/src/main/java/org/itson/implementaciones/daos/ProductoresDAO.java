/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.Productor;
import com.dominio.Tipo;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.interfaces.IProductoresDAO;

/**
 * Descripción de la clase: Clase que se encarga de realizar todas las operaciones CRUD de las empresas
 * productoras.
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class ProductoresDAO implements IProductoresDAO {
    /**
     * Coleccion de mongoBD que contiene los datos de productor
     */
    private static MongoCollection<Productor> COLECCION;
    /**
     * Instancia de la clase ProductoresDAO
     */
    private static ProductoresDAO productoresDAO;

    /**
     * Método constructor que inicializa la clase para empezar con las
     * operaciones.
     */
    private ProductoresDAO() {
        this.COLECCION = ConexionBD.getBaseDatos().getCollection("empresas", Productor.class);
    }

    /**
     * Regresa una instancia de ProductoresDAO
     *
     * @return una instancia de ProductoresDAO
     */
    public static ProductoresDAO getInstanceProductoresDAO() {
        if (productoresDAO == null) {
            productoresDAO = new ProductoresDAO();
        }
        return productoresDAO;
    }

    /**
     * Método que inserta una empresa productora en la base de datos.
     *
     * @param o Empresa productora a insertar.
     * @return Empresa productora insertada.
     * @throws PersistenciaException En dado caso de que no se pueda insertar
     * correctamente.
     */
    @Override
    public Productor insertar(Productor o) throws PersistenciaException {
        try {
            this.COLECCION.insertOne(o);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar el productor en la base de datos.\n", e.getCause());
        }

        return o;
    }

    /**
     * Consuta al Productor por medio de correro y contrasena
     *
     * @param correo Productor a buscar
     * @param contrasena Contraseña a buscar
     * @return Productor buscado, null en caso de no encontrar nada
     * @throws PersistenciaException en caso de algun error
     */
    @Override
    public Productor consultarLogin(String correo, String contrasena) throws PersistenciaException {
        try {
            List<Document> filtro = new ArrayList<>();

            filtro.add(new Document("cuenta", new Document("correo", correo).append("contrasena", contrasena)));
//            filtro.add(new Document("cuenta", new Document("contrasena", contrasena).append("correo", correo)));
            filtro.add(new Document("tipo", Tipo.PRODUCTO.toString()));

            Productor p = COLECCION.find(new Document("$and", filtro)).first();
            return p;
        } catch (MongoException e) {
            throw new PersistenciaException("Error no se pudo consultar los datos:" + e.getMessage());
        }
    }

}
