/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.entidades;

/**
 *
 * @author Jonathan
 */
public class Linea 
{
    
    private int id_linea;
    private String nombreLinea;
    

   
    

    public int getId_linea() {
        return id_linea;
    }

    public void setId_linea(int id_linea) {
        this.id_linea = id_linea;
    }

    public String getNombreLinea() {
        return nombreLinea;
    }
    
    

    @Override
    public String toString() {
        return this.nombreLinea;
    }

    public void setNombreLinea(String nombreLinea) {
        this.nombreLinea = nombreLinea;
    }
            
            
            
    
}
