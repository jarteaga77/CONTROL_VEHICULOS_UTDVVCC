/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.entidades;

import java.util.Date;

/**
 *
 * @author Jonathan
 */
public class ControlCombustible 
{
    
    private Date ctrl_com_fecha_tran; 
    private int id_vehiculo;
    private int id_usuario;
    private String observa;
    private int id_tipoCom;
    private int idmes;
    private int idyear;

    public int getIdmes() {
        return idmes;
    }

    public void setIdmes(int idmes) {
        this.idmes = idmes;
    }

    public int getIdyear() {
        return idyear;
    }

    public void setIdyear(int idyear) {
        this.idyear = idyear;
    }
    
    public int getId_tipoCom() {
        return id_tipoCom;
    }

    public void setId_tipoCom(int id_tipoCom) {
        this.id_tipoCom = id_tipoCom;
    }
   
    public Date getCtrl_com_fecha_tran() {
        return ctrl_com_fecha_tran;
    }

    public void setCtrl_com_fecha_tran(Date ctrl_com_fecha_tran) {
        this.ctrl_com_fecha_tran = ctrl_com_fecha_tran;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getObserva() {
        return observa;
    }

    public void setObserva(String observa) {
        this.observa = observa;
    }

   
 
}
