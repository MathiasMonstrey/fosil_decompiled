package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class buf extends auq {
    public static final Creator<buf> CREATOR = new bug();
    private awb bGl;
    private int ber;

    buf(int i, awb com_fossil_awb) {
        this.ber = i;
        this.bGl = com_fossil_awb;
    }

    public buf(awb com_fossil_awb) {
        this(1, com_fossil_awb);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.ber);
        aus.m4548a(parcel, 2, this.bGl, i, false);
        aus.m4540G(parcel, A);
    }
}
