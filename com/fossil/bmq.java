package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public final class bmq extends auq {
    public static final Creator<bmq> CREATOR = new bmr();
    static final List<blu> bwt = Collections.emptyList();
    private boolean bwA = true;
    private LocationRequest bwu;
    private List<blu> bwv;
    private boolean bww;
    private boolean bwx;
    private boolean bwy;
    private String bwz;
    private String mTag;

    bmq(LocationRequest locationRequest, List<blu> list, String str, boolean z, boolean z2, boolean z3, String str2) {
        this.bwu = locationRequest;
        this.bwv = list;
        this.mTag = str;
        this.bww = z;
        this.bwx = z2;
        this.bwy = z3;
        this.bwz = str2;
    }

    @Deprecated
    public static bmq m5304a(LocationRequest locationRequest) {
        return new bmq(locationRequest, bwt, null, false, false, false, null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bmq)) {
            return false;
        }
        bmq com_fossil_bmq = (bmq) obj;
        return avx.equal(this.bwu, com_fossil_bmq.bwu) && avx.equal(this.bwv, com_fossil_bmq.bwv) && avx.equal(this.mTag, com_fossil_bmq.mTag) && this.bww == com_fossil_bmq.bww && this.bwx == com_fossil_bmq.bwx && this.bwy == com_fossil_bmq.bwy && avx.equal(this.bwz, com_fossil_bmq.bwz);
    }

    public final int hashCode() {
        return this.bwu.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.bwu.toString());
        if (this.mTag != null) {
            stringBuilder.append(" tag=").append(this.mTag);
        }
        if (this.bwz != null) {
            stringBuilder.append(" moduleId=").append(this.bwz);
        }
        stringBuilder.append(" hideAppOps=").append(this.bww);
        stringBuilder.append(" clients=").append(this.bwv);
        stringBuilder.append(" forceCoarseLocation=").append(this.bwx);
        if (this.bwy) {
            stringBuilder.append(" exemptFromBackgroundThrottle");
        }
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4548a(parcel, 1, this.bwu, i, false);
        aus.m4566c(parcel, 5, this.bwv, false);
        aus.m4554a(parcel, 6, this.mTag, false);
        aus.m4556a(parcel, 7, this.bww);
        aus.m4556a(parcel, 8, this.bwx);
        aus.m4556a(parcel, 9, this.bwy);
        aus.m4554a(parcel, 10, this.bwz, false);
        aus.m4540G(parcel, A);
    }
}
