/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.DaosUtilidades;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.centro_costos;
import javax.swing.JOptionPane;

/**
 *
 * @author jarteaga
 */
public class DaoCentroCostos 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    
    public void guardarcc(centro_costos cc) throws Exception
    {
        if(cc.getNombre().equals(""))
        {
            throw new Exception("El campo nombre centro de costos no puede estar vacio.");
        }
        
        if(cc.getSigla().equals(""))
        {
           throw new Exception("El campo sigla centro de costos no puede estar vacio.");

        }
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.centrocostos(sigla_ccostos,nombre_centro_costos)VALUES('"+cc.getSigla()+"', '"+cc.getNombre()+"') ");
        JOptionPane.showMessageDialog(null, "Se guardó con exito el Centro de Costos.");
        
        conexion.desconectar();
    }
    
    
    public void Actualizarcc(centro_costos cc) throws Exception
    {
        if(cc.getNombre().equals(""))
        {
            throw new Exception("El campo nombre centro de costos no puede estar vacio.");
        }
        
        if(cc.getSigla().equals(""))
        {
           throw new Exception("El campo sigla centro de costos no puede estar vacio.");

        }
        
        conexion.executeUpdateQuery("UPDATE utilidades.centrocostos SET sigla_ccostos='"+cc.getSigla()+"', nombre_centro_costos='"+cc.getNombre()+"' WHERE id_centrocostos="+cc.getId_centro()+"");
        JOptionPane.showMessageDialog(null, "Se actualizó con exito el Centro de costos.");
        conexion.desconectar();
    }
    
    
    
    
}
