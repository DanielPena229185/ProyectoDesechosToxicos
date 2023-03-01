/**
* Traslado.java
* 28 feb. 2023 23:19:31
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
public class Traslado {
    
    private Integer id;
    private Residuo residuo;
    
    /**
     * 
     */
    public Traslado(){

    }

    /**
     * 
     * @param id
     * @param direccion
     * @param residuo 
     */
    public Traslado(Integer id, Residuo residuo) {
        this.id = id;
        this.residuo = residuo;
    }

    public Traslado(Residuo residuo) {
        this.residuo = residuo;
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
    public Residuo getResiduo() {
        return residuo;
    }

    /**
     * 
     * @param residuo 
     */
    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.residuo);
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
        final Traslado other = (Traslado) obj;

        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.residuo, other.residuo);
    }
    
}
