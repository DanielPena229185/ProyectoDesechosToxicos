/**
 * Login.java
 * 2 may. 2023 16:03:40
 *
 */
package org.itson.presentacion;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JPanel;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Login extends javax.swing.JFrame {

    JPanel panelLogin;
    JPanel panelRegistrar;

    /**
     * Creates new form Login
     */
    public Login(JPanel panelLogin, JPanel panelRegistrar) {
        this.panelLogin = panelLogin;
        this.panelRegistrar = panelRegistrar;
        initComponents();
    }

    public Login() {
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

        fondoPanel = new javax.swing.JPanel();
        encabezadoIniciarSesionPanel = new javax.swing.JPanel();
        encabezadoRegistrarmePanel = new javax.swing.JPanel();
        iniciarSesionPanel = new javax.swing.JPanel();
        registrarmePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondoPanel.setBackground(new java.awt.Color(255, 255, 255));
        fondoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        encabezadoIniciarSesionPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout encabezadoIniciarSesionPanelLayout = new javax.swing.GroupLayout(encabezadoIniciarSesionPanel);
        encabezadoIniciarSesionPanel.setLayout(encabezadoIniciarSesionPanelLayout);
        encabezadoIniciarSesionPanelLayout.setHorizontalGroup(
            encabezadoIniciarSesionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        encabezadoIniciarSesionPanelLayout.setVerticalGroup(
            encabezadoIniciarSesionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        fondoPanel.add(encabezadoIniciarSesionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, -1));

        encabezadoRegistrarmePanel.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout encabezadoRegistrarmePanelLayout = new javax.swing.GroupLayout(encabezadoRegistrarmePanel);
        encabezadoRegistrarmePanel.setLayout(encabezadoRegistrarmePanelLayout);
        encabezadoRegistrarmePanelLayout.setHorizontalGroup(
            encabezadoRegistrarmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        encabezadoRegistrarmePanelLayout.setVerticalGroup(
            encabezadoRegistrarmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        fondoPanel.add(encabezadoRegistrarmePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 460, -1));

        javax.swing.GroupLayout iniciarSesionPanelLayout = new javax.swing.GroupLayout(iniciarSesionPanel);
        iniciarSesionPanel.setLayout(iniciarSesionPanelLayout);
        iniciarSesionPanelLayout.setHorizontalGroup(
            iniciarSesionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        iniciarSesionPanelLayout.setVerticalGroup(
            iniciarSesionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        fondoPanel.add(iniciarSesionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 480, 510));

        javax.swing.GroupLayout registrarmePanelLayout = new javax.swing.GroupLayout(registrarmePanel);
        registrarmePanel.setLayout(registrarmePanelLayout);
        registrarmePanelLayout.setHorizontalGroup(
            registrarmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        registrarmePanelLayout.setVerticalGroup(
            registrarmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        fondoPanel.add(registrarmePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 460, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel encabezadoIniciarSesionPanel;
    private javax.swing.JPanel encabezadoRegistrarmePanel;
    private javax.swing.JPanel fondoPanel;
    private javax.swing.JPanel iniciarSesionPanel;
    private javax.swing.JPanel registrarmePanel;
    // End of variables declaration//GEN-END:variables

}
