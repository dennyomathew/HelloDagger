package com.dennymathew.hellodagger.helloworld.domain;

import com.dennymathew.hellodagger.LoadGreetingUseCase;
import com.dennymathew.hellodagger.helloworld.model.HelloWorldRepository;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Denny on 3/22/2018.
 */

public class HelloWorldUseCase implements LoadGreetingUseCase{

    private final HelloWorldRepository helloWorldRepository;

    @Inject
    public HelloWorldUseCase(HelloWorldRepository helloWorldRepository) {
        this.helloWorldRepository = helloWorldRepository;
    }

    @Override
    public Single<String> execute() {
        return helloWorldRepository.getGreeting();
    }
}
