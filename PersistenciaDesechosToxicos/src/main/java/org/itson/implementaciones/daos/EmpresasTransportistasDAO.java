/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.daos;

import com.dominio.EmpresaTransportista;
import com.dominio.Tipo;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.interfaces.IConsultasDAO;
import org.itson.interfaces.IEmpresasTrasnportistasDAO;

/**
 * Clase que se encarga de realizar todas las operaciones CRUD de las empresas
 * transportistas.
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class EmpresasTransportistasDAO implements IEmpresasTrasnportistasDAO {

    private static MongoCollection<EmpresaTransportista> COLECCION;
    private static EmpresasTransportistasDAO empresasTransportistasDAO;

    private EmpresasTransportistasDAO() {
        this.COLECCION = ConexionBD.getBaseDatos().getCollection("empresas", EmpresaTransportista.class);
    }

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
//
//    /**
//     * Método que actualiza una Empresa transportista de la base de datos.
//     *
//     * @param o Empresa transportista a actualizar.
//     * @param s Empresa transportista con los datos actualizados.
//     * @return Empresa transportista actualizado.
//     * @throws PersistenciaException En dado caso de que no se pueda actualizar
//     * la Empresa transportista en la base de datos.
//     */
//    @Override
//    public EmpresaTransportista actualizar(EmpresaTransportista o, EmpresaTransportista s) throws PersistenciaException {
//        try {
//            this.COLECCION.updateOne(Filters.eq(o.getId()), new Document("$set", s));
//        } catch (PersistenciaException e) {
//            throw new PersistenciaException("No se pudo actualizar la empresa transportista.\n" + e.getMessage());
//        }
//
//        return o;
//    }
//
//    /**
//     * Método que elimina a una Empresa transportista de la base de datos.
//     *
//     * @param o Empresa transportista a eliminar.
//     * @return Empresa transportista eliminado.
//     * @throws PersistenciaException En dado caso de que no se pueda eliminar la
//     * Empresa transportista de la base de datos.
//     */
//    @Override
//    public EmpresaTransportista eliminar(EmpresaTransportista o) throws PersistenciaException {
//        try {
//            this.COLECCION.deleteOne(Filters.eq(o.getId()));
//        } catch (PersistenciaException e) {
//            throw new PersistenciaException("No se pudo eliminar la empresa transportista." + e.getMessage());
//        }
//
//        return o;
//    }
//
//    /**
//     * Método que consulta a todas las Empresas transportistas de la base de
//     * datos.
//     *
//     * @return Lista de todas las Empresas transportistas.
//     * @throws PersistenciaException Si no se encuentra a ninguna Empresa
//     * transportista. en la base de datos.
//     */
//    @Override
//    public List<EmpresaTransportista> consultar() throws PersistenciaException {
//        List<EmpresaTransportista> empresasTransportistas = new ArrayList<>();
//        this.COLECCION.find().into(empresasTransportistas);
//
//        if (empresasTransportistas.size() <= 0) {
//            throw new PersistenciaException("No hay empresas transportistas registradas.");
//        }
//
//        return empresasTransportistas;
//    }
//
//    /**
//     * Método que busca a una Empresa transportista por Id.
//     *
//     * @param id id a buscar.
//     * @return Empresa transportista encontrada.
//     * @throws PersistenciaException Se genera una excepción si no existe la
//     * Empresa transportista a buscar.
//     */
//    @Override
//    public EmpresaTransportista consultar(ObjectId id) throws PersistenciaException {
//        List<EmpresaTransportista> empresasTransportistas = new ArrayList<>();
//        this.COLECCION.find(Filters.eq(id)).into(empresasTransportistas);
//
//        if (empresasTransportistas.size() <= 0) {
//            throw new PersistenciaException("No existe la empresa transportista a buscar.");
//        }
//
//        return empresasTransportistas.get(0);
//    }
//
//    /**
//     * Método que consulta a todas las Empresas transportistas que coincidan con
//     * los parámetros dados.
//     *
//     * @param parametros Empresa transportista con los parámetros especificados.
//     * @return Lista de Empresas transportistas que coincidan.
//     * @throws PersistenciaException Si no se encuentra ninguna coincidencia en
//     * la base de datos.
//     */
//    @Override
//    public List<EmpresaTransportista> consultar(EmpresaTransportista parametros) throws PersistenciaException {
//        List<EmpresaTransportista> empresasTransportistas = new ArrayList<>();
//        List<Bson> filtros = new ArrayList<>();
//
//        if (parametros.getNombre() != null) {
//            filtros.add(Filters.regex("nombre", ".*" + parametros.getNombre() + ".*", "i"));
//        }
//
//        if (parametros.getTipo() != null) {
//            filtros.add(Filters.eq("tipo", parametros.getTipo()));
//        }
//
//        if (parametros.getDirecciones() != null) {
//            filtros.add(Filters.eq("direcciones", parametros.getDirecciones()));
//        }
//
//        if (parametros.getTransportes() != null) {
//            filtros.add(Filters.eq("transportes", parametros.getTransportes()));
//        }
//
//        if (parametros.getVehiculos() != null) {
//            filtros.add(Filters.eq("vehiculos", parametros.getVehiculos()));
//        }
//
//        this.COLECCION.find(Filters.and(filtros)).into(empresasTransportistas);
//
//        if (empresasTransportistas.size() <= 0) {
//            throw new PersistenciaException("No se pudieron encontrar empresas transportistas con los parámetros dados.");
//        }
//
//        return empresasTransportistas;
//    }

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

    @Override
    public EmpresaTransportista loginEmpresaTrasnportista(String correo, String contrasena) throws PersistenciaException {
        try {
            List<Document> filtro = new ArrayList<>();

            filtro.add(new Document("cuenta", new Document("contrasena", contrasena).append("correo", correo)));
            filtro.add(new Document("tipo", Tipo.TRANSPORTISTA.toString()));

            EmpresaTransportista transportista = COLECCION.find(new Document("$and", filtro)).first();
            return transportista;

        } catch (MongoException e) {
            throw new PersistenciaException("Error al querer iniciar sesion" + e.getMessage());
        }
    }
}
