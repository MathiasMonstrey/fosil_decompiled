package com.fossil;

import java.util.concurrent.CountDownLatch;

public final class dwi {
    private final CountDownLatch aIS = new CountDownLatch(1);
    private long dyP = -1;
    private long dyQ = -1;

    dwi() {
    }

    void send() {
        if (this.dyP != -1) {
            throw new IllegalStateException();
        }
        this.dyP = System.nanoTime();
    }

    void aAA() {
        if (this.dyQ != -1 || this.dyP == -1) {
            throw new IllegalStateException();
        }
        this.dyQ = System.nanoTime();
        this.aIS.countDown();
    }

    void cancel() {
        if (this.dyQ != -1 || this.dyP == -1) {
            throw new IllegalStateException();
        }
        this.dyQ = this.dyP - 1;
        this.aIS.countDown();
    }
}
