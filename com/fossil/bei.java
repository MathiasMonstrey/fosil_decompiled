package com.fossil;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.fossil.ats.C1879a;
import com.fossil.ats.C1888f;
import com.fossil.ats.C1890b;

public final class bei<O extends C1879a> extends atu<O> {
    private final C1890b<? extends btu, btv> bgq;
    private final awy biS;
    private final C1888f bsj;
    private final bec bsk;

    public bei(Context context, ats<O> com_fossil_ats_O, Looper looper, C1888f c1888f, bec com_fossil_bec, awy com_fossil_awy, C1890b<? extends btu, btv> c1890b) {
        super(context, com_fossil_ats_O, looper);
        this.bsj = c1888f;
        this.bsk = com_fossil_bec;
        this.biS = com_fossil_awy;
        this.bgq = c1890b;
        this.bgb.m5090a((atu) this);
    }

    public final C1888f Nq() {
        return this.bsj;
    }

    public final C1888f mo1299a(Looper looper, bfu<O> com_fossil_bfu_O) {
        this.bsk.m4921a((bed) com_fossil_bfu_O);
        return this.bsj;
    }

    public final bgw mo1300a(Context context, Handler handler) {
        return new bgw(context, handler, this.biS, this.bgq);
    }
}
