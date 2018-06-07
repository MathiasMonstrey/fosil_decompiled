package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;

public final class bmb extends auq implements atz {
    public static final Creator<bmb> CREATOR = new bmc();
    private static bmb bwk = new bmb(Status.bgw);
    private final Status mStatus;

    public bmb(Status status) {
        this.mStatus = status;
    }

    public final Status Ka() {
        return this.mStatus;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4548a(parcel, 1, Ka(), i, false);
        aus.m4540G(parcel, A);
    }
}
