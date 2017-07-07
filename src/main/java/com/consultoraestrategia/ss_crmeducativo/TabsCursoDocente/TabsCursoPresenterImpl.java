package com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente;

import android.util.Log;

import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.events.ListCursosEvent;
import com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.events.TabsCursoEvent;
import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;


/**
 * Created by kelvi on 20/02/2017.
 */

public class TabsCursoPresenterImpl implements TabsCursoPresenter {
    private static final String TAG = "TabsCursoAlumnoPresenterImpl";
    private EventBus eventBus;
    private TabsCursoInteractor tabsCursoInteractor;
    private TabsCursoView tabsCursoView;


    public TabsCursoPresenterImpl(TabsCursoView tabsCursoView) {
        this.tabsCursoView = tabsCursoView;
        this.tabsCursoInteractor = new TabsCursoInteractorImpl();
        eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        tabsCursoView = null;
        eventBus.unRegister(this);
    }

    @Override
    public void OnEventMainThread(TabsCursoEvent event) {
        switch (event.getTypeEvent()) {
            case ListCursosEvent.loadSuccess:
                onLoadSuccess();
                break;
            case ListCursosEvent.loadError:
                onLoadError(event.getError());
                break;
            case ListCursosEvent.failedToRecoverySession:
                failtedToRecoverySession();
                break;
        }
    }


    private void failtedToRecoverySession() {
        if (tabsCursoView != null) {

        }
        Log.d(TAG, "failtedToRecoverySession");
//        tabsCursoView.onImageCursoLoad("https://assets.materialup.com/uploads/c0b9f1d9-3a2e-4c5f-b969-b9f26b6e6c14/preview.png");
    }

    private void onLoadSuccess() {
        if (tabsCursoView != null) {
            tabsCursoView.onImageCursoLoad("https://assets.materialup.com/uploads/c0b9f1d9-3a2e-4c5f-b969-b9f26b6e6c14/preview.png");
            tabsCursoView.onLoadSuccess();

        }

    }

    private void onLoadError(String error) {
        if (tabsCursoView != null) {
//            tabsCursoView.onHideImagesProfile();
            tabsCursoView.onLoadError(error);
        }

    }

}
