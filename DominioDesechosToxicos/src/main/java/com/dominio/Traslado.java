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
     * Adminisitrador que registro el Traslado
     */
    private Administrador administrador;
    /**
     * Direccion a la que se dirige el Traslado
     */
    private Direccion direccion;
    /**
     * Empresas transportadoras que se encargaran del Traslado
     */
    private List<EmpresaTransportista> empresas_trasnportistas;

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
     * @param administrador Administrador a asignar
     * @param direccion Direccion a asignar
     * @param transporte Trasnporte a asignar
     */
    public Traslado(ObjectId id, Residuo residuo, Administrador administrador, Direccion direccion, List<EmpresaTransportista> empresas_trasnportistas) {
        this.id = id;
        this.residuo = residuo;
        this.administrador = administrador;
        this.direccion = direccion;
        this.empresas_trasnportistas = empresas_trasnportistas;
    }

    /**
     * Constructor que le asigna valores a todos los atributos del Traslado
     * menos el Id
     *
     * @param cantidadResiduo cantidad de residuos a asignar
     * @param residuo Residuo a asignar
     * @param administrador Administrador a asignar
     * @param direccion Direccion a asignar
     * @param transporte Trasnporte a asignar
     */
    public Traslado(Residuo residuo, Administrador administrador, Direccion direccion, List<EmpresaTransportista> empresas_trasnportistas) {
        this.residuo = residuo;
        this.administrador = administrador;
        this.direccion = direccion;
        this.empresas_trasnportistas = empresas_trasnportistas;
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
     * @return el Administrador del Traslado
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * Le asigna un Administrador al Traslado
     *
     * @param administrador a asignar
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Regresa la Direccion del Traslado
     *
     * @return Direccion del Traslado
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Le asigna una Direccion al Traslado
     *
     * @param direccion objeto Direccion a asignar
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Regresa la lista de Empresas Trasnportistas asignadas
     *
     * @return Lista de EmpresasTrasnportistas
     */
    public List<EmpresaTransportista> getEmpresas_trasnportistas() {
        return empresas_trasnportistas;
    }

    /**
     * Le asigna una Lista de Empresas Transportistas
     *
     * @param empresas_trasnportistas a asignar
     */
    public void setEmpresas_trasnportistas(List<EmpresaTransportista> empresas_trasnportistas) {
        this.empresas_trasnportistas = empresas_trasnportistas;
    }

}
