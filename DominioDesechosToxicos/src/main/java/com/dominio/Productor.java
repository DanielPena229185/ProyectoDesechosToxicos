package com.dominio;

import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa una empresa productora de la
 * clase padre que es Empresa.
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class Productor extends Empresa {

    /**
     * Lista de residuos registrados por la empresa
     */
    private List<Residuo> residuos;

    /**
     * Lista de solicitudes hechos por la empresa
     */
    private List<Solicitud> solicitudes;

    /**
     * Constructor por default
     */
    public Productor() {
        super();
    }

    /**
     * Constructor con lista de residuos, lista de solicitudes, identificador,
     * nombre, lista direcciones
     *
     * @param residuos Lista de residuos
     * @param solicitudes Lista de solicitudes
     * @param id Identificador de la empresa
     * @param tipo Tipo de empresa
     * @param nombre Nombre de la empresa
     * @param direcciones Lista de direcciones de la empresa
     */
    public Productor( ObjectId id, List<Residuo> residuos, List<Solicitud> solicitudes, Tipo tipo, String nombre, List<Direccion> direcciones) {
        super(id,tipo, nombre, direcciones);
        this.residuos = residuos;
        this.solicitudes = solicitudes;
    }

    /**
     * Constructor con lista de residuos, lista de solicitudes, nombre y lista
     * de direcciones
     *
     * @param residuos Lista de residuos
     * @param solicitudes Lista de solicitudes
     * @param tipo Tipo de empresa
     * @param nombre Nombre de la empresa
     * @param direcciones Lista de direcciones de la empresa
     */
    public Productor(List<Residuo> residuos, List<Solicitud> solicitudes,Tipo tipo, String nombre, List<Direccion> direcciones) {
        super(tipo,nombre, direcciones);
        this.residuos = residuos;
        this.solicitudes = solicitudes;
    }

    /**
     * Constructor con la lista de residuos, lista solicitudes y nombre
     *
     * @param residuos Lista de residuos
     * @param solicitudes Lista de solicitudes
     * @param tipo Tipo de empresa
     * @param nombre Nombre de la empresa
     */
    public Productor(List<Residuo> residuos, List<Solicitud> solicitudes,Tipo tipo, String nombre) {
        super(tipo,nombre);
        this.residuos = residuos;
        this.solicitudes = solicitudes;
    }

    /**
     * Obtener la lista de residuos
     *
     * @return Lista de residuos
     */
    public List<Residuo> getResiduos() {
        return residuos;
    }

    /**
     * Establecer una lista de residuos
     *
     * @param residuos Lista de residuos
     */
    public void setResiduos(List<Residuo> residuos) {
        this.residuos = residuos;
    }

    /**
     * Agregar un residuo a la lista de residuos
     *
     * @param residuo Residuo a agregar a la lista
     * @return Lista de residuos
     */
    public List<Residuo> agregarResiduo(Residuo residuo) {
        if (this.residuos == null) {
            this.residuos = new LinkedList<>();
        }
        this.residuos.add(residuo);
        return residuos;
    }

    /**
     * Obtener la lista de solicitudes
     *
     * @return Lista de solicitudes
     */
    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    /**
     * Establece la lista de solicitudes
     *
     * @param solicitudes Lista de solicitudes
     */
    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    /**
     * Agregar un solicitud a la lista de solicitudes
     *
     * @param solicitud Solicitud a agregar a la lista
     * @return Lista de solicitudes
     */
    public List<Solicitud> agregarSolicitud(Solicitud solicitud) {
        if (this.solicitudes == null) {
            this.solicitudes = new LinkedList<>();
        }
        this.solicitudes.add(solicitud);
        return solicitudes;
    }
}
