/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.entidades;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Mantenimiento_Interno 
{
    
    private int id_mto_interno;
    private Date fecha_reg;
    private int id_vehiculo;
    private int id_rutina;
    private int km_llegada;
    private int km_prox_mto;
    private int id_t_mto;
    private int horas_uso;
    private int id_mecanico;
    private int id_usuario;
    private int consecutivo_vehiculo;
    private int salida_almacen;
    private Date fecha_entrada;
    private Time hora_entrada;
    private Date fecha_salida;
    private Time hora_salida;
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

    public Date getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(Date fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getId_rutina() {
        return id_rutina;
    }

    public void setId_rutina(int id_rutina) {
        this.id_rutina = id_rutina;
    }

    public int getKm_llegada() {
        return km_llegada;
    }

    public void setKm_llegada(int km_llegada) {
        this.km_llegada = km_llegada;
    }

    public int getKm_prox_mto() {
        return km_prox_mto;
    }

    public void setKm_prox_mto(int km_prox_mto) {
        this.km_prox_mto = km_prox_mto;
    }

    public int getId_t_mto() {
        return id_t_mto;
    }

    public void setId_t_mto(int id_t_mto) {
        this.id_t_mto = id_t_mto;
    }

    public int getHoras_uso() {
        return horas_uso;
    }

    public void setHoras_uso(int horas_uso) {
        this.horas_uso = horas_uso;
    }

    public int getId_mecanico() {
        return id_mecanico;
    }

    public void setId_mecanico(int id_mecanico) {
        this.id_mecanico = id_mecanico;
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

    public int getSalida_almacen() {
        return salida_almacen;
    }

    public void setSalida_almacen(int salida_almacen) {
        this.salida_almacen = salida_almacen;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Time getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Time hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }
  
}
