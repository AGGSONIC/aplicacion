package com.example.abraham.in_plant.model.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by cherrera on 11/25/2015.
 */
public class SessionPreference {

    /*
     * El nombre del archivo de session;
     */
    private static final String PREFERENCE_SESSION_NAME = "session_in_plant";

    /*
     * El archivo es un XML, tiene variables, las siguientes cadenas hacen referencia al nombre de la variable
     */
    private static final String ID_USUARIO_FIELD = "id", USERNAME_FIELD = "username", PASSWORD_FIELD = "password";
    private static final String IS_LOGGED = "isLogged"; //Esta variable del xml determina si esta iniciada la sesion o no


    /*
     * La primera vez que se checa, por obvias razones el archivo no existe, por lo que hay que dar
     * valores default a las variables.
     */
    private static final String ID_USUARIO_DEFAULT = "";
    private static final String USERNAME_DEFAULT = "", PASSWORD_DEFFAULT = "";
    private static final boolean IS_LOGGED_DEFAULT = false;


    //============================================================================================


    private Context context;
    private SharedPreferences preferences;

    private String id;
    private String username;
    private String password;
    private boolean isLogged;


    public SessionPreference (Context context){
        this.context = context;
        load();
    }

    //Carga el archivo XML de sesion
    public void load() {
        /*
         * El objeto preferences, es el encargado de cargar un archivo de preferencias
         * getSharedPreferences trae un archivo de preferencias XML con el nombre que se de.
         * MODE_PRIVATE indica que el archivo de preferencias solo puede ser accesado desde la aplicacion que lo escribe
         */
        preferences = context.getSharedPreferences(PREFERENCE_SESSION_NAME, context.MODE_PRIVATE);

        //Del archivo de preferencias se recogen los valores en el, si no existen, se agarra el default
        this.id = preferences.getString(ID_USUARIO_FIELD, ID_USUARIO_DEFAULT);
        this.username = preferences.getString(USERNAME_FIELD, USERNAME_DEFAULT);
        this.password = preferences.getString(PASSWORD_FIELD, PASSWORD_DEFFAULT);
        this.isLogged = preferences.getBoolean(IS_LOGGED, IS_LOGGED_DEFAULT);
    }

    //Guarda los cambios
    public void save(){
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(ID_USUARIO_FIELD, id);
        editor.putString(USERNAME_FIELD, username);
        editor.putString(PASSWORD_FIELD, password);
        editor.putBoolean(IS_LOGGED, isLogged);

        editor.commit(); //Escribe los datos en el archivo
    }

    //Limpia las variables del archivo (las elimina realmente)
    public void clear(){
        SharedPreferences.Editor editor = preferences.edit();

        editor.clear();

        editor.commit();
    }


    //getters and setters

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        //System.out.println("setId "+id);
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }
}
