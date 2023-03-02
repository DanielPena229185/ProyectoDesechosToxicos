/**
 * EnPartes.java
 * 1 mar. 2023 09:26:42
 */
package org.itson.dominio;
//importanciones

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class EnPartes extends Traslado {

    /**
     *
     */
    public EnPartes() {

    }

    public EnPartes(Integer id, Residuo residuo, Transporte transporte) {
        super(id, residuo);
    }


    public EnPartes(Residuo residuo) {
        super(residuo);
    }



}
