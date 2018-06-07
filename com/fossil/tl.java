package com.fossil;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

public class tl implements Closeable {
    private final List<tk> axu;
    private ScheduledFuture<?> axv;
    private boolean axw;
    private boolean closed;
    private final Object lock;

    public boolean tb() {
        boolean z;
        synchronized (this.lock) {
            tc();
            z = this.axw;
        }
        return z;
    }

    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            td();
            for (tk close : this.axu) {
                close.close();
            }
            this.axu.clear();
            this.closed = true;
        }
    }

    void m13677a(tk tkVar) {
        synchronized (this.lock) {
            tc();
            this.axu.remove(tkVar);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(tb())});
    }

    private void tc() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void td() {
        if (this.axv != null) {
            this.axv.cancel(true);
            this.axv = null;
        }
    }
}
