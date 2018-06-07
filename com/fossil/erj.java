package com.fossil;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

final class erj implements eqn, Callable<Void> {
    static final FutureTask<Void> dRV = new FutureTask(eqz.dRh, null);
    final AtomicReference<Future<?>> dRT = new AtomicReference();
    final AtomicReference<Future<?>> dRU = new AtomicReference();
    final ExecutorService dwX;
    Thread runner;
    final Runnable task;

    erj(Runnable runnable, ExecutorService executorService) {
        this.task = runnable;
        this.dwX = executorService;
    }

    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.task.run();
            m11092b(this.dwX.submit(this));
        } catch (Throwable th) {
            this.runner = null;
        }
        this.runner = null;
        return null;
    }

    public void dispose() {
        boolean z = true;
        Future future = (Future) this.dRU.getAndSet(dRV);
        if (!(future == null || future == dRV)) {
            future.cancel(this.runner != Thread.currentThread());
        }
        future = (Future) this.dRT.getAndSet(dRV);
        if (future != null && future != dRV) {
            if (this.runner == Thread.currentThread()) {
                z = false;
            }
            future.cancel(z);
        }
    }

    void m11091a(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) this.dRU.get();
            if (future2 == dRV) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.dRU.compareAndSet(future2, future));
    }

    void m11092b(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) this.dRT.get();
            if (future2 == dRV) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.dRT.compareAndSet(future2, future));
    }
}
