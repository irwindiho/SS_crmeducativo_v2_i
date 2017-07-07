package com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente;

import com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.events.TabsCursoEvent;

/**
 * Created by irvinmarin on 27/02/2017.
 */

public interface TabsCursoPresenter {

  void onCreate();
  void onDestroy();
  void OnEventMainThread(TabsCursoEvent event);
}
