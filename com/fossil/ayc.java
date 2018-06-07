package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ayc extends auq {
    public static final Creator<ayc> CREATOR = new ayd();
    private String name;
    private int version;

    public ayc(String str, int i) {
        this.name = str;
        this.version = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 1, this.name, false);
        aus.m4565c(parcel, 2, this.version);
        aus.m4540G(parcel, A);
    }
}
