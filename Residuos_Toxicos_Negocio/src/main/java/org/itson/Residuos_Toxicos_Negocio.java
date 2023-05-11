/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson;

import com.dominio.Residuo;
import javax.swing.JOptionPane;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.implementacion.NegocioFactory;
import org.itson.interfaces.INegocio;
import org.itson.interfaces.INegocioResiduo;

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
        INegocioResiduo negocioResiduo = negocio.getNegocioResiduo();
        try {
            negocioResiduo.insertarResiduo(null);
        } catch (NegocioExcepcion e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal: \n"+ e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
