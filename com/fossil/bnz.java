package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bnz extends auq {
    public static final Creator<bnz> CREATOR = new boa();
    public final String bxC;
    public final bnw byq;
    public final long byr;
    public final String name;

    bnz(bnz com_fossil_bnz, long j) {
        awa.bO(com_fossil_bnz);
        this.name = com_fossil_bnz.name;
        this.byq = com_fossil_bnz.byq;
        this.bxC = com_fossil_bnz.bxC;
        this.byr = j;
    }

    public bnz(String str, bnw com_fossil_bnw, String str2, long j) {
        this.name = str;
        this.byq = com_fossil_bnw;
        this.bxC = str2;
        this.byr = j;
    }

    public final String toString() {
        String str = this.bxC;
        String str2 = this.name;
        String valueOf = String.valueOf(this.byq);
        return new StringBuilder(((String.valueOf(str).length() + 21) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append("origin=").append(str).append(",name=").append(str2).append(",params=").append(valueOf).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 2, this.name, false);
        aus.m4548a(parcel, 3, this.byq, i, false);
        aus.m4554a(parcel, 4, this.bxC, false);
        aus.m4544a(parcel, 5, this.byr);
        aus.m4540G(parcel, A);
    }
}
