/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaosUtilidades;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Servicio_mec_interno;

/**
 *
 * @author jarteaga
 */
public class DaoServicio_Mecanico 
{
    private ConexionBD conexion=new  ConexionBD();
    
    public void guardar(Servicio_mec_interno serv)throws Exception
    {
        if(serv.getDescripcion().equals(""))
        {
            throw new Exception("El campo descripción es obligatorio");
        }
        if(serv.getCosto()==0)
        {
            throw new Exception("El costo del servicio debe ser mayor a cero");
        }
        
        if(serv.getTiempo_servicio()==0)
        {
            throw new Exception("El tiempo de duración debe ser mayor a cero");
        }
        
        if(serv.getId_rutina()==0)
        {
           throw new Exception("El ID de la rutina de mto. no puede ser cero");

        }

        conexion.executeUpdateQuery("INSERT INTO utilidades.labor_mecanico(labor,dur_labor,costo,id_rutina)VALUES('"+serv.getDescripcion()+"',"+serv.getTiempo_servicio()+", "+serv.getCosto()+", "+serv.getId_rutina()+")");
        conexion.desconectar();
    }
    public void actualizar(Servicio_mec_interno serv) throws Exception
    {
        if(serv.getDescripcion().equals(""))
        {
            throw new Exception("El campo descripción es obligatorio");
        }
        if(serv.getCosto()==0)
        {
            throw new Exception("El costo del servicio debe ser mayor a cero");
        }
        
        if(serv.getTiempo_servicio()==0)
        {
            throw new Exception("El tiempo de duración debe ser mayor a cero");
        }
        
        if(serv.getId_rutina()==0)
        {
           throw new Exception("El ID de la rutina de mto. no puede ser cero");

        }
        
        conexion.executeUpdateQuery("UPDATE utilidades.labor_mecanico SET labor='"+serv.getDescripcion()+"', dur_labor="+serv.getTiempo_servicio()+", costo="+serv.getCosto()+", id_rutina="+serv.getId_rutina()+" where id_labor="+serv.getId_servicio()+" ");
        conexion.desconectar();
    }
    
}
