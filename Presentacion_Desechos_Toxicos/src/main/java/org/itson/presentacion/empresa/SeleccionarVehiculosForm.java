package org.itson.presentacion.empresa;

import com.dominio.EmpresaTransportista;
import com.dominio.Transporte;
import com.dominio.Traslado;
import com.dominio.Vehiculo;
import com.github.lgooddatepicker.components.DatePicker;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.PresentacionException;
import org.itson.implementacion.FachadaNegocio;
import org.itson.interfaces.INegocio;

/**
 * Descripción de la clase:Selecciona el vehiculo para transportar
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID:
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class SeleccionarVehiculosForm extends javax.swing.JFrame {

    /**
     * Fachada del negocio
     */
    private final INegocio negocio;
    /**
     * Empresa con la que se inisio sesion
     */
    private EmpresaTransportista empresa;
    /**
     * Traslado que se utilizara
     */
    private Traslado traslado;
    /**
     * Instancia del formulario de SeleccionarVehiculos
     */
    private static SeleccionarVehiculosForm form;

    private List<Vehiculo> vehiculos;

    /**
     * Creates new form SeleccionarVehiculosForm
     */
    private SeleccionarVehiculosForm() {
        this.negocio = new FachadaNegocio();
        initComponents();
        this.setVisible(true);
    }

    /**
     * Devuelve una instancia única de SeleccionarVehiculosForm.
     *
     * @return La instancia única de SeleccionarVehiculosForm.
     */
    public static SeleccionarVehiculosForm getInstance() {
        if (form == null) {
            form = new SeleccionarVehiculosForm();
        }
        return form;
    }

    /**
     * Establece la empresa transportista.
     *
     * @param empresa La empresa transportista.
     */
    public void setEmpresaTransportista(EmpresaTransportista empresa) {
        this.empresa = empresa;
    }

    /**
     * Establece la empresa transportista.
     *
     * @param traslado traslado.
     */
    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
    }

    /**
     * Inicia los componentes de la ventana.
     */
    public void iniciarComponentes() {
        this.cargarTablaCajasVerificacion();
        this.lblNombreEmpresa.setText(this.empresa.getNombre());
        this.lblNombreResiduo.setText(this.traslado.getResiduo().getNombre());
        this.abrirVentana();
    }

    /**
     * Carga la lista de vehículos desde el negocio.
     *
     * @return La lista de vehículos.
     * @throws PresentacionException Si ocurre un error durante la consulta.
     */
    private List<Vehiculo> cargarListaVehiculos() throws PresentacionException {
        try {
            this.vehiculos = this.negocio.consultaVehiuculoEmpresaTrasnportadora(empresa);
            return this.vehiculos;
        } catch (NegocioException e) {
            throw new PresentacionException(e.getMessage());
        }
    }

    /**
     * Carga la tabla de cajas de verificación con los vehículos.
     */
    private void cargarTablaCajasVerificacion() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaVehiculos.getModel();
        modeloTabla.setNumRows(0);

        try {
            this.vehiculos = this.cargarListaVehiculos();

            for (Vehiculo vehiculo : this.vehiculos) {
                Object[] fila = {
                    vehiculo.getModelo() + ", " + vehiculo.getMarca()
                };

                modeloTabla.addRow(fila);
            }
        } catch (PresentacionException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    /**
     * Obtiene el vehículo seleccionado en la tabla.
     *
     * @return El vehículo seleccionado.
     */
    private Vehiculo obtenerVehiculoSeleccionado() {
        int filaSeleccionda = this.tablaVehiculos.getSelectedRow();

        return this.vehiculos.get(filaSeleccionda);
    }

    /**
     * Comprueba la selección de un vehículo en la tabla y actualiza los campos
     * correspondientes.
     */
    private void comprobarSeleccion() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaVehiculos.getModel();
        int filaSeleccionada = this.tablaVehiculos.getSelectedRow();

        // Obtenemos el valor actual del checkbox en la columna 1
        boolean seleccionActual = (boolean) modeloTabla.getValueAt(filaSeleccionada, 1);

        // Iteramos sobre todas las filas de la tabla
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            // Si la fila actual es diferente a la fila seleccionada
            if (i != filaSeleccionada) {
                // Deseleccionamos el checkbox en la columna 1
                modeloTabla.setValueAt(false, i, 1);
            }
        }

        // Actualizamos los campos con la selección actual
        this.actualizarCampos(seleccionActual);
    }

    private boolean comprobarTxtFieldVacio(JTextField e) throws PresentacionException {
        if (e.getText().isEmpty() || e.getText().isBlank()) {
            throw new PresentacionException("Error: campos de texto vacíos.");
        }

        return true;
    }

    private boolean comprobarTextAreaVacio(JTextArea e) throws PresentacionException {
        if (e.getText().isEmpty() || e.getText().isBlank()) {
            throw new PresentacionException("Error: Cuadro de texto vacío.");
        }

        return true;
    }

    private boolean comprobarFechaSeleccionad(DatePicker e) throws PresentacionException {
        if (e.getDate() == null) {
            throw new PresentacionException("Error: No hay ninguna fecha seleccionada.");
        }

        return true;
    }

    private boolean fechaValida(LocalDate fecha) throws PresentacionException {
        LocalDate fechaActual = LocalDate.now();

        if (fecha.isAfter(fechaActual)) {
            throw new PresentacionException("Error: Ingrese una fecha igual o menor a la de hoy.");
        }

        return true;
    }

    private boolean validarKilometraje(JTextField e) throws PresentacionException {
        if (Float.parseFloat(e.getText()) < 1000) {
            throw new PresentacionException("Error: Ingrese valores mayores a 1000 en el kilometraje.");
        }

        return true;
    }

    private boolean validarCostos(JTextField e) throws PresentacionException {
        if (Float.parseFloat(e.getText()) <= 0) {
            throw new PresentacionException("Error: Ingrese valores mayores a 0 en el costo..");
        }

        return true;
    }

    private boolean comprobarTodosLosCampos() throws PresentacionException {
        try {
            return this.comprobarTxtFieldVacio(this.txtKilometrosRecorridos)
                    && this.comprobarTxtFieldVacio(this.txtCosto)
                    && this.comprobarTextAreaVacio(this.textAreaTratamiento)
                    && this.comprobarFechaSeleccionad(this.datePickerFechaLlegada)
                    && this.fechaValida(this.datePickerFechaLlegada.getDate())
                    && this.validarKilometraje(this.txtKilometrosRecorridos)
                    && this.validarCostos(this.txtCosto);
        } catch (PresentacionException e) {
            throw new PresentacionException(e.getLocalizedMessage());
        }
    }

    private Transporte obtenerDatosTransporte() throws PresentacionException {
        Transporte transporte = new Transporte();

        try {
            if (this.comprobarTodosLosCampos()) {
                transporte.setKilometros(Float.parseFloat(this.txtKilometrosRecorridos.getText()));
                transporte.setCoste(Float.parseFloat(this.txtCosto.getText()));
                transporte.setVehiculos(Arrays.asList(this.obtenerVehiculoSeleccionado()));
                transporte.setEmpresa_transportista(empresa);

                return transporte;
            }
        } catch (PresentacionException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    private void guardarTransporte() throws PresentacionException {
        try {
            Transporte transporte = this.obtenerDatosTransporte();
            this.negocio.insertarTransporte(transporte);
            JOptionPane.showMessageDialog(this, "Se insertó correctamente el transporte.", "¡ÉXITO!", JOptionPane.OK_OPTION);
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Actualiza el estado de los campos en la interfaz gráfica.
     *
     * @param x true si los campos deben estar habilitados, false si deben estar
     * deshabilitados.
     */
    private void actualizarCampos(boolean x) {
        this.txtKilometrosRecorridos.setEnabled(x);
        this.txtCosto.setEnabled(x);
        this.datePickerFechaLlegada.setEnabled(x);
        this.textAreaTratamiento.setEnabled(x);
        this.btnRegistrar.setEnabled(x);
    }

    /**
     * Abre la ventana actual y la hace visible.
     */
    private void abrirVentana() {
        this.setVisible(true);
    }

    private void volverALaPantallaAnterior() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblKilometrosRecorridos = new javax.swing.JLabel();
        txtKilometrosRecorridos = new javax.swing.JTextField();
        lblCosto = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        lblFechaLlegada = new javax.swing.JLabel();
        datePickerFechaLlegada = new com.github.lgooddatepicker.components.DatePicker();
        lblTratamiento = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaTratamiento = new javax.swing.JTextArea();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNombreEmpresa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNombreResiduo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seleccionar vehículos");
        setResizable(false);

        tablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehículo", "Selección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVehiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVehiculos);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblKilometrosRecorridos.setText("Kilómetros recorridos:");

        txtKilometrosRecorridos.setEnabled(false);
        txtKilometrosRecorridos.setNextFocusableComponent(lblKilometrosRecorridos);
        txtKilometrosRecorridos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKilometrosRecorridosKeyTyped(evt);
            }
        });

        lblCosto.setText("Costo:");

        txtCosto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCosto.setEnabled(false);
        txtCosto.setNextFocusableComponent(lblCosto);
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });

        lblFechaLlegada.setText("Fecha de llegada:");

        datePickerFechaLlegada.setEnabled(false);

        lblTratamiento.setText("Tratamiento:");

        textAreaTratamiento.setColumns(20);
        textAreaTratamiento.setRows(5);
        textAreaTratamiento.setEnabled(false);
        jScrollPane2.setViewportView(textAreaTratamiento);

        btnRegistrar.setText("Registrar");
        btnRegistrar.setEnabled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblKilometrosRecorridos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKilometrosRecorridos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCosto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCosto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFechaLlegada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datePickerFechaLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTratamiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRegistrar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKilometrosRecorridos)
                    .addComponent(txtKilometrosRecorridos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCosto)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaLlegada)
                    .addComponent(datePickerFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTratamiento)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addContainerGap())
        );

        jLabel1.setText("Empresa transportista:");

        jLabel2.setText("Residuo: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(lblNombreEmpresa))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(lblNombreResiduo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNombreEmpresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNombreResiduo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Registrar".
     * Obtiene el vehículo seleccionado y realiza alguna acción.
     *
     * @param evt El evento de acción.
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        this.guardarTransporte();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tablaVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVehiculosMouseClicked
        this.comprobarSeleccion();
    }//GEN-LAST:event_tablaVehiculosMouseClicked

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume(); // Ignora el carácter no numérico
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtKilometrosRecorridosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKilometrosRecorridosKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume(); // Ignora el carácter no numérico
        }
    }//GEN-LAST:event_txtKilometrosRecorridosKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private com.github.lgooddatepicker.components.DatePicker datePickerFechaLlegada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblFechaLlegada;
    private javax.swing.JLabel lblKilometrosRecorridos;
    private javax.swing.JLabel lblNombreEmpresa;
    private javax.swing.JLabel lblNombreResiduo;
    private javax.swing.JLabel lblTratamiento;
    private javax.swing.JTable tablaVehiculos;
    private javax.swing.JTextArea textAreaTratamiento;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtKilometrosRecorridos;
    // End of variables declaration//GEN-END:variables
}
