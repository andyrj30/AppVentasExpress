package com.uteq.sistemas.ventasexpress.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uteq.sistemas.ventasexpress.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdministradorCategoriasFragment extends Fragment {


    public AdministradorCategoriasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_administrador_categorias, container, false);
    }

}