package com.consultoraestrategia.ss_crmeducativo.TabCursoAlumno;

/**
 * Created by kelvi on 20/02/2017.
 */

public class TabsCursoAlumnoInteractorImpl implements TabsCursoAlumnoInteractor {

  private TabsCursoAlumnoRepository tabsCursoAlumnoRepository;

  public TabsCursoAlumnoInteractorImpl() {
    this.tabsCursoAlumnoRepository = new TabsCursoAlumnoRepositoryImpl();
  }




}
