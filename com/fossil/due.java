package com.fossil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class due {
    private static ExecutorService dtG = Executors.newSingleThreadExecutor();
    private static long dtH = 5;

    public static synchronized void execute(Runnable runnable) {
        synchronized (due.class) {
            if (dtG.isShutdown()) {
                dtG = Executors.newSingleThreadExecutor();
            }
            dtG.execute(runnable);
        }
    }
}
