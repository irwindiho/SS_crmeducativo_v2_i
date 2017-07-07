package com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente;

/**
 * Created by kelvi on 20/02/2017.
 */

public class TabsCursoInteractorImpl implements TabsCursoInteractor  {

  private TabsCursoRepository tabsCursoRepository;

  public TabsCursoInteractorImpl() {
    this.tabsCursoRepository = new TabsCursoRepositoryImpl();
  }




}
