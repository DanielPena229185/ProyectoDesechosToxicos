
package org.itson.presentacion.Administrador;

import org.itson.presentacion.Administrador.PrincipalAdministradorForm;

/**
 * Descripción de la clase: Solicitudes de traslados 
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID:
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class SolicitudesTrasladosForm extends javax.swing.JFrame {

    /**
     * Creates new form TrasladoEmpresasForm
     */
    public SolicitudesTrasladosForm() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxEmpresa = new javax.swing.JComboBox<>();
        label1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDatosEmpresa = new javax.swing.JTable();
        asignarBtn = new javax.swing.JButton();
        regresarBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cerrarSesionBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        jLabel1.setText("Empresas disponibles: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel2.setText("Solicitudes de traslados: No atendidas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        comboBoxEmpresa.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        comboBoxEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empresa 1", "Empresa 2", "" }));
        comboBoxEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEmpresaActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 200, -1));

        label1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 30)); // NOI18N
        label1.setText("Solicitudes de traslados");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 340, 20));

        tableDatosEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Productor", "Fecha Solicitada", "Residuos a transportar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDatosEmpresa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 420, 80));

        asignarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        asignarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/siguiente.png"))); // NOI18N
        asignarBtn.setContentAreaFilled(false);
        asignarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(asignarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, -1));

        regresarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regresarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/regresar.png"))); // NOI18N
        regresarBtn.setContentAreaFilled(false);
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 530));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jLabel3.setText("Sesion: Administrador");

        cerrarSesionBtn.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        cerrarSesionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/sesion.png"))); // NOI18N
        cerrarSesionBtn.setContentAreaFilled(false);
        cerrarSesionBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cerrarSesionBtn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/sesion_G.png"))); // NOI18N
        cerrarSesionBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cerrarSesionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cerrarSesionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addContainerGap(465, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 300, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEmpresaActionPerformed
        

    }//GEN-LAST:event_comboBoxEmpresaActionPerformed

    private void asignarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarBtnActionPerformed
       RegistrarTrasladoForm r = new RegistrarTrasladoForm();
       r.setVisible(true);
       dispose();
    }//GEN-LAST:event_asignarBtnActionPerformed

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
      PrincipalAdministradorForm p = new PrincipalAdministradorForm();
      p.setVisible(true);
      dispose();
    }//GEN-LAST:event_regresarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SolicitudesTrasladosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolicitudesTrasladosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolicitudesTrasladosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolicitudesTrasladosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolicitudesTrasladosForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asignarBtn;
    private javax.swing.JButton cerrarSesionBtn;
    private javax.swing.JComboBox<String> comboBoxEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label1;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JTable tableDatosEmpresa;
    // End of variables declaration//GEN-END:variables
}
