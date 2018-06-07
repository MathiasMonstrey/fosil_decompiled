package com.fossil;

import java.util.HashMap;
import java.util.Map;

public class ze {
    private static final abk aFv = new abk();
    private final Map<abk, zd<?, ?>> aFw = new HashMap();

    public <Z, R> void m14145a(Class<Z> cls, Class<R> cls2, zd<Z, R> zdVar) {
        this.aFw.put(new abk(cls, cls2), zdVar);
    }

    public <Z, R> zd<Z, R> m14146g(Class<Z> cls, Class<R> cls2) {
        if (cls.equals(cls2)) {
            return zf.wh();
        }
        synchronized (aFv) {
            aFv.i(cls, cls2);
            zd<Z, R> zdVar = (zd) this.aFw.get(aFv);
        }
        if (zdVar != null) {
            return zdVar;
        }
        throw new IllegalArgumentException("No transcoder registered for " + cls + " and " + cls2);
    }
}
