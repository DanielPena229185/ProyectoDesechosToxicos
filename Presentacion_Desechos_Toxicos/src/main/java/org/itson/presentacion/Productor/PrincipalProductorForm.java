package org.itson.presentacion.Productor;

import com.dominio.Productor;
import org.itson.presentacion.LogInForm;
import org.itson.presentacion.residuo.RegistroResiduoForm;

/**
 *
 * @author arace
 */
public class PrincipalProductorForm extends javax.swing.JFrame {

    private Productor productor;
    private static PrincipalProductorForm form;

    /**
     * Creates new form PrincipalProductorForm
     */
    private PrincipalProductorForm() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnRegistrarResiduo = new javax.swing.JButton();
        regresarBtn = new javax.swing.JButton();
        btnSolicitarTraslado = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 30)); // NOI18N
        jLabel2.setText("PRODUCTOR");

        btnRegistrarResiduo.setBackground(new java.awt.Color(0, 0, 0));
        btnRegistrarResiduo.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        btnRegistrarResiduo.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarResiduo.setText("Registrar Residuo");
        btnRegistrarResiduo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarResiduoActionPerformed(evt);
            }
        });

        regresarBtn.setBackground(new java.awt.Color(153, 204, 255));
        regresarBtn.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        regresarBtn.setText("Regresar");
        regresarBtn.setContentAreaFilled(false);
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });

        btnSolicitarTraslado.setBackground(new java.awt.Color(0, 0, 0));
        btnSolicitarTraslado.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        btnSolicitarTraslado.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitarTraslado.setText("Solicitar Traslado");
        btnSolicitarTraslado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarTrasladoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(regresarBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSolicitarTraslado, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrarResiduo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnRegistrarResiduo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSolicitarTraslado, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(regresarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        this.abrirLoginForm();
        this.cerrarVentana();
    }//GEN-LAST:event_regresarBtnActionPerformed

    private void btnRegistrarResiduoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarResiduoActionPerformed
        abrirRegistroResiduoForm();
    }//GEN-LAST:event_btnRegistrarResiduoActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        this.abrirLoginForm();
        this.cerrarVentana();
    }//GEN-LAST:event_formComponentHidden

    private void btnSolicitarTrasladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarTrasladoActionPerformed
        this.abrirSolicitarTrasladoForm();
    }//GEN-LAST:event_btnSolicitarTrasladoActionPerformed

    public void iniciarComponentes(){
        this.abrirVentana();
    }
    
    private void abrirSolicitarTrasladoForm(){
        SolicitarTrasladoForm solicitarTrasladoForm;
        solicitarTrasladoForm = SolicitarTrasladoForm.getInstance();
        solicitarTrasladoForm.setProductor(productor);
        solicitarTrasladoForm.iniciarComponentes();
    }
    
    private void abrirRegistroResiduoForm(){
        RegistroResiduoForm registroResiduo = null;
        registroResiduo = RegistroResiduoForm.getInstance();
        registroResiduo.setProductor(productor);
        registroResiduo.iniciarComponentes();
    }
    
    private void abrirVentana(){
        this.setVisible(true);
    }

    public static PrincipalProductorForm getInstance() {
        if (form == null) {
            form = new PrincipalProductorForm();
        }
        return form;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }
    
    private void abrirLoginForm(){
        LogInForm login = LogInForm.getInstance();
        login.iniciarComponentes();
    }

    private void cerrarVentana(){
        this.setVisible(false);
        this.reiniciarFrame();
    }

    private void reiniciarFrame(){
        this.productor = null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarResiduo;
    private javax.swing.JButton btnSolicitarTraslado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton regresarBtn;
    // End of variables declaration//GEN-END:variables
}
