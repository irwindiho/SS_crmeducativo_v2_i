package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.interfaces;

import android.view.View;

import com.consultoraestrategia.ss_crmeducativo.entities.TrimestresNotas;

import java.util.HashMap;

/**
 * Created by kelvi on 28/02/2017.
 */

public interface OnItemCheckTrimestreClick {

    void onItemClickListener(HashMap<Integer, TrimestresNotas> notasHashMap, View view, String idCapacidad);

}
