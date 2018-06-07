package com.fossil;

import android.content.Context;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class bnt extends bqi {
    private long byf;
    private String byg;

    bnt(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
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
        Calendar instance = Calendar.getInstance();
        this.byf = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String valueOf = String.valueOf(locale.getLanguage().toLowerCase(Locale.ENGLISH));
        String valueOf2 = String.valueOf(locale.getCountry().toLowerCase(Locale.ENGLISH));
        this.byg = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("-").append(valueOf2).toString();
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

    public final long QV() {
        RA();
        return this.byf;
    }

    public final String QW() {
        RA();
        return this.byg;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }
}
