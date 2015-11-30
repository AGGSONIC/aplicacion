package com.example.abraham.in_plant.model.connections;

/**
 * Created by Abraham on 30/11/2015.
 */
import com.example.abraham.in_plant.model.POJOS.DispositivoPojo;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
public interface DisposirivoService {
    @GET("/cIP/edoInplant.php")
    void consulta(
            @Query("id") String id,
            Callback<ArrayList<DispositivoPojo>>callback
    );
}
