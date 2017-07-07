package com.consultoraestrategia.ss_crmeducativo.sesiones;

import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.events.EvaluacionEvent;
import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;
import com.consultoraestrategia.ss_crmeducativo.sesiones.events.SesionesEvent;

/**
 * Created by kelvi on 06/03/2017.
 */

public class SesionesRepositoryImpl implements SesionesRepository {


    private void postEvent(int type) {
        postEvent(type, null, null);
    }

    private void postEvent(int type, String error) {
        postEvent(type, error, null);
    }

    private void postEvent(int type, Trimestre trimestre) {
        postEvent(type, null, trimestre);
    }

    private void postEvent(int type, String error, Trimestre trimestre) {
        SesionesEvent sesionesEvent = new SesionesEvent();
        sesionesEvent.type = type;
        if (error != null) {
            sesionesEvent.error = error;
        }

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(sesionesEvent);
    }

    @Override
    public void onSetupRecycler() {
        postEvent(SesionesEvent.loadSetupRecyclerSuccess);
    }

    @Override
    public void onLoadSpinnerTrimestre() {
        postEvent(SesionesEvent.loadSpinnerTrimestreSuccess);
    }

    @Override
    public void onLoadSpinnerUnidad() {
        postEvent(SesionesEvent.loadSpinnerUnidadSuccess);
    }
}
