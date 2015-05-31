package com.example.pablosanjuan.core;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.pablosanjuan.core.adapters.MyAdapter;
import com.example.pablosanjuan.core.adapters.MyAdapter_usuario;
import com.example.pablosanjuan.core.db.DbManager_usuario;
import com.example.pablosanjuan.core.vo.InventarioVO;
import com.example.pablosanjuan.core.vo.UsuarioVO;

import java.util.List;

/**
 * Created by Pablo Sanjuan on 28/05/2015.
 */
public class Fragment2 extends Fragment implements View.OnClickListener {

    private Button b_borrar2;
    ListView lista;
    MyAdapter_usuario adapter;
    DbManager_usuario manager2;
    private List<UsuarioVO> listaRegistros;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment2, container, false);

        manager2 = new DbManager_usuario(getActivity());
        lista = (ListView) rootView.findViewById(R.id.list2a);
        listaRegistros = manager2.getRegistros();
        adapter = new MyAdapter_usuario(getActivity(), listaRegistros);
        lista.setAdapter(adapter);
        b_borrar2 = (Button) rootView.findViewById(R.id.btn_borrar2);
        b_borrar2.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case R.id.btn_borrar2:
            manager2.borrarRegistros();
        break;
    }
    }
}