package com.fossil;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class cef {
    private static final List<String> bPe = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> bPf = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> bPg = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> bPh = Arrays.asList(new String[0]);
    private static final Set<String> bPi = Collections.emptySet();
    private static final Object bhH = new Object();
    static final Map<String, cef> bpM = new jl();
    private final ceg bPj;
    private final AtomicBoolean bPk = new AtomicBoolean(false);
    private final AtomicBoolean bPl = new AtomicBoolean();
    private final List<Object> bPm = new CopyOnWriteArrayList();
    private final List<C2021b> bPn = new CopyOnWriteArrayList();
    private final List<Object> bPo = new CopyOnWriteArrayList();
    private C1918a bPp;
    private final Context mApplicationContext;
    private final String mName;

    public interface C1918a {
    }

    public interface C2021b {
        void ba(boolean z);
    }

    @TargetApi(24)
    static class C2022c extends BroadcastReceiver {
        private static AtomicReference<C2022c> bqe = new AtomicReference();
        private final Context mApplicationContext;

        private C2022c(Context context) {
            this.mApplicationContext = context;
        }

        private static void aY(Context context) {
            if (bqe.get() == null) {
                BroadcastReceiver c2022c = new C2022c(context);
                if (bqe.compareAndSet(null, c2022c)) {
                    context.registerReceiver(c2022c, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (cef.bhH) {
                for (cef b : cef.bpM.values()) {
                    b.VT();
                }
            }
            this.mApplicationContext.unregisterReceiver(this);
        }
    }

    private cef(Context context, String str, ceg com_fossil_ceg) {
        this.mApplicationContext = (Context) awa.bO(context);
        this.mName = awa.df(str);
        this.bPj = (ceg) awa.bO(com_fossil_ceg);
        this.bPp = new bcf();
    }

    public static cef VQ() {
        cef com_fossil_cef;
        synchronized (bhH) {
            com_fossil_cef = (cef) bpM.get("[DEFAULT]");
            if (com_fossil_cef == null) {
                String valueOf = String.valueOf(axu.LL());
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(valueOf).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
            }
        }
        return com_fossil_cef;
    }

    private final void VR() {
        awa.m4634a(!this.bPl.get(), "FirebaseApp was deleted");
    }

    private final void VT() {
        m6097a(cef.class, (Object) this, bPe);
        if (VS()) {
            m6097a(cef.class, (Object) this, bPf);
            m6097a(Context.class, this.mApplicationContext, bPg);
        }
    }

    public static cef m6095a(Context context, ceg com_fossil_ceg) {
        return m6096a(context, com_fossil_ceg, "[DEFAULT]");
    }

    public static cef m6096a(Context context, ceg com_fossil_ceg, String str) {
        Object com_fossil_cef;
        bcg.aL(context);
        if (context.getApplicationContext() instanceof Application) {
            bdq.m4909a((Application) context.getApplicationContext());
            bdq.Nd().m4910a(new cff());
        }
        String trim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (bhH) {
            awa.m4634a(!bpM.containsKey(trim), new StringBuilder(String.valueOf(trim).length() + 33).append("FirebaseApp name ").append(trim).append(" already exists!").toString());
            awa.m4640p(context, "Application context cannot be null.");
            com_fossil_cef = new cef(context, trim, com_fossil_ceg);
            bpM.put(trim, com_fossil_cef);
        }
        bcg.m4833a(com_fossil_cef);
        com_fossil_cef.m6097a(cef.class, com_fossil_cef, bPe);
        if (com_fossil_cef.VS()) {
            com_fossil_cef.m6097a(cef.class, com_fossil_cef, bPf);
            com_fossil_cef.m6097a(Context.class, com_fossil_cef.getApplicationContext(), bPg);
        }
        return com_fossil_cef;
    }

    private final <T> void m6097a(Class<T> cls, T t, Iterable<String> iterable) {
        boolean o = gn.m10636o(this.mApplicationContext);
        if (o) {
            C2022c.aY(this.mApplicationContext);
        }
        for (String str : iterable) {
            String str2;
            if (o) {
                try {
                    if (!bPh.contains(str2)) {
                    }
                } catch (ClassNotFoundException e) {
                    if (bPi.contains(str2)) {
                        throw new IllegalStateException(String.valueOf(str2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                    }
                    Log.d("FirebaseApp", String.valueOf(str2).concat(" is not linked. Skipping initialization."));
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(String.valueOf(str2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                } catch (Throwable e3) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
                } catch (Throwable e4) {
                    String str3 = "FirebaseApp";
                    String str4 = "Failed to initialize ";
                    str2 = String.valueOf(str2);
                    Log.wtf(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4), e4);
                }
            }
            Method method = Class.forName(str2).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, new Object[]{t});
            }
        }
    }

    public static cef aX(Context context) {
        cef VQ;
        synchronized (bhH) {
            if (bpM.containsKey("[DEFAULT]")) {
                VQ = VQ();
            } else {
                ceg ba = ceg.ba(context);
                if (ba == null) {
                    VQ = null;
                } else {
                    VQ = m6095a(context, ba);
                }
            }
        }
        return VQ;
    }

    private final void bD(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (C2021b ba : this.bPn) {
            ba.ba(z);
        }
    }

    public static void ba(boolean z) {
        synchronized (bhH) {
            ArrayList arrayList = new ArrayList(bpM.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                cef com_fossil_cef = (cef) obj;
                if (com_fossil_cef.bPk.get()) {
                    com_fossil_cef.bD(z);
                }
            }
        }
    }

    public ceg VP() {
        VR();
        return this.bPj;
    }

    public final boolean VS() {
        return "[DEFAULT]".equals(getName());
    }

    public boolean equals(Object obj) {
        return !(obj instanceof cef) ? false : this.mName.equals(((cef) obj).getName());
    }

    public Context getApplicationContext() {
        VR();
        return this.mApplicationContext;
    }

    public String getName() {
        VR();
        return this.mName;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public String toString() {
        return avx.bN(this).m4608b("name", this.mName).m4608b("options", this.bPj).toString();
    }
}
