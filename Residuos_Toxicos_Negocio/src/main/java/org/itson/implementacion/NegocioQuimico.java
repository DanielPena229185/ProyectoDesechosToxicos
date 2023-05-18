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
 * Descripción de la clase: Se encarga de realizar operaciones relacionadas con químicos en un sistema.
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
    /**
     * Inserta un objeto Quimico en el sistema.
     * @param quimico el objeto Quimico a insertar.
     * @return el Quimico insertado.
     * @throws NegocioException si ocurre un error en la lógica de negocio.
     */
    @Override
    public Quimico insertarQuimico(Quimico quimico) throws NegocioException {
        try {
            validarQuimico(quimico);
            return persistencia.insertarQuimico(quimico);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Consulta todos los Quimicos del sistema.
     * @return una lista de objetos Quimico que representa todos los Quimicos del sistema. 
     * @throws NegocioException si ocurre un error en la lógica de negocio.
     */
    @Override
    public List<Quimico> consultarQuimicos() throws NegocioException {
        try {
            List lista = persistencia.consultarTodosLosQuimicos();
            return lista;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    /**
     * Valida un objeto Quimico antes de ser insertado.
     * @param quimico el objeto Quimico a validar.
     * @return el Quimico validado.
     * @throws ValidacionException si el objeto Quimico no pasa las validaciones.
     */
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
