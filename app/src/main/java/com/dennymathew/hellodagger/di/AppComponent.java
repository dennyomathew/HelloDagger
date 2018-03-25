package com.dennymathew.hellodagger.di;

import com.dennymathew.hellodagger.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by Denny on 3/22/2018.
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                BuildersModule.class
        }
)
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);
        AppComponent build();

    }

    void inject(App app);
}
