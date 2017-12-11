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
public class ItemSistema 
{
    private int id;
    private String item;
    private int id_sistema;

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
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * @return the id_sistema
     */
    public int getId_sistema() {
        return id_sistema;
    }

    /**
     * @param id_sistema the id_sistema to set
     */
    public void setId_sistema(int id_sistema) {
        this.id_sistema = id_sistema;
    }

    @Override
    public String toString() {
        return item ;
    }
    
    
    
    
}
