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
public class CtrlVehiculoCombo 
{
    
    private int idctrl;
    private String vehiculo;
    private String fecha;

    public int getIdctrl() {
        return idctrl;
    }

    public void setIdctrl(int idctrl) {
        this.idctrl = idctrl;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ID=" + idctrl + " - " + fecha + " - "+ vehiculo;
    }
    
    
    
}
