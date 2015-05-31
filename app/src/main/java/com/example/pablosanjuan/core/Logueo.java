package com.example.pablosanjuan.core;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Logueo extends ActionBarActivity implements View.OnClickListener {
    private SharedPreferences prefs;
    private Button btn_validar,btn_registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logueo);

        prefs = getSharedPreferences("datos", Context.MODE_PRIVATE);
        btn_validar = (Button) findViewById(R.id.btn_validar);
        btn_registro = (Button) findViewById(R.id.btn_registro);
        btn_validar.setOnClickListener(this);
        btn_registro.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_logueo, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_validar:
                SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putBoolean("validar_sesion", true);
                editor.commit();
                Intent ir_log = new Intent().setClass(Logueo.this, Main.class);
                startActivity(ir_log);
                finish();
                break;
            case R.id.btn_registro:
                Intent ir_reg = new Intent().setClass(Logueo.this, Registro.class);
                startActivity(ir_reg);
                finish();
                break;
        }
    }
}
