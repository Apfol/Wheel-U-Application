package com.reservas.wheelu.wheelu;

import android.content.Intent;
import android.widget.Toast;

import com.reservas.wheelu.wheelu.actividades.CRUDReservas.modificar.ModificarActivity;
import com.reservas.wheelu.wheelu.actividades.CRUDReservas.modificar.ModificarRealizadoActivity;
import com.reservas.wheelu.wheelu.actividades.LoginActivity;
import com.reservas.wheelu.wheelu.actividades.MenuActivity;
import com.reservas.wheelu.wheelu.entidades.Aleatorio;
import com.reservas.wheelu.wheelu.entidades.Pasajero;
import com.reservas.wheelu.wheelu.entidades.Reserva;

import org.junit.Before;
import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class actualizarReservaTest {

    @Test
    public void actualizar_Reserva() {
        Retrofit retrofit;
        ReservaServices service;
        retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaServices.class);

        //final Pasajero usuarioLogeado = new Pasajero("Jario lopez", "jairolo@unisabana.edu.co", "jairo123", "1073525507");
        final Aleatorio aleatorio = new Aleatorio("jairolo@unisabana.edu.co", "54");

        final Reserva reservaInicial = new Reserva("Reserva1", "2", "jairolo@unisabana.edu.co");
        final Reserva reservaEsperada = new Reserva("ReservaModificada", "3", "jairolo@unisabana.edu.co");


        Call<Reserva> usuarioCall = service.modificarReserva("Reserva1", "ReservaModificada", "3", "jairolo@unisabana.edu.co", aleatorio);

        usuarioCall.enqueue(new Callback<Reserva>() {
            @Override
            public void onResponse(Call<Reserva> call, Response<Reserva> response) {
                Reserva reservaModificada = response.body();
                 assertEquals(reservaEsperada, reservaModificada);
            }

            @Override
            public void onFailure(Call<Reserva> call, Throwable t) {

            }
        });


    }
}