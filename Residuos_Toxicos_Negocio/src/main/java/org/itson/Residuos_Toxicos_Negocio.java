/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson;

import com.dominio.Quimico;
import com.dominio.Residuo;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.implementacion.NegocioResiduo;
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
        INegocioResiduo negocio = new NegocioResiduo();
        try {
            negocio.insertarResiduo(residuo);
        } catch (NegocioExcepcion e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal: \n"+ e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
