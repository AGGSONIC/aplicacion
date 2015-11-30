package com.example.abraham.in_plant;

import android.content.Context;
import android.widget.Toast;

import com.example.abraham.in_plant.model.POJOS.RegistroPojo;
import com.example.abraham.in_plant.model.connections.RegistroService;
import com.example.abraham.in_plant.model.connections.UserService;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Abraham on 15/11/2015.
 */
public class Registrar extends Usuario{
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String repContrasena;

    Registrar(String nomb, String ape, String corre, String cont, String repCont){
        super(nomb,cont,corre);
        nombre=nomb;
        apellido=ape;
        correo=corre;
        contrasena=cont;
        repContrasena=repCont;
    }
    void registra(Registrar regis, final Context context){

        String mail=regis.correo;
        String pass=regis.contrasena;
        String name=regis.nombre;
        String last=regis.apellido;
        RestAdapter adapter=new RestAdapter.Builder().setEndpoint("http://grimsameridaa.sytes.net").build();
        RegistroService service=adapter.create(RegistroService.class);
        service.iniciar(mail, pass, name, last, new Callback<ArrayList<RegistroPojo>>() {
            @Override
            public void success(ArrayList<RegistroPojo> registroPojos, Response response) {
                RegistroPojo sign=registroPojos.get(0);
                if(Integer.parseInt(sign.getResp())==1){
                    Toast.makeText(context,"Registro Exitoso",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context,"Error #0R01 No se puedo resgistrar",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                    Toast.makeText(context,"Error en la conexion",Toast.LENGTH_LONG).show();
            }
        });
    }

    boolean verificaContrasena(String contrasena, String repContrasena){

        if(contrasena.equals(repContrasena))
            return true;
        else
            return false;
    }
    void modificarDatos(Usuario user, Registrar newuser){

    }
}
