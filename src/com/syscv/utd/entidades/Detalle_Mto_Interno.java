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
public class Detalle_Mto_Interno 
{
    
    private int id_mto_interno;
    private String observacion;
    private String novedades;
    private int id_servicio;
    private boolean mto_externo;

    public boolean isMto_externo() {
        return mto_externo;
    }

    public void setMto_externo(boolean mto_externo) {
        this.mto_externo = mto_externo;
    }
 
    public int getId_mto_interno() {
        return id_mto_interno;
    }

    public void setId_mto_interno(int id_mto_interno) {
        this.id_mto_interno = id_mto_interno;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    public String getNovedades() {
        return novedades;
    }

    public void setNovedades(String novedades) {
        this.novedades = novedades;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }
   
}
