package com.reservas.wheelu.wheelu.entidades;

import java.util.ArrayList;

public abstract class Usuario {

    private String nombre;
    private String correo;
    private String contrasena;
    private String documento;
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String contrasena, String documento) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena= contrasena;
        this.documento = documento;
    }


    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    };

    public void modificar(Usuario usuario, String correo) {
        for (Usuario us: usuarios) {
            if(us.correo.equals(correo)) {
                usuarios.remove(us);
            }
            usuarios.add(usuario);
        }
    };

    public void mostrarUsuarios() {
        for (Usuario us: usuarios) {
            System.out.println(us);
        };
    };

    abstract public void consultar();
    abstract public void eliminar(String correo);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        Usuario.usuarios = usuarios;
    }
}
