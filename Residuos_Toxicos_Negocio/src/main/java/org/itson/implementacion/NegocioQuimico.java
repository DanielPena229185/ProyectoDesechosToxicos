/**
 * QuimicoNegocio.java
 * 11 may. 2023 20:18:29
 */
package org.itson.implementacion;

import com.dominio.Quimico;
import java.util.List;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
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
    public Quimico insertarQuimico(Quimico quimico) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Quimico> consultarQuimicos() throws NegocioException {
        try {
            List lista = quimicoDAO.consultarTodosLosQuimicos();
            
            return lista;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
    private Quimico validarQuimico(Quimico quimico) throws ValidacionException{
        
        if(quimico == null){
            throw new ValidacionException("No hay información del químico");
        }
        return quimico;
        
    }

}
