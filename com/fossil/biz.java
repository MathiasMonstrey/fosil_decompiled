package com.fossil;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class biz implements Executor {
    private final Handler mHandler;

    public biz(Looper looper) {
        this.mHandler = new Handler(looper);
    }

    public final void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }
}
