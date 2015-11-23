package com.example.abraham.in_plant;

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
    void registra(Registrar regis){


    }

    boolean verificaContrasena(String contrasena, String repContrasena){

        return true;
    }
    void modificarDatos(Usuario user, Registrar newuser){

    }
}
