package com.fossil;

import com.fasterxml.jackson.databind.JavaType;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class alu {
    private final int _mask;
    private final int _size;
    private final C1681a[] aUO;

    static final class C1681a {
        protected final Class<?> _class;
        protected final JavaType _type;
        public final ahb<Object> aUP;
        public final C1681a aUQ;
        protected final boolean aUR;

        public C1681a(C1681a c1681a, amu com_fossil_amu, ahb<Object> com_fossil_ahb_java_lang_Object) {
            this.aUQ = c1681a;
            this.aUP = com_fossil_ahb_java_lang_Object;
            this.aUR = com_fossil_amu.HA();
            this._class = com_fossil_amu.getRawType();
            this._type = com_fossil_amu.getType();
        }

        public boolean m3782p(Class<?> cls) {
            return this._class == cls && this.aUR;
        }

        public boolean m3784q(Class<?> cls) {
            return this._class == cls && !this.aUR;
        }

        public boolean m3783q(JavaType javaType) {
            return this.aUR && javaType.equals(this._type);
        }

        public boolean m3785r(JavaType javaType) {
            return !this.aUR && javaType.equals(this._type);
        }
    }

    public alu(Map<amu, ahb<Object>> map) {
        int gQ = gQ(map.size());
        this._size = gQ;
        this._mask = gQ - 1;
        C1681a[] c1681aArr = new C1681a[gQ];
        for (Entry entry : map.entrySet()) {
            amu com_fossil_amu = (amu) entry.getKey();
            int hashCode = com_fossil_amu.hashCode() & this._mask;
            c1681aArr[hashCode] = new C1681a(c1681aArr[hashCode], com_fossil_amu, (ahb) entry.getValue());
        }
        this.aUO = c1681aArr;
    }

    private static final int gQ(int i) {
        int i2 = 8;
        while (i2 < (i <= 64 ? i + i : (i >> 2) + i)) {
            i2 += i2;
        }
        return i2;
    }

    public static alu m3786b(HashMap<amu, ahb<Object>> hashMap) {
        return new alu(hashMap);
    }

    public ahb<Object> m3790p(JavaType javaType) {
        C1681a c1681a = this.aUO[amu.m3730t(javaType) & this._mask];
        if (c1681a == null) {
            return null;
        }
        if (c1681a.m3783q(javaType)) {
            return c1681a.aUP;
        }
        do {
            c1681a = c1681a.aUQ;
            if (c1681a == null) {
                return null;
            }
        } while (!c1681a.m3783q(javaType));
        return c1681a.aUP;
    }

    public ahb<Object> m3788n(Class<?> cls) {
        C1681a c1681a = this.aUO[amu.m3728G(cls) & this._mask];
        if (c1681a == null) {
            return null;
        }
        if (c1681a.m3782p(cls)) {
            return c1681a.aUP;
        }
        do {
            c1681a = c1681a.aUQ;
            if (c1681a == null) {
                return null;
            }
        } while (!c1681a.m3782p(cls));
        return c1681a.aUP;
    }

    public ahb<Object> m3789o(JavaType javaType) {
        C1681a c1681a = this.aUO[amu.m3729s(javaType) & this._mask];
        if (c1681a == null) {
            return null;
        }
        if (c1681a.m3785r(javaType)) {
            return c1681a.aUP;
        }
        do {
            c1681a = c1681a.aUQ;
            if (c1681a == null) {
                return null;
            }
        } while (!c1681a.m3785r(javaType));
        return c1681a.aUP;
    }

    public ahb<Object> m3787m(Class<?> cls) {
        C1681a c1681a = this.aUO[amu.m3727F(cls) & this._mask];
        if (c1681a == null) {
            return null;
        }
        if (c1681a.m3784q((Class) cls)) {
            return c1681a.aUP;
        }
        do {
            c1681a = c1681a.aUQ;
            if (c1681a == null) {
                return null;
            }
        } while (!c1681a.m3784q((Class) cls));
        return c1681a.aUP;
    }
}
