package com.consultoraestrategia.ss_crmeducativo.sesiones;

import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;

/**
 * Created by kelvi on 06/03/2017.
 */

public interface SesionesRepository {
    void onSetupRecycler();

    void onLoadSpinnerTrimestre();

    void onLoadSpinnerUnidad();
}
