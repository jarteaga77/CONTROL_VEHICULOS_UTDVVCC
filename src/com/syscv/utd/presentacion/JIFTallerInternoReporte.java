/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.presentacion;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.ControllerItemList;
import com.syscv.utd.entidades.Vehiculo;
import com.syscv.utd.recursos.JPColor;
import com.syscv.utd.reportes.InformeTallerInterno;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
/**
 *
 * @author jarteaga
 */
public class JIFTallerInternoReporte extends javax.swing.JInternalFrame {

   
    private DefaultTableModel modelo;
    private InformeTallerInterno informe;
    
    
    public JIFTallerInternoReporte() {
        initComponents();
        
        Color c1=new Color(66,111,166);
        Color c2=new Color(102,174,118);
        JPColor miColor=new JPColor(c1,c2);
        miColor.setSize(this.getSize());
        p_encabezado.add(miColor);
        
        dtc_fechaIni.setDate(new Date());
        dtc_final.setDate(new Date());
        
       modelo=new DefaultTableModel();
       
       
       modelo.addColumn("Fecha");
       modelo.addColumn("ID");
       modelo.addColumn("ID X Vehiculo"); 
       modelo.addColumn("Placa");
       modelo.addColumn("vehiculo / Equipo");
       modelo.addColumn("Tipo");
   
       modelo.addColumn("Km Entrada");
       modelo.addColumn("Km Proximo Mto");
       modelo.addColumn("Horas Uso");
       modelo.addColumn("Tipo Mto.");
       modelo.addColumn("Rutina");
       modelo.addColumn("Mecánico");
       modelo.addColumn("Concepto");

        
        cargarItemVehiculo();
        
        detalleTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        p_encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        dtc_fechaIni = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dtc_final = new com.toedter.calendar.JDateChooser();
        cbx_todos = new javax.swing.JCheckBox();
        cb_vehiculo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        rb_pdf = new javax.swing.JRadioButton();
        rb_xls = new javax.swing.JRadioButton();
        btn_exportar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_detalle = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Reporte PDF-EXcel - Mto. Taller Interno -- UTDVVCC");

        p_encabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("Reporte  Taller Interno");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/taller_int_1.png"))); // NOI18N

        javax.swing.GroupLayout p_encabezadoLayout = new javax.swing.GroupLayout(p_encabezado);
        p_encabezado.setLayout(p_encabezadoLayout);
        p_encabezadoLayout.setHorizontalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_encabezadoLayout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_encabezadoLayout.setVerticalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_encabezadoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(p_encabezadoLayout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Generar Reporte PDF - Excel - Rango de Fechas"));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Fecha Inicial");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Fecha Final");

        cbx_todos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbx_todos.setSelected(true);
        cbx_todos.setText("Todos");
        cbx_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_todosActionPerformed(evt);
            }
        });

        cb_vehiculo.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Vehiculo / Equipo");

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_pdf);
        rb_pdf.setSelected(true);
        rb_pdf.setText("PDF");

        buttonGroup1.add(rb_xls);
        rb_xls.setText("XLS");

        btn_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/exportar.png"))); // NOI18N
        btn_exportar.setText("Exportar");
        btn_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtc_fechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtc_final, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbx_todos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_vehiculo, 0, 388, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_buscar)
                        .addGap(18, 18, 18)
                        .addComponent(rb_pdf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_xls)
                        .addGap(18, 18, 18)
                        .addComponent(btn_exportar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dtc_final, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbx_todos)
                            .addComponent(cb_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dtc_fechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_buscar)
                    .addComponent(rb_pdf)
                    .addComponent(rb_xls)
                    .addComponent(btn_exportar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_detalle);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p_encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_todosActionPerformed
       if (cbx_todos.isSelected())
       {
           cb_vehiculo.setEnabled(false);
       }
       else
       {
           cb_vehiculo.setEnabled(true);
       }
    }//GEN-LAST:event_cbx_todosActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
       try {
        
        int id_vehiculo;
        Date fecha_ini, fecha_fin;
       
        
        
        if(dtc_fechaIni.equals("") && dtc_final.equals(""))
        {
            
                throw new Exception("Los campos fecha son obligatorios");
           
        }
        
        fecha_ini=dtc_fechaIni.getDate();
        fecha_fin=dtc_final.getDate();
        
        if(fecha_fin.before(fecha_ini))
        {
            throw new Exception("La fecha Final no debe ser inferior a la fecha Inicial de los parametros de busqueda");
        }
        
        
        if(cbx_todos.isSelected())
        {
           LimpiarTabla();
           todosxfecha(fecha_ini, fecha_fin);
        }
        else
        {
             Vehiculo v=(Vehiculo) cb_vehiculo.getSelectedItem();
             id_vehiculo=v.getId_vehiculo();
             
             LimpiarTabla();
             filvehiculofecha(fecha_ini, fecha_fin, id_vehiculo);
        }
        
         } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportarActionPerformed
    
 try {   
        
      String nom_us="";
      Date fecha_ini,fecha_fin;
      int id_vehiculo=0;
      String nom_vehiculo="";
      informe=new InformeTallerInterno();
      
     
     if(rb_xls.isSelected())
     {
                 //creamos un filtro de archivos para definir que archivos ver en el JFileChooser
        javax.swing.filechooser.FileNameExtensionFilter filterXls = new javax.swing.filechooser.FileNameExtensionFilter("Documentos MS Excel 95/2003", "xls");
 
        //instanciamos una ventana de seleccion de archivo
        final JFileChooser fc = new JFileChooser();
 
        //agregamos el filtro al filechooser
        fc.setFileFilter(filterXls);
 
        //capturamos la respuesta del usuario
        int returnVal = fc.showSaveDialog(null);
 
        //definimos el comportamiento de la ventana
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
 
        if (returnVal == JFileChooser.APPROVE_OPTION) {
 
            //@SuppressWarnings("UnusedAssignment")
            FileOutputStream fileOut = null;
           // @SuppressWarnings("UnusedAssignment")
            File fileXLS = null;
          
                //Creamos un objeto archivo con la ruta seleccionada
                fileXLS = fc.getSelectedFile();
 
 //Validamos si en la ruta el archivo se ha especificado la extensión
                String name = fileXLS.getName();
                if (name.indexOf('.') == -1) {
       //De no ser asi le agregamos
                    name += ".xls";
                    fileXLS = new File(fileXLS.getParentFile(), name);
                }
                fileOut = new FileOutputStream(fileXLS);
            
                     //Creamos la cabecera
                final String[] headers = {"FECHA", "ID MTO, INTERNO", "CONSECUTIVO VEHICULO / EQUIPO","PLACA", "VEHICULO / EQUIPO","TIPO VEHICULO","KM ENTRADA", "KM PROX. MTO", "HORAS USO","TIPO MTO.", "RUTINA","MECÁNICO","CONCEPTO"};
                
                
                HSSFWorkbook wb = new HSSFWorkbook();
                HSSFSheet sheet = wb.createSheet("REPORTE MTO INTERNOS");
                HSSFRow rowhead = sheet.createRow(0);
                
                //Definimos el estilo de la cabecera
                CellStyle headerStyle = wb.createCellStyle();
  //Color de fondo
                headerStyle.setFillBackgroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
  //Estilo de la fuente
                Font hfont = wb.createFont();
                hfont.setBoldweight(Font.BOLDWEIGHT_BOLD);
                headerStyle.setFont(hfont);
  //Alineacion Horizontal
                headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
                // Creamos una fila, las filas empiezan en 0
                Row titleRow = sheet.createRow((short) 0);
  //Creamos una celda para nuestra fila
                Cell hCell = titleRow.createCell((short) 0);               

                Row row = sheet.createRow((short) 0);
 /**
  Creamos nuestras celdas de acuerdo a nuestro array headers
  Por cada cabecera creamos una celda y le asignamos el estilo.
 */
                for (int i = 0; i < headers.length; i++) { 
                    Cell cell = row.createCell(i);
                    cell.setCellValue(headers[i]);
                    cell.setCellStyle(headerStyle);
  //Asigna automaticamente el tamaño
                    sheet.autoSizeColumn(i);
                }
              
//                Obtiene el nombre de cabecera de las columnas      
//                for(int i = 0; i < jt_tabla_orden.getColumnCount(); i++)
//                {
//                 rowhead.createCell(i).setCellValue(jt_tabla_orden.getColumnName(i));
//                }  
                    
                //Cremos la fila y columna que contenga la JTable
                    for(int fil=1; fil<=tb_detalle.getRowCount(); fil++)
                    {    
                
                        rowhead = sheet.createRow(fil);
                        for(int col=0; col<tb_detalle.getColumnCount(); col++)
                        {
                        rowhead.createCell(col).setCellValue(String.valueOf(tb_detalle.getValueAt(fil -1 , col)));
                        }
                    }
 
                for (int i = 0; i < headers.length; i++) {
                    sheet.autoSizeColumn(i);
                }
// // Escribimos el libro
                
                 wb.write(fileOut);
              
                fileOut.close(); 
           
        }

    }
     if(rb_pdf.isSelected())
     {
         if(cbx_todos.isSelected())
         {
             if(dtc_fechaIni.equals("") || dtc_final.equals(""))
             {
                 throw new Exception("Los campos de fecha no pueden estar vacios");
             }
             
             fecha_ini=dtc_fechaIni.getDate();
             fecha_fin=dtc_final.getDate();
             nom_us=MDIPrincipal.getvSeccionNom();
             
             if(fecha_fin.before(fecha_ini))
             {
               throw new Exception("La Fecha inicial no puede ser inferior a la Fecha Inicial");

             }
             
            
             
             System.out.println("Paso por aca");
             informe.ejecutarReporte(fecha_ini, fecha_fin, nom_us);
                
         }
     else
     {
           if(dtc_fechaIni.equals("") || dtc_final.equals(""))
             {
                 throw new Exception("Los campos de fecha no pueden estar vacios");
             }
             
             fecha_ini=dtc_fechaIni.getDate();
             fecha_fin=dtc_final.getDate();
             nom_us=MDIPrincipal.getvSeccionNom();
             
             Vehiculo v=(Vehiculo) cb_vehiculo.getSelectedItem();
             id_vehiculo=v.getId_vehiculo();
             nom_vehiculo=v.getNombreVehiculo();
             
            // nom_vehiculo=(String) cb_vehiculo.getSelectedItem();
             
             if(fecha_fin.before(fecha_ini))
             {
               throw new Exception("La Fecha inicial no puede ser inferior a la Fecha Inicial");

             }
             System.out.println("Paso por aca 2");
             informe.ejecutarReporteFil(fecha_ini, fecha_fin, nom_us, id_vehiculo,nom_vehiculo);
     }
  }   
      } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex, "Error",JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_btn_exportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_exportar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cb_vehiculo;
    private javax.swing.JCheckBox cbx_todos;
    private com.toedter.calendar.JDateChooser dtc_fechaIni;
    private com.toedter.calendar.JDateChooser dtc_final;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel p_encabezado;
    private javax.swing.JRadioButton rb_pdf;
    private javax.swing.JRadioButton rb_xls;
    private javax.swing.JTable tb_detalle;
    // End of variables declaration//GEN-END:variables

  public void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRenderer());
        }
      }
    
    
    
    
     public void cargarItemVehiculo()
    {
        ControllerItemList control=new ControllerItemList();
        
        ArrayList lista=control.listarItemVehiculo();
        
        if (lista!=null)
        {
            int size=lista.size();
            
            for(int i=0; i<size; i++)
            {
                cb_vehiculo.addItem(lista.get(i));
            }
        }
    }
     
     
      // Metodo para llenar la tabla detalle
       public void detalleTabla()
        {
       try
        {
            ConexionBD nueva=new ConexionBD();
            
            ResultSet obj=nueva.executeQuery("SELECT mto.fecha_reg,mto.id_mto_interno,mto.consecutivo_vehiculo,ve.placa_identi,(mar.descripcion ||'-'||li.descripcion)AS vehiculo,tv.descripcion, mto.km_llegada, mto.km_proximo_mto,mto.horas_uso, tipo.descripcion, rut.descripcion, mec.nombre_apellido, string_agg(lab.labor, ',' ) AS concepto\n" +
"\n" +
"FROM mantenimientos_mecanica.mto_internos mto JOIN mantenimientos_mecanica.dt_mto_interno dt ON mto.id_mto_interno=dt.id_mto_interno\n" +
"JOIN utilidades.vehiculos_equipos ve ON ve.id_vehiculo=mto.id_vehiculo\n" +
"JOIN utilidades.rutina rut ON rut.id_rutina=mto.id_rutina\n" +
"JOIN utilidades.linea_vehiculo li ON li.id_linea_vehi=ve.id_linea\n" +
"JOIN utilidades.marca_vehiculo mar ON mar.id_marca=li.id_marca\n" +
"JOIN utilidades.tipo_vehiculo tv ON tv.id_tipo_vehi=ve.id_tipo_vehiculo\n" +
"JOIN utilidades.tipo_mto tipo ON tipo.id_tipo_mto=mto.id_tipo_mto\n" +
"JOIN utilidades.mecanico_utd mec ON mec.id_meca=mto.id_mecanico\n" +
"JOIN utilidades.labor_mecanico lab ON lab.id_labor=dt.id_labor_mec\n" +
"\n" +
" GROUP BY mto.fecha_reg,mto.id_mto_interno,ve.placa_identi,mar.descripcion,li.descripcion,tv.descripcion,tipo.descripcion,rut.descripcion, mec.nombre_apellido "
                    + "ORDER BY mto.fecha_reg,vehiculo ASC");
            
            
            
            while (obj.next()) 
        {
        
        Object [] datos = new Object[13];
        
     
        for (int i=0;i<13;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
       
        }
            
        tb_detalle.setModel(modelo);
            
        TableColumnModel columnModel =tb_detalle.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(1);
        columnModel.getColumn(2).setPreferredWidth(1);
        columnModel.getColumn(3).setPreferredWidth(10);
        columnModel.getColumn(4).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(20);   
        columnModel.getColumn(6).setPreferredWidth(20);
        columnModel.getColumn(7).setPreferredWidth(20);
        columnModel.getColumn(8).setPreferredWidth(20);
        columnModel.getColumn(9).setPreferredWidth(20);
        columnModel.getColumn(10).setPreferredWidth(20);
        columnModel.getColumn(11).setPreferredWidth(20);
        columnModel.getColumn(12).setPreferredWidth(100);
        
           
            setCellRender(tb_detalle);
           nueva.desconectar();
       

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }



        }
     
    

       public void todosxfecha(Date fechaIni, Date fechaFin)
        {
       try
        {
            ConexionBD nueva=new ConexionBD();
            
            ResultSet obj=nueva.executeQuery("SELECT mto.fecha_entrada,mto.id_mto_interno,mto.consecutivo_vehiculo,ve.placa_identi,(mar.descripcion ||'-'||li.descripcion)AS vehiculo,tv.descripcion, mto.km_llegada, mto.km_proximo_mto,mto.horas_uso, tipo.descripcion, rut.descripcion, mec.nombre_apellido, string_agg(lab.labor, ',' ) AS concepto\n" +
"\n" +
"FROM mantenimientos_mecanica.mto_internos mto JOIN mantenimientos_mecanica. 	dt_mto_interno dt ON mto.id_mto_interno=dt.id_mto_interno\n" +
"JOIN utilidades.vehiculos_equipos ve ON ve.id_vehiculo=mto.id_vehiculo\n" +
"JOIN utilidades.rutina rut ON rut.id_rutina=mto.id_rutina\n" +
"JOIN utilidades.linea_vehiculo li ON li.id_linea_vehi=ve.id_linea\n" +
"JOIN utilidades.marca_vehiculo mar ON mar.id_marca=li.id_marca\n" +
"JOIN utilidades.tipo_vehiculo tv ON tv.id_tipo_vehi=ve.id_tipo_vehiculo\n" +
"JOIN utilidades.tipo_mto tipo ON tipo.id_tipo_mto=mto.id_tipo_mto\n" +
"JOIN utilidades.mecanico_utd mec ON mec.id_meca=mto.id_mecanico\n" +
"JOIN utilidades.labor_mecanico lab ON lab.id_labor=dt.id_labor_mec\n" +
"\n"
                    + "WHERE fecha_reg BETWEEN '"+fechaIni+"'AND '"+fechaFin+"'" +
" GROUP BY mto.fecha_reg,mto.id_mto_interno,ve.placa_identi,mar.descripcion,li.descripcion,tv.descripcion,tipo.descripcion,rut.descripcion, mec.nombre_apellido"
                    + " ORDER BY mto.fecha_reg,vehiculo ASC");
            
            
            
            while (obj.next()) 
        {
        
        Object [] datos = new Object[13];
        
     
        for (int i=0;i<13;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
       
        }
           tb_detalle.setModel(modelo);
           
           TableColumnModel columnModel =tb_detalle.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(1);
        columnModel.getColumn(2).setPreferredWidth(1);
        columnModel.getColumn(3).setPreferredWidth(10);
        columnModel.getColumn(4).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(20);   
        columnModel.getColumn(6).setPreferredWidth(20);
        columnModel.getColumn(7).setPreferredWidth(20);
        columnModel.getColumn(8).setPreferredWidth(20);
        columnModel.getColumn(9).setPreferredWidth(20);
        columnModel.getColumn(10).setPreferredWidth(20);
        columnModel.getColumn(11).setPreferredWidth(20);
        columnModel.getColumn(12).setPreferredWidth(100);
           
            setCellRender(tb_detalle);
           nueva.desconectar();
       

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }



        }
       
       
         public void filvehiculofecha(Date fechaIni, Date fechaFin, int id)
        {
       try
        {
            ConexionBD nueva=new ConexionBD();
            
            ResultSet obj=nueva.executeQuery("SELECT mto.fecha_entrada,mto.id_mto_interno,mto.consecutivo_vehiculo,ve.placa_identi,(mar.descripcion ||'-'||li.descripcion)AS vehiculo,tv.descripcion, mto.km_llegada, mto.km_proximo_mto,mto.horas_uso, tipo.descripcion, rut.descripcion, mec.nombre_apellido, string_agg(lab.labor, ',' ) AS concepto\n" +
"\n" +
"FROM mantenimientos_mecanica.mto_internos mto JOIN mantenimientos_mecanica.dt_mto_interno dt ON mto.id_mto_interno=dt.id_mto_interno\n" +
"JOIN utilidades.vehiculos_equipos ve ON ve.id_vehiculo=mto.id_vehiculo\n" +
"JOIN utilidades.rutina rut ON rut.id_rutina=mto.id_rutina\n" +
"JOIN utilidades.linea_vehiculo li ON li.id_linea_vehi=ve.id_linea\n" +
"JOIN utilidades.marca_vehiculo mar ON mar.id_marca=li.id_marca\n" +
"JOIN utilidades.tipo_vehiculo tv ON tv.id_tipo_vehi=ve.id_tipo_vehiculo\n" +
"JOIN utilidades.tipo_mto tipo ON tipo.id_tipo_mto=mto.id_tipo_mto\n" +
"JOIN utilidades.mecanico_utd mec ON mec.id_meca=mto.id_mecanico\n" +
"JOIN utilidades.labor_mecanico lab ON lab.id_labor=dt.id_labor_mec\n" +
"\n"
                    + "WHERE mto.fecha_reg BETWEEN '"+fechaIni+"'AND '"+fechaFin+"' AND mto.id_vehiculo="+id+"" +
                    
" GROUP BY mto.fecha_reg,mto.id_mto_interno,ve.placa_identi,mar.descripcion,li.descripcion,tv.descripcion,tipo.descripcion,rut.descripcion, mec.nombre_apellido"
                    + " ORDER BY mto.fecha_reg,vehiculo ASC");
            
            
            
            while (obj.next()) 
        {
        
        Object [] datos = new Object[13];
        
     
        for (int i=0;i<13;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
       
        }
           tb_detalle.setModel(modelo);
           
           TableColumnModel columnModel =tb_detalle.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(1);
        columnModel.getColumn(2).setPreferredWidth(1);
        columnModel.getColumn(3).setPreferredWidth(10);
        columnModel.getColumn(4).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(20);   
        columnModel.getColumn(6).setPreferredWidth(20);
        columnModel.getColumn(7).setPreferredWidth(20);
        columnModel.getColumn(8).setPreferredWidth(20);
        columnModel.getColumn(9).setPreferredWidth(20);
        columnModel.getColumn(10).setPreferredWidth(20);
        columnModel.getColumn(11).setPreferredWidth(20);
        columnModel.getColumn(12).setPreferredWidth(100);
           
            setCellRender(tb_detalle);
           nueva.desconectar();
       

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }



        }
       
     
        public void LimpiarTabla()
    {
  
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
    }








}