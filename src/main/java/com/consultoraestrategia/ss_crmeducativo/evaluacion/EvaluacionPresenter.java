package com.consultoraestrategia.ss_crmeducativo.evaluacion;

import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.events.EvaluacionEvent;

/**
 * Created by kelvi on 06/03/2017.
 */

public interface EvaluacionPresenter {
    void onCreate();

    void onDestroy();

    void onloadInformation();

    void onChangeTrimestre(Trimestre trimestre);

    void onSaveNotas();

    void OnEventMainThread(EvaluacionEvent evaluacionEvent);

}
