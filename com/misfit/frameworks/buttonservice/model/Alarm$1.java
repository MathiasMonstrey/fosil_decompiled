package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class Alarm$1 implements Creator<Alarm> {
    Alarm$1() {
    }

    public Alarm createFromParcel(Parcel parcel) {
        return new Alarm(parcel);
    }

    public Alarm[] newArray(int i) {
        return new Alarm[i];
    }
}
