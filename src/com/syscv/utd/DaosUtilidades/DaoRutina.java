/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaosUtilidades;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Rutina_mto;

/**
 *
 * @author jarteaga
 */
public class DaoRutina 


{
    
    private ConexionBD conexion=new ConexionBD();
    
    public void guardar(Rutina_mto ru)throws Exception
    {
        if(ru.getDescripcion().equals(""))
        {
            throw new Exception("El campo rutina es obligatorio");
        }
        
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.rutina(descripcion)VALUES('"+ru.getDescripcion()+"')");
        conexion.desconectar();
    }
    
    public void actualizar (int id, String nombre)
    {
        conexion.executeUpdateQuery("UPDATE utilidades.rutina SET descripcion='"+nombre+"' WHERE id_rutina="+id+"");
        conexion.desconectar();
    }
    
    
}
