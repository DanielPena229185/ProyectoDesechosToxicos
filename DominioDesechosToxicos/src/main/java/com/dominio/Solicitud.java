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
    private Date fecha_solicitada;

    /**
     * Residuo de la Solicitud
     */
    private Residuo residuo;

    /**
     * Productor que registro la Solicitud
     */
    private Productor productor;

    /**
     * Constructor por defecto
     */
    public Solicitud() {
    }

    /**
     * Constructor que instancia todos los atributos de la clase Solicitud
     *
     * @param id identificador que se le asignara a la Solicitud
     * @param estado estado que se le asignara a la Solicitud
     * @param fechaSolicitada fecha solicitada que se le asginara a la Solcitud
     * @param residuo Residuo que se le asignara a la Solicitud
     * @param productor Productor que se le asignara a la Solicitud
     */
    public Solicitud(ObjectId id, String estado, Date fecha_solicitada, Residuo residuo, Productor productor) {
        this.id = id;
        this.estado = estado;
        this.fecha_solicitada = fecha_solicitada;
        this.residuo = residuo;
        this.productor = productor;
    }

    /**
     * Constructor que instancia todos los atributos de la clase Solicitud menos
     * el Id
     *
     * @param estado estado que se le asignara a la Solicitud
     * @param fechaSolicitada fecha solicitada que se le asginara a la Solcitud
     * @param residuo Residuo que se le asignara a la Solicitud
     * @param productor Productor que se le asignara a la Solicitud
     */
    public Solicitud(String estado, Date fecha_solicitada, Residuo residuo, Productor productor) {
        this.estado = estado;
        this.fecha_solicitada = fecha_solicitada;
        this.residuo = residuo;
        this.productor = productor;
    }

    /**
     * Regresa un ObjectiId de la Solicitud
     *
     * @return el ObjectoId de la Solicitud
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Le asignar un ObjectId a la Solicitud
     *
     * @param id ObjectId a asignar
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa el estado de la Solicitud
     *
     * @return el estado de la Solicitud
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Le asigna un estado a la Solicitud
     *
     * @param estado que se le asignara a la Solicitud
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Regresa la fecha en la que fue solicitada la Solicitud
     *
     * @return objeto Date que es la fecha de la Solicitud
     */
    public Date getFecha_Solicitada() {
        return fecha_solicitada;
    }

    /**
     * Le asigna una fecha solicitada a al Solicitud
     *
     * @param fechaSolicitada objeto Date a asignar a la Solicitud
     */
    public void setFechaSolicitada(Date fecha_solicitada) {
        this.fecha_solicitada = fecha_solicitada;
    }

}
