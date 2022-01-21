package edu.formas.s7.vista;

import edu.formas.s7.ctrl.ctrlCuenta;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmCuenta extends javax.swing.JInternalFrame {

    public frmCuenta() {
        initComponents();
        this.panelCuentas.setVisible(true);
        this.panelAddCuenta.setVisible(false);
        this.panelAddAbono.setVisible(false);

        this.model = new DefaultTableModel();
        this.model.addColumn("Numero de Cuenta");
        this.model.addColumn("Cliente");
        this.model.addColumn("Saldo");
        this.tblCuenta.setModel(this.model);
        
        this.modelAbono = new DefaultTableModel();
        this.modelAbono.addColumn("Id");
        this.modelAbono.addColumn("Numero Cuenta");
        this.modelAbono.addColumn("Fecha");
        this.modelAbono.addColumn("Monto");
        this.tblAbonos.setModel(modelAbono);
        
        this.btnAceptar.setActionCommand("Aceptar");
        this.btnEliminar.setActionCommand("Eliminar");
        this.btnAbonoAceptar.setActionCommand("AgregarAbono");
        this.btnVerAbonos.setActionCommand("VerAbonos");

        this.accion = "";
        this.posicionSeleccionada = -1;
    }

    public DefaultTableModel getModelo() {
        return this.model;
    }
    
    public DefaultTableModel getModeloAbono() {
        return this.modelAbono;
    }

    public JComboBox getCombo() {
        return this.cmbClientes;
    }

    public void setControlador(ctrlCuenta c) {
        this.btnAceptar.addActionListener(c);
        this.btnEliminar.addActionListener(c);
        this.btnAbonoAceptar.addActionListener(c);
        this.btnVerAbonos.addActionListener(c);
    }

    public String getTxtNumeroCuenta() {
        return this.txtNumeroCuenta.getText();
    }

    public String getTxtNCuentaAbono() {
        return this.txtAbonoNCuenta.getText();
    }

    public String getTxtFechaAbono() {
        return this.txtAbonoFecha.getText();
    }

    public String getTxtMontoAbono() {
        return this.txtAbonoMonto.getText();
    }

    public String getCliente() {
        return this.cmbClientes.getSelectedItem().toString();
    }

    public String getAccion() {
        return this.accion;
    }

    public int getPosicionSeleccionada() {
        return this.posicionSeleccionada;
    }

    public int registroSeleccionado() {
        return this.tblCuenta.getSelectedRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAddCuenta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumeroCuenta = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        cmbClientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        panelAddAbono = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtAbonoNCuenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAbonoFecha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAbonoMonto = new javax.swing.JTextField();
        btnAbonoAceptar = new javax.swing.JButton();
        btnAbonoCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        panelAbonos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAbonos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        panelCuentas = new javax.swing.JPanel();
        btnAbonos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuenta = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnVerAbonos = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel1.setText("Numero de Cuenta:");

        txtNumeroCuenta.setEditable(false);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("CLIENTE");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAddCuentaLayout = new javax.swing.GroupLayout(panelAddCuenta);
        panelAddCuenta.setLayout(panelAddCuentaLayout);
        panelAddCuentaLayout.setHorizontalGroup(
            panelAddCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddCuentaLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(txtNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddCuentaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelAddCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelAddCuentaLayout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)))
                .addGap(42, 42, 42))
            .addGroup(panelAddCuentaLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAddCuentaLayout.setVerticalGroup(
            panelAddCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddCuentaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelAddCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(panelAddCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(134, 134, 134))
        );

        getContentPane().add(panelAddCuenta, "card3");

        jLabel3.setText("Numero de Cuenta:");

        txtAbonoNCuenta.setEditable(false);

        jLabel4.setText("Fecha:");

        jLabel5.setText("Monto Abono:");

        btnAbonoAceptar.setText("Aceptar");
        btnAbonoAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonoAceptarActionPerformed(evt);
            }
        });

        btnAbonoCancelar.setText("Cancelar");
        btnAbonoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonoCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Formato: AAAA/MM/DD");

        javax.swing.GroupLayout panelAddAbonoLayout = new javax.swing.GroupLayout(panelAddAbono);
        panelAddAbono.setLayout(panelAddAbonoLayout);
        panelAddAbonoLayout.setHorizontalGroup(
            panelAddAbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddAbonoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelAddAbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAbonoAceptar)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGroup(panelAddAbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAddAbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtAbonoNCuenta)
                        .addComponent(txtAbonoFecha)
                        .addComponent(txtAbonoMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                    .addComponent(btnAbonoCancelar)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAddAbonoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        panelAddAbonoLayout.setVerticalGroup(
            panelAddAbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddAbonoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelAddAbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAbonoNCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(panelAddAbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAbonoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(38, 38, 38)
                .addGroup(panelAddAbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAbonoMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(panelAddAbonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbonoAceptar)
                    .addComponent(btnAbonoCancelar))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        getContentPane().add(panelAddAbono, "card4");

        panelAbonos.setBorder(javax.swing.BorderFactory.createTitledBorder("Abonos"));

        tblAbonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblAbonos);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAbonosLayout = new javax.swing.GroupLayout(panelAbonos);
        panelAbonos.setLayout(panelAbonosLayout);
        panelAbonosLayout.setHorizontalGroup(
            panelAbonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
            .addGroup(panelAbonosLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAbonosLayout.setVerticalGroup(
            panelAbonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAbonosLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        getContentPane().add(panelAbonos, "card5");

        panelCuentas.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuentas"));

        btnAbonos.setText("Agregar Abono");
        btnAbonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonosActionPerformed(evt);
            }
        });

        tblCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCuenta);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnVerAbonos.setText("VerAbonos");
        btnVerAbonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerAbonosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCuentasLayout = new javax.swing.GroupLayout(panelCuentas);
        panelCuentas.setLayout(panelCuentasLayout);
        panelCuentasLayout.setHorizontalGroup(
            panelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuentasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbonos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerAbonos)
                .addGap(21, 21, 21)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        panelCuentasLayout.setVerticalGroup(
            panelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(panelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir)
                    .addComponent(btnAbonos)
                    .addComponent(btnVerAbonos))
                .addContainerGap())
        );

        getContentPane().add(panelCuentas, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.panelCuentas.setVisible(false);
        this.panelAddCuenta.setVisible(true);
        this.panelAddAbono.setVisible(false);
        this.panelAbonos.setVisible(false);
        this.jLabel1.setVisible(false);
        this.txtNumeroCuenta.setVisible(false);
        this.txtNumeroCuenta.setText("");
        this.cmbClientes.setSelectedItem(0);
        this.accion = "AD";
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        this.posicionSeleccionada = this.tblCuenta.getSelectedRow();
        if (this.posicionSeleccionada >= 0) {
            this.accion = "MO";
            this.panelCuentas.setVisible(false);
            this.panelAddCuenta.setVisible(true);
            this.panelAddAbono.setVisible(false);
            this.panelAbonos.setVisible(false);
            this.jLabel1.setVisible(true);
        this.txtNumeroCuenta.setVisible(true);
            this.txtNumeroCuenta.setText(this.model.getValueAt(this.posicionSeleccionada, 0).toString());

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        super.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        this.panelCuentas.setVisible(true);
        this.panelAddCuenta.setVisible(false);
        this.panelAddAbono.setVisible(false);
        this.panelAbonos.setVisible(false);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.panelCuentas.setVisible(true);
        this.panelAddCuenta.setVisible(false);
        this.panelAddAbono.setVisible(false);
        this.panelAbonos.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAbonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonosActionPerformed
        this.posicionSeleccionada = this.tblCuenta.getSelectedRow();
        if (this.posicionSeleccionada >= 0) {
            this.panelAddAbono.setVisible(true);
            this.panelCuentas.setVisible(false);
            this.panelAddCuenta.setVisible(false);
            this.panelAbonos.setVisible(false);
            this.txtAbonoNCuenta.setText("");
            this.txtAbonoFecha.setText("");
            this.txtAbonoMonto.setText("");
            this.txtAbonoNCuenta.setText(this.model.getValueAt(this.posicionSeleccionada, 0).toString());

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente");
        }

    }//GEN-LAST:event_btnAbonosActionPerformed

    private void btnAbonoAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonoAceptarActionPerformed
        this.panelAddAbono.setVisible(false);
        this.panelCuentas.setVisible(true);
        this.panelAddCuenta.setVisible(false);
        this.panelAbonos.setVisible(false);
    }//GEN-LAST:event_btnAbonoAceptarActionPerformed

    private void btnAbonoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonoCancelarActionPerformed
        this.panelAddAbono.setVisible(false);
        this.panelCuentas.setVisible(true);
        this.panelAddCuenta.setVisible(false);
        this.panelAbonos.setVisible(false);
    }//GEN-LAST:event_btnAbonoCancelarActionPerformed

    private void btnVerAbonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerAbonosActionPerformed
        // TODO add your handling code here:
         this.posicionSeleccionada = this.tblCuenta.getSelectedRow();
        if (this.posicionSeleccionada >= 0) {
         this.panelAddAbono.setVisible(false);
        this.panelCuentas.setVisible(false);
        this.panelAddCuenta.setVisible(false);
        this.panelAbonos.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente");
        }
        
    }//GEN-LAST:event_btnVerAbonosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          this.panelAddAbono.setVisible(false);
        this.panelCuentas.setVisible(true);
        this.panelAddCuenta.setVisible(false);
        this.panelAbonos.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonoAceptar;
    private javax.swing.JButton btnAbonoCancelar;
    private javax.swing.JButton btnAbonos;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerAbonos;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelAbonos;
    private javax.swing.JPanel panelAddAbono;
    private javax.swing.JPanel panelAddCuenta;
    private javax.swing.JPanel panelCuentas;
    private javax.swing.JTable tblAbonos;
    private javax.swing.JTable tblCuenta;
    private javax.swing.JTextField txtAbonoFecha;
    private javax.swing.JTextField txtAbonoMonto;
    private javax.swing.JTextField txtAbonoNCuenta;
    private javax.swing.JTextField txtNumeroCuenta;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel model;
    private DefaultTableModel modelAbono;
    private String accion;
    private int posicionSeleccionada;
}
