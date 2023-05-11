/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta es una clase padre que representa como poder
 * identificar quién o qué es considerado una empresa
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public abstract class Empresa {

    /**
     * Identificador de la empresa
     */
    private ObjectId id;

    /**
     * Tipo de empresa
     */
    private Tipo tipo;

    /**
     * Nombre de la empresa
     */
    private String nombre;

    /**
     * Cuenta de la empresa
     */
    private Cuenta cuenta;

    /**
     * Lista de direcciones en la que se úbica esa empresa
     */
    private List<Direccion> direcciones;

    /**
     * Constructor por default
     */
    public Empresa() {
    }

    /**
     * Constructor con identificador, nombre,tipo,cuenta y lista de direcciones
     * de la empresa
     *
     * @param id Identificador de la empresa
     * @param tipo Tipo de empresa
     * @param nombre Nombre de la empresa
     * @param cuenta Cuenta de la empresa
     * @param direcciones direcciones de la empresa
     */
    public Empresa(ObjectId id, Tipo tipo, String nombre, Cuenta cuenta, List<Direccion> direcciones) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.direcciones = direcciones;
    }

    /**
     * Constructor con nombre,tipo y cuenta y direcciones de la empresa
     *
     * @param tipo Tipo de la empresa
     * @param nombre Nombre de la empresa
     * @param cuenta Cuenta de la empresa
     * @param direcciones Direcciones de la empresa
     */
    public Empresa(Tipo tipo, String nombre, Cuenta cuenta, List<Direccion> direcciones) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.direcciones = direcciones;
    }

    /**
     * Constructor con el nombre, tipo y cuenta de la empresa
     *
     * @param nombre Nombre de la empresa
     * @param cuenta Cuenta de la empresa
     */
    public Empresa(Tipo tipo, String nombre, Cuenta cuenta) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    /**
     * Obtener el identificador de la empresa
     *
     * @return Identificador de la empresa
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establecer el identificador de la empresa
     *
     * @param id Identificador de la empresa
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtener el nombre de la empresa
     *
     * @return Nombre de la empresa
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establecer el nombre de la empresa
     *
     * @param nombre Nombre de la empresa
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener la lista de direcciones en la que se úbica la empresa
     *
     * @return Lista de direcciones en la que se úbica la empresa
     */
    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    /**
     * Establecer las direcciones en las que se úbica la empresa
     *
     * @param direcciones Direcciones en las que se úbica la empresa
     */
    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    /**
     * Agrega una dirección a la lista de direcciones donde se úbica la empresa
     *
     * @param direccion Dirección que se desea agregar a la lista
     * @return Lista de direcciones en las que se úbica la empresa
     */
    public List<Direccion> agregarDireccion(Direccion direccion) {
        if (this.direcciones == null) {
            direcciones = new LinkedList<>();
        }
        this.direcciones.add(direccion);
        return direcciones;
    }

    /**
     * Regresa la cuenta de la Empresa
     *
     * @return Cuenta de la Empresa
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * Le asigna una Cuenta a la Empresa
     *
     * @param cuenta a asignar
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Regresa el tipo de Empresa
     *
     * @return El tipo de Empresa
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Le asigna el tipo de Empresa
     *
     * @param tipo de empresa a asignar
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo hashcode
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Metodo equals
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        return Objects.equals(this.id, other.id);
    }

}
