package com.fossil;

import java.util.concurrent.ThreadFactory;

public final class aqr implements ThreadFactory {
    private final int f1452b = 1;
    private final ThreadGroup bcI;

    public aqr(String str) {
        this.bcI = new ThreadGroup(str);
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.bcI, runnable);
        thread.setName(this.bcI.getName() + ":" + thread.getId());
        thread.setPriority(this.f1452b);
        return thread;
    }
}
