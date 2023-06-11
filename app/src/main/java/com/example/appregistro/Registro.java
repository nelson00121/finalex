package com.example.appregistro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Registro extends SQLiteOpenHelper {
    private static final String NOMBRE_DB = "registro_pacientes";
    private static final int Version_BD = 1;
    private static final String TABLA_REGISTRO = "CREATE TABLE REGISTRO(DPI TEXT PRIMARY KEY,NOMBRE TEXT, DIRECCION TEXT, TELEFONO TEXT)";

    public Registro(@Nullable Context context) {
        super(context, NOMBRE_DB,null, Version_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_REGISTRO);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLA_REGISTRO);
        sqLiteDatabase.execSQL(TABLA_REGISTRO);
    }
    public void Agregar(String dpi,String nombre,String dirreccion, String telefono){
        SQLiteDatabase DB = getWritableDatabase();
        if(DB == null){
            DB.execSQL("INSERT INTO REGISTRO VALUES('"+dpi+","+nombre+","+dirreccion+","+telefono+"')");
            DB.close();
        }
    }
}
