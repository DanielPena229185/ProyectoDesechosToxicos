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
import org.itson.implementaciones.fachada.FachadaPersistencia;
import org.itson.interfaces.INegocioQuimico;
import org.itson.interfaces.IPersistencia;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioQuimico implements INegocioQuimico {

    IPersistencia persistencia;

    /**
     * Constructor por default
     */
    public NegocioQuimico() {
        persistencia = new FachadaPersistencia();
    }

    @Override
    public Quimico insertarQuimico(Quimico quimico) throws NegocioException {
        try {
            validarQuimico(quimico);
            return persistencia.insertarQuimico(quimico);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Quimico> consultarQuimicos() throws NegocioException {
        try {
            List lista = persistencia.consultarTodosLosQuimicos();
            return lista;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
    private Quimico validarQuimico(Quimico quimico) throws ValidacionException{
        
        if(quimico == null){
            throw new ValidacionException("No hay información del químico");
        }
        
        String nombreQuimico = quimico.getNombre();
        if(validarTextoVacio(nombreQuimico)){
            throw new ValidacionException("No hay nombre del químico");
        }
        
        return quimico;
    }
    
    /**
     * Valida si el texto está vacío
     *
     * @param texto Texto que se quiere validar
     * @return True si no cumple, false en caso contrario
     */
    private boolean validarTextoVacio(String texto) {
        if (texto == null || texto.isBlank()) {
            return true;
        }

        return false;
    }

}
