
package org.itson.presentacion;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Creacion del formulario registro residuo
 * @author Aracely Campa Quintana ID:233215
 */
public class RegistrarResiduoForm extends javax.swing.JFrame {
    private static final String ID_RESIDUO_DEFAULT = "123456";
    private static final String NOMBRE_RESIDUO_DEFAULT = "Desechos Quimicos";
    private static final String COMPOSICION_QUIMICA = "Composicion Quimica";
     String[] array = {"Tipo1", "Tipo2", "Tipo3"};
     
     DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(array);

    /**
     * Creates new form RegistrarResiduoForm
     */
    public RegistrarResiduoForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iniciarSesionComoLabel = new javax.swing.JLabel();
        campoIdResiduo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        campoNombreResiduo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        cancelarBtn = new javax.swing.JButton();
        registrarBtn1 = new javax.swing.JButton();
        panelInformacion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxTipoResiduo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iniciarSesionComoLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        iniciarSesionComoLabel.setForeground(new java.awt.Color(0, 0, 0));
        iniciarSesionComoLabel.setText("Registra Residuo");
        getContentPane().add(iniciarSesionComoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        campoIdResiduo.setBackground(new java.awt.Color(255, 255, 255));
        campoIdResiduo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoIdResiduo.setForeground(new java.awt.Color(204, 204, 204));
        campoIdResiduo.setText(this.ID_RESIDUO_DEFAULT);
        campoIdResiduo.setBorder(null);
        campoIdResiduo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoIdResiduoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoIdResiduoFocusLost(evt);
            }
        });
        campoIdResiduo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoIdResiduoMouseClicked(evt);
            }
        });
        getContentPane().add(campoIdResiduo, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 150, 280, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 280, 10));

        campoNombreResiduo.setBackground(new java.awt.Color(255, 255, 255));
        campoNombreResiduo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoNombreResiduo.setForeground(new java.awt.Color(204, 204, 204));
        campoNombreResiduo.setText(this.NOMBRE_RESIDUO_DEFAULT);
        campoNombreResiduo.setBorder(null);
        campoNombreResiduo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoNombreResiduoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNombreResiduoFocusLost(evt);
            }
        });
        campoNombreResiduo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoNombreResiduoMouseClicked(evt);
            }
        });
        getContentPane().add(campoNombreResiduo, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 239, 280, 30));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 280, 10));

        cancelarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cancelarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, -1, -1));

        registrarBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        registrarBtn1.setText("Registrar");
        registrarBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(registrarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        panelInformacion.setBackground(new java.awt.Color(255, 102, 0));
        panelInformacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 320, 530));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ID Residuo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 113, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tipo Residuo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        comboBoxTipoResiduo.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxTipoResiduo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxTipoResiduo.setForeground(new java.awt.Color(0, 0, 0));
        comboBoxTipoResiduo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo1", "Tipo2", " " }));
        comboBoxTipoResiduo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoResiduoActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxTipoResiduo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 211, -1, 20));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 333, 200, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoIdResiduoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoIdResiduoFocusGained
        if (this.verificarCampoIDResiduoVacio()) {
            this.campoIdResiduo.setForeground(Color.BLACK);
            this.campoIdResiduo.setText("");
        }
    }//GEN-LAST:event_campoIdResiduoFocusGained

    private void campoIdResiduoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoIdResiduoFocusLost
        if (this.verificarCampoIDResiduoVacio()) {
            this.campoIdResiduo.setForeground(Color.GRAY);
            this.campoIdResiduo.setText(this.ID_RESIDUO_DEFAULT);
        }
    }//GEN-LAST:event_campoIdResiduoFocusLost

    private void campoIdResiduoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoIdResiduoMouseClicked
        if (this.verificarCampoIDResiduoVacio()) {
            this.campoIdResiduo.setForeground(Color.BLACK);
            this.campoIdResiduo.setText("");
        }
    }//GEN-LAST:event_campoIdResiduoMouseClicked

    private void campoNombreResiduoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombreResiduoFocusGained
        if (this.verificarCampoNombreResiduoVacio()) {
            this.campoNombreResiduo.setForeground(Color.BLACK);
            this.campoNombreResiduo.setText("");
        }
    }//GEN-LAST:event_campoNombreResiduoFocusGained

    private void campoNombreResiduoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombreResiduoFocusLost
        if (this.verificarCampoNombreResiduoVacio()) {
            this.campoNombreResiduo.setForeground(Color.GRAY);
            this.campoNombreResiduo.setText(this.NOMBRE_RESIDUO_DEFAULT);
        }
    }//GEN-LAST:event_campoNombreResiduoFocusLost

    private void campoNombreResiduoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNombreResiduoMouseClicked
        if (this.verificarCampoNombreResiduoVacio()) {
            this.campoNombreResiduo.setForeground(Color.BLACK);
            this.campoNombreResiduo.setText("");
        }
    }//GEN-LAST:event_campoNombreResiduoMouseClicked

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        InicioForm v = new InicioForm();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void registrarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrarBtn1ActionPerformed

    private void comboBoxTipoResiduoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoResiduoActionPerformed
        String itemSelected = this.comboBoxTipoResiduo.getSelectedItem().toString();
        JComboBox<String> tipo_residuo = new JComboBox<>(model);
         
    }//GEN-LAST:event_comboBoxTipoResiduoActionPerformed

    private boolean verificarCampoIDResiduoVacio() {
        return this.campoIdResiduo.getText().isEmpty() || this.campoIdResiduo.getText().equals(this.ID_RESIDUO_DEFAULT);
    }
    private boolean verificarCampoNombreResiduoVacio() {
        return this.campoNombreResiduo.getText().isEmpty() || this.campoNombreResiduo.getText().equals(this.NOMBRE_RESIDUO_DEFAULT);
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
            java.util.logging.Logger.getLogger(RegistrarResiduoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarResiduoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarResiduoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarResiduoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarResiduoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoIdResiduo;
    private javax.swing.JTextField campoNombreResiduo;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JComboBox<String> comboBoxTipoResiduo;
    private javax.swing.JLabel iniciarSesionComoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JButton registrarBtn1;
    // End of variables declaration//GEN-END:variables
}