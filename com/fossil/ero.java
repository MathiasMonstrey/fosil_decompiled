package com.fossil;

import com.fossil.eqh.C3496b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.RxThreadFactory;
import io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ero extends eqh {
    static final RxThreadFactory dSq = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    static final ScheduledExecutorService dSr = Executors.newScheduledThreadPool(0);
    final ThreadFactory dOn;
    final AtomicReference<ScheduledExecutorService> dSp;

    static final class C3522a extends C3496b {
        final ScheduledExecutorService dPd;
        volatile boolean dQP;
        final eqm dSg = new eqm();

        C3522a(ScheduledExecutorService scheduledExecutorService) {
            this.dPd = scheduledExecutorService;
        }

        public eqn mo3004a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.dQP) {
                return EmptyDisposable.INSTANCE;
            }
            Future submit;
            eqn scheduledRunnable = new ScheduledRunnable(ers.m11117q(runnable), this.dSg);
            this.dSg.mo3006a(scheduledRunnable);
            if (j <= 0) {
                try {
                    submit = this.dPd.submit(scheduledRunnable);
                } catch (Throwable e) {
                    dispose();
                    ers.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            submit = this.dPd.schedule(scheduledRunnable, j, timeUnit);
            scheduledRunnable.setFuture(submit);
            return scheduledRunnable;
        }

        public void dispose() {
            if (!this.dQP) {
                this.dQP = true;
                this.dSg.dispose();
            }
        }
    }

    static {
        dSr.shutdown();
    }

    public ero() {
        this(dSq);
    }

    public ero(ThreadFactory threadFactory) {
        this.dSp = new AtomicReference();
        this.dOn = threadFactory;
        this.dSp.lazySet(m11097b(threadFactory));
    }

    static ScheduledExecutorService m11097b(ThreadFactory threadFactory) {
        return ern.m11095a(threadFactory);
    }

    public void start() {
        ScheduledExecutorService scheduledExecutorService = null;
        ScheduledExecutorService scheduledExecutorService2;
        do {
            scheduledExecutorService2 = (ScheduledExecutorService) this.dSp.get();
            if (scheduledExecutorService2 != dSr) {
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService == null) {
                scheduledExecutorService = m11097b(this.dOn);
            }
        } while (!this.dSp.compareAndSet(scheduledExecutorService2, scheduledExecutorService));
    }

    public C3496b aGG() {
        return new C3522a((ScheduledExecutorService) this.dSp.get());
    }

    public eqn mo3022a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Runnable q = ers.m11117q(runnable);
        if (j2 <= 0) {
            Future submit;
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.dSp.get();
            Object com_fossil_erj = new erj(q, scheduledExecutorService);
            if (j <= 0) {
                try {
                    submit = scheduledExecutorService.submit(com_fossil_erj);
                } catch (Throwable e) {
                    ers.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            submit = scheduledExecutorService.schedule(com_fossil_erj, j, timeUnit);
            com_fossil_erj.m11091a(submit);
            return com_fossil_erj;
        }
        eqn scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(q);
        try {
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.dSp.get()).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (Throwable e2) {
            ers.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }
}
