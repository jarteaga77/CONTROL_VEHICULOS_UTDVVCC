/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaosUtilidades;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Mecanico_UTD;

/**
 *
 * @author jarteaga
 */
public class DaoMecanico 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    public void guardar(Mecanico_UTD me)throws Exception
    {
        if(me.getNombre_apellido().equals(""))
        {
            throw new Exception("El campo nombre y apellido son obligatorios");
        }
        
        if(me.getCedula()==0)
        {
           throw new Exception("El campo cédula no puede ser igual a cero");

        }
        
        if(me.getCel()==0)
        {
           throw new Exception("El campo célular no puede ser igual a 0");

        }
        
        if(me.getDir().equals(""))
        {
          throw new Exception("El campo Dirección es obligatorio");

        }
        
         if(me.getEps().equals(""))
        {
          throw new Exception("El campo EPS es obligatorio");

        }
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.mecanico_utd(nombre_apellido,cedula,cel,tel,observacion,direccion,eps)VALUES('"+me.getNombre_apellido()+"',"+me.getCedula()+","+me.getCel()+","+me.getTel()+",'"+me.getObservacion()+"','"+me.getDir()+"','"+me.getEps()+"')");
        
        conexion.desconectar();
    }
    
    public void actualizar (Mecanico_UTD mec) throws Exception
    {
        
         if(mec.getNombre_apellido().equals(""))
        {
            throw new Exception("El campo nombre y apellido son obligatorios");
        }
        
        if(mec.getCedula()==0)
        {
           throw new Exception("El campo cédula no puede ser igual a cero");

        }
        
        if(mec.getCel()==0)
        {
           throw new Exception("El campo célular no puede ser igual a 0");

        }
        
        if(mec.getDir().equals(""))
        {
          throw new Exception("El campo Dirección es obligatorio");

        }
        
         if(mec.getEps().equals(""))
        {
          throw new Exception("El campo EPS es obligatorio");

        }
        
        conexion.executeUpdateQuery("UPDATE utilidades.mecanico_utd SET nombre_apellido='"+mec.getNombre_apellido()+"', cedula="+mec.getCedula()+", cel="+mec.getCel()+", tel="+mec.getTel()+", observacion='"+mec.getObservacion()+"', direccion='"+mec.getDir()+"', eps='"+mec.getEps()+"', activo="+mec.isActivo()+" WHERE id_meca="+mec.getId_meca()+"");
        conexion.desconectar();
    }
    
    
}
