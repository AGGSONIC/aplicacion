package com.example.abraham.in_plant;

/**
 * Created by Abraham on 15/11/2015.
 */
public class Usuario {
    private String usuario;
    private String contrasena;
    private String correo;
    public Usuario(){

    }
    public Usuario(String mail,String pass){
        correo=mail;
        contrasena=pass;
    }
    public Usuario(String user,String pass,String mail){

    }
    public boolean iniciarSesion(Usuario user){
        JsonPila jason=new JsonPila();
        jason.execute("http://mayanki.mx/cIP/iniciar.php");
        String quien=user.correo;
        String contra=user.contrasena;
        return true;
    }
}
