package com.example.pablosanjuan.core;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class IngresarBovino extends ActionBarActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private RadioGroup rdgGrupo;
    private String var_genero="";
    private String var_fecha="";
    private EditText e_id, e_nomb;
    String[] bovino;

    private Calendar calendar;
    private int year, month, day;
    private Button btn_fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar_bovino);


        e_id = (EditText) findViewById(R.id.edt_id_bovino);
        e_nomb = (EditText) findViewById(R.id.edt_nombre_bovino);
        btn_fecha = (Button) findViewById(R.id.btn_fecha);
        rdgGrupo = (RadioGroup) findViewById(R.id.rdgGrupo);


        rdgGrupo.setOnCheckedChangeListener(this);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // TODO Auto-generated method stub
        if (checkedId == R.id.rdgMacho) {
            var_genero = "Macho";
        } else if (checkedId == R.id.rdgHembra) {
            var_genero = "Hembra";
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_siguiente:
                if(validar(e_id.getText().toString(),e_nomb.getText().toString(),var_fecha,var_genero)==false){
                    Toast.makeText(this,"Debe Llenar Todos Los Campos",Toast.LENGTH_LONG).show();
                }else {
                    bovino = new String[4];
                    Intent ir_reg = new Intent(this, IngresarBovino2.class);

                        bovino[0] = e_id.getText().toString();

                        bovino[1] = e_nomb.getText().toString();
                        bovino[2] = var_fecha;
                        bovino[3] = var_genero;

                    ir_reg.putExtra("bovino", bovino);
                    startActivity(ir_reg);
                }
                break;
            case R.id.btn_fecha:
                showDialog(999);

        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            DatePickerDialog dialogDate = new DatePickerDialog(this, myDateListener, year, month, day);
            dialogDate.getDatePicker().setMaxDate(new Date().getTime());
            return dialogDate;
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2 + 1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        var_fecha = (new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year)).toString();
        btn_fecha.setText("Fecha Nacimiento: " + var_fecha);
    }

    public Boolean validar(String id, String nombre, String fecha, String genero) {
        if (id.equals("") || nombre.equals("") || fecha.equals("") || genero.equals("")) {
            return false;
        }else {
            return true;
        }
    }
}



