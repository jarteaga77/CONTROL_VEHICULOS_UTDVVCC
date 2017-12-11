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
public class TallerExterno 
{
    
    private int id;
    private Long nit;
    private String razon_social;
    private String direccion;
    private Long celular;
    private int tel;
    private String observacion;
    private String accesor;
    private String ciudad;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nit
     */
    public Long getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(Long nit) {
        this.nit = nit;
    }

    /**
     * @return the razon_social
     */
    public String getRazon_social() {
        return razon_social;
    }

    /**
     * @param razon_social the razon_social to set
     */
    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the celular
     */
    public Long getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(Long celular) {
        this.celular = celular;
    }

    /**
     * @return the tel
     */
    public int getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(int tel) {
        this.tel = tel;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * @return the accesor
     */
    public String getAccesor() {
        return accesor;
    }

    /**
     * @param accesor the accesor to set
     */
    public void setAccesor(String accesor) {
        this.accesor = accesor;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Nit: " + nit + ", Razón Social: " + razon_social;
    }
    
    
    
    
}
