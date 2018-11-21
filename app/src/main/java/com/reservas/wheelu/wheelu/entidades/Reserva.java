package com.reservas.wheelu.wheelu.entidades;

public class Reserva {
    private String nombreReserva;
    private String IDRutaReservada;
    private String documentoPasajero;

    public Reserva(String nombreReserva, String IDRutaReservada, String documentoPasajero) {
        this.nombreReserva = nombreReserva;
        this.IDRutaReservada = IDRutaReservada;
        this.documentoPasajero = documentoPasajero;
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

    public String getDocumentoPasajero() {
        return documentoPasajero;
    }

    public void setDocumentoPasajero(String documentoPasajero) {
        this.documentoPasajero = documentoPasajero;
    }
}
