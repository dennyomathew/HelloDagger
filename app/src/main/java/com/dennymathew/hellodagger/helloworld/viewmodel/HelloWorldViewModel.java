package com.dennymathew.hellodagger.helloworld.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.dennymathew.hellodagger.LoadGreetingUseCase;
import com.dennymathew.hellodagger.helloworld.domain.HelloWorldUseCase;
import com.dennymathew.hellodagger.rx.SchedulersFacade;
import com.dennymathew.hellodagger.shared.Response;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Denny on 3/23/2018.
 */

public class HelloWorldViewModel extends ViewModel {

    private HelloWorldUseCase helloWorldUseCase;

    private SchedulersFacade schedulersFacade;

    private final CompositeDisposable disposable = new CompositeDisposable();

    private final MutableLiveData<Response> response = new MutableLiveData<>();

    //We require a public default constructor
    public HelloWorldViewModel() {}

    HelloWorldViewModel(HelloWorldUseCase helloWorldUseCase, SchedulersFacade schedulersFacade) {
        this.helloWorldUseCase = helloWorldUseCase;
        this.schedulersFacade = schedulersFacade;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

    public void loadHelloWorldGreeting() {
        loadGreeting(helloWorldUseCase);
    }

    public MutableLiveData<Response> response() {
        return response;
    }

    private void loadGreeting(LoadGreetingUseCase loadGreetingUseCase) {
        disposable.add(loadGreetingUseCase.execute()
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .doOnSubscribe(__ -> response.setValue(Response.loading()))
                .subscribe(
                        greeting -> response.setValue(Response.success(greeting)),
                        throwable -> response.setValue(Response.error(throwable))
                )
        );
    }
}
