package com.reservas.wheelu.wheelu.entidades;

import java.util.ArrayList;

public class Conductor extends Usuario{

    public Conductor(String nombre, String correo, String contrasena, String documento) {
        super(nombre, correo, contrasena, documento);
    }

    public Conductor() {

    }

    @Override
    public void consultar() {
        String datosUsuarios = "";
        ArrayList<Usuario> usuarios = this.getUsuarios();
        for (Usuario us: usuarios) {
            if(us instanceof Conductor) {
                datosUsuarios += us.getNombre() + " " + us.getCorreo() + "\n";
            }
        }
    }

    @Override
    public void eliminar(String correo) {
        ArrayList<Usuario> usuarios = this.getUsuarios();
        for (Usuario us: usuarios) {
            if(us.getCorreo().equals(correo)) {
                usuarios.remove(us);
            }
        }
    }

}
