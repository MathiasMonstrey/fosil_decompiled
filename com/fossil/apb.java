package com.fossil;

import android.os.SystemClock;
import com.flurry.sdk.jx$2;
import com.flurry.sdk.ln;
import com.flurry.sdk.lo;
import com.flurry.sdk.lo.C1544a;
import java.lang.ref.WeakReference;
import java.util.Map;

public class apb {
    private static final String aXl = apb.class.getSimpleName();
    public volatile long aWN = 0;
    private String aXS;
    public volatile long aXv = 0;
    public volatile long aXw = 0;
    public volatile long aYX = -1;
    private volatile long aYo = 0;
    private String aZb;
    private final apk<lo> baA = new C17851(this);
    private Map<String, String> baB;
    WeakReference<ln> baz;

    class C17851 implements apk<lo> {
        final /* synthetic */ apb f1437a;

        C17851(apb com_fossil_apb) {
            this.f1437a = com_fossil_apb;
        }

        public final /* synthetic */ void mo759a(apj com_fossil_apj) {
            lo loVar = (lo) com_fossil_apj;
            if (this.f1437a.baz == null || loVar.bce == this.f1437a.baz.get()) {
                apb com_fossil_apb;
                switch (C17873.f1439a[loVar.f1359c - 1]) {
                    case 1:
                        com_fossil_apb = this.f1437a;
                        ln lnVar = loVar.bce;
                        loVar.baz.get();
                        com_fossil_apb.baz = new WeakReference(lnVar);
                        com_fossil_apb.aXv = System.currentTimeMillis();
                        com_fossil_apb.aXw = SystemClock.elapsedRealtime();
                        apc.IO().m4160b(new C17862(com_fossil_apb));
                        return;
                    case 2:
                        com_fossil_apb = this.f1437a;
                        loVar.baz.get();
                        com_fossil_apb.HJ();
                        return;
                    case 3:
                        com_fossil_apb = this.f1437a;
                        loVar.baz.get();
                        com_fossil_apb.aYX = SystemClock.elapsedRealtime() - com_fossil_apb.aXw;
                        return;
                    case 4:
                        apl.IW().m4170b("com.flurry.android.sdk.FlurrySessionEvent", this.f1437a.baA);
                        apb.HO();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    class C17862 extends aqx {
        final /* synthetic */ apb f1438a;

        C17862(apb com_fossil_apb) {
            this.f1438a = com_fossil_apb;
        }

        public final void HJ() {
            aos.Iy().HK();
        }
    }

    static /* synthetic */ class C17873 {
        static final /* synthetic */ int[] f1439a = new int[C1544a.m2793a().length];

        static {
            try {
                f1439a[C1544a.f1353a - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1439a[C1544a.f1355c - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1439a[C1544a.f1356d - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1439a[C1544a.f1357e - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public apb() {
        apl.IW().m4169a("com.flurry.android.sdk.FlurrySessionEvent", this.baA);
        this.baB = new jx$2(this);
    }

    public final synchronized void HJ() {
        long j = aqm.Jc().aXm;
        if (j > 0) {
            this.aWN = (System.currentTimeMillis() - j) + this.aWN;
        }
    }

    public static void HO() {
    }

    public final synchronized long IL() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.aXw;
        if (elapsedRealtime <= this.aYo) {
            elapsedRealtime = this.aYo + 1;
            this.aYo = elapsedRealtime;
        }
        this.aYo = elapsedRealtime;
        return this.aYo;
    }

    public final synchronized String HT() {
        return this.aZb;
    }

    public final synchronized String IM() {
        return this.aXS;
    }

    public final synchronized Map<String, String> IN() {
        return this.baB;
    }
}
