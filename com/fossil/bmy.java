package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

@Deprecated
public final class bmy extends auq {
    public static final Creator<bmy> CREATOR = new bna();
    private final String bwJ;
    private final String bwK;
    private final List<bmw> bwL;

    bmy(String str, String str2, List<bmw> list) {
        this.bwJ = str;
        this.bwK = str2;
        this.bwL = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bmy)) {
            return false;
        }
        bmy com_fossil_bmy = (bmy) obj;
        return this.bwJ.equals(com_fossil_bmy.bwJ) && this.bwK.equals(com_fossil_bmy.bwK) && this.bwL.equals(com_fossil_bmy.bwL);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.bwJ, this.bwK, this.bwL});
    }

    public final String toString() {
        return avx.bN(this).m4608b("accountName", this.bwJ).m4608b("placeId", this.bwK).m4608b("placeAliases", this.bwL).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 1, this.bwJ, false);
        aus.m4554a(parcel, 2, this.bwK, false);
        aus.m4566c(parcel, 6, this.bwL, false);
        aus.m4540G(parcel, A);
    }
}
