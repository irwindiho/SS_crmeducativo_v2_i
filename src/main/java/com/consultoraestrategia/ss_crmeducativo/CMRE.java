package com.consultoraestrategia.ss_crmeducativo;

import android.app.Application;
import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by kelvi on 22/02/2017.
 */

public class CMRE extends Application {
    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(new FlowConfig.Builder(this).build());
        FirebaseApp.initializeApp(this);

        context = this;
//        FlowManager.init(new FlowConfig.Builder(this).build());

//        FlowManager flowManager = new FlowMangerImpl(this);
//        flowManager.init();

//        initDb();


    }


    public static Context getContext() {
        return context;
    }
}

