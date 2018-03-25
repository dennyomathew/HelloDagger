package com.dennymathew.hellodagger.helloworld.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dennymathew.hellodagger.R;
import com.dennymathew.hellodagger.helloworld.viewmodel.HelloWorldViewModel;
import com.dennymathew.hellodagger.helloworld.viewmodel.HelloWorldViewModelFactory;
import com.dennymathew.hellodagger.shared.Response;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class HelloWorldActivity extends AppCompatActivity {

    private HelloWorldViewModel viewModel;

    @BindView(R.id.greeting_tv)
    TextView greetingTextView;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    @Inject
    HelloWorldViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HelloWorldViewModel.class);

        viewModel.response().observe(this, this::processResponse);
    }

    @OnClick(R.id.load_greeting_button)
    void loadGreeting() {
        viewModel.loadHelloWorldGreeting();
    }

    private void processResponse(Response response) {
        switch (response.status) {
            case ERROR:
                renderErrorMsg(response.error);
                break;
            case LOADING:
                renderProgressBar();
                break;
            case SUCCESS:
                renderDataState(response.data);
                break;

        }
    }

    private void renderProgressBar() {
        progressBar.setVisibility(VISIBLE);
        greetingTextView.setVisibility(GONE);
    }

    private void renderErrorMsg(Throwable error) {
        greetingTextView.setVisibility(GONE);
        progressBar.setVisibility(GONE);
        Toast.makeText(this, R.string.greeting_error, Toast.LENGTH_SHORT).show();
    }

    private void renderDataState(String data) {
        greetingTextView.setVisibility(VISIBLE);
        progressBar.setVisibility(GONE);
        greetingTextView.setText(data);
    }
}
