
package org.itson.presentacion.Administrador;

import org.itson.presentacion.InicioForm;

/**
 *
 * @author arace
 */
public class PrincipalAdministradorForm extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalAdministradorForm
     */
    public PrincipalAdministradorForm() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        solicitarTrasladosBtn = new javax.swing.JButton();
        solicitudesTrasladosBtn = new javax.swing.JButton();
        actualizarSolictudBtn = new javax.swing.JButton();
        eliminarSolicitudBtn = new javax.swing.JButton();
        regresarBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(720, 531));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 30)); // NOI18N
        jLabel2.setText("ADMINISTRADOR");

        solicitarTrasladosBtn.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        solicitarTrasladosBtn.setText("Solicitar Traslado");
        solicitarTrasladosBtn.setDefaultCapable(false);
        solicitarTrasladosBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        solicitarTrasladosBtn.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        solicitarTrasladosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitarTrasladosBtnActionPerformed(evt);
            }
        });

        solicitudesTrasladosBtn.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        solicitudesTrasladosBtn.setText("Ver solicitudes");
        solicitudesTrasladosBtn.setContentAreaFilled(false);
        solicitudesTrasladosBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        solicitudesTrasladosBtn.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        actualizarSolictudBtn.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        actualizarSolictudBtn.setText("Actualizar Solicitud");
        actualizarSolictudBtn.setContentAreaFilled(false);
        actualizarSolictudBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        actualizarSolictudBtn.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        eliminarSolicitudBtn.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        eliminarSolicitudBtn.setText("Eliminar Solicitud");
        eliminarSolicitudBtn.setContentAreaFilled(false);
        eliminarSolicitudBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliminarSolicitudBtn.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        eliminarSolicitudBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarSolicitudBtnActionPerformed(evt);
            }
        });

        regresarBtn.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        regresarBtn.setText("Regresar");
        regresarBtn.setContentAreaFilled(false);
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(solicitudesTrasladosBtn))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(solicitarTrasladosBtn)))
                        .addGap(188, 188, 188)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eliminarSolicitudBtn)
                            .addComponent(actualizarSolictudBtn)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(regresarBtn)))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(209, 209, 209))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(actualizarSolictudBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(solicitarTrasladosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(solicitudesTrasladosBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eliminarSolicitudBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(regresarBtn)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void solicitarTrasladosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitarTrasladosBtnActionPerformed
    SolicitudesTrasladosForm b = new SolicitudesTrasladosForm();
    b.setVisible(true);
    dispose();
    }//GEN-LAST:event_solicitarTrasladosBtnActionPerformed

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        InicioForm p = new InicioForm();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarBtnActionPerformed

    private void eliminarSolicitudBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarSolicitudBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarSolicitudBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalAdministradorForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarSolictudBtn;
    private javax.swing.JButton eliminarSolicitudBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JButton solicitarTrasladosBtn;
    private javax.swing.JButton solicitudesTrasladosBtn;
    // End of variables declaration//GEN-END:variables
}