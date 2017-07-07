package com.consultoraestrategia.ss_crmeducativo.sesiones;

import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.events.EvaluacionEvent;
import com.consultoraestrategia.ss_crmeducativo.sesiones.events.SesionesEvent;

/**
 * Created by kelvi on 06/03/2017.
 */

public interface SesionesPresenter {
    void onCreate();

    void onDestroy();

    void onSetupRecycler();

    void onLoadSpinnerTrimestre();

    void onLoadSpinnerUnidad();

    void OnEventMainThread(SesionesEvent sesionesEvent);

}
