package com.fossil;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class asq extends auq {
    public static final Creator<asq> CREATOR = new asp();
    private Bundle Oo;
    private int bfw;
    private int versionCode;

    asq(int i, int i2, Bundle bundle) {
        this.versionCode = i;
        this.bfw = i2;
        this.Oo = bundle;
    }

    public final int getType() {
        return this.bfw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.versionCode);
        aus.m4565c(parcel, 2, this.bfw);
        aus.m4545a(parcel, 3, this.Oo, false);
        aus.m4540G(parcel, A);
    }
}
