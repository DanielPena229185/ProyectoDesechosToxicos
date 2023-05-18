package org.itson.presentacion.Administrador;

import com.dominio.Administrador;
import com.dominio.EmpresaTransportista;
import com.dominio.MedidaResiduo;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import com.dominio.Transporte;
import com.dominio.Traslado;
import org.itson.presentacion.empresa.SolictudTrasladoForm;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.itson.presentacion.InicioForm;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import org.itson.implementacion.FachadaNegocio;
import org.itson.interfaces.INegocio;
import org.itson.utils.ConfiguracionDePaginado;

/**
 * Descripción de la clase: Se encarga de hacer el proceso de registro de los
 * traslados
 *
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID:
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class RegistrarTrasladoForm extends javax.swing.JFrame {

    private INegocio negocio;
    private List<EmpresaTransportista> transportistas = null;
    private Residuo residuo;
    private Administrador administrador;
    private Solicitud solicitud;
    private int cantidadResiduos;
    private int contadorResiduosTrasladados = 0;

    /**
     * Creates new form RegistrarTrasladoForm
     */
    public RegistrarTrasladoForm(Solicitud solicitud, Administrador administrador) {
        negocio = new FachadaNegocio();
        this.administrador = administrador;
        this.solicitud = solicitud;
        this.cantidadResiduos = solicitud.getResiduos().size();
        initComponents();
        asignaValoresLabels(solicitud);
        llenadoTablaResiduos(solicitud);
        ejecucionLlenadoTablaTransportistas();

        this.setVisible(true);

    }

    private void llenadoTablaResiduos(Solicitud solicitud) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tableResiduos.getModel();
        modeloTabla.setRowCount(0);
        for (Residuo r : solicitud.getResiduos()) {
            Object[] fila = {r.getNombre(), r.getCantidad(), r.getMedida_residuo().toString()};
            modeloTabla.addRow(fila);

        }
    }

    private void asignaValoresLabels(Solicitud solicitud) {
        this.lblProductor.setText(solicitud.getProductor().getNombre());
        SimpleDateFormat formateado = new SimpleDateFormat("dd/MM/yyyy");
        this.lblFechaSol.setText(formateado.format(solicitud.getFecha_Solicitada().getTime()));
    }

    private List<EmpresaTransportista> consultaTransportistasDisponibles() {
        return negocio.consultaTodasEmpresasTransportistas();
    }

    private void llenarTablaTransportistas(List<EmpresaTransportista> transportistas) {

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tableTransportistas.getModel();
        modeloTabla.setRowCount(0);
        for (EmpresaTransportista t : transportistas) {
            Object[] fila = {t.getNombre()};
            modeloTabla.addRow(fila);
        }
    }

    private void ejecucionLlenadoTablaTransportistas() {
        List<EmpresaTransportista> transportistas = consultaTransportistasDisponibles();
        this.transportistas = transportistas;
        llenarTablaTransportistas(transportistas);
    }

    private EmpresaTransportista consultaEmpresaSeleccionada() {
        int filaSeleccionada = this.tableTransportistas.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) tableTransportistas.getModel();
        EmpresaTransportista empresa = new EmpresaTransportista();
        empresa.setNombre((String) this.tableTransportistas.getValueAt(filaSeleccionada, 0));
        this.tableTransportistas.removeRowSelectionInterval(filaSeleccionada, filaSeleccionada);
        modelo.removeRow(filaSeleccionada);
        ingresaTranportistaSeleccionadas(empresa);
        return empresa;

    }

    private EmpresaTransportista consultaEmpresaEliminarSeleccion() {
        int filaSeleccionada = this.tableTransportistasSeleccionados.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) tableTransportistasSeleccionados.getModel();
        EmpresaTransportista empresa = new EmpresaTransportista();
        empresa.setNombre((String) this.tableTransportistasSeleccionados.getValueAt(filaSeleccionada, 0));
        this.tableTransportistasSeleccionados.removeRowSelectionInterval(filaSeleccionada, filaSeleccionada);
        modelo.removeRow(filaSeleccionada);
        ingresaTranportistaRemovida(empresa);
        return empresa;

    }

    private void ingresaTranportistaSeleccionadas(EmpresaTransportista empresaTransportista) {
        DefaultTableModel modelo = (DefaultTableModel) tableTransportistasSeleccionados.getModel();
        Object[] fila = {empresaTransportista.getNombre()};
        modelo.addRow(fila);
    }

    private void ingresaTranportistaRemovida(EmpresaTransportista empresaTransportista) {
        DefaultTableModel modelo = (DefaultTableModel) tableTransportistas.getModel();
        Object[] fila = {empresaTransportista.getNombre()};
        modelo.addRow(fila);
    }

    private Residuo consultarResiduoSeleccionado() {
        int filaSeleccionada = this.tableResiduos.getSelectedRow();
        Residuo residuo = new Residuo();
        residuo.setNombre((String) this.tableResiduos.getValueAt(filaSeleccionada, 0));
        residuo.setCantidad((Float) this.tableResiduos.getValueAt(filaSeleccionada, 1));
        String medida = (String) this.tableResiduos.getValueAt(filaSeleccionada, 2);
        if (medida == "KILOGRAMO") {
            residuo.setMedida_residuo(MedidaResiduo.KILOGRAMO);
        } else {
            residuo.setMedida_residuo(MedidaResiduo.LITRO);
        }
        llenarLabelsResiduo(residuo);
        this.residuo = residuo;
        return residuo;
    }

    private void llenarLabelsResiduo(Residuo residuo) {
        this.lblResiduoSeleccionado.setText(residuo.getNombre());
        this.lblCuenta.setText(residuo.getCantidad().toString());
        this.lblMedicion.setText(residuo.getMedida_residuo().toString());
    }

    private List<String> consultarTablaSeleccionados() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < this.tableTransportistasSeleccionados.getRowCount(); i++) {
            lista.add((String) this.tableTransportistasSeleccionados.getValueAt(i, 0));
        }
        return lista;
    }

    private List<EmpresaTransportista> dejarTransportistasSeleccionados() {
        List<EmpresaTransportista> lista = new ArrayList<>();
        List<String> tabla = consultarTablaSeleccionados();
        for (EmpresaTransportista e : this.transportistas) {

            for (String i : tabla) {
                if (e.getNombre() == i) {
                    lista.add(e);
                    break;
                }
            }
        }
        List<EmpresaTransportista> trans = new ArrayList<>();
        for(EmpresaTransportista i : lista){
            EmpresaTransportista et = new EmpresaTransportista();
            et.setId(i.getId());
            et.setNombre(i.getNombre());
            trans.add(et);
        }
        
        return trans;
    }

    private Traslado creaTraslado() {
        int cant = this.tableTransportistasSeleccionados.getRowCount();
        System.out.println(cant);
        Float cantidadEquitativa = this.residuo.getCantidad() / cant;

        String nombre = this.residuo.getNombre();
        List<EmpresaTransportista> empresas = dejarTransportistasSeleccionados();
        System.out.println("Se seleccionaron # :" + empresas.size());
        if (empresas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Favor de seleccionar minimo una empresa transportista", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        Residuo residuo = new Residuo();
        Solicitud solicitud = this.solicitud;
        residuo.setNombre(nombre);
        residuo.setCantidad(cantidadEquitativa);
        residuo.setMedida_residuo(residuo.getMedida_residuo());
        solicitud.setResiduos(Arrays.asList(residuo));

        Traslado traslado = new Traslado();
        traslado.setResiduo(residuo);
        traslado.setAdministrador(administrador);
        traslado.setSolicitud(solicitud);
        traslado.setEmpresas_transportistas(empresas);

        return traslado;
    }

    private Traslado persistirTraslado() {
        if (!seSeleccionoResiduo()) {
            JOptionPane.showMessageDialog(this, "Favor de seleccionar un residuo de la lista de residuos", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Traslado traslado = creaTraslado();
        if (traslado == null) {
            return null;
        }
        traslado = negocio.insertarTraslado(traslado);
        if (traslado.getId() == null) {
            JOptionPane.showMessageDialog(this, "Hubo un error no se pudo asignar el traslado", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        JOptionPane.showMessageDialog(this, "Se asigno el traslado con exito", "Exiro", JOptionPane.INFORMATION_MESSAGE);

        return traslado;
    }

    private boolean seSeleccionoResiduo() {
        return residuo != null;
    }

    private void vaciarLabes() {
        this.lblResiduoSeleccionado.setText("...");
        this.lblMedicion.setText("...");
        this.lblCuenta.setText("...");
    }

    private void quitarResiduoTablaResiduos() {
        this.residuo = null;
        vaciarLabes();
        int filaSeleccionada = this.tableResiduos.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) tableResiduos.getModel();
        modelo.removeRow(filaSeleccionada);
        contadorResiduosTrasladados++;
    }

    private boolean tablaResiduosEstaVacia() {
        if (this.tableResiduos.getRowCount() == 0) {
            return true;
        }
        return false;
    }

    private void vaciarTablaEmpresasSeleccionadas() {
        DefaultTableModel modelo = (DefaultTableModel) this.tableTransportistasSeleccionados.getModel();
        modelo.setRowCount(0);
    }

    private void irPrincipalAdministradorForm() {
        PrincipalAdministradorForm principalAdministradorForm;
        principalAdministradorForm = PrincipalAdministradorForm.getInstance();
        principalAdministradorForm.setAdministrador(administrador);
        principalAdministradorForm.iniciarComponentes();
    }
    
    private void actualizarEstadoSolicitud(){
    negocio.actualizaEstadoASolicitudAtendida(solicitud);
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
        productorLbl = new javax.swing.JLabel();
        fechaLbl = new javax.swing.JLabel();
        registrarTrasladoLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTransportistas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTransportistasSeleccionados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAsignar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblProductor = new javax.swing.JLabel();
        lblFechaSol = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResiduos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblResiduoSeleccionado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCuenta = new javax.swing.JLabel();
        lblMedicion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        productorLbl.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        productorLbl.setText("Productor:");

        fechaLbl.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        fechaLbl.setText("Fecha Solicitada :");

        registrarTrasladoLbl.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 30)); // NOI18N
        registrarTrasladoLbl.setText("Solicitud Traslado");

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableTransportistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTransportistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTransportistasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableTransportistas);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 300, 180));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel1.setText("Empresas Transportistas  Disponibles:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        tableTransportistasSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTransportistasSeleccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTransportistasSeleccionadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableTransportistasSeleccionados);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 300, 170));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel2.setText("Empresas a las que se les ");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 230, -1));

        btnAsignar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        btnAsignar.setText("Asignar");
        btnAsignar.setContentAreaFilled(false);
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAsignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 527, 120, 40));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel5.setText("asignaras el Traslado:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.setEnabled(false);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 120, 40));

        lblMensaje.setBackground(new java.awt.Color(255, 255, 255));
        lblMensaje.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 140, 20));

        lblProductor.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblProductor.setText("...");

        lblFechaSol.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblFechaSol.setText("...");

        tableResiduos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Residuo", "Cantidad", "Medicion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableResiduos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableResiduosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableResiduos);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel3.setText("Residuo Seleccionado :");

        lblResiduoSeleccionado.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblResiduoSeleccionado.setText("...");

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel4.setText("Cantidad :");
        jLabel4.setToolTipText("");

        lblCuenta.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblCuenta.setText("...");

        lblMedicion.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblMedicion.setText("...");

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel6.setText("Selecciona un residuo :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(productorLbl)
                                .addComponent(registrarTrasladoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fechaLbl)
                                .addComponent(jSeparator2))
                            .addComponent(lblProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFechaSol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(lblResiduoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addComponent(lblMedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(registrarTrasladoLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productorLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProductor)
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFechaSol)
                .addGap(1, 1, 1)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResiduoSeleccionado)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCuenta)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblMedicion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        if (persistirTraslado() == null) {
            return;
        }
        vaciarTablaEmpresasSeleccionadas();
        ejecucionLlenadoTablaTransportistas();
        quitarResiduoTablaResiduos();
        tablaResiduosEstaVacia();
        if (tablaResiduosEstaVacia()) {
            this.btnSalir.setEnabled(true);
            this.btnAsignar.setEnabled(false);
            actualizarEstadoSolicitud();
            
        }
    }//GEN-LAST:event_btnAsignarActionPerformed

    private void tableResiduosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableResiduosMouseClicked
        // TODO add your handling code here:
        consultarResiduoSeleccionado();

    }//GEN-LAST:event_tableResiduosMouseClicked

    private void tableTransportistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTransportistasMouseClicked
        // TODO add your handling code here:
        consultaEmpresaSeleccionada();
    }//GEN-LAST:event_tableTransportistasMouseClicked

    private void tableTransportistasSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTransportistasSeleccionadosMouseClicked
        // TODO add your handling code here:
        consultaEmpresaEliminarSeleccion();

    }//GEN-LAST:event_tableTransportistasSeleccionadosMouseClicked

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        // TODO add your handling code here:
        if (!tablaResiduosEstaVacia()) {
            this.lblMensaje.setText("Aun hay residuos");

        }

    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        // TODO add your handling code here:

        this.lblMensaje.setText("");


    }//GEN-LAST:event_btnSalirMouseExited

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        irPrincipalAdministradorForm();
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new RegistrarTrasladoForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel fechaLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblFechaSol;
    private javax.swing.JLabel lblMedicion;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblProductor;
    private javax.swing.JLabel lblResiduoSeleccionado;
    private javax.swing.JLabel productorLbl;
    private javax.swing.JLabel registrarTrasladoLbl;
    private javax.swing.JTable tableResiduos;
    private javax.swing.JTable tableTransportistas;
    private javax.swing.JTable tableTransportistasSeleccionados;
    // End of variables declaration//GEN-END:variables

}
