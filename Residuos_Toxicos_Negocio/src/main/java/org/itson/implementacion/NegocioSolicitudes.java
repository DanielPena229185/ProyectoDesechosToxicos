/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementacion;

import com.dominio.MedidaResiduo;
import com.dominio.Residuo;
import java.util.Date;
import java.util.List;
import org.itson.excepciones.ValidacionExcepcion;

/**
 *
 * @author oscar
 */
public class NegocioSolicitudes {

    private Boolean validarFechaParaTrasladoDeResiduos(Date fecha) throws ValidacionExcepcion {
        if (!fecha.after(new Date())) {
            throw new ValidacionExcepcion("");
        }
        
        return true;
    }
    
    private Boolean validaQueTengaAlmenosUnResiduo(List<Residuo> residuos) throws ValidacionExcepcion {
        if (residuos.size() <= 0) {
            throw new ValidacionExcepcion("No se recibió ningún residuo.");
        }
        
        return true;
    }
    
    private Boolean validaLaUnidadDeMedida(Residuo residuo) throws ValidacionExcepcion {
        for (MedidaResiduo m : MedidaResiduo.values()) {
            if (!m.name().equals(residuo.getMedida_residuo())) {
                throw new ValidacionExcepcion("El tipo de unidad de medida no es válida.");
            }
        }
        
        return true;
    }
    
    private Boolean validarNoMasDeCincoTrasladosPorDia(Date fecha) throws ValidacionExcepcion {
        return null;
    }
}
