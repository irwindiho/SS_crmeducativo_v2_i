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

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.entities.Calendario;
import com.consultoraestrategia.ss_crmeducativo.entities.Evento;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters.ListaCalendarioAdapter;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.interfaces.OnAnotacionAccion;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by irvinmarin on 24/03/2017.
 */

public class FragmentTabCalendarioAlumno extends Fragment implements OnAnotacionAccion {

    List<Calendario> calendarioList;
    ImageLoader imageLoader;
    View viewPadre;

    int idAlumno;
    @BindView(R.id.rvCalendario)
    RecyclerView rvCalendario;
    @BindView(R.id.fabAddEvento)
    FloatingActionButton fabAddEvento;


    public static FragmentTabCalendarioAlumno newInstance() {
        FragmentTabCalendarioAlumno fragment = new FragmentTabCalendarioAlumno();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewPadre = inflater.inflate(R.layout.tab_calendario_alumno, container, false);
        ButterKnife.bind(this, viewPadre);
//        imageLoader = new GlideImageLoader(getActivity().getApplicationContext());

        SetupDatosAlumno();
        populateCalendario();
        SetupRecyclerView();


        return viewPadre;
    }

    private void SetupRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvCalendario.setLayoutManager(layoutManager);
        ListaCalendarioAdapter listaAnotacionesAdapter = new ListaCalendarioAdapter(calendarioList, getContext(), getChildFragmentManager(), idAlumno);
        rvCalendario.setAdapter(listaAnotacionesAdapter);
    }

    private void SetupDatosAlumno() {
        idAlumno = getArguments().getInt("idAlumno");
    }

    private void populateCalendario() {

        List<Evento> eventos1 = new ArrayList<>();
        eventos1.add(new Evento("15:00", "16:00", "Reforzamiento", "jueves, 25 mayo ", false));
        eventos1.add(new Evento("16:00", "17:00", "No vino", "jueves, 25 mayo ", false));
        List<Evento> eventos2 = new ArrayList<>();
        eventos2.add(new Evento("10:00", "11:00", "Reunion con Apoderado", "viernes, 26 mayo ", false));
        eventos2.add(new Evento("11:00", "12:00", "No vino", "viernes, 26 mayo ", false));


        calendarioList = new ArrayList<>();
        calendarioList.add(new Calendario("Jueves,25 mayo", eventos1));
        calendarioList.add(new Calendario("Viernes,26 mayo", eventos2));
    }


    @OnClick(R.id.fabAddEvento)
    public void onViewClicked() {
        DialogFragment dialogFragment = new DialogFragmentNuevoEvento();
        Bundle bundle = new Bundle();
        bundle.putInt("idAlumno", idAlumno);
        dialogFragment.setArguments(bundle);
        dialogFragment.show(getChildFragmentManager(), "DialogFragmentNuevoEvento");
    }

    @Override
    public void setOnDataChange(String Mensage) {

//        Toast.makeText(getContext(), Mensage, Toast.LENGTH_LONG).show();
    }


}
