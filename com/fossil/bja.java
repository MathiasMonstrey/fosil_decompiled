package com.fossil;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class bja implements ThreadFactory {
    private final int Ll;
    private final String bvM;
    private final AtomicInteger bvN;
    private final ThreadFactory bvO;

    public bja(String str) {
        this(str, 0);
    }

    private bja(String str, int i) {
        this.bvN = new AtomicInteger();
        this.bvO = Executors.defaultThreadFactory();
        this.bvM = (String) awa.m4640p(str, "Name must not be null");
        this.Ll = 0;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.bvO.newThread(new bjb(runnable, 0));
        String str = this.bvM;
        newThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.bvN.getAndIncrement()).append("]").toString());
        return newThread;
    }
}
