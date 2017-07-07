package com.consultoraestrategia.ss_crmeducativo.TabCursoAlumno;

import android.util.Log;

import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.events.ListCursosEvent;
import com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.events.TabsCursoEvent;
import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;


/**
 * Created by kelvi on 20/02/2017.
 */

public class TabsCursoAlumnoPresenterImpl implements TabsCursoAlumnoPresenter {
    private static final String TAG = "TabsCursoAlumnoPresenterImpl";
    private EventBus eventBus;
    private TabsCursoAlumnoInteractor tabsCursoAlumnoInteractor;
    private TabsCursoAlumnoView tabsCursoAlumnoView;


    public TabsCursoAlumnoPresenterImpl(TabsCursoAlumnoView tabsCursoAlumnoView) {
        this.tabsCursoAlumnoView = tabsCursoAlumnoView;
        this.tabsCursoAlumnoInteractor = new TabsCursoAlumnoInteractorImpl();
        eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        tabsCursoAlumnoView = null;
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
        if (tabsCursoAlumnoView != null) {

        }
        Log.d(TAG, "failtedToRecoverySession");
//        tabsCursoAlumnoView.onImageCursoLoad("https://assets.materialup.com/uploads/c0b9f1d9-3a2e-4c5f-b969-b9f26b6e6c14/preview.png");
    }

    private void onLoadSuccess() {
        if (tabsCursoAlumnoView != null) {
            tabsCursoAlumnoView.onImageCursoLoad("https://assets.materialup.com/uploads/c0b9f1d9-3a2e-4c5f-b969-b9f26b6e6c14/preview.png");
            tabsCursoAlumnoView.onLoadSuccess();

        }

    }

    private void onLoadError(String error) {
        if (tabsCursoAlumnoView != null) {
//            tabsCursoAlumnoView.onHideImagesProfile();
            tabsCursoAlumnoView.onLoadError(error);
        }

    }

}
