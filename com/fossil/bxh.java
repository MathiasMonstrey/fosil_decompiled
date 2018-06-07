package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class bxh extends auq {
    public static final Creator<bxh> CREATOR = new bxi();
    private int bIf;
    private int bIg;
    private long bIh;
    private long bIi;

    bxh(int i, int i2, long j, long j2) {
        this.bIf = i;
        this.bIg = i2;
        this.bIh = j;
        this.bIi = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bxh com_fossil_bxh = (bxh) obj;
        return this.bIf == com_fossil_bxh.bIf && this.bIg == com_fossil_bxh.bIg && this.bIh == com_fossil_bxh.bIh && this.bIi == com_fossil_bxh.bIi;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.bIg), Integer.valueOf(this.bIf), Long.valueOf(this.bIi), Long.valueOf(this.bIh)});
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NetworkLocationStatus:");
        stringBuilder.append(" Wifi status: ").append(this.bIf).append(" Cell status: ").append(this.bIg).append(" elapsed time NS: ").append(this.bIi).append(" system time ms: ").append(this.bIh);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.bIf);
        aus.m4565c(parcel, 2, this.bIg);
        aus.m4544a(parcel, 3, this.bIh);
        aus.m4544a(parcel, 4, this.bIi);
        aus.m4540G(parcel, A);
    }
}
