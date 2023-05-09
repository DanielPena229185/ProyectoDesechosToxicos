/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.bd;

import com.mongodb.client.MongoDatabase;
import org.itson.implementaciones.daos.AdministradoresDAO;
import org.itson.implementaciones.daos.CuentasDAO;
import org.itson.implementaciones.daos.EmpresasTransportistasDAO;
import org.itson.interfaces.IConsultasDAO;

/**
 *
 * @author oscar
 */
public class DAOFactory {
   
    private final MongoDatabase MANEJADOR_CONEXION;
    
    public DAOFactory() {
        this.MANEJADOR_CONEXION = new ConexionBD().getBaseDatos();
    }
    
    public IConsultasDAO getAdministradoresDAO() {
        return new AdministradoresDAO(this.MANEJADOR_CONEXION);
    }
    
    public IConsultasDAO getCuentasDAO() {
        return new CuentasDAO(this.MANEJADOR_CONEXION);
    }
    
    public IConsultasDAO getDireccionesDAO() {
        return new CuentasDAO(this.MANEJADOR_CONEXION);
    }
    
    public IConsultasDAO getEmpresaTransportistaDAO(){
        return new EmpresasTransportistasDAO(MANEJADOR_CONEXION);
    }
}
