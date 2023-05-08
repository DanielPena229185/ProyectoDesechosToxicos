/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa el Traslado
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class Traslado {
    /**
     * Id del Traslado
     */
    private ObjectId id;
    /**
     * Cantidad de Residuos
     */
    private Integer cantidad_residuo;
    /**
     * Residuo que tendra el Traslado
     */
    private Residuo residuo;
    
    /**
     * Aminisitrador que registro el Traslado
     */
    private Administrador administrador;
    /**
     * Direccion a la que se dirige el Traslado
     */
    private Direccion direccion;
    /**
     * Tranporte que se encargara del Traslado
     */
    private Transporte transporte;

    /**
     * Constructor por defecto
     */
    public Traslado() {
    }

    /**
     * Constructor que le asigna valores a todos los atributos del Traslado
     * @param id identificador a asignar
     * @param cantidadResiduo cantidad de residuos a asignar
     * @param residuo Residuo a asignar
     * @param administrador Administrador a asignar
     * @param direccion Direccion a asignar
     * @param transporte Trasnporte a asignar
     */
    public Traslado(ObjectId id, Integer cantidad_residuo, Residuo residuo, Administrador administrador, Direccion direccion, Transporte transporte) {
        this.id = id;
        this.cantidad_residuo = cantidad_residuo;
        this.residuo = residuo;
        this.administrador = administrador;
        this.direccion = direccion;
        this.transporte = transporte;
    }

       /**
     * Constructor que le asigna valores a todos los atributos del Traslado menos el Id
     * @param cantidadResiduo cantidad de residuos a asignar
     * @param residuo Residuo a asignar
     * @param administrador Administrador a asignar
     * @param direccion Direccion a asignar
     * @param transporte Trasnporte a asignar
     */
    public Traslado(Integer cantidad_residuo, Residuo residuo, Administrador administrador, Direccion direccion, Transporte transporte) {
        this.cantidad_residuo = cantidad_residuo;
        this.residuo = residuo;
        this.administrador = administrador;
        this.direccion = direccion;
        this.transporte = transporte;
    }

    /**
     * Regresa el id del Traslado
     * @return ObjectId del Traslado
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Le asigna un id al Traslado
     * @param id ObjectId a asignar
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa la cantidad de residuos del Traslado
     * @return la cantidad de Residuos del Traslado
     */
    public Integer getCantidad_Residuo() {
        return cantidad_residuo;
    }

    /**
     * Le asigna una cantidad de residuos al Traslado
     * @param cantidadResiduo a asignar
     */
    public void setCantidad_Residuo(Integer cantidad_residuo) {
        this.cantidad_residuo = cantidad_residuo;
    }

    /**
     * Regresa el Residuo del Traslado
     * @return Residuo del Traslado
     */
    public Residuo getResiduo() {
        return residuo;
    }

    /**
     * Le asigna el Residuo al Traslado
     * @param residuo objeto Residuo a asignar
     */
    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    /**
     * Regresa el Administrador del Traslado
     * @return el Administrador del Traslado
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * Le asigna un Administrador al Traslado
     * @param administrador a asignar
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Regresa la Direccion del Traslado
     * @return Direccion del Traslado
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Le asigna una Direccion al Traslado
     * @param direccion objeto Direccion a asignar
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Regresa el Trasnporte del Traslado
     * @return Transporte del Traslado
     */
    public Transporte getTransporte() {
        return transporte;
    }

    /**
     * Le asigna un Transporte al Traslado
     * @param transporte a asignar
     */
    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }
    
    
}
