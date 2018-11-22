package com.reservas.wheelu.wheelu;
import android.content.Intent;
import android.widget.Toast;

import com.reservas.wheelu.wheelu.actividades.LoginActivity;
import com.reservas.wheelu.wheelu.actividades.MenuActivity;
import com.reservas.wheelu.wheelu.entidades.Aleatorio;
import com.reservas.wheelu.wheelu.entidades.ListaReservas;
import com.reservas.wheelu.wheelu.entidades.Pasajero;
import com.reservas.wheelu.wheelu.entidades.Reserva;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;
public class ReservasIntegracion {

    @Test
    public void login_crear(){
        Retrofit retrofit;
        final ReservaServices service;
        retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaServices.class);
        final Pasajero pasajero = new Pasajero("Ana Garcia", "anaga@unisabana.edu.co", "ana123", "1234567889");
        Call<Aleatorio> aleatorioCall = service.iniciarSesion(pasajero.getCorreo(), pasajero.getContrasena());
        aleatorioCall.enqueue(new Callback<Aleatorio>() {
            @Override
            public void onResponse(Call<Aleatorio> call, Response<Aleatorio> response) {
                Aleatorio aleatorio = response.body();
                final Reserva reservaEsperada = new Reserva("Reserva ana", "anaa", pasajero.getCorreo());
                Call<Reserva> creacionCall = service.crearReserva(reservaEsperada.getNombreReserva(), reservaEsperada.getIDRutaReservada(),reservaEsperada.getCorreoPasajero(), aleatorio);
                creacionCall.enqueue(new Callback<Reserva>() {
                    @Override
                    public void onResponse(Call<Reserva> call, Response<Reserva> response) {
                        assertEquals(response.body().getNombreReserva(), reservaEsperada.getNombreReserva());
                    }
                    @Override
                    public void onFailure(Call<Reserva> call, Throwable t) {
                    }
                });
            }
            @Override
            public void onFailure(Call<Aleatorio> call, Throwable t) {

            }
        });
    }

    @Test
    public void buscar_reservas_ruta() {
        final String idRuta = "4";

        Retrofit retrofit;
        final ReservaServices service;
        retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaServices.class);

        Call<ListaReservas> usuarioCall = service.obtenerTodasReservas();

        final List<Reserva> reservasEsperadas = new ArrayList<>();
        reservasEsperadas.add(new Reserva("Reserva4", "4", "anaga@unisabana.edu.co"));
        reservasEsperadas.add(new Reserva("Reserva5", "4", "jairolo@unisabana.edu.co"));


        usuarioCall.enqueue(new Callback<ListaReservas>() {
            @Override
            public void onResponse(Call<ListaReservas> call, Response<ListaReservas> response) {
                List<Reserva> reservasRuta  = new ArrayList<>();

                for(Reserva reserva: response.body().getReservas()) {
                    if(reserva.getIDRutaReservada().equals(idRuta)) {
                        reservasRuta.add(reserva);
                    }
                }
                assertArrayEquals(reservasEsperadas.toArray(), reservasRuta.toArray());
            }
            @Override
            public void onFailure(Call<ListaReservas> call, Throwable t) {

            }
        });
    }

    @Test
    public void login_actualizar() {
        Retrofit retrofit;
        final ReservaServices service;
        retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ReservaServices.class);
        final Pasajero pasajero = new Pasajero("Ana Garcia", "anaga@unisabana.edu.co", "ana123", "1234567889");
        Call<Aleatorio> aleatorioCall = service.iniciarSesion(pasajero.getCorreo(), pasajero.getContrasena());
        aleatorioCall.enqueue(new Callback<Aleatorio>() {
            @Override
            public void onResponse(Call<Aleatorio> call, Response<Aleatorio> response) {
                Aleatorio aleatorio = response.body();
                Call<ListaReservas> usuarioCall = service.obtenerReservas("anaga@unisabana.edu.co", aleatorio);

                final List<Reserva> reservasEsperadas = new ArrayList<>();
                reservasEsperadas.add(new Reserva("Reserva3", "4", "anaga@unisabana.edu.co"));
                reservasEsperadas.add(new Reserva("Reserva4", "7", "anaga@unisabana.edu.co"));

                usuarioCall.enqueue(new Callback<ListaReservas>() {
                    @Override
                    public void onResponse(Call<ListaReservas> call, Response<ListaReservas> response) {
                        List<Reserva> reservasObtenidas = response.body().getReservas();
                        assertArrayEquals(reservasEsperadas.toArray(), reservasObtenidas.toArray());
                    }

                    @Override
                    public void onFailure(Call<ListaReservas> call, Throwable t) {

                    }
                });
            }
            @Override
            public void onFailure(Call<Aleatorio> call, Throwable t) {

            }
        });
    }

}
