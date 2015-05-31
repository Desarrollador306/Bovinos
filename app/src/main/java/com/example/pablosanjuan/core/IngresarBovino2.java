package com.example.pablosanjuan.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pablosanjuan.core.db.DbManager_inventario;


public class IngresarBovino2 extends ActionBarActivity {
    private Button btn_guadar;
    private Spinner s_proposito;
    private String[] proposito = {"Lecheria Especializada","Carne","Doble Proposito"};
    private EditText e_peso, e_color, e_raza, e_id_padre, e_id_madre;
    String[] bovino;
    private DbManager_inventario manager0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar_bovino2);
        Bundle bundl=getIntent().getExtras();
        if(bundl!=null){
            bovino= bundl.getStringArray("bovino");
        }

        e_peso = (EditText) findViewById(R.id.edt_peso);
        e_color = (EditText) findViewById(R.id.edt_color);
        e_raza = (EditText) findViewById(R.id.edt_raza);
        e_id_padre = (EditText) findViewById(R.id.edt_id_padre);
        e_id_madre = (EditText) findViewById(R.id.edt_id_madre);
        btn_guadar = (Button) findViewById(R.id.btn_guardar_Bovino);
        manager0 = new DbManager_inventario(this);
        s_proposito = (Spinner) findViewById(R.id.spi_proposito);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,proposito);
        s_proposito.setAdapter(adapter);


    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_guardar_Bovino:
                if (validar(e_peso.getText().toString(), e_color.getText().toString(), e_raza.getText().toString(), e_id_padre.getText().toString(), e_id_madre.getText().toString()) == false) {
                    Toast.makeText(this, "Debe Llenar Todos Los Campos", Toast.LENGTH_LONG).show();
                } else {
                    String var1 = bovino[0];
                    String var2 = bovino[1];
                    String var3 = bovino[2];
                    String var4 = s_proposito.getSelectedItem().toString();
                    String var5 = e_peso.getText().toString();
                    String var6 = e_color.getText().toString();
                    String var7 = e_raza.getText().toString();
                    String var8 = e_id_padre.getText().toString();
                    String var9 = e_id_madre.getText().toString();
                    String var_genero = bovino[3];

                    manager0.inserta(var1, var2, var3, var_genero, var4, var5, var6, var7, var8, var9);
                    Intent ir_main = new Intent().setClass(IngresarBovino2.this, Main.class);
                    startActivity(ir_main);
                    finish();
                }
        }
    }

    public Boolean validar(String peso, String color, String raza, String idpadre, String idmadre) {
        if (peso.equals("") || color.equals("") || raza.equals("") || idpadre.equals("") || idmadre.equals("")) {
            return false;
        }else {
            return true;
        }
    }
}
