package com.example.abraham.in_plant.model.connections;

import com.example.abraham.in_plant.model.POJOS.UsuarioPojo;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by cherrera on 11/25/2015.
 */
public interface UserService {

    @GET("/cIP/iniciar.php")
    void iniciar(
            @Query("c") String correo,
            @Query("p") String contraseña,
            Callback<ArrayList<UsuarioPojo>> callback
    );

}
