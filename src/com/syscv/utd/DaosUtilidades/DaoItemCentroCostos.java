/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaosUtilidades;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.itemcentrocostos;
import javax.swing.JOptionPane;

/**
 *
 * @author jarteaga
 */
public class DaoItemCentroCostos 
{
    private ConexionBD conexion=new ConexionBD();
    
    
    
    public void guardar(itemcentrocostos item) throws Exception
    {
        if(item.getId_ccostos()==0)
        {
            throw new Exception("EL ID de centro de costos no puede ser cero");
        }
        
        if(item.getNombre().equals(""))
        {
          throw new Exception("EL Campo nombre Item Centro de Costos no puede estar vacio.");

        }
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.itemccostos(nombre_item_ccostos,id_centrocostos)VALUES('"+item.getNombre()+"', "+item.getId_ccostos()+")");
        JOptionPane.showMessageDialog(null, "Se guardó con exito el Item del Centro de costos.");
        conexion.desconectar();
    }
    
      public void actualizar(itemcentrocostos item) throws Exception
    {
        if(item.getId_ccostos()==0)
        {
            throw new Exception("EL ID de centro de costos no puede ser cero");
        }
        
        if(item.getNombre().equals(""))
        {
          throw new Exception("EL Campo nombre Item Centro de Costos no puede estar vacio.");

        }
        
        conexion.executeUpdateQuery("UPDATE utilidades.itemccostos SET nombre_item_ccostos='"+item.getNombre()+"', id_centrocostos="+item.getId_ccostos()+" WHERE id_item_ccostos="+item.getId_item()+"");
        JOptionPane.showMessageDialog(null, "Se actualizó con exito el Item del Centro de costos.");
        conexion.desconectar();
    }
    
}
