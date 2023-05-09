package com.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa un Administrador
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class Administrador {
    
    /**
     * Identificador del administrador
     */
    private ObjectId id;
    
    /**
     * Nombres del administrador
     */
    private String nombres;
    
    /**
     * Apellido paterno del administrador
     */
    private String apellido_paterno;
    
    /**
     * Apellido materno del administrador
     */
    private String apellido_materno;
    
    /**
     * Cuenta del administrador
     */
    private Cuenta cuenta;

    /**
     * Constructor por default
     */
    public Administrador() {
    }

    /**
     * Constructor con el identificador del administrador, nombres, apellido paterno y materno y su cuenta
     * 
     * @param id Identificador del administrador
     * @param nombres Nombres del administrador
     * @param apellido_paterno Apellido paterno del administrador
     * @param apellido_materno Apellido materno del administrador
     * @param cuenta Cuenta del administrador
     */
    public Administrador(ObjectId id, String nombres, String apellido_paterno, String apellido_materno, Cuenta cuenta) {
        this.id = id;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.cuenta = cuenta;
    }

    /**
     * Constructor con los nombres, apellido paterno, apellido materno, y su cuenta
     * 
     * @param nombres Nombres del administrador
     * @param apellido_paterno Apellido paterno del administrador
     * @param apellido_materno Apellido materno del administrador
     * @param cuenta Cuenta del administrador
     */
    public Administrador(String nombres, String apellido_paterno, String apellido_materno, Cuenta cuenta) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.cuenta = cuenta;
    }

    /**
     * Constructor con los nombres, apellido paterno y apellido materno
     * 
     * @param nombres Nombres del administador
     * @param apellido_paterno Apellido paterno del administrador
     * @param apellido_materno Apellido materno del administrador
     */
    public Administrador(String nombres, String apellido_paterno, String apellido_materno) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
    }

    /**
     * Obtener el identificador del administrador
     * 
     * @return Identificador del administrador
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establecer el identificador del administrador
     * 
     * @param id Identificador del administrador
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtener los nombres del administrador
     * 
     * @return Nombres del administrador
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establecer nombres del administrador
     * 
     * @param nombres Nombres del administrador
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtener el apellido paterno del administrador
     * 
     * @return Apellido paterno del administrador
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Establecer el apellido paterno del administrador
     * 
     * @param apellido_paterno Apellido paterno del administrador
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }
    
    /**
     * Obtener el apellido materno
     * 
     * @return Apellido materno
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Establecer el apellido materno
     * 
     * @param apellido_materno Apellido materno
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Obtener cuenta del administrador
     * 
     * @return Cuenta del administrador
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * Establecer cuenta del administrador
     * 
     * @param cuenta Cuenta del administrador
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Administrador other = (Administrador) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Administrador [" + "nombres: " + nombres + ", apellido_paterno: " + apellido_paterno + ", apellido_materno: " + apellido_materno + ", correo: " + cuenta.getCorreo() + ']';
    }
}
