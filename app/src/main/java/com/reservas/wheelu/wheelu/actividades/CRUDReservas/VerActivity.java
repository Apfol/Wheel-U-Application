package com.reservas.wheelu.wheelu.actividades.CRUDReservas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.reservas.wheelu.wheelu.Adapter;
import com.reservas.wheelu.wheelu.R;
import com.reservas.wheelu.wheelu.ReservaServices;
import com.reservas.wheelu.wheelu.actividades.LoginActivity;
import com.reservas.wheelu.wheelu.actividades.MenuActivity;
import com.reservas.wheelu.wheelu.entidades.Aleatorio;
import com.reservas.wheelu.wheelu.entidades.ListaReservas;
import com.reservas.wheelu.wheelu.entidades.Pasajero;
import com.reservas.wheelu.wheelu.entidades.Reserva;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VerActivity extends AppCompatActivity {

    RecyclerView reyclerViewUser;
    Retrofit retrofit;
    ReservaServices service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        final Pasajero usuarioLogeado = (Pasajero) getIntent().getExtras().getSerializable(MenuActivity.USUARIO_KEY);
        final Aleatorio aleatorio = (Aleatorio) getIntent().getExtras().getSerializable(LoginActivity.ALEATORIO_USUARIO_LOGEADO);

        reyclerViewUser = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        reyclerViewUser.setHasFixedSize(true);

        // use a linear layout manager
        reyclerViewUser.setLayoutManager(new LinearLayoutManager(this));



        retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaServices.class);
        Call<ListaReservas> usuarioCall = service.obtenerReservas(usuarioLogeado.getCorreo(), aleatorio);

        usuarioCall.enqueue(new Callback<ListaReservas>() {
            @Override
            public void onResponse(Call<ListaReservas> call, Response<ListaReservas> response) {
                // specify an adapter with the list to show
                List<Reserva> reservas = response.body().getReservas();
                Adapter mAdapter = new Adapter(response.body().getReservas());
                reyclerViewUser.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ListaReservas> call, Throwable t) {
                Toast.makeText(VerActivity.this, "¡Falló!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
