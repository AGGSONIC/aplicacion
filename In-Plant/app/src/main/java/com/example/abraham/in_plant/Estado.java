package com.example.abraham.in_plant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.abraham.in_plant.controllers.SessionManager;


public class Estado extends ActionBarActivity {

    private TextView humedad;
    private TextView temperatura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado);
        humedad=(TextView) findViewById(R.id.humedadg);
        temperatura=(TextView) findViewById(R.id.temp);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Dispositivo dispositivo = new Dispositivo("0");

                    dispositivo.mostrarEstado(dispositivo, humedad, temperatura);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_estado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()){
            case R.id.gestPlant:
                Intent gestin = new Intent(this,Dispositivos.class);
                startActivity(gestin);
                break;
            case R.id.cierraSesion:
                new SessionManager(getApplicationContext()).logOut();
                Intent cierre = new Intent(this, InicioSesion.class);
                startActivity(cierre);
                break;
            case R.id.verPerfi:
                Intent perfilin = new Intent(this, VerPerfil.class);
                startActivity(perfilin);
                break;

        }

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);


    }
}
