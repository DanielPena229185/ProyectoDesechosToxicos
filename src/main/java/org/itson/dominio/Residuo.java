/**
* Residuo.java
* 28 feb. 2023 22:59:19
*/ 

package org.itson.dominio;
//importanciones

import java.util.LinkedList;
import java.util.List;

/**
 * Descripción de la clase: 
 * 
 * @author
 * @author
 * @author
 * @author
 */
public class Residuo {
    
    private LinkedList<Quimico> quimicos;
    private Ciudad ciudad;
    private Organizacion organizacion;

   /**
    * 
    */
    public Residuo(){
    }

    /**
     * 
     * @param ciudad
     * @param organizacion 
     */
    public Residuo(Ciudad ciudad, Organizacion organizacion) {
        this.ciudad = ciudad;
        this.organizacion = organizacion;
        this.quimicos = new LinkedList<>();
    }

    /**
     * 
     * @param quimicos
     * @param ciudad
     * @param organizacion 
     */
    public Residuo(LinkedList<Quimico> quimicos, Ciudad ciudad, Organizacion organizacion) {
        this.quimicos = quimicos;
        this.ciudad = ciudad;
        this.organizacion = organizacion;
    }

    /**
     * 
     * @return 
     */
    public List<Quimico> getQuimicos() {
        return quimicos;
    }

    /**
     * 
     * @param quimicos 
     */
    public void setQuimicos(LinkedList<Quimico> quimicos) {
        this.quimicos = quimicos;
    }

    /**
     * 
     * @return 
     */
    public Ciudad getCiudad() {
        return ciudad;
    }

    /**
     * 
     * @param ciudad 
     */
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * 
     * @return 
     */
    public Organizacion getOrganizacion() {
        return organizacion;
    }

    /**
     * 
     * @param organizacion 
     */
    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}
