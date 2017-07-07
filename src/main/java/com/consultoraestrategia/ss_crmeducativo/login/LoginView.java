package com.consultoraestrategia.ss_crmeducativo.login;

/**
 * Created by kelvi on 20/02/2017.
 */

public interface   LoginView {

    void onSuccessReadQr(String nameParam, String descriptionParam);

    void onErrorReadQr();

    void onShowProgress();

    void onHideProgress();

    void onShowViews();

    void onHideViews();

    void onGoNextActivity();

    void onSuccessSignIn();

    void onErrorSignIn(String error);

    void onEnableInputs();

    void onDisableInputs();

    void onLogoImageLoad(String url);

}
