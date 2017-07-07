package com.consultoraestrategia.ss_crmeducativo.asistencia;

import com.consultoraestrategia.ss_crmeducativo.asistencia.events.AsistenciaEvent;
import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;

//import com.consultoraestrategia.ss_crmeducativo.entities.Usuario_Table;
//import com.raizlabs.android.dbflow.sql.language.Select;


/**
 * Created by kelvi on 21/02/2017.
 */

public class AsistenciaRepositoryImpl implements AsistenciaRepository {


    private static final String TAG = "AsistenciaRepositoryImpl";

    public AsistenciaRepositoryImpl() {

    }


    private void postEvent(int type, String error) {
        AsistenciaEvent event = new AsistenciaEvent();
//

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(event);
    }

    private void postEvent(int type) {
        postEvent(type, null);
    }

    @Override
    public void onGetListaAlumnos() {

    }

    @Override
    public void onInitListView() {

    }

    @Override
    public void onChangeStateFabButtons() {

    }
}
