/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.presentacion;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.recursos.JPColor;
import com.syscv.utd.reportes.ReporteNoTanqueo;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jonathan
 */
public class JIFImprimirNoTanqueo extends javax.swing.JInternalFrame {

 private DefaultTableModel modelo;
    
 private ReporteNoTanqueo reporte;
 
 private ConexionBD conexion;
 private TableRowSorter trsFiltro;
    
    public JIFImprimirNoTanqueo() {
        initComponents();
        
        Color c1=new Color(66,111,166);
        Color c2=new Color(102,174,118);
        JPColor miColor=new JPColor(c1,c2);
        miColor.setSize(this.getSize());
        p_encabezado.add(miColor);
        
        modelo=new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Vehiculo/Equipo");
        modelo.addColumn("Fecha");
        modelo.addColumn("Observación");
        modelo.addColumn("Usuario");
        modelo.addColumn("Fecha-Transación");
        
        
     try {
         consultarTodos();
     } catch (SQLException ex) {
         Logger.getLogger(JIFImprimirNoTanqueo.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel4 = new javax.swing.JLabel();
        cb_filtro = new javax.swing.JComboBox();
        txt_filtro = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_consulta = new javax.swing.JTable();
        btn_ver = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Impresión No Tanqueo --UTDVVCC--");
        setPreferredSize(new java.awt.Dimension(800, 600));

        p_encabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("IMPRIMIR NO TANQUEO");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/medidor.png"))); // NOI18N

        javax.swing.GroupLayout p_encabezadoLayout = new javax.swing.GroupLayout(p_encabezado);
        p_encabezado.setLayout(p_encabezadoLayout);
        p_encabezadoLayout.setHorizontalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_encabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(286, 286, 286))
        );
        p_encabezadoLayout.setVerticalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_encabezadoLayout.createSequentialGroup()
                .addGroup(p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(p_encabezadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Buscar Por");

        cb_filtro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Vehiculo/Equipo", "Fecha", "Usuario" }));

        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_filtroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cb_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
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
                .addComponent(p_encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verActionPerformed
        int id;
        
        if(tb_consulta.isRowSelected(tb_consulta.getSelectedRow()))
        {
            reporte=new ReporteNoTanqueo();
        
            id=(Integer) tb_consulta.getValueAt(tb_consulta.getSelectedRow(), 0);
        
            reporte.ejecutarReporte(id);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_verActionPerformed

    private void txt_filtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyTyped
        txt_filtro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = (txt_filtro.getText());
                txt_filtro.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(tb_consulta.getModel());
        tb_consulta.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txt_filtroKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ver;
    private javax.swing.JComboBox cb_filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel p_encabezado;
    private javax.swing.JTable tb_consulta;
    private javax.swing.JTextField txt_filtro;
    // End of variables declaration//GEN-END:variables

public void consultarTodos() throws SQLException
{
    System.out.println("paso por aca");
    conexion=new ConexionBD();
    
    ResultSet obj=conexion.executeQuery("SELECT n.id_notan, (' Placa: ' || ve.placa_identi ||' - '||ma.descripcion ||' '|| li.descripcion)AS vehiculo,(m.descripcion ||' - '|| y.year)AS fecha,n.observaciones, us.usuario, n.fecha_tran FROM consumo_combustible.no_tanqueo n JOIN utilidades.vehiculos_equipos ve ON ve.id_vehiculo=n.id_vehiculo JOIN utilidades.usuarios us ON us.id_usuario=n.id_usuario JOIN utilidades.linea_vehiculo li ON li.id_linea_vehi=ve.id_linea JOIN utilidades.marca_vehiculo ma ON ma.id_marca=li.id_marca JOIN utilidades.mes m ON m.id_mes=n.id_mes JOIN utilidades.year y ON n.id_year=y.id_year ORDER BY fecha, vehiculo DESC");
    
    
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

//public void consultarID(int id, int idvehi,int idmes, int idyear) throws SQLException
//{
//  
//    conexion=new ConexionBD();
//    
//    LimpiarTabla();
//    
//    ResultSet obj=conexion.executeQuery("SELECT n.id_notan, (' Placa: ' || ve.placa_identi ||' - '||ma.descripcion ||' '|| li.descripcion)AS vehiculo,(m.descripcion ||' - '|| y.year)AS fecha,n.observaciones, us.usuario, n.ctrl_com_fecha_tran FROM consumo_combustible.no_tanqueo n JOIN utilidades.vehiculos_equipos ve ON ve.id_vehiculo=n.id_vehiculo JOIN utilidades.usuarios us ON us.id_usuario=n.id_usuario JOIN utilidades.linea_vehiculo li ON li.id_linea_vehi=ve.id_linea JOIN utilidades.marca_vehiculo ma ON ma.id_marca=li.id_marca JOIN utilidades.mes m ON m.id_mes=c.id_mes JOIN utilidades.year y ON n.id_year=y.id_year WHERE n.n.id_notan="+id+" OR n.id_mes="+idmes+" OR n.id_year="+idyear+" OR n.id_vehiculo="+idvehi+"  ORDER BY n.id_notan DESC");
//    
//    
//    if(obj.next()==true)
//    {
//          
//          Object [] datos = new Object[6];
//       
//          for (int i=0;i<6;i++)
//          {
//              datos[i] =obj.getObject(i+1);
//          }
//
//           modelo.addRow(datos);
//         
//          
//        tb_consulta.setModel(modelo);
//        setCellRender(tb_consulta);
//        conexion.desconectar();
//        txt_id.setText("");
//    }else
//    {
//        JOptionPane.showMessageDialog(null, "El Relación de combustible N° "+ id + " no esta registrada");
//        //consultarTodos();
//    }
//}

//  public void cargarItemVehiculo()
//    {
//        ControllerItemList controller=new ControllerItemList();
//        
//        ArrayList lista=controller.listarItemVehiculo();
//        
//        cb_vehi.removeAllItems();
//        if (lista!=null)
//        {
//            int size=lista.size();
//            
//            for(int i=0; i<size; i++)
//            {
//                cb_vehi.addItem(lista.get(i));
//            }
//        }
//    }
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

        
           public void filtro() {
        int columnaABuscar = 0;
        if (cb_filtro.getSelectedItem().toString() == "ID") {
            columnaABuscar = 0;
        }
        if (cb_filtro.getSelectedItem() == "Vehiculo/Equipo") {
            columnaABuscar = 1;
        }
         if (cb_filtro.getSelectedItem() == "Fecha") {
            columnaABuscar = 2;
        }
        
        if (cb_filtro.getSelectedItem() == "Usuario") {
            columnaABuscar = 4;
        }
      
       
        
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt_filtro.getText(), columnaABuscar));

    }
}


