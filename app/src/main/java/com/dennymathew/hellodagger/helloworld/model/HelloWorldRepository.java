package com.dennymathew.hellodagger.helloworld.model;

import io.reactivex.Single;

/**
 * Created by Denny on 3/22/2018.
 */

public class HelloWorldRepository {

    public Single<String> getGreeting() {
        return Single.just("Hello Word!");
    }
}
