package com.fossil;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class enl {
    public static ExecutorService mk(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(mm(str));
        m10959a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService ml(String str) {
        Object newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(mm(str));
        m10959a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static final ThreadFactory mm(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1);
        return new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(new enh(this) {
                    final /* synthetic */ C34751 dNP;

                    public void yH() {
                        runnable.run();
                    }
                });
                newThread.setName(str + atomicLong.getAndIncrement());
                return newThread;
            }
        };
    }

    private static final void m10959a(String str, ExecutorService executorService) {
        m10960a(str, executorService, 2, TimeUnit.SECONDS);
    }

    public static final void m10960a(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        final String str2 = str;
        final ExecutorService executorService2 = executorService;
        final long j2 = j;
        final TimeUnit timeUnit2 = timeUnit;
        Runtime.getRuntime().addShutdownHook(new Thread(new enh() {
            public void yH() {
                try {
                    emm.aEU().mo2950d("Fabric", "Executing shutdown hook for " + str2);
                    executorService2.shutdown();
                    if (!executorService2.awaitTermination(j2, timeUnit2)) {
                        emm.aEU().mo2950d("Fabric", str2 + " did not shut down in the" + " allocated time. Requesting immediate shutdown.");
                        executorService2.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    emm.aEU().mo2950d("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{str2}));
                    executorService2.shutdownNow();
                }
            }
        }, "Crashlytics Shutdown Hook for " + str));
    }
}
