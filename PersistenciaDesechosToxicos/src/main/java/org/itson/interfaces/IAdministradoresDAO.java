/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import com.dominio.Administrador;
import org.itson.excepciones.PersistenciaException;

/**
 * Interfaz que contiene los metodos AdministradoresDAO
 * @author edemb
 */
public interface IAdministradoresDAO {
    Administrador loginAdministrador(String correo,String contrasena)throws PersistenciaException;
}
