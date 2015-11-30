package com.example.abraham.in_plant.model.connections;

/**
 * Created by Abraham on 29/11/2015.
 */

import com.example.abraham.in_plant.model.POJOS.TODOUserPojo;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
public interface TODOUserService {
    @GET("/cIP/verUsuario.php")
    void verUser(@Query("iduser") String id, Callback<ArrayList<TODOUserPojo>> callback);

}
