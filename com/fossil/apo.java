package com.fossil;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

public class apo<T extends aqy> {
    private static final String aWB = apo.class.getSimpleName();
    private final apg<Object, T> baU = new apg();
    private final HashMap<T, Object> bba = new HashMap();
    private final HashMap<T, Future<?>> bbb = new HashMap();
    private final ThreadPoolExecutor bbc;

    class C17942 extends DiscardPolicy {
        final /* synthetic */ apo bbd;

        C17942(apo com_fossil_apo) {
            this.bbd = com_fossil_apo;
        }

        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            super.rejectedExecution(runnable, threadPoolExecutor);
            final aqy g = apo.m4150g(runnable);
            if (g != null) {
                synchronized (this.bbd.bbb) {
                    this.bbd.bbb.remove(g);
                }
                this.bbd.m4146a(g);
                new aqx(this) {
                    final /* synthetic */ C17942 bbg;

                    public final void HJ() {
                    }
                }.run();
            }
        }
    }

    public apo(String str, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        this.bbc = new ThreadPoolExecutor(this, timeUnit, blockingQueue) {
            final /* synthetic */ apo bbd;

            protected final void beforeExecute(Thread thread, Runnable runnable) {
                super.beforeExecute(thread, runnable);
                final aqy g = apo.m4150g(runnable);
                if (g != null) {
                    new aqx(this) {
                        final /* synthetic */ C17921 bbf;

                        public final void HJ() {
                        }
                    }.run();
                }
            }

            protected final void afterExecute(Runnable runnable, Throwable th) {
                super.afterExecute(runnable, th);
                final aqy g = apo.m4150g(runnable);
                if (g != null) {
                    synchronized (this.bbd.bbb) {
                        this.bbd.bbb.remove(g);
                    }
                    this.bbd.m4146a(g);
                    new aqx(this) {
                        final /* synthetic */ C17921 bbf;

                        public final void HJ() {
                        }
                    }.run();
                }
            }

            protected final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
                RunnableFuture com_fossil_apn = new apn(runnable, v);
                synchronized (this.bbd.bbb) {
                    this.bbd.bbb.put((aqy) runnable, com_fossil_apn);
                }
                return com_fossil_apn;
            }

            protected final <V> RunnableFuture<V> newTaskFor(Callable<V> callable) {
                throw new UnsupportedOperationException("Callable not supported");
            }
        };
        this.bbc.setRejectedExecutionHandler(new C17942(this));
        this.bbc.setThreadFactory(new aqr(str));
    }

    private synchronized void m4146a(T t) {
        m4147a(this.bba.get(t), (aqy) t);
    }

    private synchronized void m4147a(Object obj, T t) {
        this.baU.m4165o(obj, t);
        this.bba.remove(t);
    }

    public final synchronized void m4151b(Object obj, T t) {
        if (!(obj == null || t == null)) {
            m4149c(obj, t);
            this.bbc.submit(t);
        }
    }

    private synchronized void m4149c(Object obj, T t) {
        this.baU.m4164n(obj, t);
        this.bba.put(t, obj);
    }

    public final synchronized void bJ(Object obj) {
        if (obj != null) {
            Collection<aqy> hashSet = new HashSet();
            hashSet.addAll(this.baU.bH(obj));
            for (aqy b : hashSet) {
                m4148b(b);
            }
        }
    }

    private synchronized void m4148b(final T t) {
        if (t != null) {
            Future future;
            synchronized (this.bbb) {
                future = (Future) this.bbb.remove(t);
            }
            m4146a((aqy) t);
            if (future != null) {
                future.cancel(true);
            }
            new aqx(this) {
                final /* synthetic */ apo bbh;

                public final void HJ() {
                    t.HN();
                }
            }.run();
        }
    }

    static /* synthetic */ aqy m4150g(Runnable runnable) {
        if (runnable instanceof apn) {
            return (aqy) ((apn) runnable).IX();
        }
        if (runnable instanceof aqy) {
            return (aqy) runnable;
        }
        app.m4180g(6, aWB, "Unknown runnable class: " + runnable.getClass().getName());
        return null;
    }
}
