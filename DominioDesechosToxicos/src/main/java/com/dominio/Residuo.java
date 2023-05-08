/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import java.util.List;
import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa un residuo compuesto de
 * químicos
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class Residuo {

    /**
     * Identificador del residuo
     */
    private ObjectId id;

    /**
     * Cantidad de residuo
     */
    private Float cantidad;

    /**
     * Código del residuo
     */
    private String codigo;

    /**
     * Lista de quimicos
     */
    private List<Quimico> quimicos;

    /**
     * Constructor por defecto
     */
    public Residuo() {
    }

    /**
     * Constructor que le asigna un id, cantidad, codigo y quimicos
     *
     * @param id Al que se le asignara
     * @param cantidad que se le asignara
     * @param codigo que se le asignara
     * @param quimicos lista de quimicos que lo componen
     */
    public Residuo(ObjectId id, Float cantidad, String codigo, List<Quimico> quimicos) {
        this.id = id;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.quimicos = quimicos;
    }

    /**
     * Constructor que asigna una canditada , un codigo y quimicos
     *
     * @param cantidad que se le asignara
     * @param codigo que se le asignara
     * @param quimicos lista de quimicos que lo componen
     *
     */
    public Residuo(Float cantidad, String codigo, List<Quimico> quimicos) {
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.quimicos = quimicos;
    }

    /**
     * Regresa el id del Residuo
     *
     * @return un ObjectId del Residuo
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Asigna un ObjectId al Residuo
     *
     * @param id ObjectId a asignar
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa la cantidad del Residuo
     *
     * @return cantidad del Residuo
     */
    public Float getCantidad() {
        return cantidad;
    }

    /**
     * Le asigna una cantidad al Residuo
     *
     * @param cantidad A asignar
     */
    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Regresa el codigo del Residuo
     *
     * @return el codigo del Residuo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Le asigna un codigo al Residuo
     *
     * @param codigo a asingar al Residuo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Regresa una lista de quimicos que lo componen
     *
     * @return lista de Quimicos
     */
    public List<Quimico> getQuimicos() {
        return quimicos;
    }

    /**
     * Le asignar una lista de Quimicos
     *
     * @param quimicos Lista de Quimicos a asignar
     */
    public void setQuimicos(List<Quimico> quimicos) {
        this.quimicos = quimicos;
    }

}
