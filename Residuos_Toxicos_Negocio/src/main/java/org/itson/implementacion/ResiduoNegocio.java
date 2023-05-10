/**
 * ResiduoNegocio.java
 * 7 may. 2023 19:26:36
 */
package org.itson.implementacion;

import com.dominio.Quimico;
import com.dominio.Residuo;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.excepciones.ValidacionExcepcion;
import org.itson.interfaces.CrudInterface;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ResiduoNegocio implements CrudInterface<Residuo> {

    /**
     * Constructor por default
     */
    public ResiduoNegocio() {

    }

    @Override
    public Residuo insertar(Residuo elemento) throws NegocioExcepcion {
        try {
            
            this.validarResiduoInsertar(elemento);
            this.validarResiduoInexistente(elemento);
            
        } catch (ValidacionExcepcion e) {
            throw new NegocioExcepcion(e.getMessage());
        }
        return elemento;
    }

    @Override
    public Residuo eliminar(Residuo elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Residuo actualizar(Residuo elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Residuo> consultar() throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Residuo> consultar(Residuo elemento) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Residuo validarResiduoInsertar(Residuo residuo) throws ValidacionExcepcion {
        List<String> camposErroneos = new LinkedList<>();
        String nombre = residuo.getNombre();
        String codigo = residuo.getCodigo();
        List<Quimico> listaQuimicos = residuo.getQuimicos();

        if(residuo == null){
            throw new ValidacionExcepcion("No hay información del residuo");
        }

        if (this.validarFormatoCodigo(codigo) == null) {
            camposErroneos.add("- Código inválido (Formato abc-123)");
        }
        if (this.validarListaVacia(listaQuimicos) == null) {
            camposErroneos.add("- Lista de químicos vacía");
        }

        if (this.validarNombreVacio(nombre) == null) {
            camposErroneos.add("- Nombre vacío");
        }

        if (camposErroneos.isEmpty()) {
            return residuo;
        }

        String camposVacios = this.mensajeCampos(camposErroneos);

        throw new ValidacionExcepcion(camposVacios);
    }

    private List<Quimico> validarListaVacia(List<Quimico> lista) {
        if (lista.isEmpty()) {
            return null;
        }
        return lista;
    }

    private String validarFormatoCodigo(String codigo) {
        String regex = "[A-Za-z]{3}[0-9]{3}";
        if (codigo.matches(regex)) {
            return codigo;
        }
        return null;
    }

    private String validarNombreVacio(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return null;
        }

        return nombre;
    }

    private String mensajeCampos(List<String> listaCampos) {
        String mensaje = "";
        for (String campo : listaCampos) {
            mensaje += campo + "\n";
        }
        return mensaje;
    }

    private Residuo validarResiduoInexistente(Residuo residuo){
        List<String> camposExistentes = new LinkedList<>();
        List<Residuo> residuosMismoCodigo = validarCodigoResiduo(residuo);
        if(!residuosMismoCodigo.isEmpty()){
            camposExistentes.add("- Código");
        }
        
        List<Residuo> residuoMismaListaQuimicos = validarListaQuimicos(residuo);
        if(!residuoMismaListaQuimicos.isEmpty()){
            camposExistentes.add("- Lista de químicos");
        }
        
        List<Residuo> residuoMismoNombre = validarNombreResiduo(residuo);
        if(!residuoMismoNombre.isEmpty()){
            camposExistentes.add("- Nombre");
        }
        
        if(camposExistentes.isEmpty()){
            return residuo;
        }
        
        String campos = "Campos repetidos son: \n" 
                + this.mensajeCampos(camposExistentes);
        
        throw new ValidacionExcepcion(campos);
    }
    
    private List<Residuo> validarCodigoResiduo(Residuo residuo){
        Residuo residuoCodigo = new Residuo();
        residuoCodigo.setCodigo(residuo.getCodigo());
        return this.consultar(residuoCodigo);
    }
    
    private List<Residuo> validarNombreResiduo(Residuo residuo){
        Residuo residuoNombre = new Residuo();
        residuoNombre.setNombre(residuo.getNombre());
        return this.consultar(residuoNombre);
    }
    
    private List<Residuo> validarListaQuimicos(Residuo residuo){
        Residuo residuoListaQuimicos = new Residuo();
        residuoListaQuimicos.setQuimicos(residuo.getQuimicos());
        return this.consultar(residuoListaQuimicos);
    }

    @Override
    public List<Residuo> consultar(ObjectId id) throws NegocioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
