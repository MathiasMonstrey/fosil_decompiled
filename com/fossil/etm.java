package com.fossil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class etm extends etw {
    private etw dTl;

    public etm(etw com_fossil_etw) {
        if (com_fossil_etw == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.dTl = com_fossil_etw;
    }

    public final etw aHu() {
        return this.dTl;
    }

    public final etm m11166a(etw com_fossil_etw) {
        if (com_fossil_etw == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.dTl = com_fossil_etw;
        return this;
    }

    public etw mo3063f(long j, TimeUnit timeUnit) {
        return this.dTl.mo3063f(j, timeUnit);
    }

    public long aHv() {
        return this.dTl.aHv();
    }

    public boolean aHw() {
        return this.dTl.aHw();
    }

    public long aHx() {
        return this.dTl.aHx();
    }

    public etw bk(long j) {
        return this.dTl.bk(j);
    }

    public etw aHy() {
        return this.dTl.aHy();
    }

    public etw aHz() {
        return this.dTl.aHz();
    }

    public void aHA() throws IOException {
        this.dTl.aHA();
    }
}
