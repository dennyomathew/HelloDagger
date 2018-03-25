package com.dennymathew.hellodagger;

import io.reactivex.Single;

/**
 * Created by Denny on 3/22/2018.
 */

public interface LoadGreetingUseCase {

    Single<String> execute();

}
