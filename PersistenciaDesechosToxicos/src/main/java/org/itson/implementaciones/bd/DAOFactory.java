package org.itson.implementaciones.bd;

import org.itson.implementaciones.daos.AdministradoresDAO;
import org.itson.implementaciones.daos.EmpresasTransportistasDAO;
import org.itson.implementaciones.daos.ProductoresDAO;
import org.itson.implementaciones.daos.QuimicosDAO;
import org.itson.implementaciones.daos.ResiduosDAO;
import org.itson.implementaciones.daos.SolicitudesDAO;
import org.itson.implementaciones.daos.TransportesDAO;
import org.itson.implementaciones.daos.TrasladosDAO;
import org.itson.implementaciones.daos.VehiculosDAO;
import org.itson.interfaces.IAdministradoresDAO;
import org.itson.interfaces.IEmpresasTrasnportistasDAO;
import org.itson.interfaces.IProductoresDAO;
import org.itson.interfaces.IQuimicosDAO;
import org.itson.interfaces.IResiduosDAO;
import org.itson.interfaces.ISolicitudesDAO;
import org.itson.interfaces.ITransporteDAO;
import org.itson.interfaces.ITrasladosDAO;
import org.itson.interfaces.IVehiculosDAO;

/**
 * Descripción de la clase: Esta clase nos ayuda a obtener las instancias
 * diferentes de los objetos DAO en el sistema mediante los metodos estaticos
 * correpondientes a un tipo de obejto negocio
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class DAOFactory {

    public DAOFactory() {
    }

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
     *
     * @return Una instancia de SolicitudesDAO
     */
    public static ISolicitudesDAO getSolicitudesDAO() {
        return SolicitudesDAO.getInstanceSolicitudesDAO();
    }

    /**
     * Regresa una instancia de TrasladosDAO
     *
     * @return Una instancia de TrasladosDAO
     */
    public static ITrasladosDAO getTrasladosDAO() {
        return TrasladosDAO.getInstanceTrasladosDAO();
    }

    /**
     * Regresa una instancia de VehiculosDAO
     *
     * @return Una instancia de VehiculosDAO
     */
    public static IVehiculosDAO getVehiculosDAO() {
        return VehiculosDAO.getInstanceVehiculosDAO();
    }

    /**
     * Regresa una instancia de TransportesDAO
     *
     * @return Una instancia de TransporteDAO
     */
    public static ITransporteDAO getTransporteDAO() {
        return TransportesDAO.getInstanceTransportesDAO();
    }

    /**
     * Regersa una instancia de AdministradoresDAO
     *
     * @return Una instancia de AdministradoresDAO
     */
    public static IAdministradoresDAO getAdministradoresDAO() {
        return AdministradoresDAO.getInstanceAdministradoresDAO();
    }
}
