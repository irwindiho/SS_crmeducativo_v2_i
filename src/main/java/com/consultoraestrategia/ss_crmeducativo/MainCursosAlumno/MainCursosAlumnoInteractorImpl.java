package com.consultoraestrategia.ss_crmeducativo.MainCursosAlumno;

/**
 * Created by kelvi on 20/02/2017.
 */

public class MainCursosAlumnoInteractorImpl implements MainCursosAlumnoInteractor {

  private MainCursosAlumnoRepository mainCursosAlumnoRepository;

  public MainCursosAlumnoInteractorImpl() {
    this.mainCursosAlumnoRepository = new MainCursosAlumnoRepositoryImpl();
  }


}
