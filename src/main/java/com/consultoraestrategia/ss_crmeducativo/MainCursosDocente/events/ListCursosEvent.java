package com.consultoraestrategia.ss_crmeducativo.MainCursosDocente.events;

/**
 * Created by kelvi on 21/02/2017.
 */

public class ListCursosEvent {

  public static final int loadError = 0;
  public static final int failedToRecoverySession = -1;
  public static final int loadSuccess = 1;

  private int typeEvent;
  private String error;

  public int getTypeEvent() {
    return typeEvent;
  }

  public void setTypeEvent(int typeEvent) {
    this.typeEvent = typeEvent;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }



}
