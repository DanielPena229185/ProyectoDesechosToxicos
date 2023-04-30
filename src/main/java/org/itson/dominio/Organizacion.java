package org.itson.dominio;

/**
 * Clase que se encarga de crear las organizaciones que producen residuos.
 * @author Oscar
 */
public class Organizacion extends Empresa {

    /**
     * Método constructor por omisión.
     */
    public Organizacion() {
        super();
    }

    /**
     * Método constructor que no recibe id.
     * @param nombre
     * @param direccion 
     */
    public Organizacion(String nombre, Direccion direccion) {
        super(nombre, direccion);
    }

    /**
     * Método constructor que recibe todos los parámetros.
     * @param id
     * @param nombre
     * @param direccion 
     */
    public Organizacion(Integer id, String nombre, Direccion direccion) {
        super(id, nombre, direccion);
    }

    /**
     * Método toString que muestra toda la información de la organización.
     * @return información.
     */
    @Override
    public String toString() {
        return "Organizacion{" + super.toString() + '}';
    }
    
    
}
