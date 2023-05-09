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

    @Override
    public Administrador insertar(Administrador elemento) throws NegocioExcepcion {
        try {
            this.validarAdministrador(elemento);
            administradorDAO.insertar(elemento);
        } catch (PersistenciaException e) {
            throw new NegocioExcepcion(e.getMessage())
        } catch (ValidacionExcepcion a){
            throw new NegocioExcepcion(a.getMessage());
        }
        return elemento;
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

    private Administrador validarAdministrador(Administrador administrador) throws ValidacionExcepcion {

        List<String> camposErroneos = new LinkedList<>();

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
        String correoCuenta = administrador.getCuenta().getCorreo();
        if (validarTextoVacio(correoCuenta) == null) {
            camposErroneos.add("- Correo");
        }
        //Validar contraseña
        String contrasenaCuenta = administrador.getCuenta().getCorreo();
        if (validarTextoVacio(contrasenaCuenta) == null) {
            camposErroneos.add("- Contraseña");
        }

        if (camposErroneos.isEmpty()) {
            //Si no hay elementos en la lista
            //Se regresa el administrador
            return administrador;
        }

        String campo = mensajeCampos(camposErroneos);

        throw new ValidacionExcepcion(campo);

    }

    private String mensajeCampos(List<String> listaCampos) {
        String mensaje = "";
        for (String campo : listaCampos) {
            mensaje += campo + "\n";
        }
        return mensaje;
    }

    private String validarTextoVacio(String texto) {
        if (texto == null || texto.isEmpty()) {
            return null;
        }
        return texto;
    }

}
