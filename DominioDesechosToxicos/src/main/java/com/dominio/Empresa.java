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
public class Empresa {

    /**
     * Identificador de la empresa
     */
    private ObjectId id;

    /**
     * Nombre de la empresa
     */
    private String nombre;

    /**
     * Lista de direcciones en la que se úbica esa empresa
     */
    private List<Direccion> direcciones;

    /**
     * Constructor con identificador, nombre y lista de direcciones de la
     * empresa
     *
     * @param id Identificador de la empresa
     * @param nombre Nombre de la empresa
     * @param direcciones direcciones de la empresa
     */
    public Empresa(ObjectId id, String nombre, List<Direccion> direcciones) {
        this.id = id;
        this.nombre = nombre;
        this.direcciones = direcciones;
    }

    /**
     * Constructor con nombre y direcciones de la empresa
     *
     * @param nombre Nombre de la empresa
     * @param direcciones Direcciones de la empresa
     */
    public Empresa(String nombre, List<Direccion> direcciones) {
        this.nombre = nombre;
        this.direcciones = direcciones;
    }

    /**
     * Constructor con el nombre de la empresa
     *
     * @param nombre Nombre de la empresa
     */
    public Empresa(String nombre) {
        this.nombre = nombre;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

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
