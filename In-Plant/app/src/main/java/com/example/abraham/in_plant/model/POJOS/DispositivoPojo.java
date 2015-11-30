package com.example.abraham.in_plant.model.POJOS;

/**
 * Created by Abraham on 30/11/2015.
 */
public class DispositivoPojo {
    private int nummazetas;
    private float temperatura;
    private float humedad;
    private float humedadopt;
    private float humedadmax;
    private float humedadmin;
    private float ambhumedad;

    public float getAmbhumedad() {
        return ambhumedad;
    }

    public int getNummazetas() {
        return nummazetas;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public float getHumedad() {
        return humedad;
    }

    public float getHumedadopt() {
        return humedadopt;
    }

    public float getHumedadmax() {
        return humedadmax;
    }

    public float getHumedadmin() {
        return humedadmin;
    }
}
