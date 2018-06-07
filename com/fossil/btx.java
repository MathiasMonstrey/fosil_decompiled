package com.fossil;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;

public final class btx extends auq implements atz {
    public static final Creator<btx> CREATOR = new bty();
    private int bGi;
    private Intent bGj;
    private int ber;

    public btx() {
        this(0, null);
    }

    btx(int i, int i2, Intent intent) {
        this.ber = i;
        this.bGi = i2;
        this.bGj = intent;
    }

    private btx(int i, Intent intent) {
        this(2, 0, null);
    }

    public final Status Ka() {
        return this.bGi == 0 ? Status.bgw : Status.bgA;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.ber);
        aus.m4565c(parcel, 2, this.bGi);
        aus.m4548a(parcel, 3, this.bGj, i, false);
        aus.m4540G(parcel, A);
    }
}
