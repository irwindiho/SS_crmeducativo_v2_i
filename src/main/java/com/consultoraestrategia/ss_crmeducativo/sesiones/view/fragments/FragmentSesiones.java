package com.consultoraestrategia.ss_crmeducativo.sesiones.view.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.EvaluacionFragment;
import com.consultoraestrategia.ss_crmeducativo.sesiones.SesionesPresenter;
import com.consultoraestrategia.ss_crmeducativo.sesiones.SesionesPresenterImpl;
import com.consultoraestrategia.ss_crmeducativo.sesiones.SesionesView;
import com.consultoraestrategia.ss_crmeducativo.sesiones.view.adapters.AdapterSesiones;
import com.consultoraestrategia.ss_crmeducativo.entities.Sesiones;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by irvinmarin on 23/02/2017.
 */

public class FragmentSesiones extends Fragment implements SesionesView {
    //    @BindView(R.id.fabAddNews)
//    FloatingActionButton fabAddNews;
    @BindView(R.id.spnTrimiestre)
    Spinner spnTrimiestre;
    @BindView(R.id.spnUnidad)
    Spinner spnUnidad;
    @BindView(R.id.rv_sesiones)
    RecyclerView rvSesiones;
    ArrayList<Sesiones> sesionesArrayList;

    SesionesPresenter sesionesPresenter;
    Context context;

    public static FragmentSesiones newInstance() {
        FragmentSesiones fragment = new FragmentSesiones();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_sesiones, container, false);

        poputalteSesiones();
        ButterKnife.bind(this, view);
        context = getContext();

        sesionesPresenter = new SesionesPresenterImpl(this);
        sesionesPresenter.onCreate();
        sesionesPresenter.onSetupRecycler();


        int backgroudColor = getArguments().getInt("backgroudColor");

        onLoadSpinnerTrimestre();
        onLoadSpinnerUnidad();
        onSetupRecycler();

        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        sesionesPresenter.onDestroy();
    }

    private void poputalteSesiones() {
        sesionesArrayList = new ArrayList<>();
        sesionesArrayList.add(new Sesiones(1, "Clasificando nuestros alimentos…", "Tabla de Frecuencias y Gráfico de Barras \n Medidas de Tendencia Central. Moda ", "Resolver Ejercicios Pg 24", 2, 3));
        sesionesArrayList.add(new Sesiones(2, "Conociendo nuestro perfil", "Medidas de Tendencia Central. Moda", "Resolver Ejercicios Pg 26", 4, 4));
        sesionesArrayList.add(new Sesiones(3, "Conociendo mucho a través de unos pocos ", "Tabla de Frecuencias y Gráfico de Barras \n Medidas de Tendencia Central. Moda ", "Resolver Ejercicios Pg 24", 2, 2));
        sesionesArrayList.add(new Sesiones(4, "Clasificando nuestros alimentos…", "Tabla de Frecuencias y Gráfico de Barras \n Medidas de Tendencia Central. Moda ", "Resolver Ejercicios Pg 24", 2, 1));
    }


    @Override
    public void onSetupRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        rvSesiones.setLayoutManager(linearLayoutManager);
        rvSesiones.setHasFixedSize(true);
        AdapterSesiones listAdapter = new AdapterSesiones(sesionesArrayList);
        rvSesiones.setAdapter(listAdapter);
    }

    @Override
    public void onSetupRecyclerError(String error) {
        Toast.makeText(getActivity(), "onSetupRecyclerError: " + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadSpinnerTrimestre() {

        ArrayAdapter<CharSequence> adapterSpnTrimestre = ArrayAdapter.createFromResource(context, R.array.periodo, android.R.layout.simple_spinner_item);
        spnTrimiestre.setAdapter(adapterSpnTrimestre);
    }

    @Override
    public void onLoadSpinnerTrimestreError(String e) {
        Toast.makeText(getActivity(), "onLoadSpinnerTrimestreError: " + e, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadSpinnerUnidad() {
        ArrayAdapter<CharSequence> adapterSpnUnidad = ArrayAdapter.createFromResource(context, R.array.unidad, android.R.layout.simple_spinner_item);
        spnUnidad.setAdapter(adapterSpnUnidad);
    }

    @Override
    public void onLoadSpinnerUnidadError(String e) {
        Toast.makeText(getActivity(), "onLoadSpinnerUnidadError: " + e, Toast.LENGTH_SHORT).show();
    }


}
