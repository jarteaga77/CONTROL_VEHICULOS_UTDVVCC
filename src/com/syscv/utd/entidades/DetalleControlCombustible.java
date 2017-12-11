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
public class DetalleControlCombustible 
{
    private int valeUTD;
    private String reciboEstacion;
    private Date fechaTanqueo;
    private float cantGal;
    private float kmTanqueo;
    private int vlorTanqueo;
    private int id_ctrl_com;
    private int id_estacion;
    private String deta_obser;
    private int id_tipoCombus;
    private int vlorGaso;
    private float parcialkm;
    private float renmto;
    private int id;

    public float getParcialkm() {
        return parcialkm;
    }

    public void setParcialkm(float parcialkm) {
        this.parcialkm = parcialkm;
    }

    public double getRenmto() {
        return renmto;
    }

    public void setRenmto(float renmto) {
        this.renmto = renmto;
    }
    
    
    public int getValeUTD() {
        return valeUTD;
    }

    public void setValeUTD(int valeUTD) {
        this.valeUTD = valeUTD;
    }

    public String getReciboEstacion() {
        return reciboEstacion;
    }

    public void setReciboEstacion(String reciboEstacion) {
        this.reciboEstacion = reciboEstacion;
    }

    public Date getFechaTanqueo() {
        return fechaTanqueo;
    }

    public void setFechaTanqueo(Date fechaTanqueo) {
        this.fechaTanqueo = fechaTanqueo;
    }

    public float getCantGal() {
        return cantGal;
    }

    public void setCantGal(float cantGal) {
        this.cantGal = cantGal;
    }

    public float getKmTanqueo() {
        return kmTanqueo;
    }

    public void setKmTanqueo(float kmTanqueo) {
        this.kmTanqueo = kmTanqueo;
    }

    public int getVlorTanqueo() {
        return vlorTanqueo;
    }

    public void setVlorTanqueo(int vlorTanqueo) {
        this.vlorTanqueo = vlorTanqueo;
    }

    public int getId_ctrl_com() {
        return id_ctrl_com;
    }

    public void setId_ctrl_com(int id_ctrl_com) {
        this.id_ctrl_com = id_ctrl_com;
    }

    public int getId_estacion() {
        return id_estacion;
    }

    public void setId_estacion(int id_estacion) {
        this.id_estacion = id_estacion;
    }

    public String getDeta_obser() {
        return deta_obser;
    }

    public void setDeta_obser(String deta_obser) {
        this.deta_obser = deta_obser;
    }

    public int getId_tipoCombus() {
        return id_tipoCombus;
    }

    public void setId_tipoCombus(int id_tipoCombus) {
        this.id_tipoCombus = id_tipoCombus;
    }

    public int getVlorGaso() {
        return vlorGaso;
    }

    public void setVlorGaso(int vlorGaso) {
        this.vlorGaso = vlorGaso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
    
}
