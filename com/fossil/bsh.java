package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bsh extends auq {
    public static final Creator<bsh> CREATOR = new bsi();
    public final long bDu;
    private Long bDv;
    private Float bDw;
    private Double bDx;
    private String boy;
    public final String bxC;
    public final String name;
    private int versionCode;

    bsh(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        Double d2 = null;
        this.versionCode = i;
        this.name = str;
        this.bDu = j;
        this.bDv = l;
        this.bDw = null;
        if (i == 1) {
            if (f != null) {
                d2 = Double.valueOf(f.doubleValue());
            }
            this.bDx = d2;
        } else {
            this.bDx = d;
        }
        this.boy = str2;
        this.bxC = str3;
    }

    bsh(bsj com_fossil_bsj) {
        this(com_fossil_bsj.mName, com_fossil_bsj.bDy, com_fossil_bsj.mValue, com_fossil_bsj.mOrigin);
    }

    bsh(String str, long j, Object obj, String str2) {
        awa.df(str);
        this.versionCode = 2;
        this.name = str;
        this.bDu = j;
        this.bxC = str2;
        if (obj == null) {
            this.bDv = null;
            this.bDw = null;
            this.bDx = null;
            this.boy = null;
        } else if (obj instanceof Long) {
            this.bDv = (Long) obj;
            this.bDw = null;
            this.bDx = null;
            this.boy = null;
        } else if (obj instanceof String) {
            this.bDv = null;
            this.bDw = null;
            this.bDx = null;
            this.boy = (String) obj;
        } else if (obj instanceof Double) {
            this.bDv = null;
            this.bDw = null;
            this.bDx = (Double) obj;
            this.boy = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public final Object getValue() {
        return this.bDv != null ? this.bDv : this.bDx != null ? this.bDx : this.boy != null ? this.boy : null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.versionCode);
        aus.m4554a(parcel, 2, this.name, false);
        aus.m4544a(parcel, 3, this.bDu);
        aus.m4553a(parcel, 4, this.bDv, false);
        aus.m4551a(parcel, 5, null, false);
        aus.m4554a(parcel, 6, this.boy, false);
        aus.m4554a(parcel, 7, this.bxC, false);
        aus.m4550a(parcel, 8, this.bDx, false);
        aus.m4540G(parcel, A);
    }
}
