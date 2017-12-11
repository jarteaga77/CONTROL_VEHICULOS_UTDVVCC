/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaosUtilidades;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.TallerExterno;

/**
 *
 * @author jarteaga
 */
public class DaoTallerExterno 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    
    public void guardar(TallerExterno taller) throws Exception
    {
        
        if(taller.getNit()==0)
        {
            throw new Exception("El Nit no puede ser igual a 0");
            
        }
        
        if(taller.getRazon_social().equals(""))
        {
            throw new Exception("La razón social es un campo obligatorio");
        }
        
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.talleres_externos_mec(nit,razon_social,direccion,celular,telefono,persona_encargada,observacion,ciudad)VALUES("+taller.getNit()+",'"+taller.getRazon_social()+"','"+taller.getDireccion()+"', "+taller.getCelular()+", "+taller.getTel()+", '"+taller.getAccesor()+"', '"+taller.getObservacion()+"', '"+taller.getCiudad()+"')");
        conexion.desconectar();
        
    }
    
    public void actualizar(TallerExterno taller)
    {
        conexion.executeUpdateQuery("UPDATE utilidades.talleres_externos_mec SET direccion='"+taller.getDireccion()+"', observacion='"+taller.getObservacion()+"', persona_encargada='"+taller.getAccesor()+"', telefono="+taller.getTel()+", celular="+taller.getCelular()+", ciudad='"+taller.getCiudad()+"' WHERE id="+taller.getId()+" ");
        conexion.desconectar();
    }

}
