package com.example.abraham.in_plant;

/**
 * Created by Abraham on 15/11/2015.
 */
//asdfs
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abraham.in_plant.controllers.SessionManager;
import com.example.abraham.in_plant.model.POJOS.UsuarioPojo;
import com.example.abraham.in_plant.model.connections.UserService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Usuario {
    private String usuario;
    private String contrasena;
    private String correo;
    Sqlite sql;
    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Usuario(){

    }
    public Usuario(String mail,String pass){
        correo=mail;
        contrasena=pass;
    }
    public Usuario(String user,String pass,String mail){

    }
    public boolean iniciarSesion(Usuario user,Sqlite s){
        JsonPila2 jason=new JsonPila2();
        String quien=user.correo;
        String contra=user.contrasena;
        sql=s;
        jason.execute("http://mayanki.mx/cIP/iniciar.php?c="+quien+"&p="+contra,quien,contra);
        System.out.println("quien " + quien);
        System.out.println("contra "+contra);
        System.out.println("correo "+correo);
        System.out.println("pass "+contrasena);
        System.out.println("id" + usuario);

        return true;
    }

    public void iniciarSesion2(Usuario user, final Context context, final Intent i, final TextView fallos){

        String correo = user.correo;
        String pass = user.contrasena;

        RestAdapter adapter = new RestAdapter.Builder() .setEndpoint("http://mayanki.mx") .build();
        UserService service = adapter.create(UserService.class);

        service.iniciar(correo, pass, new Callback<ArrayList<UsuarioPojo>>() {
            @Override
            public void success(ArrayList<UsuarioPojo> usuarios, Response response) {

                SessionManager manager = new SessionManager(context);
                UsuarioPojo user = usuarios.get(0);
                if(user.getPass().equals(contrasena)){
                    manager.logIn( user.getCorreo(), user.getPass(), user.getIdusuario() );
                    fallos.setTextColor(Color.parseColor("#01DF3A"));
                    fallos.setText("Iniciando Sesion");
                    //Toast.makeText(context,"Bienvenido "+)
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }
                else{
                    Toast.makeText(context,"Contraseña y/o Correo Erroneos Intente de nuevo",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void failure(RetrofitError error) {
                //hacer algo cuando falle
                Toast.makeText(context,"Error de Conexion (Compruebe su conexion a internet)",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void verifica(String... parametro){
        String correo=parametro[0];
        String pass=parametro[1];
        String id=parametro[2];
        String correold=parametro[3];
        String passold=parametro[4];
        if(pass.equals(passold)){
            sql.abrir();
            try {
                sql.insertarAcaptado(id, correo);
                Cursor edo = sql.getEstado(id);

                System.out.println("aceptado" + sql.imprimeEstado(edo));
                sql.cerrar();
            }
            catch (Exception e){
                sql.actualizaUser(id,1);
            }
        }
    }
    public boolean verSesion(Sqlite sql){
        sql.abrir();
        Cursor scorre=sql.getUsuario();
        String strcorre=sql.imprimeCorreo(scorre);
        Cursor sedo=sql.getEstado(strcorre);
        int edo =Integer.parseInt(sql.imprimeEstado(sedo));
        sql.cerrar();
        if(edo ==1) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean coneccion(String usuario,Sqlite sql){
        sql.abrir();
        Cursor scorre=sql.getCorreo(usuario);
        String strcorre=sql.imprimeCorreo(scorre);
        Cursor sedo=sql.getEstado(strcorre);
        int edo =Integer.parseInt(sql.imprimeEstado(sedo));
        sql.cerrar();
        if(edo ==1) {
            return true;
        }
        else{
            return false;
        }

    }
    public class JsonPila2 extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String... params) {
            StringBuffer buffer=new StringBuffer();
            HttpURLConnection conectar=null;
            BufferedReader leido=null;
            String respuesta=null;
            try {
                URL direccion=new URL(params[0]);
                conectar=(HttpURLConnection) direccion.openConnection();
                conectar.connect();
                InputStream stream=conectar.getInputStream();
                leido=new BufferedReader(new InputStreamReader(stream));

                String linea="";
                while((linea=leido.readLine())!=null){
                    buffer.append(linea);
                }
                String aJson=buffer.toString();

                JSONArray jsonArray=new JSONArray(aJson);
                JSONObject listas=jsonArray.getJSONObject(0);
                String resp[]=new String[5];
                resp[0]=listas.getString("correo");
                resp[1]=listas.getString("pass");
                resp[2]=listas.getString("idusuario");
                resp[3]=params[1];
                resp[4]=params[2];

                verifica(resp);/*
                setUsuario(resp[0]);
                correo=(resp[1]);
                contrasena=(resp[2]);
                respuesta=resp[0]+"/"+resp[1]+"/"+resp[2];*/
            } catch (JSONException |IOException e) {
                e.printStackTrace();
            }
            finally {
                if(conectar!=null)
                    conectar.disconnect();

                try {
                    leido.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return respuesta;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        public String resp(String result){

            return result;
        }
    }

}
