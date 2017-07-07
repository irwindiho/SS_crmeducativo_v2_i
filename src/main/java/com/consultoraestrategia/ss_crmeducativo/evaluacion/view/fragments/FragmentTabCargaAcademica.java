package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.entities.Cursos;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters.ListaCargaAcademicaAlumnoAdapter;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by irvinmarin on 24/03/2017.
 */

public class FragmentTabCargaAcademica extends Fragment {

    ImageLoader imageLoader;
    View viewPadre;
    @BindView(R.id.rv_cursosAlumno)
    RecyclerView rvCursosAlumno;


    public static FragmentTabCargaAcademica newInstance() {
        FragmentTabCargaAcademica fragment = new FragmentTabCargaAcademica();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewPadre = inflater.inflate(R.layout.tab_fragment_horario, container, false);
        ButterKnife.bind(this, viewPadre);
        SetupCargaAcademicaAlumno();
        return viewPadre;
    }

    private void SetupCargaAcademicaAlumno() {
        List<Cursos> cursosList = SQLite.select()
                .from(Cursos.class)
                .queryList();
        SetupRecyclerView(cursosList);
    }


    private void SetupRecyclerView(List<Cursos> cursosList) {
        rvCursosAlumno.setLayoutManager(new LinearLayoutManager(getContext()));
        ListaCargaAcademicaAlumnoAdapter listaCursosDocenteAdapter = new ListaCargaAcademicaAlumnoAdapter(cursosList, getContext());
        rvCursosAlumno.setAdapter(listaCursosDocenteAdapter);
    }


}
