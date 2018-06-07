package com.fossil;

import com.fossil.cay.C1982c;
import java.util.List;

final class ccd implements Runnable {
    private /* synthetic */ C1982c bLp;
    private /* synthetic */ List bLs;

    ccd(C1982c c1982c, List list) {
        this.bLp = c1982c;
        this.bLs = list;
    }

    public final void run() {
        this.bLp.bKK.m5903E(this.bLs);
    }
}
