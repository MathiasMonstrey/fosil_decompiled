package com.fossil;

import com.fossil.cay.C1982c;
import com.google.android.gms.common.data.DataHolder;

final class cbz implements Runnable {
    private /* synthetic */ DataHolder bLo;
    private /* synthetic */ C1982c bLp;

    cbz(C1982c c1982c, DataHolder dataHolder) {
        this.bLp = c1982c;
        this.bLo = dataHolder;
    }

    public final void run() {
        cat com_fossil_cat = new cat(this.bLo);
        try {
            this.bLp.bKK.m5907a(com_fossil_cat);
        } finally {
            com_fossil_cat.release();
        }
    }
}
