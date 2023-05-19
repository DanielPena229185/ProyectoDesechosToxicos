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
import org.bson.types.ObjectId;
import org.itson.DTO.ResiduoDTO;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.implementaciones.fachada.FachadaPersistencia;
import org.itson.interfaces.INegocioResiduo;
import org.itson.interfaces.IPersistencia;

/**
 * Descripción de la clase: Se encarga de manejar las operaciones relacionadas con los residuos en un sistema.
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NegocioResiduo implements INegocioResiduo {

    IPersistencia persistencia;

    /**
     * Constructor por default
     */
    public NegocioResiduo() {
        persistencia = new FachadaPersistencia();
    }

    /**
     * Se inserta el residuo a la base de datos, por medio de la capa de
     * persistencia
     *
     * @param residuo Residuo que se desea insertarTraslado
     * @return Residuo insertado
     * @throws NegocioException En caso que ocurra algún error al momento de
     * insertarTraslado o no cumpla las validaciones previas
     */
    @Override
    public Residuo insertarResiduo(Residuo residuo) throws NegocioException {
        try {

            if (residuo == null) {
                //Sí el residuo es nulo
                throw new ValidacionException("No hay información del residuo");
            }

            //Valida si el residuo cumple las validaciones para guardarse en la
            //Base de datos
            this.validarResiduoInsertar(residuo);

            //Valida si el residuo ya existe
            this.validarInexistenciaResiduo(residuo);

            //Realiza las particiones para solo guardar lo importante del
            //productor
            this.realizarParticiones(residuo);

            //Se inserta el residuo a la base de datos
            persistencia.insertarResiduo(residuo);

            //Regresa el residuo guardado
            return residuo;
        } catch (ValidacionException validacionExcepcion) {
            //Si ocurre un error en las validaciones
            throw new NegocioException(validacionExcepcion.getMessage());

        } catch (PersistenciaException persistencia) {
            //Si ocurre un error en la capa de persistencia
            throw new NegocioException(persistencia.getMessage());

        }

    }
    /**
     * Consulta los Residuos del sistema aplicando un filtro.
     * @param residuo el objeto Residuo utilizado como filtro de consulta.
     * @return una lista de objetos Residuo que cumplen con el filtro.
     * @throws NegocioException si ocurre un error en la lógica de negocio.
     */
    @Override
    public List<Residuo> consultarResiduosFiltro(Residuo residuo) throws NegocioException {
        try {
            ResiduoDTO residuoDTO = convertirResiduoToDTO(residuo);
            return persistencia.consultarResiduoFiltro(residuoDTO);
        } catch (ValidacionException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Válida si el residuo es óptimo para insertarlo en la base de datos
     *
     * @param residuo Residuo que desea validar
     * @return Residuo en caso que no haya ningún error
     * @throws ValidacionException Mensaje de que campos fueron los que no
     * cumplieron las validaciones
     */
    private Residuo validarResiduoInsertar(Residuo residuo) throws ValidacionException {
        List<String> camposErroneos = new LinkedList<>();
        if (residuo == null) {
            //Si el residuo es nulo
            throw new ValidacionException("No hay información del residuo");
        }

        //Validamos el nombre del residuo
        String nombre = residuo.getNombre();
        if (this.validarTextoVacio(nombre)) {
            //Si el nombre no está disponible, ya sea que esté vacío o nulo
            camposErroneos.add("- No contiene nombre");
        }else if (!validarTexto(nombre)){
            camposErroneos.add("- Ingresa un nombre más simple que [" + nombre + ']');
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
        } else if (listaQuimicos.size() < 2) {
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
        throw new ValidacionException(camposVacios);
    }
    /**
     * Valida si un texto contiene únicamente letras y espacios.
     * @param texto el texto a validar.
     * @return true si el texto es válido, false de lo contrario.
     */
    public boolean validarTexto(String texto) {
        // Expresión regular que valida un texto sin números ni caracteres especiales
        String patron = "^[a-zA-Z]+([\\s][a-zA-Z]+)*$";
        return texto.matches(patron);
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
     * @throws ValidacionException En caso que el residuo sea nulo
     */
    private Residuo realizarParticiones(Residuo residuo) throws ValidacionException {

        if (residuo == null) {
            //Residuo es nulo
            throw new ValidacionException("No hay información del residuo");
        }

        //Solo permitimos el acceso a los datos del productor necesario
        if (residuo.getProductor() == null) {
            throw new ValidacionException("No hay informacion del productor");
        }
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
    /**
     * Convierte un objeto Residuo en un objeto ResiduoDTO.
     * @param residuo el objeto Residuo a convertir.
     * @return el objeto ResiduoDTO resultante de la conversión.
     * @throws ValidacionException si el objeto Residuo no pasa las validaciones.
     */
    private ResiduoDTO convertirResiduoToDTO(Residuo residuo) throws ValidacionException {

        ResiduoDTO residuoDTO = new ResiduoDTO();

        if (residuo == null) {
            throw new ValidacionException("No hay información del residuo");
        }

        String clave = residuo.getCodigo();
        residuoDTO.setClave(clave);
        String nombre = residuo.getNombre();
        residuoDTO.setNombre(nombre);
        List<Quimico> quimicos = residuo.getQuimicos();
        residuoDTO.setQuimicos(quimicos);

        Productor productor = residuo.getProductor();
        if (productor != null) {
            residuoDTO.setNombreEmpresaProductora(residuo.getProductor().getNombre());

            residuoDTO.setId_EmpresaProductora(residuo.getProductor().getId());
        }
        return residuoDTO;
    }
    /**
     * Valida la inexistencia de un objeto Residuo en el sistema.
     * @param residuo el objeto Residuo a validar.
     * @return el Residuo validado si no existe en el sistema.
     * @throws ValidacionException si el objeto Residuo ya existe en el sistema.
     */
    private Residuo validarInexistenciaResiduo(Residuo residuo) throws ValidacionException {

        List<String> campoError = new LinkedList<>();

        if (residuo == null) {
            throw new ValidacionException("No hay información del residuo");
        }

        //Validar que no exista el código
        String codigo = residuo.getCodigo();
        if (validarCodigoExistenteResiduo(codigo)) {
            campoError.add("- Mismo código");
        }

        //Validar que no exista el nombre
        String nombre = residuo.getNombre();
        if (validarNombreExistenteResiduo(nombre)) {
            campoError.add("- Mismo nombre");
        }

        //Validar que no existan los mismos químicos en un residuo
        List<Quimico> quimicos = residuo.getQuimicos();
        if (validarListaQuimicosExistenteResiduo(quimicos)) {
            campoError.add("- Mismos químicos");
        }

        if (campoError.isEmpty()) {
            return residuo;
        }

        String mensaje = mensajeCampos(campoError);

        throw new ValidacionException("Ya existen los siguientes datos: \n"
                + mensaje);
    }
    /**
     * Valida si existe un residuo con el mismo código en el sistema.
     * @param codigo el código a validar.
     * @return true si existe un residuo con el mismo código, false de lo contrario.
     */
    private boolean validarCodigoExistenteResiduo(String codigo) {
        Residuo residuo = new Residuo();
        residuo.setCodigo(codigo);
        int elementos = this.consultarResiduosFiltro(residuo).size();
        if (elementos > 0) {
            return true;
        }
        return false;
    }
    /**
     * Valida si existe un residuo con el mismo nombre en el sistema
     * @param nombre el nombre a validar.
     * @return true si existe un residuo con el mismo nombre, false de lo contrario.
     */
    private boolean validarNombreExistenteResiduo(String nombre) {
        Residuo residuo = new Residuo();
        residuo.setNombre(nombre);
        int elementos = this.consultarResiduosFiltro(residuo).size();
        if (elementos > 0) {
            return true;
        }
        return false;
    }
    /**
     * Valida si existe un residuo con los mismos químicos en el sistema.
     * @param quimicos la lista de químicos a validar.
     * @return true si existe un residuo con los mismos químicos, false de lo contrario.
     */
    private boolean validarListaQuimicosExistenteResiduo(List<Quimico> quimicos) {
        Residuo residuo = new Residuo();
        residuo.setQuimicos(quimicos);
        int elementos = this.consultarResiduosFiltro(residuo).size();
        if (elementos > 0) {
            return true;
        }
        return false;
    }

}
