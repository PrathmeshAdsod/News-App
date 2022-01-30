package com.prathmeshadsod.thehindustanprime.OneSignal;

import android.app.Application;

import com.onesignal.OneSignal;

public class MyApplication extends Application {
    private static final String ONESIGNAL_APP_ID = "18188f75-5195-4cd8-a15e-a20b4517b42e";

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }
}
