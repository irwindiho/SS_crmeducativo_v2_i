package com.consultoraestrategia.ss_crmeducativo.evaluacion;

import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;

/**
 * Created by kelvi on 06/03/2017.
 */

public class EvaluacionInteractorImpl implements EvaluacionInteractor {

    private EvaluacionRepository evaluacionRepository;

    public EvaluacionInteractorImpl() {
        this.evaluacionRepository = new EvaluacionRepositoryImpl();
    }

    @Override
    public void onloadInformation() {
        evaluacionRepository.onloadInformation();
    }

    @Override
    public void onChangeTrimestre(Trimestre trimestre) {
        evaluacionRepository.onChangeTrimestre(trimestre);
    }

    @Override
    public void onSaveNotas() {
        evaluacionRepository.onSaveNotas();
    }
}
