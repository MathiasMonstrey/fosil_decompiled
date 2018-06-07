package com.fossil;

import java.lang.Thread.UncaughtExceptionHandler;

final class bph implements UncaughtExceptionHandler {
    private final String bAW;
    private /* synthetic */ bpg bAX;

    public bph(bpg com_fossil_bpg, String str) {
        this.bAX = com_fossil_bpg;
        awa.bO(str);
        this.bAW = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.bAX.Pf().Rc().m5439d(this.bAW, th);
    }
}
