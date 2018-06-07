package com.portfolio.platform.data.model.buddychallenge;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class BCInvitation$1 implements Creator<BCInvitation> {
    BCInvitation$1() {
    }

    public BCInvitation createFromParcel(Parcel parcel) {
        return new BCInvitation(parcel);
    }

    public BCInvitation[] newArray(int i) {
        return new BCInvitation[i];
    }
}
