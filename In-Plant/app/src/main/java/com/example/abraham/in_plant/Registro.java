package com.example.abraham.in_plant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Registro extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }
    //visualizar boton registrar
    public void botonRegistrar (View view){
        nombre=(EditText) findViewById(R.id.nombre);
        apellido=(EditText) findViewById(R.id.apellido);
        mailr=(EditText) findViewById(R.id.mailr);
        passr=(EditText) findViewById(R.id.passr);
        rpassr=(EditText) findViewById(R.id.rpassr);
        Registrar regis=new Registrar(nombre.getText().toString(),apellido.getText().toString(),mailr.getText().toString(),passr.getText().toString(),rpassr.getText().toString());
        if(!(nombre.getText().equals("")||apellido.getText().equals("")||mailr.getText().equals("")||passr.getText().equals("")||rpassr.getText().equals("")))
        {
            if(regis.verificaContrasena(passr.getText().toString(),rpassr.getText().toString())) {
                regis.registra(regis,getApplicationContext());
                Intent botonReg = new Intent(this, InicioSesion.class);
                startActivity(botonReg);
                //Toast.makeText(getApplicationContext(),"Error Las contrasenas no coiciden",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"Error Las contrasenas no coiciden",Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"Faltan Campos por llenar",Toast.LENGTH_SHORT).show();
        }
    }

    public void botonCancelar (View view){
        Intent botonCancel = new Intent(this,InicioSesion.class);
        startActivity(botonCancel);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private EditText nombre;
    private EditText apellido;
    private EditText mailr;
    private EditText passr;
    private EditText rpassr;
}
