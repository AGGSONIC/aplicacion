package com.example.abraham.in_plant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class InicioSesion extends ActionBarActivity {

    private EditText usuario=(EditText) findViewById(R.id.mail);
    private EditText contrasena=(EditText) findViewById(R.id.passw);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
    }

    public void nuevo (View view){
        Intent nuevoUser = new Intent(this,Registro.class);
        startActivity(nuevoUser);
    }

    public void botonInicio (View view){
        String user=usuario.getText().toString();
        String pass=contrasena.getText().toString();
        Usuario u=new Usuario(user,pass);
        u.iniciarSesion(u);
        if(true) {
            Intent i = new Intent(this, Dispositivos.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio_sesion, menu);
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
}
