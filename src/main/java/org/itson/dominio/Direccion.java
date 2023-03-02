/**
* Direccion.java
* 1 mar. 2023 00:10:00
*/ 

package org.itson.dominio;
//importanciones
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Direccion {

    private String calle;
    private String colonia;
    private String numero;
    private Ciudad ciudad;
    
    /**
     * 
     */
    public Direccion(){
    }

    public Direccion(String calle, String colonia, String numero, Ciudad ciudad) {
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    public Direccion(String colonia, String numero, Ciudad ciudad) {
        this.colonia = colonia;
        this.numero = numero;
        this.ciudad = ciudad;
    }
    
    
}
