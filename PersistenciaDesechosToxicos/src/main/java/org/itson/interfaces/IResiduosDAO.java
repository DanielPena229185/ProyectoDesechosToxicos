package org.itson.interfaces;

import com.dominio.Residuo;
import java.util.List;
import org.itson.DTO.ResiduoDTO;
import org.itson.excepciones.PersistenciaException;

/**
 * Descriocion de la interfaz: Interfaz con las operacionde de ResiduoDAO
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
