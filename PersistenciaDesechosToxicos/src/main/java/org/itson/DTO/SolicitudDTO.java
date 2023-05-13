
package org.itson.DTO;

import com.dominio.Estado;
import com.dominio.Residuo;
import java.util.Date;
import java.util.List;

/**
 * Descripción de la clase: Esta clase representa un DTO de una solicitud
 * Contiene informacion sobre la fecha de solicitud, el estado de la solicitud, lista de
 * residuos asociados a la solicitud y el nombre del productor que ha realizado la solicitud, 
 * ademas que proporciona el acceder y modificar los datos de la solicitud
 * @author oscar
 */
public class SolicitudDTO {
    private Date fechaSolicitada;
    private Estado estado;
    private List<Residuo> residuos;
    private String nombreProductor;
    /**
     * Constructor vacio
     */
    public SolicitudDTO() {
    }
    /**
     * Crea una instancia de SolicitudDTO con valores especificos para sus atributos
     * @param fechaSolicitada la fecha en que se hizo la solicitud
     * @param estado  actual de la solicitud
     * @param residuos que se solicitan gestionar
     * @param nombreProductor que hizo la solicitud.
     */
    public SolicitudDTO(Date fechaSolicitada, Estado estado, List<Residuo> residuos, String nombreProductor) {
        this.fechaSolicitada = fechaSolicitada;
        this.estado = estado;
        this.residuos = residuos;
        this.nombreProductor = nombreProductor;
    }
    /**
     * Obtiene la fecha en que se hizo la solicitud
     * @return la fecha en que se hizo la solicitud.
     */
    public Date getFechaSolicitada() {
        return fechaSolicitada;
    }
    /**
     * Establece la fecha en que se hizo la solicitud
     * @param fechaSolicitada en que se hizo la solicitud
     */
    public void setFechaSolicitada(Date fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }
    /**
     * Obtiene el estado actual de la solicitud
     * @return el estado actual de la solicitud
     */
    public Estado getEstado() {
        return estado;
    }
    /**
     * Establece el estado actual de la solicitud
     * @param estado actual de la solicitud
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    /**
     * Devuelve la lista de residuos a recolectar
     * @return La lista de residuos a recolectar
     */
    public List<Residuo> getResiduos() {
        return residuos;
    }
    /**
     * Establece la lista de residuos a recolectar
     * @param residuos La lista de residuos a recolectar
     */
    public void setResiduos(List<Residuo> residuos) {
        this.residuos = residuos;
    }
    /**
     * Obtiene el nombre del productor que hizo la solicitud
     * @return el nombre del productor que hizo la solicitud
     */
    public String getNombreProductor() {
        return nombreProductor;
    }
    /**
     * Establece el nombre del productor que hizo la solicitud
     * @param nombreProductor el nombre del productor que hizo la solicitud
     */
    public void setNombreProductor(String nombreProductor) {
        this.nombreProductor = nombreProductor;
    }
    /**
     * Devuelve una representacion en formato de cadena del objeto
     * @return una representación en formato de cadena del objeto inlcluyendo el valor de sus campos
     */
    @Override
    public String toString() {
        return "SolicitudDTO{" + "fechaSolicitada=" + fechaSolicitada + ", estado=" + estado + ", residuos=" + residuos + ", nombreProductor=" + nombreProductor + '}';
    }
}
