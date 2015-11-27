package com.example.abraham.in_plant.model.connections;

/**
 * Created by Abraham on 27/11/2015.
 */
import com.example.abraham.in_plant.model.POJOS.RegistroPojo;
import com.example.abraham.in_plant.model.POJOS.UsuarioPojo;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface RegistroService {
    @GET("/cIP/newUser.php")
    void iniciar(@Query("correo") String correo,@Query("contrasena") String contresena,
                 @Query("nombre") String nombre,@Query("apeido") String apellido,
                 Callback<ArrayList<RegistroPojo>> callback);
}
