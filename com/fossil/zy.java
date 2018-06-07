package com.fossil;

import java.util.HashMap;
import java.util.Map;

public class zy {
    private static final abk aFv = new abk();
    private final Map<abk, zx<?, ?>> aFV = new HashMap();

    public <T, Z> void m14179a(Class<T> cls, Class<Z> cls2, zx<T, Z> zxVar) {
        this.aFV.put(new abk(cls, cls2), zxVar);
    }

    public <T, Z> zx<T, Z> m14180h(Class<T> cls, Class<Z> cls2) {
        synchronized (aFv) {
            aFv.i(cls, cls2);
            zx<T, Z> zxVar = (zx) this.aFV.get(aFv);
        }
        if (zxVar == null) {
            return zz.wt();
        }
        return zxVar;
    }
}
