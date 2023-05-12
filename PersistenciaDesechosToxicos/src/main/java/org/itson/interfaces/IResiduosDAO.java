/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import com.dominio.Residuo;
import java.util.List;
import org.itson.DTO.ResiduoDTO;
import org.itson.excepciones.PersistenciaException;

/**
 * Interfaz con las operacionde de ResiduoDAO
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public interface IResiduosDAO {

    /**
     * Implementacion de Insertar un Residuo
     *
     * @param o Residuo a insertar
     * @return El Residuo insertado
     * @throws PersistenciaException en caso de algun error
     */
    Residuo insertar(Residuo o) throws PersistenciaException;
    
    /**
     * Implementacion de consultar Residuos
     *
     * @param residuo Objeto ResiduoDTO con el que se consultara el/los
     * Residuo(s)
     * @return Una Lista de Residuos
     * @throws PersistenciaException en caso de algun error
     */
    List<Residuo> consultar(ResiduoDTO residuo) throws PersistenciaException;
}
