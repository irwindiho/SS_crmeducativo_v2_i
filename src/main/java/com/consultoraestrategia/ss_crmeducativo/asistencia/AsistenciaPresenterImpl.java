package com.consultoraestrategia.ss_crmeducativo.asistencia;

import com.consultoraestrategia.ss_crmeducativo.asistencia.events.AsistenciaEvent;
import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;


/**
 * Created by kelvi on 20/02/2017.
 */

public class AsistenciaPresenterImpl implements AsistenciaPresenter {
    private static final String TAG = "AsistenciaPresenterImpl";
    private EventBus eventBus;
    private AsistenciaInteractor asistenciaInteractor;
    private AsistenciaView asistenciaView;


    public AsistenciaPresenterImpl(AsistenciaView asistenciaView) {
        this.asistenciaView = asistenciaView;
        this.asistenciaInteractor = new AsistenciaInteractorImpl();
        eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        asistenciaView = null;
        eventBus.unRegister(this);
    }

    @Override
    public void OnEventMainThread(AsistenciaEvent event) {

    }





}
