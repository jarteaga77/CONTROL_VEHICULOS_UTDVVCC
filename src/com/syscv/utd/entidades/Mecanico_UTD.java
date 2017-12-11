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
public class Mecanico_UTD 
{
    
    private int id_meca;
    private String nombre_apellido;
    private long cedula;
    private Long cel;
    private int tel;
    private String observacion;
    private boolean activo;
    private String dir, eps;

    public int getId_meca() {
        return id_meca;
    }

    public void setId_meca(int id_meca) {
        this.id_meca = id_meca;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public Long getCel() {
        return cel;
    }

    public void setCel(Long cel) {
        this.cel = cel;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }
    
    

    @Override
    public String toString() {
        return nombre_apellido;
    }
    
    
    
    
    
    
}
