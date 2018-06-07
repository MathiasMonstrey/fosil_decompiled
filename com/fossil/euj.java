package com.fossil;

import android.support.v8.renderscript.ScriptIntrinsicBLAS;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;
import java.util.ArrayList;

public class euj {
    static final Object dVA = "d";
    static final Object dVB = "H";
    static final Object dVC = "m";
    static final Object dVD = "s";
    static final Object dVE = DeviceIdentityUtils.SHINE_SERIAL_NUMBER_PREFIX;
    static final Object dVy = "y";
    static final Object dVz = "M";

    static class C3548a {
        private int count = 1;
        private final Object value;

        static boolean m11230a(C3548a[] c3548aArr, Object obj) {
            for (C3548a value : c3548aArr) {
                if (value.getValue() == obj) {
                    return true;
                }
            }
            return false;
        }

        C3548a(Object obj) {
            this.value = obj;
        }

        void increment() {
            this.count++;
        }

        int getCount() {
            return this.count;
        }

        Object getValue() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C3548a)) {
                return false;
            }
            C3548a c3548a = (C3548a) obj;
            if (this.value.getClass() != c3548a.value.getClass() || this.count != c3548a.count) {
                return false;
            }
            if (this.value instanceof StringBuilder) {
                return this.value.toString().equals(c3548a.value.toString());
            }
            if (this.value instanceof Number) {
                return this.value.equals(c3548a.value);
            }
            if (this.value == c3548a.value) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return euh.m11224R(this.value.toString(), this.count);
        }
    }

    public static String bm(long j) {
        return m11234e(j, "HH:mm:ss.SSS");
    }

    public static String m11234e(long j, String str) {
        return m11231a(j, str, true);
    }

    public static String m11231a(long j, String str, boolean z) {
        long j2;
        eui.m11229a(0, ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD, j, "durationMillis must not be negative");
        C3548a[] mP = mP(str);
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        if (C3548a.m11230a(mP, dVA)) {
            j3 = j / 86400000;
            j -= 86400000 * j3;
        }
        if (C3548a.m11230a(mP, dVB)) {
            j4 = j / 3600000;
            j -= 3600000 * j4;
        }
        if (C3548a.m11230a(mP, dVC)) {
            j5 = j / 60000;
            j -= 60000 * j5;
        }
        if (C3548a.m11230a(mP, dVD)) {
            j6 = j / 1000;
            j2 = j - (1000 * j6);
        } else {
            j2 = j;
        }
        return m11233a(mP, 0, 0, j3, j4, j5, j6, j2, z);
    }

    static String m11233a(C3548a[] c3548aArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = null;
        for (C3548a c3548a : c3548aArr) {
            Object value = c3548a.getValue();
            int count = c3548a.getCount();
            if (value instanceof StringBuilder) {
                stringBuilder.append(value.toString());
            } else if (value.equals(dVy)) {
                stringBuilder.append(m11232a(j, z, count));
                obj = null;
            } else if (value.equals(dVz)) {
                stringBuilder.append(m11232a(j2, z, count));
                obj = null;
            } else if (value.equals(dVA)) {
                stringBuilder.append(m11232a(j3, z, count));
                obj = null;
            } else if (value.equals(dVB)) {
                stringBuilder.append(m11232a(j4, z, count));
                obj = null;
            } else if (value.equals(dVC)) {
                stringBuilder.append(m11232a(j5, z, count));
                obj = null;
            } else if (value.equals(dVD)) {
                stringBuilder.append(m11232a(j6, z, count));
                obj = 1;
            } else if (value.equals(dVE)) {
                if (obj != null) {
                    stringBuilder.append(m11232a(j7, true, z ? Math.max(3, count) : 3));
                } else {
                    stringBuilder.append(m11232a(j7, z, count));
                }
                obj = null;
            }
        }
        return stringBuilder.toString();
    }

    private static String m11232a(long j, boolean z, int i) {
        String l = Long.toString(j);
        return z ? euh.m11227c(l, i, '0') : l;
    }

    static C3548a[] mP(String str) {
        ArrayList arrayList = new ArrayList(str.length());
        C3548a c3548a = null;
        StringBuilder stringBuilder = null;
        Object obj = null;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (obj == null || charAt == '\'') {
                Object obj2;
                switch (charAt) {
                    case '\'':
                        if (obj == null) {
                            stringBuilder = new StringBuilder();
                            arrayList.add(new C3548a(stringBuilder));
                            obj = 1;
                            obj2 = null;
                            break;
                        }
                        obj2 = null;
                        stringBuilder = null;
                        obj = null;
                        break;
                    case 'H':
                        obj2 = dVB;
                        break;
                    case 'M':
                        obj2 = dVz;
                        break;
                    case 'S':
                        obj2 = dVE;
                        break;
                    case 'd':
                        obj2 = dVA;
                        break;
                    case 'm':
                        obj2 = dVC;
                        break;
                    case 's':
                        obj2 = dVD;
                        break;
                    case ScriptIntrinsicBLAS.UPPER /*121*/:
                        obj2 = dVy;
                        break;
                    default:
                        if (stringBuilder == null) {
                            stringBuilder = new StringBuilder();
                            arrayList.add(new C3548a(stringBuilder));
                        }
                        stringBuilder.append(charAt);
                        obj2 = null;
                        break;
                }
                if (obj2 != null) {
                    if (c3548a == null || !c3548a.getValue().equals(obj2)) {
                        c3548a = new C3548a(obj2);
                        arrayList.add(c3548a);
                    } else {
                        c3548a.increment();
                    }
                    stringBuilder = null;
                }
            } else {
                stringBuilder.append(charAt);
            }
        }
        if (obj == null) {
            return (C3548a[]) arrayList.toArray(new C3548a[arrayList.size()]);
        }
        throw new IllegalArgumentException("Unmatched quote in format: " + str);
    }
}
