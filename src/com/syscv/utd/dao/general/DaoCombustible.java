/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.general;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Combustible;

/**
 *
 * @author Jonathan
 */
public class DaoCombustible 
{
    private ConexionBD conexion=new ConexionBD();
    
    
    public void guardar(Combustible com) throws Exception
    {
        if(com.getDescripcion().equals(""))
        {
            throw new Exception("El campo descripción es obligatorio");
        }
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.tipo_combustible(name_combustible)VALUES('"+com.getDescripcion()+"')");
        conexion.desconectar();
    }
    
}
