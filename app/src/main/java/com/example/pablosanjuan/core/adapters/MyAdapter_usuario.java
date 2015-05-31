package com.example.pablosanjuan.core.adapters;

/**
 * Created by Pablo Sanjuan on 29/05/2015.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pablosanjuan.core.R;
import com.example.pablosanjuan.core.vo.InventarioVO;
import com.example.pablosanjuan.core.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter_usuario extends BaseAdapter {

    private List<UsuarioVO> listaUsuarioVOs;
    private LayoutInflater layoutInflater;


    public MyAdapter_usuario(Activity a, List<UsuarioVO> listaUsuarioVOs) {
        super();
        this.listaUsuarioVOs = new ArrayList<UsuarioVO>();
        if (listaUsuarioVOs != null){
            this.listaUsuarioVOs = listaUsuarioVOs;
        }
        layoutInflater = a.getLayoutInflater();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listaUsuarioVOs.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return listaUsuarioVOs.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // TODO Auto-generated method stub

        view = layoutInflater.inflate(R.layout.elemento_usuario, null);

        String id = listaUsuarioVOs.get(position).getId();
        String nombre = listaUsuarioVOs.get(position).getNombre();
        String direccion = listaUsuarioVOs.get(position).getDireccion();
        String usuario = listaUsuarioVOs.get(position).getUsuario();
        String contrasena = listaUsuarioVOs.get(position).getContrasena();

        TextView tv_registro1 = (TextView) view.findViewById(R.id.registro1);
        TextView tv_registro2 = (TextView) view.findViewById(R.id.registro2);
        TextView tv_registro3 = (TextView) view.findViewById(R.id.registro3);
        TextView tv_registro4 = (TextView) view.findViewById(R.id.registro4);
        TextView tv_registro5 = (TextView) view.findViewById(R.id.registro5);

        tv_registro1.setText("Id: "+id);
        tv_registro2.setText("Nombre: "+nombre);
        tv_registro3.setText("Direccion: "+direccion);
        tv_registro4.setText("Usuario: "+usuario);
        tv_registro5.setText("Contrasena: "+contrasena);

        return view;
    }
}
