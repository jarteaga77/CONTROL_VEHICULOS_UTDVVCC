/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.entidades;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Mantenimientos_Externos 
{
    
    private int id_mto_ext;
    private Date fecha_reg;
    private int id_vehiculo;
    private int id_taller;
    private int id_usuario;
    private int tipo_mto;
    private int consecutivo_vehiculo; 
    private String solicita;

    public int getTipo_mto() {
        return tipo_mto;
    }

    public void setTipo_mto(int tipo_mto) {
        this.tipo_mto = tipo_mto;
    }

    /**
     * @return the id_mto_ext
     */
    public int getId_mto_ext() {
        return id_mto_ext;
    }

    /**
     * @return the fecha_reg
     */
    public Date getFecha_reg() {
        return fecha_reg;
    }

    /**
     * @return the id_vehiculo
     */
    public int getId_vehiculo() {
        return id_vehiculo;
    }

    /**
     * @return the id_taller
     */
    public int getId_taller() {
        return id_taller;
    }

    /**
     * @param id_mto_ext the id_mto_ext to set
     */
    public void setId_mto_ext(int id_mto_ext) {
        this.id_mto_ext = id_mto_ext;
    }

    /**
     * @param fecha_reg the fecha_reg to set
     */
    public void setFecha_reg(Date fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

    /**
     * @param id_vehiculo the id_vehiculo to set
     */
    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    /**
     * @param id_taller the id_taller to set
     */
    public void setId_taller(int id_taller) {
        this.id_taller = id_taller;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getConsecutivo_vehiculo() {
        return consecutivo_vehiculo;
    }

    public void setConsecutivo_vehiculo(int consecutivo_vehiculo) {
        this.consecutivo_vehiculo = consecutivo_vehiculo;
    }

    public String getSolicita() {
        return solicita;
    }

    public void setSolicita(String solicita) {
        this.solicita = solicita;
    }
    
    
    
    
    
    
}
