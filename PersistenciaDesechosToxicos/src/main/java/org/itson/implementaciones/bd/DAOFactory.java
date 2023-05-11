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
import org.itson.interfaces.IConsultasDAO;
import org.itson.interfaces.IQuimicosDAO;
import org.itson.interfaces.IResiduosDAO;

/**
 *
 * @author oscar
 */
public class DAOFactory {

    private DAOFactory() {
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

    public IConsultasDAO getProductoresDAO() {
        return new ProductoresDAO(this.MANEJADOR_CONEXION);
    }
     */
    /**
     * Regresa una instancia de QuimicosDAO
     *
     * @return Una IQuimicosDAO con una instancia de QuimicosDAO
     */
    public static IQuimicosDAO getQuimicosDAO() {
        IQuimicosDAO quimicoDAO = QuimicosDAO.getInstanceQuimicosDAO();
        return quimicoDAO;
    }

    /**
     * Regresa una isntancia de ResiduosDAO
     *
     * @return Una IResiduoDAO con una instancia de ResiduosDAO
     */
    public static IResiduosDAO getResiduoDAO() {
        IResiduosDAO residuoDAO = ResiduosDAO.getInstanceResiduosDAO();
        return residuoDAO;
    }
}
