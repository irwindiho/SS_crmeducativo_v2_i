package com.consultoraestrategia.ss_crmeducativo.evaluacion;

import android.util.Log;

import com.consultoraestrategia.ss_crmeducativo.entities.Alumnos;
import com.consultoraestrategia.ss_crmeducativo.entities.Capacidades;
import com.consultoraestrategia.ss_crmeducativo.entities.Trimestre;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.events.EvaluacionEvent;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters.TableAlumnosAdapter;
import com.consultoraestrategia.ss_crmeducativo.lib.EventBus;
import com.consultoraestrategia.ss_crmeducativo.lib.GreenRobotEventBus;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kelvi on 06/03/2017.
 */

public class EvaluacionPresenterImpl implements EvaluacionPresenter {
    private EvaluacionView evaluacionView;
    private EvaluacionInteractor evaluacionInteractor;
    private EventBus eventBus;

    public EvaluacionPresenterImpl(EvaluacionView evaluacionView) {
        this.evaluacionView = evaluacionView;
        this.evaluacionInteractor = new EvaluacionInteractorImpl();
        eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        evaluacionView = null;
        eventBus.unRegister(this);
    }

    @Override
    public void onloadInformation() {
        if (evaluacionView != null) {

        }
        evaluacionInteractor.onloadInformation();
    }

    @Override
    public void onChangeTrimestre(Trimestre trimestre) {
        if (evaluacionView != null) {

        }
        evaluacionInteractor.onChangeTrimestre(trimestre);
    }

    @Override
    public void onSaveNotas() {
        if (evaluacionView != null) {

        }
        evaluacionInteractor.onSaveNotas();
    }


    @Override
    @Subscribe
    public void OnEventMainThread(EvaluacionEvent evaluacionEvent) {

        switch (evaluacionEvent.type) {
            case EvaluacionEvent.loadInformacionSuccess:
                loadInformacionSuccess();
                break;
            case EvaluacionEvent.loadInformacionError:
                loadInformacionError(evaluacionEvent.error);
                break;
            case EvaluacionEvent.onChangeTrimestreSucess:
                onChangeTrimestreSucess(null);
                break;
            case EvaluacionEvent.onChangeTrimestreError:
                onChangeTrimestreError(evaluacionEvent.error);
                break;
            case EvaluacionEvent.onSaveNotasSuccess:
                onSaveNotasSuccess();
                break;
            case EvaluacionEvent.onSaveNotasError:
                onSaveNotasError(evaluacionEvent.error);
                break;

        }

    }

    private void loadInformacionSuccess() {
        if (evaluacionView != null) {
//            List<Alumnos> alumnoses = new ArrayList<>();
//            List<Capacidades> trimestres = new ArrayList<>();
//            trimestres.add(new Capacidades(1, "12", "Examen"));
//            trimestres.add(new Capacidades(2, "13", "Proyecto"));
//            alumnoses.add(new Alumnos(1, "Kelvin", "Thony", trimestres));
//            alumnoses.add(new Alumnos(2, "Juan", "Perez", trimestres));
//            Log.d("", "RELOAD?");
//            List<String> strings = new ArrayList<>();
//            strings.add("1 Trimestre");
//            strings.add("2 Trimestre");
//            strings.add("3 Trimestre");
//            strings.add("4 Trimestre");
//            strings.add("Final");
//            evaluacionView.onLoadMenu(strings);
//            evaluacionView.onLoadTableAlumnos(alumnoses, trimestres);
        }
    }

    private void loadInformacionError(String error) {
        if (evaluacionView != null) {
            evaluacionView.onLoadMenuError(error);
        }
    }

    public void onChangeTrimestreSucess(TableAlumnosAdapter alumnosAdapter) {
        if (evaluacionView != null) {
//            List<Alumnos> alumnoses = new ArrayList<>();
//            List<Capacidades> trimestres = new ArrayList<>();
//            trimestres.add(new Capacidades(1, "12", "Examen"));
//            trimestres.add(new Capacidades(2, "13", "Proyecto"));
//            alumnoses.add(new Alumnos(1, "Kelvin", "Thony", trimestres));
//            alumnoses.add(new Alumnos(2, "Juan", "Perez", trimestres));
//            Log.d("", "RELOAD?");
//            evaluacionView.onLoadTableAlumnos(alumnoses, trimestres);
        }
    }

    public void onChangeTrimestreError(String error) {
        if (evaluacionView != null) {
            evaluacionView.onLoadTableAlumnosError(error);
        }
    }

    public void onSaveNotasSuccess() {
        if (evaluacionView != null) {
            evaluacionView.onSaveNotasSuccess();
        }
    }

    public void onSaveNotasError(String error) {
        if (evaluacionView != null) {
            evaluacionView.onSaveNotasError(error);
        }
    }
}
