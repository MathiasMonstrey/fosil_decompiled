package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.fossil.aah;
import com.fossil.uz;
import com.fossil.vh;
import com.fossil.wc;

public class EngineRunnable implements wc, Runnable {
    private final C1290a aCf;
    private final uz<?, ?, ?> aCg;
    private Stage aCh = Stage.CACHE;
    private volatile boolean isCancelled;
    private final Priority priority;

    enum Stage {
        CACHE,
        SOURCE
    }

    public interface C1290a extends aah {
        void m2606b(EngineRunnable engineRunnable);
    }

    public EngineRunnable(C1290a c1290a, uz<?, ?, ?> uzVar, Priority priority) {
        this.aCf = c1290a;
        this.aCg = uzVar;
        this.priority = priority;
    }

    public void cancel() {
        this.isCancelled = true;
        this.aCg.cancel();
    }

    public void run() {
        Object obj;
        Exception exception = null;
        if (!this.isCancelled) {
            vh uX;
            try {
                uX = uX();
            } catch (Throwable e) {
                if (Log.isLoggable("EngineRunnable", 2)) {
                    Log.v("EngineRunnable", "Out Of Memory Error decoding", e);
                }
                exception = new ErrorWrappingGlideException(e);
                obj = null;
            } catch (Throwable e2) {
                if (Log.isLoggable("EngineRunnable", 2)) {
                    Log.v("EngineRunnable", "Exception decoding", e2);
                }
                Throwable th = e2;
                obj = null;
            }
            if (this.isCancelled) {
                if (uX != null) {
                    uX.recycle();
                }
            } else if (uX == null) {
                m2607f(exception);
            } else {
                m2608h(uX);
            }
        }
    }

    private boolean uW() {
        return this.aCh == Stage.CACHE;
    }

    private void m2608h(vh vhVar) {
        this.aCf.mo187g(vhVar);
    }

    private void m2607f(Exception exception) {
        if (uW()) {
            this.aCh = Stage.SOURCE;
            this.aCf.m2606b(this);
            return;
        }
        this.aCf.mo186e(exception);
    }

    private vh<?> uX() throws Exception {
        if (uW()) {
            return uY();
        }
        return uO();
    }

    private vh<?> uY() throws Exception {
        vh<?> uM;
        try {
            uM = this.aCg.uM();
        } catch (Exception e) {
            if (Log.isLoggable("EngineRunnable", 3)) {
                Log.d("EngineRunnable", "Exception decoding result from cache: " + e);
            }
            uM = null;
        }
        if (uM == null) {
            return this.aCg.uN();
        }
        return uM;
    }

    private vh<?> uO() throws Exception {
        return this.aCg.uO();
    }

    public int getPriority() {
        return this.priority.ordinal();
    }
}
