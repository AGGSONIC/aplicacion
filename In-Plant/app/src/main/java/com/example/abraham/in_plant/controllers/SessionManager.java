package com.example.abraham.in_plant.controllers;

import android.content.Context;

import com.example.abraham.in_plant.model.preferences.SessionPreference;

/**
 * Created by cherrera on 11/25/2015.
 */
public class SessionManager {

    //Por que es estatico? por que solo necesitamos una instancia de la variable durante toda la vida de la app
    //Siendo estatico entonces el valor se mantendra, aunque se cree otro objeto.
    //Pero tampoco queremos que otros objetos cambien el valor de la variable por lo que se pone privado
    private static SessionPreference session;

    public SessionManager(Context context){
        session = getSession(context); //aqui nos aseguramos de siempre tener la sesion cargada al crear el objeto
    }

    //Este metodo nos ayuda a instanciar el objeto de session solo una vez.
    //Es estatico tambien.
    //EL metodo comprueba si la variable esta instanciada, si no esta la instancia, si ya esta solo la devuelve
    public static SessionPreference getSession(Context context){
        if (session == null){
            session = new SessionPreference(context);
        }
        return session;
    }

    public void logIn(String username, String password, String id){
        //if()
        session.setUsername(username);
        session.setId(id);
        session.setIsLogged(true);

        session.save();
        session.load();
    }

    public void logOut(){
        session.clear();
        session.load();
    }

    public boolean checkSession(){
        return session.isLogged();
    }
}
