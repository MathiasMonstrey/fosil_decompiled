package com.fossil;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.fossil.ats.C1879a;
import com.fossil.ats.C1887c;
import com.fossil.ats.C1888f;
import com.fossil.atv.C1897a;

public class atu<O extends C1879a> {
    private final Account beU;
    private final ats<O> bfV;
    private final O bfW = null;
    private final bdn<O> bfX;
    private final Looper bfY;
    private final atv bfZ;
    private final bgz bga;
    protected final bfs bgb;
    private final Context mContext;
    private final int mId;

    protected atu(Context context, ats<O> com_fossil_ats_O, Looper looper) {
        awa.m4640p(context, "Null context is not permitted.");
        awa.m4640p(com_fossil_ats_O, "Api must not be null.");
        awa.m4640p(looper, "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.bfV = com_fossil_ats_O;
        this.bfY = looper;
        this.bfX = bdn.m4899e(com_fossil_ats_O);
        this.bfZ = new bga(this);
        this.bgb = bfs.aM(this.mContext);
        this.mId = this.bgb.NS();
        this.bga = new bdm();
        this.beU = null;
    }

    private final <A extends C1887c, T extends bds<? extends atz, A>> T m4458a(int i, T t) {
        t.Ni();
        this.bgb.m5091a(this, i, t);
        return t;
    }

    public final ats<O> KA() {
        return this.bfV;
    }

    public final bdn<O> KB() {
        return this.bfX;
    }

    public C1888f mo1299a(Looper looper, bfu<O> com_fossil_bfu_O) {
        return this.bfV.Kw().mo1176a(this.mContext, looper, new C1897a(this.mContext).m4464a(this.beU).KH(), this.bfW, com_fossil_bfu_O, com_fossil_bfu_O);
    }

    public final <A extends C1887c, T extends bds<? extends atz, A>> T m4460a(T t) {
        return m4458a(0, (bds) t);
    }

    public bgw mo1300a(Context context, Handler handler) {
        return new bgw(context, handler);
    }

    public final <A extends C1887c, T extends bds<? extends atz, A>> T m4462b(T t) {
        return m4458a(1, (bds) t);
    }

    public final Context getApplicationContext() {
        return this.mContext;
    }

    public final int getInstanceId() {
        return this.mId;
    }

    public final Looper getLooper() {
        return this.bfY;
    }
}
