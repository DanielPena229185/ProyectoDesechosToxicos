/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

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
     * Vehiculo asignado al Transporte
     */
    private Vehiculo vehiculo;

    /**
     * Id de Empresa Trasnportista que registro el Transporte
     */
    private ObjectId id_empresa_transportista;

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
     * @param vehiculo Vehiculo a asignar
     * @param id_empresaTransportista id del EmpresaTransportista a asignar
     */
    public Transporte(ObjectId id, Float kilometros, Float coste, Vehiculo vehiculo, ObjectId id_empresa_transportista) {
        this.id = id;
        this.kilometros = kilometros;
        this.coste = coste;
        this.vehiculo = vehiculo;
        this.id_empresa_transportista = id_empresa_transportista;
    }

    /**
     * Constructor que le asigna valor a todos los atributos del Transporte
     * menos el Id
     *
     * @param kilometros kilometros a asignar
     * @param coste coste a asignar
     * @param vehiculo Vehiculo a asignar
     * @param id_empresaTransportista id de EmpresaTransportista a asignar
     */
    public Transporte(Float kilometros, Float coste, Vehiculo vehiculo, ObjectId id_empresa_transportista) {
        this.kilometros = kilometros;
        this.coste = coste;
        this.vehiculo = vehiculo;
        this.id_empresa_transportista = id_empresa_transportista;
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
     * Regresa el Vehiculo del Transporte
     *
     * @return Vehiculo del Transporte
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Le asigna un Vehiculo al Transporte
     *
     * @param vehiculo objeto Vehiculo a asignar
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Regresa id de la Empresa Transportista del Transporte
     *
     * @return Empresa Trasnportista del Transporte
     */
    public ObjectId getId_Empresa_Transportista() {
        return id_empresa_transportista;
    }

    /**
     * Le asigna una id de EmpresaTrasnportista al Transporte
     *
     * @param empresaTransportista objeto EmpresaTransportista a asignar
     */
    public void setId_EmpresaTransportista(ObjectId id_empresa_transportista) {
        this.id_empresa_transportista = id_empresa_transportista;
    }

}
