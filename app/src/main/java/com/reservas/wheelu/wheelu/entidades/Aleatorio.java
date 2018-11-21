package com.reservas.wheelu.wheelu.entidades;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Aleatorio implements Serializable {

    @SerializedName("correo")
    private String correo;
    @SerializedName("aleatorio")
    private String aleatorio;

    public Aleatorio(String correo, String aleatorio) {
        this.correo = correo;
        this.aleatorio = aleatorio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAleatorio() {
        return aleatorio;
    }

    public void setAleatorio(String aleatorio) {
        this.aleatorio = aleatorio;
    }

}
