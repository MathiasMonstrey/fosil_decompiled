package com.fossil;

import com.fossil.eqh.C3496b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class erm extends C3496b implements eqn {
    private final ScheduledExecutorService dPd;
    volatile boolean dQP;

    public erm(ThreadFactory threadFactory) {
        this.dPd = ern.m11095a(threadFactory);
    }

    public eqn mo3021o(Runnable runnable) {
        return mo3004a(runnable, 0, null);
    }

    public eqn mo3004a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.dQP) {
            return EmptyDisposable.INSTANCE;
        }
        return m11088a(runnable, j, timeUnit, null);
    }

    public eqn m11086a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Runnable q = ers.m11117q(runnable);
        if (j2 <= 0) {
            Future submit;
            Object com_fossil_erj = new erj(q, this.dPd);
            if (j <= 0) {
                try {
                    submit = this.dPd.submit(com_fossil_erj);
                } catch (Throwable e) {
                    ers.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            submit = this.dPd.schedule(com_fossil_erj, j, timeUnit);
            com_fossil_erj.m11091a(submit);
            return com_fossil_erj;
        }
        eqn scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(q);
        try {
            scheduledDirectPeriodicTask.setFuture(this.dPd.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (Throwable e2) {
            ers.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    public ScheduledRunnable m11088a(Runnable runnable, long j, TimeUnit timeUnit, eqx com_fossil_eqx) {
        Object scheduledRunnable = new ScheduledRunnable(ers.m11117q(runnable), com_fossil_eqx);
        if (com_fossil_eqx == null || com_fossil_eqx.mo3006a(scheduledRunnable)) {
            Future submit;
            if (j <= 0) {
                try {
                    submit = this.dPd.submit(scheduledRunnable);
                } catch (Throwable e) {
                    if (com_fossil_eqx != null) {
                        com_fossil_eqx.mo3007b(scheduledRunnable);
                    }
                    ers.onError(e);
                }
            } else {
                submit = this.dPd.schedule(scheduledRunnable, j, timeUnit);
            }
            scheduledRunnable.setFuture(submit);
        }
        return scheduledRunnable;
    }

    public void dispose() {
        if (!this.dQP) {
            this.dQP = true;
            this.dPd.shutdownNow();
        }
    }
}
