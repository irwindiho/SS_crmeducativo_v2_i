package com.consultoraestrategia.ss_crmeducativo.evaluacion;

import com.consultoraestrategia.ss_crmeducativo.entities.Alumnos;
import com.consultoraestrategia.ss_crmeducativo.entities.Capacidades;
import com.consultoraestrategia.ss_crmeducativo.entities.Competencia;
import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters.MenuTrimestreAdapter;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters.TableAlumnosAdapter;

import java.util.List;

/**
 * Created by kelvi on 06/03/2017.
 */

public interface EvaluacionView {
    void onLoadMenu(List<String> stringList);

    void onLoadTableAlumnos(List<Alumnos> alumnoses, List<Competencia> competencias);

    void onLoadMenuError(String error);

    void onLoadTableAlumnosError(String error);

    void onSaveNotasSuccess();

    void onSaveNotasError(String error);


}
