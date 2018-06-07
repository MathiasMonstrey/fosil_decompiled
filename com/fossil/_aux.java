package com.fossil;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class aux implements Callback {
    private final Object Am = new Object();
    private final auy bhc;
    private final ArrayList<C1898b> bhd = new ArrayList();
    private ArrayList<C1898b> bhe = new ArrayList();
    private final ArrayList<C1899c> bhf = new ArrayList();
    private volatile boolean bhg = false;
    private final AtomicInteger bhh = new AtomicInteger(0);
    private boolean bhi = false;
    private final Handler mHandler;

    public aux(Looper looper, auy com_fossil_auy) {
        this.bhc = com_fossil_auy;
        this.mHandler = new Handler(looper, this);
    }

    public final void KR() {
        this.bhg = false;
        this.bhh.incrementAndGet();
    }

    public final void KS() {
        this.bhg = true;
    }

    public final void m4575a(C1898b c1898b) {
        awa.bO(c1898b);
        synchronized (this.Am) {
            if (this.bhd.contains(c1898b)) {
                String valueOf = String.valueOf(c1898b);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.bhd.add(c1898b);
            }
        }
        if (this.bhc.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, c1898b));
        }
    }

    public final void m4576a(C1899c c1899c) {
        awa.bO(c1899c);
        synchronized (this.Am) {
            if (this.bhf.contains(c1899c)) {
                String valueOf = String.valueOf(c1899c);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.bhf.add(c1899c);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m4577b(com.fossil.atn r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.os.Looper.myLooper();
        r3 = r7.mHandler;
        r3 = r3.getLooper();
        if (r0 != r3) goto L_0x0047;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r3 = "onConnectionFailure must only be called on the Handler thread";
        com.fossil.awa.m4634a(r0, r3);
        r0 = r7.mHandler;
        r0.removeMessages(r1);
        r3 = r7.Am;
        monitor-enter(r3);
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0055 }
        r1 = r7.bhf;	 Catch:{ all -> 0x0055 }
        r0.<init>(r1);	 Catch:{ all -> 0x0055 }
        r1 = r7.bhh;	 Catch:{ all -> 0x0055 }
        r4 = r1.get();	 Catch:{ all -> 0x0055 }
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x0055 }
        r5 = r0.size();	 Catch:{ all -> 0x0055 }
    L_0x002f:
        if (r2 >= r5) goto L_0x0058;
    L_0x0031:
        r1 = r0.get(r2);	 Catch:{ all -> 0x0055 }
        r2 = r2 + 1;
        r1 = (com.fossil.atv.C1899c) r1;	 Catch:{ all -> 0x0055 }
        r6 = r7.bhg;	 Catch:{ all -> 0x0055 }
        if (r6 == 0) goto L_0x0045;
    L_0x003d:
        r6 = r7.bhh;	 Catch:{ all -> 0x0055 }
        r6 = r6.get();	 Catch:{ all -> 0x0055 }
        if (r6 == r4) goto L_0x0049;
    L_0x0045:
        monitor-exit(r3);	 Catch:{ all -> 0x0055 }
    L_0x0046:
        return;
    L_0x0047:
        r0 = r2;
        goto L_0x000f;
    L_0x0049:
        r6 = r7.bhf;	 Catch:{ all -> 0x0055 }
        r6 = r6.contains(r1);	 Catch:{ all -> 0x0055 }
        if (r6 == 0) goto L_0x002f;
    L_0x0051:
        r1.mo1273a(r8);	 Catch:{ all -> 0x0055 }
        goto L_0x002f;
    L_0x0055:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0055 }
        throw r0;
    L_0x0058:
        monitor-exit(r3);	 Catch:{ all -> 0x0055 }
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.aux.b(com.fossil.atn):void");
    }

    public final void m4578b(C1899c c1899c) {
        awa.bO(c1899c);
        synchronized (this.Am) {
            if (!this.bhf.remove(c1899c)) {
                String valueOf = String.valueOf(c1899c);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            C1898b c1898b = (C1898b) message.obj;
            synchronized (this.Am) {
                if (this.bhg && this.bhc.isConnected() && this.bhd.contains(c1898b)) {
                    c1898b.mo1284l(this.bhc.KT());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }

    public final void hx(int i) {
        int i2 = 0;
        awa.m4634a(Looper.myLooper() == this.mHandler.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.Am) {
            this.bhi = true;
            ArrayList arrayList = new ArrayList(this.bhd);
            int i3 = this.bhh.get();
            arrayList = arrayList;
            int size = arrayList.size();
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                C1898b c1898b = (C1898b) obj;
                if (this.bhg && this.bhh.get() == i3) {
                    if (this.bhd.contains(c1898b)) {
                        c1898b.hr(i);
                    }
                }
            }
            this.bhe.clear();
            this.bhi = false;
        }
    }

    public final void m4579m(Bundle bundle) {
        boolean z = true;
        int i = 0;
        awa.m4634a(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.Am) {
            awa.aX(!this.bhi);
            this.mHandler.removeMessages(1);
            this.bhi = true;
            if (this.bhe.size() != 0) {
                z = false;
            }
            awa.aX(z);
            ArrayList arrayList = new ArrayList(this.bhd);
            int i2 = this.bhh.get();
            arrayList = arrayList;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                C1898b c1898b = (C1898b) obj;
                if (this.bhg && this.bhc.isConnected() && this.bhh.get() == i2) {
                    if (!this.bhe.contains(c1898b)) {
                        c1898b.mo1284l(bundle);
                    }
                }
            }
            this.bhe.clear();
            this.bhi = false;
        }
    }
}
