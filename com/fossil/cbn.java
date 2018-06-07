package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class cbn extends auq implements caw {
    public static final Creator<cbn> CREATOR = new cbo();
    private final String bKT;
    private final byte[] bKW;
    private final int bKY;
    private final String bKZ;

    public cbn(int i, String str, byte[] bArr, String str2) {
        this.bKY = i;
        this.bKT = str;
        this.bKW = bArr;
        this.bKZ = str2;
    }

    public final String TY() {
        return this.bKZ;
    }

    public final byte[] getData() {
        return this.bKW;
    }

    public final String getPath() {
        return this.bKT;
    }

    public final int getRequestId() {
        return this.bKY;
    }

    public final String toString() {
        int i = this.bKY;
        String str = this.bKT;
        String valueOf = String.valueOf(this.bKW == null ? "null" : Integer.valueOf(this.bKW.length));
        return new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(valueOf).length()).append("MessageEventParcelable[").append(i).append(",").append(str).append(", size=").append(valueOf).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 2, getRequestId());
        aus.m4554a(parcel, 3, getPath(), false);
        aus.m4557a(parcel, 4, getData(), false);
        aus.m4554a(parcel, 5, TY(), false);
        aus.m4540G(parcel, A);
    }
}
