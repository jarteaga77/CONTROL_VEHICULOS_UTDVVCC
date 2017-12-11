/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaosUtilidades;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Tipo_Mto;

/**
 *
 * @author jarteaga
 */
public class DaoTipoMto 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    public void guardar(Tipo_Mto tipo)throws Exception
    {
        if(tipo.getDescripcion().equals(""))
        {
            throw new Exception("El campo nombre de tipo de Mto. es obligatorio");
        }
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.tipo_mto(descripcion)VALUES('"+tipo.getDescripcion()+"')");
        conexion.desconectar();
    }
    
    
    public void actualizar(Tipo_Mto tipo)
    {
        conexion.executeUpdateQuery("UPDATE utilidades.tipo_mto SET descripcion='"+tipo.getDescripcion()+"' WHERE id_tipo_mto="+tipo.getId()+"");
        conexion.desconectar();
    }
          
    
    
}
