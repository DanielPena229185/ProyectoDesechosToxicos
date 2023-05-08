/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones.bd;

import org.itson.implementaciones.daos.AdministradoresDAO;
import org.itson.implementaciones.daos.CuentasDAO;
import org.itson.interfaces.IConexionBD;
import org.itson.interfaces.IConsultasDAO;

/**
 *
 * @author oscar
 */
public class DAOFactory {
    private final IConexionBD MANEJADOR_CONEXION;
    
    public DAOFactory(IConexionBD MANEJADOR_CONEXION) {
        this.MANEJADOR_CONEXION = MANEJADOR_CONEXION;
    }
    
    public IConsultasDAO getAdministradoresDAO() {
        return new AdministradoresDAO(this.MANEJADOR_CONEXION);
    }
    
    public IConsultasDAO getCuentasDAO() {
        return new CuentasDAO(this.MANEJADOR_CONEXION);
    }
}
