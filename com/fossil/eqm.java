package com.fossil;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.List;

public final class eqm implements eqn, eqx {
    volatile boolean dQP;
    erq<eqn> dRb;

    public void dispose() {
        if (!this.dQP) {
            synchronized (this) {
                if (this.dQP) {
                    return;
                }
                this.dQP = true;
                erq com_fossil_erq = this.dRb;
                this.dRb = null;
                m11061a(com_fossil_erq);
            }
        }
    }

    public boolean isDisposed() {
        return this.dQP;
    }

    public boolean mo3006a(eqn com_fossil_eqn) {
        era.requireNonNull(com_fossil_eqn, "d is null");
        if (!this.dQP) {
            synchronized (this) {
                if (!this.dQP) {
                    erq com_fossil_erq = this.dRb;
                    if (com_fossil_erq == null) {
                        com_fossil_erq = new erq();
                        this.dRb = com_fossil_erq;
                    }
                    com_fossil_erq.add(com_fossil_eqn);
                    return true;
                }
            }
        }
        com_fossil_eqn.dispose();
        return false;
    }

    public boolean mo3007b(eqn com_fossil_eqn) {
        if (!mo3008c(com_fossil_eqn)) {
            return false;
        }
        com_fossil_eqn.dispose();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo3008c(com.fossil.eqn r3) {
        /*
        r2 = this;
        r0 = 0;
        r1 = "Disposable item is null";
        com.fossil.era.requireNonNull(r3, r1);
        r1 = r2.dQP;
        if (r1 == 0) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        monitor-enter(r2);
        r1 = r2.dQP;	 Catch:{ all -> 0x0012 }
        if (r1 == 0) goto L_0x0015;
    L_0x0010:
        monitor-exit(r2);	 Catch:{ all -> 0x0012 }
        goto L_0x000a;
    L_0x0012:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0012 }
        throw r0;
    L_0x0015:
        r1 = r2.dRb;	 Catch:{ all -> 0x0012 }
        if (r1 == 0) goto L_0x001f;
    L_0x0019:
        r1 = r1.remove(r3);	 Catch:{ all -> 0x0012 }
        if (r1 != 0) goto L_0x0021;
    L_0x001f:
        monitor-exit(r2);	 Catch:{ all -> 0x0012 }
        goto L_0x000a;
    L_0x0021:
        monitor-exit(r2);	 Catch:{ all -> 0x0012 }
        r0 = 1;
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.eqm.c(com.fossil.eqn):boolean");
    }

    void m11061a(erq<eqn> com_fossil_erq_com_fossil_eqn) {
        if (com_fossil_erq_com_fossil_eqn != null) {
            Iterable iterable = null;
            for (Object obj : com_fossil_erq_com_fossil_eqn.aGU()) {
                if (obj instanceof eqn) {
                    try {
                        ((eqn) obj).dispose();
                    } catch (Throwable th) {
                        List arrayList;
                        Throwable th2 = th;
                        eqp.m11067k(th2);
                        if (iterable == null) {
                            arrayList = new ArrayList();
                        } else {
                            Iterable iterable2 = iterable;
                        }
                        arrayList.add(th2);
                        Object obj2 = arrayList;
                    }
                }
            }
            if (iterable == null) {
                return;
            }
            if (iterable.size() == 1) {
                throw ExceptionHelper.m((Throwable) iterable.get(0));
            }
            throw new CompositeException(iterable);
        }
    }
}
