/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa la Solicitud
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class Solicitud {

    /**
     * Identificador de la Solicitud
     */
    private ObjectId id;

    /**
     * Estado de la solicitud
     */
    private String estado;

    /**
     * Fecha en la que fue solicitada
     */
    private Date fechaSolicitada;

    public Solicitud() {
    }

    public Solicitud(ObjectId id, String estado, Date fechaSolicitada) {
        this.id = id;
        this.estado = estado;
        this.fechaSolicitada = fechaSolicitada;
    }

    public Solicitud(String estado, Date fechaSolicitada) {
        this.estado = estado;
        this.fechaSolicitada = fechaSolicitada;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaSolicitada() {
        return fechaSolicitada;
    }

    public void setFechaSolicitada(Date fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }

    
    
}
