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
public class Detalle_Consumo_Estacion 
{
    
    private int id_detalle;
    private int valeUtd;
    private String valeEstacion;
    private int id_tipo_com;
    private float cant_gal;
    private int valorTotal;
    private float kilometraje;
    private int vlorGalon;
    private String obse;
    private int id_ce;
    private int id_vehi;
    private Date fechaTanq;

    public int getId_vehi() {
        return id_vehi;
    }

    public void setId_vehi(int id_vehi) {
        this.id_vehi = id_vehi;
    }
    
    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getValeUtd() {
        return valeUtd;
    }

    public void setValeUtd(int valeUtd) {
        this.valeUtd = valeUtd;
    }

    public String getValeEstacion() {
        return valeEstacion;
    }

    public void setValeEstacion(String valeEstacion) {
        this.valeEstacion = valeEstacion;
    }

    public int getId_tipo_com() {
        return id_tipo_com;
    }

    public void setId_tipo_com(int id_tipo_com) {
        this.id_tipo_com = id_tipo_com;
    }

    public float getCant_gal() {
        return cant_gal;
    }

    public void setCant_gal(float cant_gal) {
        this.cant_gal = cant_gal;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(float kilometraje) {
        this.kilometraje = kilometraje;
    }

    public int getVlorGalon() {
        return vlorGalon;
    }

    public void setVlorGalon(int vlorGalon) {
        this.vlorGalon = vlorGalon;
    }

    public String getObse() {
        return obse;
    }

    public void setObse(String obse) {
        this.obse = obse;
    }

    public int getId_ce() {
        return id_ce;
    }

    public void setId_ce(int id_ce) {
        this.id_ce = id_ce;
    }

    public Date getFechaTanq() {
        return fechaTanq;
    }

    public void setFechaTanq(Date fechaTanq) {
        this.fechaTanq = fechaTanq;
    }
    
    
    
            
    
    
}
