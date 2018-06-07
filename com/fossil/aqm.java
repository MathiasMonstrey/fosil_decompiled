package com.fossil;

import android.app.Activity;
import android.content.Context;
import com.flurry.sdk.kb;
import com.flurry.sdk.ln;
import com.flurry.sdk.ln.C1542a;
import com.flurry.sdk.lo;
import com.flurry.sdk.lo.C1544a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class aqm {
    private static final String aWR = aqm.class.getSimpleName();
    private static aqm bcg;
    private boolean aWG;
    private final Object aXb = new Object();
    private apk<aqo> aXf = new C18331(this);
    public long aXm = 0;
    private final Map<Context, ln> bch = new WeakHashMap();
    private final aqn bci = new aqn();
    private ln bcj;
    private AtomicBoolean bck = new AtomicBoolean(false);
    private apk<kb> bcl = new C18342(this);

    class C18331 implements apk<aqo> {
        final /* synthetic */ aqm bcm;

        C18331(aqm com_fossil_aqm) {
            this.bcm = com_fossil_aqm;
        }

        public final /* bridge */ /* synthetic */ void mo759a(apj com_fossil_apj) {
            this.bcm.HM();
        }
    }

    class C18342 implements apk<kb> {
        final /* synthetic */ aqm bcm;

        C18342(aqm com_fossil_aqm) {
            this.bcm = com_fossil_aqm;
        }

        public final /* synthetic */ void mo759a(apj com_fossil_apj) {
            kb kbVar = (kb) com_fossil_apj;
            Context context = (Activity) kbVar.baz.get();
            if (context == null) {
                app.m4181w(aqm.aWR, "Activity has been destroyed, can't pass ActivityLifecycleEvent to adobject.");
                return;
            }
            switch (kbVar.f1331b) {
                case kStarted:
                    app.m4180g(3, aqm.aWR, "Automatic onStartSession for context:" + kbVar.baz);
                    this.bcm.m4226X(context);
                    return;
                case kStopped:
                    app.m4180g(3, aqm.aWR, "Automatic onEndSession for context:" + kbVar.baz);
                    this.bcm.m4238d(context);
                    return;
                case kDestroyed:
                    app.m4180g(3, aqm.aWR, "Automatic onEndSession (destroyed) for context:" + kbVar.baz);
                    this.bcm.m4238d(context);
                    return;
                default:
                    return;
            }
        }
    }

    class C18386 extends aqx {
        final /* synthetic */ aqm bcm;

        C18386(aqm com_fossil_aqm) {
            this.bcm = com_fossil_aqm;
        }

        public final void HJ() {
            this.bcm.HM();
        }
    }

    private aqm() {
        apl.IW().m4169a("com.flurry.android.sdk.ActivityLifecycleEvent", this.bcl);
        apl.IW().m4169a("com.flurry.android.sdk.FlurrySessionTimerEvent", this.aXf);
    }

    public static synchronized aqm Jc() {
        aqm com_fossil_aqm;
        synchronized (aqm.class) {
            if (bcg == null) {
                bcg = new aqm();
            }
            com_fossil_aqm = bcg;
        }
        return com_fossil_aqm;
    }

    public final synchronized void m4234a(Context context) {
        if (context instanceof Activity) {
            if (apf.IQ().Ie()) {
                app.m4180g(3, aWR, "bootstrap for context:" + context);
                m4226X(context);
            }
        }
    }

    public final synchronized void m4233W(Context context) {
        m4235b(context, false);
    }

    public final synchronized void m4235b(Context context, boolean z) {
        if (!(apf.IQ().Ie() && (context instanceof Activity))) {
            app.m4180g(3, aWR, "Manual onStartSession for context:" + context);
            m4231c(context, z);
        }
    }

    private synchronized void m4226X(Context context) {
        m4231c(context, false);
    }

    private synchronized void m4231c(final Context context, boolean z) {
        if (Jd() != null && Jd().Ja() && z) {
            if (this.bci.Ja()) {
                app.m4180g(3, aWR, "Returning from a paused background session.");
            } else {
                app.m4180g(3, aWR, "A background session has already started. Not storing in context map because we use application context only.");
            }
        }
        if (Jd() != null && !Jd().Ja() && z) {
            app.m4181w(aWR, "A Flurry background session can't be started while a foreground session is running.");
        } else if (Jd() != null && Jd().Ja() && !z) {
            app.m4181w(aWR, "New session started while background session is running.  Ending background session, then will create foreground session.");
            this.bck.set(true);
            m4232e(apc.IO().baD, true);
            apc.IO().m4160b(new Runnable(this) {
                final /* synthetic */ aqm bcn;

                public final void run() {
                    this.bcn.m4226X(context);
                }
            });
        } else if (((ln) this.bch.get(context)) == null) {
            lo loVar;
            ln lnVar;
            Object obj;
            this.bci.HO();
            ln Jd = Jd();
            if (Jd == null) {
                if (z) {
                    Jd = new aql();
                } else {
                    Jd = new ln();
                }
                Jd.m2791a(C1542a.f1349b);
                app.m4178e(aWR, "Flurry session started for context:" + context);
                loVar = new lo();
                loVar.baz = new WeakReference(context);
                loVar.bce = Jd;
                loVar.f1359c = C1544a.f1353a;
                loVar.HO();
                lnVar = Jd;
                obj = 1;
            } else {
                lnVar = Jd;
                obj = null;
            }
            this.bch.put(context, lnVar);
            synchronized (this.aXb) {
                this.bcj = lnVar;
            }
            this.bck.set(false);
            app.m4178e(aWR, "Flurry session resumed for context:" + context);
            loVar = new lo();
            loVar.baz = new WeakReference(context);
            loVar.bce = lnVar;
            loVar.f1359c = C1544a.f1355c;
            loVar.HO();
            if (obj != null) {
                apc.IO().m4160b(new aqx(this) {
                    final /* synthetic */ aqm bcg;

                    public final void HJ() {
                        lnVar.m2791a(C1542a.f1350c);
                        lo loVar = new lo();
                        loVar.baz = new WeakReference(context);
                        loVar.bce = lnVar;
                        loVar.f1359c = C1544a.f1358f;
                        loVar.HO();
                    }
                });
            }
            this.aXm = 0;
        } else if (apf.IQ().Ie()) {
            app.m4180g(3, aWR, "Session already started with context:" + context);
        } else {
            app.m4178e(aWR, "Session already started with context:" + context);
        }
    }

    public final synchronized void m4236c(Context context) {
        m4239d(context, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m4239d(android.content.Context r5, boolean r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = com.fossil.apf.IQ();	 Catch:{ all -> 0x002b }
        r0 = r0.Ie();	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x0011;
    L_0x000b:
        r0 = r5 instanceof android.app.Activity;	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r4);
        return;
    L_0x0011:
        r0 = r4.Jd();	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x002e;
    L_0x0017:
        r0 = r4.Jd();	 Catch:{ all -> 0x002b }
        r0 = r0.Ja();	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x002e;
    L_0x0021:
        if (r6 == 0) goto L_0x002e;
    L_0x0023:
        r0 = aWR;	 Catch:{ all -> 0x002b }
        r1 = "No background session running, can't end session.";
        com.fossil.app.m4181w(r0, r1);	 Catch:{ all -> 0x002b }
        goto L_0x000f;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x002e:
        if (r6 == 0) goto L_0x0034;
    L_0x0030:
        r0 = r4.aWG;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x000f;
    L_0x0034:
        r0 = 3;
        r1 = aWR;	 Catch:{ all -> 0x002b }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x002b }
        r3 = "Manual onEndSession for context:";
        r2.<init>(r3);	 Catch:{ all -> 0x002b }
        r2 = r2.append(r5);	 Catch:{ all -> 0x002b }
        r2 = r2.toString();	 Catch:{ all -> 0x002b }
        com.fossil.app.m4180g(r0, r1, r2);	 Catch:{ all -> 0x002b }
        r4.m4238d(r5);	 Catch:{ all -> 0x002b }
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.aqm.d(android.content.Context, boolean):void");
    }

    final synchronized void m4238d(Context context) {
        m4232e(context, false);
    }

    private synchronized void m4232e(Context context, boolean z) {
        ln lnVar = (ln) this.bch.remove(context);
        if (z && Jd() != null && Jd().Ja() && this.bci.Ja()) {
            HM();
        } else if (lnVar != null) {
            app.m4178e(aWR, "Flurry session paused for context:" + context);
            lo loVar = new lo();
            loVar.baz = new WeakReference(context);
            loVar.bce = lnVar;
            aon.Il();
            loVar.aYX = aon.In();
            loVar.f1359c = C1544a.f1356d;
            loVar.HO();
            if (HX() == 0) {
                if (z) {
                    HM();
                } else {
                    this.bci.m4240a(lnVar.Jb());
                }
                this.aXm = System.currentTimeMillis();
            } else {
                this.aXm = 0;
            }
        } else if (apf.IQ().Ie()) {
            app.m4180g(3, aWR, "Session cannot be ended, session not found for context:" + context);
        } else {
            app.m4178e(aWR, "Session cannot be ended, session not found for context:" + context);
        }
    }

    private synchronized void HM() {
        int HX = HX();
        if (HX > 0) {
            app.m4180g(5, aWR, "Session cannot be finalized, sessionContextCount:" + HX);
        } else {
            final ln Jd = Jd();
            if (Jd == null) {
                app.m4180g(5, aWR, "Session cannot be finalized, current session not found");
            } else {
                app.m4178e(aWR, "Flurry " + (Jd.Ja() ? "background" : "") + " session ended");
                lo loVar = new lo();
                loVar.bce = Jd;
                loVar.f1359c = C1544a.f1357e;
                aon.Il();
                loVar.aYX = aon.In();
                loVar.HO();
                apc.IO().m4160b(new aqx(this) {
                    final /* synthetic */ aqm bcn;

                    public final void HJ() {
                        aqm.m4229a(this.bcn, Jd);
                        this.bcn.aWG = false;
                    }
                });
            }
        }
    }

    public final synchronized void HO() {
        for (Entry entry : this.bch.entrySet()) {
            lo loVar = new lo();
            loVar.baz = new WeakReference(entry.getKey());
            loVar.bce = (ln) entry.getValue();
            loVar.f1359c = C1544a.f1356d;
            aon.Il();
            loVar.aYX = aon.In();
            loVar.HO();
        }
        this.bch.clear();
        apc.IO().m4160b(new C18386(this));
    }

    private synchronized int HX() {
        return this.bch.size();
    }

    public final synchronized boolean m4237c() {
        boolean z;
        if (Jd() == null) {
            app.m4180g(2, aWR, "Session not found. No active session");
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    public final synchronized int IA() {
        int i;
        if (this.bck.get()) {
            i = C1542a.f1349b;
        } else {
            ln Jd = Jd();
            if (Jd == null) {
                app.m4180g(2, aWR, "Session not found. No active session");
                i = C1542a.f1348a;
            } else {
                i = Jd.HF();
            }
        }
        return i;
    }

    public final ln Jd() {
        ln lnVar;
        synchronized (this.aXb) {
            lnVar = this.bcj;
        }
        return lnVar;
    }

    static /* synthetic */ void m4229a(aqm com_fossil_aqm, ln lnVar) {
        synchronized (com_fossil_aqm.aXb) {
            if (com_fossil_aqm.bcj == lnVar) {
                Object obj = com_fossil_aqm.bcj;
                aqp.Jf().m4243b("ContinueSessionMillis", obj);
                obj.m2791a(C1542a.f1348a);
                com_fossil_aqm.bcj = null;
            }
        }
    }
}
