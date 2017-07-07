package com.consultoraestrategia.ss_crmeducativo.MainCursosAlumno;

import com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.events.ListCursosEvent;

/**
 * Created by irvinmarin on 27/02/2017.
 */

public interface MainCursosAlumnoPresenter {

    void onCreate();
    void onDestroy();
    void OnEventMainThread(ListCursosEvent event);
}
