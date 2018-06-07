package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ActivePreset$1 implements Creator<ActivePreset> {
    ActivePreset$1() {
    }

    public ActivePreset createFromParcel(Parcel parcel) {
        return new ActivePreset(parcel);
    }

    public ActivePreset[] newArray(int i) {
        return new ActivePreset[i];
    }
}
