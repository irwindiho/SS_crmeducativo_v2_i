package com.consultoraestrategia.ss_crmeducativo.tareas.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.entities.Tarea;

import java.util.ArrayList;

import butterknife.ButterKnife;


/**
 * Created by irvinmarin on 23/02/2017.
 */

public class FragmentHorario extends Fragment {
    ArrayList<Tarea> tareaArrayList;



    View viewPadre;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewPadre = inflater.inflate(R.layout.tab_fragment_horario, container, false);


        ButterKnife.bind(this, viewPadre);

        populateTareas();
        return viewPadre;

    }



    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    public void populateTareas() {



    }

}
