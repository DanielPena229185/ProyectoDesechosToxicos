/**
 * LogInForm.java
 * 3 may. 2023 11:33:21
 *
 */
package org.itson.presentacion;

import com.dominio.Administrador;
import com.dominio.EmpresaTransportista;
import com.dominio.Productor;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.DTO.EmpresaTransportistaDTO;
import org.itson.DTO.ProductorDTO;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.PresentacionException;
import org.itson.implementacion.FachadaNegocio;
import org.itson.interfaces.INegocio;
import org.itson.presentacion.Administrador.PrincipalAdministradorForm;
import org.itson.presentacion.Productor.PrincipalProductorForm;
import org.itson.presentacion.empresa.PrincipalEmpresaForm;

/**
 * Descripción de la clase: Form que permite iniciar sesion 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class LogInForm extends javax.swing.JFrame {

    // Constantes de roles
    private static final String ADMINISTRADOR = "Administrador";
    private static final String PRODUCTOR = "Productor";
    private static final String EMPRESA_TRANSPORTADORA = "Empresa Transportadora";

    // Valores predeterminados de correo electrónico y contraseña
    private static final String CORREO_DEFAULT = "info@ejemplo.com";
    private static final String CONTRASENA_DEFAULT = "123456789112345";

    // Objeto de negocio para acceder a la lógica del negocio
    INegocio negocio;

    // Objeto de formulario de inicio de sesión
    static LogInForm login;

    /**
     * Creates new form LogInForm
     */
    public LogInForm() {
        negocio = new FachadaNegocio();
        initComponents();
        this.setVisible(true);
    }

    /**
     * Inicia los componentes de la aplicación.
     * Este método se encarga de abrir la ventana principal.
     */
    public void iniciarComponentes() {
        this.abrirVentana();
    }
    /**
     * Abre la ventana principal de la aplicación.
     * Establece la visibilidad de la ventana como verdadera.
     */
    private void abrirVentana() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelInformacion.setBackground(new java.awt.Color(208, 208, 208));
        panelInformacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelFondo.add(panelInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 320, 530));

        iniciarSesionComoLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        iniciarSesionComoLabel.setText("Iniciar Sesión como:");
        panelFondo.add(iniciarSesionComoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        comboBoxOpcionLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxOpcionLogin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", this.ADMINISTRADOR, this.PRODUCTOR, this.EMPRESA_TRANSPORTADORA }));
        comboBoxOpcionLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxOpcionLoginActionPerformed(evt);
            }
        });
        panelFondo.add(comboBoxOpcionLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 200, -1));

        usuarioLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usuarioLbl.setText("Usuario");
        panelFondo.add(usuarioLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        renglonUsuario.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(renglonUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 280, 10));

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
        contrasenaLbl.setText("Contraseña");
        panelFondo.add(contrasenaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        renglonContrasena.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(renglonContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 280, 10));

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
        iniciarSesionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSesionBtnActionPerformed(evt);
            }
        });
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

    /**
     * Maneja el evento de selección de una opción en el ComboBox de login.
     * Obtiene el elemento seleccionado y realiza cambios en el panel de información según el tipo de login.
     * 
     * @param evt El evento de selección de opción en el ComboBox.
     */
    private void comboBoxOpcionLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxOpcionLoginActionPerformed
        String itemSelected = this.comboBoxOpcionLogin.getSelectedItem().toString();
        this.cambiarColorTipoLoginPanelInformacion(itemSelected);
    }//GEN-LAST:event_comboBoxOpcionLoginActionPerformed

    /**
     * Maneja el evento de acción del CheckBox de visibilidad de contraseña.
     * Alterna la visibilidad de la contraseña en el campo correspondiente.
     * Si el CheckBox está seleccionado y el campo de contraseña está vacío, se borra el contenido.
     * Si el CheckBox no está seleccionado y el campo de contraseña está vacío, se establece un valor predeterminado.
     * 
     * @param evt El evento de acción del CheckBox.
     */
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

    /**
     * Maneja el evento de clic en el campo de usuario.
     * Si el campo de usuario está vacío, cambia el color del texto a negro y borra el contenido.
     * 
     * @param evt El evento de clic en el campo de usuario.
     */
    private void campoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoUsuarioMouseClicked
        if (this.verificarCampoUsuarioVacio()) {
            this.campoUsuario.setForeground(Color.BLACK);
            this.campoUsuario.setText("");
        }
    }//GEN-LAST:event_campoUsuarioMouseClicked

    /**
     * Maneja el evento de enfoque obtenido en el campo de usuario.
     * Si el campo de usuario está vacío, cambia el color del texto a negro y borra el contenido.
     * 
     * @param evt El evento de enfoque obtenido en el campo de usuario.
     */
    private void campoUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoUsuarioFocusGained
        if (this.verificarCampoUsuarioVacio()) {
            this.campoUsuario.setForeground(Color.BLACK);
            this.campoUsuario.setText("");
        }
    }//GEN-LAST:event_campoUsuarioFocusGained

    /**
     * Maneja el evento de enfoque perdido en el campo de usuario.
     * Si el campo de usuario está vacío, cambia el color del texto a gris y establece un valor predeterminado.
     * 
     * @param evt El evento de enfoque perdido en el campo de usuario.
     */
    private void campoUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoUsuarioFocusLost
        if (this.verificarCampoUsuarioVacio()) {
            this.campoUsuario.setForeground(Color.GRAY);
            this.campoUsuario.setText(this.CORREO_DEFAULT);
        }
    }//GEN-LAST:event_campoUsuarioFocusLost

    /**
     * Maneja el evento de enfoque perdido en el campo de usuario.
     * Si el campo de usuario está vacío, cambia el color del texto a gris y establece un valor predeterminado.
     * 
     * @param evt El evento de enfoque perdido en el campo de usuario.
     */
    private void campoContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoContrasenaMouseClicked
        if (this.verificarCampoContrasenaVacio()) {
            this.campoContrasena.setForeground(Color.BLACK);
            this.campoContrasena.setText("");
        }
    }//GEN-LAST:event_campoContrasenaMouseClicked

    /**
     * Maneja el evento de enfoque obtenido en el campo de contraseña
     * Si el campo de contraseña está vacío, cambia el color del texto a negro y borra el contenido
     * @param evt El evento de enfoque obtenido en el campo de contraseña
     */
    private void campoContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoContrasenaFocusGained
        if (this.verificarCampoContrasenaVacio()) {
            this.campoContrasena.setForeground(Color.BLACK);
            this.campoContrasena.setText("");
        }

    }//GEN-LAST:event_campoContrasenaFocusGained

    /**
     * Maneja el evento de enfoque perdido en el campo de contraseña.
     * Si el campo de contraseña está vacío, cambia el color del texto a gris y establece un valor predeterminado.
     * 
     * @param evt El evento de enfoque perdido en el campo de contraseña.
     */
    private void campoContrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoContrasenaFocusLost

        if (this.verificarCampoContrasenaVacio()) {
            this.campoContrasena.setForeground(Color.GRAY);
            this.campoContrasena.setText(this.CONTRASENA_DEFAULT);
        }

    }//GEN-LAST:event_campoContrasenaFocusLost

    /**
     * Maneja el evento de acción del botón de iniciar sesión.
     * Obtiene la opción seleccionada en el ComboBox y realiza las acciones correspondientes según dicha opción.
     * En el caso de "Administrador", se intenta iniciar sesión como administrador y se cierra la ventana actual.
     * En el caso de "Empresa Transportadora", se intenta iniciar sesión como empresa transportista y se cierra la ventana actual.
     * En el caso de "Productor", se intenta iniciar sesión como productor.
     * 
     * @param evt El evento de acción del botón de iniciar sesión.
     */
    private void iniciarSesionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSesionBtnActionPerformed
        String selectedItem = comboBoxOpcionLogin.getSelectedItem().toString();
        switch (selectedItem) {
            case ADMINISTRADOR:
                try {
                    this.iniciarSesionAdministrador();
                } catch (NegocioException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
                dispose();
                break;
            case EMPRESA_TRANSPORTADORA:
                try {
                    this.iniciarSesionEmpresaTransportista();
                } catch (NegocioException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
                this.dispose();
                break;
            case PRODUCTOR:
                try {
                this.iniciarSesionProductor();
            } catch (PresentacionException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            break;
            default:
                break;
        }

    }//GEN-LAST:event_iniciarSesionBtnActionPerformed

    /**
     * Alterna la visibilidad de la contraseña en el campo correspondiente según el estado del CheckBox.
     * Si el CheckBox está seleccionado, se muestra la contraseña sin ocultar.
     * Si el CheckBox no está seleccionado, se muestra la contraseña oculta.
     */
    private void alternarVisibilidadContrasena() {
        if (this.checkVisible.isSelected()) {
            this.campoContrasena.setEchoChar((char) 0);
        } else {
            this.campoContrasena.setEchoChar('•');
        }
    }
    /**
     * Verifica si el campo de usuario está vacío o contiene el valor predeterminado.
     * 
     * @return true si el campo de usuario está vacío o contiene el valor predeterminado, false de lo contrario.
     */
    private boolean verificarCampoUsuarioVacio() {
        return this.campoUsuario.getText().isEmpty() || this.campoUsuario.getText().equals(this.CORREO_DEFAULT);
    }

    /**
     * Cambia el color del panel de información y habilita/deshabilita el botón de iniciar sesión
     * según el tipo de login seleccionado.
     * 
     * @param tipoLogin El tipo de login seleccionado.
     */
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
    
    
/**
 * Consulta un productor usando el correo y la contraseña proporcionados.
 * 
 * @param correo     El correo del productor.
 * @param contrasena La contraseña del productor.
 * @return El objeto Productor consultado.
 * @throws PresentacionException Si ocurre un error durante la consulta del productor.
 */
    private Productor consultarProductor(String correo, String contrasena) throws PresentacionException {
        try {
            ProductorDTO productor = new ProductorDTO();
            productor.setEmail(correo);
            productor.setContrasena(contrasena);
            return negocio.loginProductor(productor);
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage());
        }
    }

    
/**
 * Consulta un productor usando el correo y la contraseña proporcionados.
 * 
 * @param correo     El correo del productor.
 * @param contrasena La contraseña del productor.
 * @return El objeto Productor consultado.
 * @throws PresentacionException Si ocurre un error durante la consulta del productor.
 */
    private void iniciarSesionProductor() throws PresentacionException {

        List<String> campoError = new LinkedList<>();

        String correo = "";

        if (verificarCampoUsuarioVacio()) {
            campoError.add("- Correo vacío");
        } else {
            correo = this.campoUsuario.getText();
        }

        String contrasena = "";

        if (verificarCampoContrasenaVacio()) {
            campoError.add("- Contraseña vacía");
        } else {
            contrasena = this.campoContrasena.getText();
        }

        if (!campoError.isEmpty()) {

            String mensaje = mensajeCampos(campoError);

            throw new PresentacionException(mensaje);

        }

        try {
            Productor productor = consultarProductor(correo, contrasena);

            if (productor == null) {
                throw new PresentacionException("No hay una cuenta con esos datos");
            }

            this.abrirPrincipalProductor(productor);
            this.cerrarVentana();
        } catch (PresentacionException a) {
            throw new PresentacionException(a.getMessage());
        }

    }

    /**
     * Cierra la ventana actual.
     */
    private void cerrarVentana() {
        this.setVisible(false);
    }
    /**
     * Abre la ventana principal del productor con el productor proporcionado.
     * 
     * @param productor El objeto Productor.
     */
    private void abrirPrincipalProductor(Productor productor) {
        PrincipalProductorForm principalProductorForm;

        principalProductorForm = PrincipalProductorForm.getInstance();

        principalProductorForm.setProductor(productor);
        principalProductorForm.iniciarComponentes();
    }
    /**
     * Inicia sesión como empresa transportista utilizando los campos de correo y contraseña ingresados.
     * Realiza validaciones y manejo de errores.
     * 
     * @throws PresentacionException Si ocurre un error durante el inicio de sesión de la empresa transportista.
     */
    private void iniciarSesionEmpresaTransportista() throws PresentacionException{

        List<String> campoError = new LinkedList<>();

        String correo = "";

        if(verificarCampoUsuarioVacio()){
            campoError.add("- Correo vacío");
        }else{
            correo = this.campoUsuario.getText();
        }

        String contrasena = "";

        if(verificarCampoContrasenaVacio()){
            campoError.add("- Contraseña vacía");
        }else{ 
            contrasena = this.campoContrasena.getText();
        }

        if (!campoError.isEmpty()) {

            String mensaje = mensajeCampos(campoError);

            throw new PresentacionException(mensaje);

        }

        try {
            EmpresaTransportista empresaTransportista = consultarEmpresaTransportista(correo, contrasena);

            if (empresaTransportista == null) {
                throw new PresentacionException("No hay una cuenta con esos datos");
            }

            this.abrirPrincipalEmpresaTransportista(empresaTransportista);
            
            this.cerrarVentana();
        } catch (PresentacionException a) {
            throw new PresentacionException(a.getMessage());
        }

    }
    /**
     * Consulta una empresa transportista usando el correo y la contraseña proporcionados.
     * 
     * @param correo     El correo de la empresa transportista.
     * @param contrasena La contraseña de la empresa transportista.
     * @return El objeto EmpresaTransportista consultado.
     * @throws PresentacionException Si ocurre un error durante la consulta de la empresa transportista.
     */
    private EmpresaTransportista consultarEmpresaTransportista(String correo, String contrasena) throws PresentacionException{
        try {
            return negocio.loginEmpresaTrasnportista(correo, contrasena);
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage());
        }
    }

    /**
     * Abre la ventana principal de la empresa transportista con la empresa transportista proporcionada.
     * 
     * @param empresaTransportista El objeto EmpresaTransportista.
     * @throws PresentacionException Si ocurre un error al abrir la ventana principal de la empresa transportista.
     */
    private void abrirPrincipalEmpresaTransportista(EmpresaTransportista empresaTransportista) throws PresentacionException{
        PrincipalEmpresaForm principalEmpresaForm;
        principalEmpresaForm = PrincipalEmpresaForm.getInstance();
        principalEmpresaForm.setEmpresa(empresaTransportista);
        principalEmpresaForm.iniciarComponentes();
    }
    /**
     * Inicia sesión como administrador utilizando los campos de correo y contraseña ingresados.
     * Realiza validaciones y manejo de errores.
     * 
     * @throws PresentacionException Si ocurre un error durante el inicio de sesión del administrador.
     */
    private void iniciarSesionAdministrador() throws PresentacionException{

        List<String> campoError = new LinkedList<>();

        String correo = "";

        if(verificarCampoUsuarioVacio()){
            campoError.add("- Correo vacío");
        }else{
            correo = this.campoUsuario.getText();
        }

        String contrasena = "";

        if(verificarCampoContrasenaVacio()){
            campoError.add("- Contraseña vacía");
        }else{ 
            contrasena = this.campoContrasena.getText();
        }

        if (!campoError.isEmpty()) {

            String mensaje = mensajeCampos(campoError);

            throw new PresentacionException(mensaje);

        }

        try {
            Administrador administrador = consultarAdministrador(correo, contrasena);

            if (administrador == null) {
                throw new PresentacionException("No hay una cuenta con esos datos");
            }

            this.abrirPrincipalAdministrador(administrador);
            this.cerrarVentana();
        } catch (PresentacionException a) {
            throw new PresentacionException(a.getMessage());
        }
    }
    /**
     * Consulta un administrador utilizando el correo y la contraseña proporcionados
     * 
     * @param correo     El correo del administrador.
     * @param contrasena La contraseña del administrador.
     * @return El objeto Administrador consultado.
     * @throws PresentacionException Si ocurre un error durante la consulta del administrador.
     */
    private Administrador consultarAdministrador(String correo, String contrasena) throws PresentacionException{
        try {
            return negocio.loginAdministrador(correo, contrasena);
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage());
        }
    }
    /**
     * Consulta un administrador utilizando el correo y la contraseña proporcionados.
     * 
     * @param correo     El correo del administrador.
     * @param contrasena La contraseña del administrador.
     * @return El objeto Administrador consultado.
     * @throws PresentacionException Si ocurre un error durante la consulta del administrador.
     */
    private void abrirPrincipalAdministrador(Administrador administrador) throws PresentacionException{
        PrincipalAdministradorForm principalAdministradorForm;
        principalAdministradorForm = PrincipalAdministradorForm.getInstance();
        principalAdministradorForm.setAdministrador(administrador);
        principalAdministradorForm.iniciarComponentes();
    }

    /**
     * Contatena todos los elementos de la lista de tipo String
     *
     * @param listaCampos Lista que quiere concatenar sus elementos
     * @return Cadena concatenada de la lista de elementos
     */
    private String mensajeCampos(List<String> listaCampos) {
        String mensaje = "";
        for (String campo : listaCampos) {
            mensaje += campo + "\n";
        }
        return mensaje;
    }

    /**
     * Verifica si el campo de contraseña está vacío o si contiene la contraseña predeterminada.
     * 
     * @return true si el campo de contraseña está vacío o contiene la contraseña predeterminada, false de lo contrario.
     */
    private boolean verificarCampoContrasenaVacio() {
        return this.campoContrasena.getText().isEmpty() || this.campoContrasena.getText().equals(this.CONTRASENA_DEFAULT);
    }
    /**
     * Obtiene una instancia de la clase LogInForm. Si no existe una instancia previa, crea una nueva y la devuelve.
     * 
     * @return Una instancia de la clase LogInForm.
     */
    public static LogInForm getInstance() {
        if (LogInForm.login == null) {
            LogInForm.login = new LogInForm();
        }
        return LogInForm.login;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Campo de contraseña
     */
    private javax.swing.JPasswordField campoContrasena;
    /**
     * Campo de usuario
     */
    private javax.swing.JTextField campoUsuario;
    /**
     * Check de visibilidad de contraseña
     */
    private javax.swing.JCheckBox checkVisible;
    /**
     * Combo Box de seleccionar el tipo de cuenta
     */
    private javax.swing.JComboBox<String> comboBoxOpcionLogin;
    /**
     * Label contraseña
     */
    private javax.swing.JLabel contrasenaLbl;
    /**
     * Botón iniciar sesión
     */
    private javax.swing.JButton iniciarSesionBtn;
    /**
     * Label iniciar sesión
     */
    private javax.swing.JLabel iniciarSesionComoLabel;
    /**
     * Panel fondo
     */
    private javax.swing.JPanel panelFondo;
    /**
     * Panel información
     */
    private javax.swing.JPanel panelInformacion;
    /**
     * Renglón de la contraseña
     */
    private javax.swing.JSeparator renglonContrasena;
    /**
     * Renglón del usuario
     */
    private javax.swing.JSeparator renglonUsuario;
    /**
     * Label usuario
     */
    private javax.swing.JLabel usuarioLbl;
    // End of variables declaration//GEN-END:variables

}
