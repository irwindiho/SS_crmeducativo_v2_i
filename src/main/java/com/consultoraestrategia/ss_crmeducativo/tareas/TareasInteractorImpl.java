package com.consultoraestrategia.ss_crmeducativo.tareas;

/**
 * Created by kelvi on 06/03/2017.
 */

public class TareasInteractorImpl implements TareasInteractor {

    private TareasRepository tareasRepository;

    public TareasInteractorImpl() {
        this.tareasRepository = new TareasRepositoryImpl();
    }

    @Override
    public void onSetupRecycler() {
        tareasRepository.onSetupRecycler();
    }

    @Override
    public void onFabNewsClick() {
        tareasRepository.onFabNewsClick();
    }


}
