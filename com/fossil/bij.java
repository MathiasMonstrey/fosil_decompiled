package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bij extends auq {
    public static final Creator<bij> CREATOR = new bil();
    final String boy;
    final int bvs;
    private int versionCode;

    bij(int i, String str, int i2) {
        this.versionCode = i;
        this.boy = str;
        this.bvs = i2;
    }

    bij(String str, int i) {
        this.versionCode = 1;
        this.boy = str;
        this.bvs = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.versionCode);
        aus.m4554a(parcel, 2, this.boy, false);
        aus.m4565c(parcel, 3, this.bvs);
        aus.m4540G(parcel, A);
    }
}
