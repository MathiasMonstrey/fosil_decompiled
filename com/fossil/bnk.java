package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bnk extends auq {
    public static final Creator<bnk> CREATOR = new bnl();
    public String bxC;
    public bsh bxD;
    public long bxE;
    public boolean bxF;
    public String bxG;
    public bnz bxH;
    public long bxI;
    public bnz bxJ;
    public long bxK;
    public bnz bxL;
    public String packageName;
    private int versionCode;

    bnk(int i, String str, String str2, bsh com_fossil_bsh, long j, boolean z, String str3, bnz com_fossil_bnz, long j2, bnz com_fossil_bnz2, long j3, bnz com_fossil_bnz3) {
        this.versionCode = i;
        this.packageName = str;
        this.bxC = str2;
        this.bxD = com_fossil_bsh;
        this.bxE = j;
        this.bxF = z;
        this.bxG = str3;
        this.bxH = com_fossil_bnz;
        this.bxI = j2;
        this.bxJ = com_fossil_bnz2;
        this.bxK = j3;
        this.bxL = com_fossil_bnz3;
    }

    bnk(bnk com_fossil_bnk) {
        this.versionCode = 1;
        awa.bO(com_fossil_bnk);
        this.packageName = com_fossil_bnk.packageName;
        this.bxC = com_fossil_bnk.bxC;
        this.bxD = com_fossil_bnk.bxD;
        this.bxE = com_fossil_bnk.bxE;
        this.bxF = com_fossil_bnk.bxF;
        this.bxG = com_fossil_bnk.bxG;
        this.bxH = com_fossil_bnk.bxH;
        this.bxI = com_fossil_bnk.bxI;
        this.bxJ = com_fossil_bnk.bxJ;
        this.bxK = com_fossil_bnk.bxK;
        this.bxL = com_fossil_bnk.bxL;
    }

    bnk(String str, String str2, bsh com_fossil_bsh, long j, boolean z, String str3, bnz com_fossil_bnz, long j2, bnz com_fossil_bnz2, long j3, bnz com_fossil_bnz3) {
        this.versionCode = 1;
        this.packageName = str;
        this.bxC = str2;
        this.bxD = com_fossil_bsh;
        this.bxE = j;
        this.bxF = z;
        this.bxG = str3;
        this.bxH = com_fossil_bnz;
        this.bxI = j2;
        this.bxJ = com_fossil_bnz2;
        this.bxK = j3;
        this.bxL = com_fossil_bnz3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.versionCode);
        aus.m4554a(parcel, 2, this.packageName, false);
        aus.m4554a(parcel, 3, this.bxC, false);
        aus.m4548a(parcel, 4, this.bxD, i, false);
        aus.m4544a(parcel, 5, this.bxE);
        aus.m4556a(parcel, 6, this.bxF);
        aus.m4554a(parcel, 7, this.bxG, false);
        aus.m4548a(parcel, 8, this.bxH, i, false);
        aus.m4544a(parcel, 9, this.bxI);
        aus.m4548a(parcel, 10, this.bxJ, i, false);
        aus.m4544a(parcel, 11, this.bxK);
        aus.m4548a(parcel, 12, this.bxL, i, false);
        aus.m4540G(parcel, A);
    }
}
