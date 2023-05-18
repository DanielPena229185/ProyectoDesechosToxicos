/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import java.util.List;
import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa el Traslado
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class Traslado {

    /**
     * Id del Traslado
     */
    private ObjectId id;
    /**
     * Residuo que tendra el Traslado
     */
    private Residuo residuo;
    
    /**
     * Administrador que registro el Traslado
     */
    private Administrador administrador;

    /**
     * Solicitud que registro el Traslado
     */
    private Solicitud solicitud;
    /**
     * Empresas transportadoras que se encargaran del Traslado
     */
    private List<EmpresaTransportista> empresas_transportistas;

    /**
     * Constructor por defecto
     */
    public Traslado() {
    }

    /**
     * Constructor que le asigna valores a todos los atributos del Traslado
     *
     * @param id identificador a asignar
     * @param residuo Residuo a asignar
     * @param administrador
     * @param solicitud solicitud a asignar
     * @param direccion Direccion a asignar
     * @param empresas_transportistas
     */
    public Traslado(ObjectId id, Residuo residuo, Administrador administrador, Solicitud solicitud, List<EmpresaTransportista> empresas_transportistas) {    
        this.id = id;
        this.residuo = residuo;
        this.administrador = administrador;
        this.solicitud = solicitud;
        this.empresas_transportistas = empresas_transportistas;
    }

    /**
     * Constructor que le asigna valores a todos los atributos del Traslado
     * menos el Id
     *
     * @param residuo Residuo a asignar
     * @param administrador
     * @param solicitud solicitud a asignar
     * @param empresas_transportistas a asignar.
     * @param direccion Direccion a asignar
     */
    public Traslado(Residuo residuo, Administrador administrador, Solicitud solicitud, List<EmpresaTransportista> empresas_transportistas) {    
        this.residuo = residuo;
        this.administrador = administrador;
        this.solicitud = solicitud;
        this.empresas_transportistas = empresas_transportistas;
    }

    /**
     * Regresa el id del Traslado
     *
     * @return ObjectId del Traslado
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Le asigna un id al Traslado
     *
     * @param id ObjectId a asignar
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa el Residuo del Traslado
     *
     * @return Residuo del Traslado
     */
    public Residuo getResiduo() {
        return residuo;
    }

    /**
     * Le asigna el Residuo al Traslado
     *
     * @param residuo objeto Residuo a asignar
     */
    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    /**
     * Regresa el Administrador del Traslado
     *
     * @return el administrador del Traslado
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * Le asigna un administrador al Traslado
     *
     * @param administrador a asignar
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Regresa el solicitud del Traslado
     *
     * @return el solicitud del Traslado
     */
    public Solicitud getSolicitud() {
        return solicitud;
    }

    /**
     * Le asigna un solicitud al Traslado
     *
     * @param solicitud a asignar
     */
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    /**
     * Regresa la lista de Empresas Trasnportistas asignadas
     *
     * @return Lista de EmpresasTrasnportistas
     */
    public List<EmpresaTransportista> getEmpresas_transportistas() {
        return empresas_transportistas;
    }

    /**
     * Le asigna una Lista de Empresas Transportistas
     *
     * @param empresas_transportistas
     */
    public void setEmpresas_transportistas(List<EmpresaTransportista> empresas_transportistas) {
        this.empresas_transportistas = empresas_transportistas;
    }
}
