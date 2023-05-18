package org.itson.presentacion.Administrador;

import com.dominio.Administrador;
import com.dominio.Estado;
import com.dominio.Productor;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itson.implementacion.FachadaNegocio;
import org.itson.interfaces.INegocio;
import org.itson.presentacion.Administrador.PrincipalAdministradorForm;
import org.itson.utils.ConfiguracionDePaginado;

/**
 * Descripción de la clase: Solicitudes de traslados
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID:
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class SolicitudesTrasladosForm extends javax.swing.JFrame {

    List<Solicitud> solicitudesTablaSolicitudes = null;
    Solicitud solicitudSeleccionada = null;

    private Administrador administrador;
    private INegocio negocio;
    private ConfiguracionDePaginado configPaginado;

    /**
     * Creates new form TrasladoEmpresasForm
     */
    public SolicitudesTrasladosForm(Administrador administrador) {
        initComponents();
        this.administrador = administrador;
        negocio = new FachadaNegocio();
        configPaginado = new ConfiguracionDePaginado(0, 3);
        ejecucionLlenadoTablaSolicitudes();
        this.setVisible(true);
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    private List<Solicitud> consultaSolicitudesNoAtendidas() {
        List<Solicitud> solicitudes = negocio.consultaSolicitudesNoAtendidas();
        return solicitudes;
    }

    private List<Solicitud> consultaSolicitudesConConfiguracionTabla(ConfiguracionDePaginado configuracionPaginado, List<Solicitud> solicitudes) {
        int offset = configuracionPaginado.getElementoASaltar();
        int limit = configuracionPaginado.getElementosPorPagina();
        List<Solicitud> lista = new ArrayList<>();
        Iterator<Solicitud> iterador = solicitudes.iterator();
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

    private void llenarTablaSolicitudes(List<Solicitud> solicitudes) {
        SimpleDateFormat formateado = new SimpleDateFormat("dd/MM/yyyy");

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tableSolicitudes.getModel();
        modeloTabla.setRowCount(0);
        for (Solicitud s : solicitudes) {

            s.getFecha_Solicitada().setDate(s.getFecha_Solicitada().getDate() + 1);
            Object[] fila = {s.getProductor().getNombre(), formateado.format(s.getFecha_Solicitada().getTime()), s.toString()};
            modeloTabla.addRow(fila);
        }
    }

    private void ejecucionLlenadoTablaSolicitudes() {
        List<Solicitud> solicitudes = consultaSolicitudesNoAtendidas();
        solicitudes = consultaSolicitudesConConfiguracionTabla(configPaginado, solicitudes);
        solicitudesTablaSolicitudes = solicitudes;
        llenarTablaSolicitudes(solicitudes);
    }

    private void retrocederPagina() {
        this.configPaginado.retrocederPagina();
        ejecucionLlenadoTablaSolicitudes();
    }

    private void avanzarPagina() {
        this.configPaginado.avanzarPagina();
        ejecucionLlenadoTablaSolicitudes();
    }

    private void consultaFilaSeleccionadaSolicitudes() {
        int filaSeleccionada = this.tableSolicitudes.getSelectedRow();
        this.lblProductor.setText((String) this.tableSolicitudes.getValueAt(filaSeleccionada, 0));
        this.lblFechaSol.setText((String) this.tableSolicitudes.getValueAt(filaSeleccionada, 1));
        llenadoTablaResiduos(filaSeleccionada);

    }

    private void llenadoTablaResiduos(int index) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tableResiduos.getModel();
        modeloTabla.setRowCount(0);
        for (Residuo r : solicitudesTablaSolicitudes.get(index).getResiduos()) {
            Object[] fila = {r.getNombre(), r.getCantidad(), r.getMedida_residuo().toString()};
            modeloTabla.addRow(fila);

        }
        this.solicitudSeleccionada = solicitudesTablaSolicitudes.get(index);
    }

    private void irRegistrarTrasladoForm() {
        if (!seleccionoUnaSolicitud()) {
            JOptionPane.showMessageDialog(this, "Favor de Seleccionar alguna Solicitude de la Talba de Solicitudes", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        RegistrarTrasladoForm registrarTrasladoForm = new RegistrarTrasladoForm(this.solicitudSeleccionada, administrador);
        cerrarVentanaActual();
    }

    private void irPrincipalAdministradorForm() {
        PrincipalAdministradorForm p = new PrincipalAdministradorForm();
        p.setAdministrador(administrador);
        cerrarVentanaActual();
    }
    
    private void cerrarVentanaActual(){
    this.dispose();
    }
    
    private boolean seleccionoUnaSolicitud(){
        return this.solicitudSeleccionada != null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        regresarBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSolicitudes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnLeft = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnAsignarEmpresas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblProductor = new javax.swing.JLabel();
        lblFechaSol = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResiduos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 30)); // NOI18N
        label1.setText("Solicitudes de traslados");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 340, 20));

        regresarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regresarBtn.setText("Regresar");
        regresarBtn.setContentAreaFilled(false);
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 458, 140, 50));

        tableSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Productor", "Fecha Solicitada", "Residuos"
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
        tableSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSolicitudesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableSolicitudes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 530, 120));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jLabel3.setText("Sesion: Administrador");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        btnLeft.setText("<");
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });
        jPanel1.add(btnLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 60, -1));

        btnRight.setText(">");
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });
        jPanel1.add(btnRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 60, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel2.setText("Solicitudes de traslados: No atendidas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        btnAsignarEmpresas.setText("Asignar Empresas");
        btnAsignarEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarEmpresasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAsignarEmpresas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 530));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel1.setText("Productor :");

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel4.setText("Fecha Solicitada :");

        lblProductor.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblProductor.setText("...");

        lblFechaSol.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblFechaSol.setText("...");

        tableResiduos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Medicion"
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
        jScrollPane1.setViewportView(tableResiduos);

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel7.setText("Residuos :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                        .addComponent(lblProductor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFechaSol, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProductor)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFechaSol)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 340, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        irPrincipalAdministradorForm();
    }//GEN-LAST:event_regresarBtnActionPerformed

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        // TODO add your handling code here:
        retrocederPagina();
    }//GEN-LAST:event_btnLeftActionPerformed

    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightActionPerformed
        // TODO add your handling code here:
        avanzarPagina();
    }//GEN-LAST:event_btnRightActionPerformed

    private void tableSolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSolicitudesMouseClicked
        // TODO add your handling code here:
        consultaFilaSeleccionadaSolicitudes();
    }//GEN-LAST:event_tableSolicitudesMouseClicked

    private void btnAsignarEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarEmpresasActionPerformed
        // TODO add your handling code here:
        irRegistrarTrasladoForm();
    }//GEN-LAST:event_btnAsignarEmpresasActionPerformed

    /**
     * @param args the command line arguments
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
//            java.util.logging.Logger.getLogger(SolicitudesTrasladosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SolicitudesTrasladosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SolicitudesTrasladosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SolicitudesTrasladosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new SolicitudesTrasladosForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarEmpresas;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnRight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel lblFechaSol;
    private javax.swing.JLabel lblProductor;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JTable tableResiduos;
    private javax.swing.JTable tableSolicitudes;
    // End of variables declaration//GEN-END:variables
}
