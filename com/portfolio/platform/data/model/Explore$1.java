package com.portfolio.platform.data.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class Explore$1 implements Creator<Explore> {
    Explore$1() {
    }

    public Explore createFromParcel(Parcel parcel) {
        return new Explore(parcel);
    }

    public Explore[] newArray(int i) {
        return new Explore[i];
    }
}
