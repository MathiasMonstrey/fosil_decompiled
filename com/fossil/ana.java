package com.fossil;

import android.content.Context;
import com.flurry.android.FlurryEventRecordStatus;
import com.flurry.sdk.ln;
import com.flurry.sdk.ln.C1542a;
import com.flurry.sdk.lo;
import com.flurry.sdk.lo.C1544a;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ana implements aps {
    private static final String aWX = ana.class.getSimpleName();
    public boolean aWE = false;
    public anu aWY;
    public aoi aWZ;
    public anv aXa;
    private final Object aXb = new Object();
    private Queue<amz> aXc = new LinkedList();
    private Queue<amz> aXd = new LinkedList();
    private Queue<amy> aXe = new LinkedList();
    private final apk<lo> aXf = new C17171(this);

    class C17171 implements apk<lo> {
        final /* synthetic */ ana aXg;

        C17171(ana com_fossil_ana) {
            this.aXg = com_fossil_ana;
        }

        public final /* bridge */ /* synthetic */ void mo759a(apj com_fossil_apj) {
            switch (C17182.f1379a[((lo) com_fossil_apj).f1359c - 1]) {
                case 1:
                    ana.m3950a(this.aXg);
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ class C17182 {
        static final /* synthetic */ int[] f1379a = new int[C1544a.m2793a().length];
        static final /* synthetic */ int[] aXh = new int[C1542a.m2787a().length];

        static {
            try {
                aXh[C1542a.f1348a - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                aXh[C1542a.f1349b - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                aXh[C1542a.f1350c - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1379a[C1544a.f1358f - 1] = 1;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static synchronized ana HD() {
        ana com_fossil_ana;
        synchronized (ana.class) {
            com_fossil_ana = (ana) apc.IO().m4157H(ana.class);
        }
        return com_fossil_ana;
    }

    public void init(Context context) {
        ln.m2789I(aol.class);
        this.aWZ = new aoi();
        this.aWY = new anu();
        this.aXa = new anv();
        apl.IW().m4169a("com.flurry.android.sdk.FlurrySessionEvent", this.aXf);
        if (!aqv.m4255l(context, "android.permission.INTERNET")) {
            app.m4182x(aWX, "Application must declare permission: android.permission.INTERNET");
        }
        if (!aqv.m4255l(context, "android.permission.ACCESS_NETWORK_STATE")) {
            app.m4178e(aWX, "It is highly recommended that the application declare permission: android.permission.ACCESS_NETWORK_STATE");
        }
        int identifier = context.getResources().getIdentifier("FLURRY_IS_YAHOO_APP", "bool", context.getPackageName());
        if (identifier != 0) {
            this.aWE = context.getResources().getBoolean(identifier);
            app.m4183y(aWX, "Found FLURRY_IS_YAHOO_APP resource id. Value: " + this.aWE);
        }
    }

    public static aol HE() {
        ln Jd = aqm.Jc().Jd();
        if (Jd == null) {
            return null;
        }
        return (aol) Jd.m2790K(aol.class);
    }

    public final FlurryEventRecordStatus m3955b(String str, Map<String, String> map, boolean z) {
        return m3953a(str, map, z, 0);
    }

    public final FlurryEventRecordStatus m3953a(String str, Map<String, String> map, boolean z, int i) {
        FlurryEventRecordStatus flurryEventRecordStatus;
        amz com_fossil_amz = new amz(str, map, z, i);
        synchronized (this.aXb) {
            switch (C17182.aXh[HF() - 1]) {
                case 1:
                    app.m4182x(aWX, "Must start a Flurry session before logging event: " + com_fossil_amz.aWB);
                    flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
                    break;
                case 2:
                    app.m4181w(aWX, "Waiting for Flurry session to initialize before logging event: " + com_fossil_amz.aWB);
                    this.aXc.add(com_fossil_amz);
                    flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventLoggingDelayed;
                    break;
                case 3:
                    flurryEventRecordStatus = m3949a(com_fossil_amz);
                    break;
                default:
                    flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
            }
        }
        return flurryEventRecordStatus;
    }

    private static FlurryEventRecordStatus m3949a(amz com_fossil_amz) {
        aol HE = HE();
        FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (HE != null) {
            return HE.m4109a(com_fossil_amz.aWB, com_fossil_amz.aWW, com_fossil_amz.aWM, com_fossil_amz.f1378d);
        }
        return flurryEventRecordStatus;
    }

    private synchronized int HF() {
        return aqm.Jc().IA();
    }

    private static void m3952b(amz com_fossil_amz) {
        aol HE = HE();
        if (HE != null) {
            HE.m4115d(com_fossil_amz.aWB, com_fossil_amz.aWW);
        }
    }

    public final void m3956b(String str, String str2, Throwable th) {
        boolean z = str != null && "uncaught".equals(str);
        m3954a(new amy(str, str2, th.getClass().getName(), th, ara.aT(z)));
    }

    public final void m3954a(amy com_fossil_amy) {
        synchronized (this.aXb) {
            switch (C17182.aXh[HF() - 1]) {
                case 1:
                    app.m4182x(aWX, "Must start a Flurry session before logging error: " + com_fossil_amy.aWB);
                    return;
                case 2:
                    app.m4181w(aWX, "Waiting for Flurry session to initialize before logging error: " + com_fossil_amy.aWB);
                    this.aXe.add(com_fossil_amy);
                    return;
                case 3:
                    m3951b(com_fossil_amy);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m3951b(amy com_fossil_amy) {
        aol HE = HE();
        if (HE != null) {
            HE.m4112a(com_fossil_amy);
        }
    }

    static /* synthetic */ void m3950a(ana com_fossil_ana) {
        app.m4181w(aWX, "Flushing deferred events queues.");
        synchronized (com_fossil_ana.aXb) {
            while (com_fossil_ana.aXc.peek() != null) {
                m3949a((amz) com_fossil_ana.aXc.poll());
            }
            while (com_fossil_ana.aXe.peek() != null) {
                m3951b((amy) com_fossil_ana.aXe.poll());
            }
            while (com_fossil_ana.aXd.peek() != null) {
                m3952b((amz) com_fossil_ana.aXd.poll());
            }
        }
    }
}
