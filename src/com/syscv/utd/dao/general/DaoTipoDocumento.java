/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.general;

import com.syscv.utd.conexionBD.ConexionBD;
import com.syscv.utd.entidades.Tipo_Documentos_Vehi;

/**
 *
 * @author jarteaga
 */
public class DaoTipoDocumento 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    
    
    public void guardar(Tipo_Documentos_Vehi tipo) throws Exception
    {
        if(tipo.getNombre_doc().equals(""))
        {
            throw new Exception("");
        }
        
        conexion.executeUpdateQuery("INSERT INTO utilidades.tipo_doc(tipo_doc)VALUES('"+tipo.getNombre_doc()+"')");
        conexion.desconectar();
    }
    
    public void actualizar(Tipo_Documentos_Vehi tipo) throws Exception
    {
         if(tipo.getNombre_doc().equals(""))
        {
            throw new Exception("");
        }
         
         conexion.executeUpdateQuery("UPDATE utilidades.tipo_doc SET tipo_doc='"+tipo.getNombre_doc()+"' WHERE id="+tipo.getId_tipo_doc()+"");
         conexion.desconectar();
    }
    
}
