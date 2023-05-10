/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa el Tratamiento
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class Tratamiento {
    /**
     * Id del Tratamiento
     */
    private ObjectId id;
    /**
     * Descripcion del Tratamiento
     */
    private String descripcion;
    /**
     * Residuo del Tratamiento
     */
    private Residuo residuo;
    /**
     * id de la Empresa Trasnportista que registro el Tratamiento
     */
    private ObjectId id_empresa_transportista;

    /**
     * Constructor por defecto
     */
    public Tratamiento() {
    }

    /**
     * Constructor que le asigna valor a todos los atributos del Tratamiento
     * @param id a asignar
     * @param descripcion a asignar
     * @param residuo a asignar
     * @param id_empresa_transportista a asignar 
     */
    public Tratamiento(ObjectId id, String descripcion, Residuo residuo, ObjectId id_empresa_transportista) {
        this.id = id;
        this.descripcion = descripcion;
        this.residuo = residuo;
        this.id_empresa_transportista = id_empresa_transportista;
    }

    /**
     * Constructor que le asigna valor a todos los atributos del Tratamiento menos el id
     * @param descripcion a asignar
     * @param residuo a asignar
     * @param empresa_transportista a asignar 
     */
    public Tratamiento(String descripcion, Residuo residuo, ObjectId id_empresa_transportista) {
        this.descripcion = descripcion;
        this.residuo = residuo;
        this.id_empresa_transportista = id_empresa_transportista;
    }

    /**
     * Regresa el id del Tratamiento
     * @return el id del Tratamiento
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Le asigna un ObjectId al Tratamiento
     * @param id ObjectId a asignar
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa la descripcion del Tratamiento
     * @return la descripcion del Tratamiento
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Le asigna una descripcion del Tratamiento
     * @param descripcion a asignar al Tratamiento
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Regresa el Residuo del Tratamiento
     * @return Residuo del Tratamiento
     */
    public Residuo getResiduo() {
        return residuo;
    }

    /**
     * Asigna un Residuo al Tratamiento
     * @param residuo a asignar
     */
    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    /**
     * Regresa la empresa trasnportista del Tratamiento
     * @return la empresa transportista del Tratamiento
     */
    public ObjectId getId_Empresa_transportista() {
        return id_empresa_transportista;
    }

    /**
     * Le asigna la empresa trasnportadora al Tratamiento
     * @param empresa_transportista a asignar
     */
    public void setId_Empresa_transportista(ObjectId id_empresa_transportista) {
        this.id_empresa_transportista = id_empresa_transportista;
    }
    
    
}
