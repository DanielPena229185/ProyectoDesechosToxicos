package org.itson.dominio;

import java.util.Objects;

/**
 * Clase que se encarga de administrar los objetos de tipo Empresa.
 * @author Oscar
 */
public class Empresa {
    private Integer id;
    private String nombre;
    private Direccion direccion;

    /**
     * Método constructor por omisión.
     */
    public Empresa() {
    }

    /**
     * Método constructor que no recibe Id.
     * @param nombre de empresa.
     * @param direccion de la empresa.
     */
    public Empresa(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Método constructor que recibe todos los parámetros e inicializan todos
     * los atributos.
     * @param id de la empresa.
     * @param nombre de la empresa.
     * @param direccion de la empresa.
     */
    public Empresa(Integer id, String nombre, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    /**
     * Método que obtiene el id.
     * @return id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que establece el id.
     * @param id a recibir.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método constructor que obtiene el nombre de la empresa.
     * @return nombre de la empresa.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre de la empresa.
     * @param nombre a recibir.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que obtiene la dirección de la empresa.
     * @return dirección de la empresa.
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Método que establece la dirección de la empresa.
     * @param direccion a recibir.
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Método que establece el codigo hash al objeto.
     * @return código hash.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Método que compara este objeto con otro.
     * @param obj objeto a comparar.
     * @return true si son iguales, false si no.
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
        final Empresa other = (Empresa) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Método toString que retorna una cadena con toda la información del
     * objeto.
     * @return cadena con información. 
     */
    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }
}
