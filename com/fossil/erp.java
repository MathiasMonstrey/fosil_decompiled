package com.fossil;

import com.fossil.eqh.C3496b;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class erp extends eqh {
    private static final erp dSs = new erp();

    static final class C3523a implements Runnable {
        private final Runnable dQO;
        private final C3526c dSt;
        private final long dSu;

        C3523a(Runnable runnable, C3526c c3526c, long j) {
            this.dQO = runnable;
            this.dSt = c3526c;
            this.dSu = j;
        }

        public void run() {
            if (!this.dSt.dQP) {
                long d = this.dSt.m11049d(TimeUnit.MILLISECONDS);
                if (this.dSu > d) {
                    d = this.dSu - d;
                    if (d > 0) {
                        try {
                            Thread.sleep(d);
                        } catch (Throwable e) {
                            Thread.currentThread().interrupt();
                            ers.onError(e);
                            return;
                        }
                    }
                }
                if (!this.dSt.dQP) {
                    this.dQO.run();
                }
            }
        }
    }

    static final class C3524b implements Comparable<C3524b> {
        final int count;
        final Runnable dQO;
        volatile boolean dQP;
        final long dSu;

        public /* synthetic */ int compareTo(Object obj) {
            return m11099a((C3524b) obj);
        }

        C3524b(Runnable runnable, Long l, int i) {
            this.dQO = runnable;
            this.dSu = l.longValue();
            this.count = i;
        }

        public int m11099a(C3524b c3524b) {
            int compare = era.compare(this.dSu, c3524b.dSu);
            if (compare == 0) {
                return era.compare(this.count, c3524b.count);
            }
            return compare;
        }
    }

    static final class C3526c extends C3496b implements eqn {
        final AtomicInteger counter = new AtomicInteger();
        volatile boolean dQP;
        final PriorityBlockingQueue<C3524b> dSv = new PriorityBlockingQueue();
        private final AtomicInteger dSw = new AtomicInteger();

        final class C3525a implements Runnable {
            final C3524b dSx;
            final /* synthetic */ C3526c dSy;

            C3525a(C3526c c3526c, C3524b c3524b) {
                this.dSy = c3526c;
                this.dSx = c3524b;
            }

            public void run() {
                this.dSx.dQP = true;
                this.dSy.dSv.remove(this.dSx);
            }
        }

        C3526c() {
        }

        public eqn mo3021o(Runnable runnable) {
            return m11101b(runnable, m11049d(TimeUnit.MILLISECONDS));
        }

        public eqn mo3004a(Runnable runnable, long j, TimeUnit timeUnit) {
            long d = m11049d(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return m11101b(new C3523a(runnable, this, d), d);
        }

        eqn m11101b(Runnable runnable, long j) {
            if (this.dQP) {
                return EmptyDisposable.INSTANCE;
            }
            C3524b c3524b = new C3524b(runnable, Long.valueOf(j), this.counter.incrementAndGet());
            this.dSv.add(c3524b);
            if (this.dSw.getAndIncrement() != 0) {
                return eqo.m11065p(new C3525a(this, c3524b));
            }
            int i = 1;
            while (!this.dQP) {
                c3524b = (C3524b) this.dSv.poll();
                if (c3524b == null) {
                    int addAndGet = this.dSw.addAndGet(-i);
                    if (addAndGet == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                    i = addAndGet;
                } else if (!c3524b.dQP) {
                    c3524b.dQO.run();
                }
            }
            this.dSv.clear();
            return EmptyDisposable.INSTANCE;
        }

        public void dispose() {
            this.dQP = true;
        }
    }

    public static erp aGT() {
        return dSs;
    }

    public C3496b aGG() {
        return new C3526c();
    }

    erp() {
    }
}
