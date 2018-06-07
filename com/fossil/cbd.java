package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class cbd extends auq implements caq {
    public static final Creator<cbd> CREATOR = new cbe();
    private final String bKR;
    private final String bKS;
    private final String bKT;

    public cbd(String str, String str2, String str3) {
        this.bKR = (String) awa.bO(str);
        this.bKS = (String) awa.bO(str2);
        this.bKT = (String) awa.bO(str3);
    }

    public final String TX() {
        return this.bKS;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cbd)) {
            return false;
        }
        cbd com_fossil_cbd = (cbd) obj;
        return this.bKR.equals(com_fossil_cbd.bKR) && avx.equal(com_fossil_cbd.bKS, this.bKS) && avx.equal(com_fossil_cbd.bKT, this.bKT);
    }

    public final String getPath() {
        return this.bKT;
    }

    public final int hashCode() {
        return this.bKR.hashCode();
    }

    public final String toString() {
        String str = this.bKR;
        String str2 = this.bKS;
        String str3 = this.bKT;
        return new StringBuilder(((String.valueOf(str).length() + 43) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append("ChannelImpl{, token='").append(str).append("', nodeId='").append(str2).append("', path='").append(str3).append("'}").toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 2, this.bKR, false);
        aus.m4554a(parcel, 3, TX(), false);
        aus.m4554a(parcel, 4, getPath(), false);
        aus.m4540G(parcel, A);
    }
}
