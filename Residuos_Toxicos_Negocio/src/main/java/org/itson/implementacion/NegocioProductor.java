/**
 * NegocioProductor.java
 * 11 may. 2023 17:47:57
 */
package org.itson.implementacion;

import com.dominio.Productor;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.itson.DTO.ProductorDTO;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.implementaciones.bd.DAOFactory;
import org.itson.interfaces.INegocioProductor;
import org.itson.interfaces.IProductoresDAO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioProductor implements INegocioProductor {

    IProductoresDAO productoresDAO;

    /**
     * Constructor por default
     */
    public NegocioProductor() {
        productoresDAO = DAOFactory.getProductoresDAO();
    }

    @Override
    public Productor loginProductor(ProductorDTO productorDTO) throws NegocioException {
        try {

            if (productorDTO == null) {
                throw new ValidacionException("No hay ningún dato del productor");
            }

            String correo = validarCorreo(productorDTO.getEmail());
            String contrasena = validarContrasena(productorDTO.getContrasena());
            Productor productor = productoresDAO.consultarLogin(correo, contrasena);

            return productor;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        } catch (ValidacionException a) {
            throw new NegocioException("Errores inválidos: " + a.getMessage());
        }

    }

    private String validarCorreo(String correo) throws ValidacionException {

        List<String> camposError = new LinkedList<>();

        if (correo == null) {
            throw new ValidacionException("No hay ningún dato del correo");
        }

        if (validarTextoVacio(correo)) {
            camposError.add("Correo vacío");
        } else if (validarCorreoElectronico(correo)) {
            camposError.add("Correo no cumple con el formato de un correo\n"
                    + "electrónico");
        }

        if (camposError.isEmpty()) {
            return correo;
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

    public boolean validarCorreoElectronico(String correo) {
        // Expresión regular para validar el formato de un correo electrónico
        String patron = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        // Se compila el patrón en una expresión regular
        Pattern pattern = Pattern.compile(patron);

        // Se comprueba si el correo cumple con el patrón
        Matcher matcher = pattern.matcher(correo);
        return !matcher.matches();
    }

    public String validarContrasena(String contrasena) throws ValidacionException {

        List<String> camposError = new LinkedList<>();

        if (contrasena == null) {
            throw new ValidacionException("No hay ninguna información de la contraseña");
        }

        if (validarTextoVacio(contrasena)) {
            camposError.add("Contraseña vacía");
        }

        if (camposError.isEmpty()) {
            return contrasena;
        }

        String mensaje = mensajeCampos(camposError);

        throw new ValidacionException(mensaje);
    }

    @Override
    public Productor insertarProductor(Productor productor) throws NegocioException {
        try {
            productoresDAO.insertar(productor);
            return productor;
        } catch (PersistenciaException e) {
            System.out.println("jdibidbibipn");
            throw new NegocioException(e.getMessage());
        }

    }
}
