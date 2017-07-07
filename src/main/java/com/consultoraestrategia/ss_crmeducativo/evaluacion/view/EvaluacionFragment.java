package com.consultoraestrategia.ss_crmeducativo.evaluacion.view;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.domain.adapters.TableFixHeaders;
import com.consultoraestrategia.ss_crmeducativo.entities.Alumnos;
import com.consultoraestrategia.ss_crmeducativo.entities.AnioAcademico;
import com.consultoraestrategia.ss_crmeducativo.entities.AnioAcademico_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.CalendarioAcademico;
import com.consultoraestrategia.ss_crmeducativo.entities.CalendarioAcademico_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.CalendarioPeriodo;
import com.consultoraestrategia.ss_crmeducativo.entities.CalendarioPeriodo_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaAcademica;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaAcademica_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaCursos;
import com.consultoraestrategia.ss_crmeducativo.entities.CargaCursos_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Competencia;
import com.consultoraestrategia.ss_crmeducativo.entities.Competencia_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Contrato;
import com.consultoraestrategia.ss_crmeducativo.entities.Contrato_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Cursos;
import com.consultoraestrategia.ss_crmeducativo.entities.Cursos_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.DesarrolloCompetenciaCurso;
import com.consultoraestrategia.ss_crmeducativo.entities.DesarrolloCompetenciaCurso_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.DetalleContratoAcad;
import com.consultoraestrategia.ss_crmeducativo.entities.DetalleContratoAcad_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.EvaluacionCapacidad;
import com.consultoraestrategia.ss_crmeducativo.entities.EvaluacionCapacidad_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.PlanCursos;
import com.consultoraestrategia.ss_crmeducativo.entities.PlanCursos_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Tipos;
import com.consultoraestrategia.ss_crmeducativo.entities.Tipos_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.TrimestresNotas;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.EvaluacionPresenter;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.EvaluacionPresenterImpl;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.EvaluacionView;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters.MenuTrimestreAdapter;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters.TableAlumnosAdapter;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.interfaces.OnItemCheckTrimestreClick;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.interfaces.SetDataChanges;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import com.shehabic.droppy.DroppyMenuPopup;

/**
 * Created by kelvi on 23/02/2017.
 */

public class EvaluacionFragment extends Fragment implements OnItemCheckTrimestreClick, EvaluacionView, SetDataChanges {


    @BindView(R.id.listMenu)
    ListView listViewMenu;
    @BindView(R.id.tableTrimestre)
    TableFixHeaders tableTrimestre;
    @BindView(R.id.fabSaveNotes)
    FloatingActionButton fabSaveNotes;
    List<CalendarioPeriodo> calendarioPeriodoList;
    private static final String TAG = "EvaluacionFragment";
    private EvaluacionPresenter evaluacionPresenter;
    int idCargaCurso = 0;
    int cursoId = 0;
    PlanCursos planCursos;
    CargaCursos cargaCursos;
    CargaAcademica cargaAcademica;
    List<DetalleContratoAcad> detalleContratoAcadList;
    List<DesarrolloCompetenciaCurso> desComCursoGeneralList;
    List<Alumnos> alumnoses;
    List<Competencia> competencias;
    List<DesarrolloCompetenciaCurso> desCompCursoxAlumno;
    List<EvaluacionCapacidad> evaluacionCapacidadGeneralList;
    boolean isChecked = false;
    List<EvaluacionCapacidad> listaNotasXalumnos;
    boolean isVisibleTri = false;
    CheckBox checkBoxCol;
    View viewPadre;

    public static EvaluacionFragment newInstance() {
        EvaluacionFragment fragment = new EvaluacionFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewPadre = inflater.inflate(R.layout.layout_evalucion_periodos, container, false);
        ButterKnife.bind(this, viewPadre);
        evaluacionPresenter = new EvaluacionPresenterImpl(this);
        evaluacionPresenter.onCreate();
        evaluacionPresenter.onloadInformation();
        getListaAlumnos(0, 0);
        initMenu(0);
        return viewPadre;
    }


    public void getListaAlumnos(int positiondesCom, int positionCal) {
        idCargaCurso = getArguments().getInt("idCargaCurso");
        cursoId = getArguments().getInt("cursoId");
        alumnoses = new ArrayList<>();
        competencias = new ArrayList<>();
        getDatosGenerales();
        getCompetenciasGenerales();
        getListaContratosAlumnos(positiondesCom, positionCal);
        setAdapterTableAlumnos();

    }

