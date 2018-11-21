package com.reservas.wheelu.wheelu.entidades;

import java.util.ArrayList;

public class Conductor{

    private String nombre;
    private String correo;
    private String contrasena;
    private String documento;
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public Conductor() {
    }

    public Conductor(String nombre, String correo, String contrasena, String documento) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena= contrasena;
        this.documento = documento;
    }

}
