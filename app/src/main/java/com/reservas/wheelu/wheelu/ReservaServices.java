package com.reservas.wheelu.wheelu;

import com.reservas.wheelu.wheelu.entidades.Aleatorio;
import com.reservas.wheelu.wheelu.entidades.ListaReservas;
import com.reservas.wheelu.wheelu.entidades.Pasajero;
import com.reservas.wheelu.wheelu.entidades.Reserva;
import com.reservas.wheelu.wheelu.entidades.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ReservaServices {

    @GET("login/{correo}/{password}")
    Call<Aleatorio> iniciarSesion(@Path("correo") String correo, @Path("password") String password);

    @POST("obtenerUsuario/{correo}")
    Call<Pasajero> usuario(@Path("correo") String correo, @Body Aleatorio aleatorio);

    @PUT("modificarReserva/{nombreReserva}/{nuevoNombre}/{nuevoIDRuta}/{correoPasajero}")
    Call<Reserva> modificarReserva(@Path("nombreReserva") String nombreReserva, @Path("nuevoNombre") String nuevoNombre,
                                   @Path("nuevoIDRuta") String nuevoIDRUTA, @Path("correoPasajero") String correoPasajero,
                                   @Body Aleatorio aleatorio);

    //@DELETE("eliminarReserva/{IdRuta}")
    @HTTP(method = "DELETE", path = "eliminarReserva/{IdRuta}", hasBody = true)
    Call<Reserva> eliminarReserva(@Path("IdRuta") String idRuta, @Body Aleatorio aleatorio);

    @POST("crearReserva/{nombreReserva}/{IDRutaReservada}/{correoPasajero}")
    Call<Reserva> crearReserva(@Path("nombreReserva") String nombreReserva,
                                   @Path("IDRutaReservada") String IDRUTA, @Path("correoPasajero") String correoPasajero,
                                   @Body Aleatorio aleatorio);

    @POST("consultarReservas/{correo}")
    Call<ListaReservas> obtenerReservas(@Path("correo") String correo, @Body Aleatorio aleatorio);
}
