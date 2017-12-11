/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaosUtilidades;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.ItemSistema;

/**
 *
 * @author jarteaga
 */
public class DaoItemSistema 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    
    public void guardar(ItemSistema item) throws Exception
    {
        if(item.getItem().isEmpty())
        {
            throw new Exception("El Campo Descripción es Obligatorio");
        }
        
        if(item.getId_sistema()==0)
        {
           throw new Exception("El ID del sistema no puede ser 0");

        }
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.items_sistema(descripcion, id_sistema)VALUES('"+item.getItem()+"', "+item.getId_sistema()+")");
        conexion.desconectar();
    }
    
    
      public void actualizar(ItemSistema item) throws Exception
    {
        if(item.getItem().isEmpty())
        {
            throw new Exception("El Campo Descripción es Obligatorio");
        }
        
        if(item.getId_sistema()==0)
        {
           throw new Exception("El ID del sistema no puede ser 0");

        }
        
        conexion.executeUpdateQuery("UPDATE utilidades.items_sistema SET descripcion='"+item.getItem()+"',id_sistema="+item.getId_sistema()+" WHERE id="+item.getId()+"  ");
        conexion.desconectar();
    }
    
}
