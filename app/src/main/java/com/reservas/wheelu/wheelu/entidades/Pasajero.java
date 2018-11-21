package com.reservas.wheelu.wheelu.entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Pasajero extends Usuario implements Serializable {

    public Pasajero(String nombre, String correo, String contrasena, String documento) {
        super(nombre, correo, contrasena, documento);
    }

    public Pasajero() {

    }

    @Override
    public void consultar() {
        String datosUsuarios = "";
        ArrayList<Usuario> usuarios = this.getUsuarios();
        for (Usuario us: usuarios) {
            if(us instanceof Pasajero) {
                datosUsuarios += us.getNombre() + " " + us.getCorreo() + "\n";
            }
        }
    }

    @Override
    public void eliminar(String correo) {
        ArrayList<Usuario> usuarios = this.getUsuarios();
        for (Usuario us : usuarios) {
            if (us.getCorreo().equals(correo)) {
                usuarios.remove(us);
            }
        }
    }
}