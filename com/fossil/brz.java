package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public final class brz extends bqi {
    private long bDm = super.OX().elapsedRealtime();
    private final bnr bDn = new bsa(this, this.zzboe);
    private final bnr bDo = new bsb(this, this.zzboe);
    private Handler mHandler;

    brz(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
    }

    private final void Sc() {
        synchronized (this) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
        }
    }

    private final void Se() {
        super.OP();
        bi(false);
        super.OQ().m5317S(super.OX().elapsedRealtime());
    }

    private final void ao(long j) {
        super.OP();
        Sc();
        this.bDn.cancel();
        this.bDo.cancel();
        super.Pf().Ri().m5439d("Activity resumed, time", Long.valueOf(j));
        this.bDm = j;
        if (super.OX().currentTimeMillis() - super.Pg().bAl.get() > super.Pg().bAn.get()) {
            super.Pg().bAm.set(true);
            super.Pg().bAo.set(0);
        }
        if (super.Pg().bAm.get()) {
            this.bDn.ak(Math.max(0, super.Pg().bAk.get() - super.Pg().bAo.get()));
        } else {
            this.bDo.ak(Math.max(0, 3600000 - super.Pg().bAo.get()));
        }
    }

    private final void ap(long j) {
        super.OP();
        Sc();
        this.bDn.cancel();
        this.bDo.cancel();
        super.Pf().Ri().m5439d("Activity paused, time", Long.valueOf(j));
        if (this.bDm != 0) {
            super.Pg().bAo.set(super.Pg().bAo.get() + (j - this.bDm));
        }
    }

    public final /* bridge */ /* synthetic */ void OM() {
        super.OM();
    }

    public final /* bridge */ /* synthetic */ void ON() {
        super.ON();
    }

    public final /* bridge */ /* synthetic */ void OO() {
        super.OO();
    }

    public final /* bridge */ /* synthetic */ void OP() {
        super.OP();
    }

    public final /* bridge */ /* synthetic */ bnc OQ() {
        return super.OQ();
    }

    public final /* bridge */ /* synthetic */ bnj OR() {
        return super.OR();
    }

    public final /* bridge */ /* synthetic */ bqk OS() {
        return super.OS();
    }

    public final /* bridge */ /* synthetic */ bog OT() {
        return super.OT();
    }

    public final /* bridge */ /* synthetic */ bnt OU() {
        return super.OU();
    }

    public final /* bridge */ /* synthetic */ brc OV() {
        return super.OV();
    }

    public final /* bridge */ /* synthetic */ bqy OW() {
        return super.OW();
    }

    public final /* bridge */ /* synthetic */ axm OX() {
        return super.OX();
    }

    public final /* bridge */ /* synthetic */ boh OY() {
        return super.OY();
    }

    public final /* bridge */ /* synthetic */ bnn OZ() {
        return super.OZ();
    }

    protected final void PH() {
    }

    public final /* bridge */ /* synthetic */ boj Pa() {
        return super.Pa();
    }

    public final /* bridge */ /* synthetic */ bsk Pb() {
        return super.Pb();
    }

    public final /* bridge */ /* synthetic */ bpf Pc() {
        return super.Pc();
    }

    public final /* bridge */ /* synthetic */ brz Pd() {
        return super.Pd();
    }

    public final /* bridge */ /* synthetic */ bpg Pe() {
        return super.Pe();
    }

    public final /* bridge */ /* synthetic */ bol Pf() {
        return super.Pf();
    }

    public final /* bridge */ /* synthetic */ bow Pg() {
        return super.Pg();
    }

    public final /* bridge */ /* synthetic */ bnm Ph() {
        return super.Ph();
    }

    protected final void Sd() {
        super.OP();
        super.Pf().Ri().m5439d("Session started, time", Long.valueOf(super.OX().elapsedRealtime()));
        super.Pg().bAm.set(false);
        super.OS().m5539a("auto", "_s", new Bundle());
        super.Pg().bAn.set(super.OX().currentTimeMillis());
    }

    public final boolean bi(boolean z) {
        super.OP();
        RA();
        long elapsedRealtime = super.OX().elapsedRealtime();
        super.Pg().bAn.set(super.OX().currentTimeMillis());
        long j = elapsedRealtime - this.bDm;
        if (z || j >= 1000) {
            super.Pg().bAo.set(j);
            super.Pf().Ri().m5439d("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            bqy.m5546a(super.OW().RT(), bundle);
            super.OS().m5539a("auto", "_e", bundle);
            this.bDm = elapsedRealtime;
            this.bDo.cancel();
            this.bDo.ak(Math.max(0, 3600000 - super.Pg().bAo.get()));
            return true;
        }
        super.Pf().Ri().m5439d("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        return false;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }
}
