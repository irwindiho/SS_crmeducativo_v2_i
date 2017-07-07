package com.consultoraestrategia.ss_crmeducativo.tareas;

import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;
import com.consultoraestrategia.ss_crmeducativo.sesiones.events.SesionesEvent;
import com.consultoraestrategia.ss_crmeducativo.tareas.events.TareasEvent;

/**
 * Created by kelvi on 06/03/2017.
 */

public class TareasPresenterImpl implements TareasPresenter {
    private TareasView sesionesView;
    private TareasInteractor tareasInteractor;
    private EventBus eventBus;

    public TareasPresenterImpl(TareasView sesionesView) {
        this.sesionesView = sesionesView;
        this.tareasInteractor = new TareasInteractorImpl();
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
        tareasInteractor.onSetupRecycler();
    }

    @Override
    public void onFabNewsClick() {
        if (sesionesView != null) {

        }
        tareasInteractor.onFabNewsClick();
    }

    @Override
    public void OnEventMainThread(TareasEvent tareasEvent) {
        switch (tareasEvent.type) {
            case TareasEvent.loadSetupRecyclerSuccess:
                loadSetupRecyclerSuccess();
                break;
            case TareasEvent.loadSetupRecyclerError:
                loadSetupRecyclerError(tareasEvent.error);
                break;
            case TareasEvent.loadFabNewsClickSuccess:
                loadFabNewsClickSuccess();
                break;
            case TareasEvent.loadFabNewsClickError:
                loadFabNewsClickError(tareasEvent.error);
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

    private void loadFabNewsClickSuccess() {
        if (sesionesView != null) {
            sesionesView.onFabNewsClick();
        }
    }

    private void loadFabNewsClickError(String error) {
        if (sesionesView != null) {
            sesionesView.onFabNewsClickError(error);
        }
    }




}


