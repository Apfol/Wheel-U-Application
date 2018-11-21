package com.reservas.wheelu.wheelu.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.reservas.wheelu.wheelu.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String correoUsuarioLogeado = getIntent().getExtras().getString(LoginActivity.USUARIO_LOGEADO_KEY);




    }
}
