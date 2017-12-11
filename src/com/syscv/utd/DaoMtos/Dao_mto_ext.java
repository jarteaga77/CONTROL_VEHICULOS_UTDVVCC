/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaoMtos;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Mantenimientos_Externos;
import java.sql.ResultSet;

/**
 *
 * @author jarteaga
 */
public class Dao_mto_ext {
    
    
    private ConexionBD conexion=new ConexionBD();
    
    
      private static int id;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Dao_mto_ext.id = id;
    }
    
    public void guardar(Mantenimientos_Externos mto)throws Exception
    {
        if(mto.getId_taller()==0)
        {
            throw new Exception("El ID del taller no puede ser igual a cero");
        }
        
        if(mto.getId_vehiculo()==0)
        {
          throw new Exception("El ID del vehiculo/Equipo no puede ser igual a cero");

        }
        
         if(mto.getId_usuario()==0)
        {
          throw new Exception("El ID del usuario no puede ser igual a cero");

        }
         
           if(mto.getConsecutivo_vehiculo()==0)
        {
          throw new Exception("El Consecutivo del Vehiculo no puede ser cero");

        }
           
          if(mto.getTipo_mto()==0)
        {
          throw new Exception("El ID de Tipo de Mto. no puede ser cero");

        }   
   
        ResultSet obj=conexion.executeQuery("INSERT INTO mantenimientos_mecanica.mtos_externos(fecha_reg,id_vehiculo,id_taller,id_usuario_reg,consecutivo_vehiculo, solicita,id_tipo_mto)VALUES('"+mto.getFecha_reg()+"', "+mto.getId_vehiculo()+", "+mto.getId_taller()+", "+mto.getId_usuario()+", "+mto.getConsecutivo_vehiculo()+", '"+mto.getSolicita()+"', "+mto.getTipo_mto()+")RETURNING id_mto_externo");
        
         while (obj.next()==true)
         {
             setId(obj.getInt("id_mto_externo"));
         }
        
        conexion.desconectar();
        
    }
    
}
