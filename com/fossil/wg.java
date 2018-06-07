package com.fossil;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class wg {
    private static final wp aDk = new C41971();
    private final Map<Class, Map<Class, wq>> aDi = new HashMap();
    private final Map<Class, Map<Class, wp>> aDj = new HashMap();
    private final Context context;

    static class C41971 implements wp {
        C41971() {
        }

        public us mo4419c(Object obj, int i, int i2) {
            throw new NoSuchMethodError("This should never be called!");
        }

        public String toString() {
            return "NULL_MODEL_LOADER";
        }
    }

    public wg(Context context) {
        this.context = context.getApplicationContext();
    }

    public synchronized <T, Y> wq<T, Y> m13992b(Class<T> cls, Class<Y> cls2, wq<T, Y> wqVar) {
        wq<T, Y> wqVar2;
        this.aDj.clear();
        Map map = (Map) this.aDi.get(cls);
        if (map == null) {
            map = new HashMap();
            this.aDi.put(cls, map);
        }
        wqVar2 = (wq) map.put(cls2, wqVar);
        if (wqVar2 != null) {
            for (Map containsValue : this.aDi.values()) {
                if (containsValue.containsValue(wqVar2)) {
                    wqVar2 = null;
                    break;
                }
            }
        }
        return wqVar2;
    }

    public synchronized <T, Y> wp<T, Y> m13993c(Class<T> cls, Class<Y> cls2) {
        wp<T, Y> e;
        e = m13990e(cls, cls2);
        if (e == null) {
            wq f = m13991f(cls, cls2);
            if (f != null) {
                e = f.mo4423a(this.context, this);
                m13988a(cls, cls2, e);
            } else {
                m13989d(cls, cls2);
            }
        } else if (aDk.equals(e)) {
            e = null;
        }
        return e;
    }

    private <T, Y> void m13989d(Class<T> cls, Class<Y> cls2) {
        m13988a(cls, cls2, aDk);
    }

    private <T, Y> void m13988a(Class<T> cls, Class<Y> cls2, wp<T, Y> wpVar) {
        Map map = (Map) this.aDj.get(cls);
        if (map == null) {
            map = new HashMap();
            this.aDj.put(cls, map);
        }
        map.put(cls2, wpVar);
    }

    private <T, Y> wp<T, Y> m13990e(Class<T> cls, Class<Y> cls2) {
        Map map = (Map) this.aDj.get(cls);
        if (map != null) {
            return (wp) map.get(cls2);
        }
        return null;
    }

    private <T, Y> wq<T, Y> m13991f(Class<T> cls, Class<Y> cls2) {
        wq<T, Y> wqVar;
        Map map = (Map) this.aDi.get(cls);
        if (map != null) {
            wqVar = (wq) map.get(cls2);
        } else {
            wqVar = null;
        }
        if (wqVar != null) {
            return wqVar;
        }
        wq<T, Y> wqVar2 = wqVar;
        for (Class cls3 : this.aDi.keySet()) {
            if (cls3.isAssignableFrom(cls)) {
                map = (Map) this.aDi.get(cls3);
                if (map != null) {
                    wqVar = (wq) map.get(cls2);
                    if (wqVar != null) {
                        return wqVar;
                    }
                    wqVar2 = wqVar;
                }
            }
            wqVar = wqVar2;
            wqVar2 = wqVar;
        }
        return wqVar2;
    }
}
