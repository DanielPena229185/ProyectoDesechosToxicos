
package org.itson.dominio;

import java.util.Objects;

/**
 *
 * @author
 * @author
 * @author
 * @author
 */
//Clase padre 
public class Registro {
    //Declaracion de variable
    private Integer id;
    /**
     * Metodo contructor de la clase 
     * @param id identificador unico del registro
     */
    public Registro(Integer id) {
        this.id = id;
    }
    /**
     * Metodo contructor por omision
     */
    public Registro() {
    }
    /**
     * Metodo que devuelve el identificador único del registro
     * @return id unico de registro
     */
    public Integer getId() {
        return id;
    }
    /**
     * Metodo para establecer el identificador del registro
     * @param id unico de registro
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Metodo que devuelve un valor hash para este registro
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }
    /**
     * Metodo que compara este registro con el objeto especificado 
     * @param obj el objeto a comparar con el registro
     * @return el objeto especificado a esta
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
        final Registro other = (Registro) obj;
        return Objects.equals(this.id, other.id);
    }
    /**
     * Metodo que devuelve una representacion en cadena de registro
     * @return una cadena que representa al registro
     */
    @Override
    public String toString() {
        return "Registro{" + "id=" + id + '}';
    }
    
}
