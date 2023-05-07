/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa una ciudad
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class Ciudad {

    /**
     * Identificador de la ciudad
     */
    private ObjectId id;

    /**
     * Nombre de la ciudad
     */
    private String nombre;

    /**
     * Lista de direcciones que se ubican en la ciudad
     */
    private List<Direccion> direcciones;

    /**
     * Constructor con Identificador de la ciudad, nombre y la lista de
     * direcciones que se encuentran en la ciudad
     *
     * @param id Identificador de la ciudad
     * @param nombre Nombre de la ciudad
     * @param direcciones Lista de direcciones de la ciudad
     */
    public Ciudad(ObjectId id, String nombre, List<Direccion> direcciones) {
        this.id = id;
        this.nombre = nombre;
        this.direcciones = direcciones;
    }

    /**
     * Constructor con nombre y direcciones que se encuentran en la ciudad
     *
     * @param nombre Nombre de la ciudad
     * @param direcciones Direcciones que se encuentran en la ciudad
     */
    public Ciudad(String nombre, List<Direccion> direcciones) {
        this.nombre = nombre;
        this.direcciones = direcciones;
    }

    /**
     * Constructor con el nombre de la ciudad
     *
     * @param nombre Nombre de la ciudad
     */
    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener el id
     *
     * @return
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establecer el id de la ciudad
     *
     * @param id Identificador de la ciudad
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtener nombre de la ciudad
     *
     * @return Nombre de la ciudad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establecer el nombre de la ciudad
     *
     * @param nombre Nombre de la ciudad
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve un valor hash basado en el valor del atributo id.
     *
     * @return el valor hash calculado
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara este objeto Ciudad con otro objeto para determinar si son
     * iguales.
     *
     * @param obj el objeto a comparar
     * @return true si los objetos son iguales, false en caso contrario
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
        final Ciudad other = (Ciudad) obj;
        return Objects.equals(this.id, other.id);
    }

}
