package com.fossil;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Map;

public final class bin<I, O> extends auq {
    public static final biq CREATOR = new biq();
    private final int ber;
    private String bvA;
    private bis bvB;
    private bio<I, O> bvC;
    protected final int bvt;
    protected final boolean bvu;
    protected final int bvv;
    protected final boolean bvw;
    protected final String bvx;
    protected final int bvy;
    protected final Class<? extends bim> bvz;

    bin(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, big com_fossil_big) {
        this.ber = i;
        this.bvt = i2;
        this.bvu = z;
        this.bvv = i3;
        this.bvw = z2;
        this.bvx = str;
        this.bvy = i4;
        if (str2 == null) {
            this.bvz = null;
            this.bvA = null;
        } else {
            this.bvz = bix.class;
            this.bvA = str2;
        }
        if (com_fossil_big == null) {
            this.bvC = null;
        } else {
            this.bvC = com_fossil_big.Ow();
        }
    }

    private bin(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends bim> cls, bio<I, O> com_fossil_bio_I__O) {
        this.ber = 1;
        this.bvt = i;
        this.bvu = z;
        this.bvv = i2;
        this.bvw = z2;
        this.bvx = str;
        this.bvy = i3;
        this.bvz = cls;
        if (cls == null) {
            this.bvA = null;
        } else {
            this.bvA = cls.getCanonicalName();
        }
        this.bvC = com_fossil_bio_I__O;
    }

    private String Oz() {
        return this.bvA == null ? null : this.bvA;
    }

    public static bin m5204a(String str, int i, bio<?, ?> com_fossil_bio___, boolean z) {
        return new bin(7, false, 0, false, str, i, null, com_fossil_bio___);
    }

    public static <T extends bim> bin<T, T> m5205a(String str, int i, Class<T> cls) {
        return new bin(11, false, 11, false, str, i, cls, null);
    }

    public static <T extends bim> bin<ArrayList<T>, ArrayList<T>> m5206b(String str, int i, Class<T> cls) {
        return new bin(11, true, 11, true, str, i, cls, null);
    }

    public static bin<Integer, Integer> m5208r(String str, int i) {
        return new bin(0, false, 0, false, str, i, null, null);
    }

    public static bin<Boolean, Boolean> m5209s(String str, int i) {
        return new bin(6, false, 6, false, str, i, null, null);
    }

    public static bin<String, String> m5210t(String str, int i) {
        return new bin(7, false, 7, false, str, i, null, null);
    }

    public final boolean OA() {
        return this.bvC != null;
    }

    public final Map<String, bin<?, ?>> OB() {
        awa.bO(this.bvA);
        awa.bO(this.bvB);
        return this.bvB.dK(this.bvA);
    }

    public final int Oy() {
        return this.bvy;
    }

    public final void m5211a(bis com_fossil_bis) {
        this.bvB = com_fossil_bis;
    }

    public final I convertBack(O o) {
        return this.bvC.convertBack(o);
    }

    public final String toString() {
        avz b = avx.bN(this).m4608b("versionCode", Integer.valueOf(this.ber)).m4608b("typeIn", Integer.valueOf(this.bvt)).m4608b("typeInArray", Boolean.valueOf(this.bvu)).m4608b("typeOut", Integer.valueOf(this.bvv)).m4608b("typeOutArray", Boolean.valueOf(this.bvw)).m4608b("outputFieldName", this.bvx).m4608b("safeParcelFieldId", Integer.valueOf(this.bvy)).m4608b("concreteTypeName", Oz());
        Class cls = this.bvz;
        if (cls != null) {
            b.m4608b("concreteType.class", cls.getCanonicalName());
        }
        if (this.bvC != null) {
            b.m4608b("converterName", this.bvC.getClass().getCanonicalName());
        }
        return b.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.ber);
        aus.m4565c(parcel, 2, this.bvt);
        aus.m4556a(parcel, 3, this.bvu);
        aus.m4565c(parcel, 4, this.bvv);
        aus.m4556a(parcel, 5, this.bvw);
        aus.m4554a(parcel, 6, this.bvx, false);
        aus.m4565c(parcel, 7, this.bvy);
        aus.m4554a(parcel, 8, Oz(), false);
        aus.m4548a(parcel, 9, this.bvC == null ? null : big.m5196a(this.bvC), i, false);
        aus.m4540G(parcel, A);
    }
}
