
package org.itson.dominio;

import java.util.Objects;
/**
 *
 * @author
 * @author
 * @author
 * @author
 */
public class Ciudad {
    //Declaracion de variables
    private Integer id;
    private String nombre;
    /**
     * Metodo contructor de la clase
     * @param id el identificador único de la ciudad
     * @param nombre nombre el nombre de la ciudad
     */
    public Ciudad(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    /**
     * Metodo constructor por omision 
     */
    public Ciudad() {
    }
    /**
     * Metodo que devuelve el identificador único de la ciudad
     * @return id unico de la ciudad
     */
    public int getId() {
        return id;
    }
    /**
     * Metodo para establecer el identificador de la ciudad
     * @param id unico de la ciudad
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Metodo que devuelve el nombre de la ciudad
     * @return nombre de la ciudad
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para establecer el nombre de la ciudad
     * @param nombre de la ciudad
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo que devuelve un valor hash para esta ciudad
     * @return un valor hash para la ciudad
     */
        @Override
        public int hashCode() {
            int hash = 7;
            return hash;
        }
        /**
         * Metodo que compara esta ciudad con el objeto especificado 
         * para ver si son iguales.
         * @param obj el objeto a comparar con esta ciudad
         * @return el objeto especificado es igual a esta 
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
            final Ciudad other = (Ciudad) obj;
            if (!Objects.equals(this.nombre, other.nombre)) {
                return false;
            }
            return Objects.equals(this.id, other.id);
        }
    
    /**
     * Metodo que devuelve una representacion en cadena de ciudad
     * @return una cadena que representa la ciudad
     */
    @Override
    public String toString() {
        return "Ciudad{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    }


