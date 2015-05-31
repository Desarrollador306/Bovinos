package com.example.pablosanjuan.core.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.pablosanjuan.core.vo.InventarioVO;
import java.util.ArrayList;
import java.util.List;

public class DbManager_inventario {

	public static final String TABLE_NAME = "Inventario";
	public static final String  ID = "_id";
    public static final String  ID_BOVINO = "IdBovino";
    public static final String NOMBRE = "Nombre";
	public static final String FECHA = "Fecha";
	public static final String GENERO = "Genero";
	public static final String PROPOSITO = "Proposito";
    public static final String PESO = "Peso";
    public static final String COLOR = "Color";
    public static final String RAZA = "Raza";
    public static final String IDPADRE = "id_padre";
    public static final String IDMADRE = "id_madre";

	public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + ID + " integer primary key autoincrement,"
            + ID_BOVINO + " text not null,"
			+ NOMBRE + " text not null,"
			+ FECHA + " text not null,"
			+ GENERO + " text not null,"
            + PROPOSITO + " text not null,"
            + PESO + " text not null,"
            + COLOR + " text not null,"
            + RAZA + " text not null,"
            + IDPADRE + " text not null,"
			+ IDMADRE + " text not null);";

	private DbHelper helper;
	private SQLiteDatabase db;
	private Cursor dbCursor;

	public DbManager_inventario(Context context){
		helper = new DbHelper(context);
		db = helper.getWritableDatabase();
	}
	
	public ContentValues generarContentValues (String id, String nombre, String fecha, String genero, String proposito, String peso, String color, String raza, String id_padre, String id_madre){
		ContentValues valores = new ContentValues();
        valores.put(ID_BOVINO, id);
        valores.put(NOMBRE, nombre);
		valores.put(FECHA, fecha);
		valores.put(GENERO, genero);
		valores.put(PROPOSITO, proposito);
        valores.put(PESO, peso);
        valores.put(COLOR, color);
        valores.put(RAZA, raza);
        valores.put(IDPADRE, id_padre);
        valores.put(IDMADRE, id_madre);
		return valores;
	}
	
	public void inserta(String id, String nombre, String fecha, String genero, String proposito, String peso, String color, String raza, String id_padre, String id_madre){
        Log.i("pablo", "enra a guardar");
        db.insert(TABLE_NAME, null, generarContentValues(id, nombre, fecha, genero, proposito, peso, color, raza, id_padre, id_madre));
	}
	
	public Cursor cargarCursorRegistro(){
		String[] columnas = new String[]{ID_BOVINO, NOMBRE, FECHA, GENERO, PROPOSITO, PESO, COLOR, RAZA, IDPADRE, IDMADRE};
		return db.query(TABLE_NAME, columnas, null, null, null, null, null);
	}

	public List<InventarioVO> getRegistros() {
		List<InventarioVO> listaRegistros = null;
		String[] columnas = new String[]{ID_BOVINO, NOMBRE, FECHA, GENERO, PROPOSITO, PESO, COLOR, RAZA, IDPADRE, IDMADRE};
		dbCursor = db.query(TABLE_NAME, columnas, null, null, null, null, null);
		if (dbCursor.getCount() > 0) {
			listaRegistros = new ArrayList<InventarioVO>();
			dbCursor.moveToFirst();
			while (!dbCursor.isAfterLast()) {
                InventarioVO registro = new InventarioVO();
				registro.setId((dbCursor.getString(0)));
				registro.setNombre(dbCursor.getString(1));
				registro.setFecha(dbCursor.getString(2));
				registro.setGenero(dbCursor.getString(3));
				registro.setProposito(dbCursor.getString(4));
                registro.setPeso(dbCursor.getString(5));
                registro.setColor(dbCursor.getString(6));
                registro.setRaza(dbCursor.getString(7));
                registro.setId_padre(dbCursor.getString(8));
                registro.setId_madre(dbCursor.getString(9));

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
