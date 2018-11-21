package com.reservas.wheelu.wheelu.actividades.CRUDReservas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reservas.wheelu.wheelu.R;
import com.reservas.wheelu.wheelu.actividades.LoginActivity;
import com.reservas.wheelu.wheelu.actividades.MenuActivity;
import com.reservas.wheelu.wheelu.entidades.Aleatorio;
import com.reservas.wheelu.wheelu.entidades.Pasajero;
import com.reservas.wheelu.wheelu.entidades.Reserva;
import com.reservas.wheelu.wheelu.servicios.ReservaServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModificarActivity extends AppCompatActivity {

    Retrofit retrofit;
    ReservaServices service;
    EditText nombreReserva, nuevoNombreReserva, nuevoIDRuta;
    Button btnModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        nombreReserva = findViewById(R.id.editTextNombreReserva);
        nuevoNombreReserva = findViewById(R.id.editTextNuevoNombre);
        nuevoIDRuta = findViewById(R.id.editTextIDRuta);
        btnModificar = findViewById(R.id.btnModificarReserva);

        Pasajero usuarioLogeado = (Pasajero) getIntent().getExtras().getSerializable(MenuActivity.USUARIO_KEY);
        Aleatorio aleatorio = (Aleatorio) getIntent().getExtras().getSerializable(LoginActivity.ALEATORIO_USUARIO_LOGEADO);

        retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaServices.class);

        actualizarReserva(service, aleatorio, usuarioLogeado, nombreReserva.getText().toString(),
                nuevoNombreReserva.getText().toString(), nuevoIDRuta.getText().toString());
    }

    //Se modifica ruta desde endpoint
    public void actualizarReserva(ReservaServices service, Aleatorio aleatorio, Pasajero pasajero,
                                  String nombreReserva, String nuevoNombre, String IDRuta) {
        Call<Reserva> usuarioCall = service.modificarReserva(nombreReserva, nuevoNombre, IDRuta, pasajero.getCorreo(), aleatorio);

        usuarioCall.enqueue(new Callback<Reserva>() {
            @Override
            public void onResponse(Call<Reserva> call, Response<Reserva> response) {
                Reserva reservaModificada = response.body();
            }

            @Override
            public void onFailure(Call<Reserva> call, Throwable t) {
                Toast.makeText(ModificarActivity.this, "¡Falló!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
