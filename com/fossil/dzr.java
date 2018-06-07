package com.fossil;

import android.content.Context;

final class dzr implements Runnable {
    final /* synthetic */ int f1485b;
    final /* synthetic */ Context baD;

    dzr(Context context, int i) {
        this.baD = context;
        this.f1485b = i;
    }

    public final void run() {
        try {
            dzg.dw(this.baD);
            ead.dy(this.baD).m10410a(this.f1485b);
        } catch (Throwable th) {
            dzg.dBR.m10419g(th);
            dzg.m10360a(this.baD, th);
        }
    }
}
