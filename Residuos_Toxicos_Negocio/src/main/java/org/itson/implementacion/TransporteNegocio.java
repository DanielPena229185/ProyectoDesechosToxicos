/**
* TransporteNegocio.java
* 7 may. 2023 21:31:42
*/ 

package org.itson.implementacion;

import com.dominio.Transporte;
import java.util.List;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.interfaces.CrudInterface;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class TransporteNegocio implements CrudInterface<Transporte>{

    /**
     * Constructor por default
     */
    public TransporteNegocio(){

    }

    @Override
    public Transporte insertar(Transporte elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Transporte eliminar(Transporte elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Transporte actualizar(Transporte elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Transporte> consultar() throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Transporte> consultar(Transporte elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
