package com.reservas.wheelu.wheelu.actividades.CRUDReservas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reservas.wheelu.wheelu.R;
import com.reservas.wheelu.wheelu.ReservaServices;
import com.reservas.wheelu.wheelu.actividades.CRUDReservas.MostrarReserva;
import com.reservas.wheelu.wheelu.actividades.CRUDReservas.modificar.ModificarActivity;
import com.reservas.wheelu.wheelu.actividades.LoginActivity;
import com.reservas.wheelu.wheelu.actividades.MenuActivity;
import com.reservas.wheelu.wheelu.entidades.Aleatorio;
import com.reservas.wheelu.wheelu.entidades.Pasajero;
import com.reservas.wheelu.wheelu.entidades.Reserva;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EliminarActivity extends AppCompatActivity {

    //private ListView listView;
    private EditText editTextIdReserva;
    private Button btnEliminarReserva;
    Retrofit retrofit;
    ReservaServices service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        final Pasajero usuarioLogeado = (Pasajero) getIntent().getExtras().getSerializable(MenuActivity.USUARIO_KEY);
        final Aleatorio aleatorio = (Aleatorio) getIntent().getExtras().getSerializable(LoginActivity.ALEATORIO_USUARIO_LOGEADO);

        retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaServices.class);


        btnEliminarReserva = findViewById(R.id.btnEliminarReserva);
        editTextIdReserva = findViewById(R.id.editTextIdRutaR);

        btnEliminarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarReserva(service, editTextIdReserva.getText().toString(), aleatorio);
            }
        });


        //listView = (ListView)findViewById(R.id.listView);


        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }


    private void eliminarReserva(ReservaServices service, String idRuta, final Aleatorio aleatorio){
        Call<Reserva> resElCall = service.eliminarReserva(idRuta, aleatorio);

        resElCall.enqueue(new Callback<Reserva>() {
            @Override
            public void onResponse(Call<Reserva> call, Response<Reserva> response) {

                if(response.isSuccessful())
                {
                    Toast.makeText(EliminarActivity.this, "¡Reserva eliminada!", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(EliminarActivity.this, "¡Reserva eliminada!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(EliminarActivity.this, MenuActivity.class);
                intent.putExtra(LoginActivity.ALEATORIO_USUARIO_LOGEADO, aleatorio);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Reserva> call, Throwable t) {
                Toast.makeText(EliminarActivity.this, "¡Falló al eliminar!", Toast.LENGTH_LONG).show();

            }
        });
    }

}
