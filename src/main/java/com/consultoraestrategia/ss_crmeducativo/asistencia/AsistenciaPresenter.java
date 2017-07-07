package com.consultoraestrategia.ss_crmeducativo.asistencia;

import com.consultoraestrategia.ss_crmeducativo.asistencia.events.AsistenciaEvent;

/**
 * Created by kelvi on 20/02/2017.
 */

public interface AsistenciaPresenter {

    void onCreate();

    void onDestroy();

    void OnEventMainThread(AsistenciaEvent event);



}
