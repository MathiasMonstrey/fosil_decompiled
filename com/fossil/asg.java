package com.fossil;

import android.content.Context;
import android.util.Log;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class asg extends gk<Void> implements bgv {
    private Semaphore bfq = new Semaphore(0);
    private Set<atv> bfr;

    public asg(Context context, Set<atv> set) {
        super(context);
        this.bfr = set;
    }

    private final Void Kf() {
        int i = 0;
        for (atv a : this.bfr) {
            i = a.mo1332a((bgv) this) ? i + 1 : i;
        }
        try {
            this.bfq.tryAcquire(i, 5, TimeUnit.SECONDS);
        } catch (Throwable e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    public final void Kg() {
        this.bfq.release();
    }

    public final /* synthetic */ Object loadInBackground() {
        return Kf();
    }

    protected final void onStartLoading() {
        this.bfq.drainPermits();
        forceLoad();
    }
}
