/**
 * ResiduoNegocio.java
 * 7 may. 2023 19:26:36
 */
package org.itson.implementacion;

import com.dominio.Quimico;
import com.dominio.Residuo;
import java.util.LinkedList;
import java.util.List;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.excepciones.ValidacionExcepcion;
import org.itson.interfaces.CrudInterface;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ResiduoNegocio implements CrudInterface<Residuo> {

    /**
     * Constructor por default
     */
    public ResiduoNegocio() {

    }

    @Override
    public Residuo insertar(Residuo elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Residuo eliminar(Residuo elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Residuo actualizar(Residuo elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Residuo> consultar() throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Residuo> consultar(Residuo elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Residuo validarResiduo(Residuo residuo) throws ValidacionExcepcion {
        List<String> camposErroneos = new LinkedList();
        String nombre = residuo.getNombre();
        String codigo = residuo.getCodigo();
        List<Quimico> listaQuimicos = residuo.getQuimicos();
        return residuo;
    }

    private List<Quimico> validarListaVacia(List<Quimico> lista) {
        if (lista.isEmpty()) {
            return null;
        }
        return lista;
    }

    private String validarFormatoCodigo(String codigo) {
        String regex = "[A-Za-z]{3}[0-9]{3}";
        if (codigo.matches(regex)) {
            return codigo;
        }
        return null;
    }

    private String validarNombreVacio(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return null;
        }

        return nombre;
    }
}
