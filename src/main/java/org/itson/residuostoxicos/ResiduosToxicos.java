package org.itson.residuostoxicos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.*;
/**
 *
 * @author Aracely Campa Quintana Quintana  ID:233215
 * @author Edgar Emir Borbon Jimenez ID:233184
 * @author Oscar Minjarez Zavala ID:231506
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ResiduosToxicos {

    public static void main(String[] args) {

        Ciudad ciudad = new Ciudad("Obregon");
        Direccion direccion = new Direccion("Filipinas", "Sampopa", "4000", ciudad);
        Empresa organizacion = new Organizacion("Trasher", direccion);
        
        Direccion direccion2 = new Direccion("Rosario", "5000", ciudad);
        Empresa transportista = new EmpresaTransportista("Transport", direccion2);
        
        Quimico q1 = new Quimico("Azufre");
        Quimico q2 = new Quimico("Silicio");
        List<Quimico> listaQuimicos = new ArrayList<>();
        listaQuimicos.add(q1);
        listaQuimicos.add(q2);
        
        Residuo residuo = new Residuo(listaQuimicos, (Organizacion) organizacion);
        
        Vehiculo vehiculo = new Vehiculo("J10", "Nissan");
        Transporte transporte = new Transporte(vehiculo, (EmpresaTransportista) transportista);
        Traslado completo = new Completo(residuo, transporte);
        
        List<Completo> listaCompleto = new ArrayList<>();
        listaCompleto.add((Completo) completo);
        
        RegistroTotalidad registroTotalidad = new RegistroTotalidad(listaCompleto);
        
        Traslado enPartes = new EnPartes(residuo);
        Historial historial = new Historial(transporte, (EnPartes) enPartes);
        
        List<EnPartes> listaEnPartes = new ArrayList<>();
        listaEnPartes.add((EnPartes) enPartes);
        RegistroEnPartes registroEnPartes = new RegistroEnPartes(listaEnPartes);
        
    }
}
