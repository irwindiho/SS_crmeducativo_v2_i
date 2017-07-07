package com.consultoraestrategia.ss_crmeducativo.MainCursosDocente;

import android.util.Log;

import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.events.ListCursosEvent;
import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;


/**
 * Created by kelvi on 20/02/2017.
 */

public class MainCursosPresenterImpl implements MainCursosPresenter {
    private static final String TAG = "MainCursosAlumnoPresenterImpl";
    private EventBus eventBus;
    private MainCursosInteractor mainCursosInteractor;
    private MainCursosView mainCursosView;


    public MainCursosPresenterImpl(MainCursosView mainCursosView) {
        this.mainCursosView = mainCursosView;
        this.mainCursosInteractor = new MainCursosInteractorImpl();
        eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        mainCursosView = null;
        eventBus.unRegister(this);
    }

    @Override
    public void OnEventMainThread(ListCursosEvent event) {
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
        if (mainCursosView != null) {

        }
        Log.d(TAG, "failtedToRecoverySession");
        mainCursosView.onImageProfile1Load("https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/7/005/019/3f0/0c53a9f.jpg");
        mainCursosView.onImageProfile2Load("https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/7/005/019/3f0/0c53a9f.jpg");
        mainCursosView.onImageProfile3Load("https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/7/005/019/3f0/0c53a9f.jpg");
        mainCursosView.onImageBackgroudProfileLoad("https://assets.materialup.com/uploads/c0b9f1d9-3a2e-4c5f-b969-b9f26b6e6c14/preview.png");

    }

    private void onLoadSuccess() {
        if (mainCursosView != null) {
            mainCursosView.onShowImagesProfile();
            mainCursosView.onLoadSuccess();

        }

    }

    private void onLoadError(String error) {
        if (mainCursosView != null) {
            mainCursosView.onHideImagesProfile();
            mainCursosView.onLoadError(error);
        }

    }


}
