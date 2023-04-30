/**
* Historial.java
* 1 mar. 2023 09:33:11
*/ 

package org.itson.dominio;
//importanciones

import java.util.LinkedList;
import java.util.Objects;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Historial {
    
    private Integer id;
    private Transporte transporte;
    private EnPartes parte;

    /**
     * 
     */
    public Historial(){

    }

    public Historial(Integer id, Transporte transporte, EnPartes parte) {
        this.id = id;
        this.transporte = transporte;
        this.parte = parte;
    }

    public Historial(Transporte transporte, EnPartes parte) {
        this.transporte = transporte;
        this.parte = parte;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public EnPartes getParte() {
        return parte;
    }

    public void setParte(EnPartes parte) {
        this.parte = parte;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.transporte);
        hash = 13 * hash + Objects.hashCode(this.parte);
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
        final Historial other = (Historial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.transporte, other.transporte)) {
            return false;
        }
        return Objects.equals(this.parte, other.parte);
    }
    
}
