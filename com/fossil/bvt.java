package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bvt extends auq {
    public static final Creator<bvt> CREATOR = new bwe();
    private int bHJ;
    private int bHK;

    bvt(int i, int i2) {
        this.bHJ = i;
        this.bHK = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.bHJ);
        aus.m4565c(parcel, 2, this.bHK);
        aus.m4540G(parcel, A);
    }
}
