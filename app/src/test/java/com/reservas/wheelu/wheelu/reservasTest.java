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

import org.junit.Assert;
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
public class reservasTest {

    Reserva reservaModificada;

    @Test
    public void actualizar_reserva() {
        Retrofit retrofit;
        ReservaServices service;
        retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaServices.class);

        final Aleatorio aleatorio = new Aleatorio("jairolo@unisabana.edu.co", "2778286363762");

        final Reserva reservaInicial = new Reserva("Reserva1", "2", "jairolo@unisabana.edu.co");
        final Reserva reservaEsperada = new Reserva("ReservaModificada", "3", "jairolo@unisabana.edu.co");

        Call<Reserva> usuarioCall = service.modificarReserva("Reserva1", "ReservaModificada", "3", "jairolo@unisabana.edu.co", aleatorio);

        usuarioCall.enqueue(new Callback<Reserva>() {
            @Override
            public void onResponse(Call<Reserva> call, Response<Reserva> response) {
                reservaModificada = response.body();
                assertEquals(reservaEsperada.getNombreReserva(), reservaModificada.getNombreReserva());
            }

            @Override
            public void onFailure(Call<Reserva> call, Throwable t) {

            }
        });
    }

    @Test void  consultarreservas() {

    }
    @Test
    public void crearReserva(){
        Retrofit retrofit;
        ReservaServices service;
        retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaServices.class);

        final Aleatorio aleatorio = new Aleatorio("anaga@unisabana.edu.co", "18499046336826");

        final Reserva reservaInicial = new Reserva("Reserva ana", "anaa", "anaga@unisabana.edu.co");

        Call<Reserva> creacionCall = service.crearReserva(reservaInicial.getNombreReserva(), reservaInicial.getIDRutaReservada(),reservaInicial.getCorreoPasajero(), aleatorio);


        creacionCall.enqueue(new Callback<Reserva>() {
            @Override
            public void onResponse(Call<Reserva> call, Response<Reserva> response) {
                if(response != null){
                    assertEquals(response.body().getNombreReserva(), reservaInicial.getNombreReserva());
                }
            }

            @Override
            public void onFailure(Call<Reserva> call, Throwable t) {
            }
        });


    }


    @Test
    public void eliminarReserva(){
        Retrofit retrofit;
        ReservaServices service;
        retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaServices.class);

        final Aleatorio aleatorio = new Aleatorio("anaga@unisabana.edu.co", "18499046336826");

        final Reserva reservaInicial = new Reserva("Reserva ana", "anaa", "anaga@unisabana.edu.co");

        Call<Reserva> eliminacionCall = service.eliminarReserva(reservaInicial.getIDRutaReservada(), aleatorio);


        eliminacionCall.enqueue(new Callback<Reserva>() {
            @Override
            public void onResponse(Call<Reserva> call, Response<Reserva> response) {
                if(response != null){
                    assertEquals(response.body().getNombreReserva(), reservaInicial.getNombreReserva());
                }
            }

            @Override
            public void onFailure(Call<Reserva> call, Throwable t) {
            }
        });
    }


}