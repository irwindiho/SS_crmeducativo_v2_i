package com.consultoraestrategia.ss_crmeducativo.sesiones.events;

import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;

/**
 * Created by kelvi on 06/03/2017.
 */

public class SesionesEvent {
    public static final int loadSetupRecyclerSuccess = 1;
    public static final int loadSetupRecyclerError = -1;

    public static final int loadSpinnerTrimestreSuccess = 2;
    public static final int loadSpinnerTrimestreError = -2;

    public static final int loadSpinnerUnidadSuccess = 3;
    public static final int loadSpinnerUnidadError = -3;
    public int type;
    public String error;

}
