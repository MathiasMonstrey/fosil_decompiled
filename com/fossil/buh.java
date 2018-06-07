package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class buh extends auq {
    public static final Creator<buh> CREATOR = new bui();
    private final awd bGm;
    private int ber;
    private final atn bhQ;

    public buh(int i) {
        this(new atn(8, null), null);
    }

    buh(int i, atn com_fossil_atn, awd com_fossil_awd) {
        this.ber = i;
        this.bhQ = com_fossil_atn;
        this.bGm = com_fossil_awd;
    }

    private buh(atn com_fossil_atn, awd com_fossil_awd) {
        this(1, com_fossil_atn, null);
    }

    public final atn Ld() {
        return this.bhQ;
    }

    public final awd SG() {
        return this.bGm;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.ber);
        aus.m4548a(parcel, 2, this.bhQ, i, false);
        aus.m4548a(parcel, 3, this.bGm, i, false);
        aus.m4540G(parcel, A);
    }
}
