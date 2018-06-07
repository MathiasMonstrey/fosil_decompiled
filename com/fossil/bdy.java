package com.fossil;

import android.os.Looper;
import android.util.Log;
import com.fossil.atw.C1900a;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class bdy<R extends atz> extends atw<R> {
    static final ThreadLocal<Boolean> brD = new bdz();
    private final Object brE;
    private bea<R> brF;
    private WeakReference<atv> brG;
    private final CountDownLatch brH;
    private final ArrayList<C1900a> brI;
    private aua<? super R> brJ;
    private final AtomicReference<bhi> brK;
    private R brL;
    private beb brM;
    private volatile boolean brN;
    private boolean brO;
    private boolean brP;
    private avj brQ;
    private volatile bhd<R> brR;
    private boolean brS;
    private Status mStatus;

    @Deprecated
    bdy() {
        this.brE = new Object();
        this.brH = new CountDownLatch(1);
        this.brI = new ArrayList();
        this.brK = new AtomicReference();
        this.brS = false;
        this.brF = new bea(Looper.getMainLooper());
        this.brG = new WeakReference(null);
    }

    protected bdy(atv com_fossil_atv) {
        this.brE = new Object();
        this.brH = new CountDownLatch(1);
        this.brI = new ArrayList();
        this.brK = new AtomicReference();
        this.brS = false;
        this.brF = new bea(com_fossil_atv != null ? com_fossil_atv.getLooper() : Looper.getMainLooper());
        this.brG = new WeakReference(com_fossil_atv);
    }

    private final R Nj() {
        R r;
        boolean z = true;
        synchronized (this.brE) {
            if (this.brN) {
                z = false;
            }
            awa.m4634a(z, "Result has already been consumed.");
            awa.m4634a(ij(), "Result is not ready.");
            r = this.brL;
            this.brL = null;
            this.brJ = null;
            this.brN = true;
        }
        bhi com_fossil_bhi = (bhi) this.brK.getAndSet(null);
        if (com_fossil_bhi != null) {
            com_fossil_bhi.mo1349c(this);
        }
        return r;
    }

    private final void m4399e(R r) {
        this.brL = r;
        this.brQ = null;
        this.brH.countDown();
        this.mStatus = this.brL.Ka();
        if (this.brO) {
            this.brJ = null;
        } else if (this.brJ != null) {
            this.brF.removeMessages(2);
            this.brF.m4919a(this.brJ, Nj());
        } else if (this.brL instanceof atx) {
            this.brM = new beb();
        }
        ArrayList arrayList = this.brI;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((C1900a) obj).mo1302d(this.mStatus);
        }
        this.brI.clear();
    }

    public static void m4400f(atz com_fossil_atz) {
        if (com_fossil_atz instanceof atx) {
            try {
                ((atx) com_fossil_atz).release();
            } catch (Throwable e) {
                String valueOf = String.valueOf(com_fossil_atz);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    public final Integer KJ() {
        return null;
    }

    public final boolean Nh() {
        boolean isCanceled;
        synchronized (this.brE) {
            if (((atv) this.brG.get()) == null || !this.brS) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void Ni() {
        boolean z = this.brS || ((Boolean) brD.get()).booleanValue();
        this.brS = z;
    }

    public final R mo1167a(long j, TimeUnit timeUnit) {
        boolean z = true;
        boolean z2 = j <= 0 || Looper.myLooper() != Looper.getMainLooper();
        awa.m4634a(z2, "await must not be called on the UI thread when time is greater than zero.");
        awa.m4634a(!this.brN, "Result has already been consumed.");
        if (this.brR != null) {
            z = false;
        }
        awa.m4634a(z, "Cannot await if then() has been called.");
        try {
            if (!this.brH.await(j, timeUnit)) {
                m4407j(Status.bgz);
            }
        } catch (InterruptedException e) {
            m4407j(Status.bgx);
        }
        awa.m4634a(ij(), "Result is not ready.");
        return Nj();
    }

    public final void mo1168a(C1900a c1900a) {
        awa.m4637b(c1900a != null, "Callback cannot be null.");
        synchronized (this.brE) {
            if (ij()) {
                c1900a.mo1302d(this.mStatus);
            } else {
                this.brI.add(c1900a);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo1169a(com.fossil.aua<? super R> r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r3 = r5.brE;
        monitor-enter(r3);
        if (r6 != 0) goto L_0x000c;
    L_0x0007:
        r0 = 0;
        r5.brJ = r0;	 Catch:{ all -> 0x0027 }
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
    L_0x000b:
        return;
    L_0x000c:
        r2 = r5.brN;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002a;
    L_0x0010:
        r2 = r0;
    L_0x0011:
        r4 = "Result has already been consumed.";
        com.fossil.awa.m4634a(r2, r4);	 Catch:{ all -> 0x0027 }
        r2 = r5.brR;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002c;
    L_0x001a:
        r1 = "Cannot set callbacks if then() has been called.";
        com.fossil.awa.m4634a(r0, r1);	 Catch:{ all -> 0x0027 }
        r0 = r5.isCanceled();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x002e;
    L_0x0025:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r2 = r1;
        goto L_0x0011;
    L_0x002c:
        r0 = r1;
        goto L_0x001a;
    L_0x002e:
        r0 = r5.ij();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x003f;
    L_0x0034:
        r0 = r5.brF;	 Catch:{ all -> 0x0027 }
        r1 = r5.Nj();	 Catch:{ all -> 0x0027 }
        r0.m4919a(r6, r1);	 Catch:{ all -> 0x0027 }
    L_0x003d:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x003f:
        r5.brJ = r6;	 Catch:{ all -> 0x0027 }
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.bdy.a(com.fossil.aua):void");
    }

    public final void m4404a(bhi com_fossil_bhi) {
        this.brK.set(com_fossil_bhi);
    }

    protected abstract R mo1172c(Status status);

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
        r2 = this;
        r1 = r2.brE;
        monitor-enter(r1);
        r0 = r2.brO;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.brN;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.brQ;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r2.brQ;	 Catch:{ RemoteException -> 0x002c }
        r0.cancel();	 Catch:{ RemoteException -> 0x002c }
    L_0x0016:
        r0 = r2.brL;	 Catch:{ all -> 0x0029 }
        m4400f(r0);	 Catch:{ all -> 0x0029 }
        r0 = 1;
        r2.brO = r0;	 Catch:{ all -> 0x0029 }
        r0 = com.google.android.gms.common.api.Status.bgA;	 Catch:{ all -> 0x0029 }
        r0 = r2.mo1172c(r0);	 Catch:{ all -> 0x0029 }
        r2.m4399e(r0);	 Catch:{ all -> 0x0029 }
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        goto L_0x000c;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.bdy.cancel():void");
    }

    public final void m4406d(R r) {
        boolean z = true;
        synchronized (this.brE) {
            if (this.brP || this.brO) {
                m4400f(r);
                return;
            }
            if (ij()) {
            }
            awa.m4634a(!ij(), "Results have already been set");
            if (this.brN) {
                z = false;
            }
            awa.m4634a(z, "Result has already been consumed");
            m4399e(r);
        }
    }

    public final boolean ij() {
        return this.brH.getCount() == 0;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.brE) {
            z = this.brO;
        }
        return z;
    }

    public final void m4407j(Status status) {
        synchronized (this.brE) {
            if (!ij()) {
                m4406d(mo1172c(status));
                this.brP = true;
            }
        }
    }
}
