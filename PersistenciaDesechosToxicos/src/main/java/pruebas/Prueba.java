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
import com.dominio.Traslado;
import java.util.ArrayList;
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
import org.itson.interfaces.ITrasladosDAO;

/**
 *
 * @author edemb
 */
public class Prueba {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        IProductoresDAO productoresDAO = DAOFactory.getProductoresDAO();
        IEmpresasTrasnportistasDAO trasnportistasDAO = DAOFactory.getEmpresasTrasnportistasDAO();

//        Productor p = productoresDAO.consultarLogin("trinu_1980@hotmail.com", "bone770115");
        EmpresaTransportista t = trasnportistasDAO.loginEmpresaTrasnportista("trinu_1980@hotmail.com", "bone770115");

        System.out.println("Trasnportista: "+t.getId()+" " + t.getTipo() + " " + t.getCuenta().getCorreo() + " " + t.getCuenta().getContrasena() + " " + t.getNombre());
//        System.out.println("Productora: "+ p.getTipo()+ " "+ p.getCuenta().getCorreo()+" "+p.getCuenta().getContrasena()+" "+p.getNombre());
    
        EmpresaTransportista empresa = new EmpresaTransportista();
        empresa.setId(t.getId());
        empresa.setNombre(t.getNombre());
        empresa.setTipo(t.getTipo());
        
        ITrasladosDAO trasladosDAO = DAOFactory.getTrasladosDAO();
//        Traslado traslado = new Traslado();
//        traslado.setEmpresas_transportistas(Arrays.asList(empresa));
//        trasladosDAO.insertarTraslado(traslado);
        List<Traslado> lista = trasladosDAO.consultaTrasladosAsingados(empresa);
        for (Traslado o : lista) {
            System.out.println(o.getId());
            for (EmpresaTransportista e : o.getEmpresas_transportistas()) {
                System.out.println("Trasnportista: " + e.getId() + " " + e.getTipo() + " " + t.getNombre());

            }
        }

    }
}
