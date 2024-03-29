package org.itson.presentacion.Administrador;

import com.dominio.Administrador;

import org.itson.presentacion.LogInForm;

/**
 * Descripción de la clase: Clase principal de administrador
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID:
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PrincipalAdministradorForm extends javax.swing.JFrame {

    /**
     * Representa al objeto Administrador.
     */
    private Administrador administrador;
    /**
     * Instancia única de la clase PrincipalAdministradorForm.
     */
    private static PrincipalAdministradorForm principalFormAdministrador;

    /**
     * 
     * Creates new form PrincipalAdministradorForm
     */
    private PrincipalAdministradorForm() {
        initComponents();
    }

    /**
     * Metodo que cierra ventana actual
     */
    private void cerrarVentanaActual() {
        this.dispose();
    }
    /**
     * Navega hacia la ventana de solicitudes de traslado
     */
    private void irSolicitudesTrasladoForm() {
        Administrador admin = new Administrador();
        admin.setId(administrador.getId());
        admin.setNombres(administrador.getNombres());
        admin.setApellido_paterno(administrador.getApellido_paterno());
        admin.setApellido_materno(administrador.getApellido_materno());
        abrirRegistrarSolicitudesTraslado(administrador);
        cerrarVentanaActual();
    }
    
    /**
     * Método que abre la ventana de solicitud traslado
     * @param administrador Administrador que enviarás al formulario
     */
    private void abrirRegistrarSolicitudesTraslado(Administrador administrador){
        SolicitudesTrasladosForm solicitudesTrasladosForm;
        solicitudesTrasladosForm = SolicitudesTrasladosForm.getInstance();
        solicitudesTrasladosForm.setAdministrador(administrador);
        solicitudesTrasladosForm.iniciarComponentes();
        
    }
    /**
     * Inicia los componentes de la ventana
     */
    public void iniciarComponentes(){
        abrirVentana();
    }
    /**
     * Navega hacia la ventana de inicio de sesión
     */
    private void irLoginForm() {

        LogInForm logInForm;
        logInForm = LogInForm.getInstance();
        logInForm.iniciarComponentes();
    }
    /**
     * Abre la ventana actual y la hace visible
     */
    private void abrirVentana(){
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        panelSecundario = new javax.swing.JPanel();
        lblAdministrador = new javax.swing.JLabel();
        renglonAdministrador = new javax.swing.JSeparator();
        solictarTrasladoBtn = new javax.swing.JButton();
        regresarbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Principal Administrador");
        setPreferredSize(new java.awt.Dimension(720, 531));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPrincipal.setBackground(new java.awt.Color(102, 153, 255));

        panelSecundario.setBackground(new java.awt.Color(255, 255, 255));
        panelSecundario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAdministrador.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 30)); // NOI18N
        lblAdministrador.setText("ADMINISTRADOR");

        solictarTrasladoBtn.setText("Solicitud de Traslado");
        solictarTrasladoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solictarTrasladoBtnActionPerformed(evt);
            }
        });

        regresarbtn.setText("Regresar");
        regresarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSecundarioLayout = new javax.swing.GroupLayout(panelSecundario);
        panelSecundario.setLayout(panelSecundarioLayout);
        panelSecundarioLayout.setHorizontalGroup(
            panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSecundarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSecundarioLayout.createSequentialGroup()
                        .addGap(0, 161, Short.MAX_VALUE)
                        .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSecundarioLayout.createSequentialGroup()
                                .addComponent(renglonAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSecundarioLayout.createSequentialGroup()
                                .addComponent(lblAdministrador)
                                .addGap(209, 209, 209))))
                    .addGroup(panelSecundarioLayout.createSequentialGroup()
                        .addComponent(regresarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelSecundarioLayout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(solictarTrasladoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelSecundarioLayout.setVerticalGroup(
            panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSecundarioLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblAdministrador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(renglonAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(solictarTrasladoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(regresarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(panelSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(panelSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        getContentPane().add(PanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción realizada al hacer clic en el botón "solicitarTrasladoBtn".
     * Navega hacia la ventana de solicitudes de traslado.
     * 
     * @param evt El evento de acción.
     */
    private void solictarTrasladoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solictarTrasladoBtnActionPerformed
        irSolicitudesTrasladoForm();
    }//GEN-LAST:event_solictarTrasladoBtnActionPerformed

     /**
     * Acción realizada al hacer clic en el botón "regresarbtn".
     * Navega hacia la ventana de inicio de sesión y cierra la ventana actual.
     * 
     * @param evt El evento de acción.
     */
    private void regresarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarbtnActionPerformed
        irLoginForm();
        cerrarVentanaActual();
    }//GEN-LAST:event_regresarbtnActionPerformed

    /**
     * Obtiene el objeto Administrador.
     * 
     * @return El objeto Administrador.
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * Establece el objeto Administrador.
     * 
     * @param administrador El objeto Administrador a establecer.
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Obtiene una instancia única de la clase PrincipalAdministradorForm.
     * 
     * @return La instancia única de PrincipalAdministradorForm.
     */
    public static PrincipalAdministradorForm getInstance(){
        if(principalFormAdministrador == null){
            principalFormAdministrador = new PrincipalAdministradorForm();
        }
        return principalFormAdministrador;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Panel principal
     */
    private javax.swing.JPanel PanelPrincipal;
    /**
     * Label de administrador
     */
    private javax.swing.JLabel lblAdministrador;
    /**
     * Panel secundario
     */
    private javax.swing.JPanel panelSecundario;
    /**
     * Botón regresar
     */
    private javax.swing.JButton regresarbtn;
    /**
     * Renglón del administrador
     */
    private javax.swing.JSeparator renglonAdministrador;
    /**
     * Botón solicitar traslado
     */
    private javax.swing.JButton solictarTrasladoBtn;
    // End of variables declaration//GEN-END:variables
}
