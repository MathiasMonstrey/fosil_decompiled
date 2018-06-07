package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Collections;
import java.util.List;

public final class bvu extends auq {
    public static final Creator<bvu> CREATOR = new bwf();
    private int bHL;
    private int bHM;
    private int bHN;
    private int bHO;
    private int bHP;
    private int bHQ;
    private List<bvt> bHR;

    bvu(int i, int i2, int i3, int i4, int i5, int i6, List<bvt> list) {
        this.bHL = i;
        this.bHM = i2;
        this.bHN = i3;
        this.bHO = i4;
        this.bHP = i5;
        this.bHQ = i6;
        this.bHR = Collections.unmodifiableList(list);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.bHL);
        aus.m4565c(parcel, 2, this.bHM);
        aus.m4565c(parcel, 3, this.bHN);
        aus.m4565c(parcel, 4, this.bHO);
        aus.m4565c(parcel, 5, this.bHP);
        aus.m4565c(parcel, 6, this.bHQ);
        aus.m4566c(parcel, 7, this.bHR, false);
        aus.m4540G(parcel, A);
    }
}
