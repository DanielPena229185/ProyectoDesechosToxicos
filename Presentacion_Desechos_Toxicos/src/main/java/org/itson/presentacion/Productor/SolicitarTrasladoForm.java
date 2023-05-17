
package org.itson.presentacion.Productor;

import com.dominio.Productor;
import com.dominio.Quimico;
import java.util.List;
import java.util.logging.Logger;
import org.itson.implementaciones.daos.QuimicosDAO;
import org.itson.interfaces.INegocioQuimico;
import com.dominio.Residuo;
import com.dominio.Solicitud;
import static java.awt.image.ImageObserver.ERROR;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itson.implementacion.FachadaNegocio;
import org.itson.interfaces.INegocio;
import org.itson.presentacion.empresa.SolictudTrasladoForm;
import org.itson.utils.ConfiguracionDePaginado;

/**
 * Descripción de la clase: Solicitudes de traslados
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID:
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class SolicitarTrasladoForm extends javax.swing.JFrame {
    List<Residuo> solicitudesTablaResiduo = null;
    Residuo solicitarTrasloResiduo = null;
    private Productor productor;
    private INegocio negocio;
    private ConfiguracionDePaginado configPaginado;
            
    /**
     * Creates new form SolicitarTrasladoForm
     */
    public SolicitarTrasladoForm(Productor productor) {
        initComponents();
        this.productor = productor;
        negocio = new FachadaNegocio();
        configPaginado = new ConfiguracionDePaginado(0, 3);
        ejecucionLlenadoTablaResiduo();
        this.setVisible(true);
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }
    private List<Residuo> consultaSolicitudesResiduos() {
        List<Residuo> residuos = negocio.consultarResiduoFiltro(solicitarTrasloResiduo);
        return residuos;
    }
    private LocalDate solicitarFecha() {
        LocalDate fecha = this.solicitarFecha.getDate();
        while (solicitarFecha.getDate() == null) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    return fecha;
    }
     private List<Residuo> consultaResiduoConConfiguracionTabla(ConfiguracionDePaginado configuracionPaginado, List<Residuo> residuo) {
        int offset = configuracionPaginado.getElementoASaltar();
        int limit = configuracionPaginado.getElementosPorPagina();
        List<Residuo> listaResiduo = new ArrayList<>();
        Iterator<Residuo> iterador = listaResiduo.iterator();
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
            listaResiduo.add(iterador.next());
            l++;
        }
        return listaResiduo;
    }
     private void llenarTablaResiduo(List<Residuo> residuos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblResiduo.getModel();
        modeloTabla.setRowCount(0);
        for (Residuo r : residuos) {

            Object[] fila = {r.getNombre(),r.getMedida_residuo(), r.toString()};
            float[] fila1 = {r.getCantidad()};
            modeloTabla.addRow(fila);
            
        }
    }
    private void ejecucionLlenadoTablaResiduo() {
        List<Residuo> residuos = consultaSolicitudesResiduos();
        residuos = consultaResiduoConConfiguracionTabla(configPaginado, residuos);
        solicitudesTablaResiduo = residuos;
        llenarTablaResiduo(residuos);
    } 
    private void retrocederPagina() {
        this.configPaginado.retrocederPagina();
        ejecucionLlenadoTablaResiduo();
    }

    private void avanzarPagina() {
        this.configPaginado.avanzarPagina();
        ejecucionLlenadoTablaResiduo();
    }
//    private void consultaFilaSeleccionadaResiduo() {
//        int filaSeleccionada = this.tblResiduo.getSelectedRow();
//        this.lblProductor.setText((String) this.tblResiduo.getValueAt(filaSeleccionada, 0));
//        this.lblFechaSol.setText((String) this.tblResiduo.getValueAt(filaSeleccionada, 1));
//        llenadoTablaResiduos(filaSeleccionada);
//
//    }
     private void llenadoTablaResiduos(int index) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblResiduo.getModel();
        modeloTabla.setRowCount(0);
        for (Residuo r : solicitudesTablaResiduo) {
            Object[] fila = {r.getNombre(), r.getCantidad(), r.getMedida_residuo()};
            modeloTabla.addRow(fila);
        }
    
        this.solicitarTrasloResiduo = solicitudesTablaResiduo.get(index);
    }
    private Date obetenerFecha(){
        LocalDate fecha = this.solicitarFecha.getDate();
        Date fechaSolicitud = new Date(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth());
    return fechaSolicitud;
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
        solicitarFecha = new com.github.lgooddatepicker.components.DatePicker();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        solicitarBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResiduo = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(solicitarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel2.setText("Seleccione fecha");
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel3.setText("Selecciones Residuo");
        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel1.setText("Solicitar Traslado");
        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 30)); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel4.setText("Sesion: Productor");
        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N

        solicitarBtn.setText("Solicitar");
        solicitarBtn.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        solicitarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(solicitarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addComponent(solicitarBtn)
                .addGap(34, 34, 34))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 320, 530));

        tblResiduo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Residuo", "Cantidad", "Unidad de medida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblResiduo);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 390, 130));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void solicitarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitarBtnActionPerformed
       int i = 0;
        if(!validarCampoTextoVacio()){
            JOptionPane.showMessageDialog(this, "Fecha vacia", "Error", JOptionPane.ERROR_MESSAGE);
                i++;
        }
         else {
            List<String> camposVacios = this.validarCampoVacio();
            if (!camposVacios.isEmpty()) {
                String mensaje = "Los siguientes campos se encuentran vacíos \n";
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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        PrincipalProductorForm a = new PrincipalProductorForm();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private boolean validarCampoTextoVacio() {
        return solicitarFecha.getText().isEmpty() || solicitarFecha.getText().equals(ERROR);
    }
    private List<String> validarCampoVacio() {
    List<String> campos = new ArrayList<>();
    if (this.validarCampoTextoVacio()) {
        campos.add("- Fecha");
    }
        return campos;
    }
    /**
     * @param args the command line arguments
//     */
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
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton solicitarBtn;
    private com.github.lgooddatepicker.components.DatePicker solicitarFecha;
    private javax.swing.JTable tblResiduo;
    // End of variables declaration//GEN-END:variables

    
}
