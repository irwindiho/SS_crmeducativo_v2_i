package com.consultoraestrategia.ss_crmeducativo.tareas;

import com.consultoraestrategia.ss_crmeducativo.sesiones.events.SesionesEvent;
import com.consultoraestrategia.ss_crmeducativo.tareas.events.TareasEvent;

/**
 * Created by kelvi on 06/03/2017.
 */

public interface TareasPresenter {
    void onCreate();

    void onDestroy();

    void onSetupRecycler();

    void onFabNewsClick();

    void OnEventMainThread(TareasEvent tareasEvent);

}
