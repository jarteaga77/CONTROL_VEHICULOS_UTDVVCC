/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.entidades;

/**
 *
 * @author jarteaga
 */
public class Rutina_mto 
{
    
    private int rutina;
    private String descripcion;

    public int getRutina() {
        return rutina;
    }

    public void setRutina(int rutina) {
        this.rutina = rutina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  descripcion ;
    }
    
    
    
}
