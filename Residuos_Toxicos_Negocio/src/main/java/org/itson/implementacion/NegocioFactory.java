/**
 * NegocioFactory.java
 * 10 may. 2023 18:24:01
 */
package org.itson.implementacion;

import org.itson.interfaces.INegocio;
import org.itson.interfaces.INegocioProductor;
import org.itson.interfaces.INegocioQuimico;
import org.itson.interfaces.INegocioResiduo;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioFactory{

    /**
     *
     */
    public NegocioFactory() {

    }

    public static INegocioResiduo getNegocioResiduo() {
        return new NegocioResiduo();
    }

    public static INegocioProductor getNegocioProductor() {
        return new NegocioProductor();
    }

    public static INegocioQuimico getNegocioQuimico() {
        return new NegocioQuimico();
    }
}
