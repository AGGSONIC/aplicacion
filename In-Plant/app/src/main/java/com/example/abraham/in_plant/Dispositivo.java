package com.example.abraham.in_plant;

/**
 * Created by Abraham on 15/11/2015.
 */
public class Dispositivo extends SistemaRiego implements Planta {
    private int identificador;
    private int humedad;
    private SistemaRiego sistemadeRiego;
    Dispositivo(String serie,boolean edotanq,float temp, int ide,int humeda){
        super(edotanq,serie,temp);
    }
    void mostrarEstado(int identificador, int humedad,SistemaRiego sistemadeRiego){

    }
    void altaDispositivo(int identificador, int plant){
        
    }
    void bajaDispositivo(int identificador){

    }
    void modificarDispositivo(int identificador, int plant){

    }

}
