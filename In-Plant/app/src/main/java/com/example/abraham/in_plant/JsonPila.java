package com.example.abraham.in_plant;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Abraham on 23/11/2015.
 */
public class JsonPila extends AsyncTask<String,String,String> {
    @Override
    protected String doInBackground(String... params) {
        StringBuffer buffer=new StringBuffer();
        HttpURLConnection conectar=null;
        BufferedReader leido=null;
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
            String resp[]=new String[3];
            resp[0]=listas.getString("correo");
            resp[1]=listas.getString("pass");
            resp[2]=listas.getString("idusuario");

            Usuario u=new Usuario();
            u.setUsuario(resp[0]);
            u.setCorreo(resp[1]);
            u.setContrasena(resp[2]);
        } catch (JSONException|IOException e) {
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
        return buffer.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }
    public String resp(String result){

        return result;
    }
}
