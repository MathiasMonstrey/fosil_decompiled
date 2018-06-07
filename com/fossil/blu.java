package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class blu extends auq {
    public static final Creator<blu> CREATOR = new blv();
    private String packageName;
    private int uid;

    public blu(int i, String str) {
        this.uid = i;
        this.packageName = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof blu)) {
            return false;
        }
        blu com_fossil_blu = (blu) obj;
        return com_fossil_blu.uid == this.uid && avx.equal(com_fossil_blu.packageName, this.packageName);
    }

    public final int hashCode() {
        return this.uid;
    }

    public final String toString() {
        return String.format("%d:%s", new Object[]{Integer.valueOf(this.uid), this.packageName});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.uid);
        aus.m4554a(parcel, 2, this.packageName, false);
        aus.m4540G(parcel, A);
    }
}
