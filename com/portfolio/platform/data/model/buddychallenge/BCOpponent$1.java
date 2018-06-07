package com.portfolio.platform.data.model.buddychallenge;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class BCOpponent$1 implements Creator<BCOpponent> {
    BCOpponent$1() {
    }

    public BCOpponent createFromParcel(Parcel parcel) {
        return new BCOpponent(parcel);
    }

    public BCOpponent[] newArray(int i) {
        return new BCOpponent[i];
    }
}
