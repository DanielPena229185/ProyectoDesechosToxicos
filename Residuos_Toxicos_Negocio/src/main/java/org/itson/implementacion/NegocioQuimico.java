/**
 * QuimicoNegocio.java
 * 11 may. 2023 20:18:29
 */
package org.itson.implementacion;

import com.dominio.Quimico;
import java.util.List;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionExcepcion;
import org.itson.implementaciones.bd.DAOFactory;
import org.itson.interfaces.INegocioQuimico;
import org.itson.interfaces.IQuimicosDAO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioQuimico implements INegocioQuimico {

    IQuimicosDAO quimicoDAO;

    /**
     * Constructor por default
     */
    public NegocioQuimico() {
        quimicoDAO = DAOFactory.getQuimicosDAO();
    }

    @Override
    public Quimico insertarQuimico(Quimico quimico) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Quimico> consultarQuimicos() throws NegocioExcepcion {
        try {
            List lista = quimicoDAO.consultarTodosLosQuimicos();
            
            return lista;
        } catch (PersistenciaException e) {
            throw new NegocioExcepcion(e.getMessage());
        }
    }
    
    private Quimico validarQuimico(Quimico quimico) throws ValidacionExcepcion{
        
        if(quimico == null){
            throw new ValidacionExcepcion("No hay información del químico");
        }
        return quimico;
        
    }

}
