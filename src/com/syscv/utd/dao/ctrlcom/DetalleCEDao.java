/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.ctrlcom;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Detalle_Consumo_Estacion;

/**
 *
 * @author Jonathan
 */
public class DetalleCEDao 
{
    
        private ConexionBD conexion=new  ConexionBD();
        
        
        public void guardar(Detalle_Consumo_Estacion det) throws Exception
        {
            
            if(det.getValeUtd()==0)
            {
                throw new Exception("El vale UTD no puede ser cero");
            }
            
            if(det.getValeEstacion().equals(""))
            {
              throw new Exception("El vale EDS es obligatorio");
          
            }
            
            if(det.getId_tipo_com()==0)
            {
               throw new Exception("El ID del tipo de combustible no puede ser cero");

            }
            if(det.getCant_gal()==0)
            {
              throw new Exception("La cantidad de galones a tanquear no puede ser cero");

            }
            
             if(det.getValorTotal()==0)
            {
              throw new Exception("El total en pesos no puede ser cero");

            }
             
            
             if(det.getVlorGalon()==0)
             {
                throw new Exception("El valor de la gasolina no puede ser cero");

             }
             
             if(det.getId_vehi()==0)
             {
                throw new Exception("El ID de la gasolina no puede ser cero");

             }
             
             if(det.getId_ce()==0)
             {
                throw new Exception("El ID CE no puede ser cero");

             }
             
             conexion.executeUpdateQuery("INSERT INTO consumo_combustible.det_con_eds(vale_utd,vale_eds,id_tipo_com,cant_gal,valor_total,kilometraje,vlor_gal,id_vehiculo,obse,id_ceds,fechatanq)VALUES("+det.getValeUtd()+", '"+det.getValeEstacion()+"', "+det.getId_tipo_com()+","+det.getCant_gal()+", "+det.getValorTotal()+", "+det.getKilometraje()+", "+det.getVlorGalon()+", "+det.getId_vehi()+", '"+det.getObse()+"', "+det.getId_ce()+", '"+det.getFechaTanq()+"')");
             conexion.desconectar();
        
            
        }
        
        public void actualizar(Detalle_Consumo_Estacion det) throws Exception
        {
            
             if(det.getValeUtd()==0)
            {
                throw new Exception("El vale UTD no puede ser cero");
            }
            
            if(det.getValeEstacion().equals(""))
            {
              throw new Exception("El vale EDS es obligatorio");
          
            }
            
            if(det.getId_tipo_com()==0)
            {
               throw new Exception("El ID del tipo de combustible no puede ser cero");

            }
            if(det.getCant_gal()==0)
            {
              throw new Exception("La cantidad de galones a tanquear no puede ser cero");

            }
            
             if(det.getValorTotal()==0)
            {
              throw new Exception("El total en pesos no puede ser cero");

            }
             
            
             if(det.getVlorGalon()==0)
             {
                throw new Exception("El valor de la gasolina no puede ser cero");

             }
             
             if(det.getId_vehi()==0)
             {
                throw new Exception("El ID de la gasolina no puede ser cero");

             }
             
    
             
             conexion.executeUpdateQuery("UPDATE consumo_combustible.det_con_eds SET vale_utd="+det.getValeUtd()+",vale_eds='"+det.getValeEstacion()+"',id_tipo_com="+det.getId_tipo_com()+",cant_gal="+det.getCant_gal()+", valor_total="+det.getValorTotal()+", kilometraje="+det.getKilometraje()+",vlor_gal="+det.getVlorGalon()+", id_vehiculo="+det.getId_vehi()+", obse='"+det.getObse()+"', fechatanq='"+det.getFechaTanq()+"' WHERE id_det_ceds="+det.getId_detalle()+"");
             conexion.desconectar();
        }

    
}
