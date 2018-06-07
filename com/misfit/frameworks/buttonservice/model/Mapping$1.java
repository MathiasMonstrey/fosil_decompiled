package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class Mapping$1 implements Creator<Mapping> {
    Mapping$1() {
    }

    public Mapping createFromParcel(Parcel parcel) {
        return new Mapping(parcel);
    }

    public Mapping[] newArray(int i) {
        return new Mapping[i];
    }
}
