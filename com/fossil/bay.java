package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bay extends auq {
    public static final Creator<bay> CREATOR = new bav();
    private final int ber;
    private final bkx boK;

    bay(int i, IBinder iBinder) {
        this.ber = i;
        this.boK = bky.m5260l(iBinder);
    }

    public bay(bkx com_fossil_bkx) {
        this.ber = 2;
        this.boK = com_fossil_bkx;
    }

    public final String toString() {
        return String.format("DisableFitRequest", new Object[0]);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4546a(parcel, 1, this.boK.asBinder(), false);
        aus.m4565c(parcel, 1000, this.ber);
        aus.m4540G(parcel, A);
    }
}
