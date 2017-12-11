/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaoInformeMensual;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Informe_Mensual;
import java.sql.ResultSet;

/**
 *
 * @author Jonathan
 */
public class DaoInformeMensual 
{
    private ConexionBD conexion=new ConexionBD();
    
    
    private static int id;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        DaoInformeMensual.id = id;
    }
    
    
    public void guardar(Informe_Mensual info) throws Exception
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
        
         ResultSet obj=conexion.executeQuery("INSERT INTO informes_mensuales.mensual_ctrl(fecha_gen,id_usuario,mes,year)VALUES('"+info.getFecha_tran()+"',"+info.getIdusuario()+", "+info.getIdmes()+", "+info.getIdyear()+" )RETURNING id");
         
         
         while (obj.next()==true)
         {
             setId(obj.getInt("id"));
         }
    
         conexion.desconectar();
    }
    
}
