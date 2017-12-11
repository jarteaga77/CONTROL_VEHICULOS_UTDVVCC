/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaoMtos;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Mantenimiento_Interno;
import java.sql.ResultSet;

/**
 *
 * @author jarteaga
 */
public class Dao_Mto_Interno 
{
    
    private ConexionBD conexion=new ConexionBD();
    
        private static int idMtoInterno;

    public static int getIdMtoInterno() {
        return idMtoInterno;
    }

    public static void setIdMtoInterno(int idMtoInterno) {
        Dao_Mto_Interno.idMtoInterno = idMtoInterno;
    }

 
    
    public void guardar(Mantenimiento_Interno mto)throws Exception 
    {
        if(mto.getId_vehiculo()==0)
        {
            throw new Exception("El ID del vehiculo no puede ser 0");
        }
        if(mto.getId_rutina()==0)
        {
            throw new Exception("El ID de la rutina no puede ser 0");
        }
        
        if(mto.getId_t_mto()==0)
        {
            throw new Exception("El ID de la rutina no puede ser 0");
        }
        
        if(mto.getId_mecanico()==0)
        {
            throw new Exception("El ID del Mecánico no puede ser 0");
        }
        
        if(mto.getId_usuario()==0)
        {
            throw new Exception("El ID del Usuario no puede ser 0");
        }
        
        if(mto.getConsecutivo_vehiculo()==0)
        {
            throw new Exception("El Consecutivo Mto.Interno por vehiculo no puede ser cero");
        }
        
       ResultSet obj= conexion.executeQuery("INSERT INTO mantenimientos_mecanica.mto_internos(fecha_reg,id_vehiculo,id_rutina,km_llegada,km_proximo_mto,id_tipo_mto,horas_uso,id_mecanico,id_usuario,consecutivo_vehiculo,salida_almacen,fecha_entrada,hora_entrada,fecha_salida,hora_salida, mto_externo)VALUES('"+mto.getFecha_reg()+"', "+mto.getId_vehiculo()+", "+mto.getId_rutina()+", "+mto.getKm_llegada()+", "+mto.getKm_prox_mto()+", "+mto.getId_t_mto()+", "+mto.getHoras_uso()+", "+mto.getId_mecanico()+", "+mto.getId_usuario()+", "+mto.getConsecutivo_vehiculo()+", "+mto.getSalida_almacen()+", '"+mto.getFecha_entrada()+"', '"+mto.getHora_entrada()+"', '"+mto.getFecha_salida()+"', '"+mto.getHora_salida()+"', '"+mto.isMto_externo()+"')RETURNING id_mto_interno");
        
        
        
        while(obj.next()==true)
        {
            setIdMtoInterno(obj.getInt("id_mto_interno"));
        }
        conexion.desconectar();
    }
    
    
    
    
}
