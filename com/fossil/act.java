package com.fossil;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class act {
    private final ExecutorService aIj;

    public act(ExecutorService executorService) {
        this.aIj = executorService;
    }

    <T> T m2974a(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.aIj.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.aIj.submit(callable).get();
        } catch (RejectedExecutionException e) {
            emm.aEU().mo2950d("Fabric", "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Throwable e2) {
            emm.aEU().mo2953g("Fabric", "Failed to execute task.", e2);
            return null;
        }
    }

    Future<?> m2976e(final Runnable runnable) {
        try {
            return this.aIj.submit(new Runnable(this) {
                final /* synthetic */ act aIU;

                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable e) {
                        emm.aEU().mo2953g("Fabric", "Failed to execute task.", e);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            emm.aEU().mo2950d("Fabric", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    <T> Future<T> m2975b(final Callable<T> callable) {
        try {
            return this.aIj.submit(new Callable<T>(this) {
                final /* synthetic */ act aIU;

                public T call() throws Exception {
                    try {
                        return callable.call();
                    } catch (Throwable e) {
                        emm.aEU().mo2953g("Fabric", "Failed to execute task.", e);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            emm.aEU().mo2950d("Fabric", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
