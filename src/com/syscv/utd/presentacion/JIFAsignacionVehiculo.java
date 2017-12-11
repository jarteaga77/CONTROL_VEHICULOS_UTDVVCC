
package com.syscv.utd.presentacion;

import com.syscv.utd.AsignacionVehiculos.AsignacionVehiculos;
import com.syscv.utd.AsignacionVehiculos.DaoAsignacionVehiculos;
import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Conductor;
import java.awt.Color;
import com.syscv.utd.recursos.JPColor;
import com.syscv.utd.entidades.ControllerItemList;
import com.syscv.utd.entidades.Vehiculo;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class JIFAsignacionVehiculo extends javax.swing.JInternalFrame {

   private ConexionBD conexion=new ConexionBD();
      private int idusuario=MDIPrincipal.getvSeccion();
      private AsignacionVehiculos asig;
      private DaoAsignacionVehiculos daoAsig;
 
   
   
   
   private int id_vehiculo=0;
    SimpleDateFormat df = new SimpleDateFormat("hh:mm a");

   

   
  
   
  
    public JIFAsignacionVehiculo() {
        initComponents();
        
        Color c1=new Color(66,111,166);
        Color c2=new Color(102,174,118);
        JPColor miColor=new JPColor(c1,c2);
        miColor.setSize(this.getSize());
        p_encabezado.add(miColor);
        
       dc_fecha_asig.setDate(new Date());
        
           
            cargarItemVehiculo();
            cargarItemProveedor();

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        p_encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta_obse = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        btn_en = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        dc_fecha_asig = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        cb_conductor = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        cb_vehiculo = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        tmc_hora = new org.bolivia.time.TimeChooser();
        jLabel24 = new javax.swing.JLabel();
        cbx_entrega_1 = new javax.swing.JCheckBox();
        cbx_entrega_2 = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        cbx_ope1 = new javax.swing.JCheckBox();
        cbx_ope2 = new javax.swing.JCheckBox();
        btn_cancelar = new javax.swing.JButton();

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

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Asignación de Vehiculos --UTDVVCC--");

        p_encabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("Asignación de Vehiculos");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syscv/utd/recursos/asignacion_1.png"))); // NOI18N

        javax.swing.GroupLayout p_encabezadoLayout = new javax.swing.GroupLayout(p_encabezado);
        p_encabezado.setLayout(p_encabezadoLayout);
        p_encabezadoLayout.setHorizontalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_encabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
        );
        p_encabezadoLayout.setVerticalGroup(
            p_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(p_encabezadoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("General"));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Observaciones ");

        txta_obse.setColumns(20);
        txta_obse.setRows(5);
        jScrollPane1.setViewportView(txta_obse);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 0, 0));
        jLabel19.setText("* Campos Obligatorios");

        btn_en.setText("Guardar");
        btn_en.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Fecha asignación *");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Conductor *");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Vehiculo * ");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("Hora Asignación");

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setText("Estado Entrega Vehiculo");

        buttonGroup1.add(cbx_entrega_1);
        cbx_entrega_1.setSelected(true);
        cbx_entrega_1.setText("OK");

        buttonGroup1.add(cbx_entrega_2);
        cbx_entrega_2.setText("No OK");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setText("Pre-Operacional");

        buttonGroup2.add(cbx_ope1);
        cbx_ope1.setSelected(true);
        cbx_ope1.setText("OK");

        buttonGroup2.add(cbx_ope2);
        cbx_ope2.setText("No OK");

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btn_en)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_cancelar))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_vehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbx_entrega_1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbx_entrega_2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbx_ope1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbx_ope2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(dc_fecha_asig, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(tmc_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_conductor, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(cb_conductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)
                        .addComponent(tmc_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15)
                        .addComponent(dc_fecha_asig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cb_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(cbx_entrega_1)
                    .addComponent(cbx_entrega_2)
                    .addComponent(jLabel25)
                    .addComponent(cbx_ope1)
                    .addComponent(cbx_ope2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_en)
                    .addComponent(btn_cancelar))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p_encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enActionPerformed
          
       try { 
        
           
         int opc=JOptionPane.showConfirmDialog(null,"Desea guardar la asignación del vehiculo ?", "Aviso!", JOptionPane.YES_NO_OPTION); 
          
        if(opc==JOptionPane.YES_OPTION)
        {
             
         
           
           
        int id_vehiculo=0;
        int id_conductor=0;
        
        asig=new AsignacionVehiculos();
        daoAsig=new DaoAsignacionVehiculos();
        
        Date fecha;
        
        fecha=dc_fecha_asig.getDate();
        
        Conductor con=(Conductor)cb_conductor.getSelectedItem();
        id_conductor=con.getId_conductor();
        
        Vehiculo ve=(Vehiculo)cb_vehiculo.getSelectedItem();
        id_vehiculo=ve.getId_vehiculo();
        
        boolean estado = false;
        boolean preoperacional = false;
        
        if(cbx_entrega_1.isSelected()){
            
                estado=true;    
        }
        if(cbx_entrega_2.isSelected())
        {
            estado=false;
        }
        
        if(cbx_ope1.isSelected())
        {
            preoperacional=true;
        }
        if(cbx_ope2.isSelected())
        {
            preoperacional=false;
        }
        
        
        String obse=txta_obse.getText();
        
        asig.setEstado_entrega(estado);
        asig.setFecha_asig(fecha);
        
        if(tmc_hora.getText().equals(""))
        {
            
                throw new Exception("El campo Hora esta vacio.");
          
        }
        
        asig.setHora_asignacion(horas());
        asig.setId_conductor(id_conductor);
        asig.setId_usuario(idusuario);
        asig.setId_vehiculo(id_vehiculo);
        asig.setObservacion(obse);
        asig.setPreoperacional(preoperacional);
        
       
           daoAsig.guardar(asig);
           limpiar();
       }      
       } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
        
        
    }//GEN-LAST:event_btn_enActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
         int opc=JOptionPane.showConfirmDialog(null,"Desea concluir el registro de asignación de vehiculo ?", "Aviso!", JOptionPane.YES_NO_OPTION); 
          
        if(opc==JOptionPane.YES_OPTION)
        {
              this.dispose();
        }
    }//GEN-LAST:event_btn_cancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_en;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cb_conductor;
    private javax.swing.JComboBox cb_vehiculo;
    private javax.swing.JCheckBox cbx_entrega_1;
    private javax.swing.JCheckBox cbx_entrega_2;
    private javax.swing.JCheckBox cbx_ope1;
    private javax.swing.JCheckBox cbx_ope2;
    private com.toedter.calendar.JDateChooser dc_fecha_asig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel p_encabezado;
    private org.bolivia.time.TimeChooser tmc_hora;
    private javax.swing.JTextArea txta_obse;
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
        
        ArrayList lista=controller.listarConductor();
        
        cb_conductor.removeAllItems();
        if (lista!=null)
        {
            int size=lista.size();
            
            for(int i=0; i<size; i++)
            {
                cb_conductor.addItem(lista.get(i));
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
    
     public Time horas()
       {
           long ms=0;
           
           String hora_llegada=(tmc_hora.getText());
            
            
            
        try {
            ms= df.parse(hora_llegada).getTime();
        } catch (ParseException ex) {
            Logger.getLogger(JIFTallerInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
            Time t = new Time(ms);
            
            return t;
       }
     
     

     
     public void limpiar()
     {
        
        txta_obse.setText("");
        dc_fecha_asig.setDate(new Date());
        tmc_hora.setText("");
      
        
         
     }

}
