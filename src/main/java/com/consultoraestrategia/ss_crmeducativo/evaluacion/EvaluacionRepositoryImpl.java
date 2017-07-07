package com.consultoraestrategia.ss_crmeducativo.evaluacion;

import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.events.EvaluacionEvent;
import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;
import com.consultoraestrategia.ss_crmeducativo.login.events.LoginEvent;

/**
 * Created by kelvi on 06/03/2017.
 */

public class EvaluacionRepositoryImpl implements EvaluacionRepository {


    @Override
    public void onloadInformation() {
        postEvent(EvaluacionEvent.loadInformacionSuccess);
    }

    @Override
    public void onChangeTrimestre(Trimestre trimestre) {
        postEvent(EvaluacionEvent.onChangeTrimestreSucess, trimestre);
    }

    @Override
    public void onSaveNotas() {
        postEvent(EvaluacionEvent.onSaveNotasSuccess);
    }

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
        EvaluacionEvent loginEvent = new EvaluacionEvent();
        loginEvent.type = type;
        if (error != null) {
            loginEvent.error = error;
        }
        if (trimestre != null) {
            loginEvent.trimestre = trimestre;
        }

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(loginEvent);
    }
}
