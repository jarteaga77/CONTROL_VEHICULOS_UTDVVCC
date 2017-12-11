/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.general;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Conductor;
import javax.swing.JOptionPane;

/**
 *
 * @author jarteaga
 */
public class Dao_conductor {
    
    private ConexionBD conexion=new ConexionBD();
    
    
    
    public void guardar(Conductor con) throws Exception
    {
        
        if(con.getCedula()==0)
        {
            throw new Exception("La cédula no puede tener valor cero.");
        }
        
        if(con.getNombre().equals(""))
        {
            throw new Exception("El campo Nombre es obligatorio");
        }
        if(con.getApellido().equals(""))
        {
            throw new Exception("El campo Apellido es obligatorio");
        }
        
         if(con.getJefe_inmediato().equals(""))
        {
            throw new Exception("El campo Jefe Inmediato es obligatorio");
        }
         
          if(con.getId_area()==0)
        {
            throw new Exception("El campo Área es obligatorio");
        }
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.conductor (cedula,nombre,apellido,celular,tel,jefe_inmediato,id_area, direccion, eps,arl,id_usuario)VALUES ("+con.getCedula()+", '"+con.getNombre()+"', '"+con.getApellido()+"', '"+con.getCel()+"', '"+con.getTel()+"', '"+con.getJefe_inmediato()+"', "+con.getId_area()+", '"+con.getDir()+"', '"+con.getEps()+"', '"+con.getArl()+"', "+con.getId_usuario()+")");
        conexion.desconectar();
        JOptionPane.showMessageDialog(null, "Se ingreso con exito el nuevo Conductor.");
    }
    
    
    public void actualizar(Conductor con) throws Exception
    {
         if(con.getCedula()==0)
        {
            throw new Exception("La cédula no puede tener valor cero.");
        }
        
        if(con.getNombre().equals(""))
        {
            throw new Exception("El campo Nombre es obligatorio");
        }
        if(con.getApellido().equals(""))
        {
            throw new Exception("El campo Apellido es obligatorio");
        }
        
         if(con.getJefe_inmediato().equals(""))
        {
            throw new Exception("El campo Jefe Inmediato es obligatorio");
        }
         
          if(con.getId_area()==0)
        {
            throw new Exception("El campo Área es obligatorio");
        }
    
       conexion.executeUpdateQuery("UPDATE utilidades.conductor SET cedula="+con.getCedula()+", nombre='"+con.getNombre()+"', apellido='"+con.getApellido()+"', celular='"+con.getCel()+"', tel='"+con.getTel()+"', jefe_inmediato='"+con.getJefe_inmediato()+"', id_area="+con.getId_area()+", activo="+con.isActivo()+", direccion='"+con.getDir()+"', eps='"+con.getEps()+"', arl='"+con.getArl()+"', id_usuario_mod="+con.getId_usuario_mod()+", fecha_mod='"+con.getFecha_mod()+"' WHERE id_conductor="+con.getId_conductor()+"");
       conexion.desconectar();
    
    
    
    
    }
    
}
