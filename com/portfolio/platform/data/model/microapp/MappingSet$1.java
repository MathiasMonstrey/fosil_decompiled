package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class MappingSet$1 implements Creator<MappingSet> {
    MappingSet$1() {
    }

    public MappingSet createFromParcel(Parcel parcel) {
        return new MappingSet(parcel);
    }

    public MappingSet[] newArray(int i) {
        return new MappingSet[i];
    }
}
