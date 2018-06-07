package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class awd extends auq {
    public static final Creator<awd> CREATOR = new awe();
    private int ber;
    private IBinder bhP;
    private atn bhQ;
    private boolean bhR;
    private boolean bhS;

    awd(int i, IBinder iBinder, atn com_fossil_atn, boolean z, boolean z2) {
        this.ber = i;
        this.bhP = iBinder;
        this.bhQ = com_fossil_atn;
        this.bhR = z;
        this.bhS = z2;
    }

    public final avg Lc() {
        IBinder iBinder = this.bhP;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        return queryLocalInterface instanceof avg ? (avg) queryLocalInterface : new avi(iBinder);
    }

    public final atn Ld() {
        return this.bhQ;
    }

    public final boolean Le() {
        return this.bhR;
    }

    public final boolean Lf() {
        return this.bhS;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof awd)) {
            return false;
        }
        awd com_fossil_awd = (awd) obj;
        return this.bhQ.equals(com_fossil_awd.bhQ) && Lc().equals(com_fossil_awd.Lc());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.ber);
        aus.m4546a(parcel, 2, this.bhP, false);
        aus.m4548a(parcel, 3, this.bhQ, i, false);
        aus.m4556a(parcel, 4, this.bhR);
        aus.m4556a(parcel, 5, this.bhS);
        aus.m4540G(parcel, A);
    }
}
