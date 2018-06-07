package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.fossil.emk.C1565b;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class emm {
    static volatile emm dMS;
    static final emu dMT = new eml();
    private AtomicBoolean aIb = new AtomicBoolean(false);
    private final IdManager aId;
    private final ExecutorService aIj;
    private final Handler ayQ;
    private final Context context;
    private final Map<Class<? extends emr>, emr> dMU;
    private final emp<emm> dMV;
    private final emp<?> dMW;
    private emk dMX;
    private WeakReference<Activity> dMY;
    final emu dMZ;
    final boolean dNa;

    class C34621 extends C1565b {
        final /* synthetic */ emm dNb;

        C34621(emm com_fossil_emm) {
            this.dNb = com_fossil_emm;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            this.dNb.m10907C(activity);
        }

        public void onActivityStarted(Activity activity) {
            this.dNb.m10907C(activity);
        }

        public void onActivityResumed(Activity activity) {
            this.dNb.m10907C(activity);
        }
    }

    public static class C3464a {
        private final Context context;
        private emp<emm> dMV;
        private emu dMZ;
        private boolean dNa;
        private emr[] dNd;
        private eny dNe;
        private String dNf;
        private String dNg;
        private Handler handler;

        public C3464a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.context = context.getApplicationContext();
        }

        public C3464a m10899a(emr... com_fossil_emrArr) {
            if (this.dNd != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.dNd = com_fossil_emrArr;
            return this;
        }

        public C3464a dI(boolean z) {
            this.dNa = z;
            return this;
        }

        public emm aEW() {
            Map hashMap;
            if (this.dNe == null) {
                this.dNe = eny.aFK();
            }
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            if (this.dMZ == null) {
                if (this.dNa) {
                    this.dMZ = new eml(3);
                } else {
                    this.dMZ = new eml();
                }
            }
            if (this.dNg == null) {
                this.dNg = this.context.getPackageName();
            }
            if (this.dMV == null) {
                this.dMV = emp.dNk;
            }
            if (this.dNd == null) {
                hashMap = new HashMap();
            } else {
                hashMap = emm.m10905l(Arrays.asList(this.dNd));
            }
            return new emm(this.context, hashMap, this.dNe, this.handler, this.dMZ, this.dNa, this.dMV, new IdManager(this.context, this.dNg, this.dNf, hashMap.values()));
        }
    }

    static emm aER() {
        if (dMS != null) {
            return dMS;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    emm(Context context, Map<Class<? extends emr>, emr> map, eny com_fossil_eny, Handler handler, emu com_fossil_emu, boolean z, emp com_fossil_emp, IdManager idManager) {
        this.context = context;
        this.dMU = map;
        this.aIj = com_fossil_eny;
        this.ayQ = handler;
        this.dMZ = com_fossil_emu;
        this.dNa = z;
        this.dMV = com_fossil_emp;
        this.dMW = pb(map.size());
        this.aId = idManager;
    }

    public static emm m10900a(emm com_fossil_emm) {
        if (dMS == null) {
            synchronized (emm.class) {
                if (dMS == null) {
                    m10901b(com_fossil_emm);
                }
            }
        }
        return dMS;
    }

    private static void m10901b(emm com_fossil_emm) {
        dMS = com_fossil_emm;
        com_fossil_emm.init();
    }

    public emm m10907C(Activity activity) {
        this.dMY = new WeakReference(activity);
        return this;
    }

    public Activity getCurrentActivity() {
        if (this.dMY != null) {
            return (Activity) this.dMY.get();
        }
        return null;
    }

    private void init() {
        m10907C(en(this.context));
        this.dMX = new emk(this.context);
        this.dMX.m10876a(new C34621(this));
        em(this.context);
    }

    public String getVersion() {
        return "1.3.4.60";
    }

    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    void em(Context context) {
        StringBuilder append;
        Future eo = eo(context);
        Collection xb = xb();
        emv com_fossil_emv = new emv(eo, xb);
        List<emr> arrayList = new ArrayList(xb);
        Collections.sort(arrayList);
        com_fossil_emv.m2870a(context, this, emp.dNk, this.aId);
        for (emr a : arrayList) {
            a.m2870a(context, this, this.dMW, this.aId);
        }
        com_fossil_emv.initialize();
        if (aEU().isLoggable("Fabric", 3)) {
            append = new StringBuilder("Initializing ").append(getIdentifier()).append(" [Version: ").append(getVersion()).append("], with the following kits:\n");
        } else {
            append = null;
        }
        for (emr a2 : arrayList) {
            a2.dNn.m10911a(com_fossil_emv.dNn);
            m10908a(this.dMU, a2);
            a2.initialize();
            if (append != null) {
                append.append(a2.getIdentifier()).append(" [Version: ").append(a2.getVersion()).append("]\n");
            }
        }
        if (append != null) {
            aEU().mo2950d("Fabric", append.toString());
        }
    }

    void m10908a(Map<Class<? extends emr>, emr> map, emr com_fossil_emr) {
        ens com_fossil_ens = (ens) com_fossil_emr.getClass().getAnnotation(ens.class);
        if (com_fossil_ens != null) {
            for (Class cls : com_fossil_ens.zy()) {
                if (cls.isInterface()) {
                    for (emr com_fossil_emr2 : map.values()) {
                        if (cls.isAssignableFrom(com_fossil_emr2.getClass())) {
                            com_fossil_emr.dNn.m10911a(com_fossil_emr2.dNn);
                        }
                    }
                } else if (((emr) map.get(cls)) == null) {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                } else {
                    com_fossil_emr.dNn.m10911a(((emr) map.get(cls)).dNn);
                }
            }
        }
    }

    private Activity en(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public emk aES() {
        return this.dMX;
    }

    public ExecutorService aET() {
        return this.aIj;
    }

    public Collection<emr> xb() {
        return this.dMU.values();
    }

    public static <T extends emr> T an(Class<T> cls) {
        return (emr) aER().dMU.get(cls);
    }

    public static emu aEU() {
        if (dMS == null) {
            return dMT;
        }
        return dMS.dMZ;
    }

    public static boolean aEV() {
        if (dMS == null) {
            return false;
        }
        return dMS.dNa;
    }

    private static Map<Class<? extends emr>, emr> m10905l(Collection<? extends emr> collection) {
        Map<Class<? extends emr>, emr> hashMap = new HashMap(collection.size());
        m10904d(hashMap, collection);
        return hashMap;
    }

    private static void m10904d(Map<Class<? extends emr>, emr> map, Collection<? extends emr> collection) {
        for (emr com_fossil_emr : collection) {
            map.put(com_fossil_emr.getClass(), com_fossil_emr);
            if (com_fossil_emr instanceof ems) {
                m10904d(map, ((ems) com_fossil_emr).xb());
            }
        }
    }

    emp<?> pb(final int i) {
        return new emp(this) {
            final /* synthetic */ emm dNb;
            final CountDownLatch dNc = new CountDownLatch(i);

            public void de(Object obj) {
                this.dNc.countDown();
                if (this.dNc.getCount() == 0) {
                    this.dNb.aIb.set(true);
                    this.dNb.dMV.de(this.dNb);
                }
            }

            public void mo2960l(Exception exception) {
                this.dNb.dMV.mo2960l(exception);
            }
        };
    }

    Future<Map<String, emt>> eo(Context context) {
        return aET().submit(new emo(context.getPackageCodePath()));
    }
}
