package com.fossil;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;

public abstract class eqh {
    static final long dQN = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    static class C3494a implements eqn, Runnable {
        final Runnable dQO;
        volatile boolean dQP;
        final C3496b worker;

        C3494a(Runnable runnable, C3496b c3496b) {
            this.dQO = runnable;
            this.worker = c3496b;
        }

        public void run() {
            if (!this.dQP) {
                try {
                    this.dQO.run();
                } catch (Throwable th) {
                    eqp.m11067k(th);
                    this.worker.dispose();
                    RuntimeException m = ExceptionHelper.m(th);
                }
            }
        }

        public void dispose() {
            this.dQP = true;
            this.worker.dispose();
        }
    }

    public static abstract class C3496b implements eqn {

        final class C3495a implements Runnable {
            long count;
            final Runnable dQQ;
            final SequentialDisposable dQR;
            final long dQS;
            long dQT;
            long dQU;
            final /* synthetic */ C3496b dQV;

            C3495a(C3496b c3496b, long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.dQV = c3496b;
                this.dQQ = runnable;
                this.dQR = sequentialDisposable;
                this.dQS = j3;
                this.dQT = j2;
                this.dQU = j;
            }

            public void run() {
                this.dQQ.run();
                if (!this.dQR.isDisposed()) {
                    long j;
                    long d = this.dQV.m11049d(TimeUnit.NANOSECONDS);
                    long j2;
                    if (eqh.dQN + d < this.dQT || d >= (this.dQT + this.dQS) + eqh.dQN) {
                        j = this.dQS + d;
                        j2 = this.dQS;
                        long j3 = this.count + 1;
                        this.count = j3;
                        this.dQU = j - (j2 * j3);
                    } else {
                        j = this.dQU;
                        j2 = this.count + 1;
                        this.count = j2;
                        j += j2 * this.dQS;
                    }
                    this.dQT = d;
                    this.dQR.replace(this.dQV.mo3004a(this, j - d, TimeUnit.NANOSECONDS));
                }
            }
        }

        public abstract eqn mo3004a(Runnable runnable, long j, TimeUnit timeUnit);

        public eqn mo3021o(Runnable runnable) {
            return mo3004a(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public eqn m11048b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            Object sequentialDisposable = new SequentialDisposable();
            eqn sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable q = ers.m11117q(runnable);
            long toNanos = timeUnit.toNanos(j2);
            long d = m11049d(TimeUnit.NANOSECONDS);
            eqn a = mo3004a(new C3495a(this, d + timeUnit.toNanos(j), q, d, sequentialDisposable2, toNanos), j, timeUnit);
            if (a == EmptyDisposable.INSTANCE) {
                return a;
            }
            sequentialDisposable.replace(a);
            return sequentialDisposable2;
        }

        public long m11049d(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public abstract C3496b aGG();

    public void start() {
    }

    public eqn mo3022a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        C3496b aGG = aGG();
        eqn c3494a = new C3494a(ers.m11117q(runnable), aGG);
        eqn b = aGG.m11048b(c3494a, j, j2, timeUnit);
        if (b == EmptyDisposable.INSTANCE) {
            return b;
        }
        return c3494a;
    }
}
