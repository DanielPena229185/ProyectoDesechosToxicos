/**
* RegistrarEmpresa.java
* 5 may. 2023 19:55:51
* 
*/ 

package org.itson.presentacion;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class RegistrarEmpresaForm extends javax.swing.JFrame {
    
    private final String EMPRESA_TRANSPORTADORA = "Transportadora";
    private final String EMPRESA_PRODUCTORA = "Productora";
    private final String NOMBRE_EMPRESA_DEFAULT = "Empresa";
    private static final String CORREO_DEFAULT = "info@ejemplo.com";
    private static final String CONTRASENA_DEFAULT = "123456789112345";
    
//    DefaultComboBoxModel<comboTipoEmpresa> model = new DefaultComboBoxModel<comboTipoEmpresa>();
//    model.addElement(new comboTipoEmpresa("Tipo 1", "Productora"));
//    model.addElement(new comboTipoEmpresa("Tipo 2", "Empresa"));
    /** Creates new form RegistrarEmpresa */
    public RegistrarEmpresaForm() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboTipoEmpresa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        campoNombreEmpresa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        campoCorreoEmpresa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        campoContrasena = new javax.swing.JPasswordField();
        registrarEmpresBtn = new javax.swing.JButton();
        checkVisibleContrasena = new javax.swing.JCheckBox();
        checkVisibleContrasena1 = new javax.swing.JCheckBox();
        regresarBtn = new javax.swing.JButton();
        correoValidoLbl = new javax.swing.JLabel();
        contrasenaValidaLbl = new javax.swing.JLabel();
        campoConfirmarContrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        jPanel1.add(panelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 290, 750));

        jLabel1.setText("Registro Empresa");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        comboTipoEmpresa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboTipoEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Seleccionar", EMPRESA_TRANSPORTADORA, EMPRESA_PRODUCTORA}));
        comboTipoEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoEmpresaActionPerformed(evt);
            }
        });
        jPanel1.add(comboTipoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, -1));

        jLabel2.setText("Tipo de Empresa");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nombre de la Empresa:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 260, 10));

        campoNombreEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoNombreEmpresa.setForeground(Color.GRAY);
        campoNombreEmpresa.setText(NOMBRE_EMPRESA_DEFAULT);
        campoNombreEmpresa.setBorder(null);
        jPanel1.add(campoNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 260, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Correo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 260, 10));

        campoCorreoEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoCorreoEmpresa.setForeground(Color.GRAY);
        campoCorreoEmpresa.setText(CORREO_DEFAULT);
        campoCorreoEmpresa.setBorder(null);
        jPanel1.add(campoCorreoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 260, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Contraseña:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 260, 10));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Confirmar Contraseña:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 260, 10));

        campoContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoContrasena.setForeground(Color.GRAY);
        campoContrasena.setText(CONTRASENA_DEFAULT);
        campoContrasena.setBorder(null);
        campoContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoContrasenaActionPerformed(evt);
            }
        });
        jPanel1.add(campoContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 260, -1));

        registrarEmpresBtn.setBackground(new java.awt.Color(0, 0, 0));
        registrarEmpresBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registrarEmpresBtn.setForeground(new java.awt.Color(255, 255, 255));
        registrarEmpresBtn.setText("Registrarme");
        registrarEmpresBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarEmpresBtnActionPerformed(evt);
            }
        });
        jPanel1.add(registrarEmpresBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, -1, -1));

        checkVisibleContrasena.setText("Visible");
        checkVisibleContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkVisibleContrasenaActionPerformed(evt);
            }
        });
        jPanel1.add(checkVisibleContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, -1, -1));

        checkVisibleContrasena1.setText("Visible");
        checkVisibleContrasena1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkVisibleContrasena1ActionPerformed(evt);
            }
        });
        jPanel1.add(checkVisibleContrasena1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, -1, -1));

        regresarBtn.setBackground(new java.awt.Color(0, 0, 0));
        regresarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        regresarBtn.setForeground(new java.awt.Color(255, 255, 255));
        regresarBtn.setLabel("Regresar");
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, -1, -1));
        jPanel1.add(correoValidoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 120, 20));
        jPanel1.add(contrasenaValidaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 150, 20));

        campoConfirmarContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoConfirmarContrasena.setForeground(Color.GRAY);
        campoConfirmarContrasena.setText(this.CONTRASENA_DEFAULT);
        campoConfirmarContrasena.setBorder(null);
        campoConfirmarContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoConfirmarContrasenaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoConfirmarContrasenaFocusLost(evt);
            }
        });
        campoConfirmarContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoConfirmarContrasenaMouseClicked(evt);
            }
        });
        jPanel1.add(campoConfirmarContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 300, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkVisibleContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkVisibleContrasenaActionPerformed
        if (this.checkVisibleContrasena.isSelected()) {
            this.campoContrasena.setEchoChar((char) 0);
        } else {
            this.campoContrasena.setEchoChar('•');
        }
    }//GEN-LAST:event_checkVisibleContrasenaActionPerformed

    private void checkVisibleContrasena1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkVisibleContrasena1ActionPerformed
        if (this.checkVisibleContrasena.isSelected()) {
            this.campoConfirmarContrasena.setEchoChar((char) 0);
        } else {
            this.campoConfirmarContrasena.setEchoChar('•');
        }
    }//GEN-LAST:event_checkVisibleContrasena1ActionPerformed

    private void campoContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoContrasenaActionPerformed

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        InicioForm i= new InicioForm();
        i.setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarBtnActionPerformed

    private void registrarEmpresBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarEmpresBtnActionPerformed
        int i = 0;
        if (validarContrasenasVacio()) {
            if (!validarContrasenaMostrar()) {
                JOptionPane.showMessageDialog(this, "Contraseñas no coinciden", "No puede registrarse", JOptionPane.ERROR_MESSAGE);
                i++;
            }
        } else {

            List<String> camposVacios = this.validarCamposVacios();
            if (!camposVacios.isEmpty()) {
                String mensaje = "Los siguientes campos se encuentran vacíos \n";
                for (String campos : camposVacios) {
                    mensaje += campos + "\n";
                }
                JOptionPane.showMessageDialog(this, mensaje, "No puedes registrarte", JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }
        if (i == 0) {
            //Método registrar
            JOptionPane.showMessageDialog(this, "Registro exitoso", "Nuevo Registro", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_registrarEmpresBtnActionPerformed

    private void comboTipoEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoEmpresaActionPerformed

    private void campoConfirmarContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoConfirmarContrasenaFocusGained
        if (validarCampoTextoVacio(campoConfirmarContrasena, CONTRASENA_DEFAULT)) {
            this.campoConfirmarContrasena.setForeground(Color.BLACK);
            this.campoConfirmarContrasena.setText("");
        }
    }//GEN-LAST:event_campoConfirmarContrasenaFocusGained

    private void campoConfirmarContrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoConfirmarContrasenaFocusLost
        if (validarCampoTextoVacio(campoConfirmarContrasena, CONTRASENA_DEFAULT)) {
            this.campoConfirmarContrasena.setForeground(Color.GRAY);
            this.campoConfirmarContrasena.setText(CONTRASENA_DEFAULT);
        }
        this.validarContrasenaMostrar();
    }//GEN-LAST:event_campoConfirmarContrasenaFocusLost

    private void campoConfirmarContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoConfirmarContrasenaMouseClicked
        if (validarCampoTextoVacio(campoConfirmarContrasena, CONTRASENA_DEFAULT)) {
            this.campoConfirmarContrasena.setForeground(Color.BLACK);
            this.campoConfirmarContrasena.setText("");
        }
    }//GEN-LAST:event_campoConfirmarContrasenaMouseClicked

    private boolean validarContrasenas() {
        String contrasena = this.campoContrasena.getText();
        String confirmarContrasena = this.campoConfirmarContrasena.getText();
        return contrasena.equals(confirmarContrasena);
    }

    private boolean validarCampoTextoVacio(JTextField campoTexto, String textoDefault) {
        return campoTexto.getText().isEmpty() || campoTexto.getText().equals(textoDefault);
    }
    private List<String> validarCamposVacios() {
        List<String> campos = new LinkedList<>();
//        if (this.validarCampoTextoVacio(comboTipoEmpresa, EMPRESA_TRANSPORTADORA)) {
//            campos.add("- Empresa Transportadora");
//        }
//        if (this.validarCampoTextoVacio(comboTipoEmpresa, EMPRESA_PRODUCTORA)) {
//            campos.add("- Empresa Productora ");
//        }
        if (this.validarCampoTextoVacio(campoNombreEmpresa, NOMBRE_EMPRESA_DEFAULT)) {
            campos.add("- Nombre de empresa");
        }
        if (this.validarCampoTextoVacio(campoCorreoEmpresa, CORREO_DEFAULT)) {
            campos.add("- Correo");
        }
        if (this.campoContrasena.getText().isEmpty() || this.campoContrasena.getText().equals(CONTRASENA_DEFAULT)) {
            campos.add("- Contraseña");
        }
        if (this.campoConfirmarContrasena.getText().isEmpty() || this.campoConfirmarContrasena.getText().equals(CONTRASENA_DEFAULT)) {
            campos.add("- Confirmar contraseña");
        }
        
        return campos;
    }
    private boolean validarContrasenasVacio() {
        if (this.campoContrasena.getText().isEmpty() || this.campoContrasena.getText().equals(CONTRASENA_DEFAULT)) {
            return false;
        }
        if (this.campoConfirmarContrasena.getText().isEmpty() || this.campoConfirmarContrasena.getText().equals(CONTRASENA_DEFAULT)) {
            return false;
        }
        return true;
    }
    private boolean validarContrasenaMostrar() {
        if (validarContrasenasVacio()) {
            if (validarContrasenas()) {
                this.contrasenaValidaLbl.setForeground(Color.GREEN);
                this.contrasenaValidaLbl.setText("Contraseñas coinciden");
                return true;
            } else {
                this.contrasenaValidaLbl.setForeground(Color.red);
                this.contrasenaValidaLbl.setText("Contraseñas no coinciden");
            }
        } else {
            this.contrasenaValidaLbl.setForeground(Color.red);
            this.contrasenaValidaLbl.setText("Contraseñas no coinciden");
        }
        return false;
    }

    public static boolean validarCorreo(String correo) {
        String expresionRegular = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return correo.matches(expresionRegular);
    }

    private boolean validarCorreoMostrar() {
    String correo = campoCorreoEmpresa.getText();

    if (correo.isEmpty()) {
        correoValidoLbl.setForeground(Color.RED);
        correoValidoLbl.setText("El campo correo está vacío");
        return false;
    } else if (validarCorreo(correo)) {
        correoValidoLbl.setForeground(Color.GREEN);
        correoValidoLbl.setText("El correo es válido");
        return true;
    } else {
        correoValidoLbl.setForeground(Color.RED);
        correoValidoLbl.setText("El correo no es válido");
        return false;
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
            java.util.logging.Logger.getLogger(RegistrarEmpresaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarEmpresaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarEmpresaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarEmpresaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarEmpresaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField campoConfirmarContrasena;
    private javax.swing.JPasswordField campoContrasena;
    private javax.swing.JTextField campoCorreoEmpresa;
    private javax.swing.JTextField campoNombreEmpresa;
    private javax.swing.JCheckBox checkVisibleContrasena;
    private javax.swing.JCheckBox checkVisibleContrasena1;
    private javax.swing.JComboBox<String> comboTipoEmpresa;
    private javax.swing.JLabel contrasenaValidaLbl;
    private javax.swing.JLabel correoValidoLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JButton registrarEmpresBtn;
    private javax.swing.JButton regresarBtn;
    // End of variables declaration//GEN-END:variables

}
