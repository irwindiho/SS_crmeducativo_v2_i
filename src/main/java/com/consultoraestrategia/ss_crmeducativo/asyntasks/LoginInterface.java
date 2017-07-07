package com.consultoraestrategia.ss_crmeducativo.asyntasks;

/**
 * Created by irvinmarin on 28/04/2017.
 */

public interface LoginInterface {
    void loginCorrecto(String mensaje);

    void loginError(String mensaje);

    void loginErrorProcedimiento(String mensaje);
}
