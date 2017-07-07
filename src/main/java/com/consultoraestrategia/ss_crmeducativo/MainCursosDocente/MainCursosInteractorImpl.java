package com.consultoraestrategia.ss_crmeducativo.MainCursosDocente;

/**
 * Created by kelvi on 20/02/2017.
 */

public class MainCursosInteractorImpl implements MainCursosInteractor {

  private MainCursosRepository mainCursosRepository;

  public MainCursosInteractorImpl() {
    this.mainCursosRepository = new MainCursosRepositoryImpl();
  }


}
