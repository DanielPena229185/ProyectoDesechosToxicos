/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa un Vehiculo
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class Vehiculo {

    /**
     * Id del Vehiculo
     */
    private ObjectId id;
    /**
     * modelo del Vehiculo
     */
    private String modelo;
    /**
     * marca del Vehiculo
     */
    private String marca;
    /**
     * empresa trasnportista que le pertenece el Vehiculo
     */
    private EmpresaTransportista empresa_trasnportista;

    /**
     * Constructor por defecto
     */
    public Vehiculo() {
    }

    /**
     * Constructor que le asigna valores a todos los atributos del Vehiculo
     *
     * @param id a asignar
     * @param modelo a asignar
     * @param marca a asignar
     * @param empresa_trasnportista a asignar
     */
    public Vehiculo(ObjectId id, String modelo, String marca, EmpresaTransportista empresa_trasnportista) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.empresa_trasnportista = empresa_trasnportista;
    }

    /**
     * Constructor que le asigna valores a todos los atributos del Vehiculo
     * menos el id
     *
     * @param modelo a asignar
     * @param marca a asignar
     * @param empresa_trasnportista a asignar
     */
    public Vehiculo(String modelo, String marca, EmpresaTransportista empresa_trasnportista) {
        this.modelo = modelo;
        this.marca = marca;
        this.empresa_trasnportista = empresa_trasnportista;
    }

    /**
     * Regresa el id del Vehiculo
     *
     * @return el id del Vehiculo
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Le asigna un ObjectId al Vehiculo
     *
     * @param id a asignar
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa el modelo del Vehiculo
     *
     * @return modelo del Vehiculo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Le asigna un modelo al Vehiculo
     *
     * @param modelo a asignar
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Regresa la marca del Vehiculo
     *
     * @return la marca del Vehiculo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Le asigna una marca al Vehiculo
     *
     * @param marca a asignar
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Regresa la empresa trasnportista del Vehiculo
     *
     * @return EmpresaTrasnportista del Vehiculo
     */
    public EmpresaTransportista getEmpresa_trasnportista() {
        return empresa_trasnportista;
    }

    /**
     * Le asigna una EmpresaTransportista al Vehiculo
     *
     * @param empresa_trasnportista a asignar
     */
    public void setEmpresa_trasnportista(EmpresaTransportista empresa_trasnportista) {
        this.empresa_trasnportista = empresa_trasnportista;
    }

}
