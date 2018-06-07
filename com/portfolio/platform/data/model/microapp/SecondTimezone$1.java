package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class SecondTimezone$1 implements Creator<SecondTimezone> {
    SecondTimezone$1() {
    }

    public SecondTimezone createFromParcel(Parcel parcel) {
        return new SecondTimezone(parcel);
    }

    public SecondTimezone[] newArray(int i) {
        return new SecondTimezone[i];
    }
}
