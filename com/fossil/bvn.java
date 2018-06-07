package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.places.internal.PlaceEntity;
import java.util.Arrays;

public final class bvn extends auq implements bvb {
    public static final Creator<bvn> CREATOR = new bvo();
    private PlaceEntity bHC;
    private float bHD;

    bvn(PlaceEntity placeEntity, float f) {
        this.bHC = placeEntity;
        this.bHD = f;
    }

    public final float ST() {
        return this.bHD;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bvn)) {
            return false;
        }
        bvn com_fossil_bvn = (bvn) obj;
        return this.bHC.equals(com_fossil_bvn.bHC) && this.bHD == com_fossil_bvn.bHD;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.bHC, Float.valueOf(this.bHD)});
    }

    public final String toString() {
        return avx.bN(this).m4608b("place", this.bHC).m4608b("likelihood", Float.valueOf(this.bHD)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4548a(parcel, 1, this.bHC, i, false);
        aus.m4543a(parcel, 2, this.bHD);
        aus.m4540G(parcel, A);
    }
}
