package com.example.abraham.in_plant;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class InicioSesion extends ActionBarActivity {

    private EditText usuario;
    private EditText contrasena;
    private TextView falloS;

    Sqlite sql=new Sqlite(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        sql.abrir();
        sql.cerrar();
        /*if(new Usuario().verSesion(sql)) {
            Intent i = new Intent(this, Dispositivos.class);
            startActivity(i);
        }*/
    }
    public void inicio(String... parametro){
        String correo=parametro[0];
        String pass=parametro[1];
        String id=parametro[2];
        String correold=parametro[3];
        String passold=parametro[4];
        Sqlite s=new Sqlite(this);
        s.abrir();
        s.insertarAcaptado(id,correo);
        System.out.println("aceptado"+s.getEstado(id));
    }
    public void nuevo (View view){
        Intent nuevoUser = new Intent(this,Registro.class);
        startActivity(nuevoUser);
    }

    public void botonInicio (View view){
        usuario=(EditText) findViewById(R.id.mail);
        contrasena=(EditText) findViewById(R.id.passw);
        Context context=getApplicationContext();
        String user=usuario.getText().toString();
        String pass=contrasena.getText().toString();
        falloS=(TextView) findViewById((R.id.errorS));
        if(user.equals("")||pass.equals("")){
            Toast.makeText(context,"Error Falta Contraseña y/o Correo",Toast.LENGTH_LONG).show();
            falloS.setText("Error Falta Contraseña y/o Correo");
        }
        else {
            Intent i =new Intent(this,Dispositivos.class);
            Usuario u = new Usuario(user, pass);
            u.iniciarSesion2(u, context,i,falloS);
        }
        //u.iniciarSesion(u, sql);
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                Cursor scorre=sql.getCorreo(usuario.getText().toString());
                String strcorre=sql.imprimeCorreo(scorre);
                Cursor sedo=sql.getEstado(strcorre);
                edo[0] =Integer.parseInt(sql.imprimeEstado(sedo));
            }
        }).start();*/
        /*if(u.coneccion(user,sql)) {
            Intent i = new Intent(this, Dispositivos.class);
            startActivity(i);
        }*/
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
