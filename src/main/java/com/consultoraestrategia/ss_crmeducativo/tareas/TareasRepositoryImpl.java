package com.consultoraestrategia.ss_crmeducativo.tareas;

import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;
import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;
import com.consultoraestrategia.ss_crmeducativo.login.events.LoginEvent;
import com.consultoraestrategia.ss_crmeducativo.sesiones.events.SesionesEvent;
import com.consultoraestrategia.ss_crmeducativo.tareas.events.TareasEvent;

/**
 * Created by kelvi on 06/03/2017.
 */

public class TareasRepositoryImpl implements TareasRepository {

    private static final String TAG = "TareasRepositoryImpl";

    private void postEvent(int type, String error) {
        TareasEvent tareasEvent = new TareasEvent();
        tareasEvent.setType(type);
        if (error != null) {
            tareasEvent.setError(error);
        }

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(tareasEvent);
    }

    private void postEvent(int type) {
        postEvent(type, null);
    }

    @Override
    public void onSetupRecycler() {
        postEvent(TareasEvent.loadSetupRecyclerSuccess);
    }

    @Override
    public void onFabNewsClick() {
        postEvent(TareasEvent.loadFabNewsClickSuccess);
    }


}
