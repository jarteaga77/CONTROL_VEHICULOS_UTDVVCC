/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.presentacion;

import com.syscv.utd.DaoInformeMensual.DaoInformeMensual;
import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Informe_Mensual;
import com.syscv.utd.recursos.JPColor;
import com.syscv.utd.reportes.mensuales.ReporteInformeMensual;
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
 * @author Jonathan
 */
public class JIFInformeMensual extends javax.swing.JInternalFrame {

 private DefaultTableModel modelo;
 private int idusuario=MDIPrincipal.getvSeccion();
 private Informe_Mensual info;
 private DaoInformeMensual daoInfo;
 private ReporteInformeMensual reporte;

    
private ConexionBD conexion;
    
    public JIFInformeMensual() {
        initComponents();
        
        Color c1=new Color(66,111,166);
        Color c2=new Color(102,174,118);
        JPColor miColor=new JPColor(c1,c2);
        miColor.setSize(this.getSize());
        p_encabezado.add(miColor);
        
        modelo=new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Fecha Transación");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total Combustible");
        modelo.addColumn("Total Pesos");
        modelo.addColumn("Usuario");
    
        
     try {
         consultarTodo();
     } catch (SQLException ex) {
         Logger.getLogger(JIFInformeMensual.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_generar = new javax.swing.JButton();
        mc_mes = new com.toedter.calendar.JMonthChooser();
        yc_year = new com.toedter.calendar.JYearChooser();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_consulta = new javax.swing.JTable();
        btn_ver = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Generar Informe Mensual Vehiculos / Equipos --UTDVVCC--");
        setPreferredSize(new java.awt.Dimension(800, 600));

        p_encabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("INFORME MENSUAL VEHICULOS / EQUIPOS");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/mensual.png"))); // NOI18N

        javax.swing.GroupLayout p_encabezadoLayout = new javax.swing.GroupLayout(p_encabezado);
        p_encabezado.setLayout(p_encabezadoLayout);
        p_encabezadoLayout.setHorizontalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_encabezadoLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        p_encabezadoLayout.setVerticalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_encabezadoLayout.createSequentialGroup()
                .addGroup(p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(p_encabezadoLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Generar Informe Mensual"));

        btn_generar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/reporte.png"))); // NOI18N
        btn_generar.setToolTipText("Generar");
        btn_generar.setBorderPainted(false);
        btn_generar.setContentAreaFilled(false);
        btn_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 51));
        jLabel2.setText("Seleccione Mes y Año");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(mc_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yc_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_generar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_generar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(yc_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mc_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_consulta);

        btn_ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/ver.png"))); // NOI18N
        btn_ver.setToolTipText("Visualizar");
        btn_ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ver)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_ver)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p_encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p_encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verActionPerformed
       reporte=new ReporteInformeMensual();
       
          int id;
          
          if(tb_consulta.isRowSelected(tb_consulta.getSelectedRow()))
          {
        
                reporte=new ReporteInformeMensual();
        
                 id=(Integer) tb_consulta.getValueAt(tb_consulta.getSelectedRow(), 0);
        
                reporte.ejecutarReporte(id);
          }else
          {
              JOptionPane.showMessageDialog(null, "Debe seleccionar una fila","Alerta", JOptionPane.WARNING_MESSAGE);
          }
    }//GEN-LAST:event_btn_verActionPerformed

