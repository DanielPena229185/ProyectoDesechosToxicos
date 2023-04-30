/**
* Quimico.java
* 28 feb. 2023 23:15:10
*/ 

package org.itson.dominio;
//importanciones

import java.util.Objects;

/**
 * Descripción de la clase: 
 * 
 * @author
 * @author
 * @author
 * @author
 */
public class Quimico {
    
    private Integer id;
    private String nombre;
    
    /**
     * 
     */
    public Quimico(){

    }

    /**
     * 
     * @param id
     * @param nombre 
     */
    public Quimico(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Quimico(String nombre) {
        this.nombre = nombre;
    }

    
    
    /**
     * 
     * @return 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    /**
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
        final Quimico other = (Quimico) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
}
