/**
* Residuo.java
* 28 feb. 2023 22:59:19
*/ 

package org.itson.dominio;
//importanciones

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Descripción de la clase: 
 * 
 * @author
 * @author
 * @author
 * @author
 */
public class Residuo {
    
    private List<Quimico> quimicos;
    private Organizacion organizacion;

   /**
    * 
    */
    public Residuo(){
    }

    /**
     * 
     * @param ciudad
     * @param organizacion 
     */
    public Residuo(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    /**
     * 
     * @param quimicos
     * @param ciudad
     * @param organizacion 
     */
    public Residuo(List<Quimico> quimicos, Organizacion organizacion) {
        this.quimicos = quimicos;
        this.organizacion = organizacion;
    }

    /**
     * 
     * @return 
     */
    public List<Quimico> getQuimicos() {
        return quimicos;
    }

    /**
     * 
     * @param quimicos 
     */
    public void setQuimicos(List<Quimico> quimicos) {
        this.quimicos = quimicos;
    }

    /**
     * 
     * @return 
     */
    public Organizacion getOrganizacion() {
        return organizacion;
    }

    /**
     * 
     * @param organizacion 
     */
    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.quimicos);
        hash = 59 * hash + Objects.hashCode(this.organizacion);
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
        final Residuo other = (Residuo) obj;
        if (!Objects.equals(this.quimicos, other.quimicos)) {
            return false;
        }
        return Objects.equals(this.organizacion, other.organizacion);
    }
    
}