    private void getListaContratosAlumnos(int positiondesCom, int positionCal) {
        for (int i = 0; i < detalleContratoAcadList.size(); i++) {
            Contrato contrato = SQLite.select()
                    .from(Contrato.class)
                    .where(Contrato_Table.idContrato.is(detalleContratoAcadList.get(i).getIdContrato()))
                    .queryList().get(0);
// //
            Persona persona = SQLite.select()
                    .from(Persona.class)
                    .where(Persona_Table.personaId.is(contrato.getPersonaId()))
                    .queryList().get(0);

            desCompCursoxAlumno = SQLite.select()
                    .from(DesarrolloCompetenciaCurso.class)
                    .where(DesarrolloCompetenciaCurso_Table.personaId.is(persona.getPersonaId()))
                    .and(DesarrolloCompetenciaCurso_Table.planCursoId.is(planCursos.getPlanCursoId()))
                    .queryList();

            Log.d(TAG, "Lista desCompCursoxAlumno : " + desCompCursoxAlumno.size());

            getNotasAlumnoPorCapacidad(desCompCursoxAlumno.get(positiondesCom).getDesCompetenciaId(), calendarioPeriodoList.get(positionCal).getCalendarioPeriodoId());


            alumnoses.add(new Alumnos(persona.getPersonaId(), persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + ", " + persona.getNombres(), "", listaNotasXalumnos, competencias));
            Log.d(TAG, "RELOAD?");
            Log.d(TAG, "Lista Alumnos : " + alumnoses.toString());

        }
    }

    private void getDatosGenerales() {
        Cursos curso = SQLite.select()
                .from(Cursos.class)
                .where(Cursos_Table.cursoId.is(cursoId))
                .queryList().get(0);

        planCursos = SQLite.select()
                .from(PlanCursos.class)
                .where(PlanCursos_Table.cursoId.is(curso.getCursoId()))
                .queryList().get(0);
//

//
        cargaCursos = SQLite.select()
                .from(CargaCursos.class)
                .where(CargaCursos_Table.cargaCursoId.is(idCargaCurso))
                .and(CargaCursos_Table.planCursoId.is(planCursos.getPlanCursoId()))
                .queryList().get(0);


//
        cargaAcademica = SQLite.select()
                .from(CargaAcademica.class)
                .where(CargaAcademica_Table.cargaAcademicaId.is(cargaCursos.getCargaAcademicaId()))
                .queryList().get(0);

        AnioAcademico anioAcademico = SQLite.select()
                .from(AnioAcademico.class)
                .where(AnioAcademico_Table.idAnioAcademico.is(cargaAcademica.getIdAnioAcademico()))
                .queryList().get(0);

        CalendarioAcademico calendarioAcademico = SQLite.select()
                .from(CalendarioAcademico.class)
                .where(CalendarioAcademico_Table.idAnioAcademico.is(anioAcademico.getIdAnioAcademico()))
                .queryList().get(0);

        calendarioPeriodoList = SQLite.select()
                .from(CalendarioPeriodo.class)
                .where(CalendarioPeriodo_Table.calendarioAcademicoId.is(calendarioAcademico.getCalendarioAcademicoId()))
                .queryList();

        desComCursoGeneralList = SQLite.select()
                .from(DesarrolloCompetenciaCurso.class)
                .where(DesarrolloCompetenciaCurso_Table.planCursoId.is(planCursos.getPlanCursoId()))
                .and(DesarrolloCompetenciaCurso_Table.calendarioPeriodoId.is(calendarioPeriodoList.get(0).getCalendarioPeriodoId()))
                .queryList();

//
        evaluacionCapacidadGeneralList = SQLite.select()
                .from(EvaluacionCapacidad.class)
                .where(EvaluacionCapacidad_Table.desCompetenciaId.is(desComCursoGeneralList.get(0).getDesCompetenciaId()))
                .queryList();
//
//
        detalleContratoAcadList = SQLite.select()
                .from(DetalleContratoAcad.class)
                .where(DetalleContratoAcad_Table.cargaCursoId.is(cargaCursos.getCargaCursoId()))
                .queryList();


    }

    private void getCompetenciasGenerales() {
        for (int j = 0; j < evaluacionCapacidadGeneralList.size(); j++) {
            Competencia CompetenciasGenerales = SQLite.select()
                    .from(Competencia.class)
                    .where(Competencia_Table.competenciaId.is(evaluacionCapacidadGeneralList.get(j).getCompetenciaId()))
                    .queryList().get(0);

            Log.d(TAG, "CompetenciasGenerales: " + CompetenciasGenerales.toString());
            Log.d(TAG, "evaluacionCapacidadGeneralList siZe : " + evaluacionCapacidadGeneralList.size() + "");
            competencias.add(CompetenciasGenerales);
        }
    }

    private void setAdapterTableAlumnos() {
        tableTrimestre.setAdapter(new TableAlumnosAdapter(isChecked, this, getChildFragmentManager(), getActivity().getSupportFragmentManager(), getActivity(), alumnoses, competencias, this));
    }

