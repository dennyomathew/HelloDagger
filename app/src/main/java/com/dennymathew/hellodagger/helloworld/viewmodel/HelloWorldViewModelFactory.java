package com.dennymathew.hellodagger.helloworld.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.dennymathew.hellodagger.helloworld.domain.HelloWorldUseCase;
import com.dennymathew.hellodagger.rx.SchedulersFacade;

/**
 * Created by Denny on 3/23/2018.
 */

public class HelloWorldViewModelFactory implements ViewModelProvider.Factory {

    private final HelloWorldUseCase helloWorldUseCase;

    private final SchedulersFacade schedulersFacade;

    public HelloWorldViewModelFactory(HelloWorldUseCase helloWorldUseCase, SchedulersFacade schedulersFacade) {
        this.helloWorldUseCase = helloWorldUseCase;
        this.schedulersFacade = schedulersFacade;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(HelloWorldViewModel.class)) {
            return (T) new HelloWorldViewModel(helloWorldUseCase, schedulersFacade);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
