package com.consultoraestrategia.ss_crmeducativo.sesiones;

import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;

/**
 * Created by kelvi on 06/03/2017.
 */

public class SesionesInteractorImpl implements SesionesInteractor {

    private SesionesRepository sesionesRepository;

    public SesionesInteractorImpl() {
        this.sesionesRepository = new SesionesRepositoryImpl();
    }

    @Override
    public void onSetupRecycler() {
        sesionesRepository.onSetupRecycler();
    }

    @Override
    public void onLoadSpinnerTrimestre() {
        sesionesRepository.onLoadSpinnerTrimestre();
    }

    @Override
    public void onLoadSpinnerUnidad() {
        sesionesRepository.onLoadSpinnerUnidad();
    }

//    @Override
//    public void onloadInformation() {
//        sesionesRepository.onloadInformation();
//    }
//
//    @Override
//    public void onChangeTrimestre(Trimestre trimestre) {
//        sesionesRepository.onChangeTrimestre(trimestre);
//    }
//
//    @Override
//    public void onSaveNotas() {
//        sesionesRepository.onSaveNotas();
//    }
}
