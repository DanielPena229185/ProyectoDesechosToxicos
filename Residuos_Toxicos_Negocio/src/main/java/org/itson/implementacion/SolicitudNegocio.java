/**
 * SolicitudNegocio.java
 * 7 may. 2023 21:29:42
 */
package org.itson.implementacion;

import com.dominio.Productor;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.excepciones.ValidacionExcepcion;
import org.itson.interfaces.CrudInterface;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class SolicitudNegocio implements CrudInterface<Solicitud> {

    /**
     * Constructor por default
     */
    public SolicitudNegocio() {

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
    public List<Solicitud> consultar() throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Solicitud> consultar(Solicitud elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Solicitud validarSolicitud(Solicitud solicitud) throws ValidacionExcepcion {

        return solicitud;
    }

    private Residuo validarResiduo(Residuo residuo) {
        if (residuo == null) {
            return null;
        }
        return residuo;
    }
    
    private Date validarFechaSolicitada(Date fechaSolicitada){
        if(fechaSolicitada == null){
            return null;
        }
        return fechaSolicitada;
    }
    
    private Productor validarProductor(Productor productor){
        if(productor == null){
            return null;
        }
        return productor;
    }

    @Override
    public List<Solicitud> consultar(ObjectId id) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Solicitud actualizar(Solicitud elemento, Solicitud elementoE) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
