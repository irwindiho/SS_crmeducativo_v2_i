package com.consultoraestrategia.ss_crmeducativo.login;

/**
 * Created by kelvi on 20/02/2017.
 */

public interface LoginInteractor {
    void checkSession();

    void signIn(String user, String password);
}
