/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.bd;

import com.mongodb.client.MongoDatabase;
import org.itson.implementaciones.daos.AdministradoresDAO;
import org.itson.implementaciones.daos.CuentasDAO;
import org.itson.implementaciones.daos.EmpresasTransportistasDAO;
import org.itson.implementaciones.daos.ProductoresDAO;
import org.itson.implementaciones.daos.QuimicosDAO;
import org.itson.implementaciones.daos.ResiduosDAO;
import org.itson.implementaciones.daos.SolicitudesDAO;
import org.itson.interfaces.IConsultasDAO;
import org.itson.interfaces.IEmpresasTrasnportistasDAO;
import org.itson.interfaces.IProductoresDAO;
import org.itson.interfaces.IQuimicosDAO;
import org.itson.interfaces.IResiduosDAO;
import org.itson.interfaces.ISolicitudesDAO;

/**
 *
 * @author oscar
 */
public class DAOFactory {

    public DAOFactory() {
    }

    /*
    public IConsultasDAO getAdministradoresDAO() {
        return new AdministradoresDAO(this.MANEJADOR_CONEXION);
    }

    public IConsultasDAO getCuentasDAO() {
        return new CuentasDAO(this.MANEJADOR_CONEXION);
    }

    public IConsultasDAO getDireccionesDAO() {
        return new CuentasDAO(this.MANEJADOR_CONEXION);
    }

    public IConsultasDAO getEmpresaTransportistaDAO() {
        return new EmpresasTransportistasDAO(this.MANEJADOR_CONEXION);
    }
     */
    /**
     * Regresa una instania de ProductoresDAO
     *
     * @return Una isntancie de ProductoresDAO
     */
    public static IProductoresDAO getProductoresDAO() {
        return ProductoresDAO.getInstanceProductoresDAO();
    }

    /**
     * Regresa una instancia de QuimicosDAO
     *
     * @return Una IQuimicosDAO con una instancia de QuimicosDAO
     */
    public static IQuimicosDAO getQuimicosDAO() {
        return QuimicosDAO.getInstanceQuimicosDAO();
    }

    /**
     * Regresa una isntancia de ResiduosDAO
     *
     * @return Una IResiduoDAO con una instancia de ResiduosDAO
     */
    public static IResiduosDAO getResiduoDAO() {
        return ResiduosDAO.getInstanceResiduosDAO();
    }

    /**
     * Regresa una instancia de EmpresasTrasnportistasDAO
     *
     * @return Una IEmpresasTrasnportistasDAO con una instancia de
     * EmpresasTrasnportsitasDAO
     */
    public static IEmpresasTrasnportistasDAO getEmpresasTrasnportistasDAO() {
        return EmpresasTransportistasDAO.getInstanceEmpresasTrasnportistasDAO();
    }

    /**
     * Regresa una instancia de SolicitudesDAO
     * @return Una instancia de SolicitudesDAO
     */
    public static ISolicitudesDAO getSolicitudesDAO() {
        return SolicitudesDAO.getInstanceSolicitudesDAO();
    }
}
