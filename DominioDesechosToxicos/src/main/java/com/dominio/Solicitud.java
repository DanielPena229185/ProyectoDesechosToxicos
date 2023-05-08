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
     * Constructor con identificador, fecha solicitada, residuo y productor
     *
     * @param id Identificador de la solicitud
     * @param fechaSolicitada Fecha solicitada
     * @param residuo Residuo que tiene la solicitud
     * @param productor Productor que realizó la solicitud
     */
    public Solicitud(ObjectId id, Date fechaSolicitada, Residuo residuo, Productor productor) {
        this.id = id;
        this.fecha_solicitada = fechaSolicitada;
        this.residuo = residuo;
        this.productor = productor;
    }

    /**
     * Constructor con fecha en la que solicitó, residuo y productor que lo
     * solicitó
     *
     * @param fechaSolicitada Fecha en la que se solicitó
     * @param residuo Residuo de la solicitó
     * @param productor Productor que solicitó
     */
    public Solicitud(Date fechaSolicitada, Residuo residuo, Productor productor) {
        this.fecha_solicitada = fechaSolicitada;
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
     * Establecer el identificador de la solicitud
     *
     * @param id Identificador de la solicitud
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtener el estado de la solicitud
     *
     * @return Estado de la solicitud
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establecer el estado de la solicitud
     *
     * @param estado Estado de la solicitud
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

    /**
     * Obtener residuo
     *
     * @return Residuo
     */
    public Residuo getResiduo() {
        return residuo;
    }

    /**
     * Establecer residuo a la solicitud
     *
     * @param residuo Residuo
     */
    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    /**
     * Obtener el productor
     *
     * @return Productor
     */
    public Productor getProductor() {
        return productor;
    }

    /**
     * Establecer al productor
     *
     * @param productor Productor
     */
    public void setProductor(Productor productor) {
        this.productor = productor;
    }

}
