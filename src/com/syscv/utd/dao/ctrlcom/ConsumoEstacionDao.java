/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.ctrlcom;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Consumo_Estacion;
import java.sql.ResultSet;

/**
 *
 * @author Jonathan
 */
public class ConsumoEstacionDao 
{
    private ConexionBD conexion=new  ConexionBD();
    
    private static int idCEstacion;

    public static int getIdCEstacion() {
        return idCEstacion;
    }

    public static void setIdCEstacion(int idCEstacion) {
        ConsumoEstacionDao.idCEstacion = idCEstacion;
    }
    
    
    public void guardar(Consumo_Estacion ce) throws Exception
    {
        if(ce.getNumero_cta().equals(""))
        {
            throw new Exception("El número de cuenta es obligatorio");
        }
        if(ce.getFecha_vencer().equals(null))
        {
           throw new Exception("La fecha de vencimiento es obligatorio");

        }
        if(ce.getId_estacion()==0)
        {
           throw new Exception("El ID de estación no puede ser cero");

        }
        if(ce.getId_usuario()==0)
        {
          throw new Exception("El ID de usuario no puede ser cero");

        }
        
        
        ResultSet obj=conexion.executeQuery("INSERT INTO consumo_combustible.consumo_estacion (num_cta,fecha_vence,id_estacion,id_usuario,observaciones,fecha_tran)VALUES('"+ce.getNumero_cta()+"','"+ce.getFecha_vencer()+"',"+ce.getId_estacion()+", "+ce.getId_usuario()+", '"+ce.getObse()+"', '"+ce.getFecha_informe()+"')RETURNING id_ce");
        
          while(obj.next()==true)
        {
            setIdCEstacion(obj.getInt("id_ce"));
        }
        
        
        conexion.desconectar();
      
    }
    

    
}
