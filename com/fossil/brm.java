package com.fossil;

import java.util.concurrent.atomic.AtomicReference;

final class brm implements Runnable {
    private /* synthetic */ String bBU;
    private /* synthetic */ brc bCU;
    private /* synthetic */ AtomicReference bCV;
    private /* synthetic */ String bCa;
    private /* synthetic */ String bCb;
    private /* synthetic */ boolean bCp;

    brm(brc com_fossil_brc, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.bCU = com_fossil_brc;
        this.bCV = atomicReference;
        this.bBU = str;
        this.bCa = str2;
        this.bCb = str3;
        this.bCp = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r8 = this;
        r1 = r8.bCV;
        monitor-enter(r1);
        r0 = r8.bCU;	 Catch:{ RemoteException -> 0x0080 }
        r0 = r0.bCO;	 Catch:{ RemoteException -> 0x0080 }
        if (r0 != 0) goto L_0x0034;
    L_0x000b:
        r0 = r8.bCU;	 Catch:{ RemoteException -> 0x0080 }
        r0 = r0.Pf();	 Catch:{ RemoteException -> 0x0080 }
        r0 = r0.Rc();	 Catch:{ RemoteException -> 0x0080 }
        r2 = "Failed to get user properties";
        r3 = r8.bBU;	 Catch:{ RemoteException -> 0x0080 }
        r3 = com.fossil.bol.ei(r3);	 Catch:{ RemoteException -> 0x0080 }
        r4 = r8.bCa;	 Catch:{ RemoteException -> 0x0080 }
        r5 = r8.bCb;	 Catch:{ RemoteException -> 0x0080 }
        r0.m5438a(r2, r3, r4, r5);	 Catch:{ RemoteException -> 0x0080 }
        r0 = r8.bCV;	 Catch:{ RemoteException -> 0x0080 }
        r2 = java.util.Collections.emptyList();	 Catch:{ RemoteException -> 0x0080 }
        r0.set(r2);	 Catch:{ RemoteException -> 0x0080 }
        r0 = r8.bCV;	 Catch:{ all -> 0x006b }
        r0.notify();	 Catch:{ all -> 0x006b }
        monitor-exit(r1);	 Catch:{ all -> 0x006b }
    L_0x0033:
        return;
    L_0x0034:
        r2 = r8.bBU;	 Catch:{ RemoteException -> 0x0080 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ RemoteException -> 0x0080 }
        if (r2 == 0) goto L_0x006e;
    L_0x003c:
        r2 = r8.bCV;	 Catch:{ RemoteException -> 0x0080 }
        r3 = r8.bCa;	 Catch:{ RemoteException -> 0x0080 }
        r4 = r8.bCb;	 Catch:{ RemoteException -> 0x0080 }
        r5 = r8.bCp;	 Catch:{ RemoteException -> 0x0080 }
        r6 = r8.bCU;	 Catch:{ RemoteException -> 0x0080 }
        r6 = r6.OT();	 Catch:{ RemoteException -> 0x0080 }
        r7 = r8.bCU;	 Catch:{ RemoteException -> 0x0080 }
        r7 = r7.Pf();	 Catch:{ RemoteException -> 0x0080 }
        r7 = r7.Rj();	 Catch:{ RemoteException -> 0x0080 }
        r6 = r6.ee(r7);	 Catch:{ RemoteException -> 0x0080 }
        r0 = r0.mo1431a(r3, r4, r5, r6);	 Catch:{ RemoteException -> 0x0080 }
        r2.set(r0);	 Catch:{ RemoteException -> 0x0080 }
    L_0x005f:
        r0 = r8.bCU;	 Catch:{ RemoteException -> 0x0080 }
        r0.RX();	 Catch:{ RemoteException -> 0x0080 }
        r0 = r8.bCV;	 Catch:{ all -> 0x006b }
        r0.notify();	 Catch:{ all -> 0x006b }
    L_0x0069:
        monitor-exit(r1);	 Catch:{ all -> 0x006b }
        goto L_0x0033;
    L_0x006b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x006b }
        throw r0;
    L_0x006e:
        r2 = r8.bCV;	 Catch:{ RemoteException -> 0x0080 }
        r3 = r8.bBU;	 Catch:{ RemoteException -> 0x0080 }
        r4 = r8.bCa;	 Catch:{ RemoteException -> 0x0080 }
        r5 = r8.bCb;	 Catch:{ RemoteException -> 0x0080 }
        r6 = r8.bCp;	 Catch:{ RemoteException -> 0x0080 }
        r0 = r0.mo1430a(r3, r4, r5, r6);	 Catch:{ RemoteException -> 0x0080 }
        r2.set(r0);	 Catch:{ RemoteException -> 0x0080 }
        goto L_0x005f;
    L_0x0080:
        r0 = move-exception;
        r2 = r8.bCU;	 Catch:{ all -> 0x00a7 }
        r2 = r2.Pf();	 Catch:{ all -> 0x00a7 }
        r2 = r2.Rc();	 Catch:{ all -> 0x00a7 }
        r3 = "Failed to get user properties";
        r4 = r8.bBU;	 Catch:{ all -> 0x00a7 }
        r4 = com.fossil.bol.ei(r4);	 Catch:{ all -> 0x00a7 }
        r5 = r8.bCa;	 Catch:{ all -> 0x00a7 }
        r2.m5438a(r3, r4, r5, r0);	 Catch:{ all -> 0x00a7 }
        r0 = r8.bCV;	 Catch:{ all -> 0x00a7 }
        r2 = java.util.Collections.emptyList();	 Catch:{ all -> 0x00a7 }
        r0.set(r2);	 Catch:{ all -> 0x00a7 }
        r0 = r8.bCV;	 Catch:{ all -> 0x006b }
        r0.notify();	 Catch:{ all -> 0x006b }
        goto L_0x0069;
    L_0x00a7:
        r0 = move-exception;
        r2 = r8.bCV;	 Catch:{ all -> 0x006b }
        r2.notify();	 Catch:{ all -> 0x006b }
        throw r0;	 Catch:{ all -> 0x006b }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.brm.run():void");
    }
}
