package com.fossil;

import android.os.Process;

public abstract class enh implements Runnable {
    protected abstract void yH();

    public final void run() {
        Process.setThreadPriority(10);
        yH();
    }
}
