
package org.itson.presentacion.empresa;

import com.dominio.EmpresaTransportista;
import com.dominio.Traslado;
import com.dominio.Vehiculo;
import java.util.List;
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

    private final INegocio negocio;
    private EmpresaTransportista empresa;
    private Traslado traslado;
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
    public static SeleccionarVehiculosForm getInstance(){
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
     * @param empresa La empresa transportista.
     */
    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
    }
     /**
     * Inicia los componentes de la ventana.
     */       
    public void iniciarComponentes() {
        this.cargarTablaCajasVerificacion();
        this.abrirVentana();
        System.out.println(this.traslado);
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
 * Comprueba la selección de un vehículo en la tabla y actualiza los campos correspondientes.
 */
    private void comprobarSeleccion() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaVehiculos.getModel();
        int filaSeleccionda = this.tablaVehiculos.getSelectedRow();
        boolean seleccion = (boolean) modeloTabla.getValueAt(filaSeleccionda, 1);
        
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            if (seleccion) {
                continue;
            }
            
            modeloTabla.setValueAt(false, i, 1);
        }
        
        this.actualizarCampos(seleccion);
    }
 /**
 * Actualiza el estado de los campos en la interfaz gráfica.
 * @param x true si los campos deben estar habilitados, false si deben estar deshabilitados.
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

        lblCosto.setText("Costo:");

        txtCosto.setEnabled(false);

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistrar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblFechaLlegada)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(datePickerFechaLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblTratamiento)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
 * Método que se ejecuta cuando se hace clic en la tabla de vehículos.
 * Comprueba la selección de un vehículo en la tabla y actualiza los campos correspondientes.
 * @param evt El evento de clic del mouse.
 */
    private void tablaVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVehiculosMouseClicked
        this.comprobarSeleccion();
    }//GEN-LAST:event_tablaVehiculosMouseClicked
/**
 * Método que se ejecuta cuando se hace clic en el botón "Registrar".
 * Obtiene el vehículo seleccionado y realiza alguna acción.
 * @param evt El evento de acción.
 */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        this.obtenerVehiculoSeleccionado();
    }//GEN-LAST:event_btnRegistrarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private com.github.lgooddatepicker.components.DatePicker datePickerFechaLlegada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblFechaLlegada;
    private javax.swing.JLabel lblKilometrosRecorridos;
    private javax.swing.JLabel lblTratamiento;
    private javax.swing.JTable tablaVehiculos;
    private javax.swing.JTextArea textAreaTratamiento;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtKilometrosRecorridos;
    // End of variables declaration//GEN-END:variables
}
