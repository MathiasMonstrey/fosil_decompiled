package com.fossil;

import io.fabric.sdk.android.services.concurrency.DependencyPriorityBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class eny extends ThreadPoolExecutor {
    private static final int axg = Runtime.getRuntime().availableProcessors();
    private static final int axh = (axg + 1);
    private static final int cob = ((axg * 2) + 1);

    public static final class C3483a implements ThreadFactory {
        private final int dOO;

        public C3483a(int i) {
            this.dOO = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.dOO);
            thread.setName("Queue");
            return thread;
        }
    }

    public /* synthetic */ BlockingQueue getQueue() {
        return aFL();
    }

    <T extends Runnable & enr & enz & enw> eny(int i, int i2, long j, TimeUnit timeUnit, DependencyPriorityBlockingQueue<T> dependencyPriorityBlockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, dependencyPriorityBlockingQueue, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & enr & enz & enw> eny cr(int i, int i2) {
        return new eny(i, i2, 1, TimeUnit.SECONDS, new DependencyPriorityBlockingQueue(), new C3483a(10));
    }

    public static eny aFK() {
        return cr(axh, cob);
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new env(runnable, t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new env(callable);
    }

    public void execute(Runnable runnable) {
        if (enx.dh(runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        enz com_fossil_enz = (enz) runnable;
        com_fossil_enz.dJ(true);
        com_fossil_enz.mo817h(th);
        aFL().recycleBlockedQueue();
        super.afterExecute(runnable, th);
    }

    public DependencyPriorityBlockingQueue aFL() {
        return (DependencyPriorityBlockingQueue) super.getQueue();
    }
}
