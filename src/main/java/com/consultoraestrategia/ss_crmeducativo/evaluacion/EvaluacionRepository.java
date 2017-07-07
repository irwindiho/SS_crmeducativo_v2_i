package com.consultoraestrategia.ss_crmeducativo.evaluacion;

import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;

/**
 * Created by kelvi on 06/03/2017.
 */

public interface EvaluacionRepository {
    void onloadInformation();

    void onChangeTrimestre(Trimestre trimestre);

    void onSaveNotas();
}
