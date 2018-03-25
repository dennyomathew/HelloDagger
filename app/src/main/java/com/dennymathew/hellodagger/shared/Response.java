package com.dennymathew.hellodagger.shared;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.dennymathew.hellodagger.shared.Status.ERROR;
import static com.dennymathew.hellodagger.shared.Status.LOADING;
import static com.dennymathew.hellodagger.shared.Status.SUCCESS;

/**
 * Created by Denny on 3/23/2018.
 */

public class Response{

    public Status status;

    @Nullable
    public String data;

    @Nullable
    public Throwable error;

    private Response(Status status, @Nullable String data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static Response loading() {
        return new Response(LOADING, null, null);
    }

    public static Response success(@NonNull String data) {
        return new Response(SUCCESS, data, null);
    }

    public static Response error(@NonNull Throwable error) {
        return new Response(ERROR, null, error);
    }
}