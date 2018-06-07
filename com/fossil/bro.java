package com.fossil;

import java.util.concurrent.atomic.AtomicReference;

final class bro implements Runnable {
    private /* synthetic */ brc bCU;
    private /* synthetic */ AtomicReference bCV;
    private /* synthetic */ boolean bCp;

    bro(brc com_fossil_brc, AtomicReference atomicReference, boolean z) {
        this.bCU = com_fossil_brc;
        this.bCV = atomicReference;
        this.bCp = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r5 = this;
        r1 = r5.bCV;
        monitor-enter(r1);
        r0 = r5.bCU;	 Catch:{ RemoteException -> 0x0046 }
        r0 = r0.bCO;	 Catch:{ RemoteException -> 0x0046 }
        if (r0 != 0) goto L_0x0021;
    L_0x000b:
        r0 = r5.bCU;	 Catch:{ RemoteException -> 0x0046 }
        r0 = r0.Pf();	 Catch:{ RemoteException -> 0x0046 }
        r0 = r0.Rc();	 Catch:{ RemoteException -> 0x0046 }
        r2 = "Failed to get user properties";
        r0.log(r2);	 Catch:{ RemoteException -> 0x0046 }
        r0 = r5.bCV;	 Catch:{ all -> 0x0043 }
        r0.notify();	 Catch:{ all -> 0x0043 }
        monitor-exit(r1);	 Catch:{ all -> 0x0043 }
    L_0x0020:
        return;
    L_0x0021:
        r2 = r5.bCV;	 Catch:{ RemoteException -> 0x0046 }
        r3 = r5.bCU;	 Catch:{ RemoteException -> 0x0046 }
        r3 = r3.OT();	 Catch:{ RemoteException -> 0x0046 }
        r4 = 0;
        r3 = r3.ee(r4);	 Catch:{ RemoteException -> 0x0046 }
        r4 = r5.bCp;	 Catch:{ RemoteException -> 0x0046 }
        r0 = r0.mo1428a(r3, r4);	 Catch:{ RemoteException -> 0x0046 }
        r2.set(r0);	 Catch:{ RemoteException -> 0x0046 }
        r0 = r5.bCU;	 Catch:{ RemoteException -> 0x0046 }
        r0.RX();	 Catch:{ RemoteException -> 0x0046 }
        r0 = r5.bCV;	 Catch:{ all -> 0x0043 }
        r0.notify();	 Catch:{ all -> 0x0043 }
    L_0x0041:
        monitor-exit(r1);	 Catch:{ all -> 0x0043 }
        goto L_0x0020;
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0043 }
        throw r0;
    L_0x0046:
        r0 = move-exception;
        r2 = r5.bCU;	 Catch:{ all -> 0x005c }
        r2 = r2.Pf();	 Catch:{ all -> 0x005c }
        r2 = r2.Rc();	 Catch:{ all -> 0x005c }
        r3 = "Failed to get user properties";
        r2.m5439d(r3, r0);	 Catch:{ all -> 0x005c }
        r0 = r5.bCV;	 Catch:{ all -> 0x0043 }
        r0.notify();	 Catch:{ all -> 0x0043 }
        goto L_0x0041;
    L_0x005c:
        r0 = move-exception;
        r2 = r5.bCV;	 Catch:{ all -> 0x0043 }
        r2.notify();	 Catch:{ all -> 0x0043 }
        throw r0;	 Catch:{ all -> 0x0043 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.bro.run():void");
    }
}
