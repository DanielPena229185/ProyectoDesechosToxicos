package org.itson.presentacion.Productor;

import com.dominio.Estado;
import com.dominio.MedidaResiduo;
import com.dominio.Productor;
import java.util.List;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import com.github.lgooddatepicker.components.DatePicker;
import static java.awt.image.ImageObserver.ERROR;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itson.excepciones.NegocioException;
import org.itson.excepciones.PresentacionException;
import org.itson.implementacion.FachadaNegocio;
import org.itson.interfaces.INegocio;
import org.itson.utils.ConfiguracionDePaginado;

/**
 * DescripciÃ³n de la clase: Residuo de traslados
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID:
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando PeÃ±a Garcia ID:229185
 */
public class SolicitarTrasladoForm extends javax.swing.JFrame {

    /**
     * La lista de los residuos no seleccinados
     */
    List<Residuo> residuosNoSeleccionados = new LinkedList<>();
    /**
     * Lista de los residuos seleccionados
     */
    List<Residuo> residuoSeleccionados = new LinkedList<>();
    /**
     * Productor con el que se esta haciendo las operaciones
     */
    private Productor productor;
    /**
     * Fachada del negocio
     */
    private INegocio negocio;
    /**
     * Consfiguracion de paginado de los no seleccionados
     */
    private ConfiguracionDePaginado configPaginadoTblNoSeleccionados;
    /**
     * Configuracion de paginado de los seleccionados
     */
    private ConfiguracionDePaginado configPaginadoTblSeleccionados;

    /**
     * Instancia del formulario de solicitar traslado
     */
    private static SolicitarTrasladoForm solicitarTrasladoForm;

