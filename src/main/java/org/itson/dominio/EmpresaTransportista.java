package org.itson.dominio;

/**
 * Método que crea las empresas transportistas.
 * @author Oscar
 */
public class EmpresaTransportista extends Empresa {
    
    /**
     * Método constructor por omisión.
     */
    public EmpresaTransportista() {
        super();
    }

    /**
     * Método constructor que no recibe id.
     * @param nombre
     * @param direccion 
     */
    public EmpresaTransportista(String nombre, Direccion direccion) {
        super(nombre, direccion);
    }

    /**
     * Método constructor que recibe todos los parámetros de la empresa
     * tranportista.
     * @param id
     * @param nombre
     * @param direccion 
     */
    public EmpresaTransportista(Integer id, String nombre, Direccion direccion) {
        super(id, nombre, direccion);
    }

    /**
     * Método toString que muestra toda la información de la empresa
     * transportista.
     * @return información.
     */
    @Override
    public String toString() {
        return "EmpresaTransportista{" + super.toString() + '}';
    }
}
