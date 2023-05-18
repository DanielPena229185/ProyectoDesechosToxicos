/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import java.util.List;
import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa el Transporte
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class Transporte {

    /**
     * Identificador del Transporte
     */
    private ObjectId id;

    /**
     * Kilometros que recorrera el Transporte
     */
    private Float kilometros;

    /**
     * Coste del Transporte
     */
    private Float coste;

    /**
     * Vehiculos asignado al Transporte
     */
    private List<Vehiculo> vehiculos;

    /**
     * Empresa Trasnportista que registro el Transporte
     */
//    private EmpresaTransportista empresa_transportista;
    private EmpresaTransportista empresa_transportista;

    /**
     * Constructor por defecto
     */
    public Transporte() {
    }

    /**
     * Constructor que le asigna valor a todos los atributos del Transporte
     *
     * @param id identificador a asignar
     * @param kilometros kilometros a asignar
     * @param coste coste a asignar
     * @param vehiculos Vehiculos a asignar
     * @param empresa_transportista
     */
    public Transporte(ObjectId id, Float kilometros, Float coste, List<Vehiculo> vehiculos, EmpresaTransportista empresa_transportista) {
        this.id = id;
        this.kilometros = kilometros;
        this.coste = coste;
        this.vehiculos = vehiculos;
//        this.empresa_transportista = empresa_transportista;
    }

    /**
     * Constructor que le asigna valor a todos los atributos del Transporte
     * menos el Id
     *
     * @param kilometros kilometros a asignar
     * @param coste coste a asignar
     * @param vehiculos Vehiculo a asignar
     * @param empresa_transportista
     */
    public Transporte(Float kilometros, Float coste, List<Vehiculo> vehiculos, EmpresaTransportista empresa_transportista) {
        this.kilometros = kilometros;
        this.coste = coste;
        this.vehiculos = vehiculos;
//        this.empresa_transportista = empresa_transportista;
    }

    /**
     * Regresa el Id del Transporte
     *
     * @return ObjectId del Transporte
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Le asigna un ObjectoId al Transporte
     *
     * @param id ObjectId a asignar
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa los kilometros del Transporte
     *
     * @return kilometros del Transporte
     */
    public Float getKilometros() {
        return kilometros;
    }

    /**
     * Le asigna los kilometros al Transportes
     *
     * @param kilometros a asignar
     */
    public void setKilometros(Float kilometros) {
        this.kilometros = kilometros;
    }

    /**
     * Regresa el coste del Transporte
     *
     * @return coste del Transporte
     */
    public Float getCoste() {
        return coste;
    }

    /**
     * Le asigna el coste al Transporte
     *
     * @param coste a asignar
     */
    public void setCoste(Float coste) {
        this.coste = coste;
    }

    /**
     * Regresa los Vehiculos del Transporte
     *
     * @return Lista de Vehiculos del Transporte
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Le asigna un Vehiculos al Transporte
     *
     * @param vehiculos Vehiculos a asignar
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

//    /**
//     * Regresa la Empresa Transportista del Transporte
//     *
//     * @return Empresa Trasnportista del Transporte
//     */
//    public EmpresaTransportista getEmpresa_Transportista() {
//        return empresa_transportista;
//    }
//
//    /**
//     * Le asigna una EmpresaTrasnportista al Transporte
//     *
//     * @param empresaTransportista objeto EmpresaTransportista a asignar
//     */
//    public void setEmpresaTransportista(EmpresaTransportista empresa_transportista) {
//        this.empresa_transportista = empresa_transportista;
//    }

    public EmpresaTransportista getEmpresa_transportista() {
        return empresa_transportista;
    }

    public void setEmpresa_transportista(EmpresaTransportista empresa_transportista) {
        this.empresa_transportista = empresa_transportista;
    }
    
    

}
