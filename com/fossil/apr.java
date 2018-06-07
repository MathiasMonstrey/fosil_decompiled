package com.fossil;

import android.content.Context;
import android.os.Build.VERSION;
import com.flurry.sdk.kp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class apr {
    private static final String aWB = apr.class.getSimpleName();
    private static final Map<Class<? extends aps>, apq> aWW = new LinkedHashMap();
    private static List<String> aYP;
    private static List<aps> bbk = new ArrayList();
    private final Map<Class<? extends aps>, aps> bbj = new LinkedHashMap();

    static {
        List arrayList = new ArrayList();
        aYP = arrayList;
        arrayList.add("com.flurry.android.marketing.FlurryMarketingModule");
        aYP.add("com.flurry.android.config.killswitch.FlurryKillSwitchModule");
    }

    public static void m4184I(Class<? extends aps> cls) {
        if (cls != null) {
            synchronized (aWW) {
                aWW.put(cls, new apq(cls));
            }
        }
    }

    public final synchronized void m4186a(Context context) {
        if (context == null) {
            app.m4180g(5, aWB, "Null context.");
        } else {
            aps com_fossil_aps;
            synchronized (aWW) {
                List<apq> arrayList = new ArrayList(aWW.values());
            }
            for (apq com_fossil_apq : arrayList) {
                try {
                    Object obj;
                    if (com_fossil_apq.bbi == null || VERSION.SDK_INT < com_fossil_apq.f1447b) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        com_fossil_aps = (aps) com_fossil_apq.bbi.newInstance();
                        com_fossil_aps.init(context);
                        this.bbj.put(com_fossil_apq.bbi, com_fossil_aps);
                    }
                } catch (Throwable e) {
                    app.m4174b(5, aWB, "Flurry Module for class " + com_fossil_apq.bbi + " is not available:", e);
                }
            }
            for (aps com_fossil_aps2 : bbk) {
                try {
                    com_fossil_aps2.init(context);
                } catch (kp e2) {
                    app.m4182x(aWB, e2.getMessage());
                }
            }
            aqm.Jc().m4234a(context);
            apf.IQ();
        }
    }

    public final aps m4185J(Class<? extends aps> cls) {
        if (cls == null) {
            return null;
        }
        synchronized (this.bbj) {
            aps com_fossil_aps = (aps) this.bbj.get(cls);
        }
        if (com_fossil_aps != null) {
            return com_fossil_aps;
        }
        throw new IllegalStateException("Module was not registered/initialized. " + cls);
    }
}
