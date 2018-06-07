package com.fossil;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class bbs implements ThreadFactory {
    private final AtomicInteger bpG = new AtomicInteger(1);

    bbs(bbo com_fossil_bbo) {
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "gcm-task#" + this.bpG.getAndIncrement());
        thread.setPriority(4);
        return thread;
    }
}
