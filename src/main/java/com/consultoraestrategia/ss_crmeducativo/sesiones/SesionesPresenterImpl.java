package com.consultoraestrategia.ss_crmeducativo.sesiones;

import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;
import com.consultoraestrategia.ss_crmeducativo.sesiones.events.SesionesEvent;

/**
 * Created by kelvi on 06/03/2017.
 */

public class SesionesPresenterImpl implements SesionesPresenter {
    private SesionesView sesionesView;
    private SesionesInteractor sesionesInteractor;
    private EventBus eventBus;

    public SesionesPresenterImpl(SesionesView sesionesView) {
        this.sesionesView = sesionesView;
        this.sesionesInteractor = new SesionesInteractorImpl();
        eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        sesionesView = null;
        eventBus.unRegister(this);
    }

    @Override
    public void onSetupRecycler() {
        if (sesionesView != null) {

        }
        sesionesInteractor.onSetupRecycler();
    }

    @Override
    public void onLoadSpinnerTrimestre() {
        if (sesionesView != null) {

        }
        sesionesInteractor.onLoadSpinnerTrimestre();
    }

    @Override
    public void onLoadSpinnerUnidad() {
        if (sesionesView != null) {

        }
        sesionesInteractor.onLoadSpinnerUnidad();
    }

    @Override
    public void OnEventMainThread(SesionesEvent sesionesEvent) {
        switch (sesionesEvent.type) {
            case SesionesEvent.loadSetupRecyclerSuccess:
                loadSetupRecyclerSuccess();
                break;
            case SesionesEvent.loadSetupRecyclerError:
                loadSetupRecyclerError(sesionesEvent.error);
                break;
            case SesionesEvent.loadSpinnerTrimestreSuccess:
                loadSpinnerTrimestreSuccess();
                break;
            case SesionesEvent.loadSpinnerTrimestreError:
                loadSpinnerTrimestreError(sesionesEvent.error);
                break;
            case SesionesEvent.loadSpinnerUnidadSuccess:
                loadSpinnerUnidadSuccess();
                break;
            case SesionesEvent.loadSpinnerUnidadError:
                loadSpinnerUnidadError(sesionesEvent.error);
                break;
        }
    }


    private void loadSetupRecyclerSuccess() {
        if (sesionesView != null) {
            sesionesView.onSetupRecycler();
        }
    }

    private void loadSetupRecyclerError(String error) {
        if (sesionesView != null) {
            sesionesView.onSetupRecyclerError(error);
        }
    }

    private void loadSpinnerTrimestreSuccess() {
        if (sesionesView != null) {
            sesionesView.onLoadSpinnerTrimestre();
        }
    }

    private void loadSpinnerTrimestreError(String error) {
        if (sesionesView != null) {
            sesionesView.onLoadSpinnerTrimestreError(error);
        }
    }


    private void loadSpinnerUnidadSuccess() {
        if (sesionesView != null) {
            sesionesView.onLoadSpinnerUnidad();
        }
    }

    private void loadSpinnerUnidadError(String error) {
        if (sesionesView != null) {
            sesionesView.onLoadSpinnerUnidadError(error);
        }
    }

}


