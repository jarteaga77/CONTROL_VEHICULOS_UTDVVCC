/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.ctrlcom;

import com.syscv.utd.conexionBD.ConexionBD;
import java.sql.ResultSet;

/**
 *
 * @author Jonathan
 */
public class DaoNoTanqueo 
{
    private ConexionBD conexion=new ConexionBD();
    
    
    private static int id;

    public ConexionBD getConexion() {
        return conexion;
    }

    public void setConexion(ConexionBD conexion) {
        this.conexion = conexion;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        DaoNoTanqueo.id = id;
    }
    
    
    
    public void guardar(NoTanqueo no_tan) throws Exception
    {
        if(no_tan.getObservaciones().equals(""))
        {
            throw new Exception("Las observaciones es un campo obligatorio");
        }
        
        if (no_tan.getIdvehiculo()==0)
        {
          throw new Exception("El id del vehiculo o equipo no puede ser cero");

        }
        if(no_tan.getId_mes()==0)
        {
          throw new Exception("El id del mes no puede ser cero");
 
        }
        
        if(no_tan.getId_year()==0)
        {
          throw new Exception("El id del año no puede ser cero");
 
        }
        
        
       ResultSet obj= conexion.executeQuery("INSERT INTO consumo_combustible.no_tanqueo(id_vehiculo,id_mes,id_year, total_gal,total_ctrl,observaciones,fecha_tran,id_usuario)VALUES("+no_tan.getIdvehiculo()+","+no_tan.getId_mes()+","+no_tan.getId_year()+", "+no_tan.getTotal_gal()+", "+no_tan.getTotal_crtl()+", '"+no_tan.getObservaciones()+"', '"+no_tan.getFechaTran()+"', "+no_tan.getIdusuario()+")RETURNING id_notan");
        
        while(obj.next()==true)
        {
            setId(obj.getInt("id_notan"));
        }
        
        conexion.desconectar();
    }
   
    
}
