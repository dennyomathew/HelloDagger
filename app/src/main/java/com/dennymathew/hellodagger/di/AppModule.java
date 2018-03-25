package com.dennymathew.hellodagger.di;

import android.app.Application;
import android.content.Context;

import com.dennymathew.hellodagger.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Denny on 3/22/2018.
 */

@Module
public class AppModule {

    //private Application application;
/*
    public AppModule(App application) {
        this.application = application;
    }
*/
    @Singleton
    @Provides
    Context providesAppContext(App application) {
        return application.getApplicationContext();
    }

    //Add your App Database here



}
