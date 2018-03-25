package com.dennymathew.hellodagger.helloworld;

import com.dennymathew.hellodagger.helloworld.domain.HelloWorldUseCase;
import com.dennymathew.hellodagger.helloworld.model.HelloWorldRepository;
import com.dennymathew.hellodagger.helloworld.viewmodel.HelloWorldViewModelFactory;
import com.dennymathew.hellodagger.rx.SchedulersFacade;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Denny on 3/22/2018.
 */

@Module
public class HelloWorldModule {

    @Provides
    HelloWorldRepository providesHelloWorldRepository() {
        return new HelloWorldRepository();
    }

    @Provides
    HelloWorldViewModelFactory providesHelloWorldViewModelFactory(HelloWorldUseCase helloWorldUseCase,
                                                                  SchedulersFacade schedulersFacade) {
        return new HelloWorldViewModelFactory(helloWorldUseCase, schedulersFacade);
    }
}
