package com.portfolio.platform.data.model.buddychallenge;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class BCChallenge$1 implements Creator<BCChallenge> {
    BCChallenge$1() {
    }

    public BCChallenge createFromParcel(Parcel parcel) {
        return new BCChallenge(parcel);
    }

    public BCChallenge[] newArray(int i) {
        return new BCChallenge[i];
    }
}
