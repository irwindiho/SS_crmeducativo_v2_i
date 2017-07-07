package com.consultoraestrategia.ss_crmeducativo.login;

/**
 * Created by kelvi on 21/02/2017.
 */

public interface LoginRepository {
    void checkSession();

    void signIn(String user, String password);
}
