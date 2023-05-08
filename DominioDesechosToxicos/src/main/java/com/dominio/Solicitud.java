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
<<<<<<< HEAD
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
=======
     * Residuo que solicitó
     */
    private Residuo residuo;

    /**
     * Productor que generó la solicitud
     */
    private Productor productor;

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
        this.fechaSolicitada = fechaSolicitada;
>>>>>>> b7ba47758215b7a1d8fe2668dea51d78f3bdfa4a
        this.residuo = residuo;
        this.productor = productor;
    }

    /**
<<<<<<< HEAD
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
=======
     * Constructor con fecha en la que solicitó, residuo y productor que lo
     * solicitó
     *
     * @param fechaSolicitada Fecha en la que se solicitó
     * @param residuo Residuo de la solicitó
     * @param productor Productor que solicitó 
     */
    public Solicitud(Date fechaSolicitada, Residuo residuo, Productor productor) {
        this.fechaSolicitada = fechaSolicitada;
>>>>>>> b7ba47758215b7a1d8fe2668dea51d78f3bdfa4a
        this.residuo = residuo;
        this.productor = productor;
    }

    /**
<<<<<<< HEAD
     * Regresa un ObjectiId de la Solicitud
     *
     * @return el ObjectoId de la Solicitud
=======
     * Obtener identificador de la solicitud
     * 
     * @return Identificador de la solicitud
>>>>>>> b7ba47758215b7a1d8fe2668dea51d78f3bdfa4a
     */
    public ObjectId getId() {
        return id;
    }

    /**
<<<<<<< HEAD
     * Le asignar un ObjectId a la Solicitud
     *
     * @param id ObjectId a asignar
=======
     * Establecer el identificador de la solicitud
     * 
     * @param id Identificador de la solicitud
>>>>>>> b7ba47758215b7a1d8fe2668dea51d78f3bdfa4a
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
<<<<<<< HEAD
     * Regresa el estado de la Solicitud
     *
     * @return el estado de la Solicitud
=======
     * Obtener el estado de la solicitud
     * 
     * @return Estado de la solicitud
>>>>>>> b7ba47758215b7a1d8fe2668dea51d78f3bdfa4a
     */
    public String getEstado() {
        return estado;
    }

    /**
<<<<<<< HEAD
     * Le asigna un estado a la Solicitud
     *
     * @param estado que se le asignara a la Solicitud
=======
     * Establecer el estado de la solicitud
     * 
     * @param estado Estado de la solicitud
>>>>>>> b7ba47758215b7a1d8fe2668dea51d78f3bdfa4a
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
<<<<<<< HEAD
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

=======
     * Obtener la fecha de la solicitud
     * 
     * @return La fecha de la solicitud
     */
    public Date getFechaSolicitada() {
        return fechaSolicitada;
    }

    /**
     * Establecer la fecha solicitada
     * 
     * @param fechaSolicitada Fecha en la que se solicitó
     */
    public void setFechaSolicitada(Date fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
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

>>>>>>> b7ba47758215b7a1d8fe2668dea51d78f3bdfa4a
}
