/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.costos;

import com.syscv.utd.conexionBD.ConexionBD;
import java.sql.ResultSet;

/**
 *
 * @author jarteaga
 */
public class Dao_costos_fac_mto_externo 
{
    private ConexionBD conexion=new ConexionBD();
    
    private static int id_cost_fact;

    public static int getId_cost_fact() {
        return id_cost_fact;
    }

    public static void setId_cost_fact(int id_cost_fact) {
        Dao_costos_fac_mto_externo.id_cost_fact = id_cost_fact;
    }
    
    
    
    
    
    public void guardar(Costos_mto_externos costos) throws Exception
    {
        if(costos.getId_mes()==0)
        {
            throw new Exception("El mes no puede ser cero");
        }
        
        if(costos.getId_anio()==0)
        {
           throw new Exception("El año no puede ser cero"); 
        }
        
        
        ResultSet obj=conexion.executeQuery("INSERT INTO mantenimientos_mecanica.cos_fact_mto_ext(id_mes, id_anio, observacion,id_usuario)VALUES("+costos.getId_mes()+", "+costos.getId_anio()+", '"+costos.getObse()+"', "+costos.getId_usuario()+")RETURNING id_cos_fact");
        
        
        
        while(obj.next()==true)
        {
            setId_cost_fact(obj.getInt("id_cos_fact"));
        }
        conexion.desconectar();
        
    }
    
}
