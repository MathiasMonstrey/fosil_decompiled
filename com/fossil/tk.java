package com.fossil;

import java.io.Closeable;

public class tk implements Closeable {
    private tl axs;
    private Runnable axt;
    private boolean closed;
    private final Object lock;

    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.axs.m13677a(this);
            this.axs = null;
            this.axt = null;
        }
    }
}
