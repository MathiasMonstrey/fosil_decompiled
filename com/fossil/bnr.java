package com.fossil;

import android.os.Handler;

abstract class bnr {
    private static volatile Handler byb;
    private final Runnable bvP = new bns(this);
    private volatile long byc;
    private boolean byd = true;
    private final bpk zzboe;

    bnr(bpk com_fossil_bpk) {
        awa.bO(com_fossil_bpk);
        this.zzboe = com_fossil_bpk;
    }

    private final Handler getHandler() {
        if (byb != null) {
            return byb;
        }
        Handler handler;
        synchronized (bnr.class) {
            if (byb == null) {
                byb = new Handler(this.zzboe.getContext().getMainLooper());
            }
            handler = byb;
        }
        return handler;
    }

    public final boolean QU() {
        return this.byc != 0;
    }

    public final void ak(long j) {
        cancel();
        if (j >= 0) {
            this.byc = this.zzboe.OX().currentTimeMillis();
            if (!getHandler().postDelayed(this.bvP, j)) {
                this.zzboe.Pf().Rc().m5439d("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final void cancel() {
        this.byc = 0;
        getHandler().removeCallbacks(this.bvP);
    }

    public abstract void run();
}
