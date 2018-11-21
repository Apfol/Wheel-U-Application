package com.reservas.wheelu.wheelu.actividades.CRUDReservas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.reservas.wheelu.wheelu.R;
import com.reservas.wheelu.wheelu.actividades.LoginActivity;
import com.reservas.wheelu.wheelu.actividades.MenuActivity;
import com.reservas.wheelu.wheelu.entidades.Aleatorio;
import com.reservas.wheelu.wheelu.entidades.Pasajero;

public class ModificarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        Pasajero usuarioLogeado = (Pasajero) getIntent().getExtras().getSerializable(MenuActivity.USUARIO_KEY);

        
    }
}
