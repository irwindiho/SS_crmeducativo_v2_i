package com.consultoraestrategia.ss_crmeducativo.login;

/**
 * Created by kelvi on 20/02/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {

    private LoginRepository loginRepository;

    public LoginInteractorImpl() {
        this.loginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void checkSession() {
        loginRepository.checkSession();
    }

    @Override
    public void signIn(String user, String password) {
        loginRepository.signIn(user, password);
    }


}
