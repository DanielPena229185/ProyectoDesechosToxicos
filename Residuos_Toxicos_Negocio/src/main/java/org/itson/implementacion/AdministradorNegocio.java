/**
* AdministradorNegocio.java
* 8 may. 2023 10:35:11
*/ 

package org.itson.implementacion;

import com.dominio.Administrador;
import java.util.List;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.implementaciones.daos.AdministradoresDAO;
import org.itson.interfaces.CrudInterface;
import org.itson.interfaces.IConsultasDAO;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class AdministradorNegocio implements CrudInterface<Administrador>{
    
    //IConsultasDAO dao = new AdministradoresDAO(MANEJADOR_CONEXIONES);
    
    /**
     *
     */
    public AdministradorNegocio(){

    }

    @Override
    public Administrador insertar(Administrador elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Administrador eliminar(Administrador elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Administrador actualizar(Administrador elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Administrador> consultar() throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Administrador> consultar(Administrador elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
