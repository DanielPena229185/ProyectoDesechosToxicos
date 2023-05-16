/**
 * NegocioAdministrador.java
 * 16 may. 2023 14:53:56
 */
package org.itson.implementacion;

import com.dominio.Administrador;
import java.util.LinkedList;
import java.util.List;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.implementaciones.fachada.FachadaPersistencia;
import org.itson.interfaces.INegocioAdministrador;
import org.itson.interfaces.IPersistencia;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioAdministrador implements INegocioAdministrador {

    IPersistencia persistencia;

    /**
     *
     */
    public NegocioAdministrador() {
        persistencia = new FachadaPersistencia();
    }

    @Override
    public Administrador loginAdministrador(String correo, String contrasena) throws NegocioException {

        try {
            this.validarLogin(correo, contrasena);
            return persistencia.loginAdministrador(correo, contrasena);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        } catch (ValidacionException a) {

            throw new NegocioException(a.getMessage());
        }
    }

    private void validarLogin(String correo, String contrasena) throws ValidacionException {
        List<String> camposError = new LinkedList<>();
        
        if (validarTextoVacio(correo)) {
            camposError.add("- No indica el correo");
        }

        if (validarTextoVacio(contrasena)) {
            camposError.add("- No indica el contraseña");
        }

        if(camposError.isEmpty()){
            return;
        }
        
        String mensaje = mensajeCampos(camposError);
        
        throw new ValidacionException(mensaje);
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

    /**
     * Contatena todos los elementos de la lista de tipo String
     *
     * @param listaCampos Lista que quiere concatenar sus elementos
     * @return Cadena concatenada de la lista de elementos
     */
    private String mensajeCampos(List<String> listaCampos) {
        String mensaje = "";
        for (String campo : listaCampos) {
            mensaje += campo + "\n";
        }
        return mensaje;
    }
}
