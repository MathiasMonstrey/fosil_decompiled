package com.fossil;

import com.fossil.eqh.C3496b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class eri extends eqh {
    static final C3516b dRI = new C3516b(0, dRJ);
    static final RxThreadFactory dRJ = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
    static final int dRK = ct(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final C3517c dRL = new C3517c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory dOn;
    final AtomicReference<C3516b> dRM;

    static final class C3515a extends C3496b {
        volatile boolean dQP;
        private final eqy dRN = new eqy();
        private final eqm dRO = new eqm();
        private final eqy dRP = new eqy();
        private final C3517c dRQ;

        C3515a(C3517c c3517c) {
            this.dRQ = c3517c;
            this.dRP.mo3006a(this.dRN);
            this.dRP.mo3006a(this.dRO);
        }

        public void dispose() {
            if (!this.dQP) {
                this.dQP = true;
                this.dRP.dispose();
            }
        }

        public eqn mo3021o(Runnable runnable) {
            if (this.dQP) {
                return EmptyDisposable.INSTANCE;
            }
            return this.dRQ.m11088a(runnable, 0, TimeUnit.MILLISECONDS, this.dRN);
        }

        public eqn mo3004a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.dQP) {
                return EmptyDisposable.INSTANCE;
            }
            return this.dRQ.m11088a(runnable, j, timeUnit, this.dRO);
        }
    }

    static final class C3516b {
        long aXW;
        final int dRR;
        final C3517c[] dRS;

        C3516b(int i, ThreadFactory threadFactory) {
            this.dRR = i;
            this.dRS = new C3517c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.dRS[i2] = new C3517c(threadFactory);
            }
        }

        public C3517c aGO() {
            int i = this.dRR;
            if (i == 0) {
                return eri.dRL;
            }
            C3517c[] c3517cArr = this.dRS;
            long j = this.aXW;
            this.aXW = 1 + j;
            return c3517cArr[(int) (j % ((long) i))];
        }

        public void shutdown() {
            for (C3517c dispose : this.dRS) {
                dispose.dispose();
            }
        }
    }

    static final class C3517c extends erm {
        C3517c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        dRL.dispose();
        dRI.shutdown();
    }

    static int ct(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    public eri() {
        this(dRJ);
    }

    public eri(ThreadFactory threadFactory) {
        this.dOn = threadFactory;
        this.dRM = new AtomicReference(dRI);
        start();
    }

    public C3496b aGG() {
        return new C3515a(((C3516b) this.dRM.get()).aGO());
    }

    public eqn mo3022a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return ((C3516b) this.dRM.get()).aGO().m11086a(runnable, j, j2, timeUnit);
    }

    public void start() {
        C3516b c3516b = new C3516b(dRK, this.dOn);
        if (!this.dRM.compareAndSet(dRI, c3516b)) {
            c3516b.shutdown();
        }
    }
}
