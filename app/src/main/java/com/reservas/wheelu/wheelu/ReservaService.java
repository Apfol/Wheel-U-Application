package com.reservas.wheelu.wheelu;

import com.reservas.wheelu.wheelu.entidades.Aleatorio;
import com.reservas.wheelu.wheelu.entidades.Pasajero;
import com.reservas.wheelu.wheelu.entidades.Reserva;
import com.reservas.wheelu.wheelu.entidades.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ReservaService {


    @GET("login/{correo}/{password}")
    Call<Aleatorio> iniciarSesion(@Path("correo") String correo, @Path("password") String password);

    @POST("obtenerUsuario/{correo}")
    Call<Usuario> obtenerUsuario(@Path("correo") String correo, @Body Aleatorio aleatorio);

    @POST("obtenerUsuario/{correo}")
    Call<Pasajero> usuario(@Path("correo") String correo, @Body Aleatorio aleatorio);

}
