/**
 * EmpresaNegocio.java
 * 7 may. 2023 19:34:46
 */
package org.itson.implementacion;

import com.dominio.Empresa;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.interfaces.CrudInterface;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class EmpresaNegocio implements CrudInterface<Empresa> {

    /**
     * Constructor por default
     */
    public EmpresaNegocio() {

    }

    @Override
    public Empresa insertar(Empresa elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empresa eliminar(Empresa elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empresa actualizar(Empresa elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Empresa> consultar() throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Empresa> consultar(Empresa elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Empresa> consultar(ObjectId id) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Regresa una un mensaje contatenado de una lista
     *
     * @param listaCampos Liusta donde los mensajes se contatenan
     * @return Mensaje contatenado
     */
    private String mensajeCampos(List<String> listaCampos) {
        String mensaje = "";
        for (String campo : listaCampos) {
            mensaje += campo + "\n";
        }
        return mensaje;
    }

    /**
     * Valida que un texto no esté vacío
     *
     * @param texto Texto que se quiere validar
     * @return Texto válido, de lo contrario null
     */
    private String validarTextoVacio(String texto) {
        if (texto == null || texto.isEmpty()) {
            return null;
        }
        return texto;
    }

}
