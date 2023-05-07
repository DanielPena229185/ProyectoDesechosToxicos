/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa una Cuenta
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class Cuenta {
    
    /**
     * Identificador de la cuenta
     */
    private ObjectId id;
    
    /**
     * Correo de la cuenta
     */
    private String correo;
    
    /**
     * Contraseña de la cuenta
     */
    private String contrasena;

    /**
     * Constructor con identificador de la cuenta, correo y contraseña
     * 
     * @param id Identificador de la cuenta
     * @param correo Correo de la cuenta
     * @param contrasena Contraseña de la cuenta
     */
    public Cuenta(ObjectId id, String correo, String contrasena) {
        this.id = id;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    /**
     * Constructor con correo y contraseña
     * 
     * @param correo Correo de la cuenta
     * @param contrasena Contraseña de la cuenta
     */
    public Cuenta(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    /**
     * Obtener el identificador de la cuenta
     * 
     * @return Identificador de la cuenta
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establecer el identificador de la cuenta
     * 
     * @param id Identificador de la cuenta
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtener el correo de la cuenta
     * 
     * @return Correo de la cuenta
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establecer el correo de la cuenta
     * 
     * @param correo Correo de la cuenta
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtener contraseña de la cuenta
     * 
     * @return Contraseña de la cuenta
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establecer contraseña de la cuenta
     * 
     * @param contrasena Contraseña de la cuenta
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Cuenta other = (Cuenta) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
