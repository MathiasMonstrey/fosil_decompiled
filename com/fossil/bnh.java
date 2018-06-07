package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class bnh extends auq {
    public static final Creator<bnh> CREATOR = new bni();
    public final String bpS;
    public final long bxA;
    public final int bxB;
    public final String bxq;
    public final String bxr;
    public final long bxs;
    public final long bxt;
    public final String bxu;
    public final boolean bxv;
    public final boolean bxw;
    public final long bxx;
    public final String bxy;
    public final long bxz;
    public final String packageName;

    bnh(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i) {
        awa.df(str);
        this.packageName = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        }
        this.bxq = str2;
        this.bpS = str3;
        this.bxx = j;
        this.bxr = str4;
        this.bxs = j2;
        this.bxt = j3;
        this.bxu = str5;
        this.bxv = z;
        this.bxw = z2;
        this.bxy = str6;
        this.bxz = j4;
        this.bxA = j5;
        this.bxB = i;
    }

    bnh(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i) {
        this.packageName = str;
        this.bxq = str2;
        this.bpS = str3;
        this.bxx = j3;
        this.bxr = str4;
        this.bxs = j;
        this.bxt = j2;
        this.bxu = str5;
        this.bxv = z;
        this.bxw = z2;
        this.bxy = str6;
        this.bxz = j4;
        this.bxA = j5;
        this.bxB = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 2, this.packageName, false);
        aus.m4554a(parcel, 3, this.bxq, false);
        aus.m4554a(parcel, 4, this.bpS, false);
        aus.m4554a(parcel, 5, this.bxr, false);
        aus.m4544a(parcel, 6, this.bxs);
        aus.m4544a(parcel, 7, this.bxt);
        aus.m4554a(parcel, 8, this.bxu, false);
        aus.m4556a(parcel, 9, this.bxv);
        aus.m4556a(parcel, 10, this.bxw);
        aus.m4544a(parcel, 11, this.bxx);
        aus.m4554a(parcel, 12, this.bxy, false);
        aus.m4544a(parcel, 13, this.bxz);
        aus.m4544a(parcel, 14, this.bxA);
        aus.m4565c(parcel, 15, this.bxB);
        aus.m4540G(parcel, A);
    }
}
