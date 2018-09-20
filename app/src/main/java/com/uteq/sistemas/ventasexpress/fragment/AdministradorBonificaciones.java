package com.uteq.sistemas.ventasexpress.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uteq.sistemas.ventasexpress.R;
import com.uteq.sistemas.ventasexpress.adapter.BonificacionesAdapter;
import com.uteq.sistemas.ventasexpress.model.Bonificacion;
import com.uteq.sistemas.ventasexpress.utils.Constants;
import com.uteq.sistemas.ventasexpress.utils.WebServ.Asynchtask;
import com.uteq.sistemas.ventasexpress.utils.WebServ.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdministradorBonificaciones extends Fragment implements Asynchtask {


    Fragment fragment;
    private FragmentTransaction fragmentTransaction;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Bonificacion> bonificacion;
    private View view;
    private String id;

    @BindView(R.id.rvBonificacion)
    RecyclerView recyclerView;

    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    public AdministradorBonificaciones() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_administrador_bonificaciones, container, false);
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_administrador_bonificaciones, container, false);
        ButterKnife.bind(this, view);
        Bundle b = getArguments();
        id = b.getString("id");

        linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        ConectWSBonificacion();
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new PedidoDetalleAgregarFragment();
                fragmentTransaction = Constants.fragmentManager.beginTransaction().addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.commit();
            }
        });
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorAccent);//Aqui podemos cponer los colores que queremos
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        ConectWSBonificacion();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
        return view;
    }

    private void ConectWSBonificacion() {
        Map<String, String> params = new HashMap<>();
        //params.put("listar", Constants.empleado.getIdentificacion());
        params.put("listar","1");
        WebService ws = new WebService(Constants.WS_BONIFICACION, params, view.getContext(), (Asynchtask) AdministradorBonificaciones.this);
        ws.execute("");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        Log.e("mmmmmmm", result);
        JSONArray objdataarray = new JSONArray(result);
        bonificacion = Bonificacion.JsonObjectsBuild(objdataarray);
        BonificacionesAdapter adapater = new BonificacionesAdapter(view.getContext(), bonificacion);
        recyclerView.setAdapter(adapater);
    }

}