    private void getNotasAlumnoPorCapacidad(int idDesComCurso, int calendarioPeriodoId) {


        getListaNotas(idDesComCurso, calendarioPeriodoId);


    }

    private void getListaNotas(int idDesComCurso, int calendarioPeriodoId) {
        CalendarioPeriodo calendarioPeriodo = SQLite.select()
                .from(CalendarioPeriodo.class)
                .where(CalendarioPeriodo_Table.calendarioPeriodoId.is(calendarioPeriodoId))

                .queryList().get(0);
//

        DesarrolloCompetenciaCurso descomCurso = SQLite.select()
                .from(DesarrolloCompetenciaCurso.class)
                .where(DesarrolloCompetenciaCurso_Table.calendarioPeriodoId.is(calendarioPeriodo.getCalendarioPeriodoId()))
                .and(DesarrolloCompetenciaCurso_Table.desCompetenciaId.is(idDesComCurso))
                .queryList().get(0);


//
//        Log.d(TAG, "Lista descomCurso : " + descomCurso.toString());
        listaNotasXalumnos = SQLite.select()
                .from(EvaluacionCapacidad.class)
                .where(EvaluacionCapacidad_Table.desCompetenciaId.is(descomCurso.getDesCompetenciaId()))
                .queryList();

    }


    @Override
    public void onDestroy() {
        evaluacionPresenter.onDestroy();
        super.onDestroy();
    }

    private void initMenu(final int positionPeriodo) {

        final List<String> listaPeriodos = new ArrayList<>();
//
        for (int i = 0; i < calendarioPeriodoList.size(); i++) {
            Tipos tipos = SQLite.select()
                    .from(Tipos.class)
                    .where(Tipos_Table.tipoId.is(calendarioPeriodoList.get(i).getTipoId()))
                    .queryList().get(0);


//          Tipos.find(Tipos.class, "tipo_Id=?", calendarioPeriodoList.get(i).getTipoId() + "").get(0);
            Log.d(TAG, "TipoId : " + tipos.getTipoId());
            listaPeriodos.add(tipos.getNombre());
        }
//
//
////        listaPeriodos.add("Final");
//
        listViewMenu.setBackgroundColor(Color.parseColor("#ffffff"));
        listViewMenu.setAdapter(new MenuTrimestreAdapter(getActivity(), listaPeriodos, positionPeriodo));
        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String string = (String) adapterView.getAdapter().getItem(position);
                Log.d(TAG, "DATA: " + string);
                getListaAlumnos(position, position);

                listViewMenu.setAdapter(new MenuTrimestreAdapter(getActivity(), listaPeriodos, position));


            }
        });

    }

    @Override
    public void onItemClickListener(HashMap<Integer, TrimestresNotas> boxListHashMap, View view, String idCapacidad) {

        checkBoxCol = (CheckBox) view;
        Log.d(TAG, "ACTIVADO: " + checkBoxCol.isChecked());
        int trimestresNotas = (Integer) checkBoxCol.getTag();


        for (EditText editText : boxListHashMap.get(trimestresNotas).getEditTexts()) {

            if (checkBoxCol.isChecked()) {


                editText.setEnabled(true);


                Competencia competencia2 = SQLite.select()
                        .from(Competencia.class)
                        .where(Competencia_Table.competenciaId.is(Integer.parseInt(idCapacidad)))
                        .queryList().get(0);


//                Competencia.find(Competencia.class, "competencia_Id=? ", idCapacidad + "").get(0);
                Snackbar.make(viewPadre, competencia2.getNombre(), Snackbar.LENGTH_INDEFINITE).show();

            } else {
                editText.setEnabled(false);


            }

        }
    }

    @Override
    public void onLoadMenu(List<String> stringList) {
        listViewMenu.setAdapter(new MenuTrimestreAdapter(getActivity(), stringList, 0));
    }

    @Override
    public void onLoadTableAlumnos(List<Alumnos> alumnosAdapter, List<Competencia> competencias) {

        tableTrimestre.setAdapter(new TableAlumnosAdapter(isChecked, this, getChildFragmentManager(), getActivity().getSupportFragmentManager(), getActivity(), alumnosAdapter, competencias, this));
    }

    @Override
    public void onLoadMenuError(String error) {
        Toast.makeText(getActivity(), "onLoadMenuError: " + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadTableAlumnosError(String error) {
        Toast.makeText(getActivity(), "onLoadTableAlumnosError: " + error, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.fabSaveNotes)
    @Override
    public void onSaveNotasSuccess() {
        initMenu(0);
        getListaAlumnos(0, 0);
        Toast.makeText(getContext(), "Notas Guardadas", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSaveNotasError(String error) {
        Toast.makeText(getActivity(), "onSaveNotasError: " + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setOnDataChange(CheckBox checkBox) {

        fabSaveNotes.setVisibility(View.VISIBLE);

    }
}
