package com.fossil;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public final class apn<V> extends FutureTask<V> {
    private final WeakReference<Runnable> baZ;
    private final WeakReference<Callable<V>> baz = new WeakReference(null);

    public apn(Runnable runnable, V v) {
        super(runnable, v);
        this.baZ = new WeakReference(runnable);
    }

    public final Runnable IX() {
        return (Runnable) this.baZ.get();
    }
}
