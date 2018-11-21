package com.reservas.wheelu.wheelu.entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Pasajero  implements Serializable {
    private String nombre;
    private String correo;
    private String contrasena;
    private String documento;
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public Pasajero() {
    }

    public Pasajero(String nombre, String correo, String contrasena, String documento) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena= contrasena;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        Pasajero.usuarios = usuarios;
    }
}