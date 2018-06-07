package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class cbs extends auq {
    public static final Creator<cbs> CREATOR = new cbt();
    private byte bLf;
    private final byte bLg;
    private final String mValue;

    public cbs(byte b, byte b2, String str) {
        this.bLf = b;
        this.bLg = b2;
        this.mValue = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        cbs com_fossil_cbs = (cbs) obj;
        return this.bLf != com_fossil_cbs.bLf ? false : this.bLg != com_fossil_cbs.bLg ? false : this.mValue.equals(com_fossil_cbs.mValue);
    }

    public final int hashCode() {
        return ((((this.bLf + 31) * 31) + this.bLg) * 31) + this.mValue.hashCode();
    }

    public final String toString() {
        byte b = this.bLf;
        byte b2 = this.bLg;
        String str = this.mValue;
        return new StringBuilder(String.valueOf(str).length() + 73).append("AmsEntityUpdateParcelable{, mEntityId=").append(b).append(", mAttributeId=").append(b2).append(", mValue='").append(str).append("'}").toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4541a(parcel, 2, this.bLf);
        aus.m4541a(parcel, 3, this.bLg);
        aus.m4554a(parcel, 4, this.mValue, false);
        aus.m4540G(parcel, A);
    }
}
