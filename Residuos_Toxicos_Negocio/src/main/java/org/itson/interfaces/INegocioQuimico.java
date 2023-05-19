/**
 * INegocioQuimico.java
 * 11 may. 2023 20:16:52
 */
package org.itson.interfaces;

import com.dominio.Quimico;
import java.util.List;
import org.itson.excepciones.NegocioException;

/**
 * Descripción de la clase: interfaz que contiene los métodos definidos para
 * realizar las operaciones en las clases que la implementen
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public interface INegocioQuimico {

    /**
     * Inserta un nuevo químico en el sistema.
     *
     * @param quimico El objeto Quimico que se desea insertar.
     * @return El objeto Quimico insertado en el sistema.
     * @throws NegocioException Si ocurre un error en la lógica del negocio
     * durante la inserción.
     */
    public Quimico insertarQuimico(Quimico quimico) throws NegocioException;

    /**
     * Consulta la lista de químicos disponibles en el sistema.
     *
     * @return Una lista de objetos Quimico que representan los químicos
     * disponibles.
     * @throws NegocioException Si ocurre un error en la lógica del negocio
     * durante la consulta.
     */
    public List<Quimico> consultarQuimicos() throws NegocioException;

}
