package com.example.pablosanjuan.core.db;

import com.example.pablosanjuan.core.vo.InventarioVO;
import com.example.pablosanjuan.core.vo.UsuarioVO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DbManager_usuario {

    public static final String TABLE_NAME = "Usuario";
    public static final String  ID = "_id";
    public static final String NOMBRE = "Nombre";
    public static final String DIRECCION = "Direccion";
    public static final String USUARIO = "Usuario";
    public static final String CONTRASENA = "Contrasena";

    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + ID + " integer primary key autoincrement,"
            + NOMBRE + " text not null,"
            + DIRECCION + " text not null,"
            + USUARIO + " text not null,"
            + CONTRASENA + " text not null);";

    private DbHelper helper;
    private SQLiteDatabase db;
    private Cursor dbCursor;

    public DbManager_usuario(Context context){
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public ContentValues generarContentValues (String nombre, String direccion, String usuario, String contrasena){
        ContentValues valores = new ContentValues();
        valores.put(NOMBRE, nombre);
        valores.put(DIRECCION, direccion);
        valores.put(USUARIO, usuario);
        valores.put(CONTRASENA, contrasena);
        return valores;
    }

    public void insertar (String nombre, String direccion, String usuario, String contrasena){
        db.insert(TABLE_NAME, null, generarContentValues(nombre, direccion, usuario, contrasena));
    }

    public Cursor cargarCursorRegistro(){
        String[] columnas = new String[]{ID, NOMBRE, DIRECCION, USUARIO, CONTRASENA};
        return db.query(TABLE_NAME, columnas, null, null, null, null, null);
    }

    public List<UsuarioVO> getRegistros() {
        List<UsuarioVO> listaRegistros = null;
        String[] columnas = new String[]{ID, NOMBRE, DIRECCION, USUARIO, CONTRASENA};
        dbCursor = db.query(TABLE_NAME, columnas, null, null, null, null, null);
        if (dbCursor.getCount() > 0) {
            listaRegistros = new ArrayList<UsuarioVO>();
            dbCursor.moveToFirst();
            while (!dbCursor.isAfterLast()) {
                UsuarioVO registro = new UsuarioVO();
                registro.setId((dbCursor.getString(0)));
                registro.setNombre(dbCursor.getString(1));
                registro.setDireccion(dbCursor.getString(2));
                registro.setUsuario(dbCursor.getString(3));
                registro.setContrasena(dbCursor.getString(4));
                listaRegistros.add(registro);
                dbCursor.moveToNext();
            }
        }
        dbCursor.close();
        return listaRegistros;
    }

    public void borrarRegistros(){
        db.delete(TABLE_NAME, null, null);
    }

}
