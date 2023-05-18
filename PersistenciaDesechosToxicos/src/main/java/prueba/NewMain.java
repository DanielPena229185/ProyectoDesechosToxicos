/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

import com.dominio.EmpresaTransportista;
import com.dominio.Transporte;
import com.dominio.Vehiculo;
import com.mongodb.client.MongoCollection;
import java.util.Arrays;
import org.itson.implementaciones.bd.ConexionBD;
import org.itson.implementaciones.bd.DAOFactory;
import org.itson.interfaces.ITransporteDAO;

/**
 *
 * @author oscar
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Transporte transporte = new Transporte();
        transporte.setKilometros(234f);
        transporte.setCoste(2345F);
        EmpresaTransportista empresa = new EmpresaTransportista();
        empresa.setNombre("empresa");
        transporte.setVehiculos(Arrays.asList(new Vehiculo()));
        transporte.setEmpresa_transportista(new EmpresaTransportista());

        ITransporteDAO transporteDAO = DAOFactory.getTransporteDAO();
        transporteDAO.insertarTrasnporte(transporte);
        
    }

}
