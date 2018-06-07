package com.fossil;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class eog<T> implements eon<T> {
    protected final Context context;
    protected final eoi<T> dOT;
    final ScheduledExecutorService dOU;
    final AtomicReference<ScheduledFuture<?>> dOV;
    volatile int dOW = -1;

    public eog(Context context, ScheduledExecutorService scheduledExecutorService, eoi<T> com_fossil_eoi_T) {
        this.context = context;
        this.dOU = scheduledExecutorService;
        this.dOT = com_fossil_eoi_T;
        this.dOV = new AtomicReference();
    }

    public void aFT() {
        if ((this.dOW != -1 ? 1 : null) != null) {
            m2892h((long) this.dOW, (long) this.dOW);
        }
    }

    public void aFP() {
        aFU();
    }

    public void aFR() {
        if (this.dOV.get() != null) {
            CommonUtils.Z(this.context, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.dOV.get()).cancel(false);
            this.dOV.set(null);
        }
    }

    public void aFQ() {
        this.dOT.aFW();
    }

    public void bj(T t) {
        CommonUtils.Z(this.context, t.toString());
        try {
            this.dOT.di(t);
        } catch (Throwable e) {
            CommonUtils.a(this.context, "Failed to write event.", e);
        }
        aFT();
    }

    public boolean aFS() {
        try {
            return this.dOT.aFS();
        } catch (Throwable e) {
            CommonUtils.a(this.context, "Failed to roll file over.", e);
            return false;
        }
    }

    protected void ph(int i) {
        this.dOW = i;
        m2892h(0, (long) this.dOW);
    }

    void m2892h(long j, long j2) {
        if ((this.dOV.get() == null ? 1 : null) != null) {
            Runnable com_fossil_eos = new eos(this.context, this);
            CommonUtils.Z(this.context, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.dOV.set(this.dOU.scheduleAtFixedRate(com_fossil_eos, j, j2, TimeUnit.SECONDS));
            } catch (Throwable e) {
                CommonUtils.a(this.context, "Failed to schedule time based file roll over", e);
            }
        }
    }

    void aFU() {
        int size;
        eop xm = xm();
        if (xm == null) {
            CommonUtils.Z(this.context, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.Z(this.context, "Sending all files");
        List aFV = this.dOT.aFV();
        int i = 0;
        while (aFV.size() > 0) {
            CommonUtils.Z(this.context, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(aFV.size())}));
            boolean u = xm.mo788u(aFV);
            if (u) {
                size = aFV.size() + i;
                try {
                    this.dOT.aG(aFV);
                    i = size;
                } catch (Exception e) {
                    Throwable e2 = e;
                }
            }
            if (!u) {
                break;
            }
            try {
                aFV = this.dOT.aFV();
            } catch (Throwable e3) {
                Throwable th = e3;
                size = i;
                e2 = th;
            }
        }
        if (i == 0) {
            this.dOT.aFX();
        }
        CommonUtils.a(this.context, "Failed to send batch of analytics files to server: " + e2.getMessage(), e2);
        i = size;
        if (i == 0) {
            this.dOT.aFX();
        }
    }
}
