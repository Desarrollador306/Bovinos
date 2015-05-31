package com.example.pablosanjuan.core;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import com.example.pablosanjuan.core.adapters.MyAdapter;
import com.example.pablosanjuan.core.db.DbManager_inventario;
import com.example.pablosanjuan.core.vo.InventarioVO;
import java.util.List;

/**
 * Created by Pablo Sanjuan on 28/05/2015.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {

    private Button btn_add_bovino, b_borrar;
    ListView lista;
    MyAdapter adapter;
    DbManager_inventario manager;
    private List<InventarioVO> listaRegistros;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment1, container, false);

        manager = new DbManager_inventario(getActivity());
        lista = (ListView) rootView.findViewById(R.id.lista1);
        listaRegistros = manager.getRegistros();
        adapter = new MyAdapter(getActivity(), listaRegistros);
        lista.setAdapter(adapter);
        btn_add_bovino = (Button) rootView.findViewById(R.id.btn_agregar_bovino);
        b_borrar = (Button) rootView.findViewById(R.id.btn_borrar);
        btn_add_bovino.setOnClickListener(this);
        b_borrar.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_agregar_bovino:
                Intent intent = new Intent(getActivity(), IngresarBovino.class);
                startActivity(intent);
                break;

            case R.id.btn_borrar:
                    manager.borrarRegistros();
                break;
        }
    }
}