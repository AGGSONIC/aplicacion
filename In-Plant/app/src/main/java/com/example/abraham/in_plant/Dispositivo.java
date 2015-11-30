package com.example.abraham.in_plant;

import android.graphics.Color;
import android.widget.TextView;

import com.example.abraham.in_plant.model.POJOS.DispositivoPojo;
import com.example.abraham.in_plant.model.connections.DisposirivoService;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Abraham on 15/11/2015.
 */
public class Dispositivo extends SistemaRiego implements Planta {
    private int identificador;
    private int humedad;
    private SistemaRiego sistemadeRiego;
    Dispositivo(String serie){
        super(serie);
    }
    void mostrarEstado(SistemaRiego sistemadeRiego,final TextView humedad,final TextView temperatura){
        String id=sistemadeRiego.noSerie;
        RestAdapter adapter=new RestAdapter.Builder().setEndpoint("http://grimsameridaa.sytes.net") .build();
        DisposirivoService ds=adapter.create(DisposirivoService.class);
        ds.consulta(id, new Callback<ArrayList<DispositivoPojo>>() {
            @Override
            public void success(ArrayList<DispositivoPojo> dispositivoPojos, Response response) {
                DispositivoPojo disp=dispositivoPojos.get(0);
                float humedo=disp.getAmbhumedad();
                float temp=disp.getTemperatura();
                humedad.setText(humedo+" %");
                if(temp>25.0f) {
                    temperatura.setTextColor(Color.parseColor("#DF3A01"));
                    temperatura.setText(temp + "° C");
                }
                else {
                    temperatura.setTextColor(Color.parseColor("#0080FF"));
                    temperatura.setText(temp + "° C");
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
    void altaDispositivo(int identificador, int plant){
        
    }
    void bajaDispositivo(int identificador){

    }
    void modificarDispositivo(int identificador, int plant){

    }

}
