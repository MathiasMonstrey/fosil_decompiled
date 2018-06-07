package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class MicroApp$1 implements Creator<MicroApp> {
    MicroApp$1() {
    }

    public MicroApp createFromParcel(Parcel parcel) {
        return new MicroApp(parcel);
    }

    public MicroApp[] newArray(int i) {
        return new MicroApp[i];
    }
}
