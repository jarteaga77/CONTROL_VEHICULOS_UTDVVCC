
package com.syscv.utd.presentacion;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.dao.ctrlcom.CtrlCombustibleDao;
import com.syscv.utd.dao.ctrlcom.DetalleCombustibleDao;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.syscv.utd.recursos.JPColor;
import com.syscv.utd.entidades.ControlCombustible;
import com.syscv.utd.entidades.ControllerItemList;
import com.syscv.utd.entidades.DetalleControlCombustible;
import com.syscv.utd.entidades.Vehiculo;
import com.syscv.utd.reportes.ReporteRelGastos;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jonathan
 */
public class JIFControlCombustible extends javax.swing.JInternalFrame {

   private ConexionBD conexion=new ConexionBD();
   private int id_ctrl;
   private int idusuario=MDIPrincipal.getvSeccion();
   private ControlCombustible control;
   private CtrlCombustibleDao daoCtrl;
   private DetalleControlCombustible detalle;
   private DetalleCombustibleDao daoDetalle;
   private int id_vehiculo=0;
   SimpleDateFormat formato = new SimpleDateFormat ("yyyy/MM/dd"); 
   private int id_tabla=0;
   private ReporteRelGastos reporte;
   private int mes,year;
   private JIFVehiculosEquipos vehiculos;
   

   
   private DefaultTableModel modelo;
   
  
    public JIFControlCombustible() {
        initComponents();
        
        Color c1=new Color(66,111,166);
        Color c2=new Color(102,174,118);
        JPColor miColor=new JPColor(c1,c2);
        miColor.setSize(this.getSize());
        p_encabezado.add(miColor);
        
        try
        {
        
//        ResultSet obj=conexion.executeQuery("SELECT CONCAT (ma.marca,'',li.name_linea,' Placa: ',ve.placa_equipo)AS vehiculo FROM vehiculos_equipos ve INNER JOIN linea li ON ve.Linea_idLinea=li.idLinea INNER JOIN marca_vehiculo ma ON li.marca_vehiculo_id_marca=ma.id_marca ORDER BY ma.marca");
//        
//        while(obj.next())
//        {
//            cb_vehiculo.addItem(obj.getObject("vehiculo"));
//        }
            
            cargarItemVehiculo();
        
        
       ResultSet obj=conexion.executeQuery("SELECT MAX(ctrl_com_id)+1 as id  FROM consumo_combustible.control_combustible");
       
       while(obj.next())
       {
           txt_id_ctrl.setText(String.valueOf(obj.getInt("id")));//Le asigna el consecutivo siguiente de orden compra al textfield
       }    
            
            
        ResultSet obj2=conexion.executeQuery("SELECT est_ser_desc FROM utilidades.estaciones_servicio ORDER BY est_ser_desc");
        
        while(obj2.next())
        {
            cb_eds.addItem(obj2.getObject("est_ser_desc"));
            cb_eds1.addItem(obj2.getObject("est_ser_desc"));

        }
        
     
//        ResultSet obj3=conexion.executeQuery("SELECT name_combustible FROM utilidades.tipo_combustible ORDER BY name_combustible");
//        
//        while (obj3.next())
//        {
//            cb_tc.addItem(obj3.getObject("name_combustible"));
//            cb_tc1.addItem(obj3.getObject("name_combustible"));
//
//        }
        conexion.desconectar();
        
        
        modelo=new DefaultTableModel();
       
        
 
        
        modelo.addColumn("ID");
        modelo.addColumn("ValeUTD");
        modelo.addColumn("RC EDS");
        modelo.addColumn("Fecha");
        modelo.addColumn("Cantidad GL");
        modelo.addColumn("Kilometraje");
        modelo.addColumn("Vlor. total GL");
        modelo.addColumn("Observaciones");
        modelo.addColumn("Valor GL");
        modelo.addColumn("RENDMTO");
        
        
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al cargar las listas " + e);
        }
      
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        JD_ModDetalle = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_eds1 = new javax.swing.JTextField();
        dc_fechaTan1 = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_cg1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_km1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txt_precio1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        cb_eds1 = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        txta_obse3 = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        btn_guardar1 = new javax.swing.JButton();
        txt_vale_utd1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        cb_no_km1 = new javax.swing.JCheckBox();
        JD_Detalle = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txt_eds = new javax.swing.JTextField();
        dc_fechaTan = new com.toedter.calendar.JDateChooser();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txt_cg = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_km = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        cb_eds = new javax.swing.JComboBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        txta_obse2 = new javax.swing.JTextArea();
        jLabel42 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        txt_vale_utd = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        cb_no_km = new javax.swing.JCheckBox();
        p_encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_id_ctrl = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_vehiculo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta_obse = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cb_tc = new javax.swing.JComboBox();
        mc_mes = new com.toedter.calendar.JMonthChooser();
        yc_year = new com.toedter.calendar.JYearChooser();
        jLabel30 = new javax.swing.JLabel();
        btn_agregarvehi = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        t_detalle = new javax.swing.JTable();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_terminar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel21.setText("Número Vale UTD *");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel22.setText("Número Recibo EDS *");

        txt_eds1.setText("000-000");

        jLabel23.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel23.setText("Fecha Tanqueo *");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel24.setText("Cantidad Gasolina *");

        txt_cg1.setText("0");

        jLabel25.setText("gal");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel26.setText("KM/H al tanqueo *");

        txt_km1.setText("0");

        jLabel27.setText("km/h");

        jLabel28.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel28.setText("Total Tanqueo* $");

        txt_precio1.setText("0");

        jLabel29.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel29.setText("EDS *");

        cb_eds1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        txta_obse3.setColumns(20);
        txta_obse3.setRows(5);
        jScrollPane5.setViewportView(txta_obse3);

        jLabel31.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel31.setText("Observaciones");

        btn_guardar1.setText("Agregar");
        btn_guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar1ActionPerformed(evt);
            }
        });

        txt_vale_utd1.setText("0");

        jLabel32.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(153, 0, 0));
        jLabel32.setText("* Campos Obligatorios");

        cb_no_km1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        cb_no_km1.setText("No Km / h");
        cb_no_km1.setToolTipText("Nota: Cuando el kilometraje no esta diligenciado en el recibo ó no es coherente");
        cb_no_km1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_no_km1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_guardar1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addGap(73, 73, 73)
                                        .addComponent(cb_eds1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_eds1)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_vale_utd1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dc_fechaTan1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(245, 245, 245)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel32)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_cg1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel25)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_km1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_no_km1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_precio1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(jLabel21)
                        .addComponent(txt_vale_utd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dc_fechaTan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txt_eds1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txt_cg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(txt_km1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(cb_no_km1)
                            .addComponent(jLabel28)
                            .addComponent(txt_precio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(cb_eds1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(53, 53, 53))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btn_guardar1)
                .addContainerGap())
        );

        javax.swing.GroupLayout JD_ModDetalleLayout = new javax.swing.GroupLayout(JD_ModDetalle.getContentPane());
        JD_ModDetalle.getContentPane().setLayout(JD_ModDetalleLayout);
        JD_ModDetalleLayout.setHorizontalGroup(
            JD_ModDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_ModDetalleLayout.setVerticalGroup(
            JD_ModDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JD_ModDetalleLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        jLabel33.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel33.setText("Número Vale UTD *");

        jLabel34.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel34.setText("Número Recibo EDS *");

        txt_eds.setText("000-000");

        jLabel35.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel35.setText("Fecha Tanqueo *");

        jLabel36.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel36.setText("Cantidad Combustible *");

        txt_cg.setText("0");

        jLabel37.setText("gal");

        jLabel38.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel38.setText("KM / H al tanqueo *");

        txt_km.setText("0");

        jLabel39.setText("km/h");

        jLabel40.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel40.setText("Total Tanqueo $ *");

        txt_precio.setText("0");

        jLabel41.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel41.setText("EDS *");

        cb_eds.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        txta_obse2.setColumns(20);
        txta_obse2.setRows(5);
        jScrollPane6.setViewportView(txta_obse2);

        jLabel42.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel42.setText("Observaciones");

        btn_guardar.setText("Agregar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        txt_vale_utd.setText("0");

        jLabel43.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(153, 0, 0));
        jLabel43.setText("* Campos Obligatorios");

        cb_no_km.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        cb_no_km.setText("No Km / h");
        cb_no_km.setToolTipText("Nota: Cuando el kilometraje no esta diligenciado en el recib");
        cb_no_km.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_no_kmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cg, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel37)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_guardar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel41)
                                        .addGap(73, 73, 73)
                                        .addComponent(cb_eds, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel34)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_eds, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_vale_utd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dc_fechaTan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addGap(30, 30, 30)
                                        .addComponent(txt_km, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel39)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb_no_km)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel40)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane6)))
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(dc_fechaTan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_km, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39)
                            .addComponent(cb_no_km)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel33)
                                .addComponent(txt_vale_utd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel35))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel34)
                                .addComponent(txt_eds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(txt_cg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(cb_eds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(53, 53, 53))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(btn_guardar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_DetalleLayout = new javax.swing.GroupLayout(JD_Detalle.getContentPane());
        JD_Detalle.getContentPane().setLayout(JD_DetalleLayout);
        JD_DetalleLayout.setHorizontalGroup(
            JD_DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_DetalleLayout.setVerticalGroup(
            JD_DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Relación de Combustible --UTDVVCC--");

        p_encabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("RELACIÓN DE COMBUSTIBLE");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/eds.png"))); // NOI18N

        javax.swing.GroupLayout p_encabezadoLayout = new javax.swing.GroupLayout(p_encabezado);
        p_encabezado.setLayout(p_encabezadoLayout);
        p_encabezadoLayout.setHorizontalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_encabezadoLayout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(263, 263, 263))
        );
        p_encabezadoLayout.setVerticalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_encabezadoLayout.createSequentialGroup()
                .addGroup(p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_encabezadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("General"));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel2.setText("ID Ctrol. Combustible *");

        txt_id_ctrl.setEditable(false);
        txt_id_ctrl.setForeground(new java.awt.Color(0, 255, 255));
        txt_id_ctrl.setText("0");
        txt_id_ctrl.setToolTipText("Campo Obligatorio No editable");

        jLabel3.setText("Vehiculo/Equipo *");

        cb_vehiculo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        cb_vehiculo.setToolTipText("");
        cb_vehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_vehiculoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cb_vehiculoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cb_vehiculoMouseReleased(evt);
            }
        });
        cb_vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_vehiculoActionPerformed(evt);
            }
        });

        jLabel6.setText("Observaciones ");

        txta_obse.setColumns(20);
        txta_obse.setRows(5);
        jScrollPane1.setViewportView(txta_obse);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 0, 0));
        jLabel19.setText("* Campos Obligatorios");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel16.setText("Combustible *");

        jLabel30.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel30.setText("Fecha *");

        btn_agregarvehi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/add.png"))); // NOI18N
        btn_agregarvehi.setToolTipText("Registro de vehiculos");
        btn_agregarvehi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarvehiActionPerformed(evt);
            }
        });

        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/actualizar.png"))); // NOI18N
        btn_actualizar.setToolTipText("Actualizar Lista de vehiculos / Equipos");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(73, 73, 73)
                                .addComponent(mc_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yc_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_id_ctrl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addComponent(btn_agregarvehi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_tc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cb_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(mc_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(yc_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_agregarvehi, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txt_id_ctrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(cb_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel30))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        t_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(t_detalle);

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/mod_detalle.png"))); // NOI18N
        btn_editar.setEnabled(false);
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/delete.png"))); // NOI18N
        btn_eliminar.setToolTipText("");
        btn_eliminar.setEnabled(false);
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/add.png"))); // NOI18N
        btn_agregar.setToolTipText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.Alignment.LEADING)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(btn_agregar)
                .addGap(7, 7, 7)
                .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminar)
                .addGap(0, 166, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_terminar.setText("Terminar");
        btn_terminar.setEnabled(false);
        btn_terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_terminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_terminar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p_encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_terminar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        int opc=JOptionPane.showConfirmDialog(null,"Desea eliminar una Linea?", "Aviso!", JOptionPane.YES_NO_OPTION); 
          
        if(opc==JOptionPane.YES_OPTION)
        {
             eliminarRegistroTabla();
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
         int valeUTD,vlor_gl;
         float can_gl,km_tanq;
         String rc_eds,obs;
         Date fecha_tanq;
         
        
        if(t_detalle.isRowSelected(t_detalle.getSelectedRow()))
            {
                id_tabla = (Integer) t_detalle.getValueAt(t_detalle.getSelectedRow(), 0);    
                valeUTD=(int) t_detalle.getValueAt(t_detalle.getSelectedRow(), 1);
                rc_eds=(String) t_detalle.getValueAt(t_detalle.getSelectedRow(), 2);
                fecha_tanq=(Date) t_detalle.getValueAt(t_detalle.getSelectedRow(), 3);
                can_gl=(float) t_detalle.getValueAt(t_detalle.getSelectedRow(),4);
                km_tanq=(float) t_detalle.getValueAt(t_detalle.getSelectedRow(), 5);
                vlor_gl=(int) t_detalle.getValueAt(t_detalle.getSelectedRow(), 6);
                obs=(String) t_detalle.getValueAt(t_detalle.getSelectedRow(), 7);
                
                txt_vale_utd1.setText(String.valueOf(valeUTD));
                txt_eds1.setText(rc_eds);
                dc_fechaTan1.setDate(fecha_tanq);
                txt_cg1.setText(String.valueOf(can_gl));
                txt_km1.setText(String.valueOf(km_tanq));
                txt_precio1.setText(String.valueOf(vlor_gl));
                txta_obse3.setText(obs);
       
                 JD_ModDetalle.pack();
                 JD_ModDetalle.setLocationRelativeTo(null);
                 JD_ModDetalle.setVisible(true);
                 JD_ModDetalle.setResizable(false);
     
            }else
            {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
            }
       
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar1ActionPerformed
        try
        {
        
       // Calendar c1=dc_fechaTan1.getCalendar();
            
            
            Date fechaTan=dc_fechaTan1.getDate();
            Calendar cal=Calendar.getInstance();         
            cal.setTime(fechaTan);
            int mesTan=cal.get(Calendar.MONTH)+1;
            int yearTan=cal.get(Calendar.YEAR);   
            
       // control=new ControlCombustible();
        //sdaoCtrl=new CtrlCombustibleDao();
        detalle=new DetalleControlCombustible();
        daoDetalle=new DetalleCombustibleDao();
        int ideds=0;
        int vlorGas=0;
        float kilometraje=0;
        float parcial=0;
        float rend=0;
        String obse="";
        
        
        mes=mc_mes.getMonth()+1;
        year=yc_year.getYear();
        
        
          
        detalle.setId(id_tabla);
        detalle.setValeUTD(Integer.parseInt(txt_vale_utd1.getText()));
        detalle.setReciboEstacion(txt_eds1.getText());
        
         if( mes!=mesTan || year!=yearTan)
        {
           throw new Exception("La fecha del tanqueo debe estar dentro del rango de la fecha del reporte");
        }
        
        detalle.setFechaTanqueo(fechaTan);
        detalle.setCantGal(Float.parseFloat(txt_cg1.getText()));
        detalle.setVlorTanqueo(Integer.parseInt(txt_precio1.getText()));
        detalle.setDeta_obser(txta_obse3.getText());
        
         vlorGas=(int) (detalle.getVlorTanqueo()/detalle.getCantGal());
         
         detalle.setVlorGaso(vlorGas);
         
         ResultSet obj1=conexion.executeQuery("SELECT det.kmtanq AS km FROM consumo_combustible.det_control_combustible det JOIN consumo_combustible.control_combustible ctrl ON ctrl.ctrl_com_id=det.ctrl_com_id WHERE ctrl.id_vehiculo="+id_vehiculo+" ORDER BY det.det_ctrl_com_id DESC limit 1");
         System.out.println(id_vehiculo);
       
           while (obj1.next())
           {
               kilometraje=obj1.getFloat("km");
               System.out.println("ola1"+kilometraje);
           }
      
         

         if(kilometraje==0)
         {
             System.out.println("Paso por aca pq km" + kilometraje );

            parcial=0;
            detalle.setParcialkm(parcial);
            rend=0;
            detalle.setRenmto(rend);

         }
         else
         {
         parcial=Float.parseFloat(txt_km1.getText())- kilometraje;
        
         detalle.setParcialkm(parcial);
         
         
         rend=parcial/Float.parseFloat(txt_cg1.getText());
         System.out.println("ola"+rend);
         detalle.setRenmto(rend);
         }
         
        if(cb_eds1.getSelectedItem()!= null)
        {
            String eds=cb_eds1.getSelectedItem().toString();
            
            ResultSet obj2=conexion.executeQuery("SELECT est_ser_id FROM utilidades.estaciones_servicio WHERE est_ser_desc='"+eds+"'");
            
           
                  while (obj2.next())
                  {
                      ideds=obj2.getInt("est_ser_id");
                      
                  } 
        }
        
        detalle.setId_estacion(ideds);
        
        if(cb_no_km1.isSelected()==true)
        {
            detalle.setKmTanqueo(0);
            detalle.setRenmto(0);
            detalle.setParcialkm(0);
            obse="El recibo le falta kilometraje / Hora ó esta mal diligenciado por el conductor";
            detalle.setDeta_obser(obse);
            daoDetalle.actualizar(detalle);
             limpiar();
            LimpiarTabla();
            detalleTabla();
            JD_ModDetalle.dispose();
        }
        
//        if(Float.parseFloat(txt_km.getText())<= kilometraje)
//        {
//            throw new Exception ("El kilometraje digitado no puede ser inferior a " + kilometraje+ " km");
//        }
        
//        if(cb_tc1.getSelectedItem()!=null)
//        {
//            String combus=cb_tc1.getSelectedItem().toString();
//            
//            ResultSet obj3=conexion.executeQuery("SELECT id_tipo_com FROM utilidades.tipo_combustible WHERE name_combustible='"+combus+"'");
//            
//             
//                  while(obj3.next())
//                  {
//                      idtipocom=obj3.getInt("id_tipo_com");
//                  } 
//        
//        }
//        detalle.setId_tipoCombus(idtipocom);
             detalle.setKmTanqueo(Float.parseFloat(txt_km1.getText()));
             detalle.setDeta_obser(txta_obse3.getText());


           daoDetalle.actualizar(detalle);
      
        limpiar();
        LimpiarTabla();
        detalleTabla();
        
        
        JD_ModDetalle.dispose();
               
    }catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
      
        
    }//GEN-LAST:event_btn_guardar1ActionPerformed

    private void btn_terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_terminarActionPerformed
                 int opc=JOptionPane.showConfirmDialog(null,"Desea concluir el registro de relación de combustible?", "Aviso!", JOptionPane.YES_NO_OPTION); 
          
        if(opc==JOptionPane.YES_OPTION)
        {
            
        if(t_detalle.getRowCount()== 0 && t_detalle.getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(null, "La tabla Detalle no contiene ningun registro!");
            
        }
        else 
        {
            
            System.out.print(id_ctrl);
            
            totalizador();
            
            JOptionPane.showMessageDialog(null,"Se ha concluido con exito la relación de combustible y la totalización del mismo");
            
            reporte=new ReporteRelGastos();
            
            reporte.ejecutarReporte1(id_ctrl);
          
           dispose();
           
        }
       }  

    }//GEN-LAST:event_btn_terminarActionPerformed

    private void cb_vehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_vehiculoActionPerformed
        try {
           
            
            
           System.out.println("PAso por aca");
           cb_tc.removeAllItems();
           
           int idveh;
           Vehiculo v=(Vehiculo) cb_vehiculo.getSelectedItem();
           idveh=v.getId_vehiculo();
           
           
           ResultSet obj=conexion.executeQuery("SELECT tc.name_combustible AS com,tca.name_combustible AS alterno FROM utilidades.vehiculos_equipos v JOIN utilidades.tipo_combustible tc ON tc.id_tipo_com=v.id_tipo_com JOIN utilidades.tipo_combustible tca ON tca.id_tipo_com=v.id_2tipo_com WHERE v.id_vehiculo="+idveh+" ");
           
           
           while (obj.next())
           {
              System.out.println("Paso por aca");
               cb_tc.addItem(obj.getObject("com"));
              cb_tc.addItem(obj.getObject("alterno"));
             
          }
           conexion.desconectar();
         
       } catch (SQLException ex) {
           Logger.getLogger(JIFControlCombustible.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
    }//GEN-LAST:event_cb_vehiculoActionPerformed

    private void btn_agregarvehiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarvehiActionPerformed
        vehiculos=new JIFVehiculosEquipos();
        MDIPrincipal.escritorio.add(vehiculos);
        vehiculos.toFront();
        vehiculos.setVisible(true);
        
        btn_actualizar.setEnabled(true);
    }//GEN-LAST:event_btn_agregarvehiActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        
        cargarItemVehiculo();
        
      
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void cb_no_km1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_no_km1ActionPerformed
         if(cb_no_km1.isSelected()==true)
       {
           txt_km1.setEnabled(false);
           txt_km1.setText("0");
       }else
       {
           txt_km1.setEnabled(true);
       }
    }//GEN-LAST:event_cb_no_km1ActionPerformed

    private void cb_vehiculoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_vehiculoMousePressed
       
        
    }//GEN-LAST:event_cb_vehiculoMousePressed

    private void cb_vehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_vehiculoMouseClicked
      // TODO add your handling code here:
    }//GEN-LAST:event_cb_vehiculoMouseClicked

    private void cb_vehiculoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_vehiculoMouseReleased
       }//GEN-LAST:event_cb_vehiculoMouseReleased

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
       
        try
        {
            Date fechaTan=dc_fechaTan.getDate();

            Calendar cal=Calendar.getInstance();
            cal.setTime(fechaTan);
            System.out.println(fechaTan);
            int mesTan=cal.get(Calendar.MONTH)+1;
            int yearTan=cal.get(Calendar.YEAR);

            System.out.println("mesTan"+mesTan + "year"+yearTan);

            control=new ControlCombustible();
            daoCtrl=new CtrlCombustibleDao();
            detalle=new DetalleControlCombustible();
            daoDetalle=new DetalleCombustibleDao();
            int ideds=0;
            int idtipocom=0;
            int vlorGas=0;
            float kilometraje=0;
            float parcial=0;
            float rend=0;
            int idyear=0;
            String obse="";
            // int mes=0, year=0;// Variables que se guarda en control vehiculos

            ResultSet obj0=conexion.executeQuery("SELECT ctrl_com_id FROM consumo_combustible.control_combustible WHERE ctrl_com_id="+txt_id_ctrl.getText()+"");

            if(obj0.next()==false)
            {

                control.setCtrl_com_fecha_tran(new Date());

                mes=mc_mes.getMonth()+1;
                year=yc_year.getYear();

                System.out.println(mes);
                System.out.println(year);
                ResultSet obj8=conexion.executeQuery("SELECT id_year FROM utilidades.year WHERE year="+year+"");

                while (obj8.next())
                {
                    idyear=obj8.getInt("id_year");
                }

                control.setIdmes(mes);
                control.setIdyear(idyear);

                Vehiculo v=(Vehiculo) cb_vehiculo.getSelectedItem();
                id_vehiculo=v.getId_vehiculo();

                ResultSet obj=conexion.executeQuery("SELECT id_vehiculo FROM consumo_combustible.control_combustible WHERE id_mes ="+mes+" AND id_year="+year+" AND id_vehiculo="+id_vehiculo+"");

                if(obj.next()==true)
                {
                    throw new Exception("No se permite el mes seleccionado");

                }

                if(cb_tc.getSelectedItem()!= null)
                {
                    String com=cb_tc.getSelectedItem().toString();

                    ResultSet obj7=conexion.executeQuery("SELECT id_tipo_com FROM utilidades.tipo_combustible WHERE name_combustible='"+com+"'");

                    while (obj7.next())
                    {
                        idtipocom=obj7.getInt("id_tipo_com");
                        System.out.println(com + idtipocom);

                    }
                }
                System.out.println(idtipocom);

                control.setId_tipoCom(idtipocom);
                control.setId_usuario(idusuario);
                control.setId_vehiculo(id_vehiculo);
                control.setObserva(txta_obse.getText());

                daoCtrl.guardar(control);

                bloquear();

                id_ctrl=CtrlCombustibleDao.getIdCtrl();

                txt_id_ctrl.setText(String.valueOf(id_ctrl));

                detalle.setId_ctrl_com(id_ctrl);
                detalle.setValeUTD(Integer.parseInt(txt_vale_utd.getText()));
                detalle.setReciboEstacion(txt_eds.getText());

                if( mes!=mesTan || year!=yearTan)
                {

                    throw new Exception("La fecha del tanqueo debe estar dentro del rango de la fecha de registro del reporte");
                }

                detalle.setFechaTanqueo(fechaTan);
                detalle.setCantGal(Float.parseFloat(txt_cg.getText()));
                detalle.setVlorTanqueo(Integer.parseInt(txt_precio.getText()));

                System.out.println("Paso 1");

                vlorGas=(int) (detalle.getVlorTanqueo()/detalle.getCantGal());
                System.out.println("Paso 2");
                detalle.setVlorGaso(vlorGas);
                System.out.println("Paso 3");

                ResultSet obj1=conexion.executeQuery("SELECT det.kmtanq AS km FROM consumo_combustible.det_control_combustible det JOIN consumo_combustible.control_combustible ctrl ON ctrl.ctrl_com_id=det.ctrl_com_id WHERE ctrl.id_vehiculo="+id_vehiculo+" ORDER BY det.det_ctrl_com_id DESC limit 1");
                System.out.println(id_vehiculo);

                while (obj1.next())
                {
                    kilometraje=obj1.getFloat("km");
                    System.out.println(kilometraje);
                }

                if(kilometraje==0)
                {
                    System.out.println("Paso por aca pq km" + kilometraje );

                    parcial=0;
                    detalle.setParcialkm(parcial);
                    rend=0;
                    detalle.setRenmto(rend);

                }
                else
                {
                    parcial=Float.parseFloat(txt_km.getText())- kilometraje;

                    detalle.setParcialkm(parcial);

                    rend=parcial/Float.parseFloat(txt_cg.getText());
                    System.out.println(rend);
                    detalle.setRenmto(rend);
                }

                if(cb_eds.getSelectedItem()!= null)
                {
                    String eds=cb_eds.getSelectedItem().toString();

                    ResultSet obj2=conexion.executeQuery("SELECT est_ser_id FROM utilidades.estaciones_servicio WHERE est_ser_desc='"+eds+"'");

                    while (obj2.next())
                    {
                        ideds=obj2.getInt("est_ser_id");

                    }
                }

                detalle.setId_estacion(ideds);

                if(cb_no_km.isSelected()==true)
                {

                    detalle.setKmTanqueo(0);
                    detalle.setParcialkm(0);
                    detalle.setRenmto(0);
                    obse="El recibo le falta kilometraje ó esta mal diligenciado por el conductor";
                    detalle.setDeta_obser(obse);
                    daoDetalle.guardar(detalle);
                    limpiar();
                    LimpiarTabla();
                    detalleTabla();
                }
                else{
                    if(Float.parseFloat(txt_km.getText())<=kilometraje)
                    {
                        throw new Exception ("El kilometraje digitado no puede ser inferior a " + kilometraje+ " km");
                    }

                    //        if(cb_tc.getSelectedItem()!=null)
                    //        {
                        //            String combus=cb_tc.getSelectedItem().toString();
                        //
                        //            ResultSet obj3=conexion.executeQuery("SELECT id_tipo_com FROM utilidades.tipo_combustible WHERE name_combustible='"+combus+"'");
                        //
                        //            while(obj3.next())
                        //            {
                            //                idtipocom=obj3.getInt("id_tipo_com");
                            //            }
                        //
                        //        }
                    //       detalle.setId_tipoCombus(idtipocom);
                    detalle.setKmTanqueo(Float.parseFloat(txt_km.getText()));
                    detalle.setDeta_obser(txta_obse2.getText());
                    daoDetalle.guardar(detalle);
                    limpiar();
                    LimpiarTabla();
                    detalleTabla();
                }
            }
            else
            {

                detalle.setId_ctrl_com(id_ctrl);
                detalle.setValeUTD(Integer.parseInt(txt_vale_utd.getText()));
                detalle.setReciboEstacion(txt_eds.getText());

                if( mes!=mesTan || year!=yearTan)
                {
                    throw new Exception("La fecha del tanqueo debe estar dentro del rango de la fecha del reporte");
                }

                detalle.setFechaTanqueo(fechaTan);
                detalle.setCantGal(Float.parseFloat(txt_cg.getText()));
                detalle.setVlorTanqueo(Integer.parseInt(txt_precio.getText()));

                vlorGas=(int) (detalle.getVlorTanqueo()/detalle.getCantGal());

                detalle.setVlorGaso(vlorGas);

                ResultSet obj1=conexion.executeQuery("SELECT det.kmtanq AS km FROM consumo_combustible.det_control_combustible det JOIN consumo_combustible.control_combustible ctrl ON ctrl.ctrl_com_id=det.ctrl_com_id WHERE ctrl.id_vehiculo="+id_vehiculo+" ORDER BY det.det_ctrl_com_id DESC limit 1");
                System.out.println(id_vehiculo);
                while (obj1.next())
                {
                    kilometraje=obj1.getFloat("km");
                    System.out.println(kilometraje);
                }

                if(kilometraje==0)
                {
                    System.out.println("Paso por aca pq km" + kilometraje );

                    parcial=0;
                    detalle.setParcialkm(parcial);
                    rend=0;
                    detalle.setRenmto(rend);

                }
                else
                {
                    parcial=Float.parseFloat(txt_km.getText())- kilometraje;

                    detalle.setParcialkm(parcial);

                    rend=parcial/Float.parseFloat(txt_cg.getText());
                    System.out.println(rend);
                    detalle.setRenmto(rend);
                }

                if(cb_eds.getSelectedItem()!= null)
                {
                    String eds=cb_eds.getSelectedItem().toString();

                    ResultSet obj2=conexion.executeQuery("SELECT est_ser_id FROM utilidades.estaciones_servicio WHERE est_ser_desc='"+eds+"'");

                    while (obj2.next())
                    {
                        ideds=obj2.getInt("est_ser_id");

                    }
                }

                detalle.setId_estacion(ideds);

                if(cb_no_km.isSelected()==true)
                {
                    detalle.setRenmto(0);
                    detalle.setParcialkm(0);
                    detalle.setKmTanqueo(0);
                    obse="El recibo le falta kilometraje / Hora ó esta mal diligenciado por el conductor";
                    detalle.setDeta_obser(obse);
                    daoDetalle.guardar(detalle);
                    limpiar();
                    LimpiarTabla();
                    detalleTabla();
                }else
                {

                    if(Float.parseFloat(txt_km.getText())<= kilometraje)
                    {
                        throw new Exception ("El kilometraje digitado no puede ser inferior a " + kilometraje+ " km");
                    }

                    //        if(cb_tc.getSelectedItem()!=null)
                    //        {
                        //            String combus=cb_tc.getSelectedItem().toString();
                        //
                        //            ResultSet obj3=conexion.executeQuery("SELECT id_tipo_com FROM utilidades.tipo_combustible WHERE name_combustible='"+combus+"'");
                        //
                        //            while(obj3.next())
                        //            {
                            //                idtipocom=obj3.getInt("id_tipo_com");
                            //            }
                        //
                        //        }
                    //        detalle.setId_tipoCombus(idtipocom);
                    detalle.setDeta_obser(txta_obse2.getText());

                    detalle.setKmTanqueo(Float.parseFloat(txt_km.getText()));

                    daoDetalle.guardar(detalle);
                    limpiar();
                    LimpiarTabla();
                    detalleTabla();
                }

            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Error "+e, "Error",JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void cb_no_kmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_no_kmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_no_kmActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
       JD_Detalle.pack();
       JD_Detalle.setLocationRelativeTo(null);
       JD_Detalle.setVisible(true);
       JD_Detalle.setResizable(false);
    }//GEN-LAST:event_btn_agregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_Detalle;
    private javax.swing.JDialog JD_ModDetalle;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_agregarvehi;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_guardar1;
    private javax.swing.JButton btn_terminar;
    private javax.swing.JComboBox cb_eds;
    private javax.swing.JComboBox cb_eds1;
    private javax.swing.JCheckBox cb_no_km;
    private javax.swing.JCheckBox cb_no_km1;
    private javax.swing.JComboBox cb_tc;
    private javax.swing.JComboBox cb_vehiculo;
    private com.toedter.calendar.JDateChooser dc_fechaTan;
    private com.toedter.calendar.JDateChooser dc_fechaTan1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private com.toedter.calendar.JMonthChooser mc_mes;
    private javax.swing.JPanel p_encabezado;
    private javax.swing.JTable t_detalle;
    private javax.swing.JTextField txt_cg;
    private javax.swing.JTextField txt_cg1;
    private javax.swing.JTextField txt_eds;
    private javax.swing.JTextField txt_eds1;
    private javax.swing.JTextField txt_id_ctrl;
    private javax.swing.JTextField txt_km;
    private javax.swing.JTextField txt_km1;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_precio1;
    private javax.swing.JTextField txt_vale_utd;
    private javax.swing.JTextField txt_vale_utd1;
    private javax.swing.JTextArea txta_obse;
    private javax.swing.JTextArea txta_obse2;
    private javax.swing.JTextArea txta_obse3;
    private com.toedter.calendar.JYearChooser yc_year;
    // End of variables declaration//GEN-END:variables

    public void cargarItemVehiculo()
    {
        ControllerItemList controller=new ControllerItemList();
        
        ArrayList lista=controller.listarItemVehiculo();
        
        cb_vehiculo.removeAllItems();
        if (lista!=null)
        {
            int size=lista.size();
            
            for(int i=0; i<size; i++)
            {
                cb_vehiculo.addItem(lista.get(i));
            }
        }
    }
    
       public static Date getPrimerDiaDelMes() {

        Calendar cal = Calendar.getInstance();

        cal.set(cal.get(Calendar.YEAR),

                cal.get(Calendar.MONTH),

                cal.getActualMinimum(Calendar.DAY_OF_MONTH),

                cal.getMinimum(Calendar.HOUR_OF_DAY),

                cal.getMinimum(Calendar.MINUTE),

                cal.getMinimum(Calendar.SECOND));
        return cal.getTime();


    }

 

    public static Date getUltimoDiaDelMes() {

        Calendar cal = Calendar.getInstance();

        cal.set(cal.get(Calendar.YEAR),

                cal.get(Calendar.MONTH),

              cal.getActualMaximum(Calendar.DAY_OF_MONTH),

                cal.getMaximum(Calendar.HOUR_OF_DAY),

                cal.getMaximum(Calendar.MINUTE),

                cal.getMaximum(Calendar.SECOND));

        return cal.getTime();

    }
    
    
     public void detalleTabla()
        {
       try
        {
            ConexionBD nueva=new ConexionBD();
            

            
           ResultSet obj=nueva.executeQuery("SELECT d.det_ctrl_com_id,d.valeutd,d.det_ctrl_com_rc_esta,d.fechatanq,d.det_ctrl_com_can_gal,d.kmtanq,d.valortanq,d.det_ctrl_com_obs,det_vlor_gaso,rendmto FROM consumo_combustible.control_combustible ctrl JOIN consumo_combustible.det_control_combustible d ON d.ctrl_com_id=ctrl.ctrl_com_id WHERE d.ctrl_com_id="+id_ctrl+" ORDER BY d.valeutd ASC");
            
            
            while (obj.next()) 
        {
        
        Object [] datos = new Object[10];
        
     
        for (int i=0;i<10;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
       
        }
           t_detalle.setModel(modelo);
            setCellRender(t_detalle);
           nueva.desconectar();

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
       
       
   }
     
     public void bloquear()
     {
        cb_vehiculo.setEnabled(false);
        txta_obse.setEnabled(false);
         cb_tc.setEnabled(false);
         mc_mes.setEnabled(false);
         yc_year.setEnabled(false);
         btn_editar.setEnabled(true);
         btn_eliminar.setEnabled(true);
         btn_terminar.setEnabled(true);
         
     }
     
     public void limpiar()
     {
         txt_vale_utd.setText("0");
         txt_eds.setText("000-000");
         dc_fechaTan.setDate(null);
         txt_cg.setText("0.00");
         txt_km.setText("0");
         txt_precio.setText("0");
         txta_obse2.setText("");
     }
     
     
     public void eliminarRegistroTabla()
    {
         ConexionBD nueva=new ConexionBD();
        
        //Verifica que la fila de la tabla esta seleccionada
        if(t_detalle.isRowSelected(t_detalle.getSelectedRow()))
        {
           int row = t_detalle.getSelectedRow();

        for(int i = 0; i < modelo.getRowCount(); i++)
        {
           nueva.executeUpdateQuery("DELETE FROM consumo_combustible.det_control_combustible WHERE det_ctrl_com_id="+modelo.getValueAt(row,0)+" ");

        }
         int numRows = t_detalle.getSelectedRows().length;
         
         for(int i = 0; i < numRows ; i++ )
         {
            modelo.removeRow(row);
         } 
          
        }         
 
     else
     {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un registro de la tabla para eliminarlo!."
         ,"Aviso", JOptionPane.WARNING_MESSAGE);
     }
          nueva.desconectar(); 
          LimpiarTabla();
          detalleTabla();  
    }
     
     
        public void LimpiarTabla()
    {
  
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
    }
        
        public void totalizador()
        {
            String nombre_eds="";
            float total_gal=0;
            float total_gal_sum=0;
            float total_km=0;
            int total_pesos=0;
            float rend_prom=0;
            float prom_hora=0;
            
            ConexionBD con=new ConexionBD();
            
            ResultSet obj=con.executeQuery("SELECT eds.est_ser_desc AS estacion, SUM(d.det_ctrl_com_can_gal)AS total_gal FROM consumo_combustible.det_control_combustible d JOIN utilidades.estaciones_servicio eds ON eds.est_ser_id=d.esta_ser_id WHERE d.ctrl_com_id="+id_ctrl+" GROUP BY eds.est_ser_desc");
            
       try {
           while (obj.next())
           {
               nombre_eds=obj.getString("estacion");
               total_gal=obj.getFloat("total_gal");
               
               con.executeUpdateQuery("INSERT INTO consumo_combustible.total_galones (estacion,t_gal_est,ctrl_com_id)VALUES('"+nombre_eds+"',"+total_gal+", "+id_ctrl+")");
           }
           
           ResultSet obj1=con.executeQuery("SELECT SUM(t_gal_est) AS total FROM consumo_combustible.total_galones WHERE ctrl_com_id="+id_ctrl+"");
           
           while (obj1.next())
           {
               total_gal_sum=obj1.getFloat("total");
           }
           
           ResultSet obj2=con.executeQuery("SELECT SUM(parcial_km)AS total_km, SUM(valortanq)AS total_pesos FROM consumo_combustible.det_control_combustible WHERE ctrl_com_id="+id_ctrl+"");
           
           while (obj2.next())
           {
               total_km=obj2.getFloat("total_km");
               total_pesos=obj2.getInt("total_pesos");
           }
           rend_prom=total_km/total_gal_sum;
           if(total_km==0)
           {
              prom_hora=0; 
              
                con.executeUpdateQuery("INSERT INTO consumo_combustible.total_control_combustible (t_ctrl_com_total_km,t_ctrl_com_rend_km_gal,t_ctrl_com_total_pesos,t_ctrl_com_ren_hora,ctrl_id)VALUES("+total_km+", "+rend_prom+","+total_pesos+","+prom_hora+","+id_ctrl+")");
                con.executeUpdateQuery("UPDATE consumo_combustible.control_combustible SET totalizado=true WHERE ctrl_com_id="+id_ctrl+"");
           
                con.desconectar();
           }
           else
           {
           
                prom_hora=total_pesos/total_km;
           
                con.executeUpdateQuery("INSERT INTO consumo_combustible.total_control_combustible (t_ctrl_com_total_km,t_ctrl_com_rend_km_gal,t_ctrl_com_total_pesos,t_ctrl_com_ren_hora,ctrl_id)VALUES("+total_km+", "+rend_prom+","+total_pesos+","+prom_hora+","+id_ctrl+")");
                con.executeUpdateQuery("UPDATE consumo_combustible.control_combustible SET totalizado=true WHERE ctrl_com_id="+id_ctrl+"");
           
                con.desconectar();
           
           }
           
       } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex,"Error", JOptionPane.ERROR_MESSAGE);
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
