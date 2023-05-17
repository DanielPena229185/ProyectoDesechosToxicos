/**
 * NegocioTransporte.java
 * 12 may. 2023 22:32:52
 */
package org.itson.implementacion;

import com.dominio.EmpresaTransportista;
import com.dominio.Transporte;
import com.dominio.Vehiculo;
import java.util.LinkedList;
import java.util.List;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.implementaciones.fachada.FachadaPersistencia;
import org.itson.interfaces.INegocioTransporte;
import org.itson.interfaces.IPersistencia;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioTransporte implements INegocioTransporte {

    IPersistencia persistencia;

    /**
     * Constructor por default
     */
    public NegocioTransporte() {
        persistencia = new FachadaPersistencia();
    }

    @Override
    public Transporte insertarTransporte(Transporte transporte) throws NegocioException {
        try {
            return persistencia.insertarTrasnporte(transporte);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        } catch (ValidacionException a) {
            throw new NegocioException(a.getMessage());
        }
    }

    private Transporte validarTransporte(Transporte transporte) throws ValidacionException {

        List<String> camposError = new LinkedList<>();

        if (transporte == null) {
            throw new ValidacionException("- No hay información del transporte");
        }

        //Valida que almenos exista un vehículo seleccionado
        List<Vehiculo> vehiculos = transporte.getVehiculos();

        if (validarListaVacia(vehiculos)) {
            camposError.add("- No hay vehículos seleccionados");
        }

        //Validar kilometros
        Float kilometros = transporte.getKilometros();
        if (kilometros == null || kilometros == 0) {
            camposError.add("- No se especificó los kilometros");
        }

        //Validar costo
        Float costo = transporte.getCoste();
        if (costo == null || costo == 0) {
            camposError.add("- No se especificó el costo");
        }
        
        //Validar Empresa transportista
        EmpresaTransportista empresaTransportista = transporte.getEmpresa_Transportista();
        return null;

    }

    /**
     * Válida que una lista esté vacia, si la lista está vacía, retorna true, en
     * caso contrarío, regresa false
     *
     * @param lista Lista que se quiere validar
     * @return True si la lista está vacía, false en caso contrario
     */
    private boolean validarListaVacia(List lista) {
        if (lista == null || lista.isEmpty()) {
            //Lista vacía o nula
            return true;
        }
        //Lista no está vacía
        return false;
    }

}
