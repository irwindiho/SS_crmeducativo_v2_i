package com.consultoraestrategia.ss_crmeducativo.tareas.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.tareas.TareasPresenter;
import com.consultoraestrategia.ss_crmeducativo.tareas.TareasPresenterImpl;
import com.consultoraestrategia.ss_crmeducativo.tareas.TareasView;
import com.consultoraestrategia.ss_crmeducativo.tareas.view.adapters.TareasDelladasAdapter;
import com.consultoraestrategia.ss_crmeducativo.entities.Tarea;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by irvinmarin on 23/02/2017.
 */

public class FragmentTareas extends Fragment implements TareasView {
    ArrayList<Tarea> tareaArrayList;

    @BindView(R.id.rvTareasDetalladas)
    RecyclerView rvTareasDetalladas;
    @BindView(R.id.fabAddNews)
    FloatingActionButton fabAddNews;
    View viewPadre;
    TareasPresenter tareasPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewPadre = inflater.inflate(R.layout.fragment_tareas_detalles, container, false);//Remplazar "f1" por Layout para Fragment Tareas


        ButterKnife.bind(this, viewPadre);
        tareasPresenter = new TareasPresenterImpl(this);
        populateTareas();
        return viewPadre;

    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        tareasPresenter.onDestroy();
    }

    public void populateTareas() {

        tareaArrayList = new ArrayList<>();
        tareaArrayList.add(new Tarea("Tarea 1", "Detalles asdsa asdasdasfgr naosdnasd ngjfkaksd mfjadjdsa"));
        tareaArrayList.add(new Tarea("tarea 2", "Detalles asdsa asdasdasfgr naosdnasd ngjfkaksd mfjadjdsa"));
        onSetupRecycler();
    }

    @Override
    public void onSetupRecycler() {
        int backgroudColor = getArguments().getInt("backgroudColor");
        TareasDelladasAdapter tareasDelladasAdapter = new TareasDelladasAdapter(tareaArrayList, getContext(), backgroudColor);
        rvTareasDetalladas.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rvTareasDetalladas.setAdapter(tareasDelladasAdapter);
    }

    @Override
    public void onSetupRecyclerError(String e) {

    }

    @OnClick(R.id.fabAddNews)
    @Override
    public void onFabNewsClick() {
        Snackbar.make(viewPadre, "Nueva Publicacion ", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onFabNewsClickError(String e) {

    }
}
