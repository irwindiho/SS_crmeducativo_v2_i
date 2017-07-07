package com.consultoraestrategia.ss_crmeducativo.lib;

/**
 * Created by kelvi on 20/02/2017.
 */

public interface EventBus {

    void register(Object subscriber);

    void unRegister(Object subscriber);

    void post(Object event);
}
