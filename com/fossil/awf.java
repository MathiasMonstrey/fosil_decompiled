package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;

public final class awf extends auq {
    public static final Creator<awf> CREATOR = new awg();
    private int ber;
    private final int bhT;
    private final int bhU;
    @Deprecated
    private final Scope[] bhV;

    awf(int i, int i2, int i3, Scope[] scopeArr) {
        this.ber = i;
        this.bhT = i2;
        this.bhU = i3;
        this.bhV = scopeArr;
    }

    public awf(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.ber);
        aus.m4565c(parcel, 2, this.bhT);
        aus.m4565c(parcel, 3, this.bhU);
        aus.m4560a(parcel, 4, this.bhV, i, false);
        aus.m4540G(parcel, A);
    }
}
