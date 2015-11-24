package com.example.abraham.in_plant;

/**
 * Created by Abraham on 24/11/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteAyudante extends SQLiteOpenHelper {
    public SqliteAyudante(Context context){
        super(context,"sesion",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuario (iduser TEXT PRIMARY KEY NOT NULL, estado INTEGER,correo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS usuario");
        //y luego creamos la nueva tabla
        db.execSQL( "CREATE TABLE usuario (iduser TEXT PRIMARY KEY AUTOINCREMENT NOT NULL, estado INTEGER,correo TEXT)" );
    }
}
