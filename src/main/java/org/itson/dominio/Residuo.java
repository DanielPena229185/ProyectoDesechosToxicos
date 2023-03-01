/**
* Residuo.java
* 28 feb. 2023 22:59:19
*/ 

package org.itson.dominio;
//importanciones

import java.util.LinkedList;
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
    
    private LinkedList<Quimico> quimicos;
    private Ciudad ciudad;
    private Empresa empresa;

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
    public Residuo(Ciudad ciudad, Empresa empresa) {
        this.ciudad = ciudad;
        this.empresa = empresa;
        this.quimicos = new LinkedList<>();
    }

    /**
     * 
     * @param quimicos
     * @param ciudad
     * @param organizacion 
     */
    public Residuo(LinkedList<Quimico> quimicos, Ciudad ciudad, Empresa organizacion) {
        this.quimicos = quimicos;
        this.ciudad = ciudad;
        this.empresa = empresa;
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
    public void setQuimicos(LinkedList<Quimico> quimicos) {
        this.quimicos = quimicos;
    }

    /**
     * 
     * @return 
     */
    public Ciudad getCiudad() {
        return ciudad;
    }

    /**
     * 
     * @param ciudad 
     */
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * 
     * @return 
     */
    public Empresa getOrganizacion() {
        return empresa;
    }

    /**
     * 
     * @param organizacion 
     */
    public void setOrganizacion(Empresa organizacion) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.quimicos);
        hash = 59 * hash + Objects.hashCode(this.ciudad);
        hash = 59 * hash + Objects.hashCode(this.empresa);
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
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        return Objects.equals(this.empresa, other.empresa);
    }
    
}
