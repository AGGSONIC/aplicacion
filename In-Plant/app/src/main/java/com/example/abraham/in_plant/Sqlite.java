package com.example.abraham.in_plant;

/**
 * Created by Abraham on 24/11/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
public class Sqlite {
    SqliteAyudante sqliteHelper;
    SQLiteDatabase db;

    public Sqlite(Context context){
        sqliteHelper=new SqliteAyudante(context);
    }
    public void abrir(){
        db = sqliteHelper.getWritableDatabase();
    }
    public void cerrar()
    {
        sqliteHelper.close();
    }
    public Cursor getEstado(String id){
        return db.query("usuario",new String[]{"iduser","estado"},"iduser='"+id+"'",null,null,null,null);
    }
    public String imprimeEstado(Cursor cursor){
        StringBuffer strb=new StringBuffer();
        if(cursor.moveToFirst())
        strb.append(cursor.getString(1));
        return strb.toString();
    }
    public Cursor getCorreo(String mail){
        return db.query("usuario", new String[]{"iduser", "estado"}, "correo='" + mail + "'", null, null, null, null);
    }
    public String imprimeCorreo(Cursor cursor){
        StringBuffer strb=new StringBuffer();
        if(cursor.moveToFirst())
            strb.append(cursor.getString(0));
        return strb.toString();
    }
    public Cursor getUsuario(){
        return db.query("usuario",new String[]{"iduser","estado"},null,null,null,null,null);
    }
    public String imprimeUsuario(Cursor cursor){
        StringBuffer strb=new StringBuffer();
        if(cursor.moveToFirst())
            strb.append(cursor.getString(0));
        return strb.toString();
    }
    public long insertarAcaptado(String id,String mail){
        ContentValues contentValues=new ContentValues();
        contentValues.put("iduser",id);
        contentValues.put("estado",1);
        contentValues.put("correo",mail);
        return db.insert("usuario", null, contentValues);
    }
    public int actualizaUser(String id,int estdo){
        ContentValues contentValues=new ContentValues();
        contentValues.put("estado",estdo);
        return db.update("usuario",contentValues,"iduser='"+id+"'",null);
    }

}
