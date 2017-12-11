/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.general;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Marca;

/**
 *
 * @author Jonathan
 */
public class DaoMarca 
{
    private ConexionBD conexion=new ConexionBD();
    
    
    public void guardar(Marca ma) throws Exception
    {
        if(ma.getMarca().equals(""))
        {
            throw new Exception("El campo marca no puede estar vacio");
        }
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.marca_vehiculo(descripcion)VALUES('"+ma.getMarca()+"')");
        conexion.desconectar();
    }
    
}