    private void btn_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarActionPerformed
        try
        {
            int mes, idyear=0, year, id=0, total_pesos, total_pesos_gal, total_pesos_ccostos, idrc=0;
            String placa, ccostos, combustible, combustible2, ccostos_total_pesos;
            float total_gal, total_gal_total, total_gal_ccostos;//Variable total combustible x vehiculo / total combustible todos
            
            conexion=new ConexionBD();
            info=new Informe_Mensual();
            daoInfo=new DaoInformeMensual();
            year=yc_year.getYear();
            mes=mc_mes.getMonth()+1;
                 
                 ResultSet obj=conexion.executeQuery("SELECT id_year FROM utilidades.year WHERE year="+year+"");
                 
                 while (obj.next())
                 {
                     idyear=obj.getInt("id_year");
                 }
            
                    ResultSet obj1=conexion.executeQuery("SELECT id FROM informes_mensuales.mensual_ctrl WHERE mes="+mes+"AND year="+idyear+"");
            
               if(obj1.next()==true)
                {
          
        
                 JOptionPane.showMessageDialog(null, "No se puede generar el reporte con el mes "+ mes+ " y Año "+ year +" Seleccionado");

           
                }else
                {
                    
                    //Encabezado Informe Mensual
                    info.setFecha_tran(new Date());
                    info.setIdusuario(idusuario);
                    info.setIdmes(mes);
                    info.setIdyear(idyear);
                    
                    daoInfo.guardar(info);
                    id=DaoInformeMensual.getId();
                    
                    //Detalle Informe Mensual
                    ResultSet obj2=conexion.executeQuery("SELECT ve.placa_identi AS placa, (c.sigla_ccostos ||' - '||i.nombre_item_ccostos)AS ccostos, com.name_combustible AS combustible, SUM(det.det_ctrl_com_can_gal)AS total_com, SUM(det.valortanq) AS total_pesos, ctrl.ctrl_com_id AS id FROM consumo_combustible.control_combustible ctrl JOIN consumo_combustible.det_control_combustible det ON det.ctrl_com_id=ctrl.ctrl_com_id JOIN utilidades.vehiculos_equipos ve ON ve.id_vehiculo=ctrl.id_vehiculo JOIN utilidades.itemccostos i ON i.id_item_ccostos=ve.id_item_ccostos JOIN utilidades.centrocostos c ON c.id_centrocostos=i.id_centrocostos JOIN utilidades.tipo_combustible com ON com.id_tipo_com=ctrl.id_tipo_com WHERE ctrl.id_mes="+mes+" AND ctrl.id_year="+idyear+" GROUP BY ve.placa_identi,ccostos,com.name_combustible,id");
                    
                    while(obj2.next()==true)
                    {
                        placa=obj2.getString("placa");
                        ccostos=obj2.getString("ccostos");
                        combustible=obj2.getString("combustible");
                        total_gal=obj2.getFloat("total_com");
                        total_pesos=obj2.getInt("total_pesos");
                        idrc=obj2.getInt("id");
                        
                        conexion.executeUpdateQuery("INSERT INTO informes_mensuales.det_inf_mens(id_men_info,placa,dependencia,tipo_combustible,total_combustible,total_pesos, id_rc)VALUES("+id+", '"+placa+"', '"+ccostos+"', '"+combustible+"', "+total_gal+", "+total_pesos+", "+idrc+")");
                        conexion.desconectar();
                    }
                    
                    ResultSet obj3=conexion.executeQuery("SELECT com.name_combustible AS combustible, SUM(det.det_ctrl_com_can_gal)AS total_com, SUM(det.valortanq) AS total_pesos  FROM consumo_combustible.control_combustible ctrl JOIN consumo_combustible.det_control_combustible det ON det.ctrl_com_id=ctrl.ctrl_com_id  JOIN utilidades.tipo_combustible com ON com.id_tipo_com=ctrl.id_tipo_com WHERE ctrl.id_mes="+mes+" AND ctrl.id_year="+idyear+" GROUP BY com.name_combustible");
                    
                    while(obj3.next())
                    {
                        total_gal_total=obj3.getFloat("total_com");
                        total_pesos_gal=obj3.getInt("total_pesos");
                        combustible2=obj3.getString("combustible");
                        
                        conexion.executeUpdateQuery("INSERT INTO informes_mensuales.total_gal_inf_men (id_men_inf,combustible,total_can,total_pesos)VALUES("+id+",'"+combustible2+"', "+total_gal_total+", "+total_pesos_gal+")");
                        conexion.desconectar();
                    }
                    
                    ResultSet obj4=conexion.executeQuery("SELECT (c.sigla_ccostos ||' - '||i.nombre_item_ccostos)AS ccostos, SUM(det.det_ctrl_com_can_gal)AS total_com, SUM(det.valortanq) AS total_pesos FROM consumo_combustible.control_combustible ctrl JOIN consumo_combustible.det_control_combustible det ON det.ctrl_com_id=ctrl.ctrl_com_id JOIN utilidades.vehiculos_equipos ve ON ve.id_vehiculo=ctrl.id_vehiculo JOIN utilidades.itemccostos i ON i.id_item_ccostos=ve.id_item_ccostos JOIN utilidades.centrocostos c ON c.id_centrocostos=i.id_centrocostos  WHERE ctrl.id_mes="+mes+" AND ctrl.id_year="+idyear+" GROUP BY ccostos");
                    
                    while(obj4.next())
                    {
                        ccostos_total_pesos=obj4.getString("ccostos");
                        total_gal_ccostos=obj4.getFloat("total_com");
                        total_pesos_ccostos=obj4.getInt("total_pesos");
                        
                        conexion.executeUpdateQuery("INSERT INTO informes_mensuales.total_ccostos_inf_men (id_men_inf,ccostos,total_gal,total_pesos)VALUES("+id+", '"+ccostos_total_pesos+"', "+total_gal_ccostos+", "+total_pesos_ccostos+")");
                        conexion.desconectar();
                    }
                    LimpiarTabla();
                    consultarTodo();
                    JOptionPane.showMessageDialog(this, "Se genero con exito el Informe Mensual");
                }
            
               reporte=new ReporteInformeMensual();
               reporte.ejecutarReporte(id);
            
        }catch (Exception e)
         {
             JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
         }
        
        
    }//GEN-LAST:event_btn_generarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_generar;
    private javax.swing.JButton btn_ver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JMonthChooser mc_mes;
    private javax.swing.JPanel p_encabezado;
    private javax.swing.JTable tb_consulta;
    private com.toedter.calendar.JYearChooser yc_year;
    // End of variables declaration//GEN-END:variables


    public void consultarTodo() throws SQLException
    {
        conexion=new ConexionBD();
         
        ResultSet obj=conexion.executeQuery("SELECT me.id, me.fecha_gen,(m.descripcion ||' '||y.year) AS fecha,SUM(det.total_combustible)As total_com, SUM(det.total_pesos)AS total_pesos, us.usuario FROM informes_mensuales.mensual_ctrl me JOIN informes_mensuales.det_inf_mens det ON det.id_men_info=me.id JOIN utilidades.mes m ON m.id_mes=me.mes JOIN utilidades.year y ON y.id_year=me.year JOIN utilidades.usuarios us ON us.id_usuario=me.id_usuario GROUP BY fecha,me.id,us.usuario ORDER BY me.id, fecha DESC ");
        
       while (obj.next()) 
          {
          
          Object [] datos = new Object[6];
       
          for (int i=0;i<6;i++)
          {
              datos[i] =obj.getObject(i+1);
          }

           modelo.addRow(datos);
         
          }
        tb_consulta.setModel(modelo);
        setCellRender(tb_consulta);
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


