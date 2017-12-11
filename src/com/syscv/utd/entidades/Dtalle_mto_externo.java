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
public class Dtalle_mto_externo 
{
    private int id_mto_externo;
    private String descripcion;
    private int can;
    private String um;
    private String observacion;
    private int itemsistema;
    private int iddt_mto_externo;
    private int id_mto_interno;
    private int id_dt_mto_interno;

    /**
     * @return the id_mto_externo
     */
    public int getId_mto_externo() {
        return id_mto_externo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the can
     */
    public int getCan() {
        return can;
    }

    /**
     * @return the um
     */
    public String getUm() {
        return um;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param id_mto_externo the id_mto_externo to set
     */
    public void setId_mto_externo(int id_mto_externo) {
        this.id_mto_externo = id_mto_externo;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @param can the can to set
     */
    public void setCan(int can) {
        this.can = can;
    }

    /**
     * @param um the um to set
     */
    public void setUm(String um) {
        this.um = um;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * @return the itemsistema
     */
    public int getItemsistema() {
        return itemsistema;
    }

    /**
     * @param itemsistema the itemsistema to set
     */
    public void setItemsistema(int itemsistema) {
        this.itemsistema = itemsistema;
    }

    /**
     * @return the iddt_mto_externo
     */
    public int getIddt_mto_externo() {
        return iddt_mto_externo;
    }

    /**
     * @param iddt_mto_externo the iddt_mto_externo to set
     */
    public void setIddt_mto_externo(int iddt_mto_externo) {
        this.iddt_mto_externo = iddt_mto_externo;
    }

    /**
     * @return the id_mto_interno
     */
    public int getId_mto_interno() {
        return id_mto_interno;
    }

    /**
     * @param id_mto_interno the id_mto_interno to set
     */
    public void setId_mto_interno(int id_mto_interno) {
        this.id_mto_interno = id_mto_interno;
    }

    /**
     * @return the id_dt_mto_interno
     */
    public int getId_dt_mto_interno() {
        return id_dt_mto_interno;
    }

    /**
     * @param id_dt_mto_interno the id_dt_mto_interno to set
     */
    public void setId_dt_mto_interno(int id_dt_mto_interno) {
        this.id_dt_mto_interno = id_dt_mto_interno;
    }
    
    
    
    
}
