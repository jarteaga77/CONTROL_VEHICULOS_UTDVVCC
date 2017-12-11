
package com.syscv.utd.presentacion;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.costos.Costos_mto_externos;
import com.syscv.utd.costos.Dao_costos_fac_mto_externo;
import com.syscv.utd.dao.ctrlcom.documentos.ManejoImagen;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.syscv.utd.recursos.JPColor;
import com.syscv.utd.entidades.ControllerItemList;
import com.syscv.utd.entidades.TallerExterno;
import com.syscv.utd.entidades.Vehiculo;
import com.syscv.utd.reportes.ReporteCostosFactExterno;
import java.awt.event.KeyEvent;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Jonathan
 */
public class JIFControlFacturasMtoExternos extends javax.swing.JInternalFrame {

   private ConexionBD conexion=new ConexionBD();
   private int id_costo;
   private int idusuario=MDIPrincipal.getvSeccion();
   private Costos_mto_externos costos;
   private Dao_costos_fac_mto_externo daocostos;
   private Double totalfact;
   private Double subtotal,descuento,vloriva,base_iva;
   private String iva;
   
   
   
   private int id_vehiculo=0;
   private int id_proveedor=0;
   SimpleDateFormat formato = new SimpleDateFormat ("yyyy/MM/dd"); 
   private int id_tabla=0;
   private int mes,year;
   private ManejoImagen mi=new ManejoImagen();
   private ReporteCostosFactExterno reporte;

   

   
   private DefaultTableModel modelo;
   
  
    public JIFControlFacturasMtoExternos() {
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
            cargarItemProveedor();
            
            dc_fecha_fact.setDate(new Date());
        
        
       ResultSet obj=conexion.executeQuery("SELECT MAX(id_cos_fact)+1 as id  FROM mantenimientos_mecanica.cos_fact_mto_ext");
       
       while(obj.next())
       {
           txt_id_costos.setText(String.valueOf(obj.getInt("id")));//Le asigna el consecutivo siguiente de orden compra al textfield
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
        modelo.addColumn("Vehiculo / Equipo");
        modelo.addColumn("OC");
        modelo.addColumn("Fecha Factura");
        modelo.addColumn("N° Factura");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Concepto");
        modelo.addColumn("Subtotal");
        modelo.addColumn("Descuento");
        modelo.addColumn("IVA");
        modelo.addColumn("Valor Iva");
        modelo.addColumn("Total");
        
        
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
        JD_Detalle = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        cb_vehiculo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbx_proveedor = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_a_concepto = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_vlorIva = new javax.swing.JTextField();
        cbx_iva = new javax.swing.JComboBox<>();
        txt_descuento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_bse_iva = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        dc_fecha_fact = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_factura = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_oc = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        p_encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_id_costos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta_obse = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        mc_mes = new com.toedter.calendar.JMonthChooser();
        yc_year = new com.toedter.calendar.JYearChooser();
        jLabel30 = new javax.swing.JLabel();
        btn_en = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        t_detalle = new javax.swing.JTable();
        btn_eliminar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lb_total = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lb_sub = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lb_dcto = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lb_iva = new javax.swing.JLabel();
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

        JD_Detalle.setTitle("Detalle Factura");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        jLabel34.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel34.setText("Vehiculo / Equipo *");

        btn_guardar.setText("Agregar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(153, 0, 0));
        jLabel43.setText("* Campos Obligatorios");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Proveedor *");

        txt_a_concepto.setColumns(20);
        txt_a_concepto.setRows(5);
        jScrollPane3.setViewportView(txt_a_concepto);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Concepto *");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("Vlor. IVA");

        txt_vlorIva.setEditable(false);
        txt_vlorIva.setText("0");
        txt_vlorIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vlorIvaActionPerformed(evt);
            }
        });

