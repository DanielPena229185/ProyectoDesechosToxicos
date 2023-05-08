/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa una Dirección la cual está
 * ubicada en una Ciudad
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class Direccion {

    /**
     * Identificador de la dirección
     */
    private ObjectId id;

    /**
     * Nombre de la calle de la dirección
     */
    private String calle;

    /**
     * Nombre de la colonia de la dirección
     */
    private String colonia;

    /**
     * Número de la dirección
     */
    private String numero;

    /**
     * Ciudad a la que pertenece
     */
    private String ciudad;

    /**
     * Constructor con identificador, calle, colonia, numero de la dirección con
     * el identificador de la ciudad a la que pertenece
     *
     * @param id Identificador de la dirección
     * @param calle Nombre de la calle de la dirección
     * @param colonia Nombre de la colonia de la dirección
     * @param numero Número de la dirección
     * @param ciudad Ciudad a la que pertenece
     */
    public Direccion(ObjectId id, String calle, String colonia, String numero, String ciudad) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    /**
     * Constructor con calle, colonia y número de la dirección, con la iudad a
     * la que pertenece
     *
     * @param calle Nombre de la calle de la dirección
     * @param colonia Nombre de la colonia de la dirección
     * @param numero Número de la dirección
     * @param ciudad Ciudad a la que pertenece
     */
    public Direccion(String calle, String colonia, String numero, String ciudad) {
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    /**
     * Obtener el identificador de la dirección
     *
     * @return Identificador de la dirección
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establecer el identificador de la dirección
     *
     * @param id Identificador de la dirección
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtener el nombre de la calle de la dirección
     *
     * @return Nombre de la calle de la dirección
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establecer el nombre de la calle de la dirección
     *
     * @param calle Nombre de la calle de la dirección
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtener el nombre de la colonia de la dirección
     *
     * @return Nombre de la colonia de la dirección
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establecer el nombre de la colonia de la dirección
     *
     * @param colonia Nombre de la colonia de la dirección
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtener el número de la dirección
     *
     * @return Número de la dirección
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establecer el número de la dirección
     *
     * @param numero Número de la dirección
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtener el identificador de la ciudad a la que pertenece la dirección
     *
     * @return Identificador de la ciudad a ala que pertenece la dirección
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establecer la ciudad a la que pertenece la dirección
     *
     * @param ciudad Ciudad a la que pertenece
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
