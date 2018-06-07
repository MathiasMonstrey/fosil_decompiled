package com.fossil;

import android.content.ComponentName;

final class brr implements Runnable {
    private /* synthetic */ brp bDe;
    private /* synthetic */ ComponentName bDf;

    brr(brp com_fossil_brp, ComponentName componentName) {
        this.bDe = com_fossil_brp;
        this.bDf = componentName;
    }

    public final void run() {
        this.bDe.bCU.onServiceDisconnected(this.bDf);
    }
}
