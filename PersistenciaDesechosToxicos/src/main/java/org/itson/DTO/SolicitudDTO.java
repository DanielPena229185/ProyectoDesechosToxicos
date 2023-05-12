/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.DTO;

import com.dominio.Estado;
import com.dominio.Residuo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author oscar
 */
public class SolicitudDTO {
    private Date fechaSolicitada;
    private Estado estado;
    private List<Residuo> residuos;
    private String nombreProductor;

    public SolicitudDTO() {
    }

    public SolicitudDTO(Date fechaSolicitada, Estado estado, List<Residuo> residuos, String nombreProductor) {
        this.fechaSolicitada = fechaSolicitada;
        this.estado = estado;
        this.residuos = residuos;
        this.nombreProductor = nombreProductor;
    }

    public Date getFechaSolicitada() {
        return fechaSolicitada;
    }

    public void setFechaSolicitada(Date fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Residuo> getResiduos() {
        return residuos;
    }

    public void setResiduos(List<Residuo> residuos) {
        this.residuos = residuos;
    }

    public String getNombreProductor() {
        return nombreProductor;
    }

    public void setNombreProductor(String nombreProductor) {
        this.nombreProductor = nombreProductor;
    }

    @Override
    public String toString() {
        return "SolicitudDTO{" + "fechaSolicitada=" + fechaSolicitada + ", estado=" + estado + ", residuos=" + residuos + ", nombreProductor=" + nombreProductor + '}';
    }
}
