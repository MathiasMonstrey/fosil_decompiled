package com.fossil;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class aaf<T, R> implements aac<R>, Runnable {
    private static final C1549a aGm = new C1549a();
    private final boolean aGn;
    private final C1549a aGo;
    private R aGp;
    private aad aGq;
    private boolean aGr;
    private boolean aGs;
    private final Handler ayQ;
    private Exception exception;
    private final int height;
    private boolean isCancelled;
    private final int width;

    static class C1549a {
        C1549a() {
        }

        public void m2806a(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }

        public void bh(Object obj) {
            obj.notifyAll();
        }
    }

    public aaf(Handler handler, int i, int i2) {
        this(handler, i, i2, true, aGm);
    }

    aaf(Handler handler, int i, int i2, boolean z, C1549a c1549a) {
        this.ayQ = handler;
        this.width = i;
        this.height = i2;
        this.aGn = z;
        this.aGo = c1549a;
    }

    public synchronized boolean cancel(boolean z) {
        boolean z2 = true;
        synchronized (this) {
            if (!this.isCancelled) {
                if (isDone()) {
                    z2 = false;
                }
                if (z2) {
                    this.isCancelled = true;
                    if (z) {
                        clear();
                    }
                    this.aGo.bh(this);
                }
            }
        }
        return z2;
    }

    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    public synchronized boolean isDone() {
        boolean z;
        z = this.isCancelled || this.aGr;
        return z;
    }

    public R get() throws InterruptedException, ExecutionException {
        try {
            return m2807a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public R get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return m2807a(Long.valueOf(timeUnit.toMillis(j)));
    }

    public void mo764a(aax com_fossil_aax) {
        com_fossil_aax.be(this.width, this.height);
    }

    public void mo767f(aad com_fossil_aad) {
        this.aGq = com_fossil_aad;
    }

    public aad wD() {
        return this.aGq;
    }

    public void mo769x(Drawable drawable) {
    }

    public void mo770y(Drawable drawable) {
    }

    public synchronized void mo765a(Exception exception, Drawable drawable) {
        this.aGs = true;
        this.exception = exception;
        this.aGo.bh(this);
    }

    public synchronized void mo766a(R r, aal<? super R> com_fossil_aal__super_R) {
        this.aGr = true;
        this.aGp = r;
        this.aGo.bh(this);
    }

    private synchronized R m2807a(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        R r;
        if (this.aGn) {
            abl.wY();
        }
        if (this.isCancelled) {
            throw new CancellationException();
        } else if (this.aGs) {
            throw new ExecutionException(this.exception);
        } else if (this.aGr) {
            r = this.aGp;
        } else {
            if (l == null) {
                this.aGo.m2806a(this, 0);
            } else if (l.longValue() > 0) {
                this.aGo.m2806a(this, l.longValue());
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.aGs) {
                throw new ExecutionException(this.exception);
            } else if (this.isCancelled) {
                throw new CancellationException();
            } else if (this.aGr) {
                r = this.aGp;
            } else {
                throw new TimeoutException();
            }
        }
        return r;
    }

    public void run() {
        if (this.aGq != null) {
            this.aGq.clear();
            cancel(false);
        }
    }

    public void clear() {
        this.ayQ.post(this);
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }
}
