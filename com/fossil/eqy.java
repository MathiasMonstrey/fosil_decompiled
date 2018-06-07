package com.fossil;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class eqy implements eqn, eqx {
    volatile boolean dQP;
    List<eqn> dRf;

    public void dispose() {
        if (!this.dQP) {
            synchronized (this) {
                if (this.dQP) {
                    return;
                }
                this.dQP = true;
                List list = this.dRf;
                this.dRf = null;
                aI(list);
            }
        }
    }

    public boolean mo3006a(eqn com_fossil_eqn) {
        era.requireNonNull(com_fossil_eqn, "d is null");
        if (!this.dQP) {
            synchronized (this) {
                if (!this.dQP) {
                    List list = this.dRf;
                    if (list == null) {
                        list = new LinkedList();
                        this.dRf = list;
                    }
                    list.add(com_fossil_eqn);
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
        r1 = r2.dRf;	 Catch:{ all -> 0x0012 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.eqy.c(com.fossil.eqn):boolean");
    }

    void aI(List<eqn> list) {
        if (list != null) {
            Iterable iterable = null;
            for (eqn dispose : list) {
                try {
                    dispose.dispose();
                } catch (Throwable th) {
                    List arrayList;
                    eqp.m11067k(th);
                    if (iterable == null) {
                        arrayList = new ArrayList();
                    } else {
                        Iterable iterable2 = iterable;
                    }
                    arrayList.add(th);
                    iterable = arrayList;
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
