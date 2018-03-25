package com.dennymathew.hellodagger.di;

import com.dennymathew.hellodagger.helloworld.HelloWorldModule;
import com.dennymathew.hellodagger.helloworld.view.HelloWorldActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Denny on 3/24/2018.
 */

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = HelloWorldModule.class)
    abstract HelloWorldActivity bindLobbyActivity();
}
