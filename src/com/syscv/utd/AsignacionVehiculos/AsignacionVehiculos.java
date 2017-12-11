/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.AsignacionVehiculos;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class AsignacionVehiculos 
{
    private int id;
    private Date fecha_asig;
    private int id_conductor;
    private int id_vehiculo;
    private boolean estado_entrega;
    private String observacion;
    private int id_usuario;
    private boolean preoperacional;
    private Time hora_asignacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_asig() {
        return fecha_asig;
    }

    public void setFecha_asig(Date fecha_asig) {
        this.fecha_asig = fecha_asig;
    }

    public int getId_conductor() {
        return id_conductor;
    }

    public void setId_conductor(int id_conductor) {
        this.id_conductor = id_conductor;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public boolean isEstado_entrega() {
        return estado_entrega;
    }

    public void setEstado_entrega(boolean estado_entrega) {
        this.estado_entrega = estado_entrega;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean isPreoperacional() {
        return preoperacional;
    }

    public void setPreoperacional(boolean preoperacional) {
        this.preoperacional = preoperacional;
    }

    public Time getHora_asignacion() {
        return hora_asignacion;
    }

    public void setHora_asignacion(Time hora_asignacion) {
        this.hora_asignacion = hora_asignacion;
    }
  
}
