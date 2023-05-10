/**
 * DireccionNegocio.java
 * 8 may. 2023 10:36:16
 */
package org.itson.implementacion;

import com.dominio.Direccion;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;
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
public class DireccionNegocio implements CrudInterface<Direccion> {

    private final IConsultasDAO direccionDAO;

    /**
     *
     */
    public DireccionNegocio() {
        direccionDAO = new DAOFactory().getDireccionesDAO();
    }

    @Override
    public Direccion insertar(Direccion elemento) throws NegocioExcepcion {
        try {
            this.validarDireccionInsertar(elemento);
            direccionDAO.insertar(elemento);
        } catch (ValidacionExcepcion e) {
            throw new NegocioExcepcion(e.getMessage());
        } catch (PersistenciaException a) {
            throw new NegocioExcepcion(a.getMessage());
        }
        return elemento;
    }

    @Override
    public Direccion eliminar(Direccion elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Direccion actualizar(Direccion elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Direccion> consultar() throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Direccion> consultar(Direccion elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Direccion validarDireccionInsertar(Direccion direccion) throws ValidacionExcepcion {
        List<String> camposError = new LinkedList<>();

        if (direccion == null) {
            //Direccion no está inicializado
            throw new ValidacionExcepcion("No hay ningun dato de direccion");
        }

        //Validar calle
        String calle = direccion.getCalle();
        if (validarTextoVacio(calle) == null) {
            camposError.add("- Calle");
        }

        //Validar colonia
        String colonia = direccion.getColonia();
        if (validarTextoVacio(colonia) == null) {
            camposError.add("- Colonia");
        }
        
        //Validar número
        String numero = direccion.getNumero();
        if (validarTextoVacio(numero) == null) {
            camposError.add("- Número");
        }

        //Validar ciudad
        String ciudad = direccion.getCiudad();
        if (validarTextoVacio(ciudad) == null) {
            camposError.add("- Ciudad");
        }

        if (camposError.isEmpty()) {
            //Si la lista está vacía
            //Se regresa la direccion
            return direccion;
        }

        String mensaje = mensajeCampos(camposError);

        throw new ValidacionExcepcion(mensaje);

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

    @Override
    public List<Direccion> consultar(ObjectId id) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
