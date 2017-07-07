package com.consultoraestrategia.ss_crmeducativo.evaluacion.events;

import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;

/**
 * Created by kelvi on 06/03/2017.
 */

public class EvaluacionEvent {
    public static final int loadInformacionSuccess = 1;
    public static final int loadInformacionError = -1;
    public static final int onChangeTrimestreSucess = 2;
    public static final int onChangeTrimestreError = -2;
    public static final int onSaveNotasSuccess = 3;
    public static final int onSaveNotasError = -3;
    public int type;
    public String error;
    public Trimestre trimestre;
}
