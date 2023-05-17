/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import java.util.Date;
import java.util.List;
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
    private Estado estado;

    /**
     * Fecha en la que fue solicitada
     */
    private Date fecha_Solicitada;

    /**
     * Residuo de la Solicitud
     */
    private List<Residuo> residuos;

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
     * Constructor con identificador, fecha solicitada, residuos y productor
     *
     * @param id Identificador de la solicitud
     * @param fechaSolicitada Fecha solicitada
     * @param estado Estado de la solicitud
     * @param residuo Residuo que tiene la solicitud
     * @param productor Productor que realizó la solicitud
     */
    public Solicitud(ObjectId id, Date fechaSolicitada, Estado estado, List<Residuo> residuo, Productor productor) {
        this.id = id;
        this.fecha_Solicitada = fechaSolicitada;
        this.estado = estado;
        this.residuos = residuo;
        this.productor = productor;
    }

    /**
     * Constructor con fecha en la que solicitó, residuos y productor que lo
     * solicitó
     *
     * @param fechaSolicitada Fecha en la que se solicitó
     * @param estado Estado de la solicitud
     * @param residuo Residuo de la solicitó
     * @param productor id del Productor que solicitó
     */
    public Solicitud(Date fechaSolicitada, Estado estado, List<Residuo> residuo, Productor productor) {
        this.fecha_Solicitada = fechaSolicitada;
        this.estado = estado;
        this.residuos = residuo;
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
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establecer el estado de la solicitud
     *
     * @param estado Estado de la solicitud
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Regresa la fecha en la que fue solicitada la Solicitud
     *
     * @return objeto Date que es la fecha de la Solicitud
     */
    public Date getFecha_Solicitada() {
        return fecha_Solicitada;
    }

    /**
     * Le asigna una fecha solicitada a al Solicitud
     *
     * @param fecha_solicitada objeto Date a asignar a la Solicitud
     */
    public void setFecha_Solicitada(Date fecha_solicitada) {
        this.fecha_Solicitada = fecha_solicitada;
    }

    /**
     * Obtener residuos
     *
     * @return Residuo
     */
    public List<Residuo> getResiduos() {
        return residuos;
    }

    /**
     * Establecer residuos a la solicitud
     *
     * @param residuos Residuo
     */
    public void setResiduos(List<Residuo> residuos) {
        this.residuos = residuos;
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

    @Override
    public String toString() {
        String texto = "";
        for (Residuo r : residuos) {
            texto += r.getNombre()+", ";
        }
        return texto;
    }

}
