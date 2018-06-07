package com.fossil;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

public final class amd {
    private C1695a aVt = null;
    private C1696b aVu = null;
    private C1701g aVv = null;
    private C1699e aVw = null;
    private C1700f aVx = null;
    private C1698d aVy = null;
    private C1697c aVz = null;

    public static final class C1695a extends amq<boolean[]> {
        public /* synthetic */ Object gV(int i) {
            return gU(i);
        }

        public final boolean[] gU(int i) {
            return new boolean[i];
        }
    }

    public static final class C1696b extends amq<byte[]> {
        public /* synthetic */ Object gV(int i) {
            return gW(i);
        }

        public final byte[] gW(int i) {
            return new byte[i];
        }
    }

    public static final class C1697c extends amq<double[]> {
        public /* synthetic */ Object gV(int i) {
            return gX(i);
        }

        public final double[] gX(int i) {
            return new double[i];
        }
    }

    public static final class C1698d extends amq<float[]> {
        public /* synthetic */ Object gV(int i) {
            return gY(i);
        }

        public final float[] gY(int i) {
            return new float[i];
        }
    }

    public static final class C1699e extends amq<int[]> {
        public /* synthetic */ Object gV(int i) {
            return gZ(i);
        }

        public final int[] gZ(int i) {
            return new int[i];
        }
    }

    public static final class C1700f extends amq<long[]> {
        public /* synthetic */ Object gV(int i) {
            return ha(i);
        }

        public final long[] ha(int i) {
            return new long[i];
        }
    }

    public static final class C1701g extends amq<short[]> {
        public /* synthetic */ Object gV(int i) {
            return hb(i);
        }

        public final short[] hb(int i) {
            return new short[i];
        }
    }

    public C1695a Hc() {
        if (this.aVt == null) {
            this.aVt = new C1695a();
        }
        return this.aVt;
    }

    public C1696b Hd() {
        if (this.aVu == null) {
            this.aVu = new C1696b();
        }
        return this.aVu;
    }

    public C1701g He() {
        if (this.aVv == null) {
            this.aVv = new C1701g();
        }
        return this.aVv;
    }

    public C1699e Hf() {
        if (this.aVw == null) {
            this.aVw = new C1699e();
        }
        return this.aVw;
    }

    public C1700f Hg() {
        if (this.aVx == null) {
            this.aVx = new C1700f();
        }
        return this.aVx;
    }

    public C1698d Hh() {
        if (this.aVy == null) {
            this.aVy = new C1698d();
        }
        return this.aVy;
    }

    public C1697c Hi() {
        if (this.aVz == null) {
            this.aVz = new C1697c();
        }
        return this.aVz;
    }

    public static Object bE(final Object obj) {
        final int length = Array.getLength(obj);
        final Class cls = obj.getClass();
        return new Object() {
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj == null || obj.getClass() != cls || Array.getLength(obj) != length) {
                    return false;
                }
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    Object obj3 = Array.get(obj, i);
                    if (obj2 != obj3 && obj2 != null && !obj2.equals(obj3)) {
                        return false;
                    }
                }
                return true;
            }
        };
    }

    public static <T> HashSet<T> m3838b(T[] tArr) {
        HashSet<T> hashSet = new HashSet();
        if (tArr != null) {
            for (Object add : tArr) {
                hashSet.add(add);
            }
        }
        return hashSet;
    }

    public static <T> HashSet<T> m3836a(Set<T> set, T[] tArr) {
        HashSet<T> hashSet = new HashSet();
        if (set != null) {
            hashSet.addAll(set);
        }
        if (tArr != null) {
            for (Object add : tArr) {
                hashSet.add(add);
            }
        }
        return hashSet;
    }

    public static <T> T[] m3837a(T[] tArr, T t) {
        Object[] objArr;
        int length = tArr.length;
        int i = 0;
        while (i < length) {
            if (tArr[i] != t) {
                i++;
            } else if (i == 0) {
                return tArr;
            } else {
                objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length);
                System.arraycopy(tArr, 0, objArr, 1, i);
                objArr[0] = t;
                i++;
                int i2 = length - i;
                if (i2 <= 0) {
                    return objArr;
                }
                System.arraycopy(tArr, i, objArr, i, i2);
                return objArr;
            }
        }
        objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + 1);
        if (length > 0) {
            System.arraycopy(tArr, 0, objArr, 1, length);
        }
        objArr[0] = t;
        return objArr;
    }
}
