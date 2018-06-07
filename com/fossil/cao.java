package com.fossil;

import java.util.concurrent.Callable;

final class cao implements Runnable {
    private /* synthetic */ can bKB;
    private /* synthetic */ Callable bKC;

    cao(can com_fossil_can, Callable callable) {
        this.bKB = com_fossil_can;
        this.bKC = callable;
    }

    public final void run() {
        try {
            this.bKB.aV(this.bKC.call());
        } catch (Exception e) {
            this.bKB.m5873h(e);
        }
    }
}
