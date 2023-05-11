/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package pruebas;

import com.dominio.Cuenta;
import com.dominio.Productor;
import com.dominio.Quimico;
import com.dominio.Tipo;
import org.itson.DTO.ProductorDTO;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.implementaciones.bd.DAOFactory;
import org.itson.implementaciones.daos.QuimicosDAO;
import org.itson.implementaciones.daos.ResiduosDAO;
import org.itson.interfaces.IProductoresDAO;
import org.itson.interfaces.IQuimicosDAO;

/**
 *
 * @author edemb
 */
public class Prueba {

    public static void main(String[] args) {
        System.out.println("Hello World!");
//        IQuimicosDAO quimicosDAO = DAOFactory.getQuimicosDAO();
//        
//        Quimico q1 = new Quimico("Agua");
//        Quimico q2 = new Quimico("Dioxido de carbono");
//        Quimico q3 = new Quimico("Ozono");
//        Quimico q4 = new Quimico("Grafito");
//        Quimico q5 = new Quimico("Glucosa");
//        
//        quimicosDAO.insertar(q5);
//        quimicosDAO.insertar(q4);
//        quimicosDAO.insertar(q3);
//        quimicosDAO.insertar(q2);
//        quimicosDAO.insertar(q1);

        IProductoresDAO productoresDAO = DAOFactory.getProductoresDAO();
        ProductorDTO o = new ProductorDTO();
        o.setContrasena("eebj031002");
        o.setEmail("edemboji@gmail.com");
        
        Productor consulta = productoresDAO.consultarProductor(o);
        System.out.println(consulta);
        System.out.println(consulta.getId());
        System.out.println(consulta.getNombre());
        System.out.println(consulta.getTipo());
        System.out.println(consulta.getCuenta().getCorreo());
        System.out.println(consulta.getCuenta().getContrasena());
        
//        Cuenta c0 = new Cuenta("edemboji@gmail.com", "eebj031002");
//        Cuenta c = new Cuenta("edmoji@gmail.com", "eej03102");
//        Cuenta c1 = new Cuenta("edemoji@gmail.com", "eeb03102");
//        Cuenta c2 = new Cuenta("edmoji@gmail.com", "eebj0312");
//        Cuenta c3 = new Cuenta("edemji@gmail.com", "ebj03102");
//        Cuenta c4 = new Cuenta("demoji@gmail.com", "eebj0102");
//        
//        Productor p0 = new Productor();
//        p0.setNombre("EmpresaEmir");
//        p0.setTipo(Tipo.PRODUCTO);
//        p0.setCuenta(c0);
//        
//        Productor p = new Productor();
//        p.setNombre("Productor2");
//        p.setTipo(Tipo.PRODUCTO);
//        p.setCuenta(c);
//        
//        Productor p1 = new Productor();
//        p1.setNombre("Productor3");
//        p1.setTipo(Tipo.PRODUCTO);
//        p1.setCuenta(c1);
//        
//        Productor p2 = new Productor();
//        p2.setNombre("Productor4");
//        p2.setTipo(Tipo.PRODUCTO);
//        p2.setCuenta(c2);
//        
//        Productor p3 = new Productor();
//        p3.setNombre("Productor5");
//        p3.setTipo(Tipo.PRODUCTO);
//        p3.setCuenta(c3);
//        
//        Productor p4 = new Productor();
//        p4.setNombre("Productor6");
//        p4.setTipo(Tipo.PRODUCTO);
//        p4.setCuenta(c4);
//
//        productoresDAO.insertar(p0);
//        productoresDAO.insertar(p);
//        productoresDAO.insertar(p1);
//        productoresDAO.insertar(p2);
//        productoresDAO.insertar(p3);
//        productoresDAO.insertar(p4);

    }
}
