/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syscv.utd.entidades;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Ficha_tecnica 
{
    
    private int id_ficha;
    private int id_vehiculo;
    private String tipo_carroceria;
    private String modelo;
    private String serie;
    private String chasis;
    private String n_motor;
    private String color;
    private String cilindraje;
    private String n_pasajeros;
    private String motor_arranque;
    private String v_marcha_minima;
    private String peso_bruto;
    private String cap_aceite_motor;
    private String cap_refrigerante;
    private String cap_tan_combustible;
    private String tipo_caja_cambios;
    private String cap_caja_cambios;
    private String tipo_direccion;
    private String cap_aceite_direccion;
    private String tipo_diferencial;
    private String cap_aceite_diferencial;
    private String n_rin_rueda;
    private String referencia_llanta;
    private String presion_inflado;
    private String referencia_bateria;
    private String alternador;
    private int id_usuario, usuario_mod;
    private Date fecha_crea, fecha_mod;

    /**
     * @return the id_ficha
     */
    public int getId_ficha() {
        return id_ficha;
    }

    /**
     * @param id_ficha the id_ficha to set
     */
    public void setId_ficha(int id_ficha) {
        this.id_ficha = id_ficha;
    }

    /**
     * @return the id_vehiculo
     */
    public int getId_vehiculo() {
        return id_vehiculo;
    }

    /**
     * @param id_vehiculo the id_vehiculo to set
     */
    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    /**
     * @return the tipo_carroceria
     */
    public String getTipo_carroceria() {
        return tipo_carroceria;
    }

    /**
     * @param tipo_carroceria the tipo_carroceria to set
     */
    public void setTipo_carroceria(String tipo_carroceria) {
        this.tipo_carroceria = tipo_carroceria;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the chasis
     */
    public String getChasis() {
        return chasis;
    }

    /**
     * @param chasis the chasis to set
     */
    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    /**
     * @return the n_motor
     */
    public String getN_motor() {
        return n_motor;
    }

    /**
     * @param n_motor the n_motor to set
     */
    public void setN_motor(String n_motor) {
        this.n_motor = n_motor;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the cilindraje
     */
    public String getCilindraje() {
        return cilindraje;
    }

    /**
     * @param cilindraje the cilindraje to set
     */
    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    /**
     * @return the n_pasajeros
     */
    public String getN_pasajeros() {
        return n_pasajeros;
    }

    /**
     * @param n_pasajeros the n_pasajeros to set
     */
    public void setN_pasajeros(String n_pasajeros) {
        this.n_pasajeros = n_pasajeros;
    }

    /**
     * @return the motor_arranque
     */
    public String getMotor_arranque() {
        return motor_arranque;
    }

    /**
     * @param motor_arranque the motor_arranque to set
     */
    public void setMotor_arranque(String motor_arranque) {
        this.motor_arranque = motor_arranque;
    }

    /**
     * @return the v_marcha_minima
     */
    public String getV_marcha_minima() {
        return v_marcha_minima;
    }

    /**
     * @param v_marcha_minima the v_marcha_minima to set
     */
    public void setV_marcha_minima(String v_marcha_minima) {
        this.v_marcha_minima = v_marcha_minima;
    }

    /**
     * @return the peso_bruto
     */
    public String getPeso_bruto() {
        return peso_bruto;
    }

    /**
     * @param peso_bruto the peso_bruto to set
     */
    public void setPeso_bruto(String peso_bruto) {
        this.peso_bruto = peso_bruto;
    }

    /**
     * @return the cap_aceite_motor
     */
    public String getCap_aceite_motor() {
        return cap_aceite_motor;
    }

    /**
     * @param cap_aceite_motor the cap_aceite_motor to set
     */
    public void setCap_aceite_motor(String cap_aceite_motor) {
        this.cap_aceite_motor = cap_aceite_motor;
    }

    /**
     * @return the cap_refrigerante
     */
    public String getCap_refrigerante() {
        return cap_refrigerante;
    }

    /**
     * @param cap_refrigerante the cap_refrigerante to set
     */
    public void setCap_refrigerante(String cap_refrigerante) {
        this.cap_refrigerante = cap_refrigerante;
    }

    /**
     * @return the cap_tan_combustible
     */
    public String getCap_tan_combustible() {
        return cap_tan_combustible;
    }

    /**
     * @param cap_tan_combustible the cap_tan_combustible to set
     */
    public void setCap_tan_combustible(String cap_tan_combustible) {
        this.cap_tan_combustible = cap_tan_combustible;
    }

    /**
     * @return the tipo_caja_cambios
     */
    public String getTipo_caja_cambios() {
        return tipo_caja_cambios;
    }

    /**
     * @param tipo_caja_cambios the tipo_caja_cambios to set
     */
    public void setTipo_caja_cambios(String tipo_caja_cambios) {
        this.tipo_caja_cambios = tipo_caja_cambios;
    }

    /**
     * @return the cap_caja_cambios
     */
    public String getCap_caja_cambios() {
        return cap_caja_cambios;
    }

    /**
     * @param cap_caja_cambios the cap_caja_cambios to set
     */
    public void setCap_caja_cambios(String cap_caja_cambios) {
        this.cap_caja_cambios = cap_caja_cambios;
    }

    /**
     * @return the tipo_direccion
     */
    public String getTipo_direccion() {
        return tipo_direccion;
    }

    /**
     * @param tipo_direccion the tipo_direccion to set
     */
    public void setTipo_direccion(String tipo_direccion) {
        this.tipo_direccion = tipo_direccion;
    }

    /**
     * @return the cap_aceite_direccion
     */
    public String getCap_aceite_direccion() {
        return cap_aceite_direccion;
    }

    /**
     * @param cap_aceite_direccion the cap_aceite_direccion to set
     */
    public void setCap_aceite_direccion(String cap_aceite_direccion) {
        this.cap_aceite_direccion = cap_aceite_direccion;
    }

    /**
     * @return the tipo_diferencial
     */
    public String getTipo_diferencial() {
        return tipo_diferencial;
    }

    /**
     * @param tipo_diferencial the tipo_diferencial to set
     */
    public void setTipo_diferencial(String tipo_diferencial) {
        this.tipo_diferencial = tipo_diferencial;
    }

    /**
     * @return the cap_aceite_diferencial
     */
    public String getCap_aceite_diferencial() {
        return cap_aceite_diferencial;
    }

    /**
     * @param cap_aceite_diferencial the cap_aceite_diferencial to set
     */
    public void setCap_aceite_diferencial(String cap_aceite_diferencial) {
        this.cap_aceite_diferencial = cap_aceite_diferencial;
    }

    /**
     * @return the n_rin_rueda
     */
    public String getN_rin_rueda() {
        return n_rin_rueda;
    }

    /**
     * @param n_rin_rueda the n_rin_rueda to set
     */
    public void setN_rin_rueda(String n_rin_rueda) {
        this.n_rin_rueda = n_rin_rueda;
    }

    /**
     * @return the referencia_llanta
     */
    public String getReferencia_llanta() {
        return referencia_llanta;
    }

    /**
     * @param referencia_llanta the referencia_llanta to set
     */
    public void setReferencia_llanta(String referencia_llanta) {
        this.referencia_llanta = referencia_llanta;
    }

    /**
     * @return the presion_inflado
     */
    public String getPresion_inflado() {
        return presion_inflado;
    }

    /**
     * @param presion_inflado the presion_inflado to set
     */
    public void setPresion_inflado(String presion_inflado) {
        this.presion_inflado = presion_inflado;
    }

    /**
     * @return the referencia_bateria
     */
    public String getReferencia_bateria() {
        return referencia_bateria;
    }

    /**
     * @param referencia_bateria the referencia_bateria to set
     */
    public void setReferencia_bateria(String referencia_bateria) {
        this.referencia_bateria = referencia_bateria;
    }

    /**
     * @return the alternador
     */
    public String getAlternador() {
        return alternador;
    }

    /**
     * @param alternador the alternador to set
     */
    public void setAlternador(String alternador) {
        this.alternador = alternador;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the usuario_mod
     */
    public int getUsuario_mod() {
        return usuario_mod;
    }

    /**
     * @param usuario_mod the usuario_mod to set
     */
    public void setUsuario_mod(int usuario_mod) {
        this.usuario_mod = usuario_mod;
    }

    /**
     * @return the fecha_crea
     */
    public Date getFecha_crea() {
        return fecha_crea;
    }

    /**
     * @param fecha_crea the fecha_crea to set
     */
    public void setFecha_crea(Date fecha_crea) {
        this.fecha_crea = fecha_crea;
    }

    /**
     * @return the fecha_mod
     */
    public Date getFecha_mod() {
        return fecha_mod;
    }

    /**
     * @param fecha_mod the fecha_mod to set
     */
    public void setFecha_mod(Date fecha_mod) {
        this.fecha_mod = fecha_mod;
    }
    
    
    
 
    
    
}
