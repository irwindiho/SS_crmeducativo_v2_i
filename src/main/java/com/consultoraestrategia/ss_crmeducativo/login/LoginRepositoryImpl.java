package com.consultoraestrategia.ss_crmeducativo.login;

import android.support.annotation.NonNull;
import android.util.Log;

import com.consultoraestrategia.ss_crmeducativo.domain.FirebaseAuthHelper;
import com.consultoraestrategia.ss_crmeducativo.entities.Usuario;
//import com.consultoraestrategia.ss_crmeducativo.entities.Usuario_Table;
import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;
import com.consultoraestrategia.ss_crmeducativo.login.events.LoginEvent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;


/**
 * Created by kelvi on 21/02/2017.
 */

public class LoginRepositoryImpl implements LoginRepository {


    private static final String TAG = "AsistenciaRepositoryImpl";
    private boolean isSessionActive = false;

    private FirebaseAuthHelper firebaseAuthHelper;
    private FirebaseAuth firebaseAuth;

    public LoginRepositoryImpl() {
        this.firebaseAuthHelper = FirebaseAuthHelper.getInstace();
        firebaseAuth = firebaseAuthHelper.getmAuth();
    }

    @Override
    public void checkSession() {

        firebaseAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                Log.d(TAG, "onAuthStateChanged");
                if (firebaseAuth != null && firebaseAuth.getCurrentUser() != null) {
                    if (!isSessionActive) {
                        isSessionActive = true;
                        postEvent(LoginEvent.signInSuccess);
                    }

                } else {
                    postEvent(LoginEvent.failedToRecoverySession);
                }
            }
        });


    }

    @Override
    public void signIn(String user, String password) {
        firebaseAuth.signInWithEmailAndPassword(user.trim(), password.trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    postEvent(LoginEvent.signInSuccess);
                } else {
                    postEvent(LoginEvent.signInError, task.getException().getMessage());
                }
            }
        });
//        String[] datosLogin = {user, password};
//        List<Usuario> usuarioList = new Select()
//                .from(Usuario.class)
//                .where(Usuario_Table.usuario.eq(datosLogin[0]))
//                .and(Usuario_Table.password.eq(datosLogin[1]))
//                .queryList();
//        if (usuarioList != null) {
//            postEvent(LoginEvent.signInSuccess);
//        } else {
//            postEvent(LoginEvent.signInError, "No Existe Usuario o Password incorrecto");
//        }

    }

    private void postEvent(int type, String error) {
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setTypeEvent(type);
        if (error != null) {
            loginEvent.setError(error);
        }

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(loginEvent);
    }

    private void postEvent(int type) {
        postEvent(type, null);
    }

}
