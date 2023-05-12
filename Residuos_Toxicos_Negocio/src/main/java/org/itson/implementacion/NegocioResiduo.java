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

    /**
     * Se inserta el residuo a la base de datos, por medio de la capa de
     * persistencia
     *
     * @param residuo Residuo que se desea insertar
     * @return Residuo insertado
     * @throws NegocioExcepcion En caso que ocurra algún error al momento de
     * insertar o no cumpla las validaciones previas
     */
    @Override
    public Residuo insertarResiduo(Residuo residuo) throws NegocioExcepcion {
        try {
            
            if (residuo == null) {
                //Sí el residuo es nulo
                throw new ValidacionExcepcion("No hay información del residuo");
            }
            
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

    /**
     * Válida si el residuo es óptimo para insertarlo en la base de datos
     *
     * @param residuo Residuo que desea validar
     * @return Residuo en caso que no haya ningún error
     * @throws ValidacionExcepcion Mensaje de que campos fueron los que no
     * cumplieron las validaciones
     */
    private Residuo validarResiduo(Residuo residuo) throws ValidacionExcepcion {
        List<String> camposErroneos = new LinkedList<>();
        if (residuo == null) {
            //Si el residuo es nulo
            throw new ValidacionExcepcion("No hay información del residuo");
        }

        //Validamos el nombre del residuo
        String nombre = residuo.getNombre();
        if (this.validarTextoVacio(nombre)) {
            //Si el nombre no está disponible, ya sea que esté vacío o nulo
            camposErroneos.add("- No contiene nombre");
        }

        //Validamos el código del residuo
        String codigo = residuo.getCodigo();
        if (this.validarTextoVacio(codigo)) {
            //Si sea nulo o esté vacío
            camposErroneos.add("- No contiene código");
        } else if (this.validarFormatoCodigo(codigo)) {
            //Si el código no está nulo o vacío, pero no cumple con el formato
            camposErroneos.add("- El código no cumple con el formato (Formato abc-123)");
        }

        //Validamos que la lista de químicos no esté vacía
        List<Quimico> listaQuimicos = residuo.getQuimicos();
        if (this.validarListaVacia(listaQuimicos)) {
            //Si la lista de químicos está vacía
            camposErroneos.add("- No hay compuestos químicos");
        }

        if (listaQuimicos.size() < 2) {
            //Si la lista tiene menos de dos químicos
            camposErroneos.add("- El residuo debe estar compuesto por almenos dos químicos");
        }

        //Si no hay ningún error, se regresa el residuo
        if (camposErroneos.isEmpty()) {
            //Regresa residuo
            return residuo;
        }

        //En caso de que haya elementos en la lista de campos erroneos, se 
        //genera un mensaje y se guarda en un string
        String camposVacios = this.mensajeCampos(camposErroneos);

        //Lanza el todos los elementos erroneos por los que no cumplieron las 
        //validaciones
        throw new ValidacionExcepcion(camposVacios);
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

    /**
     * Válida si un texto cumple con el formato de ABC-123
     *
     * @param texto Texto que se quiere validar
     * @return True si el formato no cumple, true en caso contrario
     */
    private boolean validarFormatoCodigo(String texto) {
        String regex = "[A-Za-z]{3}-[0-9]{3}";
        if (texto.matches(regex)) {
            return false;
        }
        return true;
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

    /**
     * Realiza la particion de un residuo y así conservar la información del
     * residuo que solo tenga relevancia
     *
     * @param residuo Residuo al que se le quiere realizar la partición
     * @return Residuo con partición
     * @throws ValidacionExcepcion En caso que el residuo sea nulo
     */
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
        //Limpiar lista de direcciones
        productor.setDirecciones(null);
        //Limpia informacion de la cuenta
        productor.setCuenta(null);
        //Se actualiza el productor del residuo
        residuo.setProductor(productor);
        return residuo;
    }
}