package com.reservas.wheelu.wheelu.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.reservas.wheelu.wheelu.R;
import com.reservas.wheelu.wheelu.actividades.CRUDReservas.CrearActivity;
import com.reservas.wheelu.wheelu.actividades.CRUDReservas.EliminarActivity;
import com.reservas.wheelu.wheelu.actividades.CRUDReservas.ModificarActivity;
import com.reservas.wheelu.wheelu.actividades.CRUDReservas.VerActivity;
import com.reservas.wheelu.wheelu.entidades.Aleatorio;
import com.reservas.wheelu.wheelu.entidades.Pasajero;
import com.reservas.wheelu.wheelu.servicios.ReservaServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuActivity extends AppCompatActivity {

    public static String USUARIO_KEY = "usuario";

    Retrofit retrofit;
    ReservaServices service;
    TextView titulo;
    Pasajero pasajero = new Pasajero();
    Button btnModificarReserva, btnVerReservas, btnCrearReserva, btnEliminarReserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final Aleatorio aleatorioObjectUsuarioLogeado = (Aleatorio) getIntent().getExtras().getSerializable(LoginActivity.ALEATORIO_USUARIO_LOGEADO);

        titulo = findViewById(R.id.textView);
        btnModificarReserva = findViewById(R.id.btnModificarReserva);
        btnVerReservas = findViewById(R.id.btnVerReserva);
        btnCrearReserva = findViewById(R.id.btnCrearReserva);
        btnEliminarReserva = findViewById(R.id.btnEliminarReserva);

        retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaServices.class);
        pasajero = obtenerPasajero(service, aleatorioObjectUsuarioLogeado);

        btnModificarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModificarActivity.class);
                intent.putExtra(USUARIO_KEY, pasajero);
                intent.putExtra(LoginActivity.ALEATORIO_USUARIO_LOGEADO, aleatorioObjectUsuarioLogeado);
                startActivity(intent);
            }
        });
        /*btnVerReservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VerActivity.class);
                intent.putExtra(USUARIO_KEY, pasajeroObtenido);
                intent.putExtra(LoginActivity.ALEATORIO_USUARIO_LOGEADO, aleatorioObjectUsuarioLogeado);
                startActivity(intent);
            }
        });
        btnCrearReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CrearActivity.class);
                intent.putExtra(USUARIO_KEY, pasajeroObtenido);
                intent.putExtra(LoginActivity.ALEATORIO_USUARIO_LOGEADO, aleatorioObjectUsuarioLogeado);
                startActivity(intent);
            }
        });
        btnEliminarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EliminarActivity.class);
                intent.putExtra(USUARIO_KEY, pasajeroObtenido);
                intent.putExtra(LoginActivity.ALEATORIO_USUARIO_LOGEADO, aleatorioObjectUsuarioLogeado);
                startActivity(intent);
            }
        });*/

    }

    //Se obtiene pasajero desde endpoint
    public Pasajero obtenerPasajero(ReservaServices service, Aleatorio aleatorioObjectUsuarioLogeado) {
        Call<Pasajero> usuarioCall = service.usuario(aleatorioObjectUsuarioLogeado.getCorreo(), aleatorioObjectUsuarioLogeado);
        usuarioCall.enqueue(new Callback<Pasajero>() {
            @Override
            public void onResponse(Call<Pasajero> call, Response<Pasajero> response) {
                pasajero = response.body();
                titulo.setText("Welcome: " + pasajero.getNombre());
            }
            @Override
            public void onFailure(Call<Pasajero> call, Throwable t) {
                Toast.makeText(MenuActivity.this, "¡Falló!", Toast.LENGTH_LONG).show();
            }
        });
        return pasajero;
    }
}
