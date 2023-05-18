/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import com.dominio.Solicitud;
import java.text.SimpleDateFormat;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.implementacion.FachadaNegocio;
import org.itson.interfaces.INegocio;

/**
 *
 * @author edemb
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        INegocio negocio = new FachadaNegocio();
        Solicitud solicitud = new Solicitud();
        solicitud.setId(new ObjectId("6464460ce7258b55bcbffe02"));
        negocio.actualizaEstadoASolicitudAtendida(solicitud);
        System.out.println(solicitud.getEstado());

    }

}
