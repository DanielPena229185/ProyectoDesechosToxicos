/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package pruebas;

import com.dominio.Administrador;
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
import org.itson.interfaces.IAdministradoresDAO;
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
        IAdministradoresDAO administradoresDAO = DAOFactory.getAdministradoresDAO();
        
//        Administrador a = administradoresDAO.loginAdministrador("edemboji@gmail.com", "eebj031002");
        IEmpresasTrasnportistasDAO ad = DAOFactory.getEmpresasTrasnportistasDAO();
        EmpresaTransportista a = ad.loginEmpresaTrasnportista("edemboji@gmail.com", "eebj031002");
        System.out.println(a.getId());
        System.out.println(a.getNombre());
        System.out.println(a.getCuenta().getCorreo());
        System.out.println(a.getCuenta().getContrasena());
    }
}
