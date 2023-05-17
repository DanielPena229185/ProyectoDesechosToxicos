/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import com.dominio.Solicitud;
import java.text.SimpleDateFormat;
import java.util.List;
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
                            SimpleDateFormat formateado = new SimpleDateFormat("dd/MM/yyyy");

        INegocio negocio = new FachadaNegocio();
        List<Solicitud> lista = negocio.consultaSolicitudesNoAtendidas();
        for(Solicitud s : lista){
            System.out.println(s.getId()+", "+s.getProductor().getNombre()+", "+s.getFecha_Solicitada().toString()+", "+s.getResiduos().toString());
        }
    }
    
}
