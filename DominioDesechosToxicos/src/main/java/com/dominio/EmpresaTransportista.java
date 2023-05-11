package com.dominio;

import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa una empresa transportista hija
 * de la clase padre que es Empresa.
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class EmpresaTransportista extends Empresa {

    /**
     * Lista de vehículos
     */
    private List<Vehiculo> vehiculos;

    /**
     * Lista de transportes
     */
    private List<Transporte> transportes;

    /**
     * Constuctor por default
     */
    public EmpresaTransportista() {
        super();
    }

    /**
     * Constructor con lista de vehículos, lista de transportes, identificador
     * de la empresa, nombre de la empresa, lista de direcciones de la empresa
     *
     * @param vehiculos Lista de vehículos
     * @param transportes Lista de transportes
     * @param id Identificador de la empresa
     * @param tipo Tipo de empresa
     * @param nombre Nombre de la empresa
     * @param cuenta Cuenta de la empresa
     * @param direcciones Lista de direcciones de la empresa
     */
    public EmpresaTransportista(ObjectId id, List<Vehiculo> vehiculos, List<Transporte> transportes, Tipo tipo, String nombre, Cuenta cuenta, List<Direccion> direcciones) {
        super(id, tipo, nombre, cuenta, direcciones);
        this.vehiculos = vehiculos;
        this.transportes = transportes;
    }

    /**
     * Constructor con lista de vehículos, lista de transportes, nombre de la
     * empresa, lista de direcciones de la empresa
     *
     * @param vehiculos Lista de vehículos
     * @param transportes Lista de transportes
     * @param tipo Tipo de empresa
     * @param nombre Nombre de la empresa
     * @param cuenta Cuenta de la empresa
     * @param direcciones Lista de direcciones de la empresa
     */
    public EmpresaTransportista(List<Vehiculo> vehiculos, List<Transporte> transportes, Tipo tipo, String nombre, Cuenta cuenta, List<Direccion> direcciones) {
        super(tipo, nombre, cuenta, direcciones);
        this.vehiculos = vehiculos;
        this.transportes = transportes;
    }

    /**
     * Constructor con lista de vehículos, lista de transportes, nombre de la
     * empresa
     *
     * @param vehiculos Lista de vehículos
     * @param transportes Lista de transportes
     * @param tipo Tipo de empresa
     * @param nombre Nombre de la empresa
     * @param cuenta Cuenta de la empresa
     *
     */
    public EmpresaTransportista(List<Vehiculo> vehiculos, List<Transporte> transportes, Tipo tipo, String nombre, Cuenta cuenta) {
        super(tipo, nombre, cuenta);
        this.vehiculos = vehiculos;
        this.transportes = transportes;
    }

    /**
     * Obtener lista de vehículos
     *
     * @return Lista de vehículos
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Establecer lista de vehículos
     *
     * @param vehiculos Lista de vehículos
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Agregar vehículo a la lista de vehículos
     *
     * @param vehiculo Vehículo a agregar
     * @return Lista de vehículos
     */
    public List<Vehiculo> agregarVehiculo(Vehiculo vehiculo) {
        if (this.vehiculos == null) {
            this.vehiculos = new LinkedList<>();
        }
        this.vehiculos.add(vehiculo);
        return this.vehiculos;
    }

    /**
     * Obtener lista de transportes
     *
     * @return Lista de transportes
     */
    public List<Transporte> getTransportes() {
        return transportes;
    }

    /**
     * Establecer lista de transportes
     *
     * @param transportes Lista de trasportes
     */
    public void setTransportes(List<Transporte> transportes) {
        this.transportes = transportes;
    }

    /**
     * Agregar transporte a la lista de transportes
     *
     * @param transporte Transporte a agregar
     * @return Lista de transportes
     */
    public List<Transporte> agregarTransporte(Transporte transporte) {
        if (this.transportes == null) {
            this.transportes = new LinkedList<>();
        }
        this.transportes.add(transporte);
        return this.transportes;
    }

}
