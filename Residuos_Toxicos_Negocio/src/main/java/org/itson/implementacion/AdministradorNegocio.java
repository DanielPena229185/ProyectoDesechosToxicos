/**
 * AdministradorNegocio.java
 * 8 may. 2023 10:35:11
 */
package org.itson.implementacion;

import com.dominio.Administrador;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.implementaciones.bd.DAOFactory;
import org.itson.interfaces.IConsultasDAO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class AdministradorNegocio{


    /**
     *
     */
    public AdministradorNegocio() {
    }

    /**
     *
     * @param elemento
     * @return
     * @throws NegocioException
     */
    public Administrador insertar(Administrador elemento) throws NegocioException {
        try {
            this.validarAdministradorInsertar(elemento);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        } catch (ValidacionException a) {
            throw new NegocioException(a.getMessage());
        }
        return elemento;
    }

    /**
     *
     * @param elemento
     * @return
     * @throws NegocioException
     */
    public Administrador eliminar(Administrador elemento) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @return @throws NegocioException
     */
    public List<Administrador> consultar() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param elemento
     * @return
     * @throws NegocioException
     */
    public List<Administrador> consultar(Administrador elemento) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param id
     * @return
     * @throws NegocioException
     */
    public List<Administrador> consultar(ObjectId id) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param administrador
     * @return
     * @throws ValidacionException
     */
    private Administrador validarAdministradorInsertar(Administrador administrador) throws ValidacionException {

        List<String> camposErroneos = new LinkedList<>();

        if (administrador == null) {
            throw new ValidacionException("No hay ninguna información de administrador");
        }

        //Validar nombres
        String nombres = administrador.getNombres();
        if (validarTextoVacio(nombres) == null) {
            camposErroneos.add("- Nombres");
        } else if (validarCaracteresEspeciales(nombres) == null) {
            camposErroneos.add("- Nombre con carácteres especiales");

        }
        //Validar apellido paterno
        String apellidoPaterno = administrador.getApellido_paterno();
        if (validarTextoVacio(apellidoPaterno) == null) {
            camposErroneos.add("- Apellido Paterno");
        } else if (validarCaracteresEspeciales(apellidoPaterno) == null) {
                camposErroneos.add("- Apellido Paterno con carácteres especiales");
            
        }
        //Validar apellido materno  
        String apellidoMaterno = administrador.getApellido_materno();
        if (validarTextoVacio(apellidoMaterno) == null) {
            camposErroneos.add("- Apellido Materno");
        } else {
            if (validarCaracteresEspeciales(apellidoMaterno) == null) {
                camposErroneos.add("- Apellido Materno con carácteres especiales");
            }
        }

        //Validar la cuenta del administrador
        //Validar correo
        if (administrador.getCuenta() != null) {
            String correoCuenta = administrador.getCuenta().getCorreo();
            if (validarTextoVacio(correoCuenta) == null) {
                camposErroneos.add("- Correo");
            }
            //Validar contraseña
            String contrasenaCuenta = administrador.getCuenta().getCorreo();
            if (validarTextoVacio(contrasenaCuenta) == null) {
                camposErroneos.add("- Contraseña");
            }
        } else {
            camposErroneos.add("- No contiene cuenta");
        }
        if (camposErroneos.isEmpty()) {
            //Si no hay elementos en la lista
            //Se regresa el administrador
            return administrador;
        }

        String campo = mensajeCampos(camposErroneos);

        throw new ValidacionException(campo);

    }

    private Administrador validarAdministradorEliminar(Administrador administrador) throws ValidacionException {
        List<String> camposErroneos = new LinkedList<>();
        if (administrador == null) {
            throw new ValidacionException("Datos del administrador inválidos");
        }
        return administrador;
    }

    /**
     * Regresa una un mensaje contatenado de una lista
     *
     * @param listaCampos Liusta donde los mensajes se contatenan
     * @return Mensaje contatenado
     */
    private String mensajeCampos(List<String> listaCampos) {
        String mensaje = "";
        for (String campo : listaCampos) {
            mensaje += campo + "\n";
        }
        return mensaje;
    }

    /**
     * Valida que un texto no esté vacío
     *
     * @param texto Texto que se quiere validar
     * @return Texto válido, de lo contrario null
     */
    private String validarTextoVacio(String texto) {
        if (texto == null || texto.isEmpty()) {
            return null;
        }
        return texto;
    }

    /**
     * Valida que un texto no tenga carácteres especiales
     *
     * @param texto
     * @return
     */
    public static String validarCaracteresEspeciales(String texto) {
        String patron = "^[a-zA-Z]*$"; // Expresión regular que solo permite letras y números
        if (texto.matches(patron)) {
            return texto; // El texto es válido, se devuelve el mismo texto
        }
        return null;
    }

    public Administrador actualizar(Administrador elemento, Administrador elementoE) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
