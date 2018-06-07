package com.fossil;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class tf {
    private static final tf axe = new tf();
    private static final int axg = Runtime.getRuntime().availableProcessors();
    static final int axh = (axg + 1);
    static final int axi = ((axg * 2) + 1);
    private final Executor axf = new C4107a();

    static class C4107a implements Executor {
        private C4107a() {
        }

        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private tf() {
    }

    public static ExecutorService newCachedThreadPool() {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(axh, axi, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        m13674a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    @SuppressLint({"NewApi"})
    public static void m13674a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }

    public static Executor sV() {
        return axe.axf;
    }
}
