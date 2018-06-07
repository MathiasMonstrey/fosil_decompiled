package com.portfolio.platform.data.model.buddychallenge;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class BCNotifications$1 implements Creator<BCNotifications> {
    BCNotifications$1() {
    }

    public BCNotifications createFromParcel(Parcel parcel) {
        return new BCNotifications(parcel);
    }

    public BCNotifications[] newArray(int i) {
        return new BCNotifications[i];
    }
}
