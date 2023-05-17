/**
 * NegocioFactory.java
 * 10 may. 2023 18:24:01
 */
package org.itson.implementacion;

import org.itson.interfaces.INegocioAdministrador;
import org.itson.interfaces.INegocioEmpresasTransportista;
import org.itson.interfaces.INegocioProductor;
import org.itson.interfaces.INegocioQuimico;
import org.itson.interfaces.INegocioResiduo;
import org.itson.interfaces.INegocioSolicitud;
import org.itson.interfaces.INegocioTransporte;
import org.itson.interfaces.INegocioTraslado;
import org.itson.interfaces.INegocioVehiculo;

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
    
    public static INegocioSolicitud getNegocioSolicitud(){
        return new NegocioSolicitud();
    }
    
    public static INegocioTransporte getNegocioTransporte(){
        return new NegocioTransporte();
    }
    
    public static INegocioTraslado getNegocioTraslado(){
        return new NegocioTraslado();
    }
    
    public static INegocioVehiculo getNegocioVehiculo(){
        return new NegocioVehiculo();
    }
    
    public static INegocioAdministrador getNegocioAdministrador(){
        return new NegocioAdministrador();
    }
    
    public static INegocioEmpresasTransportista getNegocioEmpresaTransportista(){
        return new NegocioEmpresaTransportista();
    }
}
