/**
 * ResiduoNegocio.java
 * 7 may. 2023 19:26:36
 */
package org.itson.implementacion;

import com.dominio.Productor;
import com.dominio.Quimico;
import com.dominio.Residuo;
import java.util.LinkedList;
import java.util.List;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionExcepcion;
import org.itson.implementaciones.bd.DAOFactory;
import org.itson.interfaces.INegocioResiduo;
import org.itson.interfaces.IResiduosDAO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioResiduo implements INegocioResiduo {

    IResiduosDAO residuoDAO;

    /**
     * Constructor por default
     */
    public NegocioResiduo() {
        residuoDAO = DAOFactory.getResiduoDAO();
    }

    @Override
    public Residuo insertarResiduo(Residuo residuo) throws NegocioExcepcion {
        try {
            //Realiza las particiones para solo guardar lo importante del
            //productor
            this.realizarParticiones(residuo);
            //Valida si el residuo cumple las validaciones para guardarse en la
            //Base de datos
            this.validarResiduo(residuo);
            //Se inserta el residuo a la base de datos
            residuoDAO.insertar(residuo);
            //Regresa el residuo guardado
            return residuo;
        } catch (ValidacionExcepcion validacionExcepcion) {
            //Si ocurre un error en las validaciones
            throw new NegocioExcepcion(validacionExcepcion.getMessage());

        } catch (PersistenciaException persistencia) {
            //Si ocurre un error en la capa de persistencia
            throw new NegocioExcepcion(persistencia.getMessage());

        }

    }

    @Override
    public List<Residuo> consultarResiduos() throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Residuo> consultarResiduo(Residuo residuo) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Residuo> consultarResiduoFiltro(Residuo residuo) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Residuo validarResiduo(Residuo residuo) throws ValidacionExcepcion {
        List<String> camposErroneos = new LinkedList<>();

        if (residuo == null) {
            throw new ValidacionExcepcion("No hay información del residuo");
        }

        String nombre = residuo.getNombre();
        if (this.validarTextoVacio(nombre)) {
            camposErroneos.add("- No contiene nombre");
        }

        String codigo = residuo.getCodigo();
        if (this.validarTextoVacio(codigo)) {
            camposErroneos.add("- No contiene código");
        } else if (this.validarFormatoCodigo(codigo)) {
            camposErroneos.add("- El código no cumple con el formato (Formato abc-123)");
        }

        List<Quimico> listaQuimicos = residuo.getQuimicos();
        if (this.validarListaVacia(listaQuimicos)) {
            camposErroneos.add("- La lista de químicos está vacía");
        }

        if (camposErroneos.isEmpty()) {
            return residuo;
        }

        String camposVacios = this.mensajeCampos(camposErroneos);

        throw new ValidacionExcepcion(camposVacios);
    }

    private boolean validarListaVacia(List lista) {
        if (lista == null || lista.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean validarFormatoCodigo(String codigo) {
        String regex = "[A-Za-z]{3}-[0-9]{3}";
        if (codigo.matches(regex)) {
            return false;
        }
        return true;
    }

    private boolean validarTextoVacio(String texto) {
        if (texto == null || texto.isBlank()) {
            return true;
        }

        return false;
    }

    private String mensajeCampos(List<String> listaCampos) {
        String mensaje = "";
        for (String campo : listaCampos) {
            mensaje += campo + "\n";
        }
        return mensaje;
    }

    private Residuo realizarParticiones(Residuo residuo) throws ValidacionExcepcion {

        if (residuo == null) {
            //Residuo es nulo
            throw new ValidacionExcepcion("No hay información del residuo");
        }

        //Solo permitimos el acceso a los datos del productor necesario
        Productor productor = residuo.getProductor();
        //Limpiar lista de residuos
        productor.setResiduos(null);
        //Limpiar lista de solicitudes
        productor.setSolicitudes(null);

        residuo.setProductor(productor);
        return residuo;
    }
}
