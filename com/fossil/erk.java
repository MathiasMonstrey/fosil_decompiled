package com.fossil;

import com.fossil.eqh.C3496b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class erk extends eqh {
    static final RxThreadFactory dRW;
    static final RxThreadFactory dRX;
    private static final TimeUnit dRY = TimeUnit.SECONDS;
    static final C3520c dRZ = new C3520c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final C3518a dSa = new C3518a(0, null, dRW);
    final ThreadFactory dOn;
    final AtomicReference<C3518a> dRM;

    static final class C3518a implements Runnable {
        private final ThreadFactory dOn;
        private final long dSb;
        private final ConcurrentLinkedQueue<C3520c> dSc;
        final eqm dSd;
        private final ScheduledExecutorService dSe;
        private final Future<?> dSf;

        C3518a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            Future scheduleWithFixedDelay;
            ScheduledExecutorService scheduledExecutorService = null;
            this.dSb = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.dSc = new ConcurrentLinkedQueue();
            this.dSd = new eqm();
            this.dOn = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, erk.dRX);
                scheduledExecutorService = newScheduledThreadPool;
                scheduleWithFixedDelay = newScheduledThreadPool.scheduleWithFixedDelay(this, this.dSb, this.dSb, TimeUnit.NANOSECONDS);
            } else {
                scheduleWithFixedDelay = null;
            }
            this.dSe = scheduledExecutorService;
            this.dSf = scheduleWithFixedDelay;
        }

        public void run() {
            aGQ();
        }

        C3520c aGP() {
            if (this.dSd.isDisposed()) {
                return erk.dRZ;
            }
            while (!this.dSc.isEmpty()) {
                C3520c c3520c = (C3520c) this.dSc.poll();
                if (c3520c != null) {
                    return c3520c;
                }
            }
            eqn c3520c2 = new C3520c(this.dOn);
            this.dSd.mo3006a(c3520c2);
            return c3520c2;
        }

        void m11093a(C3520c c3520c) {
            c3520c.aZ(aGR() + this.dSb);
            this.dSc.offer(c3520c);
        }

        void aGQ() {
            if (!this.dSc.isEmpty()) {
                long aGR = aGR();
                Iterator it = this.dSc.iterator();
                while (it.hasNext()) {
                    C3520c c3520c = (C3520c) it.next();
                    if (c3520c.aGS() > aGR) {
                        return;
                    }
                    if (this.dSc.remove(c3520c)) {
                        this.dSd.mo3007b(c3520c);
                    }
                }
            }
        }

        long aGR() {
            return System.nanoTime();
        }

        void shutdown() {
            this.dSd.dispose();
            if (this.dSf != null) {
                this.dSf.cancel(true);
            }
            if (this.dSe != null) {
                this.dSe.shutdownNow();
            }
        }
    }

    static final class C3519b extends C3496b {
        private final eqm dSg;
        private final C3518a dSh;
        private final C3520c dSi;
        final AtomicBoolean dSj = new AtomicBoolean();

        C3519b(C3518a c3518a) {
            this.dSh = c3518a;
            this.dSg = new eqm();
            this.dSi = c3518a.aGP();
        }

        public void dispose() {
            if (this.dSj.compareAndSet(false, true)) {
                this.dSg.dispose();
                this.dSh.m11093a(this.dSi);
            }
        }

        public eqn mo3004a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.dSg.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.dSi.m11088a(runnable, j, timeUnit, this.dSg);
        }
    }

    static final class C3520c extends erm {
        private long dSk = 0;

        C3520c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long aGS() {
            return this.dSk;
        }

        public void aZ(long j) {
            this.dSk = j;
        }
    }

    static {
        dRZ.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        dRW = new RxThreadFactory("RxCachedThreadScheduler", max);
        dRX = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        dSa.shutdown();
    }

    public erk() {
        this(dRW);
    }

    public erk(ThreadFactory threadFactory) {
        this.dOn = threadFactory;
        this.dRM = new AtomicReference(dSa);
        start();
    }

    public void start() {
        C3518a c3518a = new C3518a(60, dRY, this.dOn);
        if (!this.dRM.compareAndSet(dSa, c3518a)) {
            c3518a.shutdown();
        }
    }

    public C3496b aGG() {
        return new C3519b((C3518a) this.dRM.get());
    }
}
