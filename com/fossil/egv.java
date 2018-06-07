package com.fossil;

import com.ua.sdk.UaException;
import java.util.concurrent.Future;

public abstract class egv<T> implements eck {
    Future<?> aBV = null;
    boolean done = false;
    boolean duH = false;

    abstract void mo2866a(T t, UaException uaException);

    public synchronized void setFuture(Future<?> future) {
        this.aBV = future;
        if (this.duH) {
            future.cancel(true);
        }
    }

    public synchronized void m10739b(T t, UaException uaException) {
        if (!this.duH) {
            mo2866a(t, uaException);
            this.done = true;
        }
    }
}
