package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

@Deprecated
public final class bmw extends auq {
    public static final Creator<bmw> CREATOR = new bmx();
    private static bmw bwG = new bmw("Home");
    private static bmw bwH = new bmw("Work");
    private final String bwI;

    bmw(String str) {
        this.bwI = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bmw)) {
            return false;
        }
        return avx.equal(this.bwI, ((bmw) obj).bwI);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.bwI});
    }

    public final String toString() {
        return avx.bN(this).m4608b("alias", this.bwI).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 1, this.bwI, false);
        aus.m4540G(parcel, A);
    }
}
