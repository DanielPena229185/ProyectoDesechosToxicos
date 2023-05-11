/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import com.dominio.Productor;
import org.itson.DTO.ProductorDTO;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author edemb
 */
public interface IProductoresDAO {
    Productor insertar(Productor o) throws PersistenciaException;
    Productor consultarLogin(String correo,String contrasena) throws PersistenciaException;
}
