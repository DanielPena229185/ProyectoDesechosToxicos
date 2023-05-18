package com.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa un químico
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class Quimico {

    /**
     * Identificador del químico
     */
    private ObjectId id;

    /**
     * Nombre del químico
     */
    private String nombre;

    /**
     * Constructor por default
     */
    public Quimico() {
    }

    /**
     * Constructor con un identificador y el nombre del químico
     *
     * @param id Identificador del químico
     * @param nombre Nombre del químico
     */
    public Quimico(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Constructor con nombre
     *
     * @param nombre Nombre del químico
     */
    public Quimico(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener el identificador del químico
     *
     * @return Identificador del químico
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el valor al Identificador
     *
     * @param _id El nuevo valor del identificador
     */
    public void setId(ObjectId _id) {
        this.id = _id;
    }

    /**
     * Obtener el nombre del químico
     *
     * @return Nombre del químico
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el valor del identificador
     *
     * @param nombre El nuevo nombre del químico
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve un valor hash basado en el valor del atributo id.
     *
     * @return el valor hash calculado
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara este objeto Quimico con otro objeto para determinar si son
     * iguales.
     *
     * @param obj el objeto a comparar
     * @return true si los objetos son iguales, false en caso contrario
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
        final Quimico other = (Quimico) obj;
        return Objects.equals(this.id, other.id);
    }
    /**
     * Metodo que devuelve el nombre 
     * @return 
     */
    @Override
    public String toString() {
        return nombre;
    }
    
    

}
