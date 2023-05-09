/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson;

import com.dominio.Direccion;
import javax.swing.JOptionPane;
import org.itson.excepciones.NegocioExcepcion;
import org.itson.implementacion.DireccionNegocio;
import org.itson.interfaces.CrudInterface;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Residuos_Toxicos_Negocio {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        CrudInterface crud = new DireccionNegocio();
        try {
            crud.insertar(new Direccion());
        } catch (NegocioExcepcion e) {
            JOptionPane.showMessageDialog(null, "Datos inválidos: \n"
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
