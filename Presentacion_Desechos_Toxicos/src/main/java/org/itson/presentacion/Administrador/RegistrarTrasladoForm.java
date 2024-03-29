package org.itson.presentacion.Administrador;

import com.dominio.Administrador;
import com.dominio.EmpresaTransportista;
import com.dominio.MedidaResiduo;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import com.dominio.Traslado;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import org.itson.implementacion.FachadaNegocio;
import org.itson.interfaces.INegocio;

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

    /**
     * Representa la interfaz del negocio.
     */
    private INegocio negocio;

    /**
     * Lista de objetos EmpresaTransportista.
     */
    private List<EmpresaTransportista> transportistas = null;

    /**
     * Representa el objeto Residuo.
     */
    private Residuo residuo;

    /**
     * Representa el objeto Administrador.
     */
    private Administrador administrador;

    /**
     * Representa el objeto Solicitud.
     */
    private Solicitud solicitud;

    /**
     * Cantidad de residuos.
     */
    private int cantidadResiduos;

    /**
     * Contador de residuos trasladados.
     */
    private int contadorResiduosTrasladados;

    /**
     * RegistrarTrasladoForm
     */
    private static RegistrarTrasladoForm registrarTrasladoForm;

    /**
     * Creates new form RegistrarTrasladoForm
     */
    private RegistrarTrasladoForm() {
        negocio = new FachadaNegocio();
        initComponents();
    }

    /**
     * Instancia del formulario
     * @return instancia del formulario
     */
    public static RegistrarTrasladoForm getInstance() {
        if (registrarTrasladoForm == null) {
            registrarTrasladoForm = new RegistrarTrasladoForm();
        }
        return registrarTrasladoForm;
    }

    /**
     * Inicia componentes personalizados
     */
    public void iniciarComponentes() {
        this.cantidadResiduos = solicitud.getResiduos().size();
        asignaValoresLabels(solicitud);
        llenadoTablaResiduos(solicitud);
        ejecucionLlenadoTablaTransportistas();
        this.setVisible(true);
    }

    /**
     * Obtener administrador
     * @return administrador
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * Establece el administrador
     * @param administrador administrador a asignar
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Obtener la solicitud
     * @return Solicitud
     */
    public Solicitud getSolicitud() {
        return solicitud;
    }

    /**
     * Establece la solicitud
     * @param solicitud solicitud a asignar
     */
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    

    /**
     * Llena la tabla de residuos con los datos de una solicitud.
     *
     * @param solicitud La solicitud de la cual obtener los residuos.
     */
    private void llenadoTablaResiduos(Solicitud solicitud) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tableResiduos.getModel();
        modeloTabla.setRowCount(0);
        for (Residuo r : solicitud.getResiduos()) {
            Object[] fila = {r.getNombre(), r.getCantidad(), r.getMedida_residuo().toString()};
            modeloTabla.addRow(fila);

        }
    }

    /**
     * Asigna los valores de la solicitud a los labels correspondientes.
     *
     * @param solicitud La solicitud de la cual obtener los valores.
     */
    private void asignaValoresLabels(Solicitud solicitud) {
        this.lblProductor.setText(solicitud.getProductor().getNombre());
        SimpleDateFormat formateado = new SimpleDateFormat("dd/MM/yyyy");
        this.lblFechaSol.setText(formateado.format(solicitud.getFecha_Solicitada().getTime()));
    }

    /**
     * Consulta las empresas transportistas disponibles.
     *
     * @return Una lista de objetos EmpresaTransportista.
     */
    private List<EmpresaTransportista> consultaTransportistasDisponibles() {
        return negocio.consultaTodasEmpresasTransportistas();
    }

    /**
     * Llena la tabla de transportistas con los datos de la lista proporcionada.
     *
     * @param transportistas La lista de objetos EmpresaTransportista.
     */
    private void llenarTablaTransportistas(List<EmpresaTransportista> transportistas) {

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tableTransportistas.getModel();
        modeloTabla.setRowCount(0);
        for (EmpresaTransportista t : transportistas) {
            Object[] fila = {t.getNombre()};
            modeloTabla.addRow(fila);
        }
    }

    /**
     * Ejecuta el proceso de llenado de la tabla de transportistas. Consulta las
     * empresas transportistas disponibles, actualiza la lista de transportistas
     * y llena la tabla con los datos obtenidos.
     */
    private void ejecucionLlenadoTablaTransportistas() {
        List<EmpresaTransportista> transportistas = consultaTransportistasDisponibles();
        this.transportistas = transportistas;
        llenarTablaTransportistas(transportistas);
    }

    /**
     * Consulta la empresa transportista seleccionada en la tabla de
     * transportistas. Remueve la fila seleccionada de la tabla y actualiza la
     * lista de transportistas seleccionadas.
     *
     * @return La empresa transportista seleccionada.
     */
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

    /**
     * Consulta la empresa transportista a eliminar de la tabla de
     * transportistas seleccionadas. Remueve la fila seleccionada de la tabla y
     * actualiza la lista de transportistas seleccionadas.
     *
     * @return La empresa transportista a eliminar.
     */
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

    /**
     * Ingresa una empresa transportista a la tabla de transportistas
     * seleccionadas.
     *
     * @param empresaTransportista La empresa transportista a agregar.
     */
    private void ingresaTranportistaSeleccionadas(EmpresaTransportista empresaTransportista) {
        DefaultTableModel modelo = (DefaultTableModel) tableTransportistasSeleccionados.getModel();
        Object[] fila = {empresaTransportista.getNombre()};
        modelo.addRow(fila);
    }

    /**
     * Ingresa una empresa transportista removida a la tabla de transportistas.
     *
     * @param empresaTransportista La empresa transportista a agregar.
     */
    private void ingresaTranportistaRemovida(EmpresaTransportista empresaTransportista) {
        DefaultTableModel modelo = (DefaultTableModel) tableTransportistas.getModel();
        Object[] fila = {empresaTransportista.getNombre()};
        modelo.addRow(fila);
    }

    /**
     * Consulta el residuo seleccionado en la tabla de residuos.
     *
     * @return El residuo seleccionado.
     */
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

    /**
     * Llena los labels de residuo con los datos del residuo proporcionado.
     *
     * @param residuo El residuo a utilizar para llenar los labels.
     */
    private void llenarLabelsResiduo(Residuo residuo) {
        this.lblResiduoSeleccionado.setText(residuo.getNombre());
        this.lblCuenta.setText(residuo.getCantidad().toString());
        this.lblMedicion.setText(residuo.getMedida_residuo().toString());
    }

    /**
     * Consulta los elementos seleccionados en la tabla de transportistas
     * seleccionados.
     *
     * @return Una lista de nombres de las empresas transportistas
     * seleccionadas.
     */
    private List<String> consultarTablaSeleccionados() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < this.tableTransportistasSeleccionados.getRowCount(); i++) {
            lista.add((String) this.tableTransportistasSeleccionados.getValueAt(i, 0));
        }
        return lista;
    }

    /**
     * Obtiene la lista de empresas transportistas seleccionadas en la tabla de
     * transportistas seleccionadas.
     *
     * @return La lista de empresas transportistas seleccionadas.
     */
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
        for (EmpresaTransportista i : lista) {
            EmpresaTransportista et = new EmpresaTransportista();
            et.setId(i.getId());
            et.setNombre(i.getNombre());
            trans.add(et);
        }

        return trans;
    }

    /**
     * Crea un objeto Traslado con los datos del formulario.
     *
     * @return El objeto Traslado creado.
     */
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

    /**
     * Persiste un objeto Traslado en la base de datos.
     *
     * @return El objeto Traslado persistido, o null si no se pudo persistir.
     */
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

    /**
     * Verifica si se ha seleccionado un residuo.
     *
     * @return true si se ha seleccionado un residuo, false de lo contrario.
     */
    private boolean seSeleccionoResiduo() {
        return residuo != null;
    }

    /**
     * Vacía los campos de etiquetas relacionados con el residuo seleccionado.
     */
    private void vaciarLabes() {
        this.lblResiduoSeleccionado.setText("...");
        this.lblMedicion.setText("...");
        this.lblCuenta.setText("...");
    }

    /**
     * Verifica si la tabla de residuos está vacía.
     *
     * @return true si la tabla de residuos está vacía, false de lo contrario.
     */
    private void quitarResiduoTablaResiduos() {
        this.residuo = null;
        vaciarLabes();
        int filaSeleccionada = this.tableResiduos.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) tableResiduos.getModel();
        modelo.removeRow(filaSeleccionada);
        contadorResiduosTrasladados++;
    }

    /**
     * Verifica si la tabla de residuos está vacía.
     *
     * @return true si la tabla de residuos está vacía, false de lo contrario.
     */
    private boolean tablaResiduosEstaVacia() {
        if (this.tableResiduos.getRowCount() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Vacía la tabla de empresas transportistas seleccionadas.
     */
    private void vaciarTablaEmpresasSeleccionadas() {
        DefaultTableModel modelo = (DefaultTableModel) this.tableTransportistasSeleccionados.getModel();
        modelo.setRowCount(0);
    }

    /**
     * Navega a la ventana PrincipalAdministradorForm.
     */
    private void irPrincipalAdministradorForm() {
        PrincipalAdministradorForm principalAdministradorForm;
        principalAdministradorForm = PrincipalAdministradorForm.getInstance();
        principalAdministradorForm.setAdministrador(administrador);
        principalAdministradorForm.iniciarComponentes();
    }

    /**
     * Actualiza el estado de la solicitud a "Atendida".
     */
    private void actualizarEstadoSolicitud() {
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

        panelIzq = new javax.swing.JPanel();
        productorLbl = new javax.swing.JLabel();
        fechaLbl = new javax.swing.JLabel();
        registrarTrasladoLbl = new javax.swing.JLabel();
        panelDer = new javax.swing.JPanel();
        tblNombreEmpresaTransportista = new javax.swing.JScrollPane();
        tableTransportistas = new javax.swing.JTable();
        lblEmpresaTransportista = new javax.swing.JLabel();
        tblEmpresaTransportistaSeleccionada = new javax.swing.JScrollPane();
        tableTransportistasSeleccionados = new javax.swing.JTable();
        lblEmpresas = new javax.swing.JLabel();
        btnAsignar = new javax.swing.JButton();
        lblAsignarTraslado = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblProductor = new javax.swing.JLabel();
        lblFechaSol = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        tblSeleccionarResiduo = new javax.swing.JScrollPane();
        tableResiduos = new javax.swing.JTable();
        residuoSeleccionado = new javax.swing.JLabel();
        lblResiduoSeleccionado = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblCuenta = new javax.swing.JLabel();
        lblMedicion = new javax.swing.JLabel();
        lblSeleccionaResiduo = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar traslado");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        panelIzq.setBackground(new java.awt.Color(255, 255, 255));

        productorLbl.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        productorLbl.setText("Productor:");

        fechaLbl.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        fechaLbl.setText("Fecha Solicitada :");

        registrarTrasladoLbl.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 30)); // NOI18N
        registrarTrasladoLbl.setText("Solicitud Traslado");

        panelDer.setBackground(new java.awt.Color(102, 153, 255));
        panelDer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tblNombreEmpresaTransportista.setViewportView(tableTransportistas);

        panelDer.add(tblNombreEmpresaTransportista, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 300, 180));

        lblEmpresaTransportista.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblEmpresaTransportista.setText("Empresas Transportistas  Disponibles:");
        panelDer.add(lblEmpresaTransportista, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

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
        tblEmpresaTransportistaSeleccionada.setViewportView(tableTransportistasSeleccionados);

        panelDer.add(tblEmpresaTransportistaSeleccionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 300, 170));

        lblEmpresas.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblEmpresas.setText("Empresas a las que se les ");
        lblEmpresas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelDer.add(lblEmpresas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 230, -1));

        btnAsignar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        btnAsignar.setText("Asignar");
        btnAsignar.setContentAreaFilled(false);
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });
        panelDer.add(btnAsignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 90, 40));

        lblAsignarTraslado.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblAsignarTraslado.setText("asignaras el Traslado:");
        panelDer.add(lblAsignarTraslado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        btnSalir.setText("Regresar a pantalla principal");
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
        panelDer.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 210, 40));

        lblMensaje.setBackground(new java.awt.Color(255, 255, 255));
        lblMensaje.setForeground(new java.awt.Color(0, 0, 0));
        panelDer.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 140, 20));

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
        tblSeleccionarResiduo.setViewportView(tableResiduos);

        residuoSeleccionado.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        residuoSeleccionado.setText("Residuo Seleccionado :");

        lblResiduoSeleccionado.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblResiduoSeleccionado.setText("...");

        lblCantidad.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblCantidad.setText("Cantidad :");
        lblCantidad.setToolTipText("");

        lblCuenta.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblCuenta.setText("...");

        lblMedicion.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblMedicion.setText("...");

        lblSeleccionaResiduo.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblSeleccionaResiduo.setText("Selecciona un residuo :");

        javax.swing.GroupLayout panelIzqLayout = new javax.swing.GroupLayout(panelIzq);
        panelIzq.setLayout(panelIzqLayout);
        panelIzqLayout.setHorizontalGroup(
            panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzqLayout.createSequentialGroup()
                .addGroup(panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIzqLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(productorLbl)
                                .addComponent(registrarTrasladoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fechaLbl)
                                .addComponent(jSeparator2))
                            .addComponent(lblProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFechaSol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                            .addComponent(lblSeleccionaResiduo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelIzqLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tblSeleccionarResiduo, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(residuoSeleccionado)
                            .addComponent(lblResiduoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelIzqLayout.createSequentialGroup()
                                .addGroup(panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addComponent(lblMedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(panelDer, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelIzqLayout.setVerticalGroup(
            panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzqLayout.createSequentialGroup()
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
                .addComponent(lblSeleccionaResiduo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblSeleccionarResiduo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(residuoSeleccionado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResiduoSeleccionado)
                .addGroup(panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIzqLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCuenta)
                        .addGap(17, 17, 17))
                    .addGroup(panelIzqLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblMedicion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelIzqLayout.createSequentialGroup()
                .addComponent(panelDer, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelIzq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelIzq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de acción del botón "Asignar". Persiste el traslado,
     * vacía la tabla de empresas transportistas seleccionadas, ejecuta el
     * llenado de la tabla de transportistas, quita el residuo de la tabla de
     * residuos y actualiza el estado de la solicitud.
     *
     * @param evt el evento de acción
     */
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

    /**
     * Maneja el evento de clic en la tabla de residuos. Consulta y selecciona
     * el residuo correspondiente.
     *
     * @param evt el evento de clic del mouse
     */
    private void tableResiduosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableResiduosMouseClicked
        // TODO add your handling code here:
        consultarResiduoSeleccionado();

    }//GEN-LAST:event_tableResiduosMouseClicked

    /**
     * Maneja el evento de clic en la tabla de transportistas. Consulta y
     * selecciona la empresa transportista correspondiente.
     *
     * @param evt el evento de clic del mouse
     */
    private void tableTransportistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTransportistasMouseClicked
        // TODO add your handling code here:
        consultaEmpresaSeleccionada();
    }//GEN-LAST:event_tableTransportistasMouseClicked

    /**
     * Maneja el evento de clic en la tabla de transportistas seleccionados.
     * Consulta y elimina la empresa transportista seleccionada.
     *
     * @param evt el evento de clic del mouse
     */
    private void tableTransportistasSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTransportistasSeleccionadosMouseClicked
        // TODO add your handling code here:
        consultaEmpresaEliminarSeleccion();

    }//GEN-LAST:event_tableTransportistasSeleccionadosMouseClicked

    /**
     * Maneja el evento cuando el mouse entra en el botón "Salir". Si aún hay
     * residuos en la tabla, muestra un mensaje en el label lblMensaje.
     *
     * @param evt el evento del mouse
     */
    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        // TODO add your handling code here:
        if (!tablaResiduosEstaVacia()) {
            this.lblMensaje.setText("Aun hay residuos");

        }

    }//GEN-LAST:event_btnSalirMouseEntered

    /**
     * Maneja el evento cuando el mouse sale del botón "Salir". Borra el mensaje
     * del label lblMensaje.
     *
     * @param evt el evento del mouse
     */
    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        // TODO add your handling code here:

        this.lblMensaje.setText("");


    }//GEN-LAST:event_btnSalirMouseExited

    /**
     * Maneja el evento de acción del botón "Salir". Navega al formulario
     * PrincipalAdministradorForm y cierra la ventana actual.
     *
     * @param evt el evento de acción
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        irPrincipalAdministradorForm();
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        irPrincipalAdministradorForm();
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Botón asignar
     */
    private javax.swing.JButton btnAsignar;
    /**
     * Botón salir
     */
    private javax.swing.JButton btnSalir;
    /**
     * Label de fecha
     */
    private javax.swing.JLabel fechaLbl;
    /**
     * Renglon 1
     */
    private javax.swing.JSeparator jSeparator1;
    /**
     * Renglon 2
     */
    private javax.swing.JSeparator jSeparator2;
    /**
     * Renglon 3
     */
    private javax.swing.JSeparator jSeparator3;
    /**
     * Renglon 4
     */
    private javax.swing.JSeparator jSeparator4;
    /**
     * Label asignar traslado
     */
    private javax.swing.JLabel lblAsignarTraslado;
    /**
     * Label de cantidad
     */
    private javax.swing.JLabel lblCantidad;
    /**
     * Label cuenta
     */
    private javax.swing.JLabel lblCuenta;
    /**
     * Label empresa transportista
     */
    private javax.swing.JLabel lblEmpresaTransportista;
    /**
     * Label empresa
     */
    private javax.swing.JLabel lblEmpresas;
    /**
     * Label fecha solicitada
     */
    private javax.swing.JLabel lblFechaSol;
    /**
     * Label medición
     */
    private javax.swing.JLabel lblMedicion;
    /**
     * Label mensaje
     */
    private javax.swing.JLabel lblMensaje;
    /**
     * Label productor
     */
    private javax.swing.JLabel lblProductor;
    /**
     * Label residuo seleccionado
     */
    private javax.swing.JLabel lblResiduoSeleccionado;
    /**
     * Label selecciona residuo
     */
    private javax.swing.JLabel lblSeleccionaResiduo;
    /**
     * Panel derecho
     */
    private javax.swing.JPanel panelDer;
    /**
     * Panel izquierdo
     */
    private javax.swing.JPanel panelIzq;
    /**
     * Label Productor 
     */
    private javax.swing.JLabel productorLbl;
    /**
     * Label registrar traslado
     */
    private javax.swing.JLabel registrarTrasladoLbl;
    /**
     * Label residuo seleccionado
     */
    private javax.swing.JLabel residuoSeleccionado;
    /**
     * Tabla residuos
     */
    private javax.swing.JTable tableResiduos;
    /**
     * Tabla empresa transportistas no seleccionados
     */
    private javax.swing.JTable tableTransportistas;
    /**
     * Tabla empresa transportistas seleccionados
     */
    private javax.swing.JTable tableTransportistasSeleccionados;
    /**
     * Scroll pane de la tabla empresa transportistas seleccionados
     */
    private javax.swing.JScrollPane tblEmpresaTransportistaSeleccionada;
    /**
     * Scroll pane de la tabla empresa transportistas no seleccionados
     */
    private javax.swing.JScrollPane tblNombreEmpresaTransportista;
    /**
     * Scroll pane de la tabla residuos seleccionados
     */
    private javax.swing.JScrollPane tblSeleccionarResiduo;
    // End of variables declaration//GEN-END:variables

}