    /**
     * Creates new form SolicitarTrasladoForm
     */
    private SolicitarTrasladoForm() {
        negocio = new FachadaNegocio();
        initComponents();

    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    private List<Residuo> consultaResiduos() throws PresentacionException {
        try {
            Residuo residuoFiltro = new Residuo();
            residuoFiltro.setProductor(productor);
            List<Residuo> residuos = negocio.consultarResiduosFiltro(residuoFiltro);
            return residuos;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new PresentacionException("No hay ningÃºn residuo seleccionado");
        }
    }

    private Residuo consultarFilaTblNoSeleccionados() {
        try {
            int seleccionado = this.tblResiduosNoSeleccionados.getSelectedRow();
            Residuo residuo = (Residuo) this.tblResiduosNoSeleccionados.getValueAt(seleccionado, 0);
            return residuo;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new PresentacionException("No hay ningÃºn residuo seleccionado");
        }
    }

    private Residuo consultarFilaTblSeleccionados() {
        try {
            int seleccionado = this.tblResiduosSeleccionados.getSelectedRow();
            Residuo residuo = (Residuo) this.tblResiduosSeleccionados.getValueAt(seleccionado, 0);
            return residuo;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new PresentacionException("No hay ningÃºn residuo seleccionado");
        }
    }

    private List<Residuo> agregarResiduoListaSeleccionado(Residuo residuo) {
        residuoSeleccionados.add(residuo);
        return residuoSeleccionados;
    }

    private List<Residuo> eliminarResiduoListaSeleccionado(Residuo residuo) {
        residuoSeleccionados.remove(residuo);
        return residuoSeleccionados;
    }

    private List<Residuo> eliminarResiduoListaNoSeleccionados(Residuo residuo) {
        residuosNoSeleccionados.remove(residuo);
        return residuosNoSeleccionados;
    }

    private List<Residuo> agregarResiduoListaNoSeleccionados(Residuo residuo) {
        residuosNoSeleccionados.add(residuo);
        return residuosNoSeleccionados;
    }

    public void iniciarComponentes() {
        configPaginadoTblNoSeleccionados = new ConfiguracionDePaginado(0, 10);
        configPaginadoTblSeleccionados = new ConfiguracionDePaginado(0, 10);
        this.residuosNoSeleccionados = consultaResiduos();
        this.ejecucionLlenadoTblNoSeleccionados(residuosNoSeleccionados);
        this.ejecucionLlenadoTblSeleccionados(residuoSeleccionados);
        this.ocultarElementosResiduo();
        this.abrirVentana();
    }

    private void abrirVentana() {
        this.setVisible(true);
    }

    private void avanzarPaginaTblNoSeleccionados() {
        this.configPaginadoTblNoSeleccionados.avanzarPagina();
        ejecucionLlenadoTblNoSeleccionados(residuosNoSeleccionados);
    }

    private void retrocederPaginaTblNoSeleccionados() {
        this.configPaginadoTblNoSeleccionados.retrocederPagina();
        ejecucionLlenadoTblNoSeleccionados(residuosNoSeleccionados);
    }

    private void retrocederPaginaTblSeleccionados() {
        this.configPaginadoTblSeleccionados.retrocederPagina();
        ejecucionLlenadoTblSeleccionados(residuoSeleccionados);
    }

    private void avanzarPaginaTblSeleccionados() {
        this.configPaginadoTblSeleccionados.avanzarPagina();
        ejecucionLlenadoTblSeleccionados(residuoSeleccionados);
    }

    private void cerrarVentana() {
        this.setVisible(false);
    }

    private void llenadoTablaResiduosNoSeleccionados(List<Residuo> residuos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblResiduosNoSeleccionados.getModel();
        modeloTabla.setRowCount(0);
        for (Residuo r : residuos) {
            Residuo[] fila = {r};
            modeloTabla.addRow(fila);

        }
    }

    private void llenadoTablaResiduosSeleccionados(List<Residuo> residuos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblResiduosSeleccionados.getModel();
        modeloTabla.setRowCount(0);
        for (Residuo r : residuos) {
            Residuo[] fila = {r};
            modeloTabla.addRow(fila);

        }
    }

    private boolean validarNumeroNegativos() {
        String cantidadString = formatCantidadResiduo.getText();

        if (cantidadString == null || cantidadString.isBlank()) {
            throw new PresentacionException("No hay cantidad especificada");
        }

        float cantidad = Float.valueOf(cantidadString);

        return cantidad < 0;
    }

    private List<Residuo> consultaResiduoConConfiguracionTabla(ConfiguracionDePaginado configuracionPaginado, List<Residuo> residuos) {
        int offset = configuracionPaginado.getElementoASaltar();
        int limit = configuracionPaginado.getElementosPorPagina();
        List<Residuo> lista = new ArrayList<>();
        Iterator<Residuo> iterador = residuos.iterator();
        int cont = 0;
        int l = 0;
        while (iterador.hasNext()) {
            if (cont != offset) {
                cont++;
                iterador.next();
                continue;
            }
            if (l == limit) {
                break;
            }
            lista.add(iterador.next());
            l++;
        }
        return lista;
    }


    private Date obetenerFecha() {
        LocalDate fecha = this.fecha.getDate();
        Date fechaResiduo = new Date(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth());
        return fechaResiduo;
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
        fecha = new com.github.lgooddatepicker.components.DatePicker();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResiduosNoSeleccionados = new javax.swing.JTable();
        btnAdelanteTblResiduosNoSeleccionado = new javax.swing.JButton();
        btnAtrasTblResiduosNoSeleccionado = new javax.swing.JButton();
        btnAgregarResiduoSeleccionado = new javax.swing.JButton();
        lblCantidad = new javax.swing.JLabel();
        cbxUnidadMedidaResiduo = new javax.swing.JComboBox<>();
        lblUnidadMedida = new javax.swing.JLabel();
        formatCantidadResiduo = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        solicitarBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResiduosSeleccionados = new javax.swing.JTable();
        btnEliminarResiduoSeleccionado = new javax.swing.JButton();
        btnAdelanteTblResiduosSeleccionados = new javax.swing.JButton();
        btnAtrasTblResiduoSeleccionado = new javax.swing.JButton();
        btnSolicitar = new javax.swing.JButton();

        setTitle("Solicitar traslado");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel2.setText("Seleccione fecha");
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel3.setText("Selecciones Residuo");
        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel1.setText("Solicitar Traslado");
        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 30)); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        tblResiduosNoSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Residuo [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Residuo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResiduosNoSeleccionados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblResiduosNoSeleccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResiduosNoSeleccionadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResiduosNoSeleccionados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 310, 190));

        btnAdelanteTblResiduosNoSeleccionado.setText(">");
        btnAdelanteTblResiduosNoSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdelanteTblResiduosNoSeleccionadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdelanteTblResiduosNoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 420, 50, -1));

        btnAtrasTblResiduosNoSeleccionado.setText("<");
        btnAtrasTblResiduosNoSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasTblResiduosNoSeleccionadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtrasTblResiduosNoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 50, -1));

        btnAgregarResiduoSeleccionado.setText("Agregar");
        btnAgregarResiduoSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarResiduoSeleccionadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarResiduoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        lblCantidad.setText("Cantidad");
        jPanel1.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        cbxUnidadMedidaResiduo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LITRO", "KILOGRAMO" }));
        jPanel1.add(cbxUnidadMedidaResiduo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 140, -1));

        lblUnidadMedida.setText("Unidad de medida");
        jPanel1.add(lblUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, -1, -1));

        formatCantidadResiduo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jPanel1.add(formatCantidadResiduo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 610));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel4.setText("Residuos seleccionados");
        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N

        solicitarBtn.setText("Solicitar");
        solicitarBtn.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        solicitarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitarBtnActionPerformed(evt);
            }
        });

        tblResiduosSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Residuo [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Residuo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResiduosSeleccionados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jScrollPane2.setViewportView(tblResiduosSeleccionados);

        btnEliminarResiduoSeleccionado.setText("Eliminar");
        btnEliminarResiduoSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarResiduoSeleccionadoActionPerformed(evt);
            }
        });

        btnAdelanteTblResiduosSeleccionados.setText(">");
        btnAdelanteTblResiduosSeleccionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdelanteTblResiduosSeleccionadosActionPerformed(evt);
            }
        });

        btnAtrasTblResiduoSeleccionado.setText("<");
        btnAtrasTblResiduoSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasTblResiduoSeleccionadoActionPerformed(evt);
            }
        });

        btnSolicitar.setText("Solicitar");
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(493, 493, 493)
                .addComponent(solicitarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSolicitar)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnEliminarResiduoSeleccionado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAtrasTblResiduoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdelanteTblResiduosSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarResiduoSeleccionado)
                    .addComponent(btnAdelanteTblResiduosSeleccionados)
                    .addComponent(btnAtrasTblResiduoSeleccionado))
                .addGap(109, 109, 109)
                .addComponent(solicitarBtn)
                .addGap(1, 1, 1)
                .addComponent(btnSolicitar)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 360, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void solicitarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitarBtnActionPerformed
        int i = 0;
        if (!validarCampoTextoVacio()) {
            JOptionPane.showMessageDialog(this, "Fecha vacia", "Error", JOptionPane.ERROR_MESSAGE);
            i++;
        } else {
            List<String> camposVacios = this.validarCampoVacio();
            if (!camposVacios.isEmpty()) {
                String mensaje = "Los siguientes campos se encuentran vacÃ­os \n";
                for (String campos : camposVacios) {
                    mensaje += campos + "\n";
                }
                JOptionPane.showMessageDialog(this, mensaje, "No se puede solicitar traslado", JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }
        if (i == 0) {

            JOptionPane.showMessageDialog(this, "Traslado Exitoso", "", JOptionPane.INFORMATION_MESSAGE);
        }

        dispose();
    }//GEN-LAST:event_solicitarBtnActionPerformed

    public static SolicitarTrasladoForm getInstance() {
        if (solicitarTrasladoForm == null) {
            solicitarTrasladoForm = new SolicitarTrasladoForm();
        }
        return solicitarTrasladoForm;
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        abrirPrincipalProductor(productor);
        reiniciarFormulario();
        cerrarVentana();
    }//GEN-LAST:event_btnRegresarActionPerformed

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

    private void btnAdelanteTblResiduosNoSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdelanteTblResiduosNoSeleccionadoActionPerformed
        this.avanzarPaginaTblNoSeleccionados();
    }//GEN-LAST:event_btnAdelanteTblResiduosNoSeleccionadoActionPerformed

    private void btnAtrasTblResiduosNoSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasTblResiduosNoSeleccionadoActionPerformed
        this.retrocederPaginaTblNoSeleccionados();
    }//GEN-LAST:event_btnAtrasTblResiduosNoSeleccionadoActionPerformed

    private void btnEliminarResiduoSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarResiduoSeleccionadoActionPerformed
        try {
            Residuo residuo = consultarFilaTblSeleccionados();
            limpiarResiduo(residuo);
            eliminarResiduoListaResiduosSeleccionados(residuo);
            agregarResiduoListaResiduosNoSeleccionados(residuo);
        } catch (PresentacionException e) {
            JOptionPane.showMessageDialog(this, "No hay ningÃºn residuo seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarResiduoSeleccionadoActionPerformed


    private void btnAgregarResiduoSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarResiduoSeleccionadoActionPerformed
        try {
            Residuo residuo = consultarFilaTblNoSeleccionados();
            if (validarNumeroNegativos()) {
                throw new PresentacionException("La cantidad no puede ser negativa");
            }
            asignarAtributosResiduo(residuo);
            agregarResiduoListaResiduosSeleccionados(residuo);
            eliminarResiduoListaResiduosNoSeleccionados(residuo);
            this.ocultarElementosResiduo();
            this.limpiarCamposResiduo();
        } catch (PresentacionException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarResiduoSeleccionadoActionPerformed

    private void btnAtrasTblResiduoSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasTblResiduoSeleccionadoActionPerformed
        retrocederPaginaTblSeleccionados();
    }//GEN-LAST:event_btnAtrasTblResiduoSeleccionadoActionPerformed

    private void btnAdelanteTblResiduosSeleccionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdelanteTblResiduosSeleccionadosActionPerformed
        avanzarPaginaTblSeleccionados();
    }//GEN-LAST:event_btnAdelanteTblResiduosSeleccionadosActionPerformed

    private void tblResiduosNoSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResiduosNoSeleccionadosMouseClicked
        try {
            Residuo residuo = consultarFilaTblNoSeleccionados();
            if (residuo != null) {
                this.mostrarElementosResiduo();
            } else {
                this.ocultarElementosResiduo();
            }
        } catch (PresentacionException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblResiduosNoSeleccionadosMouseClicked

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        solicitarTraslado();
    }//GEN-LAST:event_btnSolicitarActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        iniciarPantallaPrincipalForm();
        reiniciarFormulario();
    }//GEN-LAST:event_formComponentHidden

    private void reiniciarFormulario() {
        this.fecha.setText("");
        this.residuoSeleccionados.clear();
        limpiarCamposResiduo();
    }

    private void iniciarPantallaPrincipalForm() {
        PrincipalProductorForm principalProductorForm;
        principalProductorForm = PrincipalProductorForm.getInstance();
        principalProductorForm.setProductor(productor);
        principalProductorForm.iniciarComponentes();
    }

    private Residuo limpiarResiduo(Residuo residuo) {
        residuo.setCantidad(null);
        residuo.setMedida_residuo(null);
        return residuo;
    }

    private void agregarResiduoListaResiduosSeleccionados(Residuo residuo) {
        agregarResiduoListaSeleccionado(residuo);
        llenadoTablaResiduosSeleccionados(residuoSeleccionados);
        ejecucionLlenadoTblSeleccionados(residuoSeleccionados);
    }

    private void eliminarResiduoListaResiduosSeleccionados(Residuo residuo) {
        eliminarResiduoListaSeleccionado(residuo);
        llenadoTablaResiduosSeleccionados(residuoSeleccionados);
        ejecucionLlenadoTblSeleccionados(residuoSeleccionados);
    }

    private void agregarResiduoListaResiduosNoSeleccionados(Residuo residuo) {
        agregarResiduoListaNoSeleccionados(residuo);
        llenadoTablaResiduosNoSeleccionados(residuosNoSeleccionados);
        ejecucionLlenadoTblNoSeleccionados(residuosNoSeleccionados);
    }

    private void eliminarResiduoListaResiduosNoSeleccionados(Residuo residuo) {
        eliminarResiduoListaNoSeleccionados(residuo);
        llenadoTablaResiduosNoSeleccionados(residuosNoSeleccionados);
        ejecucionLlenadoTblNoSeleccionados(residuosNoSeleccionados);
    }

    private List<Residuo> ejecucionLlenadoTblNoSeleccionados(List<Residuo> residuos) {
        residuos = consultaResiduoConConfiguracionTabla(configPaginadoTblNoSeleccionados, residuos);
        llenadoTablaResiduosNoSeleccionados(residuos);
        return residuos;
    }

    private List<Residuo> ejecucionLlenadoTblSeleccionados(List<Residuo> residuos) {
        residuos = consultaResiduoConConfiguracionTabla(configPaginadoTblSeleccionados, residuos);
        llenadoTablaResiduosSeleccionados(residuos);
        return residuos;
    }

    private boolean validarCampoTextoVacio() {
        return fecha.getText().isEmpty() || fecha.getText().equals(ERROR);
    }

    private void limpiarCamposResiduo() {
        this.formatCantidadResiduo.setText("");
        this.cbxUnidadMedidaResiduo.setSelectedIndex(0);
    }

    private void ocultarElementosResiduo() {
        this.lblCantidad.setVisible(false);
        this.lblUnidadMedida.setVisible(false);
        this.cbxUnidadMedidaResiduo.setVisible(false);
        this.formatCantidadResiduo.setVisible(false);
    }

    private void mostrarElementosResiduo() {
        this.lblCantidad.setVisible(true);
        this.lblUnidadMedida.setVisible(true);
        this.cbxUnidadMedidaResiduo.setVisible(true);
        this.formatCantidadResiduo.setVisible(true);
    }

    private Residuo asignarAtributosResiduo(Residuo residuo) throws PresentacionException {

        String cantidadString = formatCantidadResiduo.getText();

        if (cantidadString == null || cantidadString.isBlank()) {
            throw new PresentacionException("No hay cantidad especificada");
        }

        float cantidad = Float.valueOf(cantidadString);

        String unidad_medida = cbxUnidadMedidaResiduo.getSelectedItem().toString();

        residuo.setCantidad(cantidad);

        if (unidad_medida == "LITRO") {
            residuo.setMedida_residuo(MedidaResiduo.LITRO);
        } else if (unidad_medida == "KILOGRAMO") {
            residuo.setMedida_residuo(MedidaResiduo.KILOGRAMO);
        }
        return residuo;
    }

    private Residuo realizarParticionResiduo(Residuo residuo) {
        residuo.setProductor(null);
        residuo.setQuimicos(null);
        return residuo;
    }

    private Solicitud realizarParticionSolicitud(Solicitud solicitud) {
        //Particionar productor
        Productor productorParticionado = solicitud.getProductor();
        productorParticionado.setCuenta(null);
        productorParticionado.setDirecciones(null);
        productorParticionado.setResiduos(null);
        productorParticionado.setTipo(null);
        productorParticionado.setSolicitudes(null);

        //Particionar lista de residuos
        List<Residuo> residuos = solicitud.getResiduos();

        for (Residuo residuo : residuos) {
            realizarParticionResiduo(residuo);
        }

        solicitud.setProductor(productorParticionado);
        solicitud.setResiduos(residuos);

        return solicitud;
    }

    private List<String> validarCampoVacio() {
        List<String> campos = new ArrayList<>();
        if (this.validarCampoTextoVacio()) {
            campos.add("- Fecha");
        }
        return campos;
    }

    private Date obtenerFecha() throws PresentacionException {
        LocalDate localDate = fecha.getDate(); // Obtener LocalDate

        if (localDate == null) {
            throw new PresentacionException("No hay una fecha especificada");
        }

        // Convertir LocalDate a Date
        Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Crear una instancia de Calendar y establecer la fecha
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        // Establecer la hora, minutos y segundos en 0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        // Obtener la fecha modificada
        Date fechaModificada = calendar.getTime();

        return fecha;
    }

    private Solicitud crearSolicitud() {
        Solicitud solicitud = new Solicitud();
        solicitud.setProductor(productor);
        solicitud.setResiduos(residuoSeleccionados);
        solicitud.setFecha_Solicitada(obtenerFecha());
        solicitud.setEstado(Estado.NO_ATENDIDA);
        realizarParticionSolicitud(solicitud);
        return solicitud;
    }

    private void solicitarTraslado() {
        try {
            Solicitud solicitud = crearSolicitud();
            negocio.insertarSolicitud(solicitud);
            if (solicitud.getId() != null) {
                JOptionPane.showMessageDialog(this, "Solicitud con éxito", "Registrar solicitud", JOptionPane.INFORMATION_MESSAGE);
                cerrarVentana();
            }
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (PresentacionException a) {
            JOptionPane.showMessageDialog(this, a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * @param args the command line arguments //
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SolicitarTrasladoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SolicitarTrasladoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SolicitarTrasladoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SolicitarTrasladoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new SolicitarTrasladoForm().setVisible(true);
//            }
//        });


    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Botón adelante tabla residuos no seleccionados
     */
    private javax.swing.JButton btnAdelanteTblResiduosNoSeleccionado;
    /**
     * Botón adelante tabla residuos seleccionados
     */
    private javax.swing.JButton btnAdelanteTblResiduosSeleccionados;
    /**
     * Botón agregar residuo seleccionado
     */
    private javax.swing.JButton btnAgregarResiduoSeleccionado;
    /**
     * Botón atras residuos seleccionados
     */
    private javax.swing.JButton btnAtrasTblResiduoSeleccionado;
    /**
     * Botón atras residuos no seleccionados
     */
    private javax.swing.JButton btnAtrasTblResiduosNoSeleccionado;
    /**
     * Botón eliminar residuos seleccionados
     */
    private javax.swing.JButton btnEliminarResiduoSeleccionado;
    /**
     * Botón regresar
     */
    private javax.swing.JButton btnRegresar;
    /**
     * Botón solicitar
     */
    private javax.swing.JButton btnSolicitar;
    /**
     * ComboBox Unidad de medida
     */
    private javax.swing.JComboBox<String> cbxUnidadMedidaResiduo;
    /**
     * Date picker
     */
    private com.github.lgooddatepicker.components.DatePicker fecha;
    /**
     * Formato de cantidad del residuo
     */
    private javax.swing.JFormattedTextField formatCantidadResiduo;
    /**
     * Label 1
     */
    private javax.swing.JLabel jLabel1;
    /**
     * Label 1
     */
    private javax.swing.JLabel jLabel2;
    /**
     * Label 1
     */
    private javax.swing.JLabel jLabel3;
    /**
     * Label 1
     */
    private javax.swing.JLabel jLabel4;
    /**
     * Label 1
     */
    private javax.swing.JPanel jPanel1;
    /**
     * Label 1
     */
    private javax.swing.JPanel jPanel2;
    /**
     * Scroll pane 1
     */
    private javax.swing.JScrollPane jScrollPane1;
    /**
     * Scroll pane 1
     */
    private javax.swing.JScrollPane jScrollPane2;
    /**
     * Label cantidad
     */
    private javax.swing.JLabel lblCantidad;
    /**
     * Label unidad medida
     */
    private javax.swing.JLabel lblUnidadMedida;
    /**
     * Botón solicitar
     */
    private javax.swing.JButton solicitarBtn;
    /**
     * Tabla residuo no seleccionados
     */
    private javax.swing.JTable tblResiduosNoSeleccionados;
    /**
     * Tabla residuos seleccionados
     */
    private javax.swing.JTable tblResiduosSeleccionados;
    // End of variables declaration//GEN-END:variables

}
