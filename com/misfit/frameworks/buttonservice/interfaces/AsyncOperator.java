package com.misfit.frameworks.buttonservice.interfaces;

public interface AsyncOperator<P, R> {
    Cancellable request(P p, Callback<R> callback);
}
