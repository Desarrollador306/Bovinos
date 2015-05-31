package com.example.pablosanjuan.core.adapters;

/**
 * Created by Pablo Sanjuan on 29/05/2015.
 */

import java.util.ArrayList;
import java.util.List;

import com.example.pablosanjuan.core.R;
import com.example.pablosanjuan.core.vo.InventarioVO;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    private List<InventarioVO> listaInventarioVOs;
    private LayoutInflater layoutInflater;


    public MyAdapter(Activity a, List<InventarioVO> listaInventarioVOs) {
        super();
        this.listaInventarioVOs = new ArrayList<InventarioVO>();
        if (listaInventarioVOs != null){
            this.listaInventarioVOs = listaInventarioVOs;
        }
        layoutInflater = a.getLayoutInflater();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listaInventarioVOs.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return listaInventarioVOs.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // TODO Auto-generated method stub

        view = layoutInflater.inflate(R.layout.elemento_registro, null);

        String id = listaInventarioVOs.get(position).getId();
        String nombre = listaInventarioVOs.get(position).getNombre();
        String fecha = listaInventarioVOs.get(position).getFecha();
        String genero = listaInventarioVOs.get(position).getGenero();
        String raza = listaInventarioVOs.get(position).getRaza();

        TextView tv_registro1 = (TextView) view.findViewById(R.id.registro1);
        TextView tv_registro2 = (TextView) view.findViewById(R.id.registro2);
        TextView tv_registro3 = (TextView) view.findViewById(R.id.registro3);
        TextView tv_registro4 = (TextView) view.findViewById(R.id.registro4);
        TextView tv_registro5 = (TextView) view.findViewById(R.id.registro5);

        tv_registro1.setText("Id: "+id);
        tv_registro2.setText("Nombre: "+nombre);
        tv_registro3.setText("Fecha Nacimiento: "+fecha);
        tv_registro4.setText("Genero: "+genero);
        tv_registro5.setText("Raza: "+raza);

        return view;
    }
}
