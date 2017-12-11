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
public class FormaPago 
{
    private int id_formaPago;
    private String descripcion_forma_pago;

    public int getId_formaPago() {
        return id_formaPago;
    }

    public void setId_formaPago(int id_formaPago) {
        this.id_formaPago = id_formaPago;
    }

    public String getDescripcion_forma_pago() {
        return descripcion_forma_pago;
    }

    public void setDescripcion_forma_pago(String descripcion_forma_pago) {
        this.descripcion_forma_pago = descripcion_forma_pago;
    }

    @Override
    public String toString() {
        return descripcion_forma_pago;
    }
    
    
    
}
