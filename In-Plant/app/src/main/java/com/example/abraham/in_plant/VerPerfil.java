package com.example.abraham.in_plant;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.abraham.in_plant.model.preferences.SessionPreference;

import org.w3c.dom.Text;


public class VerPerfil extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_perfil);
        nombre=(TextView) findViewById(R.id.vnomb);
        apellido=(TextView) findViewById(R.id.vapellido);
        mail=(TextView) findViewById(R.id.verCorreo);
        SessionPreference sp=new SessionPreference(getApplicationContext());
        Usuario u=new Usuario();
        u.verUsuario(sp.getId(),nombre,apellido,mail,getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ver_perfil, menu);
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
    private TextView nombre;
    private TextView mail;
    private TextView apellido;
}
