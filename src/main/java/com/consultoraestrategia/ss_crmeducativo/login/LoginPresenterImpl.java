package com.consultoraestrategia.ss_crmeducativo.login;

import android.util.Log;

import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;
import com.consultoraestrategia.ss_crmeducativo.login.events.LoginEvent;

import org.greenrobot.eventbus.Subscribe;


/**
 * Created by kelvi on 20/02/2017.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private static final String TAG = "AsistenciaPresenterImpl";
    private EventBus eventBus;
    private LoginInteractor loginInteractor;
    private LoginView loginView;


    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
        eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
        eventBus.unRegister(this);
    }

    @Override
    public void onValidateCodeQr(String code) {
        loginView.onSuccessReadQr("Kelvin", "Thony");
    }

    @Override
    public void onSuccessQr() {

    }

    @Override
    public void onErrorQr(String error) {

    }

    @Override
    public void onCheckForAutentificatedUser() {

        if (loginView != null) {
            loginView.onDisableInputs();
            loginView.onShowProgress();
        }
        loginInteractor.checkSession();

    }

    @Override
    @Subscribe
    public void OnEventMainThread(LoginEvent event) {
        switch (event.getTypeEvent()) {
            case LoginEvent.signInSuccess:
                onSignInSuccess();
                break;
            case LoginEvent.signInError:
                onSignInError(event.getError());
                break;
            case LoginEvent.failedToRecoverySession:
                failtedToRecoverySession();
                break;
        }
    }

    private void failtedToRecoverySession() {
        if (loginView != null) {
            loginView.onHideProgress();
            loginView.onEnableInputs();
        }
        Log.d(TAG, "failtedToRecoverySession");
        loginView.onLogoImageLoad("https://assets.materialup.com/uploads/c0b9f1d9-3a2e-4c5f-b969-b9f26b6e6c14/preview.png");
    }

    @Override
    public void onSignInValidate(String user, String password) {
        if (loginView != null) {
            loginView.onDisableInputs();
            loginView.onShowProgress();
        }
        loginInteractor.signIn(user, password);
    }

    private void onSignInSuccess() {
        if (loginView != null) {
            loginView.onHideProgress();
            loginView.onSuccessSignIn();
            loginView.onGoNextActivity();
        }

    }

    private void onSignInError(String error) {
        if (loginView != null) {
            loginView.onHideProgress();
            loginView.onEnableInputs();
            loginView.onErrorSignIn(error);
        }

    }
}
