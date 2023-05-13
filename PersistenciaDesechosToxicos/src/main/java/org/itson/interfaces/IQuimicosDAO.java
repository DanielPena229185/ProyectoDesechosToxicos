/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import com.dominio.Quimico;
import java.util.List;
import org.itson.excepciones.PersistenciaException;

/**
 * Descriocion de la interfaz: Interfaz con las operaciones de QuimicosDAO
 * 
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public interface IQuimicosDAO {

    /**
     * Implementacion de insertar un Quimico
     * @param o Quimico a insertar
     * @return El Quimico insertado
     * @throws PersistenciaException en caso de algun error 
     */
    Quimico insertar(Quimico o) throws PersistenciaException;

    /**
     * Implementacion de consutar los Quimicos
     * @return Una lista de Quimicos
     * @throws PersistenciaException en caso de algun error; 
     */
    List<Quimico> consultarTodosLosQuimicos() throws PersistenciaException;
}
