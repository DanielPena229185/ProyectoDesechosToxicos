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
import com.dominio.Vehiculo;
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
import org.itson.interfaces.IVehiculosDAO;

/**
 *
 * @author edemb
 */
public class Prueba {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        IProductoresDAO productoresDAO = DAOFactory.getProductoresDAO();
        IEmpresasTrasnportistasDAO trasnportistasDAO = DAOFactory.getEmpresasTrasnportistasDAO();

        EmpresaTransportista t = trasnportistasDAO.loginEmpresaTrasnportista("trinu_1980@hotmail.com", "bone770115");

        System.out.println("Trasnportista: " + t.getId() + " " + t.getTipo() + " " + t.getCuenta().getCorreo() + " " + t.getCuenta().getContrasena() + " " + t.getNombre());

        EmpresaTransportista empresa = new EmpresaTransportista();
        empresa.setId(t.getId());
        empresa.setNombre(t.getNombre());
        empresa.setTipo(t.getTipo());
        
<<<<<<< HEAD
        Vehiculo v = new Vehiculo("modelo1", "marca1", empresa);
        Vehiculo v1 = new Vehiculo("modelo2", "marca2", empresa);
        Vehiculo v2 = new Vehiculo();
        v2.setMarca("marca3");
        v2.setModelo("modelo3");
        IVehiculosDAO vehiculosDAO = DAOFactory.getVehiculosDAO();
//        vehiculosDAO.insertarVehiculo(v);
//        vehiculosDAO.insertarVehiculo(v1);
//        vehiculosDAO.insertarVehiculo(v2);
=======
        ITrasladosDAO trasladosDAO = DAOFactory.getTrasladosDAO();
//        Traslado traslado = new Traslado();
//        traslado.setEmpresas_transportistas(Arrays.asList(empresa));
//        trasladosDAO.insertarTraslado(traslado);
        List<Traslado> lista = trasladosDAO.consultaTrasladosAsingados(empresa);
        for (Traslado o : lista) {
            System.out.println(o.getId());
            for (EmpresaTransportista e : o.getEmpresas_transportistas()) {
                System.out.println("Trasnportista: " + e.getId() + " " + e.getTipo() + " " + t.getNombre());
>>>>>>> 6543066776d164a4c7b2a4a8c55a86a2390f2cbf

    List<Vehiculo> vehiculos = vehiculosDAO.consultarVehiculosEmpresaTrasnportadora(empresa);
    for(Vehiculo l : vehiculos){
        System.out.println(l.getId()+" "+ l.getMarca()+" "+l.getModelo()+" "+l.getEmpresa_trasnportista().getId()+" "+l.getEmpresa_trasnportista().getNombre());
    }

    }
}
