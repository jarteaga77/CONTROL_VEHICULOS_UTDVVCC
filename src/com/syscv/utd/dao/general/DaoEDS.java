/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.general;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.EstacionesServicio;

/**
 *
 * @author Jonathan
 */
public class DaoEDS 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    public void guardar(EstacionesServicio eds) throws Exception
    {
        if(eds.getNomEstacion().equals(""))
        {
            throw new Exception("El campo EDS es obligatorio");
        }
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.estaciones_servicio (est_ser_desc)VALUES('"+eds.getNomEstacion()+"')");
        conexion.desconectar();
    }
    
    public void update(EstacionesServicio eds) throws Exception
    {
        if(eds.getNomEstacion().equals(""))
        {
            throw new Exception("El campo EDS es obligatorio");
        }
        
        conexion.executeUpdateQuery("UPDATE utilidades.estaciones_servicio SET est_ser_desc='"+eds.getNomEstacion()+"' WHERE est_ser_id="+eds.getId()+"");
        conexion.desconectar();
    }
    
}
