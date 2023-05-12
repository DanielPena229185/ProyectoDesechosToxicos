/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package pruebas;

import com.dominio.Cuenta;
import com.dominio.EmpresaTransportista;
import com.dominio.Estado;
import com.dominio.Productor;
import com.dominio.Quimico;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import com.dominio.Tipo;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.DTO.ProductorDTO;
import org.itson.DTO.ResiduoDTO;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.implementaciones.bd.DAOFactory;
import org.itson.implementaciones.daos.QuimicosDAO;
import org.itson.implementaciones.daos.ResiduosDAO;
import org.itson.interfaces.IEmpresasTrasnportistasDAO;
import org.itson.interfaces.IProductoresDAO;
import org.itson.interfaces.IQuimicosDAO;
import org.itson.interfaces.IResiduosDAO;
import org.itson.interfaces.ISolicitudesDAO;

/**
 *
 * @author edemb
 */
public class Prueba {

    public static void main(String[] args) {
        System.out.println("Hello World!");

//        IEmpresasTrasnportistasDAO trasnportistasDAO = DAOFactory.getEmpresasTrasnportistasDAO();
//        EmpresaTransportista e1 = new EmpresaTransportista();
//        e1.setTipo(Tipo.TRANSPORTISTA);
//        e1.setNombre("Transportista1");
//        e1.setCuenta(new Cuenta("trinu_1980@hotmail.com", "bone770115"));
//
//        EmpresaTransportista e2 = new EmpresaTransportista();
//        e2.setTipo(Tipo.TRANSPORTISTA);
//        e2.setNombre("Transportista2");
//        e2.setCuenta(new Cuenta("trinu@hotmail.com", "bon70115"));
//
//        EmpresaTransportista e3 = new EmpresaTransportista();
//        e3.setTipo(Tipo.TRANSPORTISTA);
//        e3.setNombre("Transportista3");
//        e3.setCuenta(new Cuenta("1980@hotmail.com", "bone775"));
//        
//        trasnportistasDAO.insertar(e1);
//        trasnportistasDAO.insertar(e2);
//        trasnportistasDAO.insertar(e3);

//        List<EmpresaTransportista> list = trasnportistasDAO.consultaTodasEmpresasTransportistas();
//        for (EmpresaTransportista o : list ) {
//            System.out.println(o.getId());
//            System.out.println(o.getNombre());
//            System.out.println(o.getTipo());
//            System.out.println(o.getCuenta().getCorreo() +" "+o.getCuenta().getContrasena());
//            System.out.println("");
//        }
        ISolicitudesDAO solicitudesDAO = DAOFactory.getSolicitudesDAO();
        List<Solicitud> solicitudes = solicitudesDAO.consultaSolicitudesNoAtendidas();
        for(Solicitud o : solicitudes){
            System.out.println(o.getId()+" "+o.getEstado()+" "+o.getFecha_Solicitada());
        }
//        Solicitud s = new Solicitud();
//        s.setFechaSolicitada(new Date());
//        s.setEstado(Estado.NO_ATENDIDA);
//
//        Solicitud s1 = new Solicitud();
//        s1.setFechaSolicitada(new Date());
//        s1.setEstado(Estado.NO_ATENDIDA);
//
//        Solicitud s2 = new Solicitud();
//        s2.setFechaSolicitada(new Date());
//        s2.setEstado(Estado.NO_ATENDIDA);
//
//        Solicitud s3 = new Solicitud();
//        s3.setFechaSolicitada(new Date());
//        s3.setEstado(Estado.NO_ATENDIDA);
//
//        Solicitud s4 = new Solicitud();
//        s4.setFechaSolicitada(new Date());
//        s4.setEstado(Estado.NO_ATENDIDA);
//
//        solicitudesDAO.insertarSolicitud(s);
//        solicitudesDAO.insertarSolicitud(s1);
//        solicitudesDAO.insertarSolicitud(s2);
//        solicitudesDAO.insertarSolicitud(s3);
//        solicitudesDAO.insertarSolicitud(s4);
        
        

    }
}
