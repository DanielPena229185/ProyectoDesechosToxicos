/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pruebas;

import com.dominio.Quimico;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.implementaciones.bd.DAOFactory;
import org.itson.implementaciones.daos.QuimicosDAO;
import org.itson.implementaciones.daos.ResiduosDAO;
import org.itson.interfaces.IQuimicosDAO;

/**
 *
 * @author edemb
 */
public class Prueba {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        IQuimicosDAO quimicosDAO = DAOFactory.getQuimicosDAO();
        
        Quimico q1 = new Quimico("Agua");
        Quimico q2 = new Quimico("Dioxido de carbono");
        Quimico q3 = new Quimico("Ozono");
        Quimico q4 = new Quimico("Grafito");
        Quimico q5 = new Quimico("Glucosa");
        
        quimicosDAO.insertar(q5);
        quimicosDAO.insertar(q4);
        quimicosDAO.insertar(q3);
        quimicosDAO.insertar(q2);
        quimicosDAO.insertar(q1);
        
    }
}
