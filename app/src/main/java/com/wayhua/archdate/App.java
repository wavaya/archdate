package com.wayhua.archdate;


import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.wayhua.archdate.di.CountdownComponent;
import com.wayhua.archdate.di.CountdownModule;
import com.wayhua.archdate.di.DaggerCountdownComponent;

import timber.log.Timber;

public class App extends Application {

    private final CountdownComponent countDownComponent = createCountdownComponent();

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());//TODO Install a Crashlytics tree in production
        }
    }

    protected CountdownComponent createCountdownComponent() {
        return DaggerCountdownComponent.builder()
                .countdownModule(new CountdownModule(this))
                .build();
    }

    public CountdownComponent getCountDownComponent() {
        return countDownComponent;
    }

}
