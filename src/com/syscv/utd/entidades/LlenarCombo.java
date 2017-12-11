/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.entidades;

import com.syscv.utd.conexionBD.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan
 */
public class LlenarCombo 
{
    
    //private List listaVehi;
    
    public ArrayList listaItem()
    {
        ConexionBD conexion=new ConexionBD();
        ArrayList listaVehi=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT ve.id_vehiculo AS id, (' Placa: ' || ve.placa_identi ||' - '||ma.descripcion ||' '|| li.descripcion )AS vehiculo FROM utilidades.vehiculos_equipos ve INNER JOIN utilidades.linea_vehiculo li ON ve.id_linea=li.id_linea_vehi INNER JOIN utilidades.marca_vehiculo ma ON li.id_marca=ma.id_marca  WHERE ve.estado=true ORDER BY vehiculo ASC");
        
     
        try {
            while(obj.next())
            {
                Vehiculo vehi=new Vehiculo();
                
                vehi.setId_vehiculo(obj.getInt("id"));
                vehi.setNombreVehiculo(obj.getString("vehiculo"));
                listaVehi.add(vehi);
                
                // conexion.desconectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
            conexion.desconectar();
            return listaVehi;
         
    }
    
    
      public ArrayList listaItem2()
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT li.id_linea_vehi AS id,(ma.descripcion ||' - '|| li.descripcion)AS linea FROM utilidades.linea_vehiculo li JOIN utilidades.marca_vehiculo ma ON ma.id_marca=li.id_marca ORDER BY linea ASC");
        
     
        try {
            while(obj.next())
            {
                Linea li=new Linea();
                
                li.setId_linea(obj.getInt("id"));
                li.setNombreLinea(obj.getString("linea"));
                listaLinea.add(li);
                
                // conexion.desconectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        conexion.desconectar();
            return listaLinea;
               
    }
      
      
         public ArrayList listaItem3()
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT c.ctrl_com_id AS id,to_char(c.ctrl_com_fecha_tran, 'YYYY-MM-DD')AS fecha, (ma.descripcion ||' '|| li.descripcion || ' Placa: ' || ve.placa_identi)AS vehiculo FROM consumo_combustible.control_combustible c INNER JOIN  utilidades.vehiculos_equipos ve ON c.id_vehiculo=ve.id_vehiculo INNER JOIN utilidades.linea_vehiculo li ON ve.id_linea=li.id_linea_vehi INNER JOIN utilidades.marca_vehiculo ma ON li.id_marca=ma.id_marca WHERE c.docadjuntada=false AND totalizado=true AND aprobado=false ORDER BY ma.descripcion");
        
     
        try {
            while(obj.next())
            {
                CtrlVehiculoCombo combo=new CtrlVehiculoCombo();
                
                combo.setIdctrl(obj.getInt("id"));
                combo.setFecha(obj.getString("fecha"));
                combo.setVehiculo(obj.getString("vehiculo"));
                listaLinea.add(combo);
                
                // conexion.desconectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
            conexion.desconectar();
            return listaLinea;
               
    }
         
     public ArrayList listaItem4()
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT id_tipo_mto,descripcion FROM utilidades.tipo_mto ORDER BY descripcion ASC ");
        
     
        try {
            while(obj.next())
            {
                Tipo_Mto combo=new Tipo_Mto();
                
                combo.setId(obj.getInt("id_tipo_mto"));
                combo.setDescripcion(obj.getString("descripcion"));
                
                listaLinea.add(combo);
                
                // conexion.desconectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
            conexion.desconectar();
            return listaLinea;
               
    }
     
      public ArrayList listaItem5()
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT id_rutina,descripcion FROM utilidades.rutina ORDER BY descripcion ASC ");
        
     
        try {
            while(obj.next())
            {
                Rutina_mto combo=new Rutina_mto();
                
                combo.setRutina(obj.getInt("id_rutina"));
                combo.setDescripcion(obj.getString("descripcion"));
                
                listaLinea.add(combo);
                
                // conexion.desconectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        conexion.desconectar();
            return listaLinea;
               
    }
      
       public ArrayList listaItem6()
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT id_meca,nombre_apellido FROM utilidades.mecanico_utd  WHERE activo=true ORDER BY nombre_apellido ASC ");
        
     
        try {
            while(obj.next())
            {
                Mecanico_UTD combo=new Mecanico_UTD();
                
                combo.setId_meca(obj.getInt("id_meca"));
                combo.setNombre_apellido(obj.getString("nombre_apellido"));
                
                listaLinea.add(combo);
                
                // conexion.desconectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
            conexion.desconectar();
        
            return listaLinea;
               
    }
        
       public ArrayList listaItem7(int mto)
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT id_labor,labor FROM utilidades.labor_mecanico where id_rutina="+mto+" ORDER BY labor ASC ");
        
     
        try {
            while(obj.next())
            {
                Servicio_mec_interno combo=new Servicio_mec_interno();
                
                combo.setId_servicio(obj.getInt("id_labor"));
                combo.setDescripcion(obj.getString("labor"));
                
                listaLinea.add(combo);
                
                // conexion.desconectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
            conexion.desconectar();
        
            return listaLinea;
               
    } 
       
       public ArrayList listaItem8()
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT id_sistema,descripcion FROM utilidades.sistema_vehiculo ORDER BY descripcion ASC ");
        
     
        try {
            while(obj.next())
            {
                Sistemas combo=new Sistemas();
                
                combo.setId(obj.getInt("id_sistema"));
                combo.setDescripcion(obj.getString("descripcion"));
                
                listaLinea.add(combo);
                
                // conexion.desconectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
            conexion.desconectar();
        
            return listaLinea;
               
    } 

         public ArrayList listaItem9()
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT id,nit,razon_social FROM utilidades.talleres_externos_mec ORDER BY razon_social ASC ");
        
     
        try {
            while(obj.next())
            {
                TallerExterno combo=new TallerExterno();
                
                combo.setId(obj.getInt("id"));
                combo.setNit(obj.getLong("nit"));
                combo.setRazon_social(obj.getString("razon_social"));
                
                listaLinea.add(combo);
                
                // conexion.desconectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
            conexion.desconectar();
        
            return listaLinea;
               
    }   
       
         
         
    public ArrayList listaItem10(int id)
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT id,descripcion FROM utilidades.items_sistema WHERE id_sistema="+id+" ORDER BY descripcion ASC");
        
     
        try {
            while(obj.next())
            {
                ItemSistema combo=new ItemSistema();
                
                combo.setId(obj.getInt("id"));
                combo.setItem(obj.getString("descripcion"));
                
                listaLinea.add(combo);
                
                // conexion.desconectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
            conexion.desconectar();
        
            return listaLinea;
               
    } 
    
    public ArrayList Listaitem11()
    {
         ConexionBD conexion=new ConexionBD();
        ArrayList listaVehi=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT ve.id_vehiculo AS id, (' Placa: ' || ve.placa_identi ||' - '||ma.descripcion ||' '|| li.descripcion )AS vehiculo FROM utilidades.vehiculos_equipos ve INNER JOIN utilidades.linea_vehiculo li ON ve.id_linea=li.id_linea_vehi INNER JOIN utilidades.marca_vehiculo ma ON li.id_marca=ma.id_marca  WHERE ve.estado=true AND ve.ficha_tecnica=false ORDER BY vehiculo ASC");
        
     
        try {
            while(obj.next())
            {
                Vehiculo vehi=new Vehiculo();
                
                vehi.setId_vehiculo(obj.getInt("id"));
                vehi.setNombreVehiculo(obj.getString("vehiculo"));
                listaVehi.add(vehi);
                
                // conexion.desconectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
            conexion.desconectar();
            return listaVehi;
       
    }
    
        public ArrayList listaItem12()
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT id,tipo_doc FROM utilidades.tipo_doc ORDER BY tipo_doc ASC");
        
     
        try {
            while(obj.next())
            {
                Tipo_Documentos_Vehi combo=new Tipo_Documentos_Vehi();
                
                combo.setId_tipo_doc(obj.getInt("id"));
                combo.setNombre_doc(obj.getString("tipo_doc"));
                
                listaLinea.add(combo);
                
                // conexion.desconectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
            conexion.desconectar();
        
            return listaLinea;
               
    } 
        
        
            public ArrayList listaItem13()
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT id_centrocostos,nombre_centro_costos FROM utilidades.centrocostos ORDER BY nombre_centro_costos ASC");
        
     
        try {
            while(obj.next())
            {
                centro_costos centro=new centro_costos();
                
                centro.setId_centro(obj.getInt("id_centrocostos"));
                centro.setNombre(obj.getString("nombre_centro_costos"));
                
                listaLinea.add(centro);
                
                // conexion.desconectar();
            }
            
             conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
            conexion.desconectar();
        
            return listaLinea;
               
    } 
            
            
            
            public ArrayList listaItem14(int id)
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT id_item_ccostos,nombre_item_ccostos FROM utilidades.itemccostos WHERE id_centrocostos= "+id+" ORDER BY nombre_item_ccostos ASC");
        
     
        try {
            while(obj.next())
            {
                itemcentrocostos item=new itemcentrocostos();
                
                item.setId_item(obj.getInt("id_item_ccostos"));
                item.setNombre(obj.getString("nombre_item_ccostos"));
                
                listaLinea.add(item);
                
                // conexion.desconectar();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
            conexion.desconectar();
        
            return listaLinea;
               
    } 

            
               public ArrayList listaItem15()
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT id_conductor,nombre,apellido,cedula FROM utilidades.conductor ORDER BY nombre,apellido ASC");
        
     
        try {
            while(obj.next())
            {
                Conductor con =new Conductor();
                
                con.setId_conductor(obj.getInt("id_conductor"));
                con.setNombre(obj.getString("nombre"));
                con.setApellido(obj.getString("apellido"));
                con.setCedula(obj.getLong("cedula"));
                listaLinea.add(con);
                
                // conexion.desconectar();
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
            conexion.desconectar();
        
            return listaLinea;
               
    } 
       
        public ArrayList listaItem16()
      {
           
        
        ConexionBD conexion=new ConexionBD();
        ArrayList listaLinea=new ArrayList();
        
        ResultSet obj=conexion.executeQuery("SELECT id_forma,descripcion_pago FROM utilidades.forma_pago ORDER BY descripcion_pago ASC");
        
     
        try {
            while(obj.next())
            {
                FormaPago pago=new FormaPago();
                
                pago.setId_formaPago(obj.getInt("id_forma"));
                pago.setDescripcion_forma_pago(obj.getString("descripcion_pago"));
             
                listaLinea.add(pago);
                
                // conexion.desconectar();
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
            conexion.desconectar();
        
            return listaLinea;
               
    }          
               
}
