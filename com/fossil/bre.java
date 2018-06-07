package com.fossil;

import java.util.concurrent.atomic.AtomicReference;

final class bre implements Runnable {
    private /* synthetic */ brc bCU;
    private /* synthetic */ AtomicReference bCV;

    bre(brc com_fossil_brc, AtomicReference atomicReference) {
        this.bCU = com_fossil_brc;
        this.bCV = atomicReference;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r5 = this;
        r1 = r5.bCV;
        monitor-enter(r1);
        r0 = r5.bCU;	 Catch:{ RemoteException -> 0x0062 }
        r0 = r0.bCO;	 Catch:{ RemoteException -> 0x0062 }
        if (r0 != 0) goto L_0x0021;
    L_0x000b:
        r0 = r5.bCU;	 Catch:{ RemoteException -> 0x0062 }
        r0 = r0.Pf();	 Catch:{ RemoteException -> 0x0062 }
        r0 = r0.Rc();	 Catch:{ RemoteException -> 0x0062 }
        r2 = "Failed to get app instance id";
        r0.log(r2);	 Catch:{ RemoteException -> 0x0062 }
        r0 = r5.bCV;	 Catch:{ all -> 0x005f }
        r0.notify();	 Catch:{ all -> 0x005f }
        monitor-exit(r1);	 Catch:{ all -> 0x005f }
    L_0x0020:
        return;
    L_0x0021:
        r2 = r5.bCV;	 Catch:{ RemoteException -> 0x0062 }
        r3 = r5.bCU;	 Catch:{ RemoteException -> 0x0062 }
        r3 = r3.OT();	 Catch:{ RemoteException -> 0x0062 }
        r4 = 0;
        r3 = r3.ee(r4);	 Catch:{ RemoteException -> 0x0062 }
        r0 = r0.mo1441c(r3);	 Catch:{ RemoteException -> 0x0062 }
        r2.set(r0);	 Catch:{ RemoteException -> 0x0062 }
        r0 = r5.bCV;	 Catch:{ RemoteException -> 0x0062 }
        r0 = r0.get();	 Catch:{ RemoteException -> 0x0062 }
        r0 = (java.lang.String) r0;	 Catch:{ RemoteException -> 0x0062 }
        if (r0 == 0) goto L_0x0053;
    L_0x003f:
        r2 = r5.bCU;	 Catch:{ RemoteException -> 0x0062 }
        r2 = r2.OS();	 Catch:{ RemoteException -> 0x0062 }
        r2.en(r0);	 Catch:{ RemoteException -> 0x0062 }
        r2 = r5.bCU;	 Catch:{ RemoteException -> 0x0062 }
        r2 = r2.Pg();	 Catch:{ RemoteException -> 0x0062 }
        r2 = r2.bAd;	 Catch:{ RemoteException -> 0x0062 }
        r2.eo(r0);	 Catch:{ RemoteException -> 0x0062 }
    L_0x0053:
        r0 = r5.bCU;	 Catch:{ RemoteException -> 0x0062 }
        r0.RX();	 Catch:{ RemoteException -> 0x0062 }
        r0 = r5.bCV;	 Catch:{ all -> 0x005f }
        r0.notify();	 Catch:{ all -> 0x005f }
    L_0x005d:
        monitor-exit(r1);	 Catch:{ all -> 0x005f }
        goto L_0x0020;
    L_0x005f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005f }
        throw r0;
    L_0x0062:
        r0 = move-exception;
        r2 = r5.bCU;	 Catch:{ all -> 0x0078 }
        r2 = r2.Pf();	 Catch:{ all -> 0x0078 }
        r2 = r2.Rc();	 Catch:{ all -> 0x0078 }
        r3 = "Failed to get app instance id";
        r2.m5439d(r3, r0);	 Catch:{ all -> 0x0078 }
        r0 = r5.bCV;	 Catch:{ all -> 0x005f }
        r0.notify();	 Catch:{ all -> 0x005f }
        goto L_0x005d;
    L_0x0078:
        r0 = move-exception;
        r2 = r5.bCV;	 Catch:{ all -> 0x005f }
        r2.notify();	 Catch:{ all -> 0x005f }
        throw r0;	 Catch:{ all -> 0x005f }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.bre.run():void");
    }
}
