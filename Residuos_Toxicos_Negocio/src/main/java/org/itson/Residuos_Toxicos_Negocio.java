/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson;

import com.dominio.Cuenta;
import com.dominio.Productor;
import com.dominio.Residuo;
import com.dominio.Tipo;
import javax.swing.JOptionPane;
import org.itson.DTO.ProductorDTO;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.implementacion.NegocioFactory;
import org.itson.interfaces.INegocio;
import org.itson.interfaces.INegocioProductor;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Residuos_Toxicos_Negocio {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Residuo residuo = new Residuo();
        //residuo.setNombre("Daniel");
        //residuo.setCodigo("abc-123");
        //List<Quimico> quimicos = new LinkedList<>();
        //quimicos.add(new Quimico("Popo"));
        //residuo.setQuimicos(quimicos);
        INegocio negocio = new NegocioFactory();
        INegocioProductor negocioProductor = negocio.getNegocioProductor();
        Productor insertarPor = new Productor();
        insertarPor.setNombre("Daniel");
        insertarPor.setTipo(Tipo.PRODUCTO);
        Cuenta cuenta = new Cuenta("dapgpena@gmail.com", "14785");
        insertarPor.setCuenta(cuenta);
        try {
            negocioProductor.insertarProductor(insertarPor);
//            ProductorDTO pro = new ProductorDTO();
//            pro.setEmail("dapgpena@gmail.com");
//            pro.setContrasena("14785");
//            Productor produc = negocioProductor.login(pro);
//            System.out.println(produc.getNombre());
        } catch (NegocioExcepcion e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal: \n"+ e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
