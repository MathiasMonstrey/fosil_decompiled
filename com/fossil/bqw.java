package com.fossil;

import java.util.concurrent.atomic.AtomicReference;

final class bqw implements Runnable {
    private /* synthetic */ bqk bCm;
    private /* synthetic */ AtomicReference bCo;

    bqw(bqk com_fossil_bqk, AtomicReference atomicReference) {
        this.bCm = com_fossil_bqk;
        this.bCo = atomicReference;
    }

    public final void run() {
        this.bCm.OV().m5560a(this.bCo);
    }
}
