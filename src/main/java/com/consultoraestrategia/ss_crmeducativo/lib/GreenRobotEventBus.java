package com.consultoraestrategia.ss_crmeducativo.lib;

/**
 * Created by kelvi on 20/02/2017.
 */

public class GreenRobotEventBus implements EventBus {

  private org.greenrobot.eventbus.EventBus eventBus;

  private static class SingletonHolder {
    private static final GreenRobotEventBus INSTANCE = new GreenRobotEventBus();
  }

  public static GreenRobotEventBus getInstance() {
    return SingletonHolder.INSTANCE;
  }

  public GreenRobotEventBus() {
    this.eventBus = org.greenrobot.eventbus.EventBus.getDefault();
  }


  @Override
  public void register(Object subscriber) {
//        eventBus.register(subscriber);
  }

  @Override
  public void unRegister(Object subscriber) {
    eventBus.unregister(subscriber);
  }

  @Override
  public void post(Object event) {
    eventBus.post(event);
  }
}
