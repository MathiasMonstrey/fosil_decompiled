package com.fossil;

import java.util.concurrent.atomic.AtomicReference;

final class brl implements Runnable {
    private /* synthetic */ String bBU;
    private /* synthetic */ brc bCU;
    private /* synthetic */ AtomicReference bCV;
    private /* synthetic */ String bCa;
    private /* synthetic */ String bCb;

    brl(brc com_fossil_brc, AtomicReference atomicReference, String str, String str2, String str3) {
        this.bCU = com_fossil_brc;
        this.bCV = atomicReference;
        this.bBU = str;
        this.bCa = str2;
        this.bCb = str3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r7 = this;
        r1 = r7.bCV;
        monitor-enter(r1);
        r0 = r7.bCU;	 Catch:{ RemoteException -> 0x007c }
        r0 = r0.bCO;	 Catch:{ RemoteException -> 0x007c }
        if (r0 != 0) goto L_0x0034;
    L_0x000b:
        r0 = r7.bCU;	 Catch:{ RemoteException -> 0x007c }
        r0 = r0.Pf();	 Catch:{ RemoteException -> 0x007c }
        r0 = r0.Rc();	 Catch:{ RemoteException -> 0x007c }
        r2 = "Failed to get conditional properties";
        r3 = r7.bBU;	 Catch:{ RemoteException -> 0x007c }
        r3 = com.fossil.bol.ei(r3);	 Catch:{ RemoteException -> 0x007c }
        r4 = r7.bCa;	 Catch:{ RemoteException -> 0x007c }
        r5 = r7.bCb;	 Catch:{ RemoteException -> 0x007c }
        r0.m5438a(r2, r3, r4, r5);	 Catch:{ RemoteException -> 0x007c }
        r0 = r7.bCV;	 Catch:{ RemoteException -> 0x007c }
        r2 = java.util.Collections.emptyList();	 Catch:{ RemoteException -> 0x007c }
        r0.set(r2);	 Catch:{ RemoteException -> 0x007c }
        r0 = r7.bCV;	 Catch:{ all -> 0x0069 }
        r0.notify();	 Catch:{ all -> 0x0069 }
        monitor-exit(r1);	 Catch:{ all -> 0x0069 }
    L_0x0033:
        return;
    L_0x0034:
        r2 = r7.bBU;	 Catch:{ RemoteException -> 0x007c }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ RemoteException -> 0x007c }
        if (r2 == 0) goto L_0x006c;
    L_0x003c:
        r2 = r7.bCV;	 Catch:{ RemoteException -> 0x007c }
        r3 = r7.bCa;	 Catch:{ RemoteException -> 0x007c }
        r4 = r7.bCb;	 Catch:{ RemoteException -> 0x007c }
        r5 = r7.bCU;	 Catch:{ RemoteException -> 0x007c }
        r5 = r5.OT();	 Catch:{ RemoteException -> 0x007c }
        r6 = r7.bCU;	 Catch:{ RemoteException -> 0x007c }
        r6 = r6.Pf();	 Catch:{ RemoteException -> 0x007c }
        r6 = r6.Rj();	 Catch:{ RemoteException -> 0x007c }
        r5 = r5.ee(r6);	 Catch:{ RemoteException -> 0x007c }
        r0 = r0.mo1429a(r3, r4, r5);	 Catch:{ RemoteException -> 0x007c }
        r2.set(r0);	 Catch:{ RemoteException -> 0x007c }
    L_0x005d:
        r0 = r7.bCU;	 Catch:{ RemoteException -> 0x007c }
        r0.RX();	 Catch:{ RemoteException -> 0x007c }
        r0 = r7.bCV;	 Catch:{ all -> 0x0069 }
        r0.notify();	 Catch:{ all -> 0x0069 }
    L_0x0067:
        monitor-exit(r1);	 Catch:{ all -> 0x0069 }
        goto L_0x0033;
    L_0x0069:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0069 }
        throw r0;
    L_0x006c:
        r2 = r7.bCV;	 Catch:{ RemoteException -> 0x007c }
        r3 = r7.bBU;	 Catch:{ RemoteException -> 0x007c }
        r4 = r7.bCa;	 Catch:{ RemoteException -> 0x007c }
        r5 = r7.bCb;	 Catch:{ RemoteException -> 0x007c }
        r0 = r0.mo1442g(r3, r4, r5);	 Catch:{ RemoteException -> 0x007c }
        r2.set(r0);	 Catch:{ RemoteException -> 0x007c }
        goto L_0x005d;
    L_0x007c:
        r0 = move-exception;
        r2 = r7.bCU;	 Catch:{ all -> 0x00a3 }
        r2 = r2.Pf();	 Catch:{ all -> 0x00a3 }
        r2 = r2.Rc();	 Catch:{ all -> 0x00a3 }
        r3 = "Failed to get conditional properties";
        r4 = r7.bBU;	 Catch:{ all -> 0x00a3 }
        r4 = com.fossil.bol.ei(r4);	 Catch:{ all -> 0x00a3 }
        r5 = r7.bCa;	 Catch:{ all -> 0x00a3 }
        r2.m5438a(r3, r4, r5, r0);	 Catch:{ all -> 0x00a3 }
        r0 = r7.bCV;	 Catch:{ all -> 0x00a3 }
        r2 = java.util.Collections.emptyList();	 Catch:{ all -> 0x00a3 }
        r0.set(r2);	 Catch:{ all -> 0x00a3 }
        r0 = r7.bCV;	 Catch:{ all -> 0x0069 }
        r0.notify();	 Catch:{ all -> 0x0069 }
        goto L_0x0067;
    L_0x00a3:
        r0 = move-exception;
        r2 = r7.bCV;	 Catch:{ all -> 0x0069 }
        r2.notify();	 Catch:{ all -> 0x0069 }
        throw r0;	 Catch:{ all -> 0x0069 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.brl.run():void");
    }
}
