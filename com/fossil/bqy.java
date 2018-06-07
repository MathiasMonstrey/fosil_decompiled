package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement.f;
import com.google.android.gms.measurement.AppMeasurement.g;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class bqy extends bqi {
    private g bCA;
    private long bCB;
    private final Map<Activity, brb> bCC = new jl();
    private final CopyOnWriteArrayList<f> bCD = new CopyOnWriteArrayList();
    private boolean bCE;
    private g bCF;
    private String bCG;
    protected brb bCy;
    private volatile g bCz;

    public bqy(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
    }

    private final void m5543a(Activity activity, brb com_fossil_brb, boolean z) {
        boolean hasNext;
        boolean z2 = true;
        g gVar = this.bCz != null ? this.bCz : (this.bCA == null || Math.abs(super.OX().elapsedRealtime() - this.bCB) >= 1000) ? null : this.bCA;
        gVar = gVar != null ? new g(gVar) : null;
        this.bCE = true;
        try {
            Iterator it = this.bCD.iterator();
            while (true) {
                hasNext = it.hasNext();
                if (!hasNext) {
                    break;
                }
                try {
                    z2 &= ((f) it.next()).a(gVar, com_fossil_brb);
                } catch (Exception e) {
                    super.Pf().Rc().m5439d("onScreenChangeCallback threw exception", e);
                }
            }
            hasNext = z2;
        } catch (Exception e2) {
            Exception exception = e2;
            hasNext = z2;
            z2 = super.Pf().Rc();
            z2.m5439d("onScreenChangeCallback loop threw exception", exception);
        } finally {
            this.bCE = false;
        }
        gVar = this.bCz == null ? this.bCA : this.bCz;
        if (hasNext) {
            if (com_fossil_brb.bJM == null) {
                com_fossil_brb.bJM = ew(activity.getClass().getCanonicalName());
            }
            g com_fossil_brb2 = new brb(com_fossil_brb);
            this.bCA = this.bCz;
            this.bCB = super.OX().elapsedRealtime();
            this.bCz = com_fossil_brb2;
            super.Pe().m5469h(new bqz(this, z, gVar, com_fossil_brb2));
        }
    }

    private final void m5545a(brb com_fossil_brb) {
        super.OQ().m5317S(super.OX().elapsedRealtime());
        if (super.Pd().bi(com_fossil_brb.bCM)) {
            com_fossil_brb.bCM = false;
        }
    }

    public static void m5546a(g gVar, Bundle bundle) {
        if (bundle != null && gVar != null && !bundle.containsKey("_sc")) {
            if (gVar.bJL != null) {
                bundle.putString("_sn", gVar.bJL);
            }
            bundle.putString("_sc", gVar.bJM);
            bundle.putLong("_si", gVar.bJN);
        }
    }

    private static String ew(String str) {
        String[] split = str.split("\\.");
        if (split.length == 0) {
            return str.substring(0, 36);
        }
        String str2 = split[split.length - 1];
        return str2.length() > 36 ? str2.substring(0, 36) : str2;
    }

    public final /* bridge */ /* synthetic */ void OM() {
        super.OM();
    }

    public final /* bridge */ /* synthetic */ void ON() {
        super.ON();
    }

    public final /* bridge */ /* synthetic */ void OO() {
        super.OO();
    }

    public final /* bridge */ /* synthetic */ void OP() {
        super.OP();
    }

    public final /* bridge */ /* synthetic */ bnc OQ() {
        return super.OQ();
    }

    public final /* bridge */ /* synthetic */ bnj OR() {
        return super.OR();
    }

    public final /* bridge */ /* synthetic */ bqk OS() {
        return super.OS();
    }

    public final /* bridge */ /* synthetic */ bog OT() {
        return super.OT();
    }

    public final /* bridge */ /* synthetic */ bnt OU() {
        return super.OU();
    }

    public final /* bridge */ /* synthetic */ brc OV() {
        return super.OV();
    }

    public final /* bridge */ /* synthetic */ bqy OW() {
        return super.OW();
    }

    public final /* bridge */ /* synthetic */ axm OX() {
        return super.OX();
    }

    public final /* bridge */ /* synthetic */ boh OY() {
        return super.OY();
    }

    public final /* bridge */ /* synthetic */ bnn OZ() {
        return super.OZ();
    }

    protected final void PH() {
    }

    public final /* bridge */ /* synthetic */ boj Pa() {
        return super.Pa();
    }

    public final /* bridge */ /* synthetic */ bsk Pb() {
        return super.Pb();
    }

    public final /* bridge */ /* synthetic */ bpf Pc() {
        return super.Pc();
    }

    public final /* bridge */ /* synthetic */ brz Pd() {
        return super.Pd();
    }

    public final /* bridge */ /* synthetic */ bpg Pe() {
        return super.Pe();
    }

    public final /* bridge */ /* synthetic */ bol Pf() {
        return super.Pf();
    }

    public final /* bridge */ /* synthetic */ bow Pg() {
        return super.Pg();
    }

    public final /* bridge */ /* synthetic */ bnm Ph() {
        return super.Ph();
    }

    public final brb RT() {
        RA();
        super.OP();
        return this.bCy;
    }

    public final g RU() {
        super.ON();
        g gVar = this.bCz;
        return gVar == null ? null : new g(gVar);
    }

    public final void m5547a(String str, g gVar) {
        super.OP();
        synchronized (this) {
            if (this.bCG == null || this.bCG.equals(str) || gVar != null) {
                this.bCG = str;
                this.bCF = gVar;
            }
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final void onActivityDestroyed(Activity activity) {
        this.bCC.remove(activity);
    }

    public final void onActivityPaused(Activity activity) {
        brb y = m5548y(activity);
        this.bCA = this.bCz;
        this.bCB = super.OX().elapsedRealtime();
        this.bCz = null;
        super.Pe().m5469h(new bra(this, y));
    }

    public final void onActivityResumed(Activity activity) {
        m5543a(activity, m5548y(activity), false);
        super.OQ().OL();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (bundle != null) {
            brb com_fossil_brb = (brb) this.bCC.get(activity);
            if (com_fossil_brb != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("id", com_fossil_brb.bJN);
                bundle2.putString("name", com_fossil_brb.bJL);
                bundle2.putString("referrer_name", com_fossil_brb.bJM);
                bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
            }
        }
    }

    public final void registerOnScreenChangeCallback(f fVar) {
        super.ON();
        if (fVar == null) {
            super.Pf().Re().log("Attempting to register null OnScreenChangeCallback");
            return;
        }
        this.bCD.remove(fVar);
        this.bCD.add(fVar);
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (activity == null) {
            super.Pf().Re().log("setCurrentScreen must be called with a non-null activity");
            return;
        }
        super.Pe();
        if (!bpg.LM()) {
            super.Pf().Re().log("setCurrentScreen must be called from the main thread");
        } else if (this.bCE) {
            super.Pf().Re().log("Cannot call setCurrentScreen from onScreenChangeCallback");
        } else if (this.bCz == null) {
            super.Pf().Re().log("setCurrentScreen cannot be called while no activity active");
        } else if (this.bCC.get(activity) == null) {
            super.Pf().Re().log("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = ew(activity.getClass().getCanonicalName());
            }
            boolean equals = this.bCz.bJM.equals(str2);
            boolean ae = bsk.ae(this.bCz.bJL, str);
            if (equals && ae) {
                super.Pf().Rf().log("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > bnm.PN())) {
                super.Pf().Re().m5439d("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= bnm.PN())) {
                Object obj;
                bon Ri = super.Pf().Ri();
                String str3 = "Setting current screen to name, class";
                if (str == null) {
                    obj = "null";
                } else {
                    String str4 = str;
                }
                Ri.m5437a(str3, obj, str2);
                brb com_fossil_brb = new brb(str, str2, super.Pb().Si());
                this.bCC.put(activity, com_fossil_brb);
                m5543a(activity, com_fossil_brb, true);
            } else {
                super.Pf().Re().m5439d("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final void unregisterOnScreenChangeCallback(f fVar) {
        super.ON();
        this.bCD.remove(fVar);
    }

    final brb m5548y(Activity activity) {
        awa.bO(activity);
        brb com_fossil_brb = (brb) this.bCC.get(activity);
        if (com_fossil_brb != null) {
            return com_fossil_brb;
        }
        com_fossil_brb = new brb(null, ew(activity.getClass().getCanonicalName()), super.Pb().Si());
        this.bCC.put(activity, com_fossil_brb);
        return com_fossil_brb;
    }
}
