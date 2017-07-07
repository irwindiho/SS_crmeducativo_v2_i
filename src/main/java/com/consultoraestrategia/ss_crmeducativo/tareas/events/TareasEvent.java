package com.consultoraestrategia.ss_crmeducativo.tareas.events;

/**
 * Created by kelvi on 06/03/2017.
 */

public class TareasEvent {
    public static final int loadSetupRecyclerSuccess = 1;
    public static final int loadSetupRecyclerError = -1;

    public static final int loadFabNewsClickSuccess = 2;
    public static final int loadFabNewsClickError = -2;


    public int type;
    public String error;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
