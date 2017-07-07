package com.consultoraestrategia.ss_crmeducativo.evaluacion;

import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;

/**
 * Created by kelvi on 06/03/2017.
 */

public interface EvaluacionInteractor {

    void onloadInformation();

    void onChangeTrimestre(Trimestre trimestre);

    void onSaveNotas();

}
