/**
 * RegistrarAdministrador.java
 * 4 may. 2023 16:54:00
 *
 */
package org.itson.presentacion;

import java.awt.Color;
import java.util.List;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class RegistrarAdministradorForm extends javax.swing.JFrame {

    private final String NOMBRE_DEFAULT = "María Fernanda";
    private final String APELLIDO_PATERNO_DEFAULT = "Fernandez";
    private final String APELLIDO_MATERNO_DEFAULT = "Pérez";

    private static final String CORREO_DEFAULT = "info@ejemplo.com";
    private static final String CONTRASENA_DEFAULT = "123456789112345";

    /**
     * Creates new form RegistrarAdministrador
     */
    public RegistrarAdministradorForm() {
        initComponents();
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        this.campoContrasena.setEchoChar('•');
        this.campoConfirmarContrasena.setEchoChar('•');
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
        panelInfo = new javax.swing.JPanel();
        registrarmeLbl = new javax.swing.JLabel();
        lblConfirmarContrasenaLbl = new javax.swing.JLabel();
        renglonPaterno = new javax.swing.JSeparator();
        campoPaterno = new javax.swing.JTextField();
        nombresLbl = new javax.swing.JLabel();
        renglonContrasena = new javax.swing.JSeparator();
        campoNombres = new javax.swing.JTextField();
        paternoLbl = new javax.swing.JLabel();
        renglonMaterno = new javax.swing.JSeparator();
        campoMaterno = new javax.swing.JTextField();
        maternoLbl = new javax.swing.JLabel();
        apellidosLbl = new javax.swing.JLabel();
        renglonNombres = new javax.swing.JSeparator();
        campoCorreo = new javax.swing.JTextField();
        correoLbl = new javax.swing.JLabel();
        renglonCorreo = new javax.swing.JSeparator();
        campoContrasena = new javax.swing.JPasswordField();
        checkVisibleConfirmarContrasena = new javax.swing.JCheckBox();
        renglonConfirmarContrasena = new javax.swing.JSeparator();
        campoConfirmarContrasena = new javax.swing.JPasswordField();
        checkVisibleContrasena = new javax.swing.JCheckBox();
        contrasenaLbl = new javax.swing.JLabel();
        registrarmeBtn = new javax.swing.JButton();
        contrasenaValidaLbl = new javax.swing.JLabel();
        correoValidoLbl = new javax.swing.JLabel();
        regresarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelInfo.setBackground(new Color(51, 162, 255));

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        panelFondo.add(panelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 280, 530));

        registrarmeLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        registrarmeLbl.setText("Registrarme");
        panelFondo.add(registrarmeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblConfirmarContrasenaLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblConfirmarContrasenaLbl.setText("Confirmar contraseña:");
        panelFondo.add(lblConfirmarContrasenaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));
        panelFondo.add(renglonPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 140, 10));

        campoPaterno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoPaterno.setForeground(Color.GRAY);
        campoPaterno.setText(APELLIDO_PATERNO_DEFAULT);
        campoPaterno.setBorder(null);
        campoPaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPaternoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoPaternoFocusLost(evt);
            }
        });
        campoPaterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoPaternoMouseClicked(evt);
            }
        });
        panelFondo.add(campoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 140, -1));

        nombresLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombresLbl.setText("Nombres:");
        panelFondo.add(nombresLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        panelFondo.add(renglonContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 300, 10));

        campoNombres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoNombres.setForeground(Color.GRAY);
        campoNombres.setText(NOMBRE_DEFAULT);
        campoNombres.setBorder(null);
        campoNombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoNombresFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNombresFocusLost(evt);
            }
        });
        campoNombres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoNombresMouseClicked(evt);
            }
        });
        panelFondo.add(campoNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 200, -1));

        paternoLbl.setBackground(new java.awt.Color(255, 255, 255));
        paternoLbl.setText("Paterno");
        panelFondo.add(paternoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));
        panelFondo.add(renglonMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 140, 10));

        campoMaterno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoMaterno.setForeground(Color.GRAY);
        campoMaterno.setText(APELLIDO_MATERNO_DEFAULT);
        campoMaterno.setBorder(null);
        campoMaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoMaternoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoMaternoFocusLost(evt);
            }
        });
        campoMaterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoMaternoMouseClicked(evt);
            }
        });
        panelFondo.add(campoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 140, -1));

        maternoLbl.setBackground(new java.awt.Color(255, 255, 255));
        maternoLbl.setText("Materno");
        panelFondo.add(maternoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        apellidosLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        apellidosLbl.setText("Apellidos:");
        panelFondo.add(apellidosLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        panelFondo.add(renglonNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 200, 10));

        campoCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoCorreo.setForeground(Color.GRAY);
        campoCorreo.setText(CORREO_DEFAULT);
        campoCorreo.setBorder(null);
        campoCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCorreoFocusLost(evt);
            }
        });
        campoCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoCorreoMouseClicked(evt);
            }
        });
        panelFondo.add(campoCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 300, -1));

        correoLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        correoLbl.setText("Correo:");
        panelFondo.add(correoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));
        panelFondo.add(renglonCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 300, 10));

        campoContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoContrasena.setForeground(Color.GRAY);
        campoContrasena.setText(CONTRASENA_DEFAULT);
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
        panelFondo.add(campoContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 300, -1));

        checkVisibleConfirmarContrasena.setText("Visible");
        checkVisibleConfirmarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkVisibleConfirmarContrasenaActionPerformed(evt);
            }
        });
        panelFondo.add(checkVisibleConfirmarContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, -1, -1));
        panelFondo.add(renglonConfirmarContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 300, 10));

        campoConfirmarContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoConfirmarContrasena.setForeground(Color.GRAY);
        campoConfirmarContrasena.setText(CONTRASENA_DEFAULT);
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
        panelFondo.add(campoConfirmarContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 300, -1));

        checkVisibleContrasena.setText("Visible");
        checkVisibleContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkVisibleContrasenaActionPerformed(evt);
            }
        });
        panelFondo.add(checkVisibleContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        contrasenaLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        contrasenaLbl.setText("Contraseña:");
        panelFondo.add(contrasenaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        registrarmeBtn.setBackground(new java.awt.Color(0, 0, 0));
        registrarmeBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registrarmeBtn.setForeground(new java.awt.Color(255, 255, 255));
        registrarmeBtn.setText("Registrarme");
        registrarmeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarmeBtnActionPerformed(evt);
            }
        });
        panelFondo.add(registrarmeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));
        panelFondo.add(contrasenaValidaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));
        panelFondo.add(correoValidoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        regresarBtn.setBackground(new java.awt.Color(0, 0, 0));
        regresarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        regresarBtn.setForeground(new java.awt.Color(255, 255, 255));
        regresarBtn.setLabel("Regresar");
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });
        panelFondo.add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, -1, -1));

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
    }// </editor-fold>//GEN-END:initComponents

    private void campoNombresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombresFocusGained
        if (validarCampoTextoVacio(campoNombres, NOMBRE_DEFAULT)) {
            this.campoNombres.setForeground(Color.BLACK);
            this.campoNombres.setText("");
        }
    }//GEN-LAST:event_campoNombresFocusGained

    private void campoNombresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombresFocusLost
        if (validarCampoTextoVacio(campoNombres, NOMBRE_DEFAULT)) {
            this.campoNombres.setForeground(Color.GRAY);
            this.campoNombres.setText(NOMBRE_DEFAULT);
        }
    }//GEN-LAST:event_campoNombresFocusLost

    private void campoNombresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNombresMouseClicked
        if (validarCampoTextoVacio(campoNombres, NOMBRE_DEFAULT)) {
            this.campoNombres.setForeground(Color.BLACK);
            this.campoNombres.setText("");
        }
    }//GEN-LAST:event_campoNombresMouseClicked

    private void campoPaternoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPaternoFocusGained
        if (validarCampoTextoVacio(campoPaterno, APELLIDO_PATERNO_DEFAULT)) {
            this.campoPaterno.setForeground(Color.BLACK);
            this.campoPaterno.setText("");
        }
    }//GEN-LAST:event_campoPaternoFocusGained

    private void campoPaternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoPaternoMouseClicked
        if (validarCampoTextoVacio(campoPaterno, APELLIDO_PATERNO_DEFAULT)) {
            this.campoPaterno.setForeground(Color.BLACK);
            this.campoPaterno.setText("");
        }
    }//GEN-LAST:event_campoPaternoMouseClicked

    private void campoPaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPaternoFocusLost
        if (validarCampoTextoVacio(campoPaterno, APELLIDO_PATERNO_DEFAULT)) {
            this.campoPaterno.setForeground(Color.GRAY);
            this.campoPaterno.setText(APELLIDO_PATERNO_DEFAULT);
        }
    }//GEN-LAST:event_campoPaternoFocusLost

    private void campoMaternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoMaternoMouseClicked
        if (validarCampoTextoVacio(campoMaterno, APELLIDO_MATERNO_DEFAULT)) {
            this.campoMaterno.setForeground(Color.BLACK);
            this.campoMaterno.setText("");
        }
    }//GEN-LAST:event_campoMaternoMouseClicked

    private void campoMaternoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoMaternoFocusGained
        if (validarCampoTextoVacio(campoMaterno, APELLIDO_MATERNO_DEFAULT)) {
            this.campoMaterno.setForeground(Color.BLACK);
            this.campoMaterno.setText("");
        }
    }//GEN-LAST:event_campoMaternoFocusGained

    private void campoMaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoMaternoFocusLost
        if (validarCampoTextoVacio(campoMaterno, APELLIDO_MATERNO_DEFAULT)) {
            this.campoMaterno.setForeground(Color.GRAY);
            this.campoMaterno.setText(APELLIDO_MATERNO_DEFAULT);
        }
    }//GEN-LAST:event_campoMaternoFocusLost

    private void campoCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCorreoFocusGained
        if (validarCampoTextoVacio(campoCorreo, CORREO_DEFAULT)) {
            this.campoCorreo.setForeground(Color.BLACK);
            this.campoCorreo.setText("");
        }
    }//GEN-LAST:event_campoCorreoFocusGained

    private void campoCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCorreoFocusLost
        if (validarCampoTextoVacio(campoCorreo, CORREO_DEFAULT)) {
            this.campoCorreo.setForeground(Color.GRAY);
            this.campoCorreo.setText(CORREO_DEFAULT);
        }
        this.validarCorreoMostrar();
    }//GEN-LAST:event_campoCorreoFocusLost

    private void campoCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoCorreoMouseClicked
        if (validarCampoTextoVacio(campoCorreo, CORREO_DEFAULT)) {
            this.campoCorreo.setForeground(Color.BLACK);
            this.campoCorreo.setText("");
        }
    }//GEN-LAST:event_campoCorreoMouseClicked

    private void campoContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoContrasenaFocusGained
        if (validarCampoTextoVacio(campoContrasena, CONTRASENA_DEFAULT)) {
            this.campoContrasena.setForeground(Color.BLACK);
            this.campoContrasena.setText("");
        }
    }//GEN-LAST:event_campoContrasenaFocusGained

    private void campoContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoContrasenaMouseClicked
        if (validarCampoTextoVacio(campoContrasena, CONTRASENA_DEFAULT)) {
            this.campoContrasena.setForeground(Color.BLACK);
            this.campoContrasena.setText("");
        }
    }//GEN-LAST:event_campoContrasenaMouseClicked

    private void campoContrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoContrasenaFocusLost
        if (validarCampoTextoVacio(campoContrasena, CONTRASENA_DEFAULT)) {
            this.campoContrasena.setForeground(Color.GRAY);
            this.campoContrasena.setText(CONTRASENA_DEFAULT);
        }
    }//GEN-LAST:event_campoContrasenaFocusLost

    private void campoConfirmarContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoConfirmarContrasenaFocusGained
        if (validarCampoTextoVacio(campoConfirmarContrasena, CONTRASENA_DEFAULT)) {
            this.campoConfirmarContrasena.setForeground(Color.BLACK);
            this.campoConfirmarContrasena.setText("");
        }
    }//GEN-LAST:event_campoConfirmarContrasenaFocusGained

    private void campoConfirmarContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoConfirmarContrasenaMouseClicked
        if (validarCampoTextoVacio(campoConfirmarContrasena, CONTRASENA_DEFAULT)) {
            this.campoConfirmarContrasena.setForeground(Color.BLACK);
            this.campoConfirmarContrasena.setText("");
        }
    }//GEN-LAST:event_campoConfirmarContrasenaMouseClicked

    private void campoConfirmarContrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoConfirmarContrasenaFocusLost
        if (validarCampoTextoVacio(campoConfirmarContrasena, CONTRASENA_DEFAULT)) {
            this.campoConfirmarContrasena.setForeground(Color.GRAY);
            this.campoConfirmarContrasena.setText(CONTRASENA_DEFAULT);
        }
        this.validarContrasenaMostrar();
    }//GEN-LAST:event_campoConfirmarContrasenaFocusLost

    private void checkVisibleContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkVisibleContrasenaActionPerformed
        if (this.checkVisibleContrasena.isSelected()) {
            this.campoContrasena.setEchoChar((char) 0);
        } else {
            this.campoContrasena.setEchoChar('•');
        }
    }//GEN-LAST:event_checkVisibleContrasenaActionPerformed

    private void checkVisibleConfirmarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkVisibleConfirmarContrasenaActionPerformed
        if (this.checkVisibleConfirmarContrasena.isSelected()) {
            this.campoConfirmarContrasena.setEchoChar((char) 0);
        } else {
            this.campoConfirmarContrasena.setEchoChar('•');
        }
    }//GEN-LAST:event_checkVisibleConfirmarContrasenaActionPerformed

    private void registrarmeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarmeBtnActionPerformed
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
          
            JOptionPane.showMessageDialog(this, "Registro exitoso", "Nuevo Registro", JOptionPane.INFORMATION_MESSAGE);
        }
        InicioForm a = new InicioForm(); 
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_registrarmeBtnActionPerformed

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        InicioForm i= new InicioForm();
        i.setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarBtnActionPerformed

    private boolean validarContrasenas() {
        String contrasena = this.campoContrasena.getText();
        String confirmarContrasena = this.campoConfirmarContrasena.getText();
        return contrasena.equals(confirmarContrasena);
    }

    private List<String> validarCamposVacios() {
        List<String> campos = new LinkedList<>();
        if (this.validarCampoTextoVacio(campoNombres, NOMBRE_DEFAULT)) {
            campos.add("- Nombre");
        }
        if (this.validarCampoTextoVacio(campoPaterno, APELLIDO_PATERNO_DEFAULT)) {
            campos.add("- Apellido Paterno");
        }
        if (this.validarCampoTextoVacio(campoMaterno, APELLIDO_MATERNO_DEFAULT)) {
            campos.add("- Apellido Materno");
        }
        if (this.validarCampoTextoVacio(campoCorreo, CORREO_DEFAULT)) {
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
            java.util.logging.Logger.getLogger(RegistrarAdministradorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdministradorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdministradorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdministradorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarAdministradorForm().setVisible(true);
            }
        });
    }

    private boolean validarCampoTextoVacio(JTextField campoTexto, String textoDefault) {
        return campoTexto.getText().isEmpty() || campoTexto.getText().equals(textoDefault);
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
    String correo = campoCorreo.getText();

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellidosLbl;
    private javax.swing.JPasswordField campoConfirmarContrasena;
    private javax.swing.JPasswordField campoContrasena;
    private javax.swing.JTextField campoCorreo;
    private javax.swing.JTextField campoMaterno;
    private javax.swing.JTextField campoNombres;
    private javax.swing.JTextField campoPaterno;
    private javax.swing.JCheckBox checkVisibleConfirmarContrasena;
    private javax.swing.JCheckBox checkVisibleContrasena;
    private javax.swing.JLabel contrasenaLbl;
    private javax.swing.JLabel contrasenaValidaLbl;
    private javax.swing.JLabel correoLbl;
    private javax.swing.JLabel correoValidoLbl;
    private javax.swing.JLabel lblConfirmarContrasenaLbl;
    private javax.swing.JLabel maternoLbl;
    private javax.swing.JLabel nombresLbl;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JLabel paternoLbl;
    private javax.swing.JButton registrarmeBtn;
    private javax.swing.JLabel registrarmeLbl;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JSeparator renglonConfirmarContrasena;
    private javax.swing.JSeparator renglonContrasena;
    private javax.swing.JSeparator renglonCorreo;
    private javax.swing.JSeparator renglonMaterno;
    private javax.swing.JSeparator renglonNombres;
    private javax.swing.JSeparator renglonPaterno;
    // End of variables declaration//GEN-END:variables

}
