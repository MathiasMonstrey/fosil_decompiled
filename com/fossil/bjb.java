package com.fossil;

import android.os.Process;

final class bjb implements Runnable {
    private final int Ll;
    private final Runnable bvP;

    public bjb(Runnable runnable, int i) {
        this.bvP = runnable;
        this.Ll = i;
    }

    public final void run() {
        Process.setThreadPriority(this.Ll);
        this.bvP.run();
    }
}
