package com.fossil;

import java.util.concurrent.atomic.AtomicReference;

final class bqu implements Runnable {
    private /* synthetic */ bqk bCm;
    private /* synthetic */ AtomicReference bCo;
    private /* synthetic */ boolean bCp;

    bqu(bqk com_fossil_bqk, AtomicReference atomicReference, boolean z) {
        this.bCm = com_fossil_bqk;
        this.bCo = atomicReference;
        this.bCp = z;
    }

    public final void run() {
        this.bCm.OV().m5563a(this.bCo, this.bCp);
    }
}
