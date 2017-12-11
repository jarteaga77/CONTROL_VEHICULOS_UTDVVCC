/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.general;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.LineaVehiculo;

/**
 *
 * @author Jonathan
 */
public class DaoLineVehiculo 
{
    private ConexionBD conexion=new ConexionBD();
    
    public void guardar(LineaVehiculo linea) throws Exception
    {
        if(linea.getDescripcion().equals(""))
        {
            throw new Exception("El campo descripción es obligatorio");
        }
        if(linea.getIdmarca()==1)
        {
            throw new Exception("El id de la marca no puede ser cero");
        }
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.linea_vehiculo(descripcion,id_marca)VALUES('"+linea.getDescripcion()+"',"+linea.getIdmarca()+")");
        conexion.desconectar();
    }
    
}
