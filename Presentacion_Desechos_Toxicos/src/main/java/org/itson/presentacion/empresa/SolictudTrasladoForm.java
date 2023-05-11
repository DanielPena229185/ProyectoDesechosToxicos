
package org.itson.presentacion.empresa;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//POSIBLE A ELIMINAR
/**
 *
 * @author arace
 */
public class SolictudTrasladoForm extends javax.swing.JFrame {

    /**
     * Creates new form SolictudTrasladoForm
     */
    public SolictudTrasladoForm() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cerrarSesionBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cancelarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSolicitudTraslado = new javax.swing.JTable();
        empresasComboBox = new javax.swing.JComboBox<>();
        seleccioneEmpresaLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        guardarBtn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jLabel2.setText("Sesion: Administrador");

        cerrarSesionBtn.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        cerrarSesionBtn.setContentAreaFilled(false);
        cerrarSesionBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cerrarSesionBtn.setRequestFocusEnabled(false);
        cerrarSesionBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cerrarSesionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cerrarSesionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addContainerGap(465, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 290, 530));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 30)); // NOI18N
        jLabel1.setText("Solicitud de traslado");

        cancelarBtn.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        cancelarBtn.setText("regresar");
        cancelarBtn.setContentAreaFilled(false);
        cancelarBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelarBtn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/cancelar.png"))); // NOI18N
        cancelarBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        tablaSolicitudTraslado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Empresa", "Cantidad", "Peso(kg)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaSolicitudTraslado);

        empresasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empresa" }));

        seleccioneEmpresaLbl.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        seleccioneEmpresaLbl.setText("Seleccione empresa:");

        guardarBtn.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        guardarBtn.setText("guardar");
        guardarBtn.setContentAreaFilled(false);
        guardarBtn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        guardarBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardarBtn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/guardar_G.png"))); // NOI18N
        guardarBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cancelarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guardarBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(empresasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(seleccioneEmpresaLbl)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                                        .addComponent(jSeparator1))
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(seleccioneEmpresaLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(empresasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(cancelarBtn))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guardarBtn)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JButton cerrarSesionBtn;
    private javax.swing.JComboBox<String> empresasComboBox;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel seleccioneEmpresaLbl;
    private javax.swing.JTable tablaSolicitudTraslado;
    // End of variables declaration//GEN-END:variables
}
