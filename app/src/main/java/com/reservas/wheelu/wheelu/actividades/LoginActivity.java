package com.reservas.wheelu.wheelu.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reservas.wheelu.wheelu.entidades.Aleatorio;
import com.reservas.wheelu.wheelu.R;
import com.reservas.wheelu.wheelu.servicios.ReservaServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    public static String BASE_URL = "https://wheel-u-reservas.appspot.com/_ah/api/reservas/v1/";
    public static String ALEATORIO_USUARIO_LOGEADO = "aleatorio";
    Retrofit retrofit;
    ReservaServices service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaServices.class);
        Button iniciarSesion = findViewById(R.id.buttonIniciarSesion);
        final EditText correo = findViewById(R.id.editTextCorreo);
        final EditText password = findViewById(R.id.editTextPassword);


        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<Aleatorio> aleatorioCall = service.iniciarSesion(correo.getText().toString().trim(), password.getText().toString().trim());
                aleatorioCall.enqueue(new Callback<Aleatorio>() {
                    @Override
                    public void onResponse(Call<Aleatorio> call, Response<Aleatorio> response) {
                        Aleatorio aleatorio = response.body();
                        if(aleatorio != null) {
                            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                            intent.putExtra(ALEATORIO_USUARIO_LOGEADO, aleatorio);
                            startActivity(intent);
                        }  else {
                            Toast.makeText(LoginActivity.this, "Usuario no registrado, intentalo de nuevo",Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Aleatorio> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "¡Falló!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }
}
