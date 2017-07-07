package com.consultoraestrategia.ss_crmeducativo.login;

import com.consultoraestrategia.ss_crmeducativo.login.events.LoginEvent;

/**
 * Created by kelvi on 20/02/2017.
 */

public interface LoginPresenter {

    void onCreate();

    void onDestroy();

    void onValidateCodeQr(String code);

    void onSuccessQr();

    void onErrorQr(String error);

    void onCheckForAutentificatedUser();

    void OnEventMainThread(LoginEvent event);

    void onSignInValidate(String user, String password);


}
