package com.flurry.sdk;

import com.fossil.app;
import com.fossil.aqp;
import com.fossil.aqq;
import com.fossil.aqq.C1543a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ln implements C1543a {
    private static final List<Class<?>> aXn = new ArrayList();
    private final Map<Class<?>, Object> aWU = new LinkedHashMap();
    long aXm;
    final Object bbo = new Object();
    private final String f1351d = ln.class.getSimpleName();
    private volatile int f1352f = C1542a.f1348a;

    public enum C1542a {
        ;

        public static int[] m2787a() {
            return (int[]) bcd.clone();
        }

        static {
            f1348a = 1;
            f1349b = 2;
            f1350c = 3;
            bcd = new int[]{f1348a, f1349b, f1350c};
        }
    }

    public ln() {
        synchronized (aXn) {
            List<Class> arrayList = new ArrayList(aXn);
        }
        for (Class cls : arrayList) {
            try {
                Object newInstance = cls.newInstance();
                synchronized (this.aWU) {
                    this.aWU.put(cls, newInstance);
                }
            } catch (Throwable e) {
                app.m4174b(5, this.f1351d, "Module data " + cls + " is not available:", e);
            }
        }
        aqq Jf = aqp.Jf();
        this.aXm = ((Long) Jf.cw("ContinueSessionMillis")).longValue();
        Jf.m4241a("ContinueSessionMillis", (C1543a) this);
        app.m4180g(4, this.f1351d, "initSettings, ContinueSessionMillis = " + this.aXm);
    }

    public static void m2789I(Class<?> cls) {
        synchronized (aXn) {
            aXn.add(cls);
        }
    }

    public final Object m2790K(Class<?> cls) {
        Object obj;
        synchronized (this.aWU) {
            obj = this.aWU.get(cls);
        }
        return obj;
    }

    public boolean Ja() {
        return false;
    }

    public long Jb() {
        return this.aXm;
    }

    public final void m2791a(int i) {
        synchronized (this.bbo) {
            this.f1352f = i;
        }
    }

    public final int HF() {
        int i;
        synchronized (this.bbo) {
            i = this.f1352f;
        }
        return i;
    }

    public final void mo761a(String str, Object obj) {
        if (str.equals("ContinueSessionMillis")) {
            this.aXm = ((Long) obj).longValue();
            app.m4180g(4, this.f1351d, "onSettingUpdate, ContinueSessionMillis = " + this.aXm);
            return;
        }
        app.m4180g(6, this.f1351d, "onSettingUpdate internal error!");
    }
}
