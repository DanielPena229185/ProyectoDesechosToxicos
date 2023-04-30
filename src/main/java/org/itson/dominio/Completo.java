/**
 * TrasladoTotal.java
 * 1 mar. 2023 09:12:15
 */
package org.itson.dominio;
//importanciones

import java.util.Objects;

/**
 *
 * @author @author @author @author
 */
public class Completo extends Traslado {

    Transporte transporte;

    /**
     *
     */
    public Completo() {

    }

    /**
     *
     * @param id
     * @param direccion
     * @param residuo
     */
    public Completo(Integer id, Residuo residuo) {
        super(id, residuo);
    }

    public Completo(Residuo residuo) {
        super(residuo);
    }

    /**
     *
     * @param transporte
     * @param id
     * @param direccion
     * @param residuo
     */
    public Completo(Integer id, Residuo residuo, Transporte transporte) {
        super(id, residuo);
        this.transporte = transporte;
    }

    public Completo(Residuo residuo, Transporte transporte) {
        super(residuo);
        this.transporte = transporte;
    }

    /**
     *
     * @return
     */
    public Transporte getTransporte() {
        return transporte;
    }

    /**
     *
     * @param transporte
     */
    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.transporte);
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
        final Completo other = (Completo) obj;
        return Objects.equals(this.transporte, other.transporte);
    }
}
