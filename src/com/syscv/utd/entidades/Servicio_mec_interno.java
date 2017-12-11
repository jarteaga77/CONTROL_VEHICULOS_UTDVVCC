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
public class Servicio_mec_interno 
{
    
    private int id_servicio;
    private String descripcion;
    private float tiempo_servicio;
    private int costo;
    private int id_rutina;

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getTiempo_servicio() {
        return tiempo_servicio;
    }

    public void setTiempo_servicio(float tiempo_servicio) {
        this.tiempo_servicio = tiempo_servicio;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
    
    

    @Override
    public String toString() {
        return "Cod: "+ id_servicio + " - " +descripcion ;
    }

    /**
     * @return the id_rutina
     */
    public int getId_rutina() {
        return id_rutina;
    }

    /**
     * @param id_rutina the id_rutina to set
     */
    public void setId_rutina(int id_rutina) {
        this.id_rutina = id_rutina;
    }
    
    
    
    
}
