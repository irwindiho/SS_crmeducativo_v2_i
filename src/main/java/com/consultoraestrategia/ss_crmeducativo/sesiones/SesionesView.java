package com.consultoraestrategia.ss_crmeducativo.sesiones;

import com.consultoraestrategia.ss_crmeducativo.entities.Alumnos;
import com.consultoraestrategia.ss_crmeducativo.entities.Capacidades;

import java.util.List;

/**
 * Created by kelvi on 06/03/2017.
 */

public interface SesionesView {
    void onSetupRecycler();
    void onSetupRecyclerError(String e);
    void onLoadSpinnerTrimestre();
    void onLoadSpinnerTrimestreError(String e);
    void onLoadSpinnerUnidad();
    void onLoadSpinnerUnidadError(String e);
}
