/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.ctrlcom;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.ControlCombustible;
import java.sql.ResultSet;

/**
 *
 * @author Jonathan
 */
public class CtrlCombustibleDao 
{
    //private ControlCombustible ctrlControl;
    
    private ConexionBD conexion=new  ConexionBD();
    
    private static int idCtrl;

    public static int getIdCtrl() {
        return idCtrl;
    }

    public static void setIdCtrl(int idCtrl) {
        CtrlCombustibleDao.idCtrl = idCtrl;
    }
    
    public void guardar(ControlCombustible control) throws Exception
    {
      
        if(control.getIdmes()==0)
        {
            throw new Exception("El id del mes no puede ser igual a cero");
        }
        
         if(control.getIdyear()==0)
        {
            throw new Exception("El id del año no puede ser igual a cero ");
        }
       
        if(control.getId_vehiculo()==0)
        {
           throw new Exception("Identificador del vehiculo erroneo");

        }
        
        if(control.getId_tipoCom()==0)
        {
            throw new Exception("Seleccione el tipo de combustible");

        }
        
        if(control.getId_usuario()==0)
        {
           throw new Exception("Identificador del usuario erroneo");

        }
        
      
      
        ResultSet obj=conexion.executeQuery("INSERT INTO consumo_combustible.control_combustible(ctrl_com_fecha_tran,id_vehiculo,usuario_id,ctrl_com_obs, id_tipo_com,id_mes,id_year) VALUES ('"+control.getCtrl_com_fecha_tran()+"',"+control.getId_vehiculo()+", "+control.getId_usuario()+",'"+control.getObserva()+"',  "+control.getId_tipoCom()+", "+control.getIdmes()+", "+control.getIdyear()+")RETURNING ctrl_com_id");
     
        while(obj.next()==true)
        {
            setIdCtrl(obj.getInt("ctrl_com_id"));
        }
        
        
        conexion.desconectar();
      
    }
    
}