        cbx_iva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "5%", "8%", "19%" }));
        cbx_iva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_ivaActionPerformed(evt);
            }
        });

        txt_descuento.setText("0");
        txt_descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descuentoKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("IVA *");

        txt_subtotal.setText("0");
        txt_subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_subtotalActionPerformed(evt);
            }
        });
        txt_subtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_subtotalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_subtotalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_subtotalKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Descuento *");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Subtotal *");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 0, 0));
        jLabel13.setText("TOTAL FACTURA");

        txt_total.setEditable(false);
        txt_total.setBackground(new java.awt.Color(255, 255, 204));
        txt_total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt_total.setForeground(new java.awt.Color(0, 0, 51));
        txt_total.setText("0");
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Base IVA *");

        txt_bse_iva.setText("0");
        txt_bse_iva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_bse_ivaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_vlorIva, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txt_bse_iva)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_descuento)
                            .addComponent(cbx_iva, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txt_bse_iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbx_iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_vlorIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Orden de Compra *");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Fecha Factura *");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("N° Factura *");

        txt_oc.setText("0");
        txt_oc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ocKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txt_oc))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(dc_fecha_fact, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txt_factura, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dc_fecha_fact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_oc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
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
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbx_proveedor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_vehiculo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(cb_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbx_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_guardar)
                            .addComponent(jLabel43)
                            .addComponent(btn_cancelar))))
                .addContainerGap())
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
        setTitle("Control Facturas Vehiculos / Equipos --UTDVVCC--");

        p_encabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("CONTROL FACTURAS VEHICULOS / EQUIPOS");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/folder_.png"))); // NOI18N

        javax.swing.GroupLayout p_encabezadoLayout = new javax.swing.GroupLayout(p_encabezado);
        p_encabezado.setLayout(p_encabezadoLayout);
        p_encabezadoLayout.setHorizontalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_encabezadoLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(263, 263, 263))
        );
        p_encabezadoLayout.setVerticalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_encabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("General"));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("ID  *");

        txt_id_costos.setEditable(false);
        txt_id_costos.setBackground(new java.awt.Color(204, 204, 0));
        txt_id_costos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_id_costos.setForeground(new java.awt.Color(0, 0, 51));
        txt_id_costos.setText("?");
        txt_id_costos.setToolTipText("Campo Obligatorio No editable");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Observaciones ");

        txta_obse.setColumns(20);
        txta_obse.setRows(5);
        jScrollPane1.setViewportView(txta_obse);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 0, 0));
        jLabel19.setText("* Campos Obligatorios");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setText("Fecha *");

        btn_en.setText("Guardar");
        btn_en.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enActionPerformed(evt);
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_id_costos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(mc_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(yc_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_en)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(yc_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mc_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_id_costos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_en)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        t_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(t_detalle);

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
        btn_agregar.setEnabled(false);
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel14.setText("TOTAL MES $");

        lb_total.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        lb_total.setText("VALOR");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel16.setText("SUBTOTAL $");

        lb_sub.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        lb_sub.setText("VALOR");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel18.setText("TOTAL DCTO. $");

        lb_dcto.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        lb_dcto.setText("VALOR");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel22.setText("TOTAL IVA $");

        lb_iva.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        lb_iva.setText("VALOR");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(46, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(lb_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(lb_dcto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(lb_iva, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(lb_total, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_agregar)
                    .addComponent(btn_eliminar))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btn_agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(lb_sub))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(lb_dcto))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(lb_iva))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(lb_total)))
                .addGap(0, 11, Short.MAX_VALUE))
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
                .addComponent(p_encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btn_terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_terminarActionPerformed
                 int opc=JOptionPane.showConfirmDialog(null,"Desea concluir el registro facturas externos?", "Aviso!", JOptionPane.YES_NO_OPTION); 
          
        if(opc==JOptionPane.YES_OPTION)
        {
            
        if(t_detalle.getRowCount()== 0 && t_detalle.getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(null, "La tabla Detalle no contiene ningun registro!");
            
        }
        else 
        {
            
    
            
            reporte=new ReporteCostosFactExterno();
            reporte.ejecutarReporte(id_costo);
            
            
         
          
           this.dispose();
           
        }
       }  

    }//GEN-LAST:event_btn_terminarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
       JD_Detalle.pack();
       JD_Detalle.setLocationRelativeTo(null);
       JD_Detalle.setVisible(true);
       JD_Detalle.setResizable(false);
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_enActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enActionPerformed
       try
       {

        mes=mc_mes.getMonth()+1;
        year=yc_year.getYear();
        
        int idyear=0;
        
        ResultSet obj=conexion.executeQuery("SELECT id_year FROM utilidades.year WHERE year="+year+"");

                while (obj.next())
                {
                    idyear=obj.getInt("id_year");
                }
                
                
         costos=new Costos_mto_externos();
         
         costos.setObse(txta_obse.getText());
         costos.setId_mes(mes);
         costos.setId_anio(idyear);
         costos.setId_usuario(idusuario);
         
         daocostos=new Dao_costos_fac_mto_externo();
         daocostos.guardar(costos);
         
         id_costo=Dao_costos_fac_mto_externo.getId_cost_fact();
         txt_id_costos.setText(String.valueOf(id_costo));
         bloquear();
         btn_agregar.setEnabled(true);
         
         

       }catch (Exception e)
       {
           JOptionPane.showMessageDialog(rootPane, e);
       }
        
        
    }//GEN-LAST:event_btn_enActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        try
        {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new FileNameExtensionFilter("Archivo de Imagen","jpg") );
        fileChooser.setCurrentDirectory(new java.io.File("e:/imagenes_tmp/"));
        int result = fileChooser.showOpenDialog(null);
        if ( result == JFileChooser.APPROVE_OPTION ){
            //obtiene ruta y nombre del archivo
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            String name = fileChooser.getSelectedFile().getName();
            
            Vehiculo v=(Vehiculo) cb_vehiculo.getSelectedItem();
            id_vehiculo=v.getId_vehiculo();     
            TallerExterno t=(TallerExterno)cbx_proveedor.getSelectedItem();
            id_proveedor=t.getId();
            
            
            Date fecha=dc_fecha_fact.getDate();           
            java.sql.Date sqlFecha_fact = new java.sql.Date(fecha.getTime());
            int oc_=Integer.parseInt(txt_oc.getText());
            String concepto=txt_a_concepto.getText();
            String factura=txt_factura.getText();
            
            
            if(concepto.equals("") || factura.equals("") || oc_==0)
            {
                throw new Exception("Campos Obligatorios.");
            }
            
              
                            
                if( mi.guardarDt_costos(GenerarCodigo() , name, ruta, id_vehiculo, id_costo,sqlFecha_fact,factura,id_proveedor,concepto,subtotal, descuento, vloriva, totalfact, iva, oc_ ) )
                {
                    JOptionPane.showMessageDialog(this,"Documento ["+name+"] almacenado");
                    
                    LimpiarTabla();
                    detalleTabla();
                    sumaCampos();
                    limpiar();
                    btn_terminar.setEnabled(true);
                   
                    
                 
                }
        }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex, "Error",JOptionPane.ERROR_MESSAGE);
            }
        
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_vlorIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_vlorIvaActionPerformed
        
        
       
        
       
    }//GEN-LAST:event_txt_vlorIvaActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
