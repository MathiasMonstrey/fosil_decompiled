package com.fossil;

import android.os.Handler;
import android.os.Message;
import com.fossil.eqh.C3496b;
import java.util.concurrent.TimeUnit;

final class eql extends eqh {
    private final Handler handler;

    static final class C3499a extends C3496b {
        private volatile boolean dQP;
        private final Handler handler;

        C3499a(Handler handler) {
            this.handler = handler;
        }

        public eqn mo3004a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.dQP) {
                return eqo.aGJ();
            } else {
                eqn c3500b = new C3500b(this.handler, ers.m11117q(runnable));
                Message obtain = Message.obtain(this.handler, c3500b);
                obtain.obj = this;
                this.handler.sendMessageDelayed(obtain, Math.max(0, timeUnit.toMillis(j)));
                if (!this.dQP) {
                    return c3500b;
                }
                this.handler.removeCallbacks(c3500b);
                return eqo.aGJ();
            }
        }

        public void dispose() {
            this.dQP = true;
            this.handler.removeCallbacksAndMessages(this);
        }
    }

    static final class C3500b implements eqn, Runnable {
        private volatile boolean dQP;
        private final Runnable dRa;
        private final Handler handler;

        C3500b(Handler handler, Runnable runnable) {
            this.handler = handler;
            this.dRa = runnable;
        }

        public void run() {
            try {
                this.dRa.run();
            } catch (Throwable th) {
                Throwable illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                ers.onError(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        public void dispose() {
            this.dQP = true;
            this.handler.removeCallbacks(this);
        }
    }

    eql(Handler handler) {
        this.handler = handler;
    }

    public C3496b aGG() {
        return new C3499a(this.handler);
    }
}
