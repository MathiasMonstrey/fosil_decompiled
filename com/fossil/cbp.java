package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class cbp extends auq implements cax {
    public static final Creator<cbp> CREATOR = new cbq();
    private final int bLa;
    private final boolean bLb;
    private final String beB;
    private final String beE;

    public cbp(String str, String str2, int i, boolean z) {
        this.beB = str;
        this.beE = str2;
        this.bLa = i;
        this.bLb = z;
    }

    public final boolean TZ() {
        return this.bLb;
    }

    public final boolean equals(Object obj) {
        return !(obj instanceof cbp) ? false : ((cbp) obj).beB.equals(this.beB);
    }

    public final String getDisplayName() {
        return this.beE;
    }

    public final String getId() {
        return this.beB;
    }

    public final int hashCode() {
        return this.beB.hashCode();
    }

    public final String toString() {
        String str = this.beE;
        String str2 = this.beB;
        int i = this.bLa;
        return new StringBuilder((String.valueOf(str).length() + 45) + String.valueOf(str2).length()).append("Node{").append(str).append(", id=").append(str2).append(", hops=").append(i).append(", isNearby=").append(this.bLb).append("}").toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 2, getId(), false);
        aus.m4554a(parcel, 3, getDisplayName(), false);
        aus.m4565c(parcel, 4, this.bLa);
        aus.m4556a(parcel, 5, TZ());
        aus.m4540G(parcel, A);
    }
}
