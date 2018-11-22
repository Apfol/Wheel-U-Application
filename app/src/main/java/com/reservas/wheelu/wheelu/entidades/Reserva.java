package com.reservas.wheelu.wheelu.entidades;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Reserva implements Serializable {

    private String nombreReserva;
    @SerializedName("idrutaReservada")
    private String IDRutaReservada;
    private String correoPasajero;

    public Reserva(String nombreReserva, String IDRutaReservada, String correoPasajero) {
        this.nombreReserva = nombreReserva;
        this.IDRutaReservada = IDRutaReservada;
        this.correoPasajero = correoPasajero;
    }

    public String getNombreReserva() {
        return nombreReserva;
    }

    public void setNombreReserva(String nombreReserva) {
        this.nombreReserva = nombreReserva;
    }

    public String getIDRutaReservada() {
        return IDRutaReservada;
    }

    public void setIDRutaReservada(String IDRutaReservada) {
        this.IDRutaReservada = IDRutaReservada;
    }

    public String getCorreoPasajero() {
        return correoPasajero;
    }

    public void setCorreoPasajero(String correoPasajero) {
        this.correoPasajero = correoPasajero;
    }
}
