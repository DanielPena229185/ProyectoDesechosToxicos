/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import com.dominio.Traslado;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author edemb
 */
public interface ITrasladosDAO {

    Traslado insertar(Traslado traslado) throws PersistenciaException;
}
