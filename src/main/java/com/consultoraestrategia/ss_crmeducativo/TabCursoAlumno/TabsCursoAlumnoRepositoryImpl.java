package com.consultoraestrategia.ss_crmeducativo.TabCursoAlumno;

import android.support.annotation.NonNull;
import android.util.Log;

import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.events.ListCursosEvent;
import com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.events.TabsCursoEvent;
import com.consultoraestrategia.ss_crmeducativo.domain.FirebaseAuthHelper;
import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;
import com.google.firebase.auth.FirebaseAuth;


/**
 * Created by kelvi on 21/02/2017.
 */

public class TabsCursoAlumnoRepositoryImpl implements TabsCursoAlumnoRepository {


    private static final String TAG = "TabsCursoAlumnoRepositoryImpl";
    private boolean isLoadSuccess = false;
    private FirebaseAuthHelper firebaseAuthHelper;
    private FirebaseAuth firebaseAuth;

    public TabsCursoAlumnoRepositoryImpl() {

//        this.firebaseAuthHelper = FirebaseAuthHelper.getInstace();
//        firebaseAuth = firebaseAuthHelper.getmAuth();

    }


    private void postEvent(int type, String error) {
        TabsCursoEvent tabsCursoEvent = new TabsCursoEvent();
        tabsCursoEvent.setTypeEvent(type);
        if (error != null) {
            tabsCursoEvent.setError(error);
        }

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(tabsCursoEvent);
    }


    private void postEvent(int type) {
        postEvent(type, null);
    }

    @Override
    public void checkData() {
        firebaseAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                postEvent(ListCursosEvent.loadSuccess);
                isLoadSuccess = true;
                Log.d(TAG, "onLoadSuccess");
//                if (firebaseAuth != null && firebaseAuth.getCurrentUser() != null) {
//                    if (!isLoadSuccess) {
//
//
//                    }
//
//                } else {
//                    postEvent(ListCursosEvent.failedToRecoverySession);
//                }
            }
        });
    }

    @Override
    public void loadSuccess() {
        postEvent(TabsCursoEvent.loadSuccess);
    }

    @Override
    public void loadError() {
        postEvent(TabsCursoEvent.loadError);
    }
}
