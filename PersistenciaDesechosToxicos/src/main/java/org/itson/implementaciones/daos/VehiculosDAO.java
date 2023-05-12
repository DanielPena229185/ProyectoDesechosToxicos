/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.EmpresaTransportista;
import com.dominio.Vehiculo;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.interfaces.IVehiculosDAO;

/**
 *
 * @author edemb
 */
public class VehiculosDAO implements IVehiculosDAO {

    /**
     * Instancia VehiculosDAO
     */
    private static VehiculosDAO vehiculosDAO;
    /**
     * Coleccion de Vehiculos
     */
    private static MongoCollection<Vehiculo> COLECCION;

    /**
     * Constructor
     */
    private VehiculosDAO() {
        COLECCION = ConexionBD.getBaseDatos().getCollection("vehiculos", Vehiculo.class);
    }

    /**
     * Regresa una instancia de VehiculosDAO
     *
     * @return instancia de VehiculosDAO
     */
    public static VehiculosDAO getInstanceVehiculosDAO() {
        if (vehiculosDAO == null) {
            vehiculosDAO = new VehiculosDAO();
        }
        return vehiculosDAO;
    }

    /**
     * Inserta un Vehiculo
     *
     * @param vehiculo Vehiculo a insertar
     * @return El Vehiculo insertado
     * @throws PersistenciaException en caso de algun error
     */
    @Override
    public Vehiculo insertarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        if (vehiculo == null) {
            throw new PersistenciaException("Error el vehiculo es null");
        }
        try {
            COLECCION.insertOne(vehiculo);
            return vehiculo;
        } catch (MongoException e) {
            throw new PersistenciaException("Error no se pudo insertar el Vehiculo: " + e.getMessage());
        }

    }

    /**
     * Consulta los Vehiuculos que le pertenescan a una empresa
     *
     * @param empresaTransportista a la que le consultaresmo sus Vehiculos
     * @return Una Lista de Vehiculos
     * @throws PersistenciaException en caso de algun error
     */
    @Override
    public List<Vehiculo> consultarVehiculosEmpresaTrasnportadora(EmpresaTransportista empresaTransportista) throws PersistenciaException {
        if (empresaTransportista == null) {
            throw new PersistenciaException("La empresa Transportista es null");
        }
        try {
            List<Vehiculo> vehiculos = new ArrayList<>();

            COLECCION.find(new Document("empresa_trasnportista._id", empresaTransportista.getId())).into(vehiculos);
            return vehiculos;

        } catch (MongoException e) {
            throw new PersistenciaException("Error no se pudieron consultar los Vehiculos: " + e.getMessage());
        }
    }
}
