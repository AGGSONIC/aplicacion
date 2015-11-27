package com.example.abraham.in_plant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.abraham.in_plant.controllers.SessionManager;


public class Dispositivos extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispositivos);
    }

    public void modificarBoton(View view){
        Intent modifBoton = new Intent(this,Modificar.class);
        startActivity(modifBoton);
    }

    public void verBoton (View view){
        Intent verBotonin = new Intent(this, Estado.class);
        startActivity(verBotonin);
    }

    public void agregarPlant (View view){
        Intent agregarPlant = new Intent(this, Agregar.class);
        startActivity(agregarPlant);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dispositivos, menu);
        return true;
    }
//JHG
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()){

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

        return super.onOptionsItemSelected(item);
    }
}
