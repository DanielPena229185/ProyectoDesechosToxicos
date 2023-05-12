/**
 * NegocioFachada.java
 * 12 may. 2023 15:08:49
 */
package org.itson.implementacion;

import org.itson.interfaces.INegocio;
import org.itson.interfaces.INegocioResiduo;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioFachada implements INegocio{

    INegocioResiduo negocioResiduo;

    /**
     * Constructor por default
     */
    public NegocioFachada() {
        negocioResiduo = NegocioFactory.getNegocioResiduo();
    }
}
