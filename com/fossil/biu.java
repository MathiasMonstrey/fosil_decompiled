package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class biu extends auq {
    public static final Creator<biu> CREATOR = new bir();
    final bin<?, ?> bvH;
    final String key;
    private int versionCode;

    biu(int i, String str, bin<?, ?> com_fossil_bin___) {
        this.versionCode = i;
        this.key = str;
        this.bvH = com_fossil_bin___;
    }

    biu(String str, bin<?, ?> com_fossil_bin___) {
        this.versionCode = 1;
        this.key = str;
        this.bvH = com_fossil_bin___;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.versionCode);
        aus.m4554a(parcel, 2, this.key, false);
        aus.m4548a(parcel, 3, this.bvH, i, false);
        aus.m4540G(parcel, A);
    }
}
