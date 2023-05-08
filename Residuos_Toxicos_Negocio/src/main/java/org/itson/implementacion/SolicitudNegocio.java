/**
* SolicitudNegocio.java
* 7 may. 2023 21:29:42
*/ 

package org.itson.implementacion;

import com.dominio.Solicitud;
import java.util.List;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.interfaces.CrudInterface;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class SolicitudNegocio implements CrudInterface<Solicitud>{

    /**
     * Constructor por default
     */
    public SolicitudNegocio(){

    }

    @Override
    public Solicitud insertar(Solicitud elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Solicitud eliminar(Solicitud elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Solicitud actualizar(Solicitud elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Solicitud> consultar() throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Solicitud> consultar(Solicitud elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
