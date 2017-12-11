/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaoMtos;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Detalle_Mto_Interno;

/**
 *
 * @author jarteaga
 */
public class Dao_Dt_Mto_Interno 
{
    private ConexionBD conexion=new ConexionBD();
    
    public void guardar(Detalle_Mto_Interno dt)throws Exception
    {
        if(dt.getId_mto_interno()==0)
        {
            throw new Exception("Falta el ID Mto. Interno");
        }
        
       
        
        
        conexion.executeUpdateQuery("INSERT INTO mantenimientos_mecanica.dt_mto_interno(id_mto_interno,novedades,id_labor_mec,mto_externo)VALUES("+dt.getId_mto_interno()+",'"+dt.getNovedades()+"', "+dt.getId_servicio()+", '"+dt.isMto_externo()+"')");
        conexion.desconectar();
        
    }
    
    
    public void actualizar(Detalle_Mto_Interno dt, int id) throws Exception
    {
          if(dt.getId_mto_interno()==0)
        {
            throw new Exception("Falta el ID Mto. Interno");
        }
        
      
        
         if(dt.getId_servicio()==0)
        {
            throw new Exception("El ID del servicio no puede ser igual a 0");
        }
         
         
        conexion.executeUpdateQuery("UPDATE mantenimientos_mecanica.dt_mto_interno SET  novedades='"+dt.getNovedades()+"', id_labor_mec="+dt.getId_servicio()+", mto_externo='"+dt.isMto_externo()+"' WHERE id_dt_mto_interno="+id+"");
        conexion.desconectar();
        
    }
    
    public void eliminar(int id)
    {
        conexion.executeUpdateQuery("DELETE FROM mantenimientos_mecanica.dt_mto_interno WHERE id_dt_mto_interno="+id+" ");
        conexion.desconectar();
    }
    
}
