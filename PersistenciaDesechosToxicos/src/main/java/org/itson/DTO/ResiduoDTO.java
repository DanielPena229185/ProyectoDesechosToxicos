/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.DTO;

import com.dominio.Quimico;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase DTO del Residuo
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID: 233184
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID: 229185
 */
public class ResiduoDTO {

    private ObjectId id_EmpresaProductora;
    private String nombreEmpresaProductora;
    private String clave;
    private String nombre;
    private List<Quimico> quimicos;

    public ResiduoDTO() {
    }

    public ObjectId getId_EmpresaProductora() {
        return id_EmpresaProductora;
    }

    public void setId_EmpresaProductora(ObjectId id_EmpresaProductora) {
        this.id_EmpresaProductora = id_EmpresaProductora;
    }

    public String getNombreEmpresaProductora() {
        return nombreEmpresaProductora;
    }

    public void setNombreEmpresaProductora(String nombreEmpresaProductora) {
        this.nombreEmpresaProductora = nombreEmpresaProductora;
    }
    
    

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Quimico> getQuimicos() {
        return quimicos;
    }

    public void setQuimicos(List<Quimico> quimicos) {
        this.quimicos = quimicos;
    }
    
    
    
}
