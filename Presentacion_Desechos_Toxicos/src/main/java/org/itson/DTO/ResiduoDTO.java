/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.DTO;

import com.dominio.Quimico;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Descripción de la clase: Esta clase representa un DTO para un residuo
 * Contiene informacion básica de un residuo como su identificador de empresa productora, nombre de la empresa productora,
 * clave del residuo, nombre del residuo y lista de quimicos asociados al residuo
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class ResiduoDTO {
    /**
     * El ID de la empresa productora a la que pertenece el quimico
     */
    private ObjectId id_EmpresaProductora;
    /**
     * El nombre de la empresa productora a la que pertenece el quimico
     */
    private String nombreEmpresaProductora;
    /**
     * La clave unica del químico
     */
    private String clave;
    /**
     * El nombre del quimico
     */
    private String nombre;
    /**
     * La lista de quimicos asociados a esta empresa productora
     */
    private List<Quimico> quimicos;

    /**
     * Constructor vacio
     */
    public ResiduoDTO() {
    }

    /**
     * Obtiene el identificador de la empresa productora del residuo
     * @return el identificador de la empresa productora del residuo
     */
    public ObjectId getId_EmpresaProductora() {
        return id_EmpresaProductora;
    }
    /**
     * Establece el identificador de la empresa productora del residuo
     * @param id_EmpresaProductora el identificador de la empresa productora del residuo
     */
    public void setId_EmpresaProductora(ObjectId id_EmpresaProductora) {
        this.id_EmpresaProductora = id_EmpresaProductora;
    }
    /**
     * Obtiene el nombre de la empresa productora del residuo
     * @return el nombre de la empresa productora del residuo
     */
    public String getNombreEmpresaProductora() {
        return nombreEmpresaProductora;
    }
    /**
     * Establece el nombre de la empresa productora del residuo
     * @param nombreEmpresaProductora el nombre de la empresa productora del residuo
     */
    public void setNombreEmpresaProductora(String nombreEmpresaProductora) {
        this.nombreEmpresaProductora = nombreEmpresaProductora;
    }
    /**
     * Obtiene la clave del residuo
     * @return la clave del residuo
     */
    public String getClave() {
        return clave;
    }
    /**
     * Establece la clave del residuo
     * @param clave del residuo
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    /**
     * Obtiene el nombre del residuo
     * @return el nombre del residuo
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del residuo
     * @param nombre del residuo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene la lista de quimicos asociados al residuo
     * @return la lista de quimicos asociados al residuo
     */
    public List<Quimico> getQuimicos() {
        return quimicos;
    }
    /**
     * Establece la lista de quimicos asociados al residuo
     * @param quimicos @param quimicos la lista de quimicos asociados al residuo
     */
    public void setQuimicos(List<Quimico> quimicos) {
        this.quimicos = quimicos;
    }

    
     
}
