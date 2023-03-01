package org.itson.dominio;

import java.util.Objects;

/**
 * Clase crea los objetos de tipo transporte.
 * @author Oscar
 */
public class Transporte {
    private Integer id;
    private Double kilometros;
    private Vehiculo vehiculo;
    EmpresaTransportista empresaTransportista;

    /**
     * Método constructor por omisión.
     */
    public Transporte() {
    }

    public Transporte(Vehiculo vehiculo,EmpresaTransportista empresaTransportista) {
        this.vehiculo = vehiculo;
        this.empresaTransportista=empresaTransportista;
    }

    
    
    /**
     * Método constructor que sólamente recibe los kilómetros.
     * @param kilometros
     */
    public Transporte(Vehiculo vehiculo,EmpresaTransportista empresaTransportista, Double kilometros) {
        this.vehiculo=vehiculo;
        this.empresaTransportista=empresaTransportista;
        this.kilometros = kilometros;
    }

    /**
     * Método constructor que recibe todos los parámetros.
     * @param id
     * @param kilometros 
     */
    public Transporte(Integer id, Vehiculo vehiculo,EmpresaTransportista empresaTransportista,Double kilometros) {
        this.id = id;
        this.vehiculo=vehiculo;
        this.empresaTransportista=empresaTransportista;
        this.kilometros = kilometros;
    }

    /**
     * Método que obtiene el id del trasnporte.
     * @return id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que establece el id.
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    

    /**
     * Método que obtiene los kilómetros de trasnporte.
     * @return kilómetros.
     */
    public Double getKilometros() {
        return kilometros;
    }

    /**
     * Método que establece los kilómetros del trasnporte.
     * @param kilometros 
     */
    public void setKilometros(Double kilometros) {
        this.kilometros = kilometros;
    }

    /**
     * Método que genera un código hash para un objeto único.
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Método que verifica que este objeto sea igual a otro.
     * @param obj a comparar.
     * @return true si son iguales, false si no lo es.
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
        final Transporte other = (Transporte) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Método toString que muestra toda la información del objeto.
     * @return toda la información del objeto-
     */
    @Override
    public String toString() {
        return "Transporte{" + "id=" + id + ", kilometros=" + kilometros + '}';
    }
}
