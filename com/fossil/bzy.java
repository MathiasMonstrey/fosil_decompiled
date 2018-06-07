package com.fossil;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import java.util.Arrays;

public final class bzy extends auq {
    public static final Creator<bzy> CREATOR = new bzz();
    private final String[] bKi;
    private final String[] bKj;
    private final String[] bKk;
    private final String bKl;
    private final String bKm;
    private final String bKn;
    private final String bKo;
    private final PlusCommonExtras bKp;
    private final int ber;
    private final String bwJ;

    bzy(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.ber = i;
        this.bwJ = str;
        this.bKi = strArr;
        this.bKj = strArr2;
        this.bKk = strArr3;
        this.bKl = str2;
        this.bKm = str3;
        this.bKn = str4;
        this.bKo = str5;
        this.bKp = plusCommonExtras;
    }

    public bzy(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.ber = 1;
        this.bwJ = str;
        this.bKi = strArr;
        this.bKj = strArr2;
        this.bKk = strArr3;
        this.bKl = str2;
        this.bKm = str3;
        this.bKn = null;
        this.bKo = null;
        this.bKp = plusCommonExtras;
    }

    public final String[] TN() {
        return this.bKj;
    }

    public final String TO() {
        return this.bKl;
    }

    public final Bundle TP() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", aut.m4569a(this.bKp));
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bzy)) {
            return false;
        }
        bzy com_fossil_bzy = (bzy) obj;
        return this.ber == com_fossil_bzy.ber && avx.equal(this.bwJ, com_fossil_bzy.bwJ) && Arrays.equals(this.bKi, com_fossil_bzy.bKi) && Arrays.equals(this.bKj, com_fossil_bzy.bKj) && Arrays.equals(this.bKk, com_fossil_bzy.bKk) && avx.equal(this.bKl, com_fossil_bzy.bKl) && avx.equal(this.bKm, com_fossil_bzy.bKm) && avx.equal(this.bKn, com_fossil_bzy.bKn) && avx.equal(this.bKo, com_fossil_bzy.bKo) && avx.equal(this.bKp, com_fossil_bzy.bKp);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.ber), this.bwJ, this.bKi, this.bKj, this.bKk, this.bKl, this.bKm, this.bKn, this.bKo, this.bKp});
    }

    public final String toString() {
        return avx.bN(this).m4608b("versionCode", Integer.valueOf(this.ber)).m4608b("accountName", this.bwJ).m4608b("requestedScopes", this.bKi).m4608b("visibleActivities", this.bKj).m4608b("requiredFeatures", this.bKk).m4608b("packageNameForAuth", this.bKl).m4608b("callingPackageName", this.bKm).m4608b("applicationName", this.bKn).m4608b("extra", this.bKp.toString()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 1, this.bwJ, false);
        aus.m4561a(parcel, 2, this.bKi, false);
        aus.m4561a(parcel, 3, this.bKj, false);
        aus.m4561a(parcel, 4, this.bKk, false);
        aus.m4554a(parcel, 5, this.bKl, false);
        aus.m4554a(parcel, 6, this.bKm, false);
        aus.m4554a(parcel, 7, this.bKn, false);
        aus.m4565c(parcel, 1000, this.ber);
        aus.m4554a(parcel, 8, this.bKo, false);
        aus.m4548a(parcel, 9, this.bKp, i, false);
        aus.m4540G(parcel, A);
    }
}
