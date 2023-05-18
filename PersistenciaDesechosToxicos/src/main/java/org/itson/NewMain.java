/*
* NewMain.java
* 18 may. 2023 04:29:16
 */
package org.itson;

import com.dominio.MedidaResiduo;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.DTO.SolicitudDTO;
import org.itson.implementaciones.fachada.FachadaPersistencia;
import org.itson.interfaces.IPersistencia;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IPersistencia persistencia = new FachadaPersistencia();
        
        SolicitudDTO solicitud = new SolicitudDTO();

        String fechaSolicitada = "2023-05-26T07:00:00.000+0000";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date = null;

        try {
            date = sdf.parse(fechaSolicitada);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        solicitud.setNombreProductor("Producto 1");
        List<Residuo> residuos = new LinkedList<>();
        Residuo residuo1 = new Residuo();
        residuo1.setCantidad(66F);
        residuo1.setCodigo("ABC-134");
        residuo1.setMedida_residuo(MedidaResiduo.LITRO);
        residuo1.setNombre("NOMBRE");
        residuo1.setId(new ObjectId("64643b69afa2dd2f9f8dc8a1"));
        solicitud.setResiduos(residuos);
        
        List<Solicitud> solicitudes = persistencia.consultarSolicitudFiltro(solicitud);
        
        for (Solicitud solicitude : solicitudes) {
            System.out.println("dd");
            System.out.println(solicitude.getId());
            
        }
    }
}


