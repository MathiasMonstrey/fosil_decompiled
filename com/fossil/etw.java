package com.fossil;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class etw {
    public static final etw dTD = new C35471();
    private boolean dTE;
    private long dTF;
    private long dTG;

    static class C35471 extends etw {
        C35471() {
        }

        public etw mo3063f(long j, TimeUnit timeUnit) {
            return this;
        }

        public etw bk(long j) {
            return this;
        }

        public void aHA() throws IOException {
        }
    }

    public etw mo3063f(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.dTG = timeUnit.toNanos(j);
            return this;
        }
    }

    public long aHv() {
        return this.dTG;
    }

    public boolean aHw() {
        return this.dTE;
    }

    public long aHx() {
        if (this.dTE) {
            return this.dTF;
        }
        throw new IllegalStateException("No deadline");
    }

    public etw bk(long j) {
        this.dTE = true;
        this.dTF = j;
        return this;
    }

    public etw aHy() {
        this.dTG = 0;
        return this;
    }

    public etw aHz() {
        this.dTE = false;
        return this;
    }

    public void aHA() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.dTE && this.dTF - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
