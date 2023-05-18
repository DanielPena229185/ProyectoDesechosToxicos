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
 * Descripción de la clase: Clase para obtener instancias de las interfaces de negocio
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioFactory{

    /**
     * Constructor de la clase NegocioFactory.
     */
    public NegocioFactory() {

    }

    /**
     * Obtiene una instancia de la interfaz INegocioResiduo.
     *
     * @return Una instancia de la interfaz INegocioResiduo.
     */
    public static INegocioResiduo getNegocioResiduo() {
        return new NegocioResiduo();
    }

    /**
     * Obtiene una instancia de la interfaz INegocioProductor.
     *
     * @return Una instancia de la interfaz INegocioProductor.
     */
    public static INegocioProductor getNegocioProductor() {
        return new NegocioProductor();
    }

    /**
     * Obtiene una instancia de la interfaz INegocioQuimico.
     *
     * @return Una instancia de la interfaz INegocioQuimico.
     */
    public static INegocioQuimico getNegocioQuimico() {
        return new NegocioQuimico();
    }
    
    /**
     * Obtiene una instancia de la interfaz INegocioSolicitud.
     *
     * @return Una instancia de la interfaz INegocioSolicitud.
     */
    public static INegocioSolicitud getNegocioSolicitud(){
        return new NegocioSolicitud();
    }
    
    /**
     * Obtiene una instancia de la interfaz INegocioTransporte.
     *
     * @return Una instancia de la interfaz INegocioTransporte.
     */
    public static INegocioTransporte getNegocioTransporte(){
        return new NegocioTransporte();
    }
    
    /**
     * Obtiene una instancia de la interfaz INegocioTraslado.
     *
     * @return Una instancia de la interfaz INegocioTraslado.
     */
    public static INegocioTraslado getNegocioTraslado(){
        return new NegocioTraslado();
    }
    
    /**
     * Obtiene una instancia de la interfaz INegocioVehiculo.
     *
     * @return Una instancia de la interfaz INegocioVehiculo.
     */
    public static INegocioVehiculo getNegocioVehiculo(){
        return new NegocioVehiculo();
    }
    
    /**
     * Obtiene una instancia de la interfaz INegocioAdministrador.
     *
     * @return Una instancia de la interfaz INegocioAdministrador.
     */
    public static INegocioAdministrador getNegocioAdministrador(){
        return new NegocioAdministrador();
    }
    
    /**
     * Obtiene una instancia de la interfaz INegocioEmpresasTransportista.
     *
     * @return Una instancia de la interfaz INegocioEmpresasTransportista.
     */
    public static INegocioEmpresasTransportista getNegocioEmpresaTransportista(){
        return new NegocioEmpresaTransportista();
    }
}


