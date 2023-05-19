/**
 * INegocioTransporte.java
 * 12 may. 2023 16:28:15
 */
package org.itson.interfaces;

import com.dominio.Transporte;
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
public interface INegocioTransporte {

    /**
     * Inserta un nuevo transporte en el sistema.
     *
     * @param transporte El objeto Transporte que se desea insertar.
     * @return El objeto Transporte insertado en el sistema.
     * @throws NegocioException Si ocurre un error en la lógica del negocio
     * durante la inserción.
     */
    public Transporte insertarTransporte(Transporte transporte) throws NegocioException;

}
