/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package pruebas;

import com.dominio.Estado;
import com.dominio.MedidaResiduo;
import com.dominio.Productor;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.implementaciones.bd.ConexionBD;

/**
 *
 * @author edemb
 */
public class Prueba {

    public static void main(String[] args) {

        MongoCollection<Solicitud> Coleccion = ConexionBD.getBaseDatos().getCollection("solicitudes", Solicitud.class);
        Residuo r = new Residuo();
        r.setNombre("r2");
        Residuo r1 = new Residuo();
        r1.setNombre("r1");
        Residuo r2 = new Residuo();
        r2.setNombre("r2");
        Productor productor = new Productor();
        productor.setId(new ObjectId("646314f6dff379d164733ebf"));
        productor.setNombre("Producto 3");
//        Solicitud s = new Solicitud(new Date(), Estado.NO_ATENDIDA, Arrays.asList(r, r1, r2), productor);
        Solicitud s1 = new Solicitud(new Date(), Estado.NO_ATENDIDA, Arrays.asList(r, r1, r2), productor);
        Solicitud s2 = new Solicitud(new Date(), Estado.NO_ATENDIDA, Arrays.asList(r, r1, r2), productor);
        
//        Coleccion.insertMany(Arrays.asList(s,s1,s2));
        List<Solicitud> list = new ArrayList<>();
        Coleccion.find().into(list);

        for (Solicitud s : list) {
            System.out.println(s.getId() + ", " + s.getProductor().getNombre() + ", " + s.getFecha_Solicitada() + ", " + s.toString());

        }
    }
}
