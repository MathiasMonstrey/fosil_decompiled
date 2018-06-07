package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class MicroAppVariant$1 implements Creator<MicroAppVariant> {
    MicroAppVariant$1() {
    }

    public MicroAppVariant createFromParcel(Parcel parcel) {
        return new MicroAppVariant(parcel);
    }

    public MicroAppVariant[] newArray(int i) {
        return new MicroAppVariant[i];
    }
}
