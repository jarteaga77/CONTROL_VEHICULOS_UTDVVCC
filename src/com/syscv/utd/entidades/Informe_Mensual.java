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
public class Informe_Mensual 
{
    
    private int id;
    private Date fecha_tran;
    private int idusuario;
    private int idmes;
    private int idyear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_tran() {
        return fecha_tran;
    }

    public void setFecha_tran(Date fecha_tran) {
        this.fecha_tran = fecha_tran;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

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
    
    
    
    
}
