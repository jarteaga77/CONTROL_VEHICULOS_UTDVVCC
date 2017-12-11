/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaoMtos;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Dtalle_mto_externo;

/**
 *
 * @author jarteaga
 */
public class Dao_Dtlle_mto_externo 
{
    private ConexionBD conexion=new ConexionBD();
    
    
    public void guardar(Dtalle_mto_externo dt)throws Exception
    {
        if(dt.getId_mto_externo()==0)
        {
            throw new Exception("El ID de Mto Externo no puede ser cero");
        }
        
        if(dt.getItemsistema()==0)
        {
            throw new Exception("El ID del item del sistema no puede ser cero");
        }
        
        if(dt.getDescripcion().equals(""))
        {
            throw new Exception("El campo descripción no puede estar vacio");
        }
        
        if(dt.getCan()==0)
        {
           throw new Exception("El campo cantidad no puede ser igual a cero");

        }
        
        if(dt.getUm().equals(""))
        {
            throw new Exception("El campo UM no puede estar vacio");

        }
        
        conexion.executeUpdateQuery("INSERT INTO mantenimientos_mecanica.dte_mto_externo(id_mto_externo,descripcion,can,um,observacion,item_sistema,id_dt_mto_interno,id_mto_interno)values("+dt.getId_mto_externo()+", '"+dt.getDescripcion()+"', "+dt.getCan()+", '"+dt.getUm()+"', '"+dt.getObservacion()+"', "+dt.getItemsistema()+", "+dt.getId_dt_mto_interno()+", "+dt.getId_mto_interno()+")");
        conexion.desconectar();
    }
    public void eliminar(int id)
    {
        conexion.executeUpdateQuery("DELETE FROM mantenimientos_mecanica.dte_mto_externo WHERE id_dt_mto_ex="+id+"");
        conexion.desconectar();
    }
    
    
    public void actualizar(Dtalle_mto_externo dt) throws Exception
    {
        
         if(dt.getItemsistema()==0)
        {
            throw new Exception("El ID del item del sistema no puede ser cero");
        }
        
        if(dt.getDescripcion().equals(""))
        {
            throw new Exception("El campo descripción no puede estar vacio");
        }
        
        if(dt.getCan()==0)
        {
           throw new Exception("El campo cantidad no puede ser igual a cero");

        }
        
        if(dt.getUm().equals(""))
        {
            throw new Exception("El campo UM no puede estar vacio");

        }
       
        
        conexion.executeUpdateQuery("UPDATE mantenimientos_mecanica.dte_mto_externo SET descripcion='"+dt.getDescripcion()+"', can="+dt.getCan()+", um='"+dt.getUm()+"', observacion='"+dt.getObservacion()+"', item_sistema="+dt.getItemsistema()+" WHERE id_dt_mto_ex="+dt.getIddt_mto_externo()+"");
        conexion.desconectar();
    }
    
}
