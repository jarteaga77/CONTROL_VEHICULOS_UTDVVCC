/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.ctrlcom;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.DetalleControlCombustible;

/**
 *
 * @author Jonathan
 */
public class DetalleCombustibleDao 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    public void guardar(DetalleControlCombustible detalle) throws Exception
    {
        
        
     
        
        if(detalle.getValeUTD()==0)
        {
            throw new Exception("EL vale UTD es obligatorio");
            
        }   
        
        if(detalle.getReciboEstacion().equals(""))
        {
            throw new Exception("EL recibo de la estación es obligatorio");
        }
        
        if(detalle.getFechaTanqueo().equals(""))
        {
           throw new Exception("La fecha de tanqueo es obligatorio");

        }
        
        if(detalle.getCantGal()<=0)
        {
            throw new Exception("La cantidad de galones no puede ser cero");
        }
        
     
        
        if(detalle.getId_ctrl_com()==0)
        {
           throw new Exception("El ID no puede ser cero");

        }
        
        if(detalle.getId_estacion()==0)
        {
           throw new Exception("El ID de la estación no puede ser cero");

        }
        
        
         
         
         conexion.executeUpdateQuery("INSERT INTO consumo_combustible.det_control_combustible (valeutd,det_ctrl_com_rc_esta,fechatanq,det_ctrl_com_can_gal,kmtanq,valortanq,ctrl_com_id,esta_ser_id,det_ctrl_com_obs,det_vlor_gaso,parcial_km,rendmto)"
                 + "VALUES("+detalle.getValeUTD()+",'"+detalle.getReciboEstacion()+"', '"+detalle.getFechaTanqueo()+"', "+detalle.getCantGal()+", "+detalle.getKmTanqueo()+", "+detalle.getVlorTanqueo()+", "+detalle.getId_ctrl_com()+", "+detalle.getId_estacion()+", '"+detalle.getDeta_obser()+"', "+detalle.getVlorGaso()+", "+detalle.getParcialkm()+", "+detalle.getRenmto()+")");
        
        
        
        
            
    }
    
    public void actualizar(DetalleControlCombustible detalle) throws Exception
    {
         if(detalle.getValeUTD()==0)
        {
            throw new Exception("EL vale UTD es obligatorio");
            
        }   
        
        if(detalle.getReciboEstacion().equals(""))
        {
            throw new Exception("EL recibo de la estación es obligatorio");
        }
        
        if(detalle.getFechaTanqueo().equals(""))
        {
           throw new Exception("La fecha de tanqueo es obligatorio");

        }
        
        if(detalle.getCantGal()<=0)
        {
            throw new Exception("La cantidad de galones no puede ser cero");
        }
        
       
        
        if(detalle.getId_estacion()==0)
        {
           throw new Exception("El ID de la estación no puede ser cero");

        }
        
        
       conexion.executeUpdateQuery("UPDATE consumo_combustible.det_control_combustible SET det_ctrl_com_rc_esta='"+detalle.getReciboEstacion()+"', det_ctrl_com_can_gal="+detalle.getCantGal()+", esta_ser_id="+detalle.getId_estacion()+", det_ctrl_com_obs='"+detalle.getDeta_obser()+"', det_vlor_gaso="+detalle.getVlorGaso()+", parcial_km="+detalle.getParcialkm()+", fechatanq='"+detalle.getFechaTanqueo()+"', kmtanq="+detalle.getKmTanqueo()+", valortanq="+detalle.getVlorTanqueo()+", rendmto="+detalle.getRenmto()+", valeutd="+detalle.getValeUTD()+" WHERE det_ctrl_com_id="+detalle.getId()+"");
       conexion.desconectar();
    
    }
    
    
}
    
    

