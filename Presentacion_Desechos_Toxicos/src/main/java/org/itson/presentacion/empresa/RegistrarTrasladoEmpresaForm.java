/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion.empresa;

import com.dominio.EmpresaTransportista;
import com.dominio.Traslado;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PresentacionException;
import org.itson.implementacion.FachadaNegocio;
import org.itson.interfaces.INegocio;

/**
 *
 * @author arace
 */
public class RegistrarTrasladoEmpresaForm extends javax.swing.JFrame {

    private final INegocio negocio;
    private static RegistrarTrasladoEmpresaForm form;
    private EmpresaTransportista empresaTransportista;
    
    /**
     * Creates new form RegistrarTrasladoEmpresaForm
     */
    private RegistrarTrasladoEmpresaForm() {
        this.negocio = new FachadaNegocio();
        initComponents();
        this.cargarTablaTraslados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTraslados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        registrarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaTraslados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha Solicitada", "Residuo", "Cantidad", "Productor"
            }
        ));
        jScrollPane1.setViewportView(tablaTraslados);

        jLabel1.setText("Registrar Traslado: Empresa");

        registrarBtn.setText("Registrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(registrarBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(registrarBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static RegistrarTrasladoEmpresaForm getInstance() {
        if (form == null){
            form = new RegistrarTrasladoEmpresaForm();
        }
        
        return form;
    }
    
    public void setEmpresaTransportista(EmpresaTransportista empresaTransportista) {
        this.empresaTransportista = empresaTransportista;
    }
    
    private List<Traslado> consultarListaTraslados() throws PresentacionException {
        try {
            return this.negocio.consultaTrasladosAsingados(this.empresaTransportista);
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage());
        }
    }
    
    private void cargarTablaTraslados() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaTraslados.getModel();
        modeloTabla.setNumRows(0);
        
        try {
            List<Traslado> traslados = this.consultarListaTraslados();
        
            for (Traslado traslado : traslados) {
                Object[] fila = {
                    "Hola",
                    traslado.getResiduo().getNombre(),
                    traslado.getResiduo().getCantidad(),
                    traslado.getResiduo().getProductor().getNombre()
                };

                modeloTabla.addRow(fila);
            }
        } catch (PresentacionException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarTrasladoEmpresaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarTrasladoEmpresaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarTrasladoEmpresaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarTrasladoEmpresaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrarTrasladoEmpresaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton registrarBtn;
    private javax.swing.JTable tablaTraslados;
    // End of variables declaration//GEN-END:variables
}
