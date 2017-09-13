package org.blankapp.app;

import org.blankapp.BlankApp;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BlankApp.initialize(getApplicationContext(), true);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        BlankApp.dispose();
    }
}
