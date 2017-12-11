package com.syscv.utd.presentacion;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.recursos.JPColor;
import com.syscv.utd.reportes.ReporteRelGastos;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author jarteaga
 */
public class JIFAprobacionRelCom extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo;
    private ConexionBD conexion;
    private ReporteRelGastos reporte;
    private int id;
    private int idusuario=MDIPrincipal.getvSeccion();

    
   
    public JIFAprobacionRelCom() {
        initComponents();
        Color c1=new Color(66,111,166);
        Color c2=new Color(102,174,118);
        JPColor miColor=new JPColor(c1,c2);
        miColor.setSize(this.getSize());
        p_encabezado.add(miColor);
        
        modelo=new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Vehiculo/Equipo");
        modelo.addColumn("Tipo Combustible");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total Galones");
        modelo.addColumn("Total Pesos");
        modelo.addColumn("Usuario");
        
        detalle();
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_placa = new javax.swing.JTextField();
        txt_tc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        jcb_aprobar = new javax.swing.JCheckBox();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_gal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_pesos = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_apro = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btn_visualizar = new javax.swing.JButton();
        btn_mod = new javax.swing.JButton();
        p_encabezado = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Aprobación Relación de Combustible");
        setToolTipText("");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Aprobación Relación de Combustible"));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("ID");

        txt_id.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Placa");

        txt_placa.setEditable(false);
        txt_placa.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        txt_tc.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Fecha");

        txt_fecha.setEditable(false);

        jcb_aprobar.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        jcb_aprobar.setForeground(new java.awt.Color(153, 102, 0));
        jcb_aprobar.setText("* Aprobar");
        jcb_aprobar.setToolTipText("Seleccione para aprobar");

        btn_guardar.setText("Aceptar");
        btn_guardar.setToolTipText("Clic para aprobar");
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardar.setEnabled(false);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Tipo Combustible");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(236, 19, 19));
        jLabel1.setText("* Campos Obligatorios");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Total Galones (gl)");

        txt_gal.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Total Pesos $");

        txt_pesos.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_gal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_pesos, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcb_aprobar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 32, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_gal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txt_pesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_aprobar))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_cancelar)
                    .addComponent(jLabel1)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla_apro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_apro);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/buscar.png"))); // NOI18N
        btn_visualizar.setToolTipText("Visualizar");
        btn_visualizar.setBorderPainted(false);
        btn_visualizar.setContentAreaFilled(false);
        btn_visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_visualizarActionPerformed(evt);
            }
        });

        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/mod_detalle.png"))); // NOI18N
        btn_mod.setToolTipText("Seleccionar");
        btn_mod.setBorderPainted(false);
        btn_mod.setContentAreaFilled(false);
        btn_mod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_visualizar)
            .addComponent(btn_mod)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btn_visualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_mod)
                .addGap(0, 112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        p_encabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 102));
        jLabel8.setText("APROBACIÓN RELACIÓN DE COMBUSTIBLE");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/eds.png"))); // NOI18N

        javax.swing.GroupLayout p_encabezadoLayout = new javax.swing.GroupLayout(p_encabezado);
        p_encabezado.setLayout(p_encabezadoLayout);
        p_encabezadoLayout.setHorizontalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_encabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(195, 195, 195))
        );
        p_encabezadoLayout.setVerticalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_encabezadoLayout.createSequentialGroup()
                .addGroup(p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_encabezadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(p_encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(p_encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_visualizarActionPerformed
        
        if(tabla_apro.isRowSelected(tabla_apro.getSelectedRow()))
        {
        
            reporte=new ReporteRelGastos();
            id=(Integer) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 0);
            
            reporte.ejecutarReporte1(id);
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btn_visualizarActionPerformed

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed
       int idctrl,totalpesos;
      float totalgal;
      String  placa,tc, fecha;
      
           if(tabla_apro.isRowSelected(tabla_apro.getSelectedRow()))
            {
                idctrl = (Integer) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 0); 
                txt_id.setText(String.valueOf(idctrl));
                placa=(String) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 1);
                txt_placa.setText(placa);
                tc=(String) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 2);
                txt_tc.setText(tc);
                fecha=(String) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 3);
                txt_fecha.setText(fecha);
                totalgal=(float) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 4);
                txt_gal.setText(String.valueOf(totalgal));
                totalpesos=(int) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 5);
                txt_pesos.setText(String.valueOf(totalpesos));
                
                btn_guardar.setEnabled(true);
            }
     
    }//GEN-LAST:event_btn_modActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        Date fechaA=new Date();
        if(jcb_aprobar.isSelected())
        {
          conexion.executeUpdateQuery("UPDATE consumo_combustible.control_combustible SET aprobado=true, fecha_aprobacion='"+fechaA+"', id_usuario_apro="+idusuario+" WHERE ctrl_com_id="+txt_id.getText()+"");
          conexion.desconectar();
          
          JOptionPane.showMessageDialog(null, "Se aprobo la relación de combustible N° "+ txt_id.getText() );

          txt_id.setText("");
          txt_placa.setText("");
          txt_tc.setText("");
          txt_fecha.setText("");
          txt_gal.setText("");
          txt_pesos.setText("");
          
          btn_guardar.setEnabled(false);
          LimpiarTabla();
          detalle();
          
          
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione el checkbox aprobar");
        }
        
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton btn_visualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcb_aprobar;
    private javax.swing.JPanel p_encabezado;
    private javax.swing.JTable tabla_apro;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_gal;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_pesos;
    private javax.swing.JTextField txt_placa;
    private javax.swing.JTextField txt_tc;
    // End of variables declaration//GEN-END:variables

  public void detalle()
  {
      conexion=new ConexionBD();
      
      
      ResultSet obj=conexion.executeQuery("SELECT c.ctrl_com_id, (' Placa: ' || ve.placa_identi ||' - '||ma.descripcion ||' '|| li.descripcion)AS vehiculo,tcom.name_combustible,(m.descripcion ||' - '|| y.year)AS fecha,SUM(tg.t_gal_est)AS totalgal, tc.t_ctrl_com_total_pesos,us.usuario FROM consumo_combustible.control_combustible c JOIN utilidades.vehiculos_equipos ve ON ve.id_vehiculo=c.id_vehiculo JOIN utilidades.usuarios us ON us.id_usuario=c.usuario_id JOIN utilidades.linea_vehiculo li ON li.id_linea_vehi=ve.id_linea JOIN utilidades.marca_vehiculo ma ON ma.id_marca=li.id_marca JOIN utilidades.mes m ON m.id_mes=c.id_mes JOIN utilidades.year y ON c.id_year=y.id_year JOIN consumo_combustible.total_control_combustible tc ON tc.ctrl_id=c.ctrl_com_id JOIN consumo_combustible.total_galones tg ON tg.ctrl_com_id=c.ctrl_com_id JOIN utilidades.tipo_combustible tcom ON tcom.id_tipo_com=c.id_tipo_com WHERE c.aprobado=false AND c.totalizado=true AND c.docadjuntada=true GROUP BY c.ctrl_com_id,ve.placa_identi,ma.descripcion,li.descripcion,m.descripcion,y.year,tc.t_ctrl_com_total_pesos,us.usuario,tcom.name_combustible ORDER BY c.ctrl_com_id DESC ");
        try {
            while (obj.next())
            {
                
                Object [] datos = new Object[7];
                
                for (int i=0;i<7;i++)
                {
                    datos[i] =obj.getObject(i+1);
                }
                
                modelo.addRow(datos);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAprobacionRelCom.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabla_apro.setModel(modelo);
        setCellRender(tabla_apro);
        conexion.desconectar();
    
  
  
  }
   public void LimpiarTabla()
    {
  
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
    }
        public void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRenderer());
        }
    }
    
}
