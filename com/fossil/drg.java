package com.fossil;

import com.fossil.ci.C2087a;
import java.util.concurrent.atomic.AtomicInteger;

public final class drg implements ci {
    private final AtomicInteger counter = new AtomicInteger(0);
    private final String dfk;
    private volatile C2087a dfl;

    public drg(String str) {
        this.dfk = str;
    }

    public boolean hw() {
        return this.counter.get() == 0;
    }

    public void increment() {
        this.counter.getAndIncrement();
    }

    public void decrement() {
        int decrementAndGet = this.counter.decrementAndGet();
        if (decrementAndGet == 0 && this.dfl != null) {
            this.dfl.hx();
        }
        if (decrementAndGet < 0) {
            throw new IllegalArgumentException("Counter has been corrupted!");
        }
    }
}
