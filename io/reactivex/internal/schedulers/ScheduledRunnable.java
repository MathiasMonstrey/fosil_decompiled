package io.reactivex.internal.schedulers;

import com.fossil.eqn;
import com.fossil.eqx;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements eqn, Runnable, Callable<Object> {
    static final Object DISPOSED = new Object();
    static final Object DONE = new Object();
    static final int FUTURE_INDEX = 1;
    static final int PARENT_INDEX = 0;
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    public ScheduledRunnable(Runnable runnable, eqx com_fossil_eqx) {
        super(3);
        this.actual = runnable;
        lazySet(0, com_fossil_eqx);
    }

    public Object call() {
        run();
        return null;
    }

    public void run() {
        Object obj;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        } catch (Throwable th) {
            Throwable th2 = th;
            lazySet(2, null);
            obj = get(0);
            if (!(obj == DISPOSED || obj == null || !compareAndSet(0, obj, DONE))) {
                ((eqx) obj).c(this);
            }
            do {
                obj = get(1);
                if (obj == DISPOSED) {
                    break;
                }
            } while (!compareAndSet(1, obj, DONE));
        }
        lazySet(2, null);
        obj = get(0);
        if (!(obj == DISPOSED || obj == null || !compareAndSet(0, obj, DONE))) {
            ((eqx) obj).c(this);
        }
        do {
            obj = get(1);
            if (obj == DISPOSED) {
                return;
            }
        } while (!compareAndSet(1, obj, DONE));
    }

    public void setFuture(Future<?> future) {
        boolean z = true;
        Object obj;
        do {
            obj = get(1);
            if (obj != DONE) {
                if (obj == DISPOSED) {
                    if (get(2) == Thread.currentThread()) {
                        z = false;
                    }
                    future.cancel(z);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    public void dispose() {
        Object obj;
        boolean z = true;
        do {
            obj = get(1);
            if (obj == DONE || obj == DISPOSED) {
                break;
            }
        } while (!compareAndSet(1, obj, DISPOSED));
        if (obj != null) {
            Future future = (Future) obj;
            if (get(2) == Thread.currentThread()) {
                z = false;
            }
            future.cancel(z);
        }
        do {
            obj = get(0);
            if (obj == DONE || obj == DISPOSED || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, DISPOSED));
        ((eqx) obj).c(this);
    }

    public boolean isDisposed() {
        Object obj = get(1);
        if (obj == DISPOSED || obj == DONE) {
            return true;
        }
        return false;
    }
}
