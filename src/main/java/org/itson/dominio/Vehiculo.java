package org.itson.dominio;

import java.util.Objects;

/**
 * Clase que se encarga de crear los vehículos.
 * @author Oscar
 */
public class Vehiculo {
    private Integer id;
    private String modelo;
    private String marca;

    /**
     * Método constructor por omisión.
     */
    public Vehiculo() {
    }

    /**
     * Método constructor que inicializa el vehículo sin id.
     * @param modelo
     * @param marca 
     */
    public Vehiculo(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }

    /**
     * Método constructor que inicializa todos los parámetros del vehículo.
     * @param id
     * @param modelo
     * @param marca 
     */
    public Vehiculo(Integer id, String modelo, String marca) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
    }

    /**
     * Método que obtiene el id del vehículo.
     * @return id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método establece el id el vehículo.
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método que obtiene el modelo del vehículo.
     * @return modelo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método que establece el modelo del vehículo.
     * @param modelo 
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Método que obtiene la marca del vehículo.
     * @return marca.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método que establece la marca del vehículo.
     * @param marca 
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método que crea el código hash del vehículo.
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Método que verifica si este objeto es igual a otro.
     * @param obj
     * @return true si es igual, falso si no lo es.
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
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Método toString que muestra toda la información del vehículo.
     * @return información del vehículo.
     */
    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", modelo=" + modelo + ", marca=" + marca + '}';
    }
}
