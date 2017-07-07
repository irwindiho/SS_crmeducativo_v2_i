package com.consultoraestrategia.ss_crmeducativo.asistencia;

/**
 * Created by kelvi on 20/02/2017.
 */

public class AsistenciaInteractorImpl implements AsistenciaInteractor {

    private AsistenciaRepository asistenciaRepository;

    public AsistenciaInteractorImpl() {
        this.asistenciaRepository = new AsistenciaRepositoryImpl();
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
