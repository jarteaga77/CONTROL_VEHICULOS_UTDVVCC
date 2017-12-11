/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.AsignacionVehiculos;

import com.syscv.utd.conexionBD.ConexionBD;
import javax.swing.JOptionPane;

/**
 *
 * @author jarteaga
 */
public class DaoAsignacionVehiculos 
{
    private ConexionBD conexion=new ConexionBD();
    
    
    public void guardar(AsignacionVehiculos asig) throws Exception
    {
        if(asig.getId_vehiculo()==0)
        {
            throw new Exception("El ID del vehiculo no puede ser igual a cero");
        }
        
        if(asig.getId_usuario()==0)
        {
           throw new Exception("El ID del usuario9 no puede ser igual a cero");

        }
        
        if(asig.getId_conductor()==0)
        {
           throw new Exception("El ID del conductor no puede ser igual a cero");

        }
        
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.asignacion_vehiculo (fecha_asignacion, id_conductor, id_vehiculo,estado_entrega,observacion_entrega,id_usuario,preoperacional,hora_asignacion)VALUES('"+asig.getFecha_asig()+"', "+asig.getId_conductor()+", "+asig.getId_vehiculo()+", '"+asig.isEstado_entrega()+"', '"+asig.getObservacion()+"', "+asig.getId_usuario()+", '"+asig.isPreoperacional()+"', '"+asig.getHora_asignacion()+"')");
        JOptionPane.showMessageDialog(null, "Se guardó con exito la asignación del vehiculo al conductor.");
        
        conexion.desconectar();
    }
    
}
