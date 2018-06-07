package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class CommuteTimeSettings$1 implements Creator<CommuteTimeSettings> {
    CommuteTimeSettings$1() {
    }

    public CommuteTimeSettings createFromParcel(Parcel parcel) {
        return new CommuteTimeSettings(parcel, null);
    }

    public CommuteTimeSettings[] newArray(int i) {
        return new CommuteTimeSettings[i];
    }
}
