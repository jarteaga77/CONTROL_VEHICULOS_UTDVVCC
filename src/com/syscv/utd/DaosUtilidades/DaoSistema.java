/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaosUtilidades;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Sistemas;

/**
 *
 * @author jarteaga
 */
public class DaoSistema 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    public void guardar(Sistemas sistema) throws Exception
    {
        
        if(sistema.getDescripcion().isEmpty())
        {
            throw new Exception("Campo Descripción Obligatorio");
        }
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.sistema_vehiculo(descripcion)VALUES('"+sistema.getDescripcion()+"')");
        conexion.desconectar();
    }
    
    
       public void actualizar(Sistemas sistema) throws Exception
    {
        
        if(sistema.getDescripcion().isEmpty())
        {
            throw new Exception("Campo Descripción Obligatorio");
        }
        
        conexion.executeUpdateQuery("UPDATE utilidades.sistema_vehiculo SET descripcion='"+sistema.getDescripcion()+"' WHERE id_sistema="+sistema.getId()+"");
        conexion.desconectar();
    }
}
