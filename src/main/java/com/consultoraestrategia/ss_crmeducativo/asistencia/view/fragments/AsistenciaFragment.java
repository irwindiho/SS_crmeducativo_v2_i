package com.consultoraestrategia.ss_crmeducativo.asistencia.view.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.asistencia.AsistenciaView;
import com.consultoraestrategia.ss_crmeducativo.asistencia.view.adapters.AsistenciaAdapter;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaCursos;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaCursos_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.DetalleContratoAcad;
import com.consultoraestrategia.ss_crmeducativo.entities.DetalleContratoAcad_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona;
import com.consultoraestrategia.ss_crmeducativo.entities.PlanCursos;
import com.consultoraestrategia.ss_crmeducativo.entities.PlanCursos_Table;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kelvi on 03/03/2017.
 */

public class AsistenciaFragment extends Fragment implements AsistenciaView, AsistenciaAdapter.ListenerFabButton {

    @BindView(R.id.recyclerAlumnos)
    RecyclerView recyclerViewAlumnos;
    private AsistenciaAdapter asistenciaAdapter;
    FragmentManager fragmentManager;
    List<DetalleContratoAcad> detalleContratoAcadList;

    public static AsistenciaFragment newIntance() {
        return new AsistenciaFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_content_asistencia, container, false);
        ButterKnife.bind(this, view);

        onGetListaAlumnos();
        initListView();

        return view;
    }

    int cursoId;
    int idCargaCurso;

    @Override
    public void onGetListaAlumnos() {
        idCargaCurso = getArguments().getInt("idCargaCurso");
        cursoId = getArguments().getInt("cursoId");

        PlanCursos planCursos = SQLite.select()
                .from(PlanCursos.class)
                .where(PlanCursos_Table.cursoId.is(cursoId))
                .queryList().get(0);

        CargaCursos cargaCursos = SQLite.select()
                .from(CargaCursos.class)
                .where(CargaCursos_Table.cargaCursoId.is(idCargaCurso))
                .and(CargaCursos_Table.planCursoId.is(planCursos.getPlanCursoId()))
                .queryList().get(0);

        detalleContratoAcadList = SQLite.select()
                .from(DetalleContratoAcad.class)
                .where(DetalleContratoAcad_Table.cargaCursoId.is(cargaCursos.getCargaCursoId()))
                .queryList();


    }

    @Override
    public void initListView() {
        fragmentManager = getFragmentManager();
        asistenciaAdapter = new AsistenciaAdapter(cursoId, detalleContratoAcadList, this, new GlideImageLoader(getActivity()), fragmentManager);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewAlumnos.setLayoutManager(mLayoutManager);
        recyclerViewAlumnos.setItemAnimator(new DefaultItemAnimator());
        recyclerViewAlumnos.setAdapter(asistenciaAdapter);
    }

    @Override
    public void changeStateFabButtons(FloatingActionButton btnCurrentState, FloatingActionButton btnAsistio, FloatingActionButton btnFalto, FloatingActionButton btnJustificado) {
        if (Integer.parseInt(btnCurrentState.getTag().toString()) == 0) {
            btnAsistio.setVisibility(View.VISIBLE);
            btnFalto.setVisibility(View.VISIBLE);
            btnJustificado.setVisibility(View.VISIBLE);
            btnCurrentState.setTag(1);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                btnCurrentState.setImageDrawable(getResources().getDrawable(R.drawable.ic_cross_out, getActivity().getTheme()));
            } else {
                btnCurrentState.setImageDrawable(getResources().getDrawable(R.drawable.ic_cross_out));
            }
        } else {
            btnAsistio.setVisibility(View.GONE);
            btnFalto.setVisibility(View.GONE);
            btnJustificado.setVisibility(View.GONE);
            btnCurrentState.setTag(0);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                btnCurrentState.setImageDrawable(getResources().getDrawable(R.drawable.ic_cross_out, getActivity().getTheme()));
            } else {
                btnCurrentState.setImageDrawable(getResources().getDrawable(R.drawable.ic_cross_out));
            }
        }

    }


    @Override
    public void onFabPrincipalClick(Persona persona, FloatingActionButton floatingActionButton) {

    }

    @Override
    public void onFabChilCick(Persona persona, FloatingActionButton btnCurrentState, FloatingActionButton btnAsistio, FloatingActionButton btnFalto, FloatingActionButton btnJustificado) {
        changeStateFabButtons(btnCurrentState, btnAsistio, btnFalto, btnJustificado);
    }
}
