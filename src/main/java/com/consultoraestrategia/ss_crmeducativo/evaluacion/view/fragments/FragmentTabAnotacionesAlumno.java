package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.entities.Anotaciones;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters.ListaAnotacionesAdapter;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.interfaces.OnAnotacionAccion;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by irvinmarin on 24/03/2017.
 */

public class FragmentTabAnotacionesAlumno extends Fragment implements OnAnotacionAccion {

    List<Anotaciones> anotacionesList;
    ImageLoader imageLoader;
    View viewPadre;
    @BindView(R.id.txtBuscarAnotacion)
    EditText txtBuscarAnotacion;
    @BindView(R.id.rvAnotaciones)
    RecyclerView rvAnotaciones;
    @BindView(R.id.fabAddAnotacion)
    FloatingActionButton fabAddAnotacion;
    int idAlumno;

    public static FragmentTabAnotacionesAlumno newInstance() {
        FragmentTabAnotacionesAlumno fragment = new FragmentTabAnotacionesAlumno();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewPadre = inflater.inflate(R.layout.tab_anotaciones_alumno, container, false);
        ButterKnife.bind(this, viewPadre);
        imageLoader = new GlideImageLoader(getActivity().getApplicationContext());

        SetupDatosAlumno();
        populateAnotaciones();
        SetupRecyclerView();
        return viewPadre;
    }

    private void SetupRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvAnotaciones.setLayoutManager(layoutManager);
        ListaAnotacionesAdapter listaAnotacionesAdapter = new ListaAnotacionesAdapter(anotacionesList, getContext(), getChildFragmentManager(), idAlumno);
        rvAnotaciones.setAdapter(listaAnotacionesAdapter);
    }

    private void SetupDatosAlumno() {
        idAlumno = getArguments().getInt("idAlumno");
    }


    //data prueba
    private void populateAnotaciones() {
        anotacionesList = new ArrayList<>();
        anotacionesList.add(new Anotaciones("Problemas de razonamiento",
                "No Esta Desarrollado De manea Rapida  los ejercicios y par distraida",
                "21:08",
                "Matematica(ejemplo)", "Karina Cano"));
        anotacionesList.add(new Anotaciones("Entrega de Trabajos",
                "No ha Entregado sus trabajos pendientes",
                "21:09",
                "Matematica(ejemplo)", "Karina Cano"));
    }


    @OnClick(R.id.fabAddAnotacion)
    public void onViewClicked() {
        DialogFragment dialogFragment = new DialogFragmentNuevaAnotacion();
        Bundle bundle = new Bundle();
        bundle.putInt("idAlumno", idAlumno);
        dialogFragment.setArguments(bundle);
        dialogFragment.show(getChildFragmentManager(), "DialogFragmentNuevaAnotacion");
    }

    @Override
    public void setOnDataChange(String Mensage) {
        Toast.makeText(getContext(), Mensage, Toast.LENGTH_LONG).show();
    }
}
