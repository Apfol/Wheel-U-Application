package com.reservas.wheelu.wheelu;

public class Reserva {
    private String nombreReserva;
    private int IDRutaReservada;
    private String documentoPasajero;

    public Reserva(String nombreReserva, int IDRutaReservada, String documentoPasajero) {
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

    public int getIDRutaReservada() {
        return IDRutaReservada;
    }

    public void setIDRutaReservada(int IDRutaReservada) {
        this.IDRutaReservada = IDRutaReservada;
    }

    public String getDocumentoPasajero() {
        return documentoPasajero;
    }

    public void setDocumentoPasajero(String documentoPasajero) {
        this.documentoPasajero = documentoPasajero;
    }
}
