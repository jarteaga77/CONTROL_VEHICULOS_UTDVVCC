
package com.syscv.utd.entidades;

import java.util.Date;

/**
 *
 * @author Jonathan
 */
public class Vehiculo 
{
    
    private int id_vehiculo;
    private String placa , nombreVehiculo;
    private int id_tipocom,id_tipovehi,id_linea,id_item;
    private int id_mixto;
    private int id_usuario;
    private Date fecha;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }



    public int getId_tipocom() {
        return id_tipocom;
    }

    public void setId_tipocom(int id_tipocom) {
        this.id_tipocom = id_tipocom;
    }

    public int getId_tipovehi() {
        return id_tipovehi;
    }

    public void setId_tipovehi(int id_tipovehi) {
        this.id_tipovehi = id_tipovehi;
    }

    public int getId_linea() {
        return id_linea;
    }

    public void setId_linea(int id_linea) {
        this.id_linea = id_linea;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getId_mixto() {
        return id_mixto;
    }

    public void setId_mixto(int id_mixto) {
        this.id_mixto = id_mixto;
    }
   
    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getNombreVehiculo() {
        return nombreVehiculo;
    }

    public void setNombreVehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   
    
    

    @Override
    public String toString() {
        return this.nombreVehiculo;
    }
    
}
