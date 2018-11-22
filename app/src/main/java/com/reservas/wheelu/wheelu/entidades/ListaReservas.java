package com.reservas.wheelu.wheelu.entidades;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListaReservas {

    @SerializedName("items")
    private List<Reserva> reservas;

    public ListaReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
