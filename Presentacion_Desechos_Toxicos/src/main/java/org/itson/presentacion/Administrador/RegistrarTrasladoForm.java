
package org.itson.presentacion.Administrador;

import com.dominio.Residuo;
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
import java.util.Calendar;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;

/**
 * Descripción de la clase: Se encarga de hacer el proceso de registro de los traslados
 * 
 *
 * @author Aracely Campa Quintana ID: 233215
 * @author Edgar Emir Borbon Jimenez ID:
 * @author Oscar Minjarez Zavala ID: 231503
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class RegistrarTrasladoForm extends javax.swing.JFrame {
private final String NOMBRE_PRODUCTOR_DEFAULT = "Ej: Industrias químicas";
    /**
     * Creates new form RegistrarTrasladoForm
     */
    public RegistrarTrasladoForm() {
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

        jPanel1 = new javax.swing.JPanel();
        productorLbl = new javax.swing.JLabel();
        fechaLbl = new javax.swing.JLabel();
        fechaSolicitada = new com.github.lgooddatepicker.components.DatePicker();
        registrarTrasladoLbl = new javax.swing.JLabel();
        campoProductor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistrarTraslado = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        seleccionarBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        productorLbl.setText("Productor:");
        productorLbl.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N

        fechaLbl.setText("Fecha Solicitada");
        fechaLbl.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N

        registrarTrasladoLbl.setText("Solicitud Traslado");
        registrarTrasladoLbl.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 30)); // NOI18N

        campoProductor.setText(NOMBRE_PRODUCTOR_DEFAULT);
        campoProductor.setBorder(null);
        campoProductor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoProductor.setForeground(Color.GRAY);
        campoProductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoProductorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoProductorFocusLost(evt);
            }
        });
        campoProductor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoProductorMouseClicked(evt);
            }
        });

        tablaRegistrarTraslado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Residuo a transportar", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaRegistrarTraslado);

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seleccionarBtn.setText("siguiente");
        seleccionarBtn.setContentAreaFilled(false);
        seleccionarBtn.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        seleccionarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seleccionarBtn)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(productorLbl)
                            .addComponent(registrarTrasladoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaLbl)
                            .addComponent(fechaSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(registrarTrasladoLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(productorLbl)
                .addGap(18, 18, 18)
                .addComponent(campoProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fechaLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seleccionarBtn)
                        .addGap(59, 59, 59))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(111, Short.MAX_VALUE))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarBtnActionPerformed
        int i = 0;
        if(!validarCampoTextoVacio()){
            JOptionPane.showMessageDialog(this, "Ingrese productor", "ERROR", JOptionPane.ERROR_MESSAGE);
                i++;
        }
        
         else {
            List<String> camposVacios = this.validarCampoVacio();
            if (!camposVacios.isEmpty()) {
                String mensaje = "Los siguientes campos se encuentran vacíos \n";
                for (String campos : camposVacios) {
                    mensaje += campos + "\n";
                }
                JOptionPane.showMessageDialog(this, mensaje, "No se puede registrar traslado", JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }
        if (i == 0) {
          
            JOptionPane.showMessageDialog(this, "Registro exitoso", "Nuevo Registro de traslado", JOptionPane.INFORMATION_MESSAGE);
        }
       SolictudTrasladoForm r = new SolictudTrasladoForm();
       r.setVisible(true);
       dispose();
    }//GEN-LAST:event_seleccionarBtnActionPerformed

    private void campoProductorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoProductorFocusGained
        if (validarCampoTextoVacio()) {
            this.campoProductor.setForeground(Color.BLACK);
            this.campoProductor.setText("");
        }
    }//GEN-LAST:event_campoProductorFocusGained

    private void campoProductorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoProductorFocusLost
        if (validarCampoTextoVacio()) {
            this.campoProductor.setForeground(Color.GRAY);
            this.campoProductor.setText(NOMBRE_PRODUCTOR_DEFAULT);
        }
    }//GEN-LAST:event_campoProductorFocusLost

    private void campoProductorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoProductorMouseClicked
        if (validarCampoTextoVacio()) {
            this.campoProductor.setForeground(Color.BLACK);
            this.campoProductor.setText("");
        }
    }//GEN-LAST:event_campoProductorMouseClicked

    private List<String> validarCampoVacio() {
    List<String> campos = new ArrayList<>();
    if (this.validarCampoTextoVacio()) {
        campos.add("- Productor");
    }
    return campos;
}
    private boolean validarCampoTextoVacio() {
        return campoProductor.getText().isEmpty() || campoProductor.getText().equals(ERROR);
    }
    private LocalDate solicitarFecha() {
        LocalDate fecha = this.fechaSolicitada.getDate();
        while (fechaSolicitada.getDate() == null) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    return fecha;
    }
    

    
    //Metodo incompleto debido a que se requieren metodos de las otras capas
    private void cargarTablaResiduoATransportar(){
        Residuo residuo = a.buscarResiduo(id); //es temporal la estructura de este objeto 
        try {
            List<Residuo> listaRegistroResiduo = b.buscarRegistroRegistro(configPaginado, residuo, this.cantidad, this.solicitarFecha());
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaRegistrarTraslado.getModel();
            modeloTabla.setRowCount(0);
            for (RegistroTraslado registroTraslado : registro) {
                Calendar fechaRegistroReisduo = residuo.getFechaEmision();
                Date date = fechaRegistroReisduo.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaE = sdf.format(date);
                Object[] solicitud = {
                    residuo.getNombreResiduo(),
                    residuo.getCantidad(),
                    fechaE
                };
                modeloTabla.addRow(solicitud);
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrarTrasladoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoProductor;
    private javax.swing.JLabel fechaLbl;
    private com.github.lgooddatepicker.components.DatePicker fechaSolicitada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel productorLbl;
    private javax.swing.JLabel registrarTrasladoLbl;
    private javax.swing.JButton seleccionarBtn;
    private javax.swing.JTable tablaRegistrarTraslado;
    // End of variables declaration//GEN-END:variables

    
}
