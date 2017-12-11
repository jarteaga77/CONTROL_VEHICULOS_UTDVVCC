/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.ctrlcom;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Vehiculo;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class VehiculoDao 
{
    private ConexionBD conexion=new ConexionBD();
    
    
    
    public void guardar(Vehiculo v) throws Exception
    {
        
        if(v.getPlaca().equals(""))
        {
            throw new Exception("La placa del vehiculo o identificación es obligatoria");
        }
        
        if(v.getId_item()==0)
        {
            throw new Exception("El ID del item no puede ser igual a cero");
        }
        
        if(v.getId_linea()==0)
        {
           throw new Exception("El ID de la linea del vehiculo no puede ser igual a cero");

        }
        
        if(v.getId_tipocom()==0)
        {
           throw new Exception("El ID del tipo de combustible no puede ser igual a cero");

        }
        
        if(v.getId_tipovehi()==0)
        {
           throw new Exception("El ID del tipo vehiculo no puede ser igual a cero");

        }
        
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.vehiculos_equipos (placa_identi,id_tipo_com,id_tipo_vehiculo,id_linea,id_item_ccostos,id_2tipo_com, id_usuario, fecha_creacion)VALUES('"+v.getPlaca()+"', "+v.getId_tipocom()+", "+v.getId_tipovehi()+", "+v.getId_linea()+","+v.getId_item()+","+v.getId_mixto()+","+v.getId_usuario()+", '"+v.getFecha()+"' )");
        conexion.desconectar();
        
        JOptionPane.showMessageDialog(null, "Se registro con exito.");
    }   
  
}
