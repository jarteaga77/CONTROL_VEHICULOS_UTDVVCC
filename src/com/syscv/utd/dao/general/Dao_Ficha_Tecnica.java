/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.general;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Ficha_tecnica;
import javax.swing.JOptionPane;

/**
 *
 * @author jarteaga
 */
public class Dao_Ficha_Tecnica 
{
    private ConexionBD conexion=new ConexionBD();
    
    
    
    public void guardar(Ficha_tecnica ficha) throws Exception
    {
         if(ficha.getId_vehiculo()==0)
        {
            throw new Exception("El ID del vehiculo/Equipo no puede ser cero");
        }
         
         conexion.executeUpdateQuery("INSERT INTO utilidades.ficha_tecnica_vehiculo_equipo (id_vehiculo, tipo_carroceria, modelo, serie, chasis, n_motor, color,cilindraje,n_pasajeros,motor_arranque, v_marcha_minima,peso_bruto,cap_aceite_motor,cap_refrigerante,cap_tan_combustible,tipo_caja_cambios,cap_caja_cambios, tipo_direccion,cap_aceite_direccion,tipo_diferencial,cap_aceite_diferencial,n_rin_rueda,referencia_llanta,presion_inflado,referencia_bateria,alternador,id_usuario,fecha_creacion)VALUES("+ficha.getId_vehiculo()+",'"+ficha.getTipo_carroceria()+"','"+ficha.getModelo()+"', '"+ficha.getSerie()+"', '"+ficha.getChasis()+"', '"+ficha.getN_motor()+"', '"+ficha.getColor()+"', '"+ficha.getCilindraje()+"', '"+ficha.getN_pasajeros()+"', '"+ficha.getMotor_arranque()+"', '"+ficha.getV_marcha_minima()+"', '"+ficha.getPeso_bruto()+"', '"+ficha.getCap_aceite_motor()+"', '"+ficha.getCap_refrigerante()+"', '"+ficha.getCap_tan_combustible()+"', '"+ficha.getTipo_caja_cambios()+"', '"+ficha.getCap_caja_cambios()+"', '"+ficha.getTipo_direccion()+"', '"+ficha.getCap_aceite_direccion()+"', '"+ficha.getTipo_diferencial()+"', '"+ficha.getCap_aceite_diferencial()+"', '"+ficha.getN_rin_rueda()+"', '"+ficha.getReferencia_llanta()+"', '"+ficha.getPresion_inflado()+"', '"+ficha.getReferencia_llanta()+"', '"+ficha.getAlternador()+"', "+ficha.getId_usuario()+", '"+ficha.getFecha_crea()+"')");
         JOptionPane.showMessageDialog(null, "Se registro con exito la Ficha Técnica");

         conexion.desconectar();
    }
    
    
    public void actualizar(Ficha_tecnica ficha) throws Exception
    {
         if(ficha.getId_ficha()==0)
        {
            throw new Exception("El ID de la ficha técnica no puede ser cero");
        }
         
         conexion.executeUpdateQuery("UPDATE utilidades.ficha_tecnica_vehiculo_equipo SET tipo_carroceria='"+ficha.getTipo_carroceria()+"',modelo='"+ficha.getModelo()+"', serie='"+ficha.getSerie()+"', chasis='"+ficha.getChasis()+"', n_motor='"+ficha.getN_motor()+"', color='"+ficha.getColor()+"', cilindraje='"+ficha.getCilindraje()+"', n_pasajeros='"+ficha.getN_pasajeros()+"', motor_arranque='"+ficha.getMotor_arranque()+"', v_marcha_minima='"+ficha.getV_marcha_minima()+"',peso_bruto='"+ficha.getPeso_bruto()+"', cap_aceite_motor='"+ficha.getCap_aceite_motor()+"', cap_refrigerante='"+ficha.getCap_refrigerante()+"', cap_tan_combustible='"+ficha.getCap_tan_combustible()+"', tipo_caja_cambios='"+ficha.getTipo_caja_cambios()+"', cap_caja_cambios='"+ficha.getCap_caja_cambios()+"', tipo_direccion='"+ficha.getTipo_direccion()+"', cap_aceite_direccion='"+ficha.getCap_aceite_direccion()+"', tipo_diferencial='"+ficha.getTipo_diferencial()+"', cap_aceite_diferencial='"+ficha.getCap_aceite_diferencial()+"',n_rin_rueda='"+ficha.getN_rin_rueda()+"', referencia_llanta='"+ficha.getReferencia_llanta()+"', presion_inflado='"+ficha.getPresion_inflado()+"', referencia_bateria='"+ficha.getReferencia_bateria()+"', alternador='"+ficha.getAlternador()+"' WHERE id_ficha="+ficha.getId_ficha()+"");
         conexion.desconectar();
         
         JOptionPane.showMessageDialog(null, "Se actualizó la Ficha Técnica");
        }
    
    
}
