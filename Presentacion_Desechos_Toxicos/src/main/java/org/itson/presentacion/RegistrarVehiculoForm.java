
package org.itson.presentacion;

import java.awt.Color;

/**
 * Descripción de la clase: Registrar vehiculo
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID:
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class RegistrarVehiculoForm extends javax.swing.JFrame {
private static final String NUMERO_SERIE_DEFAULT = "12345678";
    private static final String MARCA_DEFAULT = "TOYOTA";
    private static final String MODELO_DEFAULT = "2001";
    
    /**
     * Creates new form RegistrarVehiculoForm
     */
    public RegistrarVehiculoForm() {
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

        registrarmeLbl = new javax.swing.JLabel();
        campoNumeroSerie = new javax.swing.JTextField();
        usuarioLbl = new javax.swing.JLabel();
        usuarioLbl1 = new javax.swing.JLabel();
        campoMarca = new javax.swing.JTextField();
        usuarioLbl2 = new javax.swing.JLabel();
        campoModelo = new javax.swing.JTextField();
        registrarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        registrarmeLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        registrarmeLbl.setText("Registrar Vehiculo");

        campoNumeroSerie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoNumeroSerie.setForeground(new java.awt.Color(204, 204, 204));
        campoNumeroSerie.setText(this.NUMERO_SERIE_DEFAULT);
        campoNumeroSerie.setBorder(null);
        campoNumeroSerie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoNumeroSerieFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNumeroSerieFocusLost(evt);
            }
        });
        campoNumeroSerie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoNumeroSerieMouseClicked(evt);
            }
        });

        usuarioLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usuarioLbl.setText("Numero de serie");

        usuarioLbl1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usuarioLbl1.setText("Marca");

        campoMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoMarca.setForeground(new java.awt.Color(204, 204, 204));
        campoMarca.setText(this.MARCA_DEFAULT);
        campoMarca.setBorder(null);
        campoMarca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoMarcaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoMarcaFocusLost(evt);
            }
        });
        campoMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoMarcaMouseClicked(evt);
            }
        });

        usuarioLbl2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usuarioLbl2.setText("Modelo");

        campoModelo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoModelo.setForeground(new java.awt.Color(204, 204, 204));
        campoModelo.setText(this.MODELO_DEFAULT);
        campoModelo.setBorder(null);
        campoModelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoModeloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoModeloFocusLost(evt);
            }
        });
        campoModelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoModeloMouseClicked(evt);
            }
        });

        registrarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        registrarBtn.setText("Registrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registrarBtn)
                    .addComponent(campoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioLbl)
                    .addComponent(campoNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrarmeLbl)
                    .addComponent(usuarioLbl1)
                    .addComponent(usuarioLbl2)
                    .addComponent(campoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(411, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(registrarmeLbl)
                .addGap(31, 31, 31)
                .addComponent(usuarioLbl)
                .addGap(18, 18, 18)
                .addComponent(campoNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usuarioLbl1)
                .addGap(18, 18, 18)
                .addComponent(campoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usuarioLbl2)
                .addGap(18, 18, 18)
                .addComponent(campoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(registrarBtn)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNumeroSerieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumeroSerieFocusGained
        if (this.verificarCampoNumeroSerie()) {
            this.campoNumeroSerie.setForeground(Color.BLACK);
            this.campoNumeroSerie.setText("");
        }
    }//GEN-LAST:event_campoNumeroSerieFocusGained

    private void campoNumeroSerieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumeroSerieFocusLost
        if (this.verificarCampoNumeroSerie()) {
            this.campoNumeroSerie.setForeground(Color.GRAY);
            this.campoNumeroSerie.setText(this.NUMERO_SERIE_DEFAULT);
        }
    }//GEN-LAST:event_campoNumeroSerieFocusLost

    private void campoNumeroSerieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNumeroSerieMouseClicked
        if (this.verificarCampoNumeroSerie()) {
            this.campoNumeroSerie.setForeground(Color.BLACK);
            this.campoNumeroSerie.setText("");
        }
    }//GEN-LAST:event_campoNumeroSerieMouseClicked

    private void campoMarcaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoMarcaFocusGained
        if (this.verificarCampoMarcaVacio()) {
            this.campoNumeroSerie.setForeground(Color.BLACK);
            this.campoNumeroSerie.setText("");
        }
    }//GEN-LAST:event_campoMarcaFocusGained

    private void campoMarcaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoMarcaFocusLost
        if (this.verificarCampoMarcaVacio()) {
            this.campoNumeroSerie.setForeground(Color.BLACK);
            this.campoNumeroSerie.setText(this.MARCA_DEFAULT);
        }
    }//GEN-LAST:event_campoMarcaFocusLost

    private void campoMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoMarcaMouseClicked
       if (this.verificarCampoMarcaVacio()) {
            this.campoNumeroSerie.setForeground(Color.BLACK);
            this.campoNumeroSerie.setText("");
        }
    }//GEN-LAST:event_campoMarcaMouseClicked

    private void campoModeloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoModeloFocusGained
      if (this.verificarCampoModeloVacio()) {
            this.campoNumeroSerie.setForeground(Color.BLACK);
            this.campoNumeroSerie.setText("");
        }
    }//GEN-LAST:event_campoModeloFocusGained

    private void campoModeloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoModeloFocusLost
      if (this.verificarCampoModeloVacio()) {
            this.campoNumeroSerie.setForeground(Color.BLACK);
            this.campoNumeroSerie.setText(this.MODELO_DEFAULT);
        }
    }//GEN-LAST:event_campoModeloFocusLost

    private void campoModeloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoModeloMouseClicked
     if (this.verificarCampoModeloVacio()) {
            this.campoNumeroSerie.setForeground(Color.BLACK);
            this.campoNumeroSerie.setText("");
        }
    }//GEN-LAST:event_campoModeloMouseClicked

    private boolean verificarCampoNumeroSerie() {
        return this.campoNumeroSerie.getText().isEmpty() || this.campoNumeroSerie.getText().equals(this.NUMERO_SERIE_DEFAULT);
    }
    private boolean verificarCampoMarcaVacio() {
        return this.campoMarca.getText().isEmpty() || this.campoMarca.getText().equals(this.MARCA_DEFAULT);
    }
    private boolean verificarCampoModeloVacio() {
        return this.campoModelo.getText().isEmpty() || this.campoModelo.getText().equals(this.MODELO_DEFAULT);
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
            java.util.logging.Logger.getLogger(RegistrarVehiculoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarVehiculoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarVehiculoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarVehiculoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarVehiculoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoMarca;
    private javax.swing.JTextField campoModelo;
    private javax.swing.JTextField campoNumeroSerie;
    private javax.swing.JButton registrarBtn;
    private javax.swing.JLabel registrarmeLbl;
    private javax.swing.JLabel usuarioLbl;
    private javax.swing.JLabel usuarioLbl1;
    private javax.swing.JLabel usuarioLbl2;
    // End of variables declaration//GEN-END:variables
}
