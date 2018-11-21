package com.reservas.wheelu.wheelu;

import com.reservas.wheelu.wheelu.entidades.Aleatorio;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReservaService {

    @GET("login/{correo}/{password}")
    Call<Aleatorio> iniciarSesion(@Path("correo") String correo, @Path("password") String password);

}
