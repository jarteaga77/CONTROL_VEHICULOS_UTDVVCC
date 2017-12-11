/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.dao.ctrlcom;

import java.util.Date;

/**
 *
 * @author Jonathan
 */
public class NoTanqueo 
{
    
    private int id_notanqueo;
    private int idvehiculo;
    private Date fechaTran;
    private int id_mes;
    private int id_year;
    private int total_gal;
    private int total_crtl;
    private String observaciones;
    private int idusuario;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
  
    public int getId_notanqueo() {
        return id_notanqueo;
    }

    public void setId_notanqueo(int id_notanqueo) {
        this.id_notanqueo = id_notanqueo;
    }

    public int getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Date getFechaTran() {
        return fechaTran;
    }

    public void setFechaTran(Date fechaTran) {
        this.fechaTran = fechaTran;
    }

    public int getId_mes() {
        return id_mes;
    }

    public void setId_mes(int id_mes) {
        this.id_mes = id_mes;
    }

    public int getId_year() {
        return id_year;
    }

    public void setId_year(int id_year) {
        this.id_year = id_year;
    }

    public int getTotal_gal() {
        return total_gal;
    }

    public void setTotal_gal(int total_gal) {
        this.total_gal = total_gal;
    }

    public int getTotal_crtl() {
        return total_crtl;
    }

    public void setTotal_crtl(int total_crtl) {
        this.total_crtl = total_crtl;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
    
}
