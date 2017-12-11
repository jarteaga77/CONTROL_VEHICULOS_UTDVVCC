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
public class itemcentrocostos 
{
    
    private int id_item;
    private String nombre;
    private int id_ccostos;

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_ccostos() {
        return id_ccostos;
    }

    public void setId_ccostos(int id_ccostos) {
        this.id_ccostos = id_ccostos;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
