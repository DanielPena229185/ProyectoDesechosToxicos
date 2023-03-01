/**
* Tratamiento.java
* 28 feb. 2023 23:28:10
*/ 

package org.itson.dominio;
//importanciones

import java.time.LocalDate;
import java.util.Objects;

/**
 * Descripción de la clase: 
 * 
 * @author
 * @author
 * @author
 * @author
 */
public class Tratamiento {
    
    Traslado traslado;
    LocalDate fechaLlegada;
    String descripcion;
    
    /**
     * 
     */
    public Tratamiento(){

    }

    /**
     * 
     * @param traslado
     * @param fechaLlegada
     * @param descripcion 
     */
    public Tratamiento(Traslado traslado, LocalDate fechaLlegada, String descripcion) {
        this.traslado = traslado;
        this.fechaLlegada = fechaLlegada;
        this.descripcion = descripcion;
    }

    /**
     * 
     * @return 
     */
    public Traslado getTraslado() {
        return traslado;
    }

    /**
     * 
     * @param traslado 
     */
    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
    }

    /**
     * 
     * @return 
     */
    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * 
     * @param fechaLlegada 
     */
    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * 
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.traslado);
        hash = 53 * hash + Objects.hashCode(this.fechaLlegada);
        hash = 53 * hash + Objects.hashCode(this.descripcion);
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
        final Tratamiento other = (Tratamiento) obj;
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.traslado, other.traslado)) {
            return false;
        }
        return Objects.equals(this.fechaLlegada, other.fechaLlegada);
    }
    
}
