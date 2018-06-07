package com.misfit.frameworks.buttonservice.core;

import android.os.AsyncTask;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class SerialExecutor implements Executor {
    Runnable mActive;
    final ArrayDeque<Runnable> mTasks = new ArrayDeque();

    public synchronized void execute(final Runnable runnable) {
        this.mTasks.offer(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } finally {
                    SerialExecutor.this.scheduleNext();
                }
            }
        });
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    protected synchronized void scheduleNext() {
        Runnable runnable = (Runnable) this.mTasks.poll();
        this.mActive = runnable;
        if (runnable != null) {
            AsyncTask.SERIAL_EXECUTOR.execute(this.mActive);
        }
    }
}
