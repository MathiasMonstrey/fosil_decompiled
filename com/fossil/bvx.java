package com.fossil;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.Locale;

public final class bvx extends auq {
    public static final Creator<bvx> CREATOR = new bvy();
    private static bvx bHS = new bvx("com.google.android.gms", Locale.getDefault(), null);
    private String bGU;
    private String bHT;
    private String bHU;
    private String bHV;
    private int bHW;
    private int bHX;

    public bvx(String str, String str2, String str3, String str4, int i, int i2) {
        this.bHT = str;
        this.bHU = str2;
        this.bHV = str3;
        this.bGU = str4;
        this.bHW = i;
        this.bHX = i2;
    }

    private bvx(String str, Locale locale, String str2) {
        this(str, locale.toString(), null, null, atp.bfN, 0);
    }

    public bvx(String str, Locale locale, String str2, String str3, int i) {
        this(str, locale.toString(), str2, str3, atp.bfN, i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof bvx)) {
            return false;
        }
        bvx com_fossil_bvx = (bvx) obj;
        return this.bHW == com_fossil_bvx.bHW && this.bHX == com_fossil_bvx.bHX && this.bHU.equals(com_fossil_bvx.bHU) && this.bHT.equals(com_fossil_bvx.bHT) && avx.equal(this.bHV, com_fossil_bvx.bHV) && avx.equal(this.bGU, com_fossil_bvx.bGU);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.bHT, this.bHU, this.bHV, this.bGU, Integer.valueOf(this.bHW), Integer.valueOf(this.bHX)});
    }

    @SuppressLint({"DefaultLocale"})
    public final String toString() {
        return avx.bN(this).m4608b("clientPackageName", this.bHT).m4608b("locale", this.bHU).m4608b("accountName", this.bHV).m4608b("gCoreClientName", this.bGU).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 1, this.bHT, false);
        aus.m4554a(parcel, 2, this.bHU, false);
        aus.m4554a(parcel, 3, this.bHV, false);
        aus.m4554a(parcel, 4, this.bGU, false);
        aus.m4565c(parcel, 6, this.bHW);
        aus.m4565c(parcel, 7, this.bHX);
        aus.m4540G(parcel, A);
    }
}
