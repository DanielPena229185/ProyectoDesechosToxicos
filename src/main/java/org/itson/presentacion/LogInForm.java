/**
 * LogInForm.java
 * 3 may. 2023 11:33:21
 *
 */
package org.itson.presentacion;

import java.awt.Color;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class LogInForm extends javax.swing.JFrame {

    private static final String ADMINISTRADOR = "Administrador";
    private static final String PRODUCTOR = "Productor";
    private static final String EMPRESA_TRANSPORTADORA = "Empresa Transportadora";

    private static final String CORREO_DEFAULT = "info@ejemplo.com";
    private static final String CONTRASENA_DEFAULT = "123456789112345";

    /**
     * Creates new form LogInForm
     */
    public LogInForm() {
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

        panelFondo = new javax.swing.JPanel();
        panelInformacion = new javax.swing.JPanel();
        iniciarSesionComoLabel = new javax.swing.JLabel();
        comboBoxOpcionLogin = new javax.swing.JComboBox<>();
        usuarioLbl = new javax.swing.JLabel();
        renglonUsuario = new javax.swing.JSeparator();
        campoUsuario = new javax.swing.JTextField();
        contrasenaLbl = new javax.swing.JLabel();
        renglonContrasena = new javax.swing.JSeparator();
        campoContrasena = new javax.swing.JPasswordField();
        checkVisible = new javax.swing.JCheckBox();
        iniciarSesionBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Iniciar Sesión");

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelInformacion.setBackground(new java.awt.Color(208, 208, 208));
        panelInformacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelFondo.add(panelInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 320, 530));

        iniciarSesionComoLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        iniciarSesionComoLabel.setForeground(new java.awt.Color(0, 0, 0));
        iniciarSesionComoLabel.setText("Iniciar Sesión como:");
        panelFondo.add(iniciarSesionComoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        comboBoxOpcionLogin.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxOpcionLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxOpcionLogin.setForeground(new java.awt.Color(0, 0, 0));
        comboBoxOpcionLogin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", this.ADMINISTRADOR, this.PRODUCTOR, this.EMPRESA_TRANSPORTADORA }));
        comboBoxOpcionLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxOpcionLoginActionPerformed(evt);
            }
        });
        panelFondo.add(comboBoxOpcionLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 200, -1));

        usuarioLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usuarioLbl.setForeground(new java.awt.Color(0, 0, 0));
        usuarioLbl.setText("Usuario");
        panelFondo.add(usuarioLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        renglonUsuario.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(renglonUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 280, 10));

        campoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        campoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoUsuario.setForeground(new java.awt.Color(204, 204, 204));
        campoUsuario.setText(this.CORREO_DEFAULT);
        campoUsuario.setBorder(null);
        campoUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoUsuarioFocusLost(evt);
            }
        });
        campoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoUsuarioMouseClicked(evt);
            }
        });
        panelFondo.add(campoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 280, -1));

        contrasenaLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        contrasenaLbl.setForeground(new java.awt.Color(0, 0, 0));
        contrasenaLbl.setText("Contraseña");
        panelFondo.add(contrasenaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        renglonContrasena.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(renglonContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 280, 10));

        campoContrasena.setBackground(new java.awt.Color(255, 255, 255));
        campoContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoContrasena.setForeground(new java.awt.Color(204, 204, 204));
        campoContrasena.setText(this.CONTRASENA_DEFAULT);
        campoContrasena.setBorder(null);
        campoContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoContrasenaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoContrasenaFocusLost(evt);
            }
        });
        campoContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoContrasenaMouseClicked(evt);
            }
        });
        panelFondo.add(campoContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 280, -1));

        checkVisible.setText("Visible");
        checkVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkVisibleActionPerformed(evt);
            }
        });
        panelFondo.add(checkVisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

        iniciarSesionBtn.setBackground(new java.awt.Color(0, 0, 0));
        iniciarSesionBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        iniciarSesionBtn.setForeground(new java.awt.Color(255, 255, 255));
        iniciarSesionBtn.setText("Iniciar Sesión");
        iniciarSesionBtn.setEnabled(false);
        panelFondo.add(iniciarSesionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxOpcionLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxOpcionLoginActionPerformed
        String itemSelected = this.comboBoxOpcionLogin.getSelectedItem().toString();
        this.cambiarColorTipoLoginPanelInformacion(itemSelected);
    }//GEN-LAST:event_comboBoxOpcionLoginActionPerformed

    private void checkVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkVisibleActionPerformed
        this.alternarVisibilidadContrasena();

        if (this.checkVisible.isSelected()) {
            if (verificarCampoContrasenaVacio()) {
                this.campoContrasena.setText("");
            }
        } else {
            if (verificarCampoContrasenaVacio()) {
                this.campoContrasena.setText(this.CONTRASENA_DEFAULT);
            }
        }
    }//GEN-LAST:event_checkVisibleActionPerformed

    private void campoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoUsuarioMouseClicked
        if (this.verificarCampoUsuarioVacio()) {
            this.campoUsuario.setForeground(Color.BLACK);
            this.campoUsuario.setText("");
        }
    }//GEN-LAST:event_campoUsuarioMouseClicked

    private void campoUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoUsuarioFocusGained
        if (this.verificarCampoUsuarioVacio()) {
            this.campoUsuario.setForeground(Color.BLACK);
            this.campoUsuario.setText("");
        }
    }//GEN-LAST:event_campoUsuarioFocusGained

    private void campoUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoUsuarioFocusLost
        if (this.verificarCampoUsuarioVacio()) {
            this.campoUsuario.setForeground(Color.GRAY);
            this.campoUsuario.setText(this.CORREO_DEFAULT);
        }
    }//GEN-LAST:event_campoUsuarioFocusLost

    private void campoContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoContrasenaMouseClicked
        if (this.verificarCampoContrasenaVacio()) {
            this.campoContrasena.setForeground(Color.BLACK);
            this.campoContrasena.setText("");
        }
    }//GEN-LAST:event_campoContrasenaMouseClicked

    private void campoContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoContrasenaFocusGained
        if (this.verificarCampoContrasenaVacio()) {
            this.campoContrasena.setForeground(Color.BLACK);
            this.campoContrasena.setText("");
        }

    }//GEN-LAST:event_campoContrasenaFocusGained

    private void campoContrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoContrasenaFocusLost

        if (this.verificarCampoContrasenaVacio()) {
            this.campoContrasena.setForeground(Color.GRAY);
            this.campoContrasena.setText(this.CONTRASENA_DEFAULT);
        }

    }//GEN-LAST:event_campoContrasenaFocusLost

    private void alternarVisibilidadContrasena() {
        if (this.checkVisible.isSelected()) {
            this.campoContrasena.setEchoChar((char) 0);
        } else {
            this.campoContrasena.setEchoChar('•');
        }
    }

    private boolean verificarCampoUsuarioVacio() {
        return this.campoUsuario.getText().isEmpty() || this.campoUsuario.getText().equals(this.CORREO_DEFAULT);
    }

    private void cambiarColorTipoLoginPanelInformacion(String tipoLogin) {
        Color color;
        if (tipoLogin == this.ADMINISTRADOR) {
            //Color azul
            color = new Color(51, 162, 255);
            this.panelInformacion.setBackground(color);
            //Habilita botón iniciarSesión
            this.iniciarSesionBtn.setEnabled(true);
        } else if (tipoLogin == this.PRODUCTOR) {
            //Color Verde
            color = new Color(51, 255, 175);
            this.panelInformacion.setBackground(color);
            //Habilita botón iniciarSesión
            this.iniciarSesionBtn.setEnabled(true);
        } else if (tipoLogin == this.EMPRESA_TRANSPORTADORA) {
            //Color Naranja
            color = new Color(255, 162, 51);
            this.panelInformacion.setBackground(color);
            //Habilita botón iniciarSesión
            this.iniciarSesionBtn.setEnabled(true);
        } else {
            //Color gris
            color = new Color(208, 208, 208);
            this.panelInformacion.setBackground(color);
            //Deshabilita botón iniciarSesión
            this.iniciarSesionBtn.setEnabled(false);
        }
    }

    private boolean verificarCampoContrasenaVacio() {
        return this.campoContrasena.getText().isEmpty() || this.campoContrasena.getText().equals(this.CONTRASENA_DEFAULT);
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
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField campoContrasena;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JCheckBox checkVisible;
    private javax.swing.JComboBox<String> comboBoxOpcionLogin;
    private javax.swing.JLabel contrasenaLbl;
    private javax.swing.JButton iniciarSesionBtn;
    private javax.swing.JLabel iniciarSesionComoLabel;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JSeparator renglonContrasena;
    private javax.swing.JSeparator renglonUsuario;
    private javax.swing.JLabel usuarioLbl;
    // End of variables declaration//GEN-END:variables

}
