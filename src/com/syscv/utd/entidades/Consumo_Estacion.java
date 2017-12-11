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
public class Consumo_Estacion 
{
    
    private int id_ce;
    private String numero_cta;
    private Date fecha_vencer;
    private Date fecha_informe;
    private int id_estacion;
    private int id_usuario;
    private String obse;
    private int total_pesos;

    public int getId_ce() {
        return id_ce;
    }

    public void setId_ce(int id_ce) {
        this.id_ce = id_ce;
    }

    public String getNumero_cta() {
        return numero_cta;
    }

    public void setNumero_cta(String numero_cta) {
        this.numero_cta = numero_cta;
    }

    public Date getFecha_vencer() {
        return fecha_vencer;
    }

    public void setFecha_vencer(Date fecha_vencer) {
        this.fecha_vencer = fecha_vencer;
    }

    public Date getFecha_informe() {
        return fecha_informe;
    }

    public void setFecha_informe(Date fecha_informe) {
        this.fecha_informe = fecha_informe;
    }

    public int getId_estacion() {
        return id_estacion;
    }

    public void setId_estacion(int id_estacion) {
        this.id_estacion = id_estacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getObse() {
        return obse;
    }

    public void setObse(String obse) {
        this.obse = obse;
    }

    public int getTotal_pesos() {
        return total_pesos;
    }

    public void setTotal_pesos(int total_pesos) {
        this.total_pesos = total_pesos;
    }

   
}
