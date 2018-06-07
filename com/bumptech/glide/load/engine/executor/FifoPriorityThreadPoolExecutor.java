package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.util.Log;
import com.fossil.wc;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FifoPriorityThreadPoolExecutor extends ThreadPoolExecutor {
    private final AtomicInteger aDa;
    private final UncaughtThrowableStrategy aDb;

    public enum UncaughtThrowableStrategy {
        IGNORE,
        LOG {
            protected void handle(Throwable th) {
                if (Log.isLoggable("PriorityExecutor", 6)) {
                    Log.e("PriorityExecutor", "Request threw uncaught throwable", th);
                }
            }
        },
        THROW {
            protected void handle(Throwable th) {
                super.handle(th);
                throw new RuntimeException(th);
            }
        };

        protected void handle(Throwable th) {
        }
    }

    public static class C1292a implements ThreadFactory {
        int aDc = 0;

        public Thread newThread(Runnable runnable) {
            Thread c12911 = new Thread(this, runnable, "fifo-pool-thread-" + this.aDc) {
                final /* synthetic */ C1292a aDd;

                public void run() {
                    Process.setThreadPriority(10);
                    super.run();
                }
            };
            this.aDc++;
            return c12911;
        }
    }

    static class C1293b<T> extends FutureTask<T> implements Comparable<C1293b<?>> {
        private final int order;
        private final int priority;

        public /* synthetic */ int compareTo(Object obj) {
            return m2609a((C1293b) obj);
        }

        public C1293b(Runnable runnable, T t, int i) {
            super(runnable, t);
            if (runnable instanceof wc) {
                this.priority = ((wc) runnable).getPriority();
                this.order = i;
                return;
            }
            throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1293b)) {
                return false;
            }
            C1293b c1293b = (C1293b) obj;
            if (this.order == c1293b.order && this.priority == c1293b.priority) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.priority * 31) + this.order;
        }

        public int m2609a(C1293b<?> c1293b) {
            int i = this.priority - c1293b.priority;
            if (i == 0) {
                return this.order - c1293b.order;
            }
            return i;
        }
    }

    public FifoPriorityThreadPoolExecutor(int i) {
        this(i, UncaughtThrowableStrategy.LOG);
    }

    public FifoPriorityThreadPoolExecutor(int i, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        this(i, i, 0, TimeUnit.MILLISECONDS, new C1292a(), uncaughtThrowableStrategy);
    }

    public FifoPriorityThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        super(i, i2, j, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.aDa = new AtomicInteger();
        this.aDb = uncaughtThrowableStrategy;
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C1293b(runnable, t, this.aDa.getAndIncrement());
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (future.isDone() && !future.isCancelled()) {
                try {
                    future.get();
                } catch (Throwable e) {
                    this.aDb.handle(e);
                } catch (Throwable e2) {
                    this.aDb.handle(e2);
                }
            }
        }
    }
}
