package com.reservas.wheelu.wheelu.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.reservas.wheelu.wheelu.R;
import com.reservas.wheelu.wheelu.ReservaService;
import com.reservas.wheelu.wheelu.entidades.Aleatorio;
import com.reservas.wheelu.wheelu.entidades.Pasajero;
import com.reservas.wheelu.wheelu.entidades.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuActivity extends AppCompatActivity {

    Retrofit retrofit;
    ReservaService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaService.class);

        Aleatorio aleatorioObjectUsuarioLogeado = (Aleatorio) getIntent().getExtras().getSerializable(LoginActivity.USUARIO_LOGEADO_KEY);
        Call<Pasajero> usuarioCall = service.usuario(aleatorioObjectUsuarioLogeado.getCorreo(), aleatorioObjectUsuarioLogeado);

        usuarioCall.enqueue(new Callback<Pasajero>() {
            @Override
            public void onResponse(Call<Pasajero> call, Response<Pasajero> response) {
                Pasajero pasajero = response.body();
            }

            @Override
            public void onFailure(Call<Pasajero> call, Throwable t) {
                Toast.makeText(MenuActivity.this, "¡Falló!", Toast.LENGTH_LONG).show();
            }
        });

        

    }
}