//         iva=(String) cbx_iva.getSelectedItem();
//        
//        subtotal=Double.parseDouble(txt_bse_iva.getText());
//        descuento=Double.parseDouble(txt_descuento.getText());
//        
//        
//        if(iva.equals("0%"))
//        {
//            totalfact=subtotal - descuento;
//            txt_total.setText(String.valueOf(totalfact));
//        }
//        
//        if(iva.equals("5%"))
//        {
//           vloriva=subtotal * 0.05;
//           txt_vlorIva.setText(String.valueOf(vloriva));
//           totalfact=(subtotal - descuento) + vloriva;
//           txt_total.setText(String.valueOf(totalfact));
//        }
//       
//        if(iva.equals("8%"))
//        {
//           vloriva=subtotal * 0.08;
//           txt_vlorIva.setText(String.valueOf(vloriva));
//           totalfact=(subtotal - descuento) + vloriva;
//            txt_total.setText(String.valueOf(totalfact));        }
//        if(iva.equals("19%"))
//        {
//           vloriva=subtotal * 0.19;
//           txt_vlorIva.setText(String.valueOf(vloriva));
//           totalfact=(subtotal - descuento) + vloriva;
//           txt_total.setText(String.valueOf(totalfact));
//        }
    }//GEN-LAST:event_txt_totalActionPerformed

    private void cbx_ivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_ivaActionPerformed
         iva=(String) cbx_iva.getSelectedItem();
        
        subtotal=Double.parseDouble(txt_subtotal.getText());
        base_iva=Double.parseDouble(txt_bse_iva.getText());
        descuento=Double.parseDouble(txt_descuento.getText());
        
        
        if(iva.equals("0%"))
        {
            vloriva=0.0;
            totalfact=subtotal - descuento;
            txt_total.setText(String.valueOf(totalfact));
            txt_vlorIva.setText(String.valueOf(vloriva));
            
        }
        
        if(iva.equals("5%"))
        {
           subtotal=subtotal - descuento;
           vloriva=base_iva * 0.05;
           txt_vlorIva.setText(String.valueOf(vloriva));
           totalfact=subtotal + vloriva;
           txt_total.setText(String.valueOf(totalfact));
        
        }
       
        if(iva.equals("8%"))
        {
            subtotal=subtotal - descuento;
           vloriva=base_iva * 0.08;
           txt_vlorIva.setText(String.valueOf(vloriva));
           totalfact=subtotal + vloriva;
           txt_total.setText(String.valueOf(totalfact));
        }
        if(iva.equals("19%"))
        {   
           subtotal=subtotal - descuento;
           vloriva=base_iva * 0.19;
           txt_vlorIva.setText(String.valueOf(vloriva));
           totalfact=subtotal + vloriva;
           txt_total.setText(String.valueOf(totalfact));
        }
    }//GEN-LAST:event_cbx_ivaActionPerformed

    private void txt_subtotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_subtotalKeyTyped
       int k=(int)evt.getKeyChar();
                if (k >= 97 && k <= 122 || k>=65 && k<=90)
             {
                 evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                 JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
               }
                    if(k==241 || k==209){
                        evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                        JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
                    }
                        if(k==10){
                        txt_subtotal.transferFocus();
                        }
    }//GEN-LAST:event_txt_subtotalKeyTyped

    private void txt_descuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descuentoKeyTyped
        int k=(int)evt.getKeyChar();
                if (k >= 97 && k <= 122 || k>=65 && k<=90)
             {
                 evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                 JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
               }
                    if(k==241 || k==209){
                        evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                        JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
                    }
                        if(k==10){
                        txt_vlorIva.transferFocus();
                        }
    }//GEN-LAST:event_txt_descuentoKeyTyped

    private void txt_ocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ocKeyTyped
        int k=(int)evt.getKeyChar();
                if (k >= 97 && k <= 122 || k>=65 && k<=90)
             {
                 evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                 JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
               }
                    if(k==241 || k==209){
                        evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                        JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
                    }
                        if(k==10){
                        txt_oc.transferFocus();
                        }
    }//GEN-LAST:event_txt_ocKeyTyped

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        JD_Detalle.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_subtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_subtotalActionPerformed
   
    }//GEN-LAST:event_txt_subtotalActionPerformed

    private void txt_bse_ivaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bse_ivaKeyTyped
        int k=(int)evt.getKeyChar();
                if (k >= 97 && k <= 122 || k>=65 && k<=90)
             {
                 evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                 JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
               }
                    if(k==241 || k==209){
                        evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                        JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
                    }
                        if(k==10){
                        txt_bse_iva.transferFocus();
                        }
    }//GEN-LAST:event_txt_bse_ivaKeyTyped

    private void txt_subtotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_subtotalKeyPressed
     
    }//GEN-LAST:event_txt_subtotalKeyPressed

    private void txt_subtotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_subtotalKeyReleased
            double base=0;
       
       base=Double.parseDouble(txt_subtotal.getText());
       txt_bse_iva.setText("");
       txt_bse_iva.setText(String.valueOf(base));
    }//GEN-LAST:event_txt_subtotalKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_Detalle;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_en;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_terminar;
    private javax.swing.JComboBox cb_vehiculo;
    private javax.swing.JComboBox<String> cbx_iva;
    private javax.swing.JComboBox cbx_proveedor;
    private com.toedter.calendar.JDateChooser dc_fecha_fact;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lb_dcto;
    private javax.swing.JLabel lb_iva;
    private javax.swing.JLabel lb_sub;
    private javax.swing.JLabel lb_total;
    private com.toedter.calendar.JMonthChooser mc_mes;
    private javax.swing.JPanel p_encabezado;
    private javax.swing.JTable t_detalle;
    private javax.swing.JTextArea txt_a_concepto;
    private javax.swing.JTextField txt_bse_iva;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_factura;
    private javax.swing.JTextField txt_id_costos;
    private javax.swing.JTextField txt_oc;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_vlorIva;
    private javax.swing.JTextArea txta_obse;
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
    
    
     public void cargarItemProveedor()
    {
        ControllerItemList controller=new ControllerItemList();
        
        ArrayList lista=controller.listarItemProveedor();
        
        cbx_proveedor.removeAllItems();
        if (lista!=null)
        {
            int size=lista.size();
            
            for(int i=0; i<size; i++)
            {
                cbx_proveedor.addItem(lista.get(i));
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
            

            
           ResultSet obj=nueva.executeQuery("SELECT d.id_dt,v.placa_identi,d.oc_,d.fecha_fact,d.fact_num,p.razon_social,d.concepto,d.subtotal,d.descuento,d.iva, d.vlor_iva, d.total FROM mantenimientos_mecanica.dt_cos_fact_mto_ext d "
                   + " JOIN utilidades.vehiculos_equipos v ON d.id_vehiculo=v.id_vehiculo "
                   + " JOIN utilidades.talleres_externos_mec p ON p.id=d.id_proveedor WHERE d.id_fact_mto_ex="+id_costo+" ORDER BY d.id_dt ASC");
            
            
            while (obj.next()) 
        {
        
        Object [] datos = new Object[12];
        
     
        for (int i=0;i<12;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
       
        }
           t_detalle.setModel(modelo);
           
           
        TableColumnModel columnModel =t_detalle.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(5);
        columnModel.getColumn(1).setPreferredWidth(30);
        columnModel.getColumn(2).setPreferredWidth(10);
        columnModel.getColumn(3).setPreferredWidth(30);
        columnModel.getColumn(4).setPreferredWidth(40);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(30);
        columnModel.getColumn(8).setPreferredWidth(30);
        columnModel.getColumn(9).setPreferredWidth(20);
        columnModel.getColumn(10).setPreferredWidth(30);
        columnModel.getColumn(11).setPreferredWidth(30);
           
            setCellRender(t_detalle);
           nueva.desconectar();

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
       
       
   }
     
     public void bloquear()
     {
        txta_obse.setEnabled(false);
         mc_mes.setEnabled(false);
         yc_year.setEnabled(false);
         btn_en.setEnabled(false);
         btn_eliminar.setEnabled(true);
         btn_terminar.setEnabled(true);
         
     }
     
     public void limpiar()
     {
        
         dc_fecha_fact.setDate(new Date());
         txt_factura.setText("");
         txt_oc.setText("");
         txt_subtotal.setText("0");
         txt_vlorIva.setText("0");
         txt_total.setText("0");
         txt_descuento.setText("0");
         txt_a_concepto.setText("");
         
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
           nueva.executeUpdateQuery("DELETE FROM mantenimientos_mecanica.dt_cos_fact_mto_ext WHERE id_dt="+modelo.getValueAt(row,0)+" ");

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
          sumaCampos();
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
        
        
    //Genera un código unico para la imagen
    private String GenerarCodigo()
    {
        SimpleDateFormat sdf= new SimpleDateFormat("hhmmss");
        return sdf.format(new Date());
    }
        
     public void sumaCampos()
       {
           double subtotal=0;
           double vlordcto=0;
           double vlorIva=0;
           double total=0;
           
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setPerMill('.');
            java.text.DecimalFormat formato = new java.text.DecimalFormat("#,##0.00",dfs);

           
           
           for(int i=0; i<t_detalle.getRowCount(); i++)
           {
               subtotal+=(double) t_detalle.getValueAt(i, 7);
               vlordcto+=(double) t_detalle.getValueAt(i, 8);
               vlorIva+=(double) t_detalle.getValueAt(i, 10);
               total+=(double) t_detalle.getValueAt(i,11);
           }
           
          lb_sub .setText(formato.format(subtotal));
          lb_dcto.setText(formato.format(vlordcto));
          lb_iva.setText(formato.format(vlorIva));
          lb_total.setText(formato.format(total));
          
          conexion.executeUpdateQuery("UPDATE mantenimientos_mecanica.cos_fact_mto_ext SET total_fact="+total+" WHERE id_cos_fact="+id_costo+"");
          conexion.desconectar();

       }
            


}
