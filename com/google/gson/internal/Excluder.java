package com.google.gson.internal;

import com.fossil.cfg;
import com.fossil.cfh;
import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cfy;
import com.fossil.cgb;
import com.fossil.cgc;
import com.fossil.cgu;
import com.fossil.cgv;
import com.fossil.cgw;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public final class Excluder implements cfx, Cloneable {
    public static final Excluder bRv = new Excluder();
    private List<cfg> bRA = Collections.emptyList();
    private List<cfg> bRB = Collections.emptyList();
    private double bRw = -1.0d;
    private int bRx = 136;
    private boolean bRy = true;
    private boolean bRz;

    protected /* synthetic */ Object clone() throws CloneNotSupportedException {
        return WM();
    }

    protected Excluder WM() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public Excluder m14586g(int... iArr) {
        int i = 0;
        Excluder WM = WM();
        WM.bRx = 0;
        int length = iArr.length;
        while (i < length) {
            WM.bRx = iArr[i] | WM.bRx;
            i++;
        }
        return WM;
    }

    public Excluder WN() {
        Excluder WM = WM();
        WM.bRz = true;
        return WM;
    }

    public <T> cfw<T> m14583a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        Class rawType = com_fossil_cgu_T.getRawType();
        final boolean d = m14585d(rawType, true);
        final boolean d2 = m14585d(rawType, false);
        if (!d && !d2) {
            return null;
        }
        final cfj com_fossil_cfj2 = com_fossil_cfj;
        final cgu<T> com_fossil_cgu_T2 = com_fossil_cgu_T;
        return new cfw<T>(this) {
            private cfw<T> bQX;
            final /* synthetic */ Excluder bRG;

            public T m14579b(cgv com_fossil_cgv) throws IOException {
                if (!d2) {
                    return WO().b(com_fossil_cgv);
                }
                com_fossil_cgv.skipValue();
                return null;
            }

            public void m14578a(cgw com_fossil_cgw, T t) throws IOException {
                if (d) {
                    com_fossil_cgw.Xe();
                } else {
                    WO().a(com_fossil_cgw, t);
                }
            }

            private cfw<T> WO() {
                cfw<T> com_fossil_cfw_T = this.bQX;
                if (com_fossil_cfw_T != null) {
                    return com_fossil_cfw_T;
                }
                com_fossil_cfw_T = com_fossil_cfj2.a(this.bRG, com_fossil_cgu_T2);
                this.bQX = com_fossil_cfw_T;
                return com_fossil_cfw_T;
            }
        };
    }

    public boolean m14584a(Field field, boolean z) {
        if ((this.bRx & field.getModifiers()) != 0) {
            return true;
        }
        if (this.bRw != -1.0d && !m14581a((cgb) field.getAnnotation(cgb.class), (cgc) field.getAnnotation(cgc.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.bRz) {
            cfy com_fossil_cfy = (cfy) field.getAnnotation(cfy.class);
            if (com_fossil_cfy == null || (z ? !com_fossil_cfy.WG() : !com_fossil_cfy.WH())) {
                return true;
            }
        }
        if (!this.bRy && ad(field.getType())) {
            return true;
        }
        if (ac(field.getType())) {
            return true;
        }
        List<cfg> list = z ? this.bRA : this.bRB;
        if (!list.isEmpty()) {
            cfh com_fossil_cfh = new cfh(field);
            for (cfg a : list) {
                if (a.a(com_fossil_cfh)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean m14585d(Class<?> cls, boolean z) {
        if (this.bRw != -1.0d && !m14581a((cgb) cls.getAnnotation(cgb.class), (cgc) cls.getAnnotation(cgc.class))) {
            return true;
        }
        if (!this.bRy && ad(cls)) {
            return true;
        }
        if (ac(cls)) {
            return true;
        }
        for (cfg Z : z ? this.bRA : this.bRB) {
            if (Z.Z(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean ac(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean ad(Class<?> cls) {
        return cls.isMemberClass() && !ae(cls);
    }

    private boolean ae(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean m14581a(cgb com_fossil_cgb, cgc com_fossil_cgc) {
        return m14580a(com_fossil_cgb) && m14582a(com_fossil_cgc);
    }

    private boolean m14580a(cgb com_fossil_cgb) {
        if (com_fossil_cgb == null || com_fossil_cgb.WK() <= this.bRw) {
            return true;
        }
        return false;
    }

    private boolean m14582a(cgc com_fossil_cgc) {
        if (com_fossil_cgc == null || com_fossil_cgc.WK() > this.bRw) {
            return true;
        }
        return false;
    }
}
