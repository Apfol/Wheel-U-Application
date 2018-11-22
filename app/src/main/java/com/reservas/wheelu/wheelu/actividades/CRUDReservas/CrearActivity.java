package com.reservas.wheelu.wheelu.actividades.CRUDReservas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reservas.wheelu.wheelu.R;
import com.reservas.wheelu.wheelu.ReservaServices;
import com.reservas.wheelu.wheelu.actividades.CRUDReservas.modificar.ModificarActivity;
import com.reservas.wheelu.wheelu.actividades.CRUDReservas.modificar.ModificarRealizadoActivity;
import com.reservas.wheelu.wheelu.actividades.LoginActivity;
import com.reservas.wheelu.wheelu.actividades.MenuActivity;
import com.reservas.wheelu.wheelu.entidades.Aleatorio;
import com.reservas.wheelu.wheelu.entidades.Pasajero;
import com.reservas.wheelu.wheelu.entidades.Reserva;
import com.reservas.wheelu.wheelu.entidades.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearActivity extends AppCompatActivity {
    Retrofit retrofit;
    ReservaServices service;
    EditText  iDRuta;
    Button btnReservar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);


        btnReservar = findViewById(R.id.btnReservar);

        final Pasajero usuarioLogeado = (Pasajero) getIntent().getExtras().getSerializable(MenuActivity.USUARIO_KEY);
        final Aleatorio aleatorio = (Aleatorio) getIntent().getExtras().getSerializable(LoginActivity.ALEATORIO_USUARIO_LOGEADO);
        // Obtener la infor de la Ruta con el intent
        iDRuta = findViewById(R.id.editTextIdRut);


        // Obtener nombre de reserva aleatorio desde otro endpoint
        final String nombreRes = "PegazoDorado";

        retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaServices.class);


        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearReserva(service, aleatorio, usuarioLogeado, nombreRes, iDRuta.getText().toString() );
            }
        });

    }

    private void crearReserva(ReservaServices service, Aleatorio aleatorio, Pasajero usuario, String nombreRes, String idRuta){
        Call<Reserva> reservaCallPost = service.crearReserva(nombreRes, idRuta, usuario.getCorreo(), aleatorio);

        reservaCallPost.enqueue(new Callback<Reserva>() {
            @Override
            public void onResponse(Call<Reserva> call, Response<Reserva> response) {
                Reserva reservaModificada = response.body();
                if(reservaModificada != null) {
                    Intent intent = new Intent(getApplicationContext(), MostrarReserva.class);
                    intent.putExtra(ModificarActivity.RESERVA_KEY, reservaModificada);
                    intent.putExtra(MenuActivity.TITULO_KEY, "Reserva creada");
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Reserva> call, Throwable t) {
                Toast.makeText(CrearActivity.this, "¡Falló la creacion!", Toast.LENGTH_LONG).show();

            }
        });
    }
}
