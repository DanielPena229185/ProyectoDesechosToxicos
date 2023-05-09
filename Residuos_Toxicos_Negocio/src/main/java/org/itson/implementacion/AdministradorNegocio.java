/**
 * AdministradorNegocio.java
 * 8 may. 2023 10:35:11
 */
package org.itson.implementacion;

import com.dominio.Administrador;
import java.util.LinkedList;
import java.util.List;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionExcepcion;
import org.itson.implementaciones.bd.DAOFactory;
import org.itson.interfaces.CrudInterface;
import org.itson.interfaces.IConsultasDAO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class AdministradorNegocio implements CrudInterface<Administrador> {

    private final IConsultasDAO administradorDAO;

    /**
     *
     */
    public AdministradorNegocio() {
        administradorDAO = new DAOFactory().getAdministradoresDAO();
    }

    /**
     *
     * @param elemento
     * @return
     * @throws NegocioExcepcion
     */
    @Override
    public Administrador insertar(Administrador elemento) throws NegocioExcepcion {
        try {
            this.validarAdministrador(elemento);
            administradorDAO.insertar(elemento);
        } catch (PersistenciaException e) {
            throw new NegocioExcepcion(e.getMessage());
        } catch (ValidacionExcepcion a) {
            throw new NegocioExcepcion(a.getMessage());
        }
        return elemento;
    }

    /**
     *
     * @param elemento
     * @return
     * @throws NegocioExcepcion
     */
    @Override
    public Administrador eliminar(Administrador elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param elemento
     * @return
     * @throws NegocioExcepcion
     */
    @Override
    public Administrador actualizar(Administrador elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @return @throws NegocioExcepcion
     */
    @Override
    public List<Administrador> consultar() throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param elemento
     * @return
     * @throws NegocioExcepcion
     */
    @Override
    public List<Administrador> consultar(Administrador elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param administrador
     * @return
     * @throws ValidacionExcepcion
     */
    private Administrador validarAdministrador(Administrador administrador) throws ValidacionExcepcion {

        List<String> camposErroneos = new LinkedList<>();

        if (administrador == null) {
            throw new ValidacionExcepcion("No hay ninguna información de administrador");
        }

        //Validar nombres
        String nombres = administrador.getNombres();
        if (validarTextoVacio(nombres) == null) {
            camposErroneos.add("- Nombres");
        }
        //Validar apellido paterno
        String apellidoPaterno = administrador.getApellido_paterno();
        if (validarTextoVacio(apellidoPaterno) == null) {
            camposErroneos.add("- Apellido Paterno");
        }
        //Validar apellido materno  
        String apellidoMaterno = administrador.getApellido_materno();
        if (validarTextoVacio(apellidoMaterno) == null) {
            camposErroneos.add("- Apellido Materno");
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
        }else{
            camposErroneos.add("- No contiene cuenta");
        }
        if (camposErroneos.isEmpty()) {
            //Si no hay elementos en la lista
            //Se regresa el administrador
            return administrador;
        }

        String campo = mensajeCampos(camposErroneos);

        throw new ValidacionExcepcion(campo);

    }

    /**
     *
     * @param listaCampos
     * @return
     */
    private String mensajeCampos(List<String> listaCampos) {
        String mensaje = "";
        for (String campo : listaCampos) {
            mensaje += campo + "\n";
        }
        return mensaje;
    }

    /**
     *
     * @param texto
     * @return
     */
    private String validarTextoVacio(String texto) {
        if (texto == null || texto.isEmpty()) {
            return null;
        }
        return texto;
    }

}
