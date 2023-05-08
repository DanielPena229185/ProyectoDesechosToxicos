/**
* DireccionNegocio.java
* 8 may. 2023 10:36:16
*/ 

package org.itson.implementacion;

import com.dominio.Direccion;
import java.util.List;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.interfaces.CrudInterface;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class DireccionNegocio implements CrudInterface<Direccion>{

    /**
     *
     */
    public DireccionNegocio(){

    }

    @Override
    public Direccion insertar(Direccion elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Direccion eliminar(Direccion elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Direccion actualizar(Direccion elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Direccion> consultar() throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Direccion> consultar(Direccion elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
