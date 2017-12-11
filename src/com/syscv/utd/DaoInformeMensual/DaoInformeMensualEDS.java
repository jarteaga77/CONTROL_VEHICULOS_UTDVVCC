/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaoInformeMensual;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.InformeMensualEDS;
import java.sql.ResultSet;

/**
 *
 * @author Jonathan
 */
public class DaoInformeMensualEDS 
{
    private ConexionBD conexion=new ConexionBD();
    
    
    private static int id;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        DaoInformeMensualEDS.id = id;
    }
    
    
    public void guardar(InformeMensualEDS info) throws Exception
    {
        if(info.getIdusuario()==0)
        {
            throw new Exception("El usuario no puede ser igual a cero");
        }
        
        if(info.getIdmes()==0)
        {
          throw new Exception("El ID del mes no puede ser igual a cero");

        }
         if(info.getIdyear()==0)
        {
          throw new Exception("El ID del año no puede ser igual a cero");

        }
         
          if(info.getIdyear()==0)
        {
          throw new Exception("El ID del año no puede ser igual a cero");

        }
          
         if(info.getIdeds()==0)
        {
          throw new Exception("El ID del EDS no puede ser igual a cero");

        }  
        
         ResultSet obj=conexion.executeQuery("INSERT INTO informes_mensuales.mensual_eds(fecha_gen,id_usuario,mes,year, id_eds)VALUES('"+info.getFecha_tran()+"',"+info.getIdusuario()+", "+info.getIdmes()+", "+info.getIdyear()+", "+info.getIdeds()+" )RETURNING id");
         
         
         while (obj.next()==true)
         {
             setId(obj.getInt("id"));
         }
    
         conexion.desconectar();
    }
    
}
