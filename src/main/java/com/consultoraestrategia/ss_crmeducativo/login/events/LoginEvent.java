package com.consultoraestrategia.ss_crmeducativo.login.events;

/**
 * Created by kelvi on 21/02/2017.
 */

public class LoginEvent {
    public static final int signInError = 0;
    public static final int failedToRecoverySession = -1;
    public static final int signInSuccess = 1;

    private int typeEvent;
    private String error;

    public int getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(int typeEvent) {
        this.typeEvent = typeEvent;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


}
