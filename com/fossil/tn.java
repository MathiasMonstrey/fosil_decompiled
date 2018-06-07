package com.fossil;

import bolts.ExecutorException;
import bolts.UnobservedTaskException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class tn<TResult> {
    private static volatile C4118b axA;
    private static tn<?> axF = new tn(null);
    private static tn<Boolean> axG = new tn(Boolean.valueOf(true));
    private static tn<Boolean> axH = new tn(Boolean.valueOf(false));
    private static tn<?> axI = new tn(true);
    public static final ExecutorService axx = ti.sX();
    private static final Executor axy = ti.sY();
    public static final Executor axz = tf.sV();
    private boolean axB;
    private boolean axC;
    private tp axD;
    private List<tm<TResult, Void>> axE = new ArrayList();
    private boolean cancelled;
    private Exception error;
    private final Object lock = new Object();
    private TResult result;

    public class C4117a extends to<TResult> {
        final /* synthetic */ tn axN;

        C4117a(tn tnVar) {
            this.axN = tnVar;
        }
    }

    public interface C4118b {
        void m13684a(tn<?> tnVar, UnobservedTaskException unobservedTaskException);
    }

    public static C4118b te() {
        return axA;
    }

    tn() {
    }

    private tn(TResult tResult) {
        aU(tResult);
    }

    private tn(boolean z) {
        if (z) {
            tj();
        } else {
            aU(null);
        }
    }

    public static <TResult> C4117a tf() {
        tn tnVar = new tn();
        tnVar.getClass();
        return new C4117a(tnVar);
    }

    public boolean isCompleted() {
        boolean z;
        synchronized (this.lock) {
            z = this.axB;
        }
        return z;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.lock) {
            z = this.cancelled;
        }
        return z;
    }

    public boolean tg() {
        boolean z;
        synchronized (this.lock) {
            z = getError() != null;
        }
        return z;
    }

    public TResult getResult() {
        TResult tResult;
        synchronized (this.lock) {
            tResult = this.result;
        }
        return tResult;
    }

    public Exception getError() {
        Exception exception;
        synchronized (this.lock) {
            if (this.error != null) {
                this.axC = true;
                if (this.axD != null) {
                    this.axD.tm();
                    this.axD = null;
                }
            }
            exception = this.error;
        }
        return exception;
    }

    public static <TResult> tn<TResult> aT(TResult tResult) {
        if (tResult == null) {
            return axF;
        }
        if (tResult instanceof Boolean) {
            return ((Boolean) tResult).booleanValue() ? axG : axH;
        } else {
            to toVar = new to();
            toVar.aV(tResult);
            return toVar.tk();
        }
    }

    public static <TResult> tn<TResult> m13686b(Exception exception) {
        to toVar = new to();
        toVar.m13683d(exception);
        return toVar.tk();
    }

    public static <TResult> tn<TResult> th() {
        return axI;
    }

    public <TContinuationResult> tn<TContinuationResult> m13692a(tm<TResult, TContinuationResult> tmVar, Executor executor, tj tjVar) {
        final to toVar = new to();
        synchronized (this.lock) {
            boolean isCompleted = isCompleted();
            if (!isCompleted) {
                final tm<TResult, TContinuationResult> tmVar2 = tmVar;
                final Executor executor2 = executor;
                final tj tjVar2 = tjVar;
                this.axE.add(new tm<TResult, Void>(this) {
                    final /* synthetic */ tn axN;

                    public /* synthetic */ Object then(tn tnVar) throws Exception {
                        return m13678a(tnVar);
                    }

                    public Void m13678a(tn<TResult> tnVar) {
                        tn.m13685a(toVar, tmVar2, tnVar, executor2, tjVar2);
                        return null;
                    }
                });
            }
        }
        if (isCompleted) {
            m13685a(toVar, tmVar, this, executor, tjVar);
        }
        return toVar.tk();
    }

    public <TContinuationResult> tn<TContinuationResult> m13690a(tm<TResult, TContinuationResult> tmVar) {
        return m13692a(tmVar, axy, null);
    }

    public <TContinuationResult> tn<TContinuationResult> m13691a(tm<TResult, tn<TContinuationResult>> tmVar, Executor executor) {
        return m13694b(tmVar, executor, null);
    }

    public <TContinuationResult> tn<TContinuationResult> m13694b(tm<TResult, tn<TContinuationResult>> tmVar, Executor executor, tj tjVar) {
        final to toVar = new to();
        synchronized (this.lock) {
            boolean isCompleted = isCompleted();
            if (!isCompleted) {
                final tm<TResult, tn<TContinuationResult>> tmVar2 = tmVar;
                final Executor executor2 = executor;
                final tj tjVar2 = tjVar;
                this.axE.add(new tm<TResult, Void>(this) {
                    final /* synthetic */ tn axN;

                    public /* synthetic */ Object then(tn tnVar) throws Exception {
                        return m13679a(tnVar);
                    }

                    public Void m13679a(tn<TResult> tnVar) {
                        tn.m13687b(toVar, tmVar2, tnVar, executor2, tjVar2);
                        return null;
                    }
                });
            }
        }
        if (isCompleted) {
            m13687b(toVar, tmVar, this, executor, tjVar);
        }
        return toVar.tk();
    }

    public <TContinuationResult> tn<TContinuationResult> m13695c(final tm<TResult, TContinuationResult> tmVar, Executor executor, final tj tjVar) {
        return m13691a(new tm<TResult, tn<TContinuationResult>>(this) {
            final /* synthetic */ tn axN;

            public /* synthetic */ Object then(tn tnVar) throws Exception {
                return m13680b(tnVar);
            }

            public tn<TContinuationResult> m13680b(tn<TResult> tnVar) {
                if (tjVar != null && tjVar.tb()) {
                    return tn.th();
                }
                if (tnVar.tg()) {
                    return tn.m13686b(tnVar.getError());
                }
                if (tnVar.isCancelled()) {
                    return tn.th();
                }
                return tnVar.m13690a(tmVar);
            }
        }, executor);
    }

    public <TContinuationResult> tn<TContinuationResult> m13693b(tm<TResult, TContinuationResult> tmVar) {
        return m13695c(tmVar, axy, null);
    }

    private static <TContinuationResult, TResult> void m13685a(final to<TContinuationResult> toVar, final tm<TResult, TContinuationResult> tmVar, final tn<TResult> tnVar, Executor executor, final tj tjVar) {
        try {
            executor.execute(new Runnable() {
                public void run() {
                    if (tjVar == null || !tjVar.tb()) {
                        try {
                            toVar.aV(tmVar.then(tnVar));
                            return;
                        } catch (CancellationException e) {
                            toVar.tl();
                            return;
                        } catch (Exception e2) {
                            toVar.m13683d(e2);
                            return;
                        }
                    }
                    toVar.tl();
                }
            });
        } catch (Exception e) {
            toVar.m13683d(new ExecutorException(e));
        }
    }

    private static <TContinuationResult, TResult> void m13687b(final to<TContinuationResult> toVar, final tm<TResult, tn<TContinuationResult>> tmVar, final tn<TResult> tnVar, Executor executor, final tj tjVar) {
        try {
            executor.execute(new Runnable() {

                class C41151 implements tm<TContinuationResult, Void> {
                    final /* synthetic */ C41165 axP;

                    C41151(C41165 c41165) {
                        this.axP = c41165;
                    }

                    public /* synthetic */ Object then(tn tnVar) throws Exception {
                        return m13681a(tnVar);
                    }

                    public Void m13681a(tn<TContinuationResult> tnVar) {
                        if (tjVar != null && tjVar.tb()) {
                            toVar.tl();
                        } else if (tnVar.isCancelled()) {
                            toVar.tl();
                        } else if (tnVar.tg()) {
                            toVar.m13683d(tnVar.getError());
                        } else {
                            toVar.aV(tnVar.getResult());
                        }
                        return null;
                    }
                }

                public void run() {
                    if (tjVar == null || !tjVar.tb()) {
                        try {
                            tn tnVar = (tn) tmVar.then(tnVar);
                            if (tnVar == null) {
                                toVar.aV(null);
                                return;
                            } else {
                                tnVar.m13690a(new C41151(this));
                                return;
                            }
                        } catch (CancellationException e) {
                            toVar.tl();
                            return;
                        } catch (Exception e2) {
                            toVar.m13683d(e2);
                            return;
                        }
                    }
                    toVar.tl();
                }
            });
        } catch (Exception e) {
            toVar.m13683d(new ExecutorException(e));
        }
    }

    private void ti() {
        synchronized (this.lock) {
            for (tm then : this.axE) {
                try {
                    then.then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Throwable e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.axE = null;
        }
    }

    boolean tj() {
        boolean z = true;
        synchronized (this.lock) {
            if (this.axB) {
                z = false;
            } else {
                this.axB = true;
                this.cancelled = true;
                this.lock.notifyAll();
                ti();
            }
        }
        return z;
    }

    boolean aU(TResult tResult) {
        boolean z = true;
        synchronized (this.lock) {
            if (this.axB) {
                z = false;
            } else {
                this.axB = true;
                this.result = tResult;
                this.lock.notifyAll();
                ti();
            }
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m13696c(java.lang.Exception r5) {
        /*
        r4 = this;
        r1 = 1;
        r0 = 0;
        r2 = r4.lock;
        monitor-enter(r2);
        r3 = r4.axB;	 Catch:{ all -> 0x002f }
        if (r3 == 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r2);	 Catch:{ all -> 0x002f }
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = 1;
        r4.axB = r0;	 Catch:{ all -> 0x002f }
        r4.error = r5;	 Catch:{ all -> 0x002f }
        r0 = 0;
        r4.axC = r0;	 Catch:{ all -> 0x002f }
        r0 = r4.lock;	 Catch:{ all -> 0x002f }
        r0.notifyAll();	 Catch:{ all -> 0x002f }
        r4.ti();	 Catch:{ all -> 0x002f }
        r0 = r4.axC;	 Catch:{ all -> 0x002f }
        if (r0 != 0) goto L_0x002c;
    L_0x001f:
        r0 = te();	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x002c;
    L_0x0025:
        r0 = new com.fossil.tp;	 Catch:{ all -> 0x002f }
        r0.<init>(r4);	 Catch:{ all -> 0x002f }
        r4.axD = r0;	 Catch:{ all -> 0x002f }
    L_0x002c:
        monitor-exit(r2);	 Catch:{ all -> 0x002f }
        r0 = r1;
        goto L_0x000a;
    L_0x002f:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x002f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.tn.c(java.lang.Exception):boolean");
    }
}
